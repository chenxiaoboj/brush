/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : brush

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-03-05 00:13:06
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
  `mobile` varchar(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1017 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brush_exception_info
-- ----------------------------
INSERT INTO `brush_exception_info` VALUES ('977', '937707mltg.sjdzp.cn:443 failed to respond', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=邓碧莹, mobile=13013314007, id_number=452623199710193323, id_number_list[]=452623199806153326, player_name_list[]=陆玉萍, player_mobile_list[]=13013314007, id_number_list[]=372928199804280012, player_name_list[]=武致远, player_mobile_list[]=13013314007, id_number_list[]=511011199308256266, player_name_list[]=李何丽, player_mobile_list[]=13013314007, id_number_list[]=511002199708251249, player_name_list[]=黎议瞳, player_mobile_list[]=13013314007]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('978', 'Connect to 112.84.245.179:6915 [/112.84.245.179] failed: Connection refused: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=黄法良, mobile=13097410333, id_number=441621199409284415, id_number_list[]=45010419871010202X, player_name_list[]=陆琳, player_mobile_list[]=13097140333, id_number_list[]=450106195708141520, player_name_list[]=梁燕英, player_mobile_list[]=13097410333, id_number_list[]=441781199502110323, player_name_list[]=赖红妃, player_mobile_list[]=13097410333, id_number_list[]=44178119970918352X, player_name_list[]=肖静文, player_mobile_list[]=13097410333]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('979', 'Connect to 106.59.58.62:4273 [/106.59.58.62] failed: Connection refused: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=袁玲, mobile=15126170911, id_number=421087199010027343, id_number_list[]=432923198209268123, player_name_list[]=阳萍, player_mobile_list[]=15126170911, id_number_list[]=140511198211167526, player_name_list[]=成云霞, player_mobile_list[]=15126010911, id_number_list[]=340122198909143934, player_name_list[]=孙保庆, player_mobile_list[]=15126010911, id_number_list[]=341281199008209140, player_name_list[]=曹艳飞, player_mobile_list[]=15126010911]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('980', 'Connect to 117.29.94.147:4216 [/117.29.94.147] failed: Connection refused: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=黎栩柔, mobile=19908810533, id_number=440181199402198125, id_number_list[]=442000199108180854, player_name_list[]=黄捷满, player_mobile_list[]=19908810533, id_number_list[]=45252819710103536X, player_name_list[]=莫才珍, player_mobile_list[]=19908810533, id_number_list[]=452528197308075406, player_name_list[]=易燕华, player_mobile_list[]=19908810533, id_number_list[]=45252819740228540X, player_name_list[]=易在燕, player_mobile_list[]=19908810533]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('981', 'Connect to 117.67.74.129:4227 [/117.67.74.129] failed: Connection refused: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=李自勇, mobile=17708810360, id_number=530129199702230533, id_number_list[]=513902199811110023, player_name_list[]=徐利平, player_mobile_list[]=17708810360, id_number_list[]=52212819930219002X, player_name_list[]=葛丽 , player_mobile_list[]=17708180360, id_number_list[]=522128198808262014, player_name_list[]=张焕伦, player_mobile_list[]=17708810360, id_number_list[]=513902199904222171, player_name_list[]=汪嘉宾, player_mobile_list[]=17708810360]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('982', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c60zZRUO5IFg9Y; expires=Sun, 03-Mar-2019 09:36:40 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=33ee08a8d6fbc23af936d3ba9a7335e24635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=赵莉, mobile=18505120692, id_number=232331198204192641, id_number_list[]=110103196806241215, player_name_list[]=包振河, player_mobile_list[]=18505910692, id_number_list[]=36223219800115002X, player_name_list[]=雷琴琴, player_mobile_list[]=18505910692, id_number_list[]=110108196008153773, player_name_list[]=鲍海燕, player_mobile_list[]=18505910692, id_number_list[]=110108200705193753, player_name_list[]=鲍雷, player_mobile_list[]=18505120692]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('983', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c61WIAWeVCFg1W; expires=Sun, 03-Mar-2019 09:36:40 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=9225f612616987f17fb81a066a303c594635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=毕士伟, mobile=15859012702, id_number=120111198511120011 , id_number_list[]=430623199101295142 , player_name_list[]=万璐, player_mobile_list[]=15859192702, id_number_list[]=371102199411192910, player_name_list[]=高磊, player_mobile_list[]=15859192072, id_number_list[]=371327199409296428, player_name_list[]=曹梦瑶, player_mobile_list[]=15859012072, id_number_list[]=321181199005253171, player_name_list[]=尹振伟, player_mobile_list[]=15859012072]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('984', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c6gzUGB-dPEw9Y; expires=Sun, 03-Mar-2019 09:36:40 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=48ff1e796a390b5d4975eb10b0d143dd4635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=林锦, mobile=19981120793, id_number=350302199407071637, id_number_list[]=350321199402108428 , player_name_list[]=林秋水, player_mobile_list[]=19981213093, id_number_list[]=53212219910205107X, player_name_list[]=聂忠明, player_mobile_list[]=19981210793, id_number_list[]=532122199312020028, player_name_list[]=高开梅, player_mobile_list[]=19981210793, id_number_list[]=130124199110031286, player_name_list[]=贾韩韩, player_mobile_list[]=19981210793]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('985', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c63WcGAOJLGgBd; expires=Sun, 03-Mar-2019 09:36:40 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=017230364a81da249a9bbca68695a4d14635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=黄静莹, mobile=15933618033, id_number=441702199509012827, id_number_list[]=422201198708137322, player_name_list[]=黄应萍, player_mobile_list[]=15933618033, id_number_list[]=420116199302212427, player_name_list[]=王娜娜, player_mobile_list[]=15933618033, id_number_list[]=420104199107224320, player_name_list[]=熊伊伊, player_mobile_list[]=15933618033, id_number_list[]=420923199309065842, player_name_list[]=张婷, player_mobile_list[]=15933178033]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('986', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c60WJWVOBCEQhX; expires=Sun, 03-Mar-2019 09:36:40 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=b887a569ffcfba47944471731b52fe424635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=刘静, mobile=13211190222, id_number=320321199412177042, id_number_list[]=530111198512281120, player_name_list[]=汤艳, player_mobile_list[]=13211190222, id_number_list[]=530111195308164716, player_name_list[]=汤志明, player_mobile_list[]=13211910222, id_number_list[]=530111200909041117, player_name_list[]=汤俊康, player_mobile_list[]=13211910222, id_number_list[]=530111196306204803, player_name_list[]=孟春兰, player_mobile_list[]=13211910222]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('987', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c6h2RRBONPFw1W; expires=Sun, 03-Mar-2019 09:36:40 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=b516bdebe8efaa3e0568247738f7e6ea4635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=陈殿芝, mobile=13313819046, id_number=330102198908151265, id_number_list[]=620102199303023344, player_name_list[]=汪千颀, player_mobile_list[]=13313819046, id_number_list[]=330723199108041024, player_name_list[]=龚匡, player_mobile_list[]=13313169046, id_number_list[]=33072319870401102X, player_name_list[]=龚玲玲, player_mobile_list[]=13313819046, id_number_list[]=362528198603281512, player_name_list[]=邹鹏, player_mobile_list[]=13313169046]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('988', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c6hjkHV-5JEwBZ; expires=Sun, 03-Mar-2019 09:36:40 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=e785cf65c2d5bdb157e67ce6a706cb904635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=滑星, mobile=18380130301, id_number=110221199102161219, id_number_list[]=330106199307013027, player_name_list[]=金苗苗, player_mobile_list[]=18380310301, id_number_list[]=330106199210133014, player_name_list[]=冯翁熠峰, player_mobile_list[]=18380331301, id_number_list[]=330104198908083322, player_name_list[]=王晨晨, player_mobile_list[]=18380310301, id_number_list[]=330106198909143035, player_name_list[]=吴建飞, player_mobile_list[]=18380310301]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('989', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c6hmdSBeNPGgBZ; expires=Sun, 03-Mar-2019 09:36:40 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=15ec9669a4f422f85069b93b7451c9af4635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=周宏, mobile=18605180292, id_number=432801197606100019, id_number_list[]=431021198708140017, player_name_list[]=陈俊佐, player_mobile_list[]=18605010292, id_number_list[]=150125199411074220, player_name_list[]=燕永霞, player_mobile_list[]=18605010292, id_number_list[]=150125199406150823, player_name_list[]=高蓉蓉, player_mobile_list[]=18605010292, id_number_list[]=411423199301166587, player_name_list[]=马盼盼, player_mobile_list[]=18605010292]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('990', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c6gDhVWeNNFABd; expires=Sun, 03-Mar-2019 09:36:40 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=4737c943fd31627412423c4e6f157c2f4635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=黎芳君, mobile=17732810909, id_number=522131198905203129, id_number_list[]=420683199607140361, player_name_list[]=赵顺蕾, player_mobile_list[]=17732810909, id_number_list[]=420683199809040940, player_name_list[]=柏雨, player_mobile_list[]=17732190909, id_number_list[]=130533199103294422, player_name_list[]=刘欣颖, player_mobile_list[]=17732810909, id_number_list[]=11010620011115181X, player_name_list[]=刘帅 , player_mobile_list[]=17732190909]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('991', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c60mdRUeBMGwBa; expires=Sun, 03-Mar-2019 09:36:40 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=f07d15d1860829d029ca68613012c13a4635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=4, g_batch_type=2, name=陈家昌, mobile=19906010596, id_number=430681200105259316, id_number_list[]=430725199703151689, player_name_list[]=王婧, player_mobile_list[]=19906130596, id_number_list[]=431229199705091623, player_name_list[]=陆依纯, player_mobile_list[]=19906010596, id_number_list[]=342401199308216975 , player_name_list[]=王一政, player_mobile_list[]=19906015096]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('992', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c6h2QHA-FDGgFZ; expires=Sun, 03-Mar-2019 09:36:41 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=ae2582cc3f022e628b34636027913ada4635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=沈潘, mobile=13023195036, id_number=430122199407231121, id_number_list[]=500225198901011923, player_name_list[]=陈佳, player_mobile_list[]=13023195036, id_number_list[]=430122199309085212, player_name_list[]=刘密, player_mobile_list[]=13023195036, id_number_list[]=441424199104246950, player_name_list[]=邵华, player_mobile_list[]=13023195036, id_number_list[]=44140219940326152X, player_name_list[]=陈媛, player_mobile_list[]=13023195036]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('993', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c6hzYFUuJNEwtb; expires=Sun, 03-Mar-2019 09:36:41 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=9f8d788409c10e6565427958a25d2d5a4635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=黄远程, mobile=18783813053, id_number=510922199808260170, id_number_list[]=440681199708245438, player_name_list[]=何礼添, player_mobile_list[]=18783813053, id_number_list[]=522626199410250418, player_name_list[]=杨帆, player_mobile_list[]=18783163053, id_number_list[]=522226199205212824, player_name_list[]=李旭, player_mobile_list[]=18783163053, id_number_list[]=442000199812074238, player_name_list[]=罗伟林, player_mobile_list[]=18783813053]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('994', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c6gzVWUeNNFw1f; expires=Sun, 03-Mar-2019 09:36:41 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=8fcd9ecf95e0b46d0ccc9b572a3641164635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=杨健, mobile=15933160622, id_number=612723199304245613, id_number_list[]=61272319940218042X, player_name_list[]=赵瑞英, player_mobile_list[]=15933610622, id_number_list[]=510681199612030625, player_name_list[]=代文学, player_mobile_list[]=15933610622, id_number_list[]=51068120000409062X, player_name_list[]=陈文翰, player_mobile_list[]=15933610622, id_number_list[]=350426198802061510, player_name_list[]=林义烩, player_mobile_list[]=15933610622]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('995', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c63TNQVe5CFA5Z; expires=Sun, 03-Mar-2019 09:36:41 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=87eaeddff4608c21935efaf432e103054635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=4, g_batch_type=2, name=杨健, mobile=18088100028, id_number=32010319840613227X, id_number_list[]=510802199003102545, player_name_list[]=徐小红, player_mobile_list[]=18088010028, id_number_list[]=500235198512150674, player_name_list[]=黄建菲, player_mobile_list[]=18088010028, id_number_list[]=500232198807163983, player_name_list[]=周慧萍, player_mobile_list[]=18088010028]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('996', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c63DYFVOROEQFa; expires=Sun, 03-Mar-2019 09:36:42 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=ccdb6d8e95dfb69741ccc7f1f02ae3a04635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=3, g_batch_type=2, name=杨双超, mobile=15980812035, id_number=530112199607090934, id_number_list[]=50022519970603741X, player_name_list[]=覃涵, player_mobile_list[]=15980112035, id_number_list[]=520202199703015521, player_name_list[]=屠定丽, player_mobile_list[]=15980812035]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('997', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c63DJbUudPGgxX; expires=Sun, 03-Mar-2019 09:36:43 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=bb5fa5582c2d5a26cac5a37a53d5af774635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=罗荣潮, mobile=13931410018, id_number=441702199501030334, id_number_list[]=342222199107017620, player_name_list[]=朱子谦, player_mobile_list[]=13931410018, id_number_list[]=130183200008290025, player_name_list[]=李笑莹, player_mobile_list[]=13931410018, id_number_list[]=513326199611020013, player_name_list[]=泽亮宇, player_mobile_list[]=13931410018, id_number_list[]=360424199707205700, player_name_list[]=吴炜, player_mobile_list[]=13931120018]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('998', 'Connect to 117.21.111.188:4282 [/117.21.111.188] failed: Connection refused: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=吕良山, mobile=13784511032, id_number=450702199207030334, id_number_list[]=450521199001031540, player_name_list[]=刘蜻云, player_mobile_list[]=13784511032, id_number_list[]=210402197902060535, player_name_list[]=宋鑫, player_mobile_list[]=13784131032, id_number_list[]=210411198107200229, player_name_list[]=尤丹, player_mobile_list[]=13784131032, id_number_list[]=210402200704170527, player_name_list[]=宋奕璠, player_mobile_list[]=13784511032]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('999', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c61zNaA-9LEQtW; expires=Sun, 03-Mar-2019 09:36:47 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=4fac9c032efa641f5299ee5742c4eca74635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=张玉林, mobile=18559210886, id_number=152632197607240706, id_number_list[]=152632199906051525, player_name_list[]=张婷蕾, player_mobile_list[]=18559210886, id_number_list[]=430724199901255044 , player_name_list[]=刘惠妹, player_mobile_list[]=18559217086, id_number_list[]=430281199702059163, player_name_list[]=刘雅文, player_mobile_list[]=18559210886, id_number_list[]=430281197111144826, player_name_list[]=刘冬华, player_mobile_list[]=18559210886]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1000', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c60DgGB-5PGwBZ; expires=Sun, 03-Mar-2019 09:36:44 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=26dc87326fba46f37804f1a34654964d4635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=徐先勇, mobile=15003211091, id_number=510221198001025111, id_number_list[]=654021199511300425, player_name_list[]=张晓霞, player_mobile_list[]=15003211091, id_number_list[]=350203196501011013, player_name_list[]=林文斌, player_mobile_list[]=15003211091, id_number_list[]=500221198802037620, player_name_list[]=胡力文, player_mobile_list[]=15003211091, id_number_list[]=211202199802182542, player_name_list[]=代明月, player_mobile_list[]=15003211091]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1001', 'Connect to 114.100.169.219:4216 [/114.100.169.219] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=陈春瑜, mobile=13769010460, id_number=532701199102260622, id_number_list[]=532401196404291221, player_name_list[]=普美芬, player_mobile_list[]=13769010460, id_number_list[]=530402199105201247, player_name_list[]=薛红艳, player_mobile_list[]=13769010460, id_number_list[]=53270119710816064X, player_name_list[]=普美珍, player_mobile_list[]=13769010460, id_number_list[]=610625199311191129 , player_name_list[]=胡娟娟, player_mobile_list[]=13769016060]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1002', 'Connect to 113.238.67.82:4237 [/113.238.67.82] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=温慧玲, mobile=13578310698, id_number=450721199612034426, id_number_list[]=450721199410113951, player_name_list[]=劳英灿, player_mobile_list[]=13578310698, id_number_list[]=210882199809291227, player_name_list[]=王子慧, player_mobile_list[]=13578310698, id_number_list[]=410881199103025518, player_name_list[]=袁奇鹏, player_mobile_list[]=13578310698, id_number_list[]=410881199303224562, player_name_list[]=李柳明, player_mobile_list[]=13578310698]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1003', 'Connect to 113.225.102.51:4675 [/113.225.102.51] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=叶舒睿, mobile=13988810069, id_number=532502199808080629, id_number_list[]=431227199211112508, player_name_list[]=蒲芬, player_mobile_list[]=13988130069, id_number_list[]=431226199410296024, player_name_list[]=潘茜茜, player_mobile_list[]=13988810069, id_number_list[]=441581199408238215, player_name_list[]=林志亮, player_mobile_list[]=13988810069, id_number_list[]=441501199405116069, player_name_list[]=温碧霞, player_mobile_list[]=13988810069]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1004', 'Connect to 114.234.224.179:4217 [/114.234.224.179] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=周姝, mobile=18559130787, id_number=500109198402181324, id_number_list[]=430524200101101762, player_name_list[]=杨濯嫘, player_mobile_list[]=18559010787, id_number_list[]=430524200005184836, player_name_list[]=刘希, player_mobile_list[]=18559130787, id_number_list[]=42102219991231452X, player_name_list[]=陕茜 , player_mobile_list[]=18559130787, id_number_list[]=411521200006168334, player_name_list[]=李文俊, player_mobile_list[]=18559010787]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1005', 'Connect to 220.165.154.98:4232 [/220.165.154.98] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=邓力, mobile=18088130596, id_number=511324199404093813, id_number_list[]=51012119931231266X, player_name_list[]=张玲玲, player_mobile_list[]=18088910596, id_number_list[]=230184198810155568, player_name_list[]=肖雪娇, player_mobile_list[]=18088910596, id_number_list[]=51130419820723201X, player_name_list[]=易辉, player_mobile_list[]=18088130596, id_number_list[]=532502197109160364, player_name_list[]=舒立辉, player_mobile_list[]=18088910596]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1006', 'Connect to 117.67.75.177:4227 [/117.67.75.177] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=3, g_batch_type=2, name=杭越武, mobile=13308819046, id_number=610625199006161118 , id_number_list[]=120225199010031414, player_name_list[]=张志伟, player_mobile_list[]=13308810446, id_number_list[]=120224199305250749, player_name_list[]=张洪波, player_mobile_list[]=13308810446]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1007', 'Connect to 36.56.149.18:4272 [/36.56.149.18] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=陈业强, mobile=15306010325, id_number=440682198610091014, id_number_list[]=44132219941002643X, player_name_list[]=陈赵宇, player_mobile_list[]=15306010325, id_number_list[]=441322199302113026, player_name_list[]=陈佩琦, player_mobile_list[]=15306010325, id_number_list[]=44068219840919103X, player_name_list[]=谭永健, player_mobile_list[]=15306010325, id_number_list[]=440682199110311345, player_name_list[]=陈丽嫦, player_mobile_list[]=15306010325]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1008', 'Connect to 117.63.101.209:4276 [/117.63.101.209] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=苏钰麟, mobile=18950016036, id_number=440105198406250313, id_number_list[]=440105198309094224, player_name_list[]=余艳婷, player_mobile_list[]=18950016036, id_number_list[]=440104198311101925, player_name_list[]=陈丽思, player_mobile_list[]=18950016036, id_number_list[]=510421199611165520, player_name_list[]=罗佳, player_mobile_list[]=18950176036, id_number_list[]=331022198109280213, player_name_list[]=陈德强, player_mobile_list[]=18950016036]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1009', 'Connect to 112.122.253.27:4676 [/112.122.253.27] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=蔡丽晓, mobile=18810511040, id_number=330381198812015943, id_number_list[]=362330199906085821, player_name_list[]=鲁淑敏, player_mobile_list[]=18810511040, id_number_list[]=362330200110160238, player_name_list[]=刘景烨, player_mobile_list[]=18810511040, id_number_list[]=362330199912181713, player_name_list[]=黄小兵, player_mobile_list[]=18810511040, id_number_list[]=362330200003215571, player_name_list[]=张俊, player_mobile_list[]=18810141040]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1010', 'Connect to 182.244.169.89:4252 [/182.244.169.89] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=邵晓青, mobile=18000510755, id_number=310113198410232426, id_number_list[]=320522199309091635, player_name_list[]=吉鸿飞, player_mobile_list[]=18000510755, id_number_list[]=445121199310123968, player_name_list[]=陈伊敏, player_mobile_list[]=18000510755, id_number_list[]=445121199601203968, player_name_list[]=陈伊琳, player_mobile_list[]=18000510755, id_number_list[]=440521197301231340, player_name_list[]=陈淑芸, player_mobile_list[]=18000510755]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1011', 'Connect to 182.247.183.180:4281 [/182.247.183.180] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=张剑杰, mobile=17689910675, id_number=532425199804101014, id_number_list[]=411402199108268520, player_name_list[]=王利增, player_mobile_list[]=17689910675, id_number_list[]=532524199511283829, player_name_list[]=陈雪娇, player_mobile_list[]=17689910675, id_number_list[]=530421199604150324, player_name_list[]=罗雪, player_mobile_list[]=17689140675, id_number_list[]=530427199610110722, player_name_list[]=方能花, player_mobile_list[]=17689910675]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1012', 'Connect to 112.252.194.103:8878 [/112.252.194.103] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=闫宸昊, mobile=13601310731, id_number=130104199110281837, id_number_list[]=13013019920512153X, player_name_list[]=高松, player_mobile_list[]=13601130731, id_number_list[]=130104196411091830, player_name_list[]=闫静辉, player_mobile_list[]=13601310731, id_number_list[]=130104196510041345, player_name_list[]=高志敏, player_mobile_list[]=13601310731, id_number_list[]=130130199110220228, player_name_list[]=郝晔, player_mobile_list[]=13601130731]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1013', 'Connect to 125.111.150.251:4205 [/125.111.150.251] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=盖青松, mobile=15959212040, id_number=411421199306197232, id_number_list[]=411421199110194822, player_name_list[]=刘迪, player_mobile_list[]=15959142040, id_number_list[]=430702199310176039, player_name_list[]=韩磊, player_mobile_list[]=15959142040, id_number_list[]=431224199408130014, player_name_list[]=杜亮, player_mobile_list[]=15959142040, id_number_list[]=430122199203237820, player_name_list[]=罗欣, player_mobile_list[]=15959142040]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1014', 'Connect to 182.109.131.231:4276 [/182.109.131.231] failed: connect timed out', '32c60WUGVexJEglXXhKLfOAlZXY=32c63DNVUuBDGghc; expires=Sun, 03-Mar-2019 09:36:52 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=45de2e547c02473495db95ddcf81a0674635; path=/', '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=陈杰, mobile=15108190345, id_number=511526198906292731, id_number_list[]=511526199303182749, player_name_list[]=陈敏, player_mobile_list[]=15108190345, id_number_list[]=512533196906282723, player_name_list[]=罗家翠, player_mobile_list[]=15108310345, id_number_list[]=512533196707162710, player_name_list[]=陈小兵, player_mobile_list[]=15108310345, id_number_list[]=511526199709103043, player_name_list[]=李世珍, player_mobile_list[]=15108310345]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1015', '只能购买最近1天内日期', '32c60WUGVexJEglXXhKLfOAlZXY=32c6gzEHUuJKEwFa; expires=Sun, 03-Mar-2019 09:36:46 GMT; Max-Age=120; path=/Miniwx/Index/; PHPSESSID=85723667a1fefcedcf8bc9c1ebf6010c4635; path=/', '2', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=4, g_batch_type=2, name=何云凡, mobile=15607610661, id_number=420684198910285549, id_number_list[]=440825198109292158, player_name_list[]=林权, player_mobile_list[]=15607190661, id_number_list[]=132324196704071436, player_name_list[]=高志学, player_mobile_list[]=15607610661, id_number_list[]=132324196809030729, player_name_list[]=刘红翠, player_mobile_list[]=15607610661]', '2019-03-03 17:34:40', null, null);
INSERT INTO `brush_exception_info` VALUES ('1016', 'Connect to 220.186.135.239:2316 [/220.186.135.239] failed: Connection timed out: connect', null, '4', null, null, '[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=胡鹏鹏, mobile=13632410851, id_number=360121198910262436, id_number_list[]=360111199110231027, player_name_list[]=徐和艳, player_mobile_list[]=13632410851, id_number_list[]=34242319930621208X, player_name_list[]=李运华, player_mobile_list[]=13632410851, id_number_list[]=41152419910302407X, player_name_list[]=唐永洋, player_mobile_list[]=13632410851, id_number_list[]=210902199403292063, player_name_list[]=李梓源, player_mobile_list[]=13632410851]', '2019-03-03 17:34:40', null, null);

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
  `order_id_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=814 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of success_order_info
-- ----------------------------

-- ----------------------------
-- Table structure for tourist_info
-- ----------------------------
DROP TABLE IF EXISTS `tourist_info`;
CREATE TABLE `tourist_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `id_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
  `remarks` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
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
