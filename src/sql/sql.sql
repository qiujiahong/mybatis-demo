CREATE TABLE `Blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) DEFAULT '' COMMENT '名字',
  `url` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COMMENT='博客';