/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : sang

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-02-22 18:10:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for brush_exception_info
-- ----------------------------
DROP TABLE IF EXISTS `brush_exception_info`;
CREATE TABLE `brush_exception_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(100) DEFAULT NULL COMMENT '异常信息',
  `cookie` varchar(100) DEFAULT NULL COMMENT '异常的cookie',
  `count` int(1) DEFAULT NULL COMMENT '异常步骤(1:验证码 2：下订单 3：获取支付验证码)',
  `get_ewm_url` varchar(100) DEFAULT NULL COMMENT '获取支付二维码的url',
  `auth_orders_id` varchar(100) DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brush_exception_info
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brush_ticket_info
-- ----------------------------
INSERT INTO `brush_ticket_info` VALUES ('1', '111.177.179.24', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('2', '120.236.128.201', '8060', '广东省广州市', '移动', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('3', '58.249.55.222', '9797', '广东省广州市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('4', '112.95.26.180', '8118', '广东省广州市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('5', '111.177.175.212', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('6', '163.125.16.224', '8888', '广东省深圳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('7', '60.223.243.21', '32779', '山西省晋中市平遥县', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('8', '121.61.3.77', '9999', '湖北省咸宁市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('9', '125.46.0.62', '53281', '河南省济源市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('10', '110.52.235.198', '9999', '湖南省岳阳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('11', '183.148.138.199', '9999', '浙江省台州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('12', '59.45.16.10', '59156', '辽宁省盘锦市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('13', '110.52.235.16', '9999', '湖南省岳阳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('14', '134.196.244.120', '46425', '中国', '', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('15', '182.150.35.145', '8080', '四川省成都市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('16', '111.177.179.24', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('17', '120.236.128.201', '8060', '广东省广州市', '移动', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('18', '58.249.55.222', '9797', '广东省广州市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('19', '112.95.26.180', '8118', '广东省广州市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('20', '111.177.175.212', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('21', '163.125.16.224', '8888', '广东省深圳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('22', '60.223.243.21', '32779', '山西省晋中市平遥县', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('23', '121.61.3.77', '9999', '湖北省咸宁市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('24', '125.46.0.62', '53281', '河南省济源市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('25', '110.52.235.198', '9999', '湖南省岳阳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('26', '183.148.138.199', '9999', '浙江省台州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('27', '59.45.16.10', '59156', '辽宁省盘锦市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('28', '110.52.235.16', '9999', '湖南省岳阳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('29', '134.196.244.120', '46425', '中国', '', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('30', '182.150.35.145', '8080', '四川省成都市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('31', '125.123.138.97', '9999', '浙江省嘉兴市嘉善县', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('32', '125.227.196.141', '8080', '台湾省', '中华电信(HiNet)数据中心', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('33', '116.209.57.222', '9999', '湖北省仙桃市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('34', '116.209.55.86', '9999', '湖北省仙桃市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('35', '125.123.140.249', '9000', '浙江省嘉兴市嘉善县', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('36', '183.245.98.6', '8118', '浙江省温州市', '移动', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('37', '222.221.11.119', '3128', '云南省昆明市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('38', '115.151.7.232', '9999', '江西省宜春市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('39', '144.255.13.248', '9999', '山东省', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('40', '111.177.166.199', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('41', '125.123.138.139', '9999', '浙江省嘉兴市嘉善县', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('42', '59.62.166.90', '9999', '江西省宜春市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('43', '111.177.179.55', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('44', '116.209.58.92', '9999', '湖北省仙桃市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('45', '111.177.169.65', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('46', '116.209.56.219', '9999', '湖北省仙桃市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('47', '60.26.152.236', '53281', '天津市河东区', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('48', '111.177.160.25', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('49', '116.209.52.7', '9999', '湖北省仙桃市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('50', '121.61.1.252', '9999', '湖北省咸宁市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('51', '180.118.247.133', '9999', '江苏省镇江市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('52', '221.235.234.177', '9999', '湖北省鄂州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('53', '115.151.1.45', '9999', '江西省宜春市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('54', '111.177.176.114', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('55', '111.177.180.219', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('56', '117.191.11.106', '8080', '新疆', '移动', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('57', '122.4.28.57', '9999', '山东省济南市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('58', '110.52.235.131', '9999', '湖南省岳阳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('59', '36.26.227.50', '9999', '浙江省', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('60', '140.143.237.109', '808', '中国', '', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('61', '116.209.57.147', '9999', '湖北省仙桃市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('62', '111.177.176.137', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('63', '117.91.232.91', '9999', '江苏省扬州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('64', '221.235.234.207', '9999', '湖北省鄂州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('65', '111.177.188.20', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('66', '163.125.221.125', '8088', '广东省深圳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('67', '111.177.163.172', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('68', '119.123.177.236', '9000', '广东省深圳市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('69', '111.177.190.100', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('70', '221.235.232.2', '9999', '湖北省鄂州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('71', '111.177.186.175', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('72', '111.177.178.199', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('73', '121.232.148.56', '9999', '江苏省镇江市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('74', '36.26.205.181', '9999', '浙江省', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('75', '115.151.4.142', '9999', '江西省宜春市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('76', '221.235.233.195', '9999', '湖北省鄂州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('77', '111.77.196.180', '9999', '江西省宜春市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('78', '110.52.235.146', '9999', '湖南省岳阳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('79', '60.173.244.133', '35634', '安徽省合肥市巢湖市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('80', '111.177.190.166', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('81', '115.239.25.127', '9999', '浙江省嘉兴市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('82', '111.177.174.135', '9999', '湖北省随州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('83', '125.123.139.160', '9999', '浙江省嘉兴市嘉善县', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('84', '110.52.235.172', '9999', '湖南省岳阳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('85', '116.209.54.75', '9999', '湖北省仙桃市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('86', '110.52.235.75', '9999', '湖南省岳阳市', '联通', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('87', '1.192.246.153', '9999', '河南省郑州市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('88', '183.230.162.20', '8060', '重庆市', '移动', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('89', '113.122.168.75', '9999', '山东省日照市', '电信', '2019-02-22', '0');
INSERT INTO `brush_ticket_info` VALUES ('90', '116.209.58.11', '9999', '湖北省仙桃市', '电信', '2019-02-22', '0');

-- ----------------------------
-- Table structure for success_order_info
-- ----------------------------
DROP TABLE IF EXISTS `success_order_info`;
CREATE TABLE `success_order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ewm_url` varchar(100) DEFAULT NULL COMMENT '支付二维码地址',
  `parameter` varchar(100) DEFAULT NULL COMMENT '请求参数',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of success_order_info
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=5573 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tourist_info
-- ----------------------------
INSERT INTO `tourist_info` VALUES ('5375', '陈春瑜', '13769036460', '532701199102260622', 'a', '0');
INSERT INTO `tourist_info` VALUES ('5376', '普美芬', '13769036460', '532401196404291221', 'a', '0');
INSERT INTO `tourist_info` VALUES ('5377', '薛红艳', '13769036460', '530402199105201247', 'a', '0');
INSERT INTO `tourist_info` VALUES ('5378', '普美珍', '13769036460', '53270119710816064X', 'a', '0');
INSERT INTO `tourist_info` VALUES ('5379', '胡娟娟', '13769036460', '610625199311191129 ', 'a', '0');
INSERT INTO `tourist_info` VALUES ('5380', '杭越武', '13308889446', '610625199006161118 ', 'b', '0');
INSERT INTO `tourist_info` VALUES ('5381', '张志伟', '13308889446', '120225199010031414', 'b', '0');
INSERT INTO `tourist_info` VALUES ('5382', '张洪波', '13308889446', '120224199305250749', 'b', '0');
INSERT INTO `tourist_info` VALUES ('5385', '温慧玲 ', '13578384698', '450721199612034426', 'c', '1');
INSERT INTO `tourist_info` VALUES ('5386', '劳英灿 ', '13578384698', '450721199410113951', 'c', '1');
INSERT INTO `tourist_info` VALUES ('5387', '王子慧', '13578384698', '210882199809291227', 'c', '1');
INSERT INTO `tourist_info` VALUES ('5388', '袁奇鹏', '13578384698', '410881199103025518', 'c', '1');
INSERT INTO `tourist_info` VALUES ('5389', '李柳明', '13578384698', '410881199303224562', 'c', '1');
INSERT INTO `tourist_info` VALUES ('5390', '袁玲', '15126074911', '421087199010027343', 'd', '1');
INSERT INTO `tourist_info` VALUES ('5391', '阳萍', '15126074911', '432923198209268123', 'd', '1');
INSERT INTO `tourist_info` VALUES ('5392', '成云霞', '15126074911', '140511198211167526', 'd', '1');
INSERT INTO `tourist_info` VALUES ('5393', '孙保庆', '15126074911', '340122198909143934', 'd', '1');
INSERT INTO `tourist_info` VALUES ('5394', '曹艳飞', '15126074911', '341281199008209140', 'd', '1');
INSERT INTO `tourist_info` VALUES ('5395', '邓力', '18088935596', '511324199404093813', 'e', '1');
INSERT INTO `tourist_info` VALUES ('5396', '张玲玲', '18088935596', '51012119931231266X', 'e', '1');
INSERT INTO `tourist_info` VALUES ('5397', '肖雪娇', '18088935596', '230184198810155568', 'e', '1');
INSERT INTO `tourist_info` VALUES ('5398', '易辉', '18088935596', '51130419820723201X', 'e', '1');
INSERT INTO `tourist_info` VALUES ('5399', '舒立辉', '18088935596', '532502197109160364', 'e', '1');
INSERT INTO `tourist_info` VALUES ('5400', '叶舒睿', '13988835069', '532502199808080629', 'f', '1');
INSERT INTO `tourist_info` VALUES ('5401', '蒲芬', '13988835069', '431227199211112508', 'f', '1');
INSERT INTO `tourist_info` VALUES ('5402', '潘茜茜', '13988835069', '431226199410296024', 'f', '1');
INSERT INTO `tourist_info` VALUES ('5403', '林志亮', '13988835069', '441581199408238215', 'f', '1');
INSERT INTO `tourist_info` VALUES ('5404', '周姝', '18559038787', '500109198402181324', 'h', '1');
INSERT INTO `tourist_info` VALUES ('5405', '温碧霞', '13988835069', '441501199405116069', 'f', '1');
INSERT INTO `tourist_info` VALUES ('5406', '陈业强', '15306099325', '440682198610091014', 'g', '1');
INSERT INTO `tourist_info` VALUES ('5407', '陈赵宇  ', '15306099325', '44132219941002643X', 'g', '1');
INSERT INTO `tourist_info` VALUES ('5408', '陈佩琦 ', '15306099325', '441322199302113026', 'g', '1');
INSERT INTO `tourist_info` VALUES ('5409', '谭永健', '15306099325', '44068219840919103X', 'g', '1');
INSERT INTO `tourist_info` VALUES ('5410', '陈丽嫦', '15306099325', '440682199110311345', 'g', '1');
INSERT INTO `tourist_info` VALUES ('5411', '杨濯嫘', '18559038787', '430524200101101762', 'h', '1');
INSERT INTO `tourist_info` VALUES ('5412', '刘希', '18559038787', '430524200005184836', 'h', '1');
INSERT INTO `tourist_info` VALUES ('5413', '陕茜 ', '18559038787', '42102219991231452X', 'h', '1');
INSERT INTO `tourist_info` VALUES ('5414', '李文俊 ', '18559038787', '411521200006168334', 'h', '1');
INSERT INTO `tourist_info` VALUES ('5415', '赵莉', '18505923692', '232331198204192641', 'i', '1');
INSERT INTO `tourist_info` VALUES ('5416', '包振河', '18505923692', '110103196806241215', 'i', '1');
INSERT INTO `tourist_info` VALUES ('5417', '雷琴琴', '18505923692', '36223219800115002X', 'i', '1');
INSERT INTO `tourist_info` VALUES ('5418', '鲍海燕', '18505923692', '110108196008153773', 'i', '1');
INSERT INTO `tourist_info` VALUES ('5419', '鲍雷', '18505923692', '110108200705193753', 'i', '1');
INSERT INTO `tourist_info` VALUES ('5420', '刘静', '13211992222', '320321199412177042', 'l', '1');
INSERT INTO `tourist_info` VALUES ('5421', '陈家昌', '19906035596', '430681200105259316', 'm', '1');
INSERT INTO `tourist_info` VALUES ('5422', '黎栩柔', '19908880533', '440181199402198125', 'j', '1');
INSERT INTO `tourist_info` VALUES ('5423', '黄捷满', '19908880533', '442000199108180854', 'j', '1');
INSERT INTO `tourist_info` VALUES ('5424', '莫才珍', '19908880533', '45252819710103536X', 'j', '1');
INSERT INTO `tourist_info` VALUES ('5425', '易燕华', '19908880533', '452528197308075406', 'j', '1');
INSERT INTO `tourist_info` VALUES ('5426', '易在燕', '19908880533', '45252819740228540X', 'j', '1');
INSERT INTO `tourist_info` VALUES ('5427', '王婧', '19906035596', '430725199703151689', 'm', '1');
INSERT INTO `tourist_info` VALUES ('5428', '陆依纯', '19906035596', '431229199705091623', 'm', '1');
INSERT INTO `tourist_info` VALUES ('5429', '黄法良', '13097449333', '441621199409284415', 'k', '1');
INSERT INTO `tourist_info` VALUES ('5430', '陆琳', '13097449333', '45010419871010202X', 'k', '1');
INSERT INTO `tourist_info` VALUES ('5431', '梁燕英', '13097449333', '450106195708141520', 'k', '1');
INSERT INTO `tourist_info` VALUES ('5432', '赖红妃', '13097449333', '441781199502110323', 'k', '1');
INSERT INTO `tourist_info` VALUES ('5433', '汤艳', '13211992222', '530111198512281120', 'l', '1');
INSERT INTO `tourist_info` VALUES ('5434', '肖静文', '13097449333', '44178119970918352X', 'k', '1');
INSERT INTO `tourist_info` VALUES ('5435', '汤志明', '13211992222', '530111195308164716', 'l', '1');
INSERT INTO `tourist_info` VALUES ('5436', '汤俊康', '13211992222', '530111200909041117', 'l', '1');
INSERT INTO `tourist_info` VALUES ('5437', '孟春兰', '13211992222', '530111196306204803', 'l', '1');
INSERT INTO `tourist_info` VALUES ('5439', '王一政', '19906035596', '342401199308216975 ', 'm', '1');
INSERT INTO `tourist_info` VALUES ('5440', '周宏', '18605082292', '432801197606100019', 'n', '1');
INSERT INTO `tourist_info` VALUES ('5441', '陈俊佐', '18605082292', '431021198708140017', 'n', '1');
INSERT INTO `tourist_info` VALUES ('5442', '燕永霞', '18605082292', '150125199411074220', 'n', '1');
INSERT INTO `tourist_info` VALUES ('5443', '高蓉蓉', '18605082292', '150125199406150823', 'n', '1');
INSERT INTO `tourist_info` VALUES ('5444', '马盼盼 ', '18605082292', '411423199301166587', 'n', '1');
INSERT INTO `tourist_info` VALUES ('5445', '张剑杰', '17689942675', '532425199804101014', 'o', '1');
INSERT INTO `tourist_info` VALUES ('5446', '王利增 ', '17689942675', '411402199108268520', 'o', '1');
INSERT INTO `tourist_info` VALUES ('5447', '胡鹏鹏', '13632426851', '360121198910262436', 'p', '1');
INSERT INTO `tourist_info` VALUES ('5448', '陈雪娇', '17689942675', '532524199511283829', 'o', '1');
INSERT INTO `tourist_info` VALUES ('5449', '罗雪', '17689942675', '530421199604150324', 'o', '1');
INSERT INTO `tourist_info` VALUES ('5450', '方能花', '17689942675', '530427199610110722', 'o', '1');
INSERT INTO `tourist_info` VALUES ('5451', '徐和艳', '13632426851', '360111199110231027', 'p', '1');
INSERT INTO `tourist_info` VALUES ('5452', '李运华', '13632426851', '34242319930621208X', 'p', '1');
INSERT INTO `tourist_info` VALUES ('5453', '唐永洋', '13632426851', '41152419910302407X', 'p', '1');
INSERT INTO `tourist_info` VALUES ('5454', '张玉林', '18559287886', '152632197607240706', 'Q', '1');
INSERT INTO `tourist_info` VALUES ('5455', '张婷蕾', '18559287886', '152632199906051525', 'Q', '1');
INSERT INTO `tourist_info` VALUES ('5456', '刘惠妹', '18559287886', '430724199901255044 ', 'Q', '1');
INSERT INTO `tourist_info` VALUES ('5457', '刘雅文', '18559287886', '430281199702059163', 'Q', '1');
INSERT INTO `tourist_info` VALUES ('5458', '刘冬华', '18559287886', '430281197111144826', 'Q', '1');
INSERT INTO `tourist_info` VALUES ('5459', '陈杰', '15108399345', '511526198906292731', 'r', '1');
INSERT INTO `tourist_info` VALUES ('5460', '陈敏', '15108399345', '511526199303182749', 'r', '1');
INSERT INTO `tourist_info` VALUES ('5461', '李梓源', '13632426851', '210902199403292063', 'p', '1');
INSERT INTO `tourist_info` VALUES ('5462', '罗家翠', '15108399345', '512533196906282723', 'r', '1');
INSERT INTO `tourist_info` VALUES ('5463', '陈小兵', '15108399345', '512533196707162710', 'r', '1');
INSERT INTO `tourist_info` VALUES ('5464', '李世珍', '15108399345', '511526199709103043', 'r', '1');
INSERT INTO `tourist_info` VALUES ('5465', '邵晓青', '18000541755', '310113198410232426', 's', '1');
INSERT INTO `tourist_info` VALUES ('5466', '吉鸿飞', '18000541755', '320522199309091635', 's', '1');
INSERT INTO `tourist_info` VALUES ('5467', '陈伊敏', '18000541755', '445121199310123968', 's', '1');
INSERT INTO `tourist_info` VALUES ('5468', '陈伊琳', '18000541755', '445121199601203968', 's', '1');
INSERT INTO `tourist_info` VALUES ('5469', '林锦', '19981223793', '350302199407071637', 't', '1');
INSERT INTO `tourist_info` VALUES ('5470', '陈淑芸', '18000541755', '440521197301231340', 's', '1');
INSERT INTO `tourist_info` VALUES ('5471', '林秋水', '19981223793', '350321199402108428 ', 't', '1');
INSERT INTO `tourist_info` VALUES ('5472', '聂忠明', '19981223793', '53212219910205107X', 't', '1');
INSERT INTO `tourist_info` VALUES ('5473', '高开梅', '19981223793', '532122199312020028', 't', '1');
INSERT INTO `tourist_info` VALUES ('5474', '贾韩韩', '19981223793', '130124199110031286', 't', '1');
INSERT INTO `tourist_info` VALUES ('5475', '滑星', '18380331301', '110221199102161219', 'u', '1');
INSERT INTO `tourist_info` VALUES ('5476', '杨健', '15933666622', '612723199304245613', 'v', '1');
INSERT INTO `tourist_info` VALUES ('5477', '赵瑞英', '15933666622', '61272319940218042X', 'v', '1');
INSERT INTO `tourist_info` VALUES ('5478', '金苗苗', '18380331301', '330106199307013027', 'u', '1');
INSERT INTO `tourist_info` VALUES ('5479', '冯翁熠峰', '18380331301', '330106199210133014', 'u', '1');
INSERT INTO `tourist_info` VALUES ('5480', '王晨晨', '18380331301', '330104198908083322', 'u', '1');
INSERT INTO `tourist_info` VALUES ('5481', '吴建飞', '18380331301', '330106198909143035', 'u', '1');
INSERT INTO `tourist_info` VALUES ('5482', '代文学', '15933666622', '510681199612030625', 'v', '1');
INSERT INTO `tourist_info` VALUES ('5483', '陈文翰', '15933666622', '51068120000409062X', 'v', '1');
INSERT INTO `tourist_info` VALUES ('5484', '黎芳君', '17732899909', '522131198905203129', 'w', '1');
INSERT INTO `tourist_info` VALUES ('5485', '林义烩', '15933666622', '350426198802061510', 'v', '1');
INSERT INTO `tourist_info` VALUES ('5486', '赵顺蕾', '17732899909', '420683199607140361', 'w', '1');
INSERT INTO `tourist_info` VALUES ('5487', '柏雨', '17732899909', '420683199809040940', 'w', '1');
INSERT INTO `tourist_info` VALUES ('5488', '刘欣颖', '17732899909', '130533199103294422', 'w', '1');
INSERT INTO `tourist_info` VALUES ('5489', '刘帅 ', '17732899909', '11010620011115181X', 'w', '1');
INSERT INTO `tourist_info` VALUES ('5490', '李自勇', '17708888360', '530129199702230533', 'x', '1');
INSERT INTO `tourist_info` VALUES ('5491', '徐利平', '17708888360', '513902199811110023', 'x', '1');
INSERT INTO `tourist_info` VALUES ('5492', '葛丽 ', '17708888360', '52212819930219002X', 'x', '1');
INSERT INTO `tourist_info` VALUES ('5493', '张焕伦 ', '17708888360', '522128198808262014', 'x', '1');
INSERT INTO `tourist_info` VALUES ('5494', '汪嘉宾', '17708888360', '513902199904222171', 'x', '1');
INSERT INTO `tourist_info` VALUES ('5495', '何云凡', '15607695661', '420684198910285549', 'z', '1');
INSERT INTO `tourist_info` VALUES ('5496', '闫宸昊', '13601337731', '130104199110281837', 'y', '1');
INSERT INTO `tourist_info` VALUES ('5497', '林权', '15607695661', '440825198109292158', 'z', '1');
INSERT INTO `tourist_info` VALUES ('5498', '高松', '13601337731', '13013019920512153X', 'y', '1');
INSERT INTO `tourist_info` VALUES ('5499', '闫静辉', '13601337731', '130104196411091830', 'y', '1');
INSERT INTO `tourist_info` VALUES ('5500', '高志敏', '13601337731', '130104196510041345', 'y', '1');
INSERT INTO `tourist_info` VALUES ('5501', '郝晔', '13601337731', '130130199110220228', 'y', '1');
INSERT INTO `tourist_info` VALUES ('5502', '高志学', '15607695661', '132324196704071436', 'z', '1');
INSERT INTO `tourist_info` VALUES ('5503', '刘红翠', '15607695661', '132324196809030729', 'z', '1');
INSERT INTO `tourist_info` VALUES ('5504', '徐先勇', '15003241991', '510221198001025111', 'A1', '0');
INSERT INTO `tourist_info` VALUES ('5505', '张晓霞', '15003241991', '654021199511300425', 'A1', '0');
INSERT INTO `tourist_info` VALUES ('5506', '林文斌 ', '15003241991', '350203196501011013', 'A1', '0');
INSERT INTO `tourist_info` VALUES ('5507', '吕良山', '13784531132', '450702199207030334', 'B1', '1');
INSERT INTO `tourist_info` VALUES ('5508', '胡力文', '15003241991', '500221198802037620', 'A1', '0');
INSERT INTO `tourist_info` VALUES ('5509', '刘蜻云', '13784531132', '450521199001031540', 'B1', '1');
INSERT INTO `tourist_info` VALUES ('5510', '蔡丽晓', '18810541540', '330381198812015943', 'C1', '1');
INSERT INTO `tourist_info` VALUES ('5511', '鲁淑敏', '18810541540', '362330199906085821', 'C1', '1');
INSERT INTO `tourist_info` VALUES ('5512', '宋鑫', '13784531132', '210402197902060535', 'B1', '1');
INSERT INTO `tourist_info` VALUES ('5513', '尤丹', '13784531132', '210411198107200229', 'B1', '1');
INSERT INTO `tourist_info` VALUES ('5514', '宋奕璠', '13784531132', '210402200704170527', 'B1', '1');
INSERT INTO `tourist_info` VALUES ('5515', '刘景烨', '18810541540', '362330200110160238', 'C1', '1');
INSERT INTO `tourist_info` VALUES ('5516', '黄静莹', '15933678333', '441702199509012827', 'D1', '1');
INSERT INTO `tourist_info` VALUES ('5517', '黄小兵', '18810541540', '362330199912181713', 'C1', '1');
INSERT INTO `tourist_info` VALUES ('5518', '罗荣潮', '13931420118', '441702199501030334', 'E1', '1');
INSERT INTO `tourist_info` VALUES ('5519', '张俊', '18810541540', '362330200003215571', 'C1', '1');
INSERT INTO `tourist_info` VALUES ('5520', '黄应萍', '15933678333', '422201198708137322', 'D1', '1');
INSERT INTO `tourist_info` VALUES ('5521', '王娜娜', '15933678333', '420116199302212427', 'D1', '1');
INSERT INTO `tourist_info` VALUES ('5522', '熊伊伊', '15933678333', '420104199107224320', 'D1', '1');
INSERT INTO `tourist_info` VALUES ('5523', '朱子谦', '13931420118', '342222199107017620', 'E1', '1');
INSERT INTO `tourist_info` VALUES ('5524', '李笑莹', '13931420118', '130183200008290025', 'E1', '1');
INSERT INTO `tourist_info` VALUES ('5525', '张婷', '15933678333', '420923199309065842', 'D1', '1');
INSERT INTO `tourist_info` VALUES ('5526', '泽亮宇', '13931420118', '513326199611020013', 'E1', '1');
INSERT INTO `tourist_info` VALUES ('5527', '吴炜', '13931420118', '360424199707205700', 'E1', '1');
INSERT INTO `tourist_info` VALUES ('5528', '邓碧莹', '13013384507', '452623199710193323', 'F1', '1');
INSERT INTO `tourist_info` VALUES ('5529', '陆玉萍', '13013384507', '452623199806153326', 'F1', '1');
INSERT INTO `tourist_info` VALUES ('5530', '武致远', '13013384507', '372928199804280012', 'F1', '1');
INSERT INTO `tourist_info` VALUES ('5531', '李何丽', '13013384507', '511011199308256266', 'F1', '1');
INSERT INTO `tourist_info` VALUES ('5532', '黎议瞳', '13013384507', '511002199708251249', 'F1', '1');
INSERT INTO `tourist_info` VALUES ('5533', '代明月', '15003241991', '211202199802182542', 'A1', '0');
INSERT INTO `tourist_info` VALUES ('5534', '黄远程', '18783863553', '510922199808260170', 'G1', '1');
INSERT INTO `tourist_info` VALUES ('5535', '何礼添', '18783863553', '440681199708245438', 'G1', '1');
INSERT INTO `tourist_info` VALUES ('5536', '杨帆', '18783863553', '522626199410250418', 'G1', '1');
INSERT INTO `tourist_info` VALUES ('5537', '李旭', '18783863553', '522226199205212824', 'G1', '1');
INSERT INTO `tourist_info` VALUES ('5538', '罗伟林', '18783863553', '442000199812074238', 'G1', '1');
INSERT INTO `tourist_info` VALUES ('5539', '盖青松', '15959242440', '411421199306197232', 'H1', '1');
INSERT INTO `tourist_info` VALUES ('5540', '刘迪', '15959242440', '411421199110194822', 'H1', '1');
INSERT INTO `tourist_info` VALUES ('5541', '韩磊', '15959242440', '430702199310176039', 'H1', '1');
INSERT INTO `tourist_info` VALUES ('5542', '苏钰麟 ', '18950076936', '440105198406250313', 'I1', '1');
INSERT INTO `tourist_info` VALUES ('5543', '杜亮', '15959242440', '431224199408130014', 'H1', '1');
INSERT INTO `tourist_info` VALUES ('5544', '罗欣', '15959242440', '430122199203237820', 'H1', '1');
INSERT INTO `tourist_info` VALUES ('5545', '余艳婷 ', '18950076936', '440105198309094224', 'I1', '1');
INSERT INTO `tourist_info` VALUES ('5546', '陈丽思 ', '18950076936', '440104198311101925', 'I1', '1');
INSERT INTO `tourist_info` VALUES ('5547', '毕士伟', '15859092772', '120111198511120011 ', 'JJ', '1');
INSERT INTO `tourist_info` VALUES ('5548', '万璐', '15859092772', '430623199101295142 ', 'JJ', '1');
INSERT INTO `tourist_info` VALUES ('5549', '高磊', '15859092772', '371102199411192910', 'JJ', '1');
INSERT INTO `tourist_info` VALUES ('5550', '曹梦瑶', '15859092772', '371327199409296428', 'JJ', '1');
INSERT INTO `tourist_info` VALUES ('5551', '尹振伟', '15859092772', '321181199005253171', 'JJ', '1');
INSERT INTO `tourist_info` VALUES ('5552', '罗佳', '18950076936', '510421199611165520', 'I1', '1');
INSERT INTO `tourist_info` VALUES ('5553', '陈德强', '18950076936', '331022198109280213', 'I1', '1');
INSERT INTO `tourist_info` VALUES ('5554', '陈殿芝', '13313869446', '330102198908151265', 'KK', '1');
INSERT INTO `tourist_info` VALUES ('5557', '汪千颀', '13313869446', '620102199303023344', 'KK', '1');
INSERT INTO `tourist_info` VALUES ('5558', '龚匡', '13313869446', '330723199108041024', 'KK', '1');
INSERT INTO `tourist_info` VALUES ('5559', '龚玲玲', '13313869446', '33072319870401102X', 'KK', '1');
INSERT INTO `tourist_info` VALUES ('5560', '杨双超', '15980812935', '530112199607090934', 'LL', '1');
INSERT INTO `tourist_info` VALUES ('5561', '覃涵', '15980812935', '50022519970603741X', 'LL', '1');
INSERT INTO `tourist_info` VALUES ('5562', '屠定丽', '15980812935', '520202199703015521', 'LL', '1');
INSERT INTO `tourist_info` VALUES ('5563', '沈潘', '13023995636', '430122199407231121', 'MM', '1');
INSERT INTO `tourist_info` VALUES ('5564', '陈佳', '13023995636', '500225198901011923', 'MM', '1');
INSERT INTO `tourist_info` VALUES ('5565', '刘密', '13023995636', '430122199309085212', 'MM', '1');
INSERT INTO `tourist_info` VALUES ('5566', '邹鹏', '13313869446', '362528198603281512', 'KK', '1');
INSERT INTO `tourist_info` VALUES ('5567', '邵华', '13023995636', '441424199104246950', 'MM', '1');
INSERT INTO `tourist_info` VALUES ('5568', '陈媛', '13023995636', '44140219940326152X', 'MM', '1');
INSERT INTO `tourist_info` VALUES ('5569', '杨健', '18088000428', '32010319840613227X', 'yj', '1');
INSERT INTO `tourist_info` VALUES ('5570', '徐小红', '18088000428', '510802199003102545', 'yj', '1');
INSERT INTO `tourist_info` VALUES ('5571', '黄建菲', '18088000428', '500235198512150674', 'yj', '1');
INSERT INTO `tourist_info` VALUES ('5572', '周慧萍', '18088000428', '500232198807163983', 'yj', '1');
