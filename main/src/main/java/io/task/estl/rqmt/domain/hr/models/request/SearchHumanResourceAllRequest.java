package io.task.estl.rqmt.domain.hr.models.request;

import lombok.Data;

@Data
public class SearchHumanResourceAllRequest {
  private int page;
  private int size;
  private String specify;
  private Integer sort;
}
