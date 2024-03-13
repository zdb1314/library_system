
-- ----------------------------
--  Table structure for `book`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `book`(
   `id`           int(11) NOT NULL primary key AUTO_INCREMENT,
   `title`        varchar(50) NOT NULL,
   `author`   varchar(50)  NOT NULL,
   `remark`   varchar(256)
);
