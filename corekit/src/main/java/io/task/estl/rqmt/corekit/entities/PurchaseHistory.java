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
@Table(name = "purchase_history", schema = "", catalog = "mydatabase")
public class PurchaseHistory {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "total_amount")
  private Long totalAmount;

  @Column(name = "supplied_amount")
  private Long suppliedAmount;

  @Column(name = "vat")
  private Long vat;

  @Column(name = "cancels")
  private Long cancels;

  @Column(name = "reg_dt")
  private Timestamp regDt;

  @Column(name = "mod_dt")
  private Timestamp modDt;

  @Column(name = "provider_order_id")
  private String providerOrderId;

  @Column(name = "provider_receipt")
  private String providerReceipt;

  @Column(name = "provider_info")
  private String providerInfo;

}
