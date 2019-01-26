CREATE TABLE IF NOT EXISTS category
(
  id          INTEGER PRIMARY KEY auto_increment,
  name        VARCHAR(100),
  description VARCHAR(2000),
  age_group   VARCHAR(20),
  created     DATETIME,
  inserted    BIGINT
);
