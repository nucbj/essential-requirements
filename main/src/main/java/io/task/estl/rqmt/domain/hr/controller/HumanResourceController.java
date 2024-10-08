package io.task.estl.rqmt.domain.hr.controller;

import io.task.estl.rqmt.corekit.entities.Users;
import io.task.estl.rqmt.corekit.repositories.UsersRepository;
import io.task.estl.rqmt.domain.hr.models.request.SearchHumanResourceAllRequest;
import io.task.estl.rqmt.domain.hr.models.response.SearchHumanResourceAllResponse;
import io.task.estl.rqmt.event.hr.HrEvents;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/hr")
@RequiredArgsConstructor
public class HumanResourceController {

  public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private final ApplicationEventPublisher eventPublisher;

  private final UsersRepository usersRepository;

  @GetMapping("{resourceId}")
  public SearchHumanResourceAllResponse findHumanResource(
    @PathVariable Long resourceId
  ) throws Exception {
    Optional<Users> entity = Optional.of(usersRepository.findById(resourceId)).orElse(null);
    publishEventsDetailView(resourceId);
    if (Objects.isNull(entity)) {
      throw new BadRequestException("Non-existent resource");
    } else {
      return convertToDto(entity.get());
    }
  }

  @Cacheable(value = "hr", key = "#root.methodName")
  @GetMapping("/all")
  public Page<SearchHumanResourceAllResponse> findHumanResources(
    @ModelAttribute SearchHumanResourceAllRequest searchDto
  ) {
    Integer sort = Optional.of(searchDto.getSort()).orElse(1);
    String sortField = Optional.of(searchDto.getSpecify()).orElse("name");
    Sort sorting = Sort.by(sortField).ascending();
    if (sort == 0) {
      sorting = sorting.descending();
    }

    Pageable pageable = PageRequest.of(searchDto.getPage(), searchDto.getSize(), sorting);
    Page<Users> result = usersRepository.findAll(pageable);

    return result.map(this::convertToDto);

  }

  private SearchHumanResourceAllResponse convertToDto(Users entity) {
    return SearchHumanResourceAllResponse.builder()
      .id(entity.getId())
      .name(entity.getName())
      .viewCount(entity.getViewCount())
      .regDt(sdf.format(entity.getRegDt()))
      .build();
  }

  private void publishEventsDetailView(Long resourceId) {
    eventPublisher.publishEvent(new HrEvents(this, resourceId));
  }
}
