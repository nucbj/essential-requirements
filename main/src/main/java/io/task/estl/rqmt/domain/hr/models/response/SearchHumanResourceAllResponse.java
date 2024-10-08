package io.task.estl.rqmt.domain.hr.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchHumanResourceAllResponse {
  private Long id;
  private String name;
  private Long viewCount;
  private String regDt;
}
