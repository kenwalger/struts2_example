CREATE DATABASE IF NOT EXISTS ssei_test
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS ssei_test.entries (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  os          VARCHAR(30),
  osVersion   VARCHAR(30),
  notes       VARCHAR(150),
  created     TIMESTAMP DEFAULT NOW()
);