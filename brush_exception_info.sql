/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : sang

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-02-27 16:22:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for brush_exception_info
-- ----------------------------
DROP TABLE IF EXISTS `brush_exception_info`;
CREATE TABLE `brush_exception_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(500) DEFAULT NULL COMMENT '异常信息',
  `cookie` varchar(500) DEFAULT NULL COMMENT '异常的cookie',
  `count` int(1) DEFAULT NULL COMMENT '异常步骤(1:验证码 2：下订单 3：获取支付验证码)',
  `get_ewm_url` varchar(100) DEFAULT NULL COMMENT '获取支付二维码的url',
  `auth_orders_id` varchar(100) DEFAULT NULL COMMENT '订单id',
  `parameter` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=868 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=591 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brush_ticket_info
-- ----------------------------
INSERT INTO `brush_ticket_info` VALUES ('539', '118.122.92.252', '37901', '四川省成都市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('541', '122.117.37.39', '47728', '台湾省', '中华电信(HiNet)数据中心', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('542', '220.173.106.168', '63000', '广西柳州市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('543', '220.133.57.116', '56732', '台湾省', '中华电信(HiNet)', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('544', '203.93.125.238', '31566', '黑龙江省大庆市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('545', '221.210.120.153', '54402', '黑龙江省绥化市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('546', '221.6.32.214', '41816', '江苏省南京市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('547', '221.224.136.211', '35101', '江苏省苏州市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('548', '157.0.210.242', '53540', '江苏省', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('549', '222.128.9.235', '33428', '北京市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('550', '111.43.70.58', '51547', '黑龙江省', '移动(全省通用)', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('551', '222.174.225.26', '57641', '山东省', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('552', '210.5.10.87', '53281', '广东省广州市', '中移铁通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('553', '120.194.42.157', '38185', '河南省洛阳市孟津县', '移动', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('554', '119.1.97.192', '36751', '贵州省黔西南州兴义市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('555', '221.239.86.26', '32228', '天津市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('556', '119.145.2.99', '44129', '广东省深圳市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('557', '123.132.232.254', '61017', '山东省临沂市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('558', '218.25.131.121', '58137', '辽宁省大连市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('559', '218.22.7.62', '53281', '安徽省合肥市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('560', '119.145.2.98', '44129', '广东省深圳市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('561', '59.125.31.116', '45965', '台湾省', '中华电信(HiNet)数据中心', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('562', '221.214.167.3', '44352', '山东省烟台市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('563', '119.180.196.69', '61234', '山东省', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('564', '222.139.245.130', '40475', '河南省南阳市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('565', '58.254.220.116', '53579', '广东省惠州市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('566', '222.170.101.98', '50204', '黑龙江省佳木斯市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('567', '117.141.155.241', '53281', '广西', '移动', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('568', '218.76.253.201', '61310', '湖南省永州市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('569', '103.254.185.26', '39177', '北京市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('570', '119.57.108.73', '53281', '北京市', '东四IDC机房', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('571', '182.111.64.8', '53364', '江西省宜春市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('572', '117.65.39.37', '31323', '安徽省蚌埠市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('573', '61.164.39.67', '53281', '浙江省杭州市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('574', '123.195.152.139', '50942', '台湾省台北市', '亚太电信集团公司', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('575', '118.163.120.182', '58837', '台湾省', '中华电信(HiNet)数据中心', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('576', '182.207.232.135', '49166', '辽宁省沈阳市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('577', '103.205.26.78', '47917', '广东省东莞市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('578', '122.116.67.146', '57967', '台湾省', '中华电信(HiNet)数据中心', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('579', '180.140.191.233', '48326', '广西南宁市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('580', '103.235.199.9', '33180', '北京市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('581', '221.11.105.68', '56120', '陕西省汉中市汉台区', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('582', '103.205.26.84', '41805', '广东省东莞市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('583', '36.33.32.158', '46817', '安徽省合肥市', '联通', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('584', '103.205.26.57', '57010', '广东省东莞市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('585', '203.110.164.139', '52144', '上海市', '图像数据通信有限公司', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('586', '183.215.206.39', '53281', '湖南省', '移动', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('587', '58.56.108.237', '58690', '山东省济南市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('588', '220.134.24.215', '58879', '台湾省', '中华电信(HiNet)', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('589', '59.37.33.62', '50686', '广东省惠州市', '电信', '2019-02-27', '0');
INSERT INTO `brush_ticket_info` VALUES ('590', '117.65.38.116', '31323', '安徽省蚌埠市', '电信', '2019-02-27', '0');

-- ----------------------------
-- Table structure for success_order_info
-- ----------------------------
DROP TABLE IF EXISTS `success_order_info`;
CREATE TABLE `success_order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ewm_url` varchar(100) DEFAULT NULL COMMENT '支付二维码地址',
  `parameter` varchar(1000) DEFAULT NULL COMMENT '请求参数',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `number` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=793 DEFAULT CHARSET=utf8;

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
INSERT INTO `tourist_info` VALUES ('5375', '陈春瑜', '13769010460', '532701199102260622', 'a', '0');
INSERT INTO `tourist_info` VALUES ('5376', '普美芬', '13769010460', '532401196404291221', 'a', '0');
INSERT INTO `tourist_info` VALUES ('5377', '薛红艳', '13769010460', '530402199105201247', 'a', '0');
INSERT INTO `tourist_info` VALUES ('5378', '普美珍', '13769010460', '53270119710816064X', 'a', '0');
INSERT INTO `tourist_info` VALUES ('5379', '胡娟娟', '13769016060', '610625199311191129 ', 'a', '0');
INSERT INTO `tourist_info` VALUES ('5380', '杭越武', '13308819046', '610625199006161118 ', 'b', '0');
INSERT INTO `tourist_info` VALUES ('5381', '张志伟', '13308810446', '120225199010031414', 'b', '0');
INSERT INTO `tourist_info` VALUES ('5382', '张洪波', '13308810446', '120224199305250749', 'b', '0');
INSERT INTO `tourist_info` VALUES ('5385', '温慧玲', '13578310698', '450721199612034426', 'c', '1');
INSERT INTO `tourist_info` VALUES ('5386', '劳英灿', '13578310698', '450721199410113951', 'c', '1');
INSERT INTO `tourist_info` VALUES ('5387', '王子慧', '13578310698', '210882199809291227', 'c', '1');
INSERT INTO `tourist_info` VALUES ('5388', '袁奇鹏', '13578310698', '410881199103025518', 'c', '1');
INSERT INTO `tourist_info` VALUES ('5389', '李柳明', '13578310698', '410881199303224562', 'c', '1');
INSERT INTO `tourist_info` VALUES ('5390', '袁玲', '15126170911', '421087199010027343', 'd', '1');
INSERT INTO `tourist_info` VALUES ('5391', '阳萍', '15126170911', '432923198209268123', 'd', '1');
INSERT INTO `tourist_info` VALUES ('5392', '成云霞', '15126010911', '140511198211167526', 'd', '1');
INSERT INTO `tourist_info` VALUES ('5393', '孙保庆', '15126010911', '340122198909143934', 'd', '1');
INSERT INTO `tourist_info` VALUES ('5394', '曹艳飞', '15126010911', '341281199008209140', 'd', '1');
INSERT INTO `tourist_info` VALUES ('5395', '邓力', '18088130596', '511324199404093813', 'e', '1');
INSERT INTO `tourist_info` VALUES ('5396', '张玲玲', '18088910596', '51012119931231266X', 'e', '1');
INSERT INTO `tourist_info` VALUES ('5397', '肖雪娇', '18088910596', '230184198810155568', 'e', '1');
INSERT INTO `tourist_info` VALUES ('5398', '易辉', '18088130596', '51130419820723201X', 'e', '1');
INSERT INTO `tourist_info` VALUES ('5399', '舒立辉', '18088910596', '532502197109160364', 'e', '1');
INSERT INTO `tourist_info` VALUES ('5400', '叶舒睿', '13988810069', '532502199808080629', 'f', '1');
INSERT INTO `tourist_info` VALUES ('5401', '蒲芬', '13988130069', '431227199211112508', 'f', '1');
INSERT INTO `tourist_info` VALUES ('5402', '潘茜茜', '13988810069', '431226199410296024', 'f', '1');
INSERT INTO `tourist_info` VALUES ('5403', '林志亮', '13988810069', '441581199408238215', 'f', '1');
INSERT INTO `tourist_info` VALUES ('5404', '周姝', '18559130787', '500109198402181324', 'h', '1');
INSERT INTO `tourist_info` VALUES ('5405', '温碧霞', '13988810069', '441501199405116069', 'f', '1');
INSERT INTO `tourist_info` VALUES ('5406', '陈业强', '15306010325', '440682198610091014', 'g', '1');
INSERT INTO `tourist_info` VALUES ('5407', '陈赵宇', '15306010325', '44132219941002643X', 'g', '1');
INSERT INTO `tourist_info` VALUES ('5408', '陈佩琦', '15306010325', '441322199302113026', 'g', '1');
INSERT INTO `tourist_info` VALUES ('5409', '谭永健', '15306010325', '44068219840919103X', 'g', '1');
INSERT INTO `tourist_info` VALUES ('5410', '陈丽嫦', '15306010325', '440682199110311345', 'g', '1');
INSERT INTO `tourist_info` VALUES ('5411', '杨濯嫘', '18559010787', '430524200101101762', 'h', '1');
INSERT INTO `tourist_info` VALUES ('5412', '刘希', '18559130787', '430524200005184836', 'h', '1');
INSERT INTO `tourist_info` VALUES ('5413', '陕茜 ', '18559130787', '42102219991231452X', 'h', '1');
INSERT INTO `tourist_info` VALUES ('5414', '李文俊', '18559010787', '411521200006168334', 'h', '1');
INSERT INTO `tourist_info` VALUES ('5415', '赵莉', '18505120692', '232331198204192641', 'i', '1');
INSERT INTO `tourist_info` VALUES ('5416', '包振河', '18505910692', '110103196806241215', 'i', '1');
INSERT INTO `tourist_info` VALUES ('5417', '雷琴琴', '18505910692', '36223219800115002X', 'i', '1');
INSERT INTO `tourist_info` VALUES ('5418', '鲍海燕', '18505910692', '110108196008153773', 'i', '1');
INSERT INTO `tourist_info` VALUES ('5419', '鲍雷', '18505120692', '110108200705193753', 'i', '1');
INSERT INTO `tourist_info` VALUES ('5420', '刘静', '13211190222', '320321199412177042', 'l', '1');
INSERT INTO `tourist_info` VALUES ('5421', '陈家昌', '19906010596', '430681200105259316', 'm', '1');
INSERT INTO `tourist_info` VALUES ('5422', '黎栩柔', '19908810533', '440181199402198125', 'j', '1');
INSERT INTO `tourist_info` VALUES ('5423', '黄捷满', '19908810533', '442000199108180854', 'j', '1');
INSERT INTO `tourist_info` VALUES ('5424', '莫才珍', '19908810533', '45252819710103536X', 'j', '1');
INSERT INTO `tourist_info` VALUES ('5425', '易燕华', '19908810533', '452528197308075406', 'j', '1');
INSERT INTO `tourist_info` VALUES ('5426', '易在燕', '19908810533', '45252819740228540X', 'j', '1');
INSERT INTO `tourist_info` VALUES ('5427', '王婧', '19906130596', '430725199703151689', 'm', '1');
INSERT INTO `tourist_info` VALUES ('5428', '陆依纯', '19906010596', '431229199705091623', 'm', '1');
INSERT INTO `tourist_info` VALUES ('5429', '黄法良', '13097410333', '441621199409284415', 'k', '1');
INSERT INTO `tourist_info` VALUES ('5430', '陆琳', '13097140333', '45010419871010202X', 'k', '1');
INSERT INTO `tourist_info` VALUES ('5431', '梁燕英', '13097410333', '450106195708141520', 'k', '1');
INSERT INTO `tourist_info` VALUES ('5432', '赖红妃', '13097410333', '441781199502110323', 'k', '1');
INSERT INTO `tourist_info` VALUES ('5433', '汤艳', '13211190222', '530111198512281120', 'l', '1');
INSERT INTO `tourist_info` VALUES ('5434', '肖静文', '13097410333', '44178119970918352X', 'k', '1');
INSERT INTO `tourist_info` VALUES ('5435', '汤志明', '13211910222', '530111195308164716', 'l', '1');
INSERT INTO `tourist_info` VALUES ('5436', '汤俊康', '13211910222', '530111200909041117', 'l', '1');
INSERT INTO `tourist_info` VALUES ('5437', '孟春兰', '13211910222', '530111196306204803', 'l', '1');
INSERT INTO `tourist_info` VALUES ('5439', '王一政', '19906015096', '342401199308216975 ', 'm', '1');
INSERT INTO `tourist_info` VALUES ('5440', '周宏', '18605180292', '432801197606100019', 'n', '1');
INSERT INTO `tourist_info` VALUES ('5441', '陈俊佐', '18605010292', '431021198708140017', 'n', '1');
INSERT INTO `tourist_info` VALUES ('5442', '燕永霞', '18605010292', '150125199411074220', 'n', '1');
INSERT INTO `tourist_info` VALUES ('5443', '高蓉蓉', '18605010292', '150125199406150823', 'n', '1');
INSERT INTO `tourist_info` VALUES ('5444', '马盼盼', '18605010292', '411423199301166587', 'n', '1');
INSERT INTO `tourist_info` VALUES ('5445', '张剑杰', '17689910675', '532425199804101014', 'o', '1');
INSERT INTO `tourist_info` VALUES ('5446', '王利增', '17689910675', '411402199108268520', 'o', '1');
INSERT INTO `tourist_info` VALUES ('5447', '胡鹏鹏', '13632410851', '360121198910262436', 'p', '1');
INSERT INTO `tourist_info` VALUES ('5448', '陈雪娇', '17689910675', '532524199511283829', 'o', '1');
INSERT INTO `tourist_info` VALUES ('5449', '罗雪', '17689140675', '530421199604150324', 'o', '1');
INSERT INTO `tourist_info` VALUES ('5450', '方能花', '17689910675', '530427199610110722', 'o', '1');
INSERT INTO `tourist_info` VALUES ('5451', '徐和艳', '13632410851', '360111199110231027', 'p', '1');
INSERT INTO `tourist_info` VALUES ('5452', '李运华', '13632410851', '34242319930621208X', 'p', '1');
INSERT INTO `tourist_info` VALUES ('5453', '唐永洋', '13632410851', '41152419910302407X', 'p', '1');
INSERT INTO `tourist_info` VALUES ('5454', '张玉林', '18559210886', '152632197607240706', 'Q', '1');
INSERT INTO `tourist_info` VALUES ('5455', '张婷蕾', '18559210886', '152632199906051525', 'Q', '1');
INSERT INTO `tourist_info` VALUES ('5456', '刘惠妹', '18559217086', '430724199901255044 ', 'Q', '1');
INSERT INTO `tourist_info` VALUES ('5457', '刘雅文', '18559210886', '430281199702059163', 'Q', '1');
INSERT INTO `tourist_info` VALUES ('5458', '刘冬华', '18559210886', '430281197111144826', 'Q', '1');
INSERT INTO `tourist_info` VALUES ('5459', '陈杰', '15108190345', '511526198906292731', 'r', '1');
INSERT INTO `tourist_info` VALUES ('5460', '陈敏', '15108190345', '511526199303182749', 'r', '1');
INSERT INTO `tourist_info` VALUES ('5461', '李梓源', '13632410851', '210902199403292063', 'p', '1');
INSERT INTO `tourist_info` VALUES ('5462', '罗家翠', '15108310345', '512533196906282723', 'r', '1');
INSERT INTO `tourist_info` VALUES ('5463', '陈小兵', '15108310345', '512533196707162710', 'r', '1');
INSERT INTO `tourist_info` VALUES ('5464', '李世珍', '15108310345', '511526199709103043', 'r', '1');
INSERT INTO `tourist_info` VALUES ('5465', '邵晓青', '18000510755', '310113198410232426', 's', '1');
INSERT INTO `tourist_info` VALUES ('5466', '吉鸿飞', '18000510755', '320522199309091635', 's', '1');
INSERT INTO `tourist_info` VALUES ('5467', '陈伊敏', '18000510755', '445121199310123968', 's', '1');
INSERT INTO `tourist_info` VALUES ('5468', '陈伊琳', '18000510755', '445121199601203968', 's', '1');
INSERT INTO `tourist_info` VALUES ('5469', '林锦', '19981120793', '350302199407071637', 't', '1');
INSERT INTO `tourist_info` VALUES ('5470', '陈淑芸', '18000510755', '440521197301231340', 's', '1');
INSERT INTO `tourist_info` VALUES ('5471', '林秋水', '19981213093', '350321199402108428 ', 't', '1');
INSERT INTO `tourist_info` VALUES ('5472', '聂忠明', '19981210793', '53212219910205107X', 't', '1');
INSERT INTO `tourist_info` VALUES ('5473', '高开梅', '19981210793', '532122199312020028', 't', '1');
INSERT INTO `tourist_info` VALUES ('5474', '贾韩韩', '19981210793', '130124199110031286', 't', '1');
INSERT INTO `tourist_info` VALUES ('5475', '滑星', '18380130301', '110221199102161219', 'u', '1');
INSERT INTO `tourist_info` VALUES ('5476', '杨健', '15933160622', '612723199304245613', 'v', '1');
INSERT INTO `tourist_info` VALUES ('5477', '赵瑞英', '15933610622', '61272319940218042X', 'v', '1');
INSERT INTO `tourist_info` VALUES ('5478', '金苗苗', '18380310301', '330106199307013027', 'u', '1');
INSERT INTO `tourist_info` VALUES ('5479', '冯翁熠峰', '18380331301', '330106199210133014', 'u', '1');
INSERT INTO `tourist_info` VALUES ('5480', '王晨晨', '18380310301', '330104198908083322', 'u', '1');
INSERT INTO `tourist_info` VALUES ('5481', '吴建飞', '18380310301', '330106198909143035', 'u', '1');
INSERT INTO `tourist_info` VALUES ('5482', '代文学', '15933610622', '510681199612030625', 'v', '1');
INSERT INTO `tourist_info` VALUES ('5483', '陈文翰', '15933610622', '51068120000409062X', 'v', '1');
INSERT INTO `tourist_info` VALUES ('5484', '黎芳君', '17732810909', '522131198905203129', 'w', '1');
INSERT INTO `tourist_info` VALUES ('5485', '林义烩', '15933610622', '350426198802061510', 'v', '1');
INSERT INTO `tourist_info` VALUES ('5486', '赵顺蕾', '17732810909', '420683199607140361', 'w', '1');
INSERT INTO `tourist_info` VALUES ('5487', '柏雨', '17732190909', '420683199809040940', 'w', '1');
INSERT INTO `tourist_info` VALUES ('5488', '刘欣颖', '17732810909', '130533199103294422', 'w', '1');
INSERT INTO `tourist_info` VALUES ('5489', '刘帅 ', '17732190909', '11010620011115181X', 'w', '1');
INSERT INTO `tourist_info` VALUES ('5490', '李自勇', '17708810360', '530129199702230533', 'x', '1');
INSERT INTO `tourist_info` VALUES ('5491', '徐利平', '17708810360', '513902199811110023', 'x', '1');
INSERT INTO `tourist_info` VALUES ('5492', '葛丽 ', '17708180360', '52212819930219002X', 'x', '1');
INSERT INTO `tourist_info` VALUES ('5493', '张焕伦', '17708810360', '522128198808262014', 'x', '1');
INSERT INTO `tourist_info` VALUES ('5494', '汪嘉宾', '17708810360', '513902199904222171', 'x', '1');
INSERT INTO `tourist_info` VALUES ('5495', '何云凡', '15607610661', '420684198910285549', 'z', '1');
INSERT INTO `tourist_info` VALUES ('5496', '闫宸昊', '13601310731', '130104199110281837', 'y', '1');
INSERT INTO `tourist_info` VALUES ('5497', '林权', '15607190661', '440825198109292158', 'z', '1');
INSERT INTO `tourist_info` VALUES ('5498', '高松', '13601130731', '13013019920512153X', 'y', '1');
INSERT INTO `tourist_info` VALUES ('5499', '闫静辉', '13601310731', '130104196411091830', 'y', '1');
INSERT INTO `tourist_info` VALUES ('5500', '高志敏', '13601310731', '130104196510041345', 'y', '1');
INSERT INTO `tourist_info` VALUES ('5501', '郝晔', '13601130731', '130130199110220228', 'y', '1');
INSERT INTO `tourist_info` VALUES ('5502', '高志学', '15607610661', '132324196704071436', 'z', '1');
INSERT INTO `tourist_info` VALUES ('5503', '刘红翠', '15607610661', '132324196809030729', 'z', '1');
INSERT INTO `tourist_info` VALUES ('5504', '徐先勇', '15003211091', '510221198001025111', 'A1', '0');
INSERT INTO `tourist_info` VALUES ('5505', '张晓霞', '15003211091', '654021199511300425', 'A1', '0');
INSERT INTO `tourist_info` VALUES ('5506', '林文斌', '15003211091', '350203196501011013', 'A1', '0');
INSERT INTO `tourist_info` VALUES ('5507', '吕良山', '13784511032', '450702199207030334', 'B1', '1');
INSERT INTO `tourist_info` VALUES ('5508', '胡力文', '15003211091', '500221198802037620', 'A1', '0');
INSERT INTO `tourist_info` VALUES ('5509', '刘蜻云', '13784511032', '450521199001031540', 'B1', '1');
INSERT INTO `tourist_info` VALUES ('5510', '蔡丽晓', '18810511040', '330381198812015943', 'C1', '1');
INSERT INTO `tourist_info` VALUES ('5511', '鲁淑敏', '18810511040', '362330199906085821', 'C1', '1');
INSERT INTO `tourist_info` VALUES ('5512', '宋鑫', '13784131032', '210402197902060535', 'B1', '1');
INSERT INTO `tourist_info` VALUES ('5513', '尤丹', '13784131032', '210411198107200229', 'B1', '1');
INSERT INTO `tourist_info` VALUES ('5514', '宋奕璠', '13784511032', '210402200704170527', 'B1', '1');
INSERT INTO `tourist_info` VALUES ('5515', '刘景烨', '18810511040', '362330200110160238', 'C1', '1');
INSERT INTO `tourist_info` VALUES ('5516', '黄静莹', '15933618033', '441702199509012827', 'D1', '1');
INSERT INTO `tourist_info` VALUES ('5517', '黄小兵', '18810511040', '362330199912181713', 'C1', '1');
INSERT INTO `tourist_info` VALUES ('5518', '罗荣潮', '13931410018', '441702199501030334', 'E1', '1');
INSERT INTO `tourist_info` VALUES ('5519', '张俊', '18810141040', '362330200003215571', 'C1', '1');
INSERT INTO `tourist_info` VALUES ('5520', '黄应萍', '15933618033', '422201198708137322', 'D1', '1');
INSERT INTO `tourist_info` VALUES ('5521', '王娜娜', '15933618033', '420116199302212427', 'D1', '1');
INSERT INTO `tourist_info` VALUES ('5522', '熊伊伊', '15933618033', '420104199107224320', 'D1', '1');
INSERT INTO `tourist_info` VALUES ('5523', '朱子谦', '13931410018', '342222199107017620', 'E1', '1');
INSERT INTO `tourist_info` VALUES ('5524', '李笑莹', '13931410018', '130183200008290025', 'E1', '1');
INSERT INTO `tourist_info` VALUES ('5525', '张婷', '15933178033', '420923199309065842', 'D1', '1');
INSERT INTO `tourist_info` VALUES ('5526', '泽亮宇', '13931410018', '513326199611020013', 'E1', '1');
INSERT INTO `tourist_info` VALUES ('5527', '吴炜', '13931120018', '360424199707205700', 'E1', '1');
INSERT INTO `tourist_info` VALUES ('5528', '邓碧莹', '13013314007', '452623199710193323', 'F1', '1');
INSERT INTO `tourist_info` VALUES ('5529', '陆玉萍', '13013314007', '452623199806153326', 'F1', '1');
INSERT INTO `tourist_info` VALUES ('5530', '武致远', '13013314007', '372928199804280012', 'F1', '1');
INSERT INTO `tourist_info` VALUES ('5531', '李何丽', '13013314007', '511011199308256266', 'F1', '1');
INSERT INTO `tourist_info` VALUES ('5532', '黎议瞳', '13013314007', '511002199708251249', 'F1', '1');
INSERT INTO `tourist_info` VALUES ('5533', '代明月', '15003211091', '211202199802182542', 'A1', '0');
INSERT INTO `tourist_info` VALUES ('5534', '黄远程', '18783813053', '510922199808260170', 'G1', '1');
INSERT INTO `tourist_info` VALUES ('5535', '何礼添', '18783813053', '440681199708245438', 'G1', '1');
INSERT INTO `tourist_info` VALUES ('5536', '杨帆', '18783163053', '522626199410250418', 'G1', '1');
INSERT INTO `tourist_info` VALUES ('5537', '李旭', '18783163053', '522226199205212824', 'G1', '1');
INSERT INTO `tourist_info` VALUES ('5538', '罗伟林', '18783813053', '442000199812074238', 'G1', '1');
INSERT INTO `tourist_info` VALUES ('5539', '盖青松', '15959212040', '411421199306197232', 'H1', '1');
INSERT INTO `tourist_info` VALUES ('5540', '刘迪', '15959142040', '411421199110194822', 'H1', '1');
INSERT INTO `tourist_info` VALUES ('5541', '韩磊', '15959142040', '430702199310176039', 'H1', '1');
INSERT INTO `tourist_info` VALUES ('5542', '苏钰麟', '18950016036', '440105198406250313', 'I1', '1');
INSERT INTO `tourist_info` VALUES ('5543', '杜亮', '15959142040', '431224199408130014', 'H1', '1');
INSERT INTO `tourist_info` VALUES ('5544', '罗欣', '15959142040', '430122199203237820', 'H1', '1');
INSERT INTO `tourist_info` VALUES ('5545', '余艳婷', '18950016036', '440105198309094224', 'I1', '1');
INSERT INTO `tourist_info` VALUES ('5546', '陈丽思', '18950016036', '440104198311101925', 'I1', '1');
INSERT INTO `tourist_info` VALUES ('5547', '毕士伟', '15859012702', '120111198511120011 ', 'JJ', '1');
INSERT INTO `tourist_info` VALUES ('5548', '万璐', '15859192702', '430623199101295142 ', 'JJ', '1');
INSERT INTO `tourist_info` VALUES ('5549', '高磊', '15859192072', '371102199411192910', 'JJ', '1');
INSERT INTO `tourist_info` VALUES ('5550', '曹梦瑶', '15859012072', '371327199409296428', 'JJ', '1');
INSERT INTO `tourist_info` VALUES ('5551', '尹振伟', '15859012072', '321181199005253171', 'JJ', '1');
INSERT INTO `tourist_info` VALUES ('5552', '罗佳', '18950176036', '510421199611165520', 'I1', '1');
INSERT INTO `tourist_info` VALUES ('5553', '陈德强', '18950016036', '331022198109280213', 'I1', '1');
INSERT INTO `tourist_info` VALUES ('5554', '陈殿芝', '13313819046', '330102198908151265', 'KK', '1');
INSERT INTO `tourist_info` VALUES ('5557', '汪千颀', '13313819046', '620102199303023344', 'KK', '1');
INSERT INTO `tourist_info` VALUES ('5558', '龚匡', '13313169046', '330723199108041024', 'KK', '1');
INSERT INTO `tourist_info` VALUES ('5559', '龚玲玲', '13313819046', '33072319870401102X', 'KK', '1');
INSERT INTO `tourist_info` VALUES ('5560', '杨双超', '15980812035', '530112199607090934', 'LL', '1');
INSERT INTO `tourist_info` VALUES ('5561', '覃涵', '15980112035', '50022519970603741X', 'LL', '1');
INSERT INTO `tourist_info` VALUES ('5562', '屠定丽', '15980812035', '520202199703015521', 'LL', '1');
INSERT INTO `tourist_info` VALUES ('5563', '沈潘', '13023195036', '430122199407231121', 'MM', '1');
INSERT INTO `tourist_info` VALUES ('5564', '陈佳', '13023195036', '500225198901011923', 'MM', '1');
INSERT INTO `tourist_info` VALUES ('5565', '刘密', '13023195036', '430122199309085212', 'MM', '1');
INSERT INTO `tourist_info` VALUES ('5566', '邹鹏', '13313169046', '362528198603281512', 'KK', '1');
INSERT INTO `tourist_info` VALUES ('5567', '邵华', '13023195036', '441424199104246950', 'MM', '1');
INSERT INTO `tourist_info` VALUES ('5568', '陈媛', '13023195036', '44140219940326152X', 'MM', '1');
INSERT INTO `tourist_info` VALUES ('5569', '杨健', '18088100028', '32010319840613227X', 'yj', '1');
INSERT INTO `tourist_info` VALUES ('5570', '徐小红', '18088010028', '510802199003102545', 'yj', '1');
INSERT INTO `tourist_info` VALUES ('5571', '黄建菲', '18088010028', '500235198512150674', 'yj', '1');
INSERT INTO `tourist_info` VALUES ('5572', '周慧萍', '18088010028', '500232198807163983', 'yj', '1');
