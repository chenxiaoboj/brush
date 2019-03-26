/*
Navicat MySQL Data Transfer

Source Server         : localhose
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : brush

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-03-26 22:53:50
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
-- Records of brush_exception_info
-- ----------------------------
INSERT INTO `brush_exception_info` VALUES ('510', '2019-03-17 08:38:56', '曹宇', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c60zJVV-JIEQtY; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=3920ef38aab0d8a2af40518800161cc14643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=8801RkcRnxgqHYdeJmwgkQ', '8801RkcRnxgqHYdeJmwgkQ', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128271|100000000013|10:00:00-10:29:59|83, amount=5, g_batch_type=2, name=曹宇, mobile=18088935596, id_number=362203199107077310, id_number_list[]=362424199201230644, player_name_list[]=梅雅婷, player_mobile_list[]=18088935596, id_number_list[]=362203199206156145, player_name_list[]=罗慧琳, player_mobile_list[]=18088935596, id_number_list[]=450521199105156161, player_name_list[]=周海灵, player_mobile_list[]=18088935596, id_number_list[]=450105199104111517, player_name_list[]=陈煜芃, player_mobile_list[]=18088935596]', '18088935596', '0');
INSERT INTO `brush_exception_info` VALUES ('511', '2019-03-17 08:27:40', '朱树江', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c63WBUVuFPFwha; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=12bdee9dcd272430331d3cae1567a9ad4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=23c4N8lk61t0WyEEJYJZAw', '23c4N8lk61t0WyEEJYJZAw', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=朱树江, mobile=13578384698, id_number=413022197907254017, id_number_list[]=342221198312125013, player_name_list[]=王成云, player_mobile_list[]=13578384698, id_number_list[]=410526198910144884, player_name_list[]=许满园, player_mobile_list[]=13578384698, id_number_list[]=412727198304242010, player_name_list[]=王峰, player_mobile_list[]=13578384698, id_number_list[]=320922198901071139, player_name_list[]=李昭臣, player_mobile_list[]=13578384698]', '13578384698', '1');
INSERT INTO `brush_exception_info` VALUES ('512', '2019-03-17 08:38:56', '耿娜娜', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6hDhUU-5IEwlZ; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=abe1b4a99087525bd17cb12d3bbaa4414643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=f5e7dgqOJma81bUrp2nuWA', 'f5e7dgqOJma81bUrp2nuWA', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128271|100000000013|10:00:00-10:29:59|83, amount=5, g_batch_type=2, name=耿娜娜, mobile=15933678333, id_number=320322198704034264, id_number_list[]=412825199710080288, player_name_list[]=王珂, player_mobile_list[]=15933678333, id_number_list[]=412825200012030270, player_name_list[]=王俊威, player_mobile_list[]=15933678333, id_number_list[]=412825199604050018, player_name_list[]=杨曤珲, player_mobile_list[]=15933678333, id_number_list[]=362203199112157315, player_name_list[]=彭锟, player_mobile_list[]=15933678333]', '15933678333', '0');
INSERT INTO `brush_exception_info` VALUES ('513', '2019-03-17 08:26:40', '吴宇红', '景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6hDZSA-VLGwxZ; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=b347193df6c7725afe31d86c1b3c4bda4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=7511nOPZAXor0aWlr9GukA', '7511nOPZAXor0aWlr9GukA', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=吴宇红, mobile=13632426851, id_number=420106197010260820, id_number_list[]=440682198907272836, player_name_list[]=陈志锋, player_mobile_list[]=13632426851, id_number_list[]=440682198512292824, player_name_list[]=刘海欣, player_mobile_list[]=13632426851, id_number_list[]=420105197706261649, player_name_list[]=吴宇平, player_mobile_list[]=13632426851, id_number_list[]=220521198107153629, player_name_list[]=张家红, player_mobile_list[]=13632426851]', '13632426851', '1');
INSERT INTO `brush_exception_info` VALUES ('514', '2019-03-17 08:38:56', '吴良', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c61DgABOFKFAlc; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=2ab05d090b1b77c289620ab8ef1f87654643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=3523S0izpVgv2ODcc5ENrA', '3523S0izpVgv2ODcc5ENrA', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=吴良, mobile=13769036460, id_number=320404198001062851, id_number_list[]=510524198805185167, player_name_list[]=陆秀英, player_mobile_list[]=13769036460, id_number_list[]=130927199912311215, player_name_list[]=高双庆, player_mobile_list[]=13769036460, id_number_list[]=522323199505306212, player_name_list[]=叶卫, player_mobile_list[]=13769036460, id_number_list[]=522321199508251226, player_name_list[]=严移文, player_mobile_list[]=13769036460]', '13769036460', '0');
INSERT INTO `brush_exception_info` VALUES ('515', '2019-03-17 08:27:41', '何威', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c60zcBV-BNGg9a; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=b29af0b8716571f6a971d880137f17204643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=b103CsIuR9m7N7Nb25GvsQ', 'b103CsIuR9m7N7Nb25GvsQ', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=何威, mobile=13308889446, id_number=440222199211191014, id_number_list[]=440222199301031225, player_name_list[]=梁顺媛, player_mobile_list[]=13308889446, id_number_list[]=650121198908213714, player_name_list[]=哈建彬, player_mobile_list[]=13308889446, id_number_list[]=650121199108253720, player_name_list[]=杨菊, player_mobile_list[]=13308889446, id_number_list[]=320922198705051165, player_name_list[]=李昭君, player_mobile_list[]=13308889446]', '13308889446', '1');
INSERT INTO `brush_exception_info` VALUES ('516', '2019-03-17 08:38:56', '王宏才', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6gDFQWeVLGwhY; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=c922e8a35a47cf266b27e5ecc29728004643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=2e2cFsvdoCmMqlM5ohBeEA', '2e2cFsvdoCmMqlM5ohBeEA', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127906|100000000013|09:30:00-09:59:59|79, amount=5, g_batch_type=2, name=王宏才, mobile=15306099325, id_number=420102195707202036, id_number_list[]=420102196111252045, player_name_list[]=王宏才, player_mobile_list[]=15306099325, id_number_list[]=420106198209192428, player_name_list[]=王黎, player_mobile_list[]=15306099325, id_number_list[]=420112196701232725, player_name_list[]=颜继兰, player_mobile_list[]=15306099325, id_number_list[]=420112199510192728, player_name_list[]=张冰洁, player_mobile_list[]=15306099325]', '15306099325', '0');
INSERT INTO `brush_exception_info` VALUES ('517', '2019-03-17 08:26:40', '郝春海', '景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c60WJRAuRLGghd; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=6bbb643fa4fc6d85a9a25b661796d81e4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=f8242B9gexojDVGFJimUBg', 'f8242B9gexojDVGFJimUBg', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=郝春海, mobile=18559038787, id_number=210202197209140034, id_number_list[]=440682199112263666, player_name_list[]=杜泳桃 , player_mobile_list[]=18559038787, id_number_list[]=440682199008260617, player_name_list[]=董日俊 , player_mobile_list[]=18559038787, id_number_list[]=500232199310053548, player_name_list[]=陈素琼, player_mobile_list[]=18559038787, id_number_list[]=500102199402142149, player_name_list[]=张颖, player_mobile_list[]=18559038787]', '18559038787', '1');
INSERT INTO `brush_exception_info` VALUES ('518', '2019-03-17 08:27:42', '何思旋', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c60zZXVeJMEw5f; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=fe24913a0b99f40fcdabf83a183f793f4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=c3a9vZkG88Px3EG1aWokiA', 'c3a9vZkG88Px3EG1aWokiA', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128636|100000000013|10:30:00-10:59:59|66, amount=5, g_batch_type=2, name=何思旋, mobile=15933666622, id_number=441426199405050348, id_number_list[]=652201199301221220, player_name_list[]=张梦凡, player_mobile_list[]=15933666622, id_number_list[]=610221197802171337, player_name_list[]=孙红卫, player_mobile_list[]=15933666622, id_number_list[]=652201198911280215, player_name_list[]=贺强, player_mobile_list[]=15933666622, id_number_list[]=433002197905121024, player_name_list[]=梁淑华, player_mobile_list[]=15933666622]', '15933666622', '1');
INSERT INTO `brush_exception_info` VALUES ('519', '2019-03-17 08:38:56', '王晨昱 ', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c61DdVB-VKEAlW; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=36ca8780a4d016898238e06aa0e2080f4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=2124FywEjtGyJFK1LVr51w', '2124FywEjtGyJFK1LVr51w', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=王晨昱 , mobile=19908880533, id_number=610121199708045581, id_number_list[]=61012519941012002X, player_name_list[]=司颖 , player_mobile_list[]=19908880533, id_number_list[]=43020219890219102X, player_name_list[]=谢鸿, player_mobile_list[]=19908880533, id_number_list[]=410926199807290038, player_name_list[]=曹然智, player_mobile_list[]=19908880533, id_number_list[]=410926199809010140, player_name_list[]=晁祥璐, player_mobile_list[]=19908880533]', '19908880533', '0');
INSERT INTO `brush_exception_info` VALUES ('520', '2019-03-17 08:27:43', '孟莉', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c61zlVB-9OGg9f; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=aa0c065e07897977ad867a4432bfe31d4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=0942pnWw7pTKEmHlpDBH8A', '0942pnWw7pTKEmHlpDBH8A', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128636|100000000013|10:30:00-10:59:59|66, amount=5, g_batch_type=2, name=孟莉, mobile=13931420118, id_number=513426199701052620, id_number_list[]=513426199501120158, player_name_list[]=朱勋林, player_mobile_list[]=13931420118, id_number_list[]=410181198310017526, player_name_list[]=徐莹瑛, player_mobile_list[]=13931420118, id_number_list[]=232326199205091045, player_name_list[]=王国婷, player_mobile_list[]=13931420118, id_number_list[]=232326197101081054, player_name_list[]=朱锡才, player_mobile_list[]=13931420118]', '13931420118', '1');
INSERT INTO `brush_exception_info` VALUES ('521', '2019-03-17 08:38:56', '胡敏', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6gzQHUeRJEwlZ; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=ce0eec8d59901b70bea76d224cda3c4f4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=e194O49SuT9nt8E0VZ79UQ', 'e194O49SuT9nt8E0VZ79UQ', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128271|100000000013|10:00:00-10:29:59|83, amount=5, g_batch_type=2, name=胡敏, mobile=18783863553, id_number=420104198706210049, id_number_list[]=110102196310090445, player_name_list[]=王静, player_mobile_list[]=18783863553, id_number_list[]=110102199010240417, player_name_list[]=段思铭, player_mobile_list[]=18783863553, id_number_list[]=420102198608190811, player_name_list[]=刘志辉, player_mobile_list[]=18783863553, id_number_list[]=610302198909080516, player_name_list[]=王雨晨, player_mobile_list[]=18783863553]', '18783863553', '0');
INSERT INTO `brush_exception_info` VALUES ('522', '2019-03-17 08:38:56', '刘晓丽', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c602MHBOdDFg5Y; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=e638b16f184df3297a9e3ba0952059694643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=d229TeS4mo0PCzn3QY9SwA', 'd229TeS4mo0PCzn3QY9SwA', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127906|100000000013|09:30:00-09:59:59|79, amount=5, g_batch_type=2, name=刘晓丽, mobile=18605082292, id_number=220102195804192821, id_number_list[]=220102195510092817, player_name_list[]=高勇, player_mobile_list[]=18605082292, id_number_list[]=432524199908086424, player_name_list[]=曹凤, player_mobile_list[]=18605082292, id_number_list[]=432524199804180627, player_name_list[]=陈琦琪, player_mobile_list[]=18605082292, id_number_list[]=412828199407202747, player_name_list[]=齐雪敏, player_mobile_list[]=18605082292]', '18605082292', '0');
INSERT INTO `brush_exception_info` VALUES ('523', '2019-03-17 08:38:56', '丁中连', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6hmJWV-9JGw1d; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=1ec7dea07de53347f598749ebdc73f644643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=81d135u1jIQ8Xg5ZP2hrgg', '81d135u1jIQ8Xg5ZP2hrgg', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128271|100000000013|10:00:00-10:29:59|83, amount=5, g_batch_type=2, name=丁中连, mobile=13720848396, id_number=330121196311308944, id_number_list[]=430524198905162923, player_name_list[]=龙黎, player_mobile_list[]=13720848396, id_number_list[]=43052419870612246X, player_name_list[]=魏爱凤, player_mobile_list[]=13720848396, id_number_list[]=33012119630821893X, player_name_list[]=孙仕华, player_mobile_list[]=13720848396, id_number_list[]=120111199305203021, player_name_list[]=李津 , player_mobile_list[]=13720848396]', '13720848396', '0');
INSERT INTO `brush_exception_info` VALUES ('524', '2019-03-17 08:38:57', '娄亚群', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c61TZUWOFLEghZ; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=549097729decef6dfe5cfe85c8b00a1c4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=ec8cRMWvFw0DwCOnLQiTyw', 'ec8cRMWvFw0DwCOnLQiTyw', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127906|100000000013|09:30:00-09:59:59|79, amount=5, g_batch_type=2, name=娄亚群, mobile=18559287886, id_number=331082199310125822, id_number_list[]=330624199402222425, player_name_list[]=俞倩倩, player_mobile_list[]=18559287886, id_number_list[]=132222197209070432, player_name_list[]=任献志, player_mobile_list[]=18559287886, id_number_list[]=132222197201050429, player_name_list[]=陆春菊, player_mobile_list[]=18559287886, id_number_list[]=342622199010120455, player_name_list[]=吴亚, player_mobile_list[]=18559287886]', '18559287886', '0');
INSERT INTO `brush_exception_info` VALUES ('525', '2019-03-17 08:38:57', '马晨博', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c63DBTVeFLFQFX; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=cd8191c7138e480b698a72d25ec7e8d84643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=7504labSmv6bKAmG6FgoiA', '7504labSmv6bKAmG6FgoiA', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128636|100000000013|10:30:00-10:59:59|66, amount=5, g_batch_type=2, name=马晨博, mobile=17710045777, id_number=22240319900613251X, id_number_list[]=350824199304104972, player_name_list[]=钟宪宏, player_mobile_list[]=17710045777, id_number_list[]=350627199202132524, player_name_list[]=郑碧香, player_mobile_list[]=17710045777, id_number_list[]=500226198609110517, player_name_list[]=邓海波, player_mobile_list[]=17710045777, id_number_list[]=500224198911128766, player_name_list[]=吴媛, player_mobile_list[]=17710045777]', '17710045777', '0');
INSERT INTO `brush_exception_info` VALUES ('526', '2019-03-17 08:38:57', '刘露', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c61jRUUuFOFAlW; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=9fa0698ccfee565410d905083e8936b44643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=3f07MKTEdaAtqv0JNy6e2w', '3f07MKTEdaAtqv0JNy6e2w', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=刘露, mobile=13211992222, id_number=500224199608281965, id_number_list[]=500224199501151968, player_name_list[]=刘艳, player_mobile_list[]=13211992222, id_number_list[]=432524199002280036, player_name_list[]=刘智文, player_mobile_list[]=13211992222, id_number_list[]=432524198406050339, player_name_list[]=陈俊辉, player_mobile_list[]=13211992222, id_number_list[]=432524198811280621, player_name_list[]=刘丹, player_mobile_list[]=13211992222]', '13211992222', '0');
INSERT INTO `brush_exception_info` VALUES ('527', '2019-03-17 08:38:57', '韩淑艳', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c612NSUeBDFwFa; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=71c4f879e9d72ab1c78adec9eccc56334643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=6ea1AenN2UWgRdPzjC1gQg', '6ea1AenN2UWgRdPzjC1gQg', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128636|100000000013|10:30:00-10:59:59|66, amount=5, g_batch_type=2, name=韩淑艳, mobile=13013384507, id_number=232326197609291044, id_number_list[]=232326199407151034, player_name_list[]=朱恒耀, player_mobile_list[]=13013384507, id_number_list[]=330105198604233113, player_name_list[]=董宬男, player_mobile_list[]=13013384507, id_number_list[]=412825196612010055, player_name_list[]=段卫国, player_mobile_list[]=13013384507, id_number_list[]=330522198911023923, player_name_list[]=张子君, player_mobile_list[]=13013384507]', '13013384507', '0');
INSERT INTO `brush_exception_info` VALUES ('528', '2019-03-17 08:27:43', '杨飞', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c60jIFVuRLEgFZ; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=2a1bdcb017007baefaf4cfdad08247b94643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=7a5e83pMR75kQGsp7XNeIg', '7a5e83pMR75kQGsp7XNeIg', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128636|100000000013|10:30:00-10:59:59|66, amount=5, g_batch_type=2, name=杨飞, mobile=17708888360, id_number=610221198710027965, id_number_list[]=610221196904050814, player_name_list[]=李百政, player_mobile_list[]=17708888360, id_number_list[]=610221197312100827, player_name_list[]=成淑宁, player_mobile_list[]=17708888360, id_number_list[]=211221199201130615, player_name_list[]=代志博, player_mobile_list[]=17708888360, id_number_list[]=211202199303222802, player_name_list[]=李佳, player_mobile_list[]=17708888360]', '17708888360', '1');
INSERT INTO `brush_exception_info` VALUES ('529', '2019-03-17 08:38:57', '陈晓冬', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c63GBWWONIFwFa; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=1c43e9bb62b23cb5153a2bbb19f0e3724643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=428cYwNxU3OJNYbTOqEA7w', '428cYwNxU3OJNYbTOqEA7w', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127906|100000000013|09:30:00-09:59:59|79, amount=5, g_batch_type=2, name=陈晓冬, mobile=19906035596, id_number=45090219891212296X, id_number_list[]=430124197907291028, player_name_list[]=颜素琳, player_mobile_list[]=19906035596, id_number_list[]=522425200004245427, player_name_list[]=丁云, player_mobile_list[]=19906035596, id_number_list[]=522425199606200028, player_name_list[]=王世琴, player_mobile_list[]=19906035596, id_number_list[]=210113196604034724, player_name_list[]=陈凤丽, player_mobile_list[]=19906035596]', '19906035596', '0');
INSERT INTO `brush_exception_info` VALUES ('530', '2019-03-17 08:38:57', '李松', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6h2QFVu5KGw5f; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=c6f4ded6eb97f3c19cabf535e0142a8c4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=befaUvbKAbdJzWZyKWQxAw', 'befaUvbKAbdJzWZyKWQxAw', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128636|100000000013|10:30:00-10:59:59|66, amount=5, g_batch_type=2, name=李松, mobile=15003241991, id_number=211221198701160613, id_number_list[]=211202198901161806, player_name_list[]=杨建威, player_mobile_list[]=15003241991, id_number_list[]=410482199001204480, player_name_list[]=韩闪闪, player_mobile_list[]=15003241991, id_number_list[]=410482199004245966, player_name_list[]=陈自华, player_mobile_list[]=15003241991, id_number_list[]=62040219890826007X, player_name_list[]=周生昌, player_mobile_list[]=15003241991]', '15003241991', '0');
INSERT INTO `brush_exception_info` VALUES ('531', '2019-03-17 08:38:57', '程晋鹏', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6hGBTUORLFAtb; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=432e3c6345e874dad58dc1fa9913ed7d4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=cd6ajtAYjxV8vHltqkNbyw', 'cd6ajtAYjxV8vHltqkNbyw', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=程晋鹏, mobile=15126074911, id_number=413026199508254217, id_number_list[]=320922198912054449, player_name_list[]=张玲玲, player_mobile_list[]=15126074911, id_number_list[]=342221198105065118, player_name_list[]=朱伟豪, player_mobile_list[]=15126074911, id_number_list[]=450703198809120910, player_name_list[]=李礼达, player_mobile_list[]=15126074911, id_number_list[]=420102198509302013, player_name_list[]=王伟, player_mobile_list[]=15126074911]', '15126074911', '0');
INSERT INTO `brush_exception_info` VALUES ('532', '2019-03-17 08:38:57', '石梦亚', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c63TkCB-9DGw9Y; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=5fefb666d314e7cf970c9a446bcdf0f74643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=3b6aKGApmQy7KUfOszOATw', '3b6aKGApmQy7KUfOszOATw', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127906|100000000013|09:30:00-09:59:59|79, amount=5, g_batch_type=2, name=石梦亚, mobile=15108399345, id_number=320283199010044865, id_number_list[]=430511199105147023, player_name_list[]=雷娅玲, player_mobile_list[]=15108399345, id_number_list[]=360123199001152448, player_name_list[]=潘娇娇, player_mobile_list[]=15108399345, id_number_list[]=43050219901222402X, player_name_list[]=余缨芝, player_mobile_list[]=15108399345, id_number_list[]=441421199602165521, player_name_list[]=陈春媚, player_mobile_list[]=15108399345]', '15108399345', '0');
INSERT INTO `brush_exception_info` VALUES ('533', '2019-03-17 08:38:57', '樊运泽', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c61mVbAuVKGg5f; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=379d18cdeb20bc019f219d8ba57c595c4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=2503Xq5kg2B3QuMwDgn9xw', '2503Xq5kg2B3QuMwDgn9xw', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128271|100000000013|10:00:00-10:29:59|83, amount=5, g_batch_type=2, name=樊运泽, mobile=18187248008, id_number=522401199408100439, id_number_list[]=152302199409261658, player_name_list[]=张立达, player_mobile_list[]=18187248008, id_number_list[]=450923199710280261, player_name_list[]=陈容, player_mobile_list[]=18187248008, id_number_list[]=452225199907062520, player_name_list[]=何静, player_mobile_list[]=18187248008, id_number_list[]=522401199405014041, player_name_list[]=吴玉, player_mobile_list[]=18187248008]', '18187248008', '0');
INSERT INTO `brush_exception_info` VALUES ('534', '2019-03-17 08:38:57', '于民翔', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6hzFSBeJIFgtf; expires=Sun, 17-Mar-2019 00:28:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=9b00852e34412410a770370f2145a25b4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=339bXcOE5CWTr1UlwgGt9Q', '339bXcOE5CWTr1UlwgGt9Q', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127906|100000000013|09:30:00-09:59:59|79, amount=5, g_batch_type=2, name=于民翔, mobile=17689942675, id_number=210113196301230031, id_number_list[]=445102199311010915, player_name_list[]=黄枬, player_mobile_list[]=17689942675, id_number_list[]=445102199312030627, player_name_list[]=陈晓玲, player_mobile_list[]=17689942675, id_number_list[]=330326199302177424, player_name_list[]=雷小西, player_mobile_list[]=17689942675, id_number_list[]=330206199311153423, player_name_list[]=徐邵波, player_mobile_list[]=17689942675]', '17689942675', '0');
INSERT INTO `brush_exception_info` VALUES ('535', '2019-03-17 08:38:57', '张婷婷', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c61zFQUOBDFgld; expires=Sun, 17-Mar-2019 00:28:46 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=819efbb5bdfe654097e77ccb8f01d33c4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=d351yycl1jWovmxRWzMvdA', 'd351yycl1jWovmxRWzMvdA', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128271|100000000013|10:00:00-10:29:59|83, amount=5, g_batch_type=2, name=张婷婷, mobile=18088000428, id_number=352203199009241023, id_number_list[]=410821198707112021, player_name_list[]=张珍珍 , player_mobile_list[]=18088000428, id_number_list[]=450821198806180692, player_name_list[]=甘展瑞, player_mobile_list[]=18088000428, id_number_list[]=450721198908102665, player_name_list[]=姚永燕, player_mobile_list[]=18088000428, id_number_list[]=320322199112204260, player_name_list[]=耿乐, player_mobile_list[]=18088000428]', '18088000428', '0');
INSERT INTO `brush_exception_info` VALUES ('536', '2019-03-17 08:38:58', '兰婷婷', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6hGVWUOVNFg5d; expires=Sun, 17-Mar-2019 00:28:45 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=a4850d30edc53c76329cc8d2de8e3df54643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=01e2MbIlZndZkTN9T4fY4Q', '01e2MbIlZndZkTN9T4fY4Q', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128636|100000000013|10:30:00-10:59:59|66, amount=5, g_batch_type=2, name=兰婷婷, mobile=18601010927, id_number=530181199809022625, id_number_list[]=530112199212202516, player_name_list[]=朱芝成, player_mobile_list[]=18601010927, id_number_list[]=511023198801021429, player_name_list[]=杨晓莉, player_mobile_list[]=18601010927, id_number_list[]=360103197801183424, player_name_list[]=邓嘉敏, player_mobile_list[]=18601010927, id_number_list[]=222403199210072825, player_name_list[]=孙彤, player_mobile_list[]=18601010927]', '18601010927', '0');
INSERT INTO `brush_exception_info` VALUES ('537', '2019-03-17 08:38:58', '林雷', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6hjcBB-NOEQhd; expires=Sun, 17-Mar-2019 00:28:48 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=95224bbc121cf055ff0afa63441f8c234643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=36f4nvWy16wk3s7pKdbrLA', '36f4nvWy16wk3s7pKdbrLA', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127906|100000000013|09:30:00-09:59:59|79, amount=5, g_batch_type=2, name=林雷, mobile=18505923692, id_number=510303198706231313, id_number_list[]=210123199410230045, player_name_list[]=王畅, player_mobile_list[]=18505923692, id_number_list[]=110103197111251219, player_name_list[]=何闯, player_mobile_list[]=18505923692, id_number_list[]=342501197608076229, player_name_list[]=吴桂红, player_mobile_list[]=18505923692, id_number_list[]=110101197008062062, player_name_list[]=毕京毕, player_mobile_list[]=18505923692]', '18505923692', '0');
INSERT INTO `brush_exception_info` VALUES ('538', '2019-03-17 08:38:58', '马玉军', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6hGBWBO9PFAxf; expires=Sun, 17-Mar-2019 00:28:48 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=32efb0ddc75ef39e10a1e5b3716ce56f4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=24acCKDglRJpUjYwY12GCQ', '24acCKDglRJpUjYwY12GCQ', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128271|100000000013|10:00:00-10:29:59|83, amount=5, g_batch_type=2, name=马玉军, mobile=13769002382, id_number=132801195505264612, id_number_list[]=132801195509104624, player_name_list[]=刘素凤, player_mobile_list[]=13769002382, id_number_list[]=131002198208084629, player_name_list[]=马宁, player_mobile_list[]=13769002382, id_number_list[]=411023199106055628, player_name_list[]=申佳佳, player_mobile_list[]=13769002382, id_number_list[]=411023199101204030, player_name_list[]=任李鹏, player_mobile_list[]=13769002382]', '13769002382', '0');
INSERT INTO `brush_exception_info` VALUES ('539', '2019-03-17 08:38:58', '张燚', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6gGRbUudCGgxY; expires=Sun, 17-Mar-2019 00:28:47 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=76957fe892c329556a13b4090831bf2a4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=f125ftjlXLEpktzYjwExLQ', 'f125ftjlXLEpktzYjwExLQ', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127906|100000000013|09:30:00-09:59:59|79, amount=5, g_batch_type=2, name=张燚, mobile=13097449333, id_number=110101199711171518, id_number_list[]=370111196508011049, player_name_list[]=刘继军, player_mobile_list[]=13097449333, id_number_list[]=370111196611241029, player_name_list[]=闫世梅, player_mobile_list[]=13097449333, id_number_list[]=370111195912021017, player_name_list[]=丁秀武, player_mobile_list[]=13097449333, id_number_list[]=370111196401011057, player_name_list[]=杨维静, player_mobile_list[]=13097449333]', '13097449333', '0');
INSERT INTO `brush_exception_info` VALUES ('540', '2019-03-17 08:38:58', '何永红', '二次获取支付二维码失败-----景区正在出票中，请稍后再支付', '5', '3', '32c61DhXU-xJEglXXhKKeOEqZHQ=32c6gWNXAOFCGgBa; expires=Sun, 17-Mar-2019 00:28:53 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=6195c37b37a4ab59ecc71fafaeda472e4643; path=/', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=9a7fO96dPMpznY3uhYHNgw', '9a7fO96dPMpznY3uhYHNgw', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128271|100000000013|10:00:00-10:29:59|83, amount=5, g_batch_type=2, name=何永红, mobile=13988835069, id_number=500235198407156660, id_number_list[]=120111199205263027, player_name_list[]=孟佳 , player_mobile_list[]=13988835069, id_number_list[]=432522199803243304, player_name_list[]= 李倩, player_mobile_list[]=13988835069, id_number_list[]=430424199808275423, player_name_list[]=罗家遥, player_mobile_list[]=13988835069, id_number_list[]=432522199809264309, player_name_list[]=蒋丽华, player_mobile_list[]=13988835069]', '13988835069', '0');
INSERT INTO `brush_exception_info` VALUES ('541', '2019-03-26 21:45:27', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('542', '2019-03-26 21:45:32', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('543', '2019-03-26 21:45:32', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('544', '2019-03-26 21:45:33', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('545', '2019-03-26 21:45:33', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('546', '2019-03-26 21:45:33', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('547', '2019-03-26 21:45:33', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('548', '2019-03-26 21:45:33', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('549', '2019-03-26 21:45:34', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('550', '2019-03-26 21:45:34', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('551', '2019-03-26 21:45:34', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('552', '2019-03-26 21:45:34', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('553', '2019-03-26 21:45:35', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('554', '2019-03-26 21:45:35', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('555', '2019-03-26 21:45:35', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('556', '2019-03-26 21:45:35', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('557', '2019-03-26 21:45:36', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('558', '2019-03-26 21:45:36', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('559', '2019-03-26 21:45:36', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('560', '2019-03-26 21:45:36', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('561', '2019-03-26 21:45:37', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('562', '2019-03-26 21:45:37', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('563', '2019-03-26 21:45:37', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('564', '2019-03-26 21:45:37', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('565', '2019-03-26 21:45:38', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('566', '2019-03-26 21:45:38', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('567', '2019-03-26 21:45:38', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('568', '2019-03-26 21:45:39', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('569', '2019-03-26 21:45:39', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('570', '2019-03-26 21:45:39', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('571', '2019-03-26 21:45:40', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('572', '2019-03-26 21:45:40', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('573', '2019-03-26 21:45:40', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('574', '2019-03-26 21:45:40', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('575', '2019-03-26 21:45:40', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('576', '2019-03-26 21:45:40', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');
INSERT INTO `brush_exception_info` VALUES ('577', '2019-03-26 21:45:41', null, '4', null, '4', null, null, null, '[goods_id=1843845, pintuan_id=, play_date=2019-03-26, time_slot_damoylxs[]=100000130451|100000000013|13:00:00-13:29:59|100, amount=1, g_batch_type=2, name=陈台, mobile=13114562158, id_number=430903198805124540]', null, 'test');

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
-- Records of brush_ticket_info
-- ----------------------------

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
-- Records of fenzu_entity
-- ----------------------------
INSERT INTO `fenzu_entity` VALUES ('1', 'A', '1|3|4|5|6', '5');
INSERT INTO `fenzu_entity` VALUES ('2', 'AA', '130|132|133|134|135', '5');
INSERT INTO `fenzu_entity` VALUES ('3', 'B', '2|7|8|9|11', '5');
INSERT INTO `fenzu_entity` VALUES ('4', 'BB', '136|138|139|140|141', '5');
INSERT INTO `fenzu_entity` VALUES ('5', 'C', '10|12|13|14|15', '5');
INSERT INTO `fenzu_entity` VALUES ('6', 'CC', '137|142|143|145|147', '5');
INSERT INTO `fenzu_entity` VALUES ('7', 'D', '16|17|18|19|20', '5');
INSERT INTO `fenzu_entity` VALUES ('8', 'DD', '144|146|148|149|151', '5');
INSERT INTO `fenzu_entity` VALUES ('9', 'E', '21|22|23|26|27', '5');
INSERT INTO `fenzu_entity` VALUES ('10', 'EE', '150|152|153|154|156', '5');
INSERT INTO `fenzu_entity` VALUES ('11', 'F', '24|25|28|29|30', '5');
INSERT INTO `fenzu_entity` VALUES ('12', 'FF', '155|157', '2');
INSERT INTO `fenzu_entity` VALUES ('13', 'G', '31|32|33|34|35', '5');
INSERT INTO `fenzu_entity` VALUES ('14', 'H', '36|37|38|39|41', '5');
INSERT INTO `fenzu_entity` VALUES ('15', 'I', '40|42|43|44|47', '5');
INSERT INTO `fenzu_entity` VALUES ('16', 'J', '45|46|48|49|50', '5');
INSERT INTO `fenzu_entity` VALUES ('17', 'K', '51|52|53|54|55', '5');
INSERT INTO `fenzu_entity` VALUES ('18', 'L', '56|57|58|59|60', '5');
INSERT INTO `fenzu_entity` VALUES ('19', 'M', '61|62|63|64|65', '5');
INSERT INTO `fenzu_entity` VALUES ('20', 'N', '66|67|68|69|70', '5');
INSERT INTO `fenzu_entity` VALUES ('21', 'O', '71|72|73|74|75', '5');
INSERT INTO `fenzu_entity` VALUES ('22', 'P', '76|77|78|79|80', '5');
INSERT INTO `fenzu_entity` VALUES ('23', 'Q', '81|82|83|84|85', '5');
INSERT INTO `fenzu_entity` VALUES ('24', 'R', '86|87|88|89|90', '5');
INSERT INTO `fenzu_entity` VALUES ('25', 'S', '91|92|93|94|95', '5');
INSERT INTO `fenzu_entity` VALUES ('26', 'T', '96|97|98|99|100', '5');
INSERT INTO `fenzu_entity` VALUES ('27', 'U', '101|102|103|104|105', '5');
INSERT INTO `fenzu_entity` VALUES ('28', 'V', '106|107|108|109|110', '5');
INSERT INTO `fenzu_entity` VALUES ('29', 'W', '111|112|113|114|115', '5');
INSERT INTO `fenzu_entity` VALUES ('30', 'X', '116|117|118|119|120', '5');
INSERT INTO `fenzu_entity` VALUES ('31', 'Y', '121|122|123|124|125', '5');
INSERT INTO `fenzu_entity` VALUES ('32', 'Z', '126|127|128|129|131', '5');

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
-- Records of success_order_info
-- ----------------------------
INSERT INTO `success_order_info` VALUES ('41', '2019-03-17 08:27:41', 'https://pay.spdb.swiftpass.cn/pay/qrcode?uuid=weixin%3A%2F%2Fwxpay%2Fbizpayurl%3Fpr%3DHd343QY', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=吴宇红, mobile=13632426851, id_number=420106197010260820, id_number_list[]=440682198907272836, player_name_list[]=陈志锋, player_mobile_list[]=13632426851, id_number_list[]=440682198512292824, player_name_list[]=刘海欣, player_mobile_list[]=13632426851, id_number_list[]=420105197706261649, player_name_list[]=吴宇平, player_mobile_list[]=13632426851, id_number_list[]=220521198107153629, player_name_list[]=张家红, player_mobile_list[]=13632426851]', '13632426851', '5', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=7511nOPZAXor0aWlr9GukA', null, '吴宇红', 'https://937707mltg.sjdzp.cn/Miniwx/Index/orderInfo.html?orders_id=7511nOPZAXor0aWlr9GukA');
INSERT INTO `success_order_info` VALUES ('42', '2019-03-17 08:27:42', 'https://pay.spdb.swiftpass.cn/pay/qrcode?uuid=weixin%3A%2F%2Fwxpay%2Fbizpayurl%3Fpr%3DnbhJUyE', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=郝春海, mobile=18559038787, id_number=210202197209140034, id_number_list[]=440682199112263666, player_name_list[]=杜泳桃 , player_mobile_list[]=18559038787, id_number_list[]=440682199008260617, player_name_list[]=董日俊 , player_mobile_list[]=18559038787, id_number_list[]=500232199310053548, player_name_list[]=陈素琼, player_mobile_list[]=18559038787, id_number_list[]=500102199402142149, player_name_list[]=张颖, player_mobile_list[]=18559038787]', '18559038787', '5', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=f8242B9gexojDVGFJimUBg', null, '郝春海', 'https://937707mltg.sjdzp.cn/Miniwx/Index/orderInfo.html?orders_id=f8242B9gexojDVGFJimUBg');
INSERT INTO `success_order_info` VALUES ('43', '2019-03-17 08:29:55', 'https://pay.spdb.swiftpass.cn/pay/qrcode?uuid=weixin%3A%2F%2Fwxpay%2Fbizpayurl%3Fpr%3DwFAZohB', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=朱树江, mobile=13578384698, id_number=413022197907254017, id_number_list[]=342221198312125013, player_name_list[]=王成云, player_mobile_list[]=13578384698, id_number_list[]=410526198910144884, player_name_list[]=许满园, player_mobile_list[]=13578384698, id_number_list[]=412727198304242010, player_name_list[]=王峰, player_mobile_list[]=13578384698, id_number_list[]=320922198901071139, player_name_list[]=李昭臣, player_mobile_list[]=13578384698]', '13578384698', '5', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=23c4N8lk61t0WyEEJYJZAw', null, '朱树江', 'https://937707mltg.sjdzp.cn/Miniwx/Index/orderInfo.html?orders_id=23c4N8lk61t0WyEEJYJZAw');
INSERT INTO `success_order_info` VALUES ('44', '2019-03-17 08:29:57', 'https://pay.spdb.swiftpass.cn/pay/qrcode?uuid=weixin%3A%2F%2Fwxpay%2Fbizpayurl%3Fpr%3D21XD0jN', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000127541|100000000013|09:00:00-09:29:59|75, amount=5, g_batch_type=2, name=何威, mobile=13308889446, id_number=440222199211191014, id_number_list[]=440222199301031225, player_name_list[]=梁顺媛, player_mobile_list[]=13308889446, id_number_list[]=650121198908213714, player_name_list[]=哈建彬, player_mobile_list[]=13308889446, id_number_list[]=650121199108253720, player_name_list[]=杨菊, player_mobile_list[]=13308889446, id_number_list[]=320922198705051165, player_name_list[]=李昭君, player_mobile_list[]=13308889446]', '13308889446', '5', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=b103CsIuR9m7N7Nb25GvsQ', null, '何威', 'https://937707mltg.sjdzp.cn/Miniwx/Index/orderInfo.html?orders_id=b103CsIuR9m7N7Nb25GvsQ');
INSERT INTO `success_order_info` VALUES ('45', '2019-03-17 08:29:57', 'https://pay.spdb.swiftpass.cn/pay/qrcode?uuid=weixin%3A%2F%2Fwxpay%2Fbizpayurl%3Fpr%3DKjecvb5', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128636|100000000013|10:30:00-10:59:59|66, amount=5, g_batch_type=2, name=何思旋, mobile=15933666622, id_number=441426199405050348, id_number_list[]=652201199301221220, player_name_list[]=张梦凡, player_mobile_list[]=15933666622, id_number_list[]=610221197802171337, player_name_list[]=孙红卫, player_mobile_list[]=15933666622, id_number_list[]=652201198911280215, player_name_list[]=贺强, player_mobile_list[]=15933666622, id_number_list[]=433002197905121024, player_name_list[]=梁淑华, player_mobile_list[]=15933666622]', '15933666622', '5', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=c3a9vZkG88Px3EG1aWokiA', null, '何思旋', 'https://937707mltg.sjdzp.cn/Miniwx/Index/orderInfo.html?orders_id=c3a9vZkG88Px3EG1aWokiA');
INSERT INTO `success_order_info` VALUES ('46', '2019-03-17 08:29:58', 'https://pay.spdb.swiftpass.cn/pay/qrcode?uuid=weixin%3A%2F%2Fwxpay%2Fbizpayurl%3Fpr%3DsHVT8Le', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128636|100000000013|10:30:00-10:59:59|66, amount=5, g_batch_type=2, name=孟莉, mobile=13931420118, id_number=513426199701052620, id_number_list[]=513426199501120158, player_name_list[]=朱勋林, player_mobile_list[]=13931420118, id_number_list[]=410181198310017526, player_name_list[]=徐莹瑛, player_mobile_list[]=13931420118, id_number_list[]=232326199205091045, player_name_list[]=王国婷, player_mobile_list[]=13931420118, id_number_list[]=232326197101081054, player_name_list[]=朱锡才, player_mobile_list[]=13931420118]', '13931420118', '5', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=0942pnWw7pTKEmHlpDBH8A', null, '孟莉', 'https://937707mltg.sjdzp.cn/Miniwx/Index/orderInfo.html?orders_id=0942pnWw7pTKEmHlpDBH8A');
INSERT INTO `success_order_info` VALUES ('47', '2019-03-17 08:30:00', 'https://pay.spdb.swiftpass.cn/pay/qrcode?uuid=weixin%3A%2F%2Fwxpay%2Fbizpayurl%3Fpr%3DprMtd71', '[goods_id=1843845, pintuan_id=, play_date=2019-03-17, time_slot_damoylxs[]=100000128636|100000000013|10:30:00-10:59:59|66, amount=5, g_batch_type=2, name=杨飞, mobile=17708888360, id_number=610221198710027965, id_number_list[]=610221196904050814, player_name_list[]=李百政, player_mobile_list[]=17708888360, id_number_list[]=610221197312100827, player_name_list[]=成淑宁, player_mobile_list[]=17708888360, id_number_list[]=211221199201130615, player_name_list[]=代志博, player_mobile_list[]=17708888360, id_number_list[]=211202199303222802, player_name_list[]=李佳, player_mobile_list[]=17708888360]', '17708888360', '5', 'https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=7a5e83pMR75kQGsp7XNeIg', null, '杨飞', 'https://937707mltg.sjdzp.cn/Miniwx/Index/orderInfo.html?orders_id=7a5e83pMR75kQGsp7XNeIg');

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

-- ----------------------------
-- Records of tourist_info
-- ----------------------------
INSERT INTO `tourist_info` VALUES ('1', '吴良', '13769036460', '320404198001062851', 'A', null);
INSERT INTO `tourist_info` VALUES ('2', '何威', '13308889446', '440222199211191014', 'B', null);
INSERT INTO `tourist_info` VALUES ('3', '陆秀英', '13769036460', '510524198805185167', 'A', null);
INSERT INTO `tourist_info` VALUES ('4', '高双庆', '13769036460', '130927199912311215', 'A', null);
INSERT INTO `tourist_info` VALUES ('5', '叶卫', '13769036460', '522323199505306212', 'A', null);
INSERT INTO `tourist_info` VALUES ('6', '严移文', '13769036460', '522321199508251226', 'A', null);
INSERT INTO `tourist_info` VALUES ('7', '梁顺媛', '13308889446', '440222199301031225', 'B', null);
INSERT INTO `tourist_info` VALUES ('8', '哈建彬', '13308889446', '650121198908213714', 'B', null);
INSERT INTO `tourist_info` VALUES ('9', '杨菊', '13308889446', '650121199108253720', 'B', null);
INSERT INTO `tourist_info` VALUES ('10', '朱树江', '13578384698', '413022197907254017', 'C', null);
INSERT INTO `tourist_info` VALUES ('11', '李昭君', '13308889446', '320922198705051165', 'B', null);
INSERT INTO `tourist_info` VALUES ('12', '王成云', '13578384698', '342221198312125013', 'C', null);
INSERT INTO `tourist_info` VALUES ('13', '许满园', '13578384698', '410526198910144884', 'C', null);
INSERT INTO `tourist_info` VALUES ('14', '王峰', '13578384698', '412727198304242010', 'C', null);
INSERT INTO `tourist_info` VALUES ('15', '李昭臣', '13578384698', '320922198901071139', 'C', null);
INSERT INTO `tourist_info` VALUES ('16', '程晋鹏', '15126074911', '413026199508254217', 'D', null);
INSERT INTO `tourist_info` VALUES ('17', '张玲玲', '15126074911', '320922198912054449', 'D', null);
INSERT INTO `tourist_info` VALUES ('18', '朱伟豪', '15126074911', '342221198105065118', 'D', null);
INSERT INTO `tourist_info` VALUES ('19', '李礼达', '15126074911', '450703198809120910', 'D', null);
INSERT INTO `tourist_info` VALUES ('20', '王伟', '15126074911', '420102198509302013', 'D', null);
INSERT INTO `tourist_info` VALUES ('21', '王宏才', '15306099325', '420102195707202036', 'E', null);
INSERT INTO `tourist_info` VALUES ('22', '王宏才', '15306099325', '420102196111252045', 'E', null);
INSERT INTO `tourist_info` VALUES ('23', '王黎', '15306099325', '420106198209192428', 'E', null);
INSERT INTO `tourist_info` VALUES ('24', '林雷', '18505923692', '510303198706231313', 'F', null);
INSERT INTO `tourist_info` VALUES ('25', '王畅', '18505923692', '210123199410230045', 'F', null);
INSERT INTO `tourist_info` VALUES ('26', '颜继兰', '15306099325', '420112196701232725', 'E', null);
INSERT INTO `tourist_info` VALUES ('27', '张冰洁', '15306099325', '420112199510192728', 'E', null);
INSERT INTO `tourist_info` VALUES ('28', '何闯', '18505923692', '110103197111251219', 'F', null);
INSERT INTO `tourist_info` VALUES ('29', '吴桂红', '18505923692', '342501197608076229', 'F', null);
INSERT INTO `tourist_info` VALUES ('30', '毕京毕', '18505923692', '110101197008062062', 'F', null);
INSERT INTO `tourist_info` VALUES ('31', '张燚', '13097449333', '110101199711171518', 'G', null);
INSERT INTO `tourist_info` VALUES ('32', '刘继军', '13097449333', '370111196508011049', 'G', null);
INSERT INTO `tourist_info` VALUES ('33', '闫世梅', '13097449333', '370111196611241029', 'G', null);
INSERT INTO `tourist_info` VALUES ('34', '丁秀武', '13097449333', '370111195912021017', 'G', null);
INSERT INTO `tourist_info` VALUES ('35', '杨维静', '13097449333', '370111196401011057', 'G', null);
INSERT INTO `tourist_info` VALUES ('36', '陈晓冬', '19906035596', '45090219891212296X', 'H', null);
INSERT INTO `tourist_info` VALUES ('37', '颜素琳', '19906035596', '430124197907291028', 'H', null);
INSERT INTO `tourist_info` VALUES ('38', '丁云', '19906035596', '522425200004245427', 'H', null);
INSERT INTO `tourist_info` VALUES ('39', '王世琴', '19906035596', '522425199606200028', 'H', null);
INSERT INTO `tourist_info` VALUES ('40', '于民翔', '17689942675', '210113196301230031', 'I', null);
INSERT INTO `tourist_info` VALUES ('41', '陈凤丽', '19906035596', '210113196604034724', 'H', null);
INSERT INTO `tourist_info` VALUES ('42', '黄枬', '17689942675', '445102199311010915', 'I', null);
INSERT INTO `tourist_info` VALUES ('43', '陈晓玲', '17689942675', '445102199312030627', 'I', null);
INSERT INTO `tourist_info` VALUES ('44', '雷小西', '17689942675', '330326199302177424', 'I', null);
INSERT INTO `tourist_info` VALUES ('45', '娄亚群', '18559287886', '331082199310125822', 'J', null);
INSERT INTO `tourist_info` VALUES ('46', '俞倩倩', '18559287886', '330624199402222425', 'J', null);
INSERT INTO `tourist_info` VALUES ('47', '徐邵波', '17689942675', '330206199311153423', 'I', null);
INSERT INTO `tourist_info` VALUES ('48', '任献志', '18559287886', '132222197209070432', 'J', null);
INSERT INTO `tourist_info` VALUES ('49', '陆春菊', '18559287886', '132222197201050429', 'J', null);
INSERT INTO `tourist_info` VALUES ('50', '吴亚', '18559287886', '342622199010120455', 'J', null);
INSERT INTO `tourist_info` VALUES ('51', '石梦亚', '15108399345', '320283199010044865', 'K', null);
INSERT INTO `tourist_info` VALUES ('52', '雷娅玲', '15108399345', '430511199105147023', 'K', null);
INSERT INTO `tourist_info` VALUES ('53', '潘娇娇', '15108399345', '360123199001152448', 'K', null);
INSERT INTO `tourist_info` VALUES ('54', '余缨芝', '15108399345', '43050219901222402X', 'K', null);
INSERT INTO `tourist_info` VALUES ('55', '陈春媚', '15108399345', '441421199602165521', 'K', null);
INSERT INTO `tourist_info` VALUES ('56', '何思旋', '15933666622', '441426199405050348', 'L', null);
INSERT INTO `tourist_info` VALUES ('57', '张梦凡', '15933666622', '652201199301221220', 'L', null);
INSERT INTO `tourist_info` VALUES ('58', '孙红卫', '15933666622', '610221197802171337', 'L', null);
INSERT INTO `tourist_info` VALUES ('59', '贺强', '15933666622', '652201198911280215', 'L', null);
INSERT INTO `tourist_info` VALUES ('60', '梁淑华', '15933666622', '433002197905121024', 'L', null);
INSERT INTO `tourist_info` VALUES ('61', '杨飞', '17708888360', '610221198710027965', 'M', null);
INSERT INTO `tourist_info` VALUES ('62', '李百政', '17708888360', '610221196904050814', 'M', null);
INSERT INTO `tourist_info` VALUES ('63', '成淑宁', '17708888360', '610221197312100827', 'M', null);
INSERT INTO `tourist_info` VALUES ('64', '代志博', '17708888360', '211221199201130615', 'M', null);
INSERT INTO `tourist_info` VALUES ('65', '李佳', '17708888360', '211202199303222802', 'M', null);
INSERT INTO `tourist_info` VALUES ('66', '李松', '15003241991', '211221198701160613', 'N', null);
INSERT INTO `tourist_info` VALUES ('67', '杨建威', '15003241991', '211202198901161806', 'N', null);
INSERT INTO `tourist_info` VALUES ('68', '韩闪闪', '15003241991', '410482199001204480', 'N', null);
INSERT INTO `tourist_info` VALUES ('69', '陈自华', '15003241991', '410482199004245966', 'N', null);
INSERT INTO `tourist_info` VALUES ('70', '周生昌', '15003241991', '62040219890826007X', 'N', null);
INSERT INTO `tourist_info` VALUES ('71', '兰婷婷', '18601010927', '530181199809022625', 'O', null);
INSERT INTO `tourist_info` VALUES ('72', '朱芝成', '18601010927', '530112199212202516', 'O', null);
INSERT INTO `tourist_info` VALUES ('73', '杨晓莉', '18601010927', '511023198801021429', 'O', null);
INSERT INTO `tourist_info` VALUES ('74', '邓嘉敏', '18601010927', '360103197801183424', 'O', null);
INSERT INTO `tourist_info` VALUES ('75', '孙彤', '18601010927', '222403199210072825', 'O', null);
INSERT INTO `tourist_info` VALUES ('76', '马晨博', '17710045777', '22240319900613251X', 'P', null);
INSERT INTO `tourist_info` VALUES ('77', '钟宪宏', '17710045777', '350824199304104972', 'P', null);
INSERT INTO `tourist_info` VALUES ('78', '郑碧香', '17710045777', '350627199202132524', 'P', null);
INSERT INTO `tourist_info` VALUES ('79', '邓海波', '17710045777', '500226198609110517', 'P', null);
INSERT INTO `tourist_info` VALUES ('80', '吴媛', '17710045777', '500224198911128766', 'P', null);
INSERT INTO `tourist_info` VALUES ('81', '孟莉', '13931420118', '513426199701052620', 'Q', null);
INSERT INTO `tourist_info` VALUES ('82', '朱勋林', '13931420118', '513426199501120158', 'Q', null);
INSERT INTO `tourist_info` VALUES ('83', '徐莹瑛', '13931420118', '410181198310017526', 'Q', null);
INSERT INTO `tourist_info` VALUES ('84', '王国婷', '13931420118', '232326199205091045', 'Q', null);
INSERT INTO `tourist_info` VALUES ('85', '朱锡才', '13931420118', '232326197101081054', 'Q', null);
INSERT INTO `tourist_info` VALUES ('86', '韩淑艳', '13013384507', '232326197609291044', 'R', null);
INSERT INTO `tourist_info` VALUES ('87', '朱恒耀', '13013384507', '232326199407151034', 'R', null);
INSERT INTO `tourist_info` VALUES ('88', '董宬男', '13013384507', '330105198604233113', 'R', null);
INSERT INTO `tourist_info` VALUES ('89', '段卫国', '13013384507', '412825196612010055', 'R', null);
INSERT INTO `tourist_info` VALUES ('90', '张子君', '13013384507', '330522198911023923', 'R', null);
INSERT INTO `tourist_info` VALUES ('91', '胡敏', '18783863553', '420104198706210049', 'S', null);
INSERT INTO `tourist_info` VALUES ('92', '王静', '18783863553', '110102196310090445', 'S', null);
INSERT INTO `tourist_info` VALUES ('93', '段思铭', '18783863553', '110102199010240417', 'S', null);
INSERT INTO `tourist_info` VALUES ('94', '刘志辉', '18783863553', '420102198608190811', 'S', null);
INSERT INTO `tourist_info` VALUES ('95', '王雨晨', '18783863553', '610302198909080516', 'S', null);
INSERT INTO `tourist_info` VALUES ('96', '樊运泽', '18187248008', '522401199408100439', 'T', null);
INSERT INTO `tourist_info` VALUES ('97', '张立达', '18187248008', '152302199409261658', 'T', null);
INSERT INTO `tourist_info` VALUES ('98', '陈容', '18187248008', '450923199710280261', 'T', null);
INSERT INTO `tourist_info` VALUES ('99', '何静', '18187248008', '452225199907062520', 'T', null);
INSERT INTO `tourist_info` VALUES ('100', '吴玉', '18187248008', '522401199405014041', 'T', null);
INSERT INTO `tourist_info` VALUES ('101', '张婷婷', '18088000428', '352203199009241023', 'U', null);
INSERT INTO `tourist_info` VALUES ('102', '张珍珍 ', '18088000428', '410821198707112021', 'U', null);
INSERT INTO `tourist_info` VALUES ('103', '甘展瑞', '18088000428', '450821198806180692', 'U', null);
INSERT INTO `tourist_info` VALUES ('104', '姚永燕', '18088000428', '450721198908102665', 'U', null);
INSERT INTO `tourist_info` VALUES ('105', '耿乐', '18088000428', '320322199112204260', 'U', null);
INSERT INTO `tourist_info` VALUES ('106', '耿娜娜', '15933678333', '320322198704034264', 'V', null);
INSERT INTO `tourist_info` VALUES ('107', '王珂', '15933678333', '412825199710080288', 'V', null);
INSERT INTO `tourist_info` VALUES ('108', '王俊威', '15933678333', '412825200012030270', 'V', null);
INSERT INTO `tourist_info` VALUES ('109', '杨曤珲', '15933678333', '412825199604050018', 'V', null);
INSERT INTO `tourist_info` VALUES ('110', '彭锟', '15933678333', '362203199112157315', 'V', null);
INSERT INTO `tourist_info` VALUES ('111', '曹宇', '18088935596', '362203199107077310', 'W', null);
INSERT INTO `tourist_info` VALUES ('112', '梅雅婷', '18088935596', '362424199201230644', 'W', null);
INSERT INTO `tourist_info` VALUES ('113', '罗慧琳', '18088935596', '362203199206156145', 'W', null);
INSERT INTO `tourist_info` VALUES ('114', '周海灵', '18088935596', '450521199105156161', 'W', null);
INSERT INTO `tourist_info` VALUES ('115', '陈煜芃', '18088935596', '450105199104111517', 'W', null);
INSERT INTO `tourist_info` VALUES ('116', '丁中连', '13720848396', '330121196311308944', 'X', null);
INSERT INTO `tourist_info` VALUES ('117', '龙黎', '13720848396', '430524198905162923', 'X', null);
INSERT INTO `tourist_info` VALUES ('118', '魏爱凤', '13720848396', '43052419870612246X', 'X', null);
INSERT INTO `tourist_info` VALUES ('119', '孙仕华', '13720848396', '33012119630821893X', 'X', null);
INSERT INTO `tourist_info` VALUES ('120', '李津 ', '13720848396', '120111199305203021', 'X', null);
INSERT INTO `tourist_info` VALUES ('121', '何永红', '13988835069', '500235198407156660', 'Y', null);
INSERT INTO `tourist_info` VALUES ('122', '孟佳 ', '13988835069', '120111199205263027', 'Y', null);
INSERT INTO `tourist_info` VALUES ('123', ' 李倩', '13988835069', '432522199803243304', 'Y', null);
INSERT INTO `tourist_info` VALUES ('124', '罗家遥', '13988835069', '430424199808275423', 'Y', null);
INSERT INTO `tourist_info` VALUES ('125', '蒋丽华', '13988835069', '432522199809264309', 'Y', null);
INSERT INTO `tourist_info` VALUES ('126', '马玉军', '13769002382', '132801195505264612', 'Z', null);
INSERT INTO `tourist_info` VALUES ('127', '刘素凤', '13769002382', '132801195509104624', 'Z', null);
INSERT INTO `tourist_info` VALUES ('128', '马宁', '13769002382', '131002198208084629', 'Z', null);
INSERT INTO `tourist_info` VALUES ('129', '申佳佳', '13769002382', '411023199106055628', 'Z', null);
INSERT INTO `tourist_info` VALUES ('130', '吴宇红', '13632426851', '420106197010260820', 'AA', null);
INSERT INTO `tourist_info` VALUES ('131', '任李鹏', '13769002382', '411023199101204030', 'Z', null);
INSERT INTO `tourist_info` VALUES ('132', '陈志锋', '13632426851', '440682198907272836', 'AA', null);
INSERT INTO `tourist_info` VALUES ('133', '刘海欣', '13632426851', '440682198512292824', 'AA', null);
INSERT INTO `tourist_info` VALUES ('134', '吴宇平', '13632426851', '420105197706261649', 'AA', null);
INSERT INTO `tourist_info` VALUES ('135', '张家红', '13632426851', '220521198107153629', 'AA', null);
INSERT INTO `tourist_info` VALUES ('136', '郝春海', '18559038787', '210202197209140034', 'BB', null);
INSERT INTO `tourist_info` VALUES ('137', '王晨昱 ', '19908880533', '610121199708045581', 'CC', null);
INSERT INTO `tourist_info` VALUES ('138', '杜泳桃 ', '18559038787', '440682199112263666', 'BB', null);
INSERT INTO `tourist_info` VALUES ('139', '董日俊 ', '18559038787', '440682199008260617', 'BB', null);
INSERT INTO `tourist_info` VALUES ('140', '陈素琼', '18559038787', '500232199310053548', 'BB', null);
INSERT INTO `tourist_info` VALUES ('141', '张颖', '18559038787', '500102199402142149', 'BB', null);
INSERT INTO `tourist_info` VALUES ('142', '司颖 ', '19908880533', '61012519941012002X', 'CC', null);
INSERT INTO `tourist_info` VALUES ('143', '谢鸿', '19908880533', '43020219890219102X', 'CC', null);
INSERT INTO `tourist_info` VALUES ('144', '刘露', '13211992222', '500224199608281965', 'DD', null);
INSERT INTO `tourist_info` VALUES ('145', '曹然智', '19908880533', '410926199807290038', 'CC', null);
INSERT INTO `tourist_info` VALUES ('146', '刘艳', '13211992222', '500224199501151968', 'DD', null);
INSERT INTO `tourist_info` VALUES ('147', '晁祥璐', '19908880533', '410926199809010140', 'CC', null);
INSERT INTO `tourist_info` VALUES ('148', '刘智文', '13211992222', '432524199002280036', 'DD', null);
INSERT INTO `tourist_info` VALUES ('149', '陈俊辉', '13211992222', '432524198406050339', 'DD', null);
INSERT INTO `tourist_info` VALUES ('150', '刘晓丽', '18605082292', '220102195804192821', 'EE', null);
INSERT INTO `tourist_info` VALUES ('151', '刘丹', '13211992222', '432524198811280621', 'DD', null);
INSERT INTO `tourist_info` VALUES ('152', '高勇', '18605082292', '220102195510092817', 'EE', null);
INSERT INTO `tourist_info` VALUES ('153', '曹凤', '18605082292', '432524199908086424', 'EE', null);
INSERT INTO `tourist_info` VALUES ('154', '陈琦琪', '18605082292', '432524199804180627', 'EE', null);
INSERT INTO `tourist_info` VALUES ('155', '黄锦荣', '18000541755', '452502199503265219', 'FF', null);
INSERT INTO `tourist_info` VALUES ('156', '齐雪敏', '18605082292', '412828199407202747', 'EE', null);
INSERT INTO `tourist_info` VALUES ('157', '高铭', '18000541755', '412828199510160979', 'FF', null);
