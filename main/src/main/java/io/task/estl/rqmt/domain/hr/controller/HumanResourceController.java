package io.task.estl.rqmt.domain.hr.controller;

import io.task.estl.rqmt.domain.hr.models.request.SearchHumanResourceAllRequest;
import io.task.estl.rqmt.domain.hr.models.response.SearchHumanResourceAllResponse;
import io.task.estl.rqmt.domain.hr.services.HumanResourceService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hr")
@RequiredArgsConstructor
public class HumanResourceController {

  private final HumanResourceService humanResourceService;

  @GetMapping("{resourceId}")
  public SearchHumanResourceAllResponse findHumanResource(
    @PathVariable Long resourceId
  ) throws BadRequestException {
    return humanResourceService.findHumanResource(resourceId);
  }

  @Cacheable(value = "hr", key = "#root.methodName")
  @GetMapping("/all")
  public Page<SearchHumanResourceAllResponse> findHumanResources(
    @ModelAttribute SearchHumanResourceAllRequest searchDto
  ) {
    return humanResourceService.findHumanResources(searchDto);
  }
}
