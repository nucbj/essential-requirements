-- 데이터베이스 스키마 및 테이블 생성
CREATE TABLE IF NOT EXISTS mydatabase.users
(
  id         BIGINT AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(50)                          NOT NULL,
  view_count BIGINT   DEFAULT 0                   NOT NULL,
  reg_dt     DATETIME DEFAULT CURRENT_TIMESTAMP() NOT NULL,
  mod_dt     DATETIME                             NULL
);

CREATE INDEX user_name_index ON mydatabase.users (name);

INSERT INTO mydatabase.users (NAME)
VALUES ('user1'),
       ('user2'),
       ('user3');

CREATE TABLE IF NOT EXISTS purchase_history
(
  id                bigint auto_increment,
  user_id           bigint       not null,
  total_amount      bigint       not null,
  supplied_amount   bigint       not null,
  vat               bigint       not null,
  cancels           boolean      null,
  reg_dt            datetime(3)  null,
  mod_dt            datetime(3)  null,
  provider_order_id varchar(100) not null,
  provider_receipt  varchar(500) not null,
  provider_info     json         null,
  constraint purchase_history_pk
    primary key (id),
  constraint purchase_history_users_id_fk
    foreign key (user_id) references mydatabase.users (id)
)
  comment '구매 이력';

CREATE TABLE IF NOT EXISTS point_history
(
  id      BIGINT auto_increment,
  user_id BIGINT   null,
  specify INT      not null comment '1: PURCHASE, 2: EVENT 3: ADMIN, 4: ETC ...',
  type    INT      not null comment '1: INC, 2: DEC',
  amount  bigint   not null,
  reg_dt  datetime null,
  constraint point_history_pk
    primary key (id),
  constraint point_history_users_id_fk
    foreign key (user_id) references mydatabase.users (id)
);



SELECT *
FROM mydatabase.users
