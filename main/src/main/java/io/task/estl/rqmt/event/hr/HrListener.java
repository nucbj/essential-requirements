package io.task.estl.rqmt.event.hr;

import io.task.estl.rqmt.corekit.entities.Users;
import io.task.estl.rqmt.corekit.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HrListener {

  private final UsersRepository usersRepository;

  @Async
  @EventListener
  public void handleViewCountEvent(HrEvents event) {
    Optional<Users> user = usersRepository.findById(event.getResourceId());
    if (user.isPresent()) {
      Users entity = user.get();
      entity.setViewCount(entity.getViewCount() + 1);  // view_count 증가
      usersRepository.save(entity);  // 변경사항 저장
    }
  }
}
