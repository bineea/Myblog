# Dump of table blog_comment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `blog_comment`;

CREATE TABLE `blog_comment` (
  `id` varchar(32) NOT NULL COMMENT '����ID',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '�ظ�������ID',
  `content_id` varchar(32) DEFAULT NULL COMMENT '���۵�����ID',
  `content_module` varchar(32) DEFAULT NULL COMMENT '���۵�����ģ��',
  `comment_count` int(11) unsigned DEFAULT '0' COMMENT '���۵Ļظ�����',
  `order_number` int(11) unsigned DEFAULT '0' COMMENT '�����ţ��������ö���',
  `user_id` varchar(32) DEFAULT NULL COMMENT '���۵��û�ID(��̨���������͸���ϵͳ�û�)',
  `ip` varchar(64) DEFAULT NULL COMMENT '���۵�IP��ַ',
  `author` varchar(128) DEFAULT NULL COMMENT '���۵�����',
  `comment_type` varchar(32) DEFAULT 'comment' COMMENT '���۵����ͣ�Ĭ����comment',
  `text` longtext COMMENT '���۵�����',
  `agent` text COMMENT '�ύ���۵��������Ϣ',
  `create_time` datetime DEFAULT NULL COMMENT '���۵�ʱ��',
  `slug` varchar(128) DEFAULT NULL COMMENT '���۵�slug(α��̬)',
  `email` varchar(64) DEFAULT NULL COMMENT '�����û���email',
  `comment_status` varchar(32) DEFAULT NULL COMMENT '���۵�״̬',
  `vote_up` int(11) unsigned DEFAULT '0' COMMENT '������������',
  `vote_down` int(11) unsigned DEFAULT '0' COMMENT '���ȡ�������',
  `flag` varchar(256) DEFAULT NULL COMMENT '��ʶ',
  `lat` decimal(20,16) DEFAULT NULL COMMENT 'γ��',
  `lng` decimal(20,16) DEFAULT NULL COMMENT '����',
  PRIMARY KEY (`id`),
  UNIQUE KEY `slug` (`slug`),
  KEY `content_id` (`content_id`),
  KEY `user_id` (`user_id`),
  KEY `email` (`email`),
  KEY `create_time` (`create_time`),
  KEY `parent_id` (`parent_id`),
  KEY `content_module` (`content_module`),
  KEY `comment_count` (`comment_count`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���۱����ڱ���content���ݵĻظ��������Ƽ�����Ϣ��';