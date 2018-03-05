# Dump of table blog_comment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `blog_comment`;

CREATE TABLE `blog_comment` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '回复的评论ID',
  `content_id` varchar(32) DEFAULT NULL COMMENT '评论的内容ID',
  `content_module` varchar(32) DEFAULT NULL COMMENT '评论的内容模型',
  `comment_count` int(11) unsigned DEFAULT '0' COMMENT '评论的回复数量',
  `order_number` int(11) unsigned DEFAULT '0' COMMENT '排序编号，常用语置顶等',
  `user_id` varchar(32) DEFAULT NULL COMMENT '评论的用户ID(后台将评论推送给该系统用户)',
  `ip` varchar(64) DEFAULT NULL COMMENT '评论的IP地址',
  `author` varchar(128) DEFAULT NULL COMMENT '评论的作者',
  `comment_type` varchar(32) DEFAULT 'COMMENT' COMMENT '评论的类型，默认是COMMENT',
  `text` longtext COMMENT '评论的内容',
  `agent` text COMMENT '提交评论的浏览器信息',
  `create_time` datetime DEFAULT NULL COMMENT '评论的时间',
  `slug` varchar(128) DEFAULT NULL COMMENT '评论的slug(伪静态)',
  `email` varchar(64) DEFAULT NULL COMMENT '评论用户的email',
  `comment_status` varchar(32) DEFAULT NULL COMMENT '评论的状态',
  `vote_up` int(11) unsigned DEFAULT '0' COMMENT '“顶”的数量',
  `vote_down` int(11) unsigned DEFAULT '0' COMMENT '“踩”的数量',
  `flag` varchar(256) DEFAULT NULL COMMENT '标识',
  `lat` decimal(20,16) DEFAULT NULL COMMENT '纬度',
  `lng` decimal(20,16) DEFAULT NULL COMMENT '经度',
  PRIMARY KEY (`id`),
  UNIQUE KEY `slug` (`slug`),
  KEY `content_id` (`content_id`),
  KEY `user_id` (`user_id`),
  KEY `email` (`email`),
  KEY `create_time` (`create_time`),
  KEY `parent_id` (`parent_id`),
  KEY `content_module` (`content_module`),
  KEY `comment_count` (`comment_count`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表，用于保存content内容的回复、分享、推荐等信息。';

DROP TABLE IF EXISTS `blog_resource`;

CREATE TABLE `blog_resource` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `list` int(11) NOT NULL COMMENT '菜单排序',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '对应上级菜单id',
  `menu_type` varchar(10) NOT NULL COMMENT '菜单类型',
  `name` varchar(200) NOT NULL COMMENT '资源名称',
  `request_method` varchar(10) DEFAULT NULL COMMENT '资源请求方式',
  `url` varchar(300) DEFAULT NULL COMMENT '链接',
  `logo_style` varchar(128) DEFAULT NULL COMMENT 'logo样式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '菜单资源表';

DROP TABLE IF EXISTS `blog_role`;

CREATE TABLE `blog_role` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `info` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `list` int(11) NOT NULL COMMENT '排序',
  `name` varchar(30) NOT NULL COMMENT '角色名称',
  `system` int(1) NOT NULL COMMENT '是否系统自带',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色表';

DROP TABLE IF EXISTS `blog_role_resource`;

CREATE TABLE `blog_role_resource` (
  `id` varchar(32) NOT NULL,
  `resource_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `resource_id` (`resource_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `resource_id` FOREIGN KEY (`resource_id`) REFERENCES `blog_resource` (`id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `blog_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `blog_user`;

CREATE TABLE `blog_user` (
`id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称' ,
`male`  tinyint(1) NULL DEFAULT NULL COMMENT '性别' ,
`email`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱' ,
`login_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号' ,
`pass_wd`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码' ,
`status`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号状态' ,
`role_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id' ,
`profile_picture` blob NULL DEFAULT NULL COMMENT '头像',
PRIMARY KEY (`id`),
UNIQUE INDEX `email` (`email`) USING BTREE ,
UNIQUE INDEX `loginName` (`login_name`) USING BTREE,
CONSTRAINT `roleId` FOREIGN KEY (`role_id`) REFERENCES `blog_role` (`id`)
)
ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci COMMENT='用户表，用于保存用户信息。';