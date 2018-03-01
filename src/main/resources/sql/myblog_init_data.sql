INSERT INTO `myblogdb`.`blog_resource` (`id`, `list`, `menu_id`, `menu_type`, `name`, `request_method`, `url`, `logo_style`) VALUES ('index', '1', NULL, 'COLUMN', '首页', NULL, NULL, 'fa fa-home');
INSERT INTO `myblogdb`.`blog_resource` (`id`, `list`, `menu_id`, `menu_type`, `name`, `request_method`, `url`, `logo_style`) VALUES ('xtgl', '2', NULL, 'COLUMN', '系统管理', NULL, NULL, 'fa fa-gears (alias)');
INSERT INTO `myblogdb`.`blog_resource` (`id`, `list`, `menu_id`, `menu_type`, `name`, `request_method`, `url`, `logo_style`) VALUES ('xtgl_ddgl', '3', 'xtgl', 'COLUMN', '调度管理', NULL, NULL, NULL);
INSERT INTO `myblogdb`.`blog_resource` (`id`, `list`, `menu_id`, `menu_type`, `name`, `request_method`, `url`, `logo_style`) VALUES ('xtgl_ddgl_ddrw', '1', 'xtgl_ddgl', 'MENU', '调度任务', 'GET', NULL, NULL);
INSERT INTO `myblogdb`.`blog_resource` (`id`, `list`, `menu_id`, `menu_type`, `name`, `request_method`, `url`, `logo_style`) VALUES ('xtgl_jsgl', '2', 'xtgl', 'MENU', '角色管理', 'GET', NULL, NULL);
INSERT INTO `myblogdb`.`blog_resource` (`id`, `list`, `menu_id`, `menu_type`, `name`, `request_method`, `url`, `logo_style`) VALUES ('xtgl_yhgl', '1', 'xtgl', 'MENU', '用户管理', 'GET', NULL, NULL);
