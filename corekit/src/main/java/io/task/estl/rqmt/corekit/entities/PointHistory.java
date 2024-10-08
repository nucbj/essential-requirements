package io.task.estl.rqmt.corekit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "point_history", schema = "", catalog = "mydatabase")
public class PointHistory {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "specify")
  private Long specify;

  @Column(name = "type")
  private Long type;

  @Column(name = "amount")
  private Long amount;

  @Column(name = "reg_dt")
  private Timestamp regDt;

}
