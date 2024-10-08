package io.task.estl.rqmt.event.hr;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class HrEvents extends ApplicationEvent {
  private final Long resourceId;

  public HrEvents(Object source, Long resourceId) {
    super(source);
    this.resourceId = resourceId;
  }
}
