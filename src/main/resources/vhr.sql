/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : vhr

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 03/04/2019 18:10:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iconCls` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keepAlive` tinyint(1) NULL DEFAULT NULL,
  `requireAuth` tinyint(1) NULL DEFAULT NULL,
  `parentId` int(11) NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表（url菜单）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '/', NULL, NULL, '所有', NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (2, '/', '/home', 'Home', '员工资料', 'fa fa-user-circle-o', NULL, 1, 1, 1);
INSERT INTO `sys_permission` VALUES (3, '/', '/home', 'Home', '人事管理', 'fa fa-address-card-o', NULL, 1, 1, 1);
INSERT INTO `sys_permission` VALUES (4, '/', '/home', 'Home', '薪资管理', 'fa fa-money', NULL, 1, 1, 1);
INSERT INTO `sys_permission` VALUES (5, '/', '/home', 'Home', '统计管理', 'fa fa-bar-chart', NULL, 1, 1, 1);
INSERT INTO `sys_permission` VALUES (6, '/', '/home', 'Home', '系统管理', 'fa fa-windows', NULL, 1, 1, 1);
INSERT INTO `sys_permission` VALUES (7, '/employee/basic/**', '/emp/basic', 'EmpBasic', '基本资料', NULL, NULL, 1, 2, 1);
INSERT INTO `sys_permission` VALUES (8, '/employee/advanced/**', '/emp/adv', 'EmpAdv', '高级资料', NULL, NULL, 1, 2, 0);
INSERT INTO `sys_permission` VALUES (9, '/personnel/emp/**', '/per/emp', 'PerEmp', '员工资料', NULL, NULL, 1, 3, 0);
INSERT INTO `sys_permission` VALUES (10, '/personnel/ec/**', '/per/ec', 'PerEc', '员工奖惩', NULL, NULL, 1, 3, 1);
INSERT INTO `sys_permission` VALUES (11, '/personnel/train/**', '/per/train', 'PerTrain', '员工培训', NULL, NULL, 1, 3, 1);
INSERT INTO `sys_permission` VALUES (12, '/personnel/salary/**', '/per/salary', 'PerSalary', '员工调薪', NULL, NULL, 1, 3, 1);
INSERT INTO `sys_permission` VALUES (13, '/personnel/remove/**', '/per/mv', 'PerMv', '员工调动', NULL, NULL, 1, 3, 1);
INSERT INTO `sys_permission` VALUES (14, '/salary/sob/**', '/sal/sob', 'SalSob', '工资账套管理', NULL, NULL, 1, 4, 1);
INSERT INTO `sys_permission` VALUES (15, '/salary/sobcfg/**', '/sal/sobcfg', 'SalSobCfg', '员工账套设置', NULL, NULL, 1, 4, 1);
INSERT INTO `sys_permission` VALUES (16, '/salary/table/**', '/sal/table', 'SalTable', '工资表管理', NULL, NULL, 1, 4, 1);
INSERT INTO `sys_permission` VALUES (17, '/salary/month/**', '/sal/month', 'SalMonth', '月末处理', NULL, NULL, 1, 4, 1);
INSERT INTO `sys_permission` VALUES (18, '/salary/search/**', '/sal/search', 'SalSearch', '工资表查询', NULL, NULL, 1, 4, 1);
INSERT INTO `sys_permission` VALUES (19, '/statistics/all/**', '/sta/all', 'StaAll', '综合信息统计', NULL, NULL, 1, 5, 1);
INSERT INTO `sys_permission` VALUES (20, '/statistics/score/**', '/sta/score', 'StaScore', '员工积分统计', NULL, NULL, 1, 5, 1);
INSERT INTO `sys_permission` VALUES (21, '/statistics/personnel/**', '/sta/pers', 'StaPers', '人事信息统计', NULL, NULL, 1, 5, 1);
INSERT INTO `sys_permission` VALUES (22, '/statistics/recored/**', '/sta/record', 'StaRecord', '人事记录统计', NULL, NULL, 1, 5, 1);
INSERT INTO `sys_permission` VALUES (23, '/system/basic/**', '/sys/basic', 'SysBasic', '基础信息设置', NULL, NULL, 1, 6, 1);
INSERT INTO `sys_permission` VALUES (24, '/system/cfg/**', '/sys/cfg', 'SysCfg', '系统管理', NULL, NULL, 1, 6, 1);
INSERT INTO `sys_permission` VALUES (25, '/system/log/**', '/sys/log', 'SysLog', '操作日志管理', NULL, NULL, 1, 6, 1);
INSERT INTO `sys_permission` VALUES (26, '/system/hr/**', '/sys/hr', 'SysHr', '操作员管理', NULL, NULL, 1, 6, 1);
INSERT INTO `sys_permission` VALUES (27, '/system/data/**', '/sys/data', 'SysData', '备份恢复数据库', NULL, NULL, 1, 6, 1);
INSERT INTO `sys_permission` VALUES (28, '/system/init/**', '/sys/init', 'SysInit', '初始化数据库', NULL, NULL, 1, 6, 1);

-- ----------------------------
-- Table structure for sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_role`;
CREATE TABLE `sys_permission_role`  (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `permission_id` bigint(16) NOT NULL,
  `role_id` bigint(16) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`permission_id`) USING BTREE,
  INDEX `rid`(`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 288 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限-角色关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission_role
-- ----------------------------
INSERT INTO `sys_permission_role` VALUES (162, 7, 6);
INSERT INTO `sys_permission_role` VALUES (163, 9, 6);
INSERT INTO `sys_permission_role` VALUES (164, 10, 6);
INSERT INTO `sys_permission_role` VALUES (165, 11, 6);
INSERT INTO `sys_permission_role` VALUES (166, 12, 6);
INSERT INTO `sys_permission_role` VALUES (167, 13, 6);
INSERT INTO `sys_permission_role` VALUES (168, 14, 6);
INSERT INTO `sys_permission_role` VALUES (169, 15, 6);
INSERT INTO `sys_permission_role` VALUES (170, 16, 6);
INSERT INTO `sys_permission_role` VALUES (171, 17, 6);
INSERT INTO `sys_permission_role` VALUES (172, 18, 6);
INSERT INTO `sys_permission_role` VALUES (173, 19, 6);
INSERT INTO `sys_permission_role` VALUES (174, 20, 6);
INSERT INTO `sys_permission_role` VALUES (175, 21, 6);
INSERT INTO `sys_permission_role` VALUES (176, 22, 6);
INSERT INTO `sys_permission_role` VALUES (177, 23, 6);
INSERT INTO `sys_permission_role` VALUES (178, 25, 6);
INSERT INTO `sys_permission_role` VALUES (179, 26, 6);
INSERT INTO `sys_permission_role` VALUES (180, 27, 6);
INSERT INTO `sys_permission_role` VALUES (181, 28, 6);
INSERT INTO `sys_permission_role` VALUES (182, 24, 6);
INSERT INTO `sys_permission_role` VALUES (247, 7, 4);
INSERT INTO `sys_permission_role` VALUES (248, 8, 4);
INSERT INTO `sys_permission_role` VALUES (249, 11, 4);
INSERT INTO `sys_permission_role` VALUES (256, 7, 1);
INSERT INTO `sys_permission_role` VALUES (257, 8, 1);
INSERT INTO `sys_permission_role` VALUES (258, 9, 1);
INSERT INTO `sys_permission_role` VALUES (259, 10, 1);
INSERT INTO `sys_permission_role` VALUES (260, 11, 1);
INSERT INTO `sys_permission_role` VALUES (261, 12, 1);
INSERT INTO `sys_permission_role` VALUES (262, 13, 1);
INSERT INTO `sys_permission_role` VALUES (263, 14, 1);
INSERT INTO `sys_permission_role` VALUES (264, 15, 1);
INSERT INTO `sys_permission_role` VALUES (265, 16, 1);
INSERT INTO `sys_permission_role` VALUES (266, 17, 1);
INSERT INTO `sys_permission_role` VALUES (267, 18, 1);
INSERT INTO `sys_permission_role` VALUES (268, 19, 1);
INSERT INTO `sys_permission_role` VALUES (269, 20, 1);
INSERT INTO `sys_permission_role` VALUES (270, 21, 1);
INSERT INTO `sys_permission_role` VALUES (271, 22, 1);
INSERT INTO `sys_permission_role` VALUES (272, 23, 1);
INSERT INTO `sys_permission_role` VALUES (273, 24, 1);
INSERT INTO `sys_permission_role` VALUES (274, 25, 1);
INSERT INTO `sys_permission_role` VALUES (275, 26, 1);
INSERT INTO `sys_permission_role` VALUES (276, 27, 1);
INSERT INTO `sys_permission_role` VALUES (277, 28, 1);
INSERT INTO `sys_permission_role` VALUES (278, 7, 2);
INSERT INTO `sys_permission_role` VALUES (279, 10, 2);
INSERT INTO `sys_permission_role` VALUES (280, 11, 2);
INSERT INTO `sys_permission_role` VALUES (281, 12, 2);
INSERT INTO `sys_permission_role` VALUES (282, 13, 2);
INSERT INTO `sys_permission_role` VALUES (283, 7, 3);
INSERT INTO `sys_permission_role` VALUES (284, 10, 3);
INSERT INTO `sys_permission_role` VALUES (285, 11, 3);
INSERT INTO `sys_permission_role` VALUES (286, 12, 3);
INSERT INTO `sys_permission_role` VALUES (287, 13, 3);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nameZh` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ROLE_manager', '部门经理');
INSERT INTO `sys_role` VALUES (2, 'ROLE_personnel', '人事专员');
INSERT INTO `sys_role` VALUES (3, 'ROLE_recruiter', '招聘主管');
INSERT INTO `sys_role` VALUES (4, 'ROLE_train', '培训主管');
INSERT INTO `sys_role` VALUES (5, 'ROLE_performance', '薪酬绩效主管');
INSERT INTO `sys_role` VALUES (6, 'ROLE_admin', '系统管理员');
INSERT INTO `sys_role` VALUES (13, 'ROLE_test2', '测试角色2');
INSERT INTO `sys_role` VALUES (14, 'ROLE_test1', '测试角色1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(16) NOT NULL COMMENT 'hrID',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) NULL DEFAULT 1,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (3, '系统管理员', '18568887789', '029-82881234', '深圳南山', 1, 'admin', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', NULL);
INSERT INTO `sys_user` VALUES (5, '李白', '18568123489', '029-82123434', '海口美兰', 1, 'libai', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', NULL);
INSERT INTO `sys_user` VALUES (10, '韩愈', '18568123666', '029-82111555', '广州番禺', 1, 'hanyu', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1406745149,1563524794&fm=27&gp=0.jpg', NULL);
INSERT INTO `sys_user` VALUES (11, '柳宗元', '18568123377', '029-82111333', '广州天河', 1, 'liuzongyuan', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515233756&di=0856d923a0a37a87fd26604a2c871370&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2014-09-27%2F041716704.jpg', NULL);
INSERT INTO `sys_user` VALUES (12, '曾巩', '18568128888', '029-82111222', '广州越秀', 1, 'zenggong', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(16) NOT NULL,
  `role_id` bigint(16) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户-角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 3, 6);
INSERT INTO `sys_user_role` VALUES (9, 5, 1);
INSERT INTO `sys_user_role` VALUES (10, 5, 4);
INSERT INTO `sys_user_role` VALUES (35, 12, 4);
INSERT INTO `sys_user_role` VALUES (36, 12, 3);
INSERT INTO `sys_user_role` VALUES (37, 12, 2);
INSERT INTO `sys_user_role` VALUES (43, 11, 3);
INSERT INTO `sys_user_role` VALUES (44, 11, 2);
INSERT INTO `sys_user_role` VALUES (45, 11, 4);
INSERT INTO `sys_user_role` VALUES (46, 11, 5);
INSERT INTO `sys_user_role` VALUES (48, 10, 3);
INSERT INTO `sys_user_role` VALUES (49, 10, 4);

-- ----------------------------
-- Procedure structure for addDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
  declare did int;
  declare pDepPath varchar(64);
  insert into department set name=depName,parentId=parentId,enabled=enabled;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from department where id=parentId;
  update department set depPath=concat(pDepPath,'.',did) where id=did;
  update department set isParent=true where id=parentId;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDep`(in did int,out result int)
begin
  declare ecount int;
  declare pid int;
  declare pcount int;
  select count(*) into ecount from employee where departmentId=did;
  if ecount>0 then set result=-1;
  else 
  select parentId into pid from department where id=did;
  delete from department where id=did and isParent=false;
  select row_count() into result;
  select count(*) into pcount from department where parentId=pid;
  if pcount=0 then update department set isParent=false where id=pid;
  end if;
  end if;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
