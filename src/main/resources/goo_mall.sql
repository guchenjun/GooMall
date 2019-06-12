/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : goo_mall

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 29/05/2019 17:33:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gm_address
-- ----------------------------
DROP TABLE IF EXISTS `gm_address`;
CREATE TABLE `gm_address`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) UNSIGNED NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `receiver_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_userId`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gm_admin
-- ----------------------------
DROP TABLE IF EXISTS `gm_admin`;
CREATE TABLE `gm_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `real_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `e_mail` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `privilege` tinyint(1) NOT NULL DEFAULT 0,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_admin
-- ----------------------------
INSERT INTO `gm_admin` VALUES (1, 'admin', '顾晨俊', '21232f297a57a5a743894a0e4a801fc3', '971733381@qq.com', '18989845722', 1, '2019-05-04 19:41:49', '2019-05-04 19:41:52');

-- ----------------------------
-- Table structure for gm_apply_shop_record
-- ----------------------------
DROP TABLE IF EXISTS `gm_apply_shop_record`;
CREATE TABLE `gm_apply_shop_record`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `shop_id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `admin_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `review_status` tinyint(1) NOT NULL COMMENT '0未审核，1审核通过',
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_apply_shop_record
-- ----------------------------
INSERT INTO `gm_apply_shop_record` VALUES (1, 1, 1, 1, 1, '2019-04-30 22:52:54', '2019-05-04 23:38:11');
INSERT INTO `gm_apply_shop_record` VALUES (2, 1, 2, 1, 1, '2019-04-30 22:54:51', '2019-05-04 23:56:00');
INSERT INTO `gm_apply_shop_record` VALUES (3, 1, 2, 1, 1, '2019-04-30 23:19:56', '2019-05-06 12:27:05');
INSERT INTO `gm_apply_shop_record` VALUES (4, 1, 2, 1, 1, '2019-05-02 22:40:06', '2019-05-04 23:35:30');
INSERT INTO `gm_apply_shop_record` VALUES (5, 1, 2, 1, 1, '2019-05-23 22:40:22', '2019-05-04 23:56:17');

-- ----------------------------
-- Table structure for gm_attr
-- ----------------------------
DROP TABLE IF EXISTS `gm_attr`;
CREATE TABLE `gm_attr`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `attr_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `category2_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_attr
-- ----------------------------
INSERT INTO `gm_attr` VALUES (1, '机身颜色', 6, '2019-05-07 21:53:16', '2019-05-07 21:53:16');
INSERT INTO `gm_attr` VALUES (2, '存储容量', 6, '2019-05-07 21:53:41', '2019-05-07 21:53:41');
INSERT INTO `gm_attr` VALUES (3, '颜色分类', 7, '2019-05-07 21:54:19', '2019-05-07 21:54:19');

-- ----------------------------
-- Table structure for gm_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `gm_attr_value`;
CREATE TABLE `gm_attr_value`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `attr_id` int(10) UNSIGNED NOT NULL,
  `attr_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `attr_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_attr_value
-- ----------------------------
INSERT INTO `gm_attr_value` VALUES (1, 1, '机身颜色', '黑色', '2019-05-07 21:56:17', '2019-05-07 21:56:17');
INSERT INTO `gm_attr_value` VALUES (2, 1, '机身颜色', '白色', '2019-05-07 21:56:56', '2019-05-07 21:56:56');
INSERT INTO `gm_attr_value` VALUES (3, 2, '存储容量', '6G+128G', '2019-05-07 21:57:19', '2019-05-07 21:57:19');
INSERT INTO `gm_attr_value` VALUES (4, 2, '存储容量', '8G+256G', '2019-05-07 21:57:28', '2019-05-07 21:57:28');
INSERT INTO `gm_attr_value` VALUES (5, 3, '颜色分类', '黑色', '2019-05-07 22:12:15', '2019-05-07 22:12:15');
INSERT INTO `gm_attr_value` VALUES (6, 3, '颜色分类', '粉红', '2019-05-07 22:12:33', '2019-05-07 22:12:33');

-- ----------------------------
-- Table structure for gm_brand
-- ----------------------------
DROP TABLE IF EXISTS `gm_brand`;
CREATE TABLE `gm_brand`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_brand
-- ----------------------------
INSERT INTO `gm_brand` VALUES (1, '华为', '2019-05-06 22:04:26', '2019-05-06 22:04:26');
INSERT INTO `gm_brand` VALUES (2, '苹果', '2019-05-06 22:04:31', '2019-05-06 22:04:31');
INSERT INTO `gm_brand` VALUES (3, '小米', '2019-05-06 22:04:34', '2019-05-06 22:04:34');
INSERT INTO `gm_brand` VALUES (4, '三星', '2019-05-06 22:04:43', '2019-05-06 22:04:43');

-- ----------------------------
-- Table structure for gm_brand_category
-- ----------------------------
DROP TABLE IF EXISTS `gm_brand_category`;
CREATE TABLE `gm_brand_category`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `brand_id` int(10) UNSIGNED NOT NULL,
  `category2_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_brand_category
-- ----------------------------
INSERT INTO `gm_brand_category` VALUES (1, 1, 6, '2019-05-06 22:06:43', '2019-05-06 22:06:43');
INSERT INTO `gm_brand_category` VALUES (2, 2, 6, '2019-05-06 22:06:48', '2019-05-06 22:06:48');
INSERT INTO `gm_brand_category` VALUES (3, 3, 6, '2019-05-06 22:06:50', '2019-05-06 22:06:50');
INSERT INTO `gm_brand_category` VALUES (4, 4, 6, '2019-05-06 22:06:53', '2019-05-06 22:06:53');

-- ----------------------------
-- Table structure for gm_category1
-- ----------------------------
DROP TABLE IF EXISTS `gm_category1`;
CREATE TABLE `gm_category1`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `category1_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_category1
-- ----------------------------
INSERT INTO `gm_category1` VALUES (101, '家电', '2019-05-02 14:45:13', '2019-05-02 14:45:13');
INSERT INTO `gm_category1` VALUES (102, '数码', '2019-05-02 14:45:28', '2019-05-02 14:45:28');
INSERT INTO `gm_category1` VALUES (103, '电脑', '2019-05-02 14:45:33', '2019-05-02 14:45:33');
INSERT INTO `gm_category1` VALUES (104, '男装', '2019-05-02 14:45:39', '2019-05-02 14:45:39');
INSERT INTO `gm_category1` VALUES (105, '女装', '2019-05-02 14:45:43', '2019-05-02 14:45:43');
INSERT INTO `gm_category1` VALUES (106, '内衣', '2019-05-02 14:45:47', '2019-05-02 14:45:47');
INSERT INTO `gm_category1` VALUES (107, '箱包', '2019-05-02 14:45:52', '2019-05-02 14:45:52');
INSERT INTO `gm_category1` VALUES (108, '男鞋', '2019-05-02 14:45:57', '2019-05-02 14:45:57');
INSERT INTO `gm_category1` VALUES (109, '女鞋', '2019-05-02 14:46:01', '2019-05-02 14:46:01');
INSERT INTO `gm_category1` VALUES (110, '童装', '2019-05-02 14:46:08', '2019-05-02 14:46:08');
INSERT INTO `gm_category1` VALUES (111, '母婴', '2019-05-02 14:46:16', '2019-05-02 14:46:16');
INSERT INTO `gm_category1` VALUES (112, '玩具', '2019-05-02 14:46:20', '2019-05-02 14:46:20');
INSERT INTO `gm_category1` VALUES (113, '个护', '2019-05-02 14:46:24', '2019-05-02 14:46:24');
INSERT INTO `gm_category1` VALUES (114, '骑行', '2019-05-02 14:46:31', '2019-05-02 14:46:31');
INSERT INTO `gm_category1` VALUES (115, '运动', '2019-05-02 14:46:35', '2019-05-02 14:46:35');
INSERT INTO `gm_category1` VALUES (116, '健身', '2019-05-02 14:46:40', '2019-05-02 14:46:40');
INSERT INTO `gm_category1` VALUES (117, '家装', '2019-05-02 14:46:44', '2019-05-02 14:46:44');
INSERT INTO `gm_category1` VALUES (118, '百货', '2019-05-02 14:46:49', '2019-05-02 14:46:49');

-- ----------------------------
-- Table structure for gm_category2
-- ----------------------------
DROP TABLE IF EXISTS `gm_category2`;
CREATE TABLE `gm_category2`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `category2_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `category1_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_category2
-- ----------------------------
INSERT INTO `gm_category2` VALUES (1, '电视', 101, '2019-05-06 21:36:21', '2019-05-06 21:36:21');
INSERT INTO `gm_category2` VALUES (2, '空调', 101, '2019-05-06 21:36:33', '2019-05-06 21:36:33');
INSERT INTO `gm_category2` VALUES (3, '冰箱', 101, '2019-05-06 21:36:42', '2019-05-06 21:36:42');
INSERT INTO `gm_category2` VALUES (4, '洗衣机', 101, '2019-05-06 21:36:48', '2019-05-06 21:36:48');
INSERT INTO `gm_category2` VALUES (5, '煤气灶', 101, '2019-05-06 21:36:59', '2019-05-06 21:36:59');
INSERT INTO `gm_category2` VALUES (6, '手机', 102, '2019-05-06 21:37:22', '2019-05-06 21:37:22');
INSERT INTO `gm_category2` VALUES (7, '单反相机', 102, '2019-05-06 21:37:30', '2019-05-06 21:37:30');
INSERT INTO `gm_category2` VALUES (8, '数码相机', 102, '2019-05-06 21:37:38', '2019-05-06 21:37:38');
INSERT INTO `gm_category2` VALUES (9, '笔记本', 103, '2019-05-06 21:37:48', '2019-05-06 21:37:48');
INSERT INTO `gm_category2` VALUES (10, '游戏本', 103, '2019-05-06 21:37:57', '2019-05-06 21:37:57');
INSERT INTO `gm_category2` VALUES (11, '台式电脑', 103, '2019-05-06 21:38:13', '2019-05-06 21:38:13');
INSERT INTO `gm_category2` VALUES (12, '衬衫', 104, '2019-05-06 21:38:56', '2019-05-06 21:38:56');
INSERT INTO `gm_category2` VALUES (13, '牛仔裤', 104, '2019-05-06 21:39:05', '2019-05-06 21:39:05');
INSERT INTO `gm_category2` VALUES (14, 'T恤', 104, '2019-05-06 21:39:12', '2019-05-06 21:39:12');
INSERT INTO `gm_category2` VALUES (15, '短裤', 104, '2019-05-06 21:39:19', '2019-05-06 21:39:19');
INSERT INTO `gm_category2` VALUES (16, '连衣裙', 105, '2019-05-06 21:39:47', '2019-05-06 21:39:47');
INSERT INTO `gm_category2` VALUES (17, '衬衫', 105, '2019-05-06 21:39:55', '2019-05-06 21:39:55');
INSERT INTO `gm_category2` VALUES (18, '针织衫', 105, '2019-05-06 21:40:06', '2019-05-06 21:40:06');
INSERT INTO `gm_category2` VALUES (19, '风衣', 105, '2019-05-06 21:40:12', '2019-05-06 21:40:12');
INSERT INTO `gm_category2` VALUES (20, '半身裙', 105, '2019-05-06 21:40:23', '2019-05-06 21:40:23');
INSERT INTO `gm_category2` VALUES (21, '男士内裤', 106, '2019-05-06 21:40:30', '2019-05-06 21:40:30');
INSERT INTO `gm_category2` VALUES (22, '女士内裤', 106, '2019-05-06 21:40:36', '2019-05-06 21:40:36');
INSERT INTO `gm_category2` VALUES (23, '睡衣', 106, '2019-05-06 21:40:42', '2019-05-06 21:40:42');
INSERT INTO `gm_category2` VALUES (24, '文胸', 106, '2019-05-06 21:40:52', '2019-05-06 21:40:52');
INSERT INTO `gm_category2` VALUES (25, '打底裤', 106, '2019-05-06 21:40:59', '2019-05-06 21:40:59');
INSERT INTO `gm_category2` VALUES (26, '丝袜', 106, '2019-05-06 21:41:04', '2019-05-06 21:41:04');
INSERT INTO `gm_category2` VALUES (27, '单肩包', 107, '2019-05-06 21:41:13', '2019-05-06 21:41:13');
INSERT INTO `gm_category2` VALUES (28, '双肩包', 107, '2019-05-06 21:41:20', '2019-05-06 21:41:20');
INSERT INTO `gm_category2` VALUES (29, '钱包', 107, '2019-05-06 21:41:30', '2019-05-06 21:41:30');
INSERT INTO `gm_category2` VALUES (30, ' 拉杆箱', 107, '2019-05-06 21:41:35', '2019-05-06 21:41:35');
INSERT INTO `gm_category2` VALUES (31, '电脑包', 107, '2019-05-06 21:41:42', '2019-05-06 21:41:42');
INSERT INTO `gm_category2` VALUES (32, '跑步鞋', 108, '2019-05-06 21:42:25', '2019-05-06 21:42:25');
INSERT INTO `gm_category2` VALUES (33, '休闲鞋', 108, '2019-05-06 21:42:30', '2019-05-06 21:42:30');
INSERT INTO `gm_category2` VALUES (34, '帆布鞋', 108, '2019-05-06 21:42:36', '2019-05-06 21:42:36');
INSERT INTO `gm_category2` VALUES (35, '拖鞋', 108, '2019-05-06 21:42:41', '2019-05-06 21:42:41');
INSERT INTO `gm_category2` VALUES (36, '高跟鞋', 109, '2019-05-06 21:42:47', '2019-05-06 21:42:47');
INSERT INTO `gm_category2` VALUES (37, '休闲鞋', 109, '2019-05-06 21:44:51', '2019-05-06 21:44:51');
INSERT INTO `gm_category2` VALUES (38, '内增高', 109, '2019-05-06 21:44:58', '2019-05-06 21:44:58');
INSERT INTO `gm_category2` VALUES (39, '女靴', 109, '2019-05-06 21:45:03', '2019-05-06 21:45:03');
INSERT INTO `gm_category2` VALUES (40, '雪地靴', 109, '2019-05-06 21:45:10', '2019-05-06 21:45:10');
INSERT INTO `gm_category2` VALUES (41, '套装', 110, '2019-05-06 21:45:18', '2019-05-06 21:45:18');
INSERT INTO `gm_category2` VALUES (42, '卫衣', 110, '2019-05-06 21:45:25', '2019-05-06 21:45:25');
INSERT INTO `gm_category2` VALUES (43, '裤子', 110, '2019-05-06 21:45:38', '2019-05-06 21:45:38');
INSERT INTO `gm_category2` VALUES (44, '衬衫', 110, '2019-05-06 21:45:44', '2019-05-06 21:45:44');
INSERT INTO `gm_category2` VALUES (45, '奶嘴', 111, '2019-05-06 21:46:12', '2019-05-06 21:46:12');
INSERT INTO `gm_category2` VALUES (46, '吸奶器', 111, '2019-05-06 21:46:21', '2019-05-06 21:46:21');
INSERT INTO `gm_category2` VALUES (47, '儿童餐具', 111, '2019-05-06 21:46:28', '2019-05-06 21:46:28');
INSERT INTO `gm_category2` VALUES (48, '婴儿枕', 111, '2019-05-06 21:46:38', '2019-05-06 21:46:38');
INSERT INTO `gm_category2` VALUES (49, '孕妈装', 111, '2019-05-06 21:46:44', '2019-05-06 21:46:44');
INSERT INTO `gm_category2` VALUES (50, '婴儿推车', 111, '2019-05-06 21:46:49', '2019-05-06 21:46:49');
INSERT INTO `gm_category2` VALUES (51, '婴儿床', 111, '2019-05-06 21:46:55', '2019-05-06 21:46:55');
INSERT INTO `gm_category2` VALUES (52, '益智玩具', 112, '2019-05-06 21:47:27', '2019-05-06 21:47:27');
INSERT INTO `gm_category2` VALUES (53, '橡皮泥', 112, '2019-05-06 21:47:32', '2019-05-06 21:47:32');
INSERT INTO `gm_category2` VALUES (54, '积木拼装', 112, '2019-05-06 21:47:40', '2019-05-06 21:47:40');
INSERT INTO `gm_category2` VALUES (55, '遥控/电动', 112, '2019-05-06 21:47:47', '2019-05-06 21:47:47');
INSERT INTO `gm_category2` VALUES (56, '毛绒玩具', 112, '2019-05-06 21:47:55', '2019-05-06 21:47:55');
INSERT INTO `gm_category2` VALUES (57, '娃娃玩具', 112, '2019-05-06 21:48:01', '2019-05-06 21:48:01');
INSERT INTO `gm_category2` VALUES (58, '牙刷', 113, '2019-05-06 21:48:37', '2019-05-06 21:48:37');
INSERT INTO `gm_category2` VALUES (59, '牙膏', 113, '2019-05-06 21:48:46', '2019-05-06 21:48:46');
INSERT INTO `gm_category2` VALUES (60, '洗发露', 113, '2019-05-06 21:48:54', '2019-05-06 21:48:54');
INSERT INTO `gm_category2` VALUES (61, '护发素', 113, '2019-05-06 21:49:03', '2019-05-06 21:49:03');
INSERT INTO `gm_category2` VALUES (62, '面膜', 113, '2019-05-06 21:49:11', '2019-05-06 21:49:11');
INSERT INTO `gm_category2` VALUES (63, '洗面奶', 113, '2019-05-06 21:49:24', '2019-05-06 21:49:24');
INSERT INTO `gm_category2` VALUES (64, '口红', 113, '2019-05-06 21:49:37', '2019-05-06 21:49:37');
INSERT INTO `gm_category2` VALUES (65, '自行车', 114, '2019-05-06 21:50:19', '2019-05-06 21:50:19');
INSERT INTO `gm_category2` VALUES (66, '山地车', 114, '2019-05-06 21:50:27', '2019-05-06 21:50:27');
INSERT INTO `gm_category2` VALUES (67, '折叠车', 114, '2019-05-06 21:50:32', '2019-05-06 21:50:32');
INSERT INTO `gm_category2` VALUES (68, '电动车', 114, '2019-05-06 21:50:37', '2019-05-06 21:50:37');
INSERT INTO `gm_category2` VALUES (69, '平衡车', 114, '2019-05-06 21:50:42', '2019-05-06 21:50:42');
INSERT INTO `gm_category2` VALUES (70, '乒乓球', 115, '2019-05-06 21:51:05', '2019-05-06 21:51:05');
INSERT INTO `gm_category2` VALUES (71, '羽毛球', 115, '2019-05-06 21:51:11', '2019-05-06 21:51:11');
INSERT INTO `gm_category2` VALUES (72, '篮球', 115, '2019-05-06 21:51:21', '2019-05-06 21:51:21');
INSERT INTO `gm_category2` VALUES (73, '足球', 115, '2019-05-06 21:51:26', '2019-05-06 21:51:26');
INSERT INTO `gm_category2` VALUES (74, '网球', 115, '2019-05-06 21:51:35', '2019-05-06 21:51:35');
INSERT INTO `gm_category2` VALUES (75, '跑步机', 116, '2019-05-06 21:51:41', '2019-05-06 21:51:41');
INSERT INTO `gm_category2` VALUES (76, '动感单车', 116, '2019-05-06 21:51:47', '2019-05-06 21:51:47');
INSERT INTO `gm_category2` VALUES (77, '收腹机/俯卧板', 116, '2019-05-06 21:51:59', '2019-05-06 21:51:59');
INSERT INTO `gm_category2` VALUES (78, '拉力器/臂力器', 116, '2019-05-06 21:52:08', '2019-05-06 21:52:08');
INSERT INTO `gm_category2` VALUES (79, '运动护具', 116, '2019-05-06 21:52:14', '2019-05-06 21:52:14');
INSERT INTO `gm_category2` VALUES (80, '茶几', 117, '2019-05-06 21:52:29', '2019-05-06 21:52:29');
INSERT INTO `gm_category2` VALUES (81, '电脑桌', 117, '2019-05-06 21:52:35', '2019-05-06 21:52:35');
INSERT INTO `gm_category2` VALUES (82, '电视柜', 117, '2019-05-06 21:52:41', '2019-05-06 21:52:41');
INSERT INTO `gm_category2` VALUES (83, '沙发', 117, '2019-05-06 21:52:47', '2019-05-06 21:52:47');
INSERT INTO `gm_category2` VALUES (84, '衣架', 117, '2019-05-06 21:52:53', '2019-05-06 21:52:53');
INSERT INTO `gm_category2` VALUES (85, '床', 117, '2019-05-06 21:52:58', '2019-05-06 21:52:58');
INSERT INTO `gm_category2` VALUES (86, '保温杯', 118, '2019-05-06 21:53:08', '2019-05-06 21:53:08');
INSERT INTO `gm_category2` VALUES (87, '餐具套装', 118, '2019-05-06 21:53:16', '2019-05-06 21:53:16');
INSERT INTO `gm_category2` VALUES (88, '茶壶', 118, '2019-05-06 21:53:23', '2019-05-06 21:53:23');
INSERT INTO `gm_category2` VALUES (89, '垃圾桶', 118, '2019-05-06 21:53:28', '2019-05-06 21:53:28');
INSERT INTO `gm_category2` VALUES (90, '拖把', 118, '2019-05-06 21:53:32', '2019-05-06 21:53:32');
INSERT INTO `gm_category2` VALUES (91, '围裙', 118, '2019-05-06 21:53:37', '2019-05-06 21:53:37');

-- ----------------------------
-- Table structure for gm_shop
-- ----------------------------
DROP TABLE IF EXISTS `gm_shop`;
CREATE TABLE `gm_shop`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(20) UNSIGNED NOT NULL,
  `shop_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `shop_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `shop_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `shop_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `shop_score` decimal(3, 2) NOT NULL,
  `shop_deposit` decimal(9, 2) NOT NULL,
  `shop_account` decimal(9, 2) NOT NULL,
  `shop_status` tinyint(1) NULL DEFAULT NULL COMMENT '0表示未认证通过，1代表通过审核',
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_shop
-- ----------------------------
INSERT INTO `gm_shop` VALUES (1, 1, '小李店铺', '/74dce220-8270-45b4-a21d-b0dabe548692.jpg', '浙江省杭州市杭州师范大学', '专卖华为手机，iPhone，小米等旗舰机', 5.00, 1000.00, 0.00, 1, '2019-04-30 22:52:54', '2019-04-30 22:52:54');
INSERT INTO `gm_shop` VALUES (2, 2, '小张店铺', '/44485392-33e8-46ba-8006-ee438d3f62ff.jpg', '浙江省杭州市杭州师范大学2', '阿迪达斯，耐克，AJ专卖店', 5.00, 2000.00, 0.00, 0, '2019-04-30 22:54:51', '2019-04-30 22:54:51');
INSERT INTO `gm_shop` VALUES (3, 2, '小顾店铺', '/74dce220-8270-45b4-a21d-b0dabe548692.jpg', '浙江省杭州市杭州师范大学2', '阿迪达斯，耐克，AJ专卖店', 5.00, 2000.00, 0.00, 0, '2019-04-30 23:19:56', '2019-04-30 23:19:56');

-- ----------------------------
-- Table structure for gm_shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `gm_shop_cart`;
CREATE TABLE `gm_shop_cart`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) UNSIGNED NOT NULL,
  `spu_id` int(11) UNSIGNED NOT NULL,
  `sku_id` int(11) UNSIGNED NOT NULL,
  `sku_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NOT NULL,
  `amount` int(11) UNSIGNED NOT NULL,
  `attr_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gm_sku
-- ----------------------------
DROP TABLE IF EXISTS `gm_sku`;
CREATE TABLE `gm_sku`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `spu_id` int(10) UNSIGNED NOT NULL,
  `sku_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `stock` int(10) UNSIGNED NOT NULL,
  `is_on` tinyint(10) UNSIGNED NOT NULL COMMENT '0下架，1上架',
  `price` decimal(9, 2) UNSIGNED NOT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_sku
-- ----------------------------
INSERT INTO `gm_sku` VALUES (1, 2, '华为P20【黑色】【6G+128G】', 592, 0, 3299.00, '2019-05-25 15:54:47', '2019-05-25 15:54:47');
INSERT INTO `gm_sku` VALUES (2, 2, '华为P20【黑色】【8G+256G】', 999, 0, 3699.00, '2019-05-25 16:03:52', '2019-05-25 16:03:52');
INSERT INTO `gm_sku` VALUES (3, 2, '华为P20【白色】【6G+128G】', 697, 0, 3299.00, '2019-05-25 16:04:22', '2019-05-25 16:04:22');
INSERT INTO `gm_sku` VALUES (4, 2, '华为P20【白色】【8G+256G】', 899, 0, 3599.00, '2019-05-25 16:05:02', '2019-05-25 16:05:02');

-- ----------------------------
-- Table structure for gm_sku_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `gm_sku_attr_value`;
CREATE TABLE `gm_sku_attr_value`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `spu_id` int(10) UNSIGNED NOT NULL,
  `sku_id` int(10) UNSIGNED NOT NULL,
  `attr_id` int(10) UNSIGNED NOT NULL,
  `attr_value_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_sku_attr_value
-- ----------------------------
INSERT INTO `gm_sku_attr_value` VALUES (1, 2, 1, 1, 1, '2019-05-25 15:54:47', '2019-05-25 15:54:47');
INSERT INTO `gm_sku_attr_value` VALUES (2, 2, 1, 2, 3, '2019-05-25 15:54:47', '2019-05-25 15:54:47');
INSERT INTO `gm_sku_attr_value` VALUES (3, 2, 2, 1, 1, '2019-05-25 16:03:52', '2019-05-25 16:03:52');
INSERT INTO `gm_sku_attr_value` VALUES (4, 2, 2, 2, 4, '2019-05-25 16:03:52', '2019-05-25 16:03:52');
INSERT INTO `gm_sku_attr_value` VALUES (5, 2, 3, 1, 2, '2019-05-25 16:04:22', '2019-05-25 16:04:22');
INSERT INTO `gm_sku_attr_value` VALUES (6, 2, 3, 2, 3, '2019-05-25 16:04:22', '2019-05-25 16:04:22');
INSERT INTO `gm_sku_attr_value` VALUES (7, 2, 4, 1, 2, '2019-05-25 16:05:02', '2019-05-25 16:05:02');
INSERT INTO `gm_sku_attr_value` VALUES (8, 2, 4, 2, 4, '2019-05-25 16:05:02', '2019-05-25 16:05:02');

-- ----------------------------
-- Table structure for gm_sku_image
-- ----------------------------
DROP TABLE IF EXISTS `gm_sku_image`;
CREATE TABLE `gm_sku_image`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sku_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_sku_image
-- ----------------------------
INSERT INTO `gm_sku_image` VALUES (1, '66f0a3cd-fb68-4c79-a96b-f00e7cb574df.png', 1, '2019-05-25 15:54:47', '2019-05-25 15:54:47');
INSERT INTO `gm_sku_image` VALUES (2, 'ec8bcee4-1c86-448f-bea2-07cbfdd29277.jpg', 2, '2019-05-25 16:03:52', '2019-05-25 16:03:52');
INSERT INTO `gm_sku_image` VALUES (3, '9e56bcc2-209c-4218-b305-1d5f73bc0488.jpg', 3, '2019-05-25 16:04:22', '2019-05-25 16:04:22');
INSERT INTO `gm_sku_image` VALUES (4, '78b236b9-52c7-43cb-9232-cfa65c8bcd45.jpg', 4, '2019-05-25 16:05:02', '2019-05-25 16:05:02');

-- ----------------------------
-- Table structure for gm_spu
-- ----------------------------
DROP TABLE IF EXISTS `gm_spu`;
CREATE TABLE `gm_spu`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `spu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `spu_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '封面',
  `category1_id` int(10) UNSIGNED NOT NULL,
  `category2_id` int(10) UNSIGNED NOT NULL,
  `brand_id` int(10) UNSIGNED NOT NULL,
  `shop_id` int(10) UNSIGNED NOT NULL,
  `is_on` tinyint(4) NOT NULL COMMENT '0下架，1上架',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_spu
-- ----------------------------
INSERT INTO `gm_spu` VALUES (1, 'Apple/苹果 iPhone XR 全网通4G手机双卡双待 苹果iPhoneXR 苹果XR 苹果xr', 'ce436c5b-6891-45f4-a4f9-890a5f30b483.png', 102, 6, 2, 1, 0, '苹果手机a', '2019-05-15 23:43:38', '2019-05-15 23:43:38');
INSERT INTO `gm_spu` VALUES (2, '官方正品Huawei/华为P20全网通P20Pro极光色8G+128G/256G手机P30P', 'd0c0d52f-fe25-4093-bcb4-dc99af32e8d4.png', 102, 6, 1, 1, 1, '华为手机', '2019-05-15 23:43:40', '2019-05-15 23:43:40');

-- ----------------------------
-- Table structure for gm_trade_order
-- ----------------------------
DROP TABLE IF EXISTS `gm_trade_order`;
CREATE TABLE `gm_trade_order`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NOT NULL,
  `spu_id` int(10) UNSIGNED NOT NULL,
  `sku_id` int(10) UNSIGNED NOT NULL,
  `sku_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NOT NULL,
  `amount` int(255) UNSIGNED NOT NULL,
  `attr_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000010 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_trade_order
-- ----------------------------
INSERT INTO `gm_trade_order` VALUES (1000001, 1, 2, 2, '华为P20【黑色】【8G+256G】', 'ec8bcee4-1c86-448f-bea2-07cbfdd29277.jpg', 3699.00, 1, '机身颜色:黑色,存储容量:8G+256G', '2019-05-27 18:12:41', '2019-05-27 18:12:41');
INSERT INTO `gm_trade_order` VALUES (1000002, 1, 2, 3, '华为P20【白色】【6G+128G】', '9e56bcc2-209c-4218-b305-1d5f73bc0488.jpg', 3299.00, 3, '机身颜色:白色,存储容量:6G+128G', '2019-05-27 18:23:28', '2019-05-27 18:23:28');
INSERT INTO `gm_trade_order` VALUES (1000003, 1, 2, 4, '华为P20【白色】【8G+256G】', '78b236b9-52c7-43cb-9232-cfa65c8bcd45.jpg', 3599.00, 2, '机身颜色:白色,存储容量:8G+256G', '2019-05-27 18:23:33', '2019-05-27 18:23:33');
INSERT INTO `gm_trade_order` VALUES (1000004, 1, 2, 1, '华为P20【黑色】【6G+128G】', '66f0a3cd-fb68-4c79-a96b-f00e7cb574df.png', 3299.00, 5, '机身颜色:黑色,存储容量:6G+128G', '2019-05-27 23:04:13', '2019-05-27 23:04:13');
INSERT INTO `gm_trade_order` VALUES (1000005, 1, 2, 1, '华为P20【黑色】【6G+128G】', '66f0a3cd-fb68-4c79-a96b-f00e7cb574df.png', 3299.00, 1, '机身颜色:黑色,存储容量:6G+128G', '2019-05-27 23:07:44', '2019-05-27 23:07:44');
INSERT INTO `gm_trade_order` VALUES (1000006, 1, 2, 4, '华为P20【白色】【8G+256G】', '78b236b9-52c7-43cb-9232-cfa65c8bcd45.jpg', 3599.00, 3, '机身颜色:白色,存储容量:8G+256G', '2019-05-28 23:32:16', '2019-05-28 23:32:16');
INSERT INTO `gm_trade_order` VALUES (1000007, 1, 2, 2, '华为P20【黑色】【8G+256G】', 'ec8bcee4-1c86-448f-bea2-07cbfdd29277.jpg', 3699.00, 1, '机身颜色:黑色,存储容量:8G+256G', '2019-05-28 23:33:34', '2019-05-28 23:33:34');
INSERT INTO `gm_trade_order` VALUES (1000008, 1, 2, 2, '华为P20【黑色】【8G+256G】', 'ec8bcee4-1c86-448f-bea2-07cbfdd29277.jpg', 3699.00, 2, '机身颜色:黑色,存储容量:8G+256G', '2019-05-28 23:34:29', '2019-05-28 23:34:29');
INSERT INTO `gm_trade_order` VALUES (1000009, 1, 2, 3, '华为P20【白色】【6G+128G】', '9e56bcc2-209c-4218-b305-1d5f73bc0488.jpg', 3299.00, 2, '机身颜色:白色,存储容量:6G+128G', '2019-05-29 17:07:17', '2019-05-29 17:07:17');

-- ----------------------------
-- Table structure for gm_user
-- ----------------------------
DROP TABLE IF EXISTS `gm_user`;
CREATE TABLE `gm_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `head_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '/default-head-image.jpg',
  `e_mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `experience` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'VIP1（0-600），VIP2（601-1800），...',
  `level` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '1是普通会员；2是VIP2；同理至VIP6',
  `money` decimal(9, 2) NOT NULL DEFAULT 0.00,
  `role` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '0是用户；1是商家',
  `credit` smallint(11) NOT NULL DEFAULT 100 COMMENT '信用度，默认100',
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gm_user
-- ----------------------------
INSERT INTO `gm_user` VALUES (1, 'guchenjun', '顾晨俊', 'c4ca4238a0b923820dcc509a6f75849b', 'b7b60273-308a-40e8-a10b-c24796939aea.png', '971733381@qq.com', '18989845722', 601, 1, 0.00, 1, 100, '2019-04-26 19:15:05', '2019-04-26 19:15:05');
INSERT INTO `gm_user` VALUES (2, 'milen', 'gu chenjun', '9cbf8a4dcb8e30682b927f352d6559a0', 'default-head-image.jpg', '97113@qq.com', '18989845723', 0, 1, 0.00, 1, 100, '2019-04-26 23:21:15', '2019-04-26 23:21:15');
INSERT INTO `gm_user` VALUES (3, 'guchenjun003', 'gu chenjun', '9cbf8a4dcb8e30682b927f352d6559a0', 'default-head-image.jpg', '971733382@qq.com', '18989845723', 0, 1, 0.00, 1, 100, '2019-04-29 21:27:19', '2019-04-29 21:27:19');

SET FOREIGN_KEY_CHECKS = 1;
