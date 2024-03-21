/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80035 (8.0.35)
 Source Host           : localhost:3306
 Source Schema         : stu_db

 Target Server Type    : MySQL
 Target Server Version : 80035 (8.0.35)
 File Encoding         : 65001

 Date: 21/03/2024 16:43:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin`  (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `admin_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员名称',
                              `admin_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '管理员密码',
                              `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '后台管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES (1, 'admin', '4297f44b13955235245b2497399d7a93', '2024-03-18 10:45:13');
INSERT INTO `sys_admin` VALUES (2, 'test', '4297f44b13955235245b2497399d7a93', '2024-03-18 10:45:24');

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程名称',
                              `course_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程视频路径',
                              `course_img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程的封面图',
                              `sys_id` int NULL DEFAULT NULL COMMENT '管理员ID',
                              `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程表信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES (1, 'C#', 'http://192.168.1.4:1688/upload/mp4/c8b129cf340d45f4bb3c87a0494dcb0b.mp4', 'https://img0.baidu.com/it/u=1678426392,3298905118&fm=253&fmt=auto&app=138&f=JPEG?w=389&h=389', NULL, '2024-03-19 14:25:39');
INSERT INTO `tb_course` VALUES (2, 'C++', 'http://192.168.1.4:1688/upload/mp4/74e7a1534ac8493a966dea7e80802787.mp4', 'https://img0.baidu.com/it/u=1678426392,3298905118&fm=253&fmt=auto&app=138&f=JPEG?w=389&h=389', NULL, '2024-03-19 14:25:42');
INSERT INTO `tb_course` VALUES (3, 'Python', 'http://192.168.1.4:1688/upload/mp4/0a87e000d09a4949967c84b39a74316d.mp4', 'https://img0.baidu.com/it/u=1678426392,3298905118&fm=253&fmt=auto&app=138&f=JPEG?w=389&h=389', NULL, '2024-03-19 14:25:53');
INSERT INTO `tb_course` VALUES (4, 'fortran', 'http://192.168.1.4:1688/upload/mp4/6cc3544cf1bb49889841624072d0b60a.mp4', 'https://img0.baidu.com/it/u=1678426392,3298905118&fm=253&fmt=auto&app=138&f=JPEG?w=389&h=389', NULL, '2024-03-19 14:25:55');
INSERT INTO `tb_course` VALUES (5, 'go', 'http://192.168.1.4:1688/upload/mp4/6cc3544cf1bb49889841624072d0b60a.mp4', 'https://img0.baidu.com/it/u=1678426392,3298905118&fm=253&fmt=auto&app=138&f=JPEG?w=389&h=389', NULL, '2024-03-19 14:25:57');
INSERT INTO `tb_course` VALUES (6, 'java', 'http://192.168.1.4:1688/upload/mp4/6cc3544cf1bb49889841624072d0b60a.mp4', 'https://img0.baidu.com/it/u=1678426392,3298905118&fm=253&fmt=auto&app=138&f=JPEG?w=389&h=389', NULL, '2024-03-19 14:26:00');
INSERT INTO `tb_course` VALUES (7, 'javascript', 'http://192.168.1.4:1688/upload/mp4/6cc3544cf1bb49889841624072d0b60a.mp4', 'https://img0.baidu.com/it/u=1678426392,3298905118&fm=253&fmt=auto&app=138&f=JPEG?w=389&h=389', NULL, '2024-03-19 14:26:08');
INSERT INTO `tb_course` VALUES (8, 'e', 'http://192.168.1.4:1688/upload/mp4/6cc3544cf1bb49889841624072d0b60a.mp4', 'https://img0.baidu.com/it/u=1678426392,3298905118&fm=253&fmt=auto&app=138&f=JPEG?w=389&h=389', NULL, '2024-03-19 14:26:22');
INSERT INTO `tb_course` VALUES (9, 'html', 'http://192.168.1.4:1688/upload/mp4/6cc3544cf1bb49889841624072d0b60a.mp4', 'https://img0.baidu.com/it/u=1678426392,3298905118&fm=253&fmt=auto&app=138&f=JPEG?w=389&h=389', NULL, '2024-03-19 14:26:27');
INSERT INTO `tb_course` VALUES (12, '123123123', 'http://192.168.1.4:1688/upload/mp4/6cc3544cf1bb49889841624072d0b60a.mp4', NULL, NULL, '2024-03-20 14:20:02');

SET FOREIGN_KEY_CHECKS = 1;
