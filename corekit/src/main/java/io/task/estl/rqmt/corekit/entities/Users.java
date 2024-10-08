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
@Table(name = "users", schema = "", catalog = "mydatabase")
public class Users {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "view_count")
  private Long viewCount;

  @Column(name = "reg_dt")
  private Timestamp regDt;

  @Column(name = "mod_dt")
  private Timestamp modDt;
}
