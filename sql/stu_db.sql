/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50733
Source Host           : localhost:3306
Source Database       : stu_db

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2024-03-18 11:39:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_user` varchar(255) NOT NULL COMMENT '管理员名称',
  `admin_password` varchar(255) DEFAULT NULL COMMENT '管理员密码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES ('1', 'admin', '123123', '2024-03-18 10:45:13');
INSERT INTO `sys_admin` VALUES ('2', 'test', '123123', '2024-03-18 10:45:24');

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `course_url` varchar(255) DEFAULT NULL COMMENT '课程视频路径',
  `course_img_url` varchar(255) DEFAULT NULL COMMENT '课程的封面图',
  `sys_id` int(11) DEFAULT NULL COMMENT '管理员ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
