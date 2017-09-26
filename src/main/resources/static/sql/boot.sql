/*
Navicat MySQL Data Transfer

Source Server         : 123.206.129.162
Source Server Version : 50717
Source Host           : 123.206.129.162:3306
Source Database       : boot

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-26 15:50:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` varchar(255) NOT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `parent_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1505377991704', null, '测试部门', '0', '1', '一级部门');
INSERT INTO `sys_dept` VALUES ('1505543395303', null, '测试部门2', '0', '1505377991704', '测试部门');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` varchar(255) NOT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `parent_name` varchar(255) DEFAULT NULL,
  `perms` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1505357921200', '0', 'user', '用户管理', '0', '0', '一级菜单', 'admin:user:view', '1', '/user/user');
INSERT INTO `sys_menu` VALUES ('1505358775626', null, 'list layout', '菜单管理', '2', '0', '一级菜单', 'admin:menu:view', '1', '/menu/menu');
INSERT INTO `sys_menu` VALUES ('1505359347214', '0', '0', '添加菜单', '0', '1505358775626', '菜单管理', 'admin:menu:add', '2', '/menu/add-menu');
INSERT INTO `sys_menu` VALUES ('1505367916901', '0', '', '删除菜单', '0', '1505358775626', '菜单管理', 'admin:menu:delete', '2', '/menu/delete/');
INSERT INTO `sys_menu` VALUES ('1505368312688', '0', '', '修改菜单', '0', '1505358775626', '菜单管理', 'admin:menu:edit', '2', '/menu/edit/');
INSERT INTO `sys_menu` VALUES ('1505370854118', '0', '', '添加用户', '0', '1505357921200', '用户管理', 'admin:user:add', '2', '/menu/add-user');
INSERT INTO `sys_menu` VALUES ('1505371378596', '0', '', '角色管理', '0', '0', '一级菜单', 'admin:role:view', '1', '/role/role');
INSERT INTO `sys_menu` VALUES ('1505373308958', '0', '', '部门管理', '0', '0', '一级菜单', 'admin:dept:view', '1', '/dept/dept');
INSERT INTO `sys_menu` VALUES ('1505374984860', '0', '', '添加部门', '0', '1505373308958', '部门管理', 'admin:dept:add', '2', '/dept/add-dept');
INSERT INTO `sys_menu` VALUES ('1505546299087', '0', '', '添加角色', '0', '1505371378596', '角色管理', 'admin:role:add', '2', '/role/add-role');
INSERT INTO `sys_menu` VALUES ('1505702633786', '0', '', '修改部门', '0', '1505373308958', '部门管理', 'admin:dept:edit', '2', '/dept/edit-dept');
INSERT INTO `sys_menu` VALUES ('1505703113874', '0', '', '删除部门', '0', '1505373308958', '部门管理', 'admin:dept:delete', '2', '/dept/delete');
INSERT INTO `sys_menu` VALUES ('1505703188308', '0', '', '修改角色', '1', '1505371378596', '角色管理', 'admin:role:edit', '2', '/role/edit');
INSERT INTO `sys_menu` VALUES ('1505703238395', '0', '', '删除角色', '1', '1505371378596', '角色管理', 'admin:role:delete', '2', '/role/delete');
INSERT INTO `sys_menu` VALUES ('1506408884417', '0', '', '修改用户', '0', '1505357921200', '用户管理', 'admin:user:edit', '2', '/user/edit-user');
INSERT INTO `sys_menu` VALUES ('1506408963810', '0', '', '删除用户', '0', '1505357921200', '用户管理', 'admin:user:delete', '2', '/user/delete');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `dept_id` varchar(255) NOT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1506406011337', '2017-09-26 14:06:51', null, '1505543395303', '测试部门2', '', 'admin');

-- ----------------------------
-- Table structure for `sys_role_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `id` varchar(255) NOT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `dept_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('1506406012645', null, '1505377991704', '1506406011337');
INSERT INTO `sys_role_dept` VALUES ('1506406012670', null, '1505543395303', '1506406011337');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(255) NOT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `menu_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1506406011338', null, '1505357921200', '1506406011337');
INSERT INTO `sys_role_menu` VALUES ('1506406011397', null, '1505370854118', '1506406011337');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_user_id` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `dept_id` varchar(255) DEFAULT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, null, null, '1505377991704', null, '549595297@qq.com', null, 'b954990a308d50ce8b844602ab3c40dc0c03f32b85b3f441abb8946912894909', null, 'ITBC');
INSERT INTO `sys_user` VALUES ('1506406096649', '2017-09-26 15:44:38', '1506406096649', null, '1505543395303', '测试部门2', 'admin@qq.com', '15698253358', 'b954990a308d50ce8b844602ab3c40dc0c03f32b85b3f441abb8946912894909', '0', 'admin');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(255) NOT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1505627342252', '1');
INSERT INTO `sys_user_role` VALUES ('1506411876940', null, '1506406011337', '1506406096649');
