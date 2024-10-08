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

INSERT INTO users (NAME)
VALUES
('user1'),
('user2'),
('user3');

SELECT * FROM mydatabase.users
