/*
 Navicat Premium Data Transfer

 Source Server         : 服装
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 101.200.149.111:3306
 Source Schema         : sharebook

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 30/11/2019 15:23:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for booktypeinfo
-- ----------------------------
DROP TABLE IF EXISTS `booktypeinfo`;
CREATE TABLE `booktypeinfo`  (
  `isbn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `summary` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pubplace` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pubdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `binding` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_pub` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`isbn`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of booktypeinfo
-- ----------------------------
INSERT INTO `booktypeinfo` VALUES ('123', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `booktypeinfo` VALUES ('9787302147510', '数据结构', '', 'http://api.jisuapi.com/isbn/upload/395/394609.png', '30.00', '严蔚敏 吴伟民', '《数据结构》（C语言版）是为“数据结构”课程编写的教材，也可作为学习数据结构及其算法的C程序设计的参数教材。\n本书的前半部分从抽象数据类型的角度讨论各种基本类型的数据结构及其应用；后半部分主要讨论查找和排序的各种实现方法及其综合分析比较。其内容和章节编排1992年4月出版的《数据结构》（第二版）基本一致，但在本书中更突出了抽象数据类型的概念。全书采用类C语言作为数据结构和算法的描述语言。\n本书概念表述严谨，逻辑推理严密，语言精炼，用词达意，并有配套出版的《数据结构题集》（C语言版），便于教学，又便于自学。\n本书后附有光盘。光盘内容可在DOS环境下运行的以类C语言描述的“数据结构算法动态模拟辅助教学软件，以及在Windows环境下运行的以类PASCAL或类C两种语言描述的“数据结构算法动态模拟辅助教学软件”。\n本书可作为计算机类专业或信息类相关专业的本科或专科教材，也可供从事计算机工程与应用工作的科技工作者参考。', '清华大学出版社', NULL, '2007-3-1', '平装', NULL, NULL, NULL);
INSERT INTO `booktypeinfo` VALUES ('9787111445203', '计算机网络', NULL, 'http://api.jisuapi.com/isbn/upload/12/2664312.jpg', '49.00', '王相林著', '本书采用“自顶向下方法”讲解计算机网络的体系结构，介绍计算机网络的理论、技术和应用。结合生活知识辅助计算机网络理论讲解，采用深入浅出的方法描述计算机网络关键知识点。内容涵盖：计算机网络基础知识、自顶向下的5层计算机网络体系结构和网络协议、计算机网络管理和安全基础、IPv6技术。', '机械工业出版社', '北京', '2013-10', '平装', NULL, NULL, NULL);
INSERT INTO `booktypeinfo` VALUES ('9787040396638', '高等数学（第七版', '', 'http://api.jisuapi.com/isbn/upload/63/286963.jpg', '137.40', '同济大学数学系', '《高等数学》第7版是“十二五”普通高等教育本科国家级规划教材，在第6版的基础上作了进一步的修订。新版教材在保留原教材结构严谨，逻辑清晰、叙述详细、通俗易懂、例题较多、便于自学等优点的基础上，对教材深广度进行了适度的调整，使其更适合当前教学的需要；同时吸收了国外优秀教材的优点，对习题作了较多调整和充实；对全书内容作了进一步的锤炼和适当的调整， 使其能更好满足高等教育进入大众化的新要求。本书上册的主要内容包括函数与极限、导数与微分、微分中值定理与导数的应用、不定积分、定积分及其应用、微分方程等，主要供高等工科院校各专业本科生使用，也可供科技工作者阅读。', '高等教育出版社', '北京', '2014-07-01', '平装', NULL, NULL, NULL);
INSERT INTO `booktypeinfo` VALUES ('9787040396621', '包邮', '', 'http://api.jisuapi.com/isbn/upload/94/587794.jpg', '146.40', '同济大学数学系', '《高等数学》第7版是“十二五”普通高等教育本科国家级规划教材，在第6版的基础上作了进一步的修订。新版教材在保留原教材结构严谨，逻辑清晰、叙述详细、通俗易懂、例题较多、便于自学等优点的基础上，对教材深广度进行了适度的调整，使其更适合当前教学的需要；同时吸收了国外优秀教材的优点，对习题作了较多调整和充实；对全书内容作了进一步的锤炼和适当的调整， 使其能更好满足高等教育进入大众化的新要求。本书下册的主要内容包括空间解析几何与向量代数、多元函数微分法及其应用、重积分、曲线积分与曲面积分、无穷级数等内容，主要供高等工科院校各专业本科生使用，也可供科技工作者阅读。', '高等教育', '北京', '2014-08-01', '平装', NULL, NULL, NULL);
INSERT INTO `booktypeinfo` VALUES ('9787040238969', '概率论与数理统计', '第4版', 'http://api.jisuapi.com/isbn/upload/395/394292.jpg', '34.70', '盛骤 谢式千 潘承毅', '', '高等教育出版社', '北京', '2010-10', '平装', NULL, NULL, NULL);
INSERT INTO `booktypeinfo` VALUES ('9787111407010', '算法导论', '计算机科学丛书', 'http://api.jisuapi.com/isbn/upload/63/2777963.jpg', '128.00', ' (美) 科曼 (Cormen,T.H.) , 等著', '本书提供了对当代计算机算法研究的一个全面、综合性的介绍。全书共八部分，内容涵盖基础知识、排序和顺序统计量、数据结构、高级设计和分析技术、高级数据结构、图算法、算法问题选编，以及数学基础知识。书中深入浅出地介绍了大量的算法及相关的数据结构，以及用于解决一些复杂计算问题的高级策略（如动态规划、贪心算法、摊还分析等），重点在于算法的分析与设计', '机械工业出版社', '北京', '2013-1', '平装', NULL, NULL, NULL);
INSERT INTO `booktypeinfo` VALUES ('9787121328480', '游戏运营', '', 'http://api.jisuapi.com/isbn//upload/3265/3264807.jpg', '79.00', '饭大官人, 著', '这是一本系统的，成体系的，注重运营效能、强化系统思维、提升专业认知的书籍。内容几乎完整覆盖了一个游戏运营人员日常工作中的方方面面，并从工作中具体的业务场景出发，归纳整理总结出各种解决问题的方法论。本书为广大游戏从业者建立了完整的知识技能成长体系，包含：两大岗位基本功——内容输出和协作推进，四大职业技能——活动策划、版本管理、用户运营、数据分析，三大通用能力——学习、管理、沟通能力。各个章节均独立成文，每篇内容至少深入解决一个问题。如果你是一个工作0~2年的运营新人，顺着读下去，相信本书中的一些技巧能够快速帮你确认部门内的核心地位。如果你是一个2~5年的运营人，建议你带着问题从各个章节中寻找答案，获取方法论后应用到自己的工作之中，相信你一定会收获比过往更满意的结果。', '电子工业出版社', '北京', '2018-1', '平装', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (163);
INSERT INTO `hibernate_sequence` VALUES (163);
INSERT INTO `hibernate_sequence` VALUES (163);

-- ----------------------------
-- Table structure for postedbook
-- ----------------------------
DROP TABLE IF EXISTS `postedbook`;
CREATE TABLE `postedbook`  (
  `rent_id` int(16) NOT NULL,
  `book_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_pub` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cata` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deadline` date NULL DEFAULT NULL,
  `deposit` double NULL DEFAULT NULL,
  `isbn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `rent_book_id` bigint(20) NULL DEFAULT NULL,
  `rent_time` int(20) NULL DEFAULT NULL,
  `rent_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unused1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unused2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unused3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unused4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rent_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of postedbook
-- ----------------------------
INSERT INTO `postedbook` VALUES (159, '饭大官人, 著', '游戏运营', NULL, '0', '2047-04-16', NULL, '9787121328480', '/img/1575090555341.jpg', NULL, NULL, 33, NULL, 9999, 'ovcQ95bRwtBpNTe8rnNBejZ8REdY', 'deleted', NULL, NULL, NULL, NULL);
INSERT INTO `postedbook` VALUES (160, ' (美) 科曼 (Cormen,T.H.) , 等著', '算法导论', NULL, '0', '2047-04-16', NULL, '9787111407010', '/img/1575091066445.jpg', NULL, NULL, 23, NULL, 9999, 'ovcQ95bRwtBpNTe8rnNBejZ8REdY', 'rented', NULL, NULL, NULL, NULL);
INSERT INTO `postedbook` VALUES (162, ' (美) 科曼 (Cormen,T.H.) , 等著', '算法导论', NULL, '0', '2047-04-16', NULL, '9787111407010', '/img/1575092820156.jpg', NULL, NULL, 342, NULL, 9999, 'ovcQ95bRwtBpNTe8rnNBejZ8REdY', 'posted', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for rent_record
-- ----------------------------
DROP TABLE IF EXISTS `rent_record`;
CREATE TABLE `rent_record`  (
  `rent_recorder_id` int(16) NOT NULL,
  `cata` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expire_time` datetime(0) NULL DEFAULT NULL,
  `rent_id` int(16) NULL DEFAULT NULL,
  `rent_time` datetime(0) NULL DEFAULT NULL,
  `renter_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unused1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unused2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unused3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unused4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rent_recorder_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rent_record
-- ----------------------------
INSERT INTO `rent_record` VALUES (161, '0', '2293-09-13 13:21:12', 160, '2019-11-30 13:21:12', 'ovcQ95bRwtBpNTe8rnNBejZ8REdY', 'payed', '算法导论', '/img/1575091066445.jpg', '23.0', '99999');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authentication` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authentication_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `balance` double unsigned zerofill NULL,
  `idcard_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_stdnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_tel_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', NULL, NULL, '', NULL, 0000000000000000000153, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users` VALUES ('123', NULL, NULL, NULL, NULL, 0000000000000000000123, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users` VALUES ('1233', NULL, NULL, NULL, NULL, 0000000000000000000123, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users` VALUES ('ovcQ95bRwtBpNTe8rnNBejZ8REdY', NULL, NULL, NULL, NULL, 0000000000000008535919, NULL, NULL, NULL, NULL, NULL, '17367098458854');

SET FOREIGN_KEY_CHECKS = 1;
