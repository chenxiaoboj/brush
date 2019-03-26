/*
Navicat MySQL Data Transfer

Source Server         : localhose
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : brush

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-03-26 22:00:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for brush_exception_info
-- ----------------------------
DROP TABLE IF EXISTS `brush_exception_info`;
CREATE TABLE `brush_exception_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL COMMENT '异常信息',
  `number` int(11) DEFAULT NULL,
  `count` int(1) DEFAULT NULL COMMENT '异常步骤(1:验证码 2：下订单 3：获取支付验证码)',
  `cookie` varchar(500) DEFAULT NULL COMMENT '异常的cookie',
  `get_ewm_url` varchar(100) DEFAULT NULL COMMENT '获取支付二维码的url',
  `auth_orders_id` varchar(100) DEFAULT NULL COMMENT '订单id',
  `parameter` varchar(1000) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `del_flag` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=578 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for brush_ticket_info
-- ----------------------------
DROP TABLE IF EXISTS `brush_ticket_info`;
CREATE TABLE `brush_ticket_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host_name` varchar(100) DEFAULT NULL COMMENT '代理ip',
  `port` int(11) DEFAULT NULL COMMENT '端口',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `operator_type` varchar(100) DEFAULT NULL COMMENT '运营商类型',
  `end_time` date DEFAULT NULL COMMENT '最后检测时间',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '标记是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fenzu_entity
-- ----------------------------
DROP TABLE IF EXISTS `fenzu_entity`;
CREATE TABLE `fenzu_entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) DEFAULT NULL,
  `id_list` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for success_order_info
-- ----------------------------
DROP TABLE IF EXISTS `success_order_info`;
CREATE TABLE `success_order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `ewm_url` varchar(100) DEFAULT NULL COMMENT '支付二维码地址',
  `parameter` varchar(1000) DEFAULT NULL COMMENT '请求参数',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `number` int(11) DEFAULT NULL,
  `order_id_url` varchar(255) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `success_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tourist_info
-- ----------------------------
DROP TABLE IF EXISTS `tourist_info`;
CREATE TABLE `tourist_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话',
  `id_number` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '身份证号',
  `remarks` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=latin1;
