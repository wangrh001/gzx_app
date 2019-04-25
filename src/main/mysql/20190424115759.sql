/*
 Navicat MySQL Backup

 Source Server         : gzx
 Source Server Version : 80011
 Source Host           : localhost
 Source Database       : gzx

 Target Server Version : 80011
 File Encoding         : utf-8

 Date: 04/24/2019 11:57:59 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cfg_account_account_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_account_account_state`;
CREATE TABLE `cfg_account_account_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_account_account_state`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_account_account_state` VALUES ('1', '有效'), ('2', '作废'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_account_balance`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_account_balance`;
CREATE TABLE `cfg_account_balance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1、资产；2、负债；3、所有者权益；4、损益',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_account_balance`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_account_balance` VALUES ('1', '1001', '库存现金', '1'), ('3', '1002', '银行存款', '1'), ('4', '1121', '应收票据', '1'), ('5', '1122', '应收帐款	', '1'), ('6', '1123', '预付帐款', '1'), ('7', '1132', '应收利息', '1'), ('8', '1231', '其它应收款', '1'), ('9', '1241', '坏帐准备', '1'), ('10', '1601', '固定资产', '1'), ('11', '2001', '短期借款', '2'), ('12', '2202', '应付帐款', '2'), ('13', '2205', '预收帐款', '2'), ('14', '2211', '应付职工薪酬', '2'), ('15', '2221', '应交税费', '2'), ('16', '2232', '应付利息', '2'), ('17', '2241', '其他应付款', '2'), ('18', '2231', '应付股利', '2'), ('19', '4001', '实收资本', '3'), ('20', '4002', '资本公积', '3'), ('21', '4101', '盈余公积', '3'), ('22', '4103', '本年利润', '3'), ('23', '4104', '利润分配', '3'), ('24', '6001', '主营业务收入', '4'), ('25', '6011', '利息收入', '4'), ('26', '6021', '手续费收入', '4'), ('27', '6301', '营业外收入', '4'), ('28', '6401', '主营业务成本', '5'), ('29', '6405', '营业税金及附加', '5'), ('30', '6411', '利息支出', '5'), ('31', '6421', '手续费支出', '5'), ('32', '6601', '销售费用', '5'), ('33', '6602', '管理费用', '5'), ('34', '6603', '财务费用', '5'), ('35', '6711', '营业外支出', '5'), ('36', '6801', '所得税', '5'), ('37', '1003', '短期贷款', '1'), ('38', '1004', '长期贷款', '1'), ('39', '2002', '长期借款', '2');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_account_bank`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_account_bank`;
CREATE TABLE `cfg_account_bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_account_bank`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_account_bank` VALUES ('0', '全部'), ('1', '中国银行'), ('2', '建设银行'), ('3', '工商银行');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_account_company`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_account_company`;
CREATE TABLE `cfg_account_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_account_company`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_account_company` VALUES ('1', '帮你贷'), ('2', '大数科技'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_accounting_period_period_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_accounting_period_period_state`;
CREATE TABLE `cfg_accounting_period_period_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_accounting_period_period_state`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_accounting_period_period_state` VALUES ('1', '生效中'), ('2', '已关账'), ('3', '已结转'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_accounting_rule_fee_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_accounting_rule_fee_type`;
CREATE TABLE `cfg_accounting_rule_fee_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_accounting_rule_fee_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_accounting_rule_fee_type` VALUES ('1', '利息收入'), ('2', '利息支出'), ('3', '员工工资'), ('4', '房屋租金'), ('5', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_agent_business_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_agent_business_type`;
CREATE TABLE `cfg_agent_business_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_agent_business_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_agent_business_type` VALUES ('0', '全部'), ('1', '贷款业务'), ('2', '居间业务'), ('3', '垫资过桥');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_agent_channel_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_agent_channel_type`;
CREATE TABLE `cfg_agent_channel_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_agent_channel_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_agent_channel_type` VALUES ('1', '内部销售', '1'), ('2', '外部销售', '2'), ('3', '外部机构', '2'), ('4', '内部兼职销售', '1'), ('5', '全部', '0');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_attendance_ask_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_attendance_ask_type`;
CREATE TABLE `cfg_attendance_ask_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_attendance_ask_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_attendance_ask_type` VALUES ('1', '年假'), ('2', '病假'), ('3', '事假'), ('4', '产假'), ('5', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_balance_credit`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_balance_credit`;
CREATE TABLE `cfg_balance_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_balance_debit`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_balance_debit`;
CREATE TABLE `cfg_balance_debit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_btask_result`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_btask_result`;
CREATE TABLE `cfg_btask_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_calc_formula_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_calc_formula_type`;
CREATE TABLE `cfg_calc_formula_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_calc_formula_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_calc_formula_type` VALUES ('0', '全部'), ('1', '非交易垫资利息'), ('2', '非交易垫资下户费'), ('3', '非交易垫资律师费'), ('4', '非交易垫资专员工资'), ('5', '非交易垫资专员提成'), ('6', '非交易垫资经理工资'), ('7', '非交易垫资经理提成'), ('8', '非交易垫资专员最低提成'), ('9', '非交易垫资专员最高提成'), ('10', '非交易垫资外勤逐单提成'), ('11', '非交易垫资经理最高提成'), ('12', '非交易垫资经理最低提成');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cbs_business_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_business_type`;
CREATE TABLE `cfg_cbs_business_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cbs_business_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cbs_business_type` VALUES ('0', '全部'), ('1', '居间业务'), ('2', '垫资-非交易类'), ('3', '抵押业务'), ('4', '融资业务'), ('6', '垫资-交易类'), ('7', '垫资-提放业务');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cbs_cust_city`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_cust_city`;
CREATE TABLE `cfg_cbs_cust_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_cbs_estate_area`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_estate_area`;
CREATE TABLE `cfg_cbs_estate_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cbs_estate_area`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cbs_estate_area` VALUES ('0', '2', '全部'), ('1', '2', '东西朝海'), ('2', '2', '城六区'), ('3', '2', '近郊'), ('4', '2', '远郊');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cbs_estate_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_estate_type`;
CREATE TABLE `cfg_cbs_estate_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cbs_estate_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cbs_estate_type` VALUES ('1', '住宅'), ('2', '别墅'), ('3', '经济适用房'), ('4', '商住两用'), ('5', '纯商业'), ('6', '纯商业实际为居住'), ('7', '公司名下房产'), ('8', '公寓'), ('9', '酒店式公寓'), ('10', '央产房'), ('11', '公寓式酒店'), ('12', '学区房'), ('13', '别墅立项为住宅'), ('14', '别墅立项为别墅'), ('15', '底商'), ('16', '标准价'), ('17', '公寓住人'), ('18', '公寓办公'), ('19', '成本价房'), ('20', '写字楼'), ('21', '商铺'), ('22', '商品房'), ('23', '独栋别墅'), ('26', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cbs_identity_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_identity_type`;
CREATE TABLE `cfg_cbs_identity_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cbs_identity_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cbs_identity_type` VALUES ('1', '贷款人'), ('2', '抵押人'), ('3', '连带借款人'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cbs_order_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_order_state`;
CREATE TABLE `cfg_cbs_order_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `busi_type` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cbs_order_state`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cbs_order_state` VALUES ('0', '全部', '0'), ('101', '订单暂存', '1'), ('102', '订单初录入', '1'), ('103', '初审不通过', '1'), ('104', '初审通过', '1'), ('105', '初审上报', '1'), ('106', '订单关闭', '1'), ('107', '订单已录入', '1'), ('108', '复审通过', '1'), ('109', '复审不通过', '1'), ('110', '订单复暂存', '1'), ('111', '已收下户费', '1'), ('112', '下户通过', '1'), ('113', '下户不通过', '1'), ('114', '汇审通过', '1'), ('115', '汇审不通过', '1'), ('116', '已签约', '1'), ('117', '已收费', '1'), ('118', '已上报机构', '1'), ('119', '同意放款', '1'), ('120', '不同意放款', '1'), ('121', '放款完成', '1'), ('122', '扣款完成', '1'), ('123', '解押材料已领取', '1'), ('124', '下家已抵押', '1'), ('125', '已回款', '1'), ('126', '已交接', '1'), ('127', '已完结', '1');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cbs_pay_interest_way`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_pay_interest_way`;
CREATE TABLE `cfg_cbs_pay_interest_way` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cbs_pay_interest_way`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cbs_pay_interest_way` VALUES ('0', '全部'), ('1', '一次性付息'), ('2', '按周期付息');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cbs_pay_way`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_pay_way`;
CREATE TABLE `cfg_cbs_pay_way` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cbs_pay_way`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cbs_pay_way` VALUES ('1', '等额本息'), ('2', '等额本金'), ('3', '月息年本'), ('5', '一次性支付'), ('7', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cbs_period_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_period_type`;
CREATE TABLE `cfg_cbs_period_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cbs_period_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cbs_period_type` VALUES ('0', '全部'), ('1', '日'), ('2', '三天'), ('3', '七天'), ('4', '十天');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cbs_prod_bank`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_prod_bank`;
CREATE TABLE `cfg_cbs_prod_bank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_cbs_prod_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_prod_type`;
CREATE TABLE `cfg_cbs_prod_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cbs_prod_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cbs_prod_type` VALUES ('0', '全部'), ('1', '经营贷'), ('2', '消费贷'), ('3', '保单贷'), ('4', '月供贷'), ('5', '公积金贷'), ('6', '信用贷');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cbs_rend_object`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cbs_rend_object`;
CREATE TABLE `cfg_cbs_rend_object` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cbs_rend_object`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cbs_rend_object` VALUES ('1', '全部'), ('2', '学校'), ('3', '幼儿园'), ('4', '医院');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_certificate_certi_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_certificate_certi_state`;
CREATE TABLE `cfg_certificate_certi_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_certificate_certi_state`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_certificate_certi_state` VALUES ('0', '全部'), ('1', '收押中'), ('2', '出借中'), ('3', '已归还'), ('4', '免归还');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_certificate_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_certificate_type`;
CREATE TABLE `cfg_certificate_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_certificate_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_certificate_type` VALUES ('0', '全部'), ('1', '身份证'), ('2', '房产证');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_commission_base_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_commission_base_type`;
CREATE TABLE `cfg_commission_base_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_commission_base_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_commission_base_type` VALUES ('1', '业务额'), ('2', '手续费'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_commission_business_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_commission_business_type`;
CREATE TABLE `cfg_commission_business_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_commission_business_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_commission_business_type` VALUES ('1', '贷款业务'), ('2', '居间业务'), ('3', '垫资过桥'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_commission_channel_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_commission_channel_type`;
CREATE TABLE `cfg_commission_channel_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_commission_channel_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_commission_channel_type` VALUES ('0', '全部'), ('1', '外部员工'), ('2', '内部员工');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_commission_level`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_commission_level`;
CREATE TABLE `cfg_commission_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_commission_level`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_commission_level` VALUES ('1', '基础员工'), ('2', '团队负责人'), ('3', '部门经理'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_commission_product_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_commission_product_type`;
CREATE TABLE `cfg_commission_product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_commission_product_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_commission_product_type` VALUES ('1', '全部'), ('2', '抵押贷款'), ('3', '居间业务');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_commission_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_commission_type`;
CREATE TABLE `cfg_commission_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_commission_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_commission_type` VALUES ('1', '销售人员'), ('2', '风控人员'), ('3', '服务人员'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_commission_way`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_commission_way`;
CREATE TABLE `cfg_commission_way` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_commission_way`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_commission_way` VALUES ('1', '简单比例'), ('2', '累进比例'), ('3', '累进'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cswork_cs_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cswork_cs_state`;
CREATE TABLE `cfg_cswork_cs_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_cswork_cstype`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cswork_cstype`;
CREATE TABLE `cfg_cswork_cstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_curriculum_pos_id`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_curriculum_pos_id`;
CREATE TABLE `cfg_curriculum_pos_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_curriculum_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_curriculum_type`;
CREATE TABLE `cfg_curriculum_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_cust_city`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cust_city`;
CREATE TABLE `cfg_cust_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cust_city`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cust_city` VALUES ('1', '北京'), ('2', '上海'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cust_info_original`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cust_info_original`;
CREATE TABLE `cfg_cust_info_original` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cust_info_original`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cust_info_original` VALUES ('1', '陌生拜访'), ('2', '互联网'), ('3', '熟人推荐'), ('4', '电话筛选'), ('5', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cust_is_new_stockholder`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cust_is_new_stockholder`;
CREATE TABLE `cfg_cust_is_new_stockholder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cust_is_new_stockholder`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cust_is_new_stockholder` VALUES ('1', '是'), ('2', '否'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cust_job`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cust_job`;
CREATE TABLE `cfg_cust_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cust_job`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cust_job` VALUES ('1', '做生意'), ('2', '上班'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cust_sales_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cust_sales_state`;
CREATE TABLE `cfg_cust_sales_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cust_sales_state`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cust_sales_state` VALUES ('1', '准客户'), ('2', '服务客户'), ('3', '服务完结客户'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cust_sex`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cust_sex`;
CREATE TABLE `cfg_cust_sex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cust_sex`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cust_sex` VALUES ('1', '男'), ('2', '女'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_cust_why_borrow`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cust_why_borrow`;
CREATE TABLE `cfg_cust_why_borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_cust_why_borrow`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_cust_why_borrow` VALUES ('1', '做生意用钱'), ('2', '增贷'), ('3', '延长贷款期限'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_employee_city`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_employee_city`;
CREATE TABLE `cfg_employee_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_employee_city`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_employee_city` VALUES ('0', '全部'), ('1', '北京'), ('2', '上海'), ('3', '武汉');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_employee_manage_grade`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_employee_manage_grade`;
CREATE TABLE `cfg_employee_manage_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_employee_manage_grade`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_employee_manage_grade` VALUES ('0', '全部'), ('1', '普通员工'), ('2', '组长'), ('3', '部门经理'), ('4', '总监');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_employee_position_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_employee_position_type`;
CREATE TABLE `cfg_employee_position_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_employee_position_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_employee_position_type` VALUES ('0', '全部'), ('1', '全职岗位'), ('2', '兼职岗位');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_employee_tech_grade`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_employee_tech_grade`;
CREATE TABLE `cfg_employee_tech_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_employee_tech_grade`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_employee_tech_grade` VALUES ('0', '全部'), ('1', '初级'), ('2', '中级'), ('3', '高级');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_format_info_client_mapping`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_format_info_client_mapping`;
CREATE TABLE `cfg_format_info_client_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_key` varchar(255) DEFAULT NULL,
  `format_info_key` varchar(255) DEFAULT NULL,
  `ocr_file_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_format_info_client_mapping`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_format_info_client_mapping` VALUES ('1', 'address', '发证地址', '1'), ('2', 'nationality', '民族', '1'), ('3', 'start_date', '身份证有效期起', '1'), ('4', 'end_date', '身份证有效期止', '1'), ('5', 'issue', '发证机关', '1'), ('6', '房产证号', '房产证号', '6'), ('7', '权利人', '产权人', '6'), ('8', '共有情况', '共有情况', '6'), ('9', '坐落', '房屋坐落', '6'), ('10', '不动产单元号', '不动产单元号', '6'), ('11', '土地权利类型', '土地权利类型', '6'), ('12', '房屋权利类型', '房屋权利类型', '6'), ('13', '土地权利性质/取得方式', '土地权利性质/取得方式', '6'), ('14', '房屋权利性质/取得方式', '房屋权利性质/取得方式', '6'), ('15', '土地用途', '土地用途', '6'), ('16', '房屋用途', '房屋用途', '6'), ('17', '建筑面积', '建筑面积', '6'), ('18', '使用期限', '使用期限', '6');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_format_info_data_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_format_info_data_type`;
CREATE TABLE `cfg_format_info_data_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_format_info_data_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_format_info_data_type` VALUES ('0', '全部'), ('1', 'Integer'), ('2', 'Long'), ('3', 'String'), ('4', 'Date'), ('5', 'BigDecimal');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_format_info_if_scatter`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_format_info_if_scatter`;
CREATE TABLE `cfg_format_info_if_scatter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_format_info_if_scatter`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_format_info_if_scatter` VALUES ('0', '全部'), ('1', '是'), ('2', '否');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_format_info_who_object`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_format_info_who_object`;
CREATE TABLE `cfg_format_info_who_object` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_format_info_who_object`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_format_info_who_object` VALUES ('0', '全部'), ('1', 'Order');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_group_grade`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_group_grade`;
CREATE TABLE `cfg_group_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_group_grade`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_group_grade` VALUES ('0', '全部'), ('1', '部'), ('2', '组');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_job_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_job_type`;
CREATE TABLE `cfg_job_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_knowledge_question_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_knowledge_question_type`;
CREATE TABLE `cfg_knowledge_question_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_knowledge_question_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_knowledge_question_type` VALUES ('1', '产品类'), ('2', '销售类'), ('3', '服务类'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_order_doc_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_order_doc_type`;
CREATE TABLE `cfg_order_doc_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ch_name` varchar(255) DEFAULT NULL,
  `en_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_order_doc_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_order_doc_type` VALUES ('1', '身份证明', 'certificate'), ('2', '婚姻证明', 'marriage'), ('3', '户口本', 'householdRegister'), ('4', '诉讼材料', 'litigationMaterials'), ('5', '征信', 'creditReporting'), ('6', '房产证', 'propertyOwnership');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_organ_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_organ_type`;
CREATE TABLE `cfg_organ_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_organ_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_organ_type` VALUES ('1', '银行'), ('2', '机构'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_paraters`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_paraters`;
CREATE TABLE `cfg_paraters` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ch_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `en_name` varchar(255) DEFAULT NULL,
  `necessary` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_payment_in_out`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_payment_in_out`;
CREATE TABLE `cfg_payment_in_out` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_payment_in_out`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_payment_in_out` VALUES ('0', '全部'), ('1', '收'), ('2', '支');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_payment_offset`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_payment_offset`;
CREATE TABLE `cfg_payment_offset` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_payment_offset`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_payment_offset` VALUES ('0', '全部'), ('1', '已核销'), ('2', '未核销');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_payment_pay_data_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_payment_pay_data_type`;
CREATE TABLE `cfg_payment_pay_data_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_payment_pay_data_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_payment_pay_data_type` VALUES ('0', '全部'), ('1', '实'), ('2', '应');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_payment_pay_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_payment_pay_state`;
CREATE TABLE `cfg_payment_pay_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_payment_pay_state`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_payment_pay_state` VALUES ('0', '全部'), ('1', '待支付'), ('3', '支付中'), ('4', '撤销'), ('5', '支付成功'), ('6', '已确认'), ('7', '待确认');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_payment_pay_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_payment_pay_type`;
CREATE TABLE `cfg_payment_pay_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `busi_type` int(3) NOT NULL,
  `fee_type` int(2) NOT NULL,
  `relate_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_payment_pay_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_payment_pay_type` VALUES ('0', '全部', '0', '0', '0'), ('1', '应收利息', '1', '1', '18'), ('2', '应付利息', '1', '2', '8'), ('3', '应收手续费', '1', '1', '14'), ('5', '应付工资', '1', '2', '23'), ('6', '应付佣金', '1', '2', '24'), ('7', '应付渠道费用', '1', '2', '25'), ('8', '实付利息', '1', '4', '1'), ('9', '应收律师费', '1', '1', '15'), ('10', '应收公证费', '1', '1', '16'), ('11', '应收执照费', '1', '1', '17'), ('12', '实付办公费用', '2', '4', '0'), ('13', '实收客户借款', '1', '3', '20'), ('14', '实收手续费', '1', '3', '3'), ('15', '实收律师费', '1', '3', '9'), ('16', '实收公证费', '1', '3', '10'), ('17', '实收执照费', '1', '3', '11'), ('18', '实收利息', '1', '3', '1'), ('19', '实付客户贷款', '1', '4', '21'), ('20', '应收客户借款', '1', '1', '13'), ('21', '应付客户贷款', '1', '2', '19'), ('23', '实付工资', '1', '4', '5'), ('24', '实付佣金', '1', '4', '6'), ('25', '实付渠道费用', '1', '4', '7'), ('26', '应收客户贷款', '1', '1', '28'), ('27', '应付客户借款', '1', '2', '29'), ('28', '实收客户贷款', '1', '3', '26'), ('29', '实付客户借款', '1', '4', '27'), ('30', '应收下户费', '1', '1', '31'), ('31', '实收下户费', '1', '3', '30');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_performance_commission_process`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_performance_commission_process`;
CREATE TABLE `cfg_performance_commission_process` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_performance_commission_process`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_performance_commission_process` VALUES ('0', '全部'), ('1', '已经核算'), ('2', '已经发放');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_position_dept_id`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_position_dept_id`;
CREATE TABLE `cfg_position_dept_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_position_is_commission`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_position_is_commission`;
CREATE TABLE `cfg_position_is_commission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_position_is_commission`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_position_is_commission` VALUES ('0', '全部'), ('1', '是'), ('2', '否');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_prod_interest_period_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_prod_interest_period_type`;
CREATE TABLE `cfg_prod_interest_period_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_product_bank_id`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_product_bank_id`;
CREATE TABLE `cfg_product_bank_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_product_bank_id`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_product_bank_id` VALUES ('0', '全部'), ('1', '中国银行'), ('2', '工商银行'), ('3', '招商银行'), ('4', '贯泽信'), ('5', '小科金融');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_product_end_date`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_product_end_date`;
CREATE TABLE `cfg_product_end_date` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_product_interest_way`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_product_interest_way`;
CREATE TABLE `cfg_product_interest_way` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_product_product_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_product_product_state`;
CREATE TABLE `cfg_product_product_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_product_product_state`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_product_product_state` VALUES ('1', '生效中'), ('2', '已停售'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_product_product_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_product_product_type`;
CREATE TABLE `cfg_product_product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_product_product_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_product_product_type` VALUES ('0', '全部'), ('1', '抵押贷'), ('2', '经营贷'), ('3', '消费贷');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_resource_parent_id`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_resource_parent_id`;
CREATE TABLE `cfg_resource_parent_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_resource_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_resource_type`;
CREATE TABLE `cfg_resource_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_resource_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_resource_type` VALUES ('0', '全部'), ('1', '链接'), ('2', '按钮'), ('3', '数据');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_role_resource_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_role_resource_type`;
CREATE TABLE `cfg_role_resource_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_role_resource_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_role_resource_type` VALUES ('1', '可读'), ('2', '读增改'), ('3', '读增改删'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_salary_extend_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_salary_extend_state`;
CREATE TABLE `cfg_salary_extend_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_salary_extend_state`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_salary_extend_state` VALUES ('0', '全部'), ('1', '已发放'), ('2', '未发放');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_task_end_date`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_task_end_date`;
CREATE TABLE `cfg_task_end_date` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_task_task_period`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_task_task_period`;
CREATE TABLE `cfg_task_task_period` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_task_task_period`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_task_task_period` VALUES ('1', '天'), ('2', '周'), ('3', '月'), ('4', '年'), ('6', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_task_task_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_task_task_state`;
CREATE TABLE `cfg_task_task_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_task_task_state`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_task_task_state` VALUES ('1', '待完成'), ('2', '进行中'), ('3', '已完成'), ('4', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_task_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_task_type`;
CREATE TABLE `cfg_task_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_task_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_task_type` VALUES ('1', '销售任务'), ('2', '一般日常'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_tel_sales_result`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_tel_sales_result`;
CREATE TABLE `cfg_tel_sales_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_tel_sales_result`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_tel_sales_result` VALUES ('1', '不接'), ('2', '不需要'), ('3', '没空'), ('4', '需要进一步了解'), ('5', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_tel_sales_task_delay`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_tel_sales_task_delay`;
CREATE TABLE `cfg_tel_sales_task_delay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_tel_sales_task_delay`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_tel_sales_task_delay` VALUES ('1', '一天后'), ('2', '两天后'), ('3', '三天后'), ('4', '一周后'), ('5', '一月后'), ('6', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_work_flow_after_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_work_flow_after_state`;
CREATE TABLE `cfg_work_flow_after_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_work_flow_befor_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_work_flow_befor_state`;
CREATE TABLE `cfg_work_flow_befor_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_work_flow_work_type`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_work_flow_work_type`;
CREATE TABLE `cfg_work_flow_work_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `cfg_work_flow_work_type`
-- ----------------------------
BEGIN;
INSERT INTO `cfg_work_flow_work_type` VALUES ('1', '订单处理工作'), ('2', '其他工作'), ('3', '全部');
COMMIT;

-- ----------------------------
--  Table structure for `cfg_work_order_cs_state`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_work_order_cs_state`;
CREATE TABLE `cfg_work_order_cs_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `cfg_work_order_cstype`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_work_order_cstype`;
CREATE TABLE `cfg_work_order_cstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_bank`
-- ----------------------------
DROP TABLE IF EXISTS `t_bank`;
CREATE TABLE `t_bank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `org_type` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_bank`
-- ----------------------------
BEGIN;
INSERT INTO `t_bank` VALUES ('1', '华夏银行', '1'), ('2', '包商银行', '1'), ('3', '招商银行', '1'), ('4', '兴业银行', '1'), ('5', '廊坊银行', '1'), ('6', '厦门国际银行', '1'), ('7', '平安银行', '1'), ('8', '工商银行', '1'), ('9', '浙商银行', '1'), ('10', '广发银行', '1'), ('11', '交通银行', '1'), ('12', '邮储银行', '1'), ('13', '友利银行', '1'), ('14', '浦发银行', '1'), ('15', '民生银行', '1'), ('16', '南京银行', '1'), ('17', '光大银行', '1'), ('19', '中信银行', '1'), ('20', '贯泽信担保', '2');
COMMIT;

-- ----------------------------
--  Table structure for `t_batch_btask`
-- ----------------------------
DROP TABLE IF EXISTS `t_batch_btask`;
CREATE TABLE `t_batch_btask` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `batch_id` int(11) DEFAULT NULL,
  `batch_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `error_desc` varchar(255) DEFAULT NULL,
  `result` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_batch_job`
-- ----------------------------
DROP TABLE IF EXISTS `t_batch_job`;
CREATE TABLE `t_batch_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `batch_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL,
  `next_time` datetime DEFAULT NULL,
  `period_num` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_cbs_certi_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_certi_log`;
CREATE TABLE `t_cbs_certi_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `certi_id` bigint(20) DEFAULT NULL,
  `operator` bigint(20) DEFAULT NULL,
  `opt_time` datetime DEFAULT NULL,
  `opt_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_certi_log`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_certi_log` VALUES ('1', '1', '1', '2019-04-15 08:04:32', '1'), ('2', '1', '1', '2019-04-15 08:04:37', '2'), ('3', '3', '1', '2019-04-22 08:11:17', '1'), ('4', '3', '1', '2019-04-22 08:11:19', '2');
COMMIT;

-- ----------------------------
--  Table structure for `t_cbs_certificate`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_certificate`;
CREATE TABLE `t_cbs_certificate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `box_no` int(11) DEFAULT NULL,
  `certi_state` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `receive_time` datetime DEFAULT NULL,
  `return_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_certificate`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_certificate` VALUES ('1', '0', '1', '2019-04-15 07:43:23', '1', null, '0', '2019-04-15 07:43:23', null, '1', '1', '2019-04-15 08:04:36', '1', '1'), ('2', '0', '1', '2019-04-15 07:43:23', '1', null, '0', '2019-04-15 07:43:23', null, '1', '2', null, '0', '1'), ('3', '1', '1', '2019-04-15 09:34:45', '1', null, '1', '2019-04-15 09:34:45', null, '1', '1', '2019-04-22 08:11:19', '1', '1'), ('4', '1', '1', '2019-04-15 09:34:45', '1', null, '1', '2019-04-15 09:34:45', null, '1', '2', null, '0', '1'), ('5', '2', '1', '2019-04-15 09:34:56', '1', null, '2', '2019-04-15 09:34:56', null, '1', '1', null, '0', '1'), ('6', '2', '1', '2019-04-15 09:34:56', '1', null, '2', '2019-04-15 09:34:56', null, '1', '2', null, '0', '1'), ('7', '3', '1', '2019-04-15 09:35:04', '1', null, '3', '2019-04-15 09:35:04', null, '1', '1', null, '0', '1'), ('8', '3', '1', '2019-04-15 09:35:05', '1', null, '3', '2019-04-15 09:35:05', null, '1', '2', null, '0', '1'), ('9', '4', '1', '2019-04-15 09:35:17', '1', null, '4', '2019-04-15 09:35:17', null, '1', '1', null, '0', '1'), ('10', '4', '1', '2019-04-15 09:35:17', '1', null, '4', '2019-04-15 09:35:17', null, '1', '2', null, '0', '1'), ('11', '5', '1', '2019-04-15 09:35:26', '1', null, '5', '2019-04-15 09:35:26', null, '1', '1', null, '0', '1'), ('12', '5', '1', '2019-04-15 09:35:26', '1', null, '5', '2019-04-15 09:35:26', null, '1', '2', null, '0', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_cbs_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_order`;
CREATE TABLE `t_cbs_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `saler_id` int(11) unsigned zerofill DEFAULT NULL COMMENT '内部单 是employeeid，外部单是agentId',
  `applicant_name` varchar(255) DEFAULT NULL,
  `apply_time` datetime NOT NULL,
  `business_type` int(11) NOT NULL,
  `cell_phone` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `demand_amount` decimal(19,2) DEFAULT NULL,
  `demand_date` datetime DEFAULT NULL,
  `demand_interest` decimal(19,2) DEFAULT NULL,
  `demand_pay_way` int(11) DEFAULT NULL,
  `state` int(3) NOT NULL,
  `period_num` int(11) DEFAULT NULL,
  `period_type` int(3) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `check_time` datetime DEFAULT NULL,
  `sign_date` datetime DEFAULT NULL,
  `order_state` int(3) NOT NULL,
  `pay_interest_way` int(11) DEFAULT NULL,
  `next_org_type` int(11) DEFAULT NULL,
  `channel_type` int(11) DEFAULT NULL,
  `approve_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_order`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_order` VALUES ('47', '11', '运河', '2019-03-22 23:47:06', '2', '18611300304', '2019-03-22 23:47:06', '13', '222.00', '2019-03-17 11:00:00', '22.00', '1', '100', '22', '1', '2019-03-23 01:29:19', '13', null, '2019-06-11 11:00:00', '102', '2', '1', '1', null), ('48', '11', '三三', '2019-03-22 23:54:13', '2', '18611300304', '2019-03-22 23:54:13', '13', '100.00', '2019-03-17 11:00:00', '11.00', '1', '100', '11', '1', '2019-03-23 01:29:53', '13', null, '2019-06-11 11:00:00', '102', '1', '1', '1', null), ('50', '11', '晶晶', '2019-03-23 08:22:29', '2', '18611300304', '2019-03-23 08:22:29', '13', '22.00', '2019-03-17 11:00:00', '22.00', '1', '100', '22', '1', '2019-03-25 02:14:12', '14', null, '2019-06-09 11:00:00', '127', '2', '1', '1', null), ('51', '11', '紫霞', '2019-03-23 08:28:10', '2', '18611300304', '2019-03-23 08:28:10', '13', '222.00', '2019-03-17 11:00:00', '111.00', '1', '100', '11', '1', '2019-03-25 02:14:17', '14', null, null, '127', '1', '1', '1', null), ('52', '11', '小强', '2019-03-25 10:09:32', '2', '18611300304', '2019-03-25 10:09:32', '13', '222.00', '2019-03-17 11:00:00', '22.00', '1', '100', '22', '1', '2019-03-25 10:13:48', '8', null, null, '108', '1', '1', '1', null), ('54', '11', '姑姑', '2019-03-26 20:54:26', '2', '18611300304', '2019-03-26 20:54:26', '13', '222.00', '2019-03-27 11:00:00', '0.00', '0', '100', '14', '1', '2019-03-27 03:32:04', '8', null, null, '108', '0', '1', '1', null), ('55', '11', '我', '2019-03-27 03:40:48', '2', '18611300304', '2019-03-27 03:40:48', '13', '333.00', '2019-03-28 11:00:00', '0.00', '0', '100', '22', '1', '2019-03-27 07:39:43', '14', null, null, '127', '0', '1', '1', null), ('56', '0', '全能王', '2019-03-28 06:45:33', '2', '18611300304', '2019-03-28 06:45:33', '13', '222.00', '2019-03-28 11:00:00', '0.00', '0', '100', '14', '1', null, '0', null, '2019-03-27 11:00:00', '101', '0', '0', '0', null), ('57', '0', '全能王', '2019-03-28 06:50:10', '2', '18611300304', '2019-03-28 06:50:10', '15', '333.00', '2019-03-28 11:00:00', '0.00', '0', '100', '22', '1', null, '0', null, '2019-03-27 11:00:00', '101', '0', '1', '0', null), ('58', '9', '全能王', '2019-03-28 07:15:11', '2', '18611300304', '2019-03-28 07:15:11', '16', '333.00', '2019-03-28 11:00:00', '0.00', '0', '100', '14', '1', '2019-03-28 07:29:20', '9', null, '2019-03-27 11:00:00', '116', '0', '1', '1', null), ('59', '9', '姥姥2', '2019-03-28 08:01:58', '2', '18611300304', '2019-03-28 08:01:58', '16', '400.00', '2019-03-28 11:00:00', '0.00', '0', '100', '20', '1', '2019-03-28 08:12:05', '14', null, '2019-03-27 11:00:00', '127', '0', '1', '1', null), ('60', '9', '老师', '2019-03-28 09:35:14', '2', '222333', '2019-03-28 09:35:14', '16', '300.00', '2019-03-28 11:00:00', '0.00', '0', '100', '14', '1', '2019-03-28 09:45:22', '14', null, '2019-03-27 11:00:00', '127', '0', '1', '1', null), ('61', '9', '胜利', '2019-03-28 20:30:24', '2', '18611300304', '2019-03-28 20:30:24', '16', '900.00', '2019-03-29 11:00:00', '0.00', '0', '100', '2', '2', '2019-03-28 20:46:32', '14', null, '2019-03-28 11:00:00', '127', '0', '1', '1', null), ('62', '9', '小刀', '2019-03-28 22:41:09', '2', '18611300304', '2019-03-28 22:41:09', '16', '9000000.00', '2019-03-28 11:00:00', '0.00', '0', '100', '22', '1', '2019-03-28 22:56:36', '14', null, '2019-03-28 11:00:00', '127', '0', '1', '1', null), ('63', '9', '六六', '2019-04-02 02:06:47', '2', '18611300304', '2019-04-02 02:06:47', '16', '2220000.00', '2019-04-01 11:00:00', '0.00', '0', '100', '22', '1', '2019-04-02 02:14:24', '14', null, '2019-03-31 11:00:00', '127', '0', '1', '1', null), ('64', '9', '七七', '2019-04-02 04:53:10', '2', '18611300304', '2019-04-02 04:53:10', '16', '3330000.00', '2019-04-01 11:00:00', '0.00', '0', '100', '22', '1', '2019-04-02 08:05:20', '14', null, '2019-04-02 11:00:00', '127', '0', '1', '1', null), ('65', '9', '王置换33', '2019-04-08 08:16:44', '2', '18611300304', '2019-04-08 08:16:44', '16', '2220000.00', '2019-04-01 16:00:00', '0.00', '0', '100', '20', '1', '2019-04-18 08:15:29', '16', null, '2019-06-09 16:00:00', '102', '0', '2', '1', null), ('79', '8', null, '2019-04-12 05:45:14', '2', null, '2019-04-12 05:45:14', '0', '0.00', '2019-04-12 05:45:14', '0.00', '0', '100', '0', '0', '2019-04-12 05:47:28', '0', null, null, '104', '0', '0', '0', '064deaf4-b054-4ed1-8107-c73a7b040000'), ('80', '8', '', '2019-04-12 05:45:16', '2', '', '2019-04-12 05:45:16', '0', '0.00', '2019-04-11 16:00:00', '0.00', '0', '100', '0', '0', '2019-04-18 06:21:03', '16', null, null, '107', '0', '0', '0', 'ed9ef910-7f62-4537-8318-c754cd194f42'), ('81', '4', '王润海', '2019-04-13 16:26:53', '0', '18611300304', '2019-04-13 16:26:53', '1', '2000000.00', '2019-09-08 16:00:00', '0.00', '0', '100', '0', '1', null, '0', null, '2019-09-08 16:00:00', '101', '0', '1', '2', null), ('82', '9', '关羽', '2019-04-14 02:02:12', '2', '18611300304', '2019-04-14 02:02:12', '16', '1100000.00', '2019-09-17 16:00:00', '0.00', '0', '100', '10', '2', '2019-04-18 06:34:17', '16', null, '2019-06-09 16:00:00', '102', '0', '2', '1', null), ('83', '9', '张飞', '2019-04-14 02:57:32', '0', '222333', '2019-04-14 02:57:32', '16', '1000000.00', '2019-04-01 16:00:00', '0.00', '0', '100', '10', '2', null, '0', null, null, '101', '0', '2', '1', null), ('84', '9', '张飞', '2019-04-14 03:01:19', '2', '18611300304', '2019-04-14 03:01:19', '16', '1500000.00', '2019-09-17 16:00:00', '0.00', '0', '100', '20', '1', '2019-04-18 06:27:38', '16', null, null, '102', '0', '2', '1', null), ('85', '9', '赵云', '2019-04-14 06:07:17', '2', '222', '2019-04-14 06:07:17', '16', '1000000.00', '2019-03-27 16:00:00', '0.00', '0', '100', '0', '1', '2019-04-16 05:58:03', '16', null, null, '102', '0', '2', '1', null), ('86', '9', '魏延', '2019-04-15 15:47:44', '2', '18611300304', '2019-04-15 15:47:44', '16', '2220000.00', '2019-09-17 16:00:00', '0.00', '0', '100', '20', '1', '2019-04-16 05:57:03', '16', null, '2019-06-09 16:00:00', '107', '0', '2', '1', null), ('87', '9', '黄忠', '2019-04-19 15:44:22', '2', '18611300304', '2019-04-19 15:44:22', '16', '1500000.00', '2019-06-27 16:00:00', '0.00', '0', '100', '15', '1', '2019-04-19 15:47:31', '14', null, '2019-06-09 16:00:00', '104', '0', '2', '1', null), ('88', '8', null, '2019-04-22 01:22:19', '2', null, '2019-04-22 01:22:19', '0', '5000000.00', '2019-04-22 16:00:00', '0.00', '0', '100', '15', '1', '2019-04-22 02:00:05', '0', null, null, '104', '0', '0', '0', '7e7a915c-92c2-4886-9c6f-07d39e5b17a8'), ('89', '8', '百晶晶', '2019-04-22 07:20:01', '2', '1112223333', '2019-04-22 07:20:01', '0', '6000000.00', '2019-04-23 16:00:00', '0.00', '0', '100', '15', '1', '2019-04-22 09:31:34', '10', null, null, '122', '0', '0', '0', 'e1e21565-4db3-49c0-bbe8-5e686caf9a37'), ('90', '8', '', '2019-04-22 10:40:02', '2', '', '2019-04-22 10:40:02', '0', '2350000.00', '2019-04-23 16:00:00', '0.00', '0', '100', '20', '1', '2019-04-22 15:04:55', '14', null, '2019-06-09 16:00:00', '127', '0', '0', '0', 'ce6fb530-2b92-44ce-95d7-9d22f4ac0d5f'), ('91', '8', '', '2019-04-22 15:00:01', '2', '', '2019-04-22 15:00:01', '0', '1230000.00', '2019-04-23 16:00:00', '0.00', '0', '100', '69', '1', '2019-04-22 15:05:20', '14', null, null, '104', '0', '0', '0', '596337af-3831-49be-ac4b-96c8173a4211'), ('92', '8', '', '2019-04-24 00:28:04', '2', null, '2019-04-24 00:28:04', '0', '5860000.00', '2019-04-24 16:00:00', '0.00', '0', '100', '15', '1', '2019-04-24 02:05:43', '14', null, '2019-06-09 16:00:00', '127', '0', '0', '0', '96eadf8e-820b-4ce2-b1ad-6f36f41b9762'), ('93', '8', null, '2019-04-24 02:00:01', '2', null, '2019-04-24 02:00:01', '0', '3330000.00', '2019-04-24 16:00:00', '0.00', '0', '100', '42', '1', '2019-04-24 03:11:07', '0', null, null, '104', '0', '0', '0', '28d8b7fc-286b-4df8-b765-a96aaca6b155'), ('94', '8', null, '2019-04-24 03:00:25', '2', null, '2019-04-24 03:00:25', '0', '5550000.00', '2019-04-24 16:00:00', '0.00', '0', '0', '32', '1', '2019-04-24 03:11:07', '0', null, null, '104', '0', '0', '0', '56baefe6-33cd-4272-8425-f570172726fb');
COMMIT;

-- ----------------------------
--  Table structure for `t_cbs_order_doc`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_order_doc`;
CREATE TABLE `t_cbs_order_doc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uuidname` varchar(255) DEFAULT NULL,
  `uuidnamed_file_path` varchar(255) DEFAULT NULL,
  `condense_name_path` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `doc_type` int(11) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `origina_name` varchar(255) DEFAULT NULL,
  `original_file_path` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_order_doc`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_order_doc` VALUES ('4', '89517c7a-8da1-4162-9be8-1abbb822ac7c.jpeg', 'uploadfile/raw/byOrder/39/89517c7a-8da1-4162-9be8-1abbb822ac7c.jpeg', 'uploadfile/raw/byOrder/39/89517c7a-8da1-4162-9be8-1abbb822ac7c.jpeg', '2018-12-11 10:20:06', '0', '0', '39', 'large.jpeg', 'uploadfile/raw/byOrder/39/large.jpeg', '1', null, '0'), ('5', 'ec859167-a8ab-457e-86fc-203c24a8d127.jpeg', 'uploadfile/raw/byOrder/39/ec859167-a8ab-457e-86fc-203c24a8d127.jpeg', 'uploadfile/raw/byOrder/39/ec859167-a8ab-457e-86fc-203c24a8d127.jpeg', '2018-12-11 10:20:06', '0', '0', '39', 'large (1).jpeg', 'uploadfile/raw/byOrder/39/large (1).jpeg', '1', null, '0'), ('6', 'c6dc42f2-f0a5-4b83-9b09-87131b085890.jpeg', 'uploadfile/raw/byOrder/39/c6dc42f2-f0a5-4b83-9b09-87131b085890.jpeg', 'uploadfile/raw/byOrder/39/c6dc42f2-f0a5-4b83-9b09-87131b085890.jpeg', '2018-12-11 10:20:06', '0', '0', '39', '红黄蓝造谣者.jpeg', 'uploadfile/raw/byOrder/39/红黄蓝造谣者.jpeg', '1', null, '0'), ('7', 'ea6852e0-be43-433d-8936-f15f8c919fdd.jpeg', 'uploadfile/raw/byOrder/39/ea6852e0-be43-433d-8936-f15f8c919fdd.jpeg', 'uploadfile/raw/byOrder/39/ea6852e0-be43-433d-8936-f15f8c919fdd.jpeg', '2018-12-11 10:26:55', '0', '0', '39', 'large.jpeg', 'uploadfile/raw/byOrder/39/large.jpeg', '1', null, '0'), ('8', '468f75bf-e68d-4710-868a-ae4a21231c2b.jpeg', 'uploadfile/raw/byOrder/39/468f75bf-e68d-4710-868a-ae4a21231c2b.jpeg', 'uploadfile/raw/byOrder/39/468f75bf-e68d-4710-868a-ae4a21231c2b.jpeg', '2018-12-11 10:26:55', '0', '0', '39', 'large (1).jpeg', 'uploadfile/raw/byOrder/39/large (1).jpeg', '1', null, '0'), ('9', '0278c7ed-6832-4758-8682-c23a344e1ffb.jpeg', 'uploadfile/raw/byOrder/40/0278c7ed-6832-4758-8682-c23a344e1ffb.jpeg', 'uploadfile/raw/byOrder/40/0278c7ed-6832-4758-8682-c23a344e1ffb.jpeg', '2018-12-11 12:05:57', '0', '0', '40', 'large.jpeg', 'uploadfile/raw/byOrder/40/large.jpeg', '1', null, '0'), ('10', 'e8a875be-28e7-4458-8cd7-dc6493d515e9.jpeg', 'uploadfile/raw/byOrder/40/e8a875be-28e7-4458-8cd7-dc6493d515e9.jpeg', 'uploadfile/raw/byOrder/40/e8a875be-28e7-4458-8cd7-dc6493d515e9.jpeg', '2018-12-11 12:05:57', '0', '0', '40', 'large (1).jpeg', 'uploadfile/raw/byOrder/40/large (1).jpeg', '1', null, '0'), ('11', '3965bdea-c679-499c-994b-ac482daefc5e.jpeg', 'uploadfile/raw/byOrder/40/3965bdea-c679-499c-994b-ac482daefc5e.jpeg', 'uploadfile/raw/byOrder/40/3965bdea-c679-499c-994b-ac482daefc5e.jpeg', '2018-12-11 12:05:57', '0', '0', '40', '红黄蓝造谣者.jpeg', 'uploadfile/raw/byOrder/40/红黄蓝造谣者.jpeg', '1', null, '0'), ('12', '9ace9c4f-fdb9-4e84-ae98-e952e12d506c.jpeg', 'uploadfile/raw/byOrder/40/9ace9c4f-fdb9-4e84-ae98-e952e12d506c.jpeg', 'uploadfile/raw/byOrder/40/9ace9c4f-fdb9-4e84-ae98-e952e12d506c.jpeg', '2018-12-11 14:40:59', '0', '0', '40', 'large (1).jpeg', 'uploadfile/raw/byOrder/40/large (1).jpeg', '1', null, '0'), ('13', '9a0d48f6-9c3e-4116-987a-4d84d5a17be8.jpeg', 'uploadfile/raw/byOrder/40/9a0d48f6-9c3e-4116-987a-4d84d5a17be8.jpeg', 'uploadfile/raw/byOrder/40/9a0d48f6-9c3e-4116-987a-4d84d5a17be8.jpeg', '2018-12-11 14:40:59', '0', '0', '40', '红黄蓝造谣者.jpeg', 'uploadfile/raw/byOrder/40/红黄蓝造谣者.jpeg', '1', null, '0'), ('14', 'fe6fda3e-5ea3-4f20-b5d5-e4205eae014f.jpeg', 'uploadfile/raw/byOrder/40/fe6fda3e-5ea3-4f20-b5d5-e4205eae014f.jpeg', 'uploadfile/raw/byOrder/40/fe6fda3e-5ea3-4f20-b5d5-e4205eae014f.jpeg', '2018-12-11 14:40:59', '0', '0', '40', 'large.jpeg', 'uploadfile/raw/byOrder/40/large.jpeg', '1', null, '0'), ('15', '54f3ce75-1592-424c-9b12-89fb5540cdfa.png', 'uploadfile/raw/byOrder/30/54f3ce75-1592-424c-9b12-89fb5540cdfa.png', 'uploadfile/raw/byOrder/30/54f3ce75-1592-424c-9b12-89fb5540cdfa.png', '2019-03-01 00:50:14', '0', '0', '30', '183614qwmfwh3jklpmvzfy.png', 'uploadfile/raw/byOrder/30/183614qwmfwh3jklpmvzfy.png', '1', null, '0'), ('16', '9ca3a478-2d2e-48f3-95e2-52a1682bdbbe.jpeg', 'uploadfile/raw/byOrder/33/9ca3a478-2d2e-48f3-95e2-52a1682bdbbe.jpeg', 'uploadfile/raw/byOrder/33/9ca3a478-2d2e-48f3-95e2-52a1682bdbbe.jpeg', '2019-03-07 02:30:58', '0', '0', '33', 'WechatIMG1.jpeg', 'uploadfile/raw/byOrder/33/WechatIMG1.jpeg', '1', null, '0'), ('17', '878a64cb-cad9-440f-86b7-3921b26b7654.png', 'uploadfile/raw/byOrder/33/878a64cb-cad9-440f-86b7-3921b26b7654.png', 'uploadfile/raw/byOrder/33/878a64cb-cad9-440f-86b7-3921b26b7654.png', '2019-03-07 02:31:10', '0', '0', '33', '183614qwmfwh3jklpmvzfy.png', 'uploadfile/raw/byOrder/33/183614qwmfwh3jklpmvzfy.png', '1', null, '0'), ('18', '7abdc1aa-a538-43e7-a2e5-c59e9e2e60b1.jpeg', 'uploadfile/raw/byOrder/33/7abdc1aa-a538-43e7-a2e5-c59e9e2e60b1.jpeg', 'uploadfile/raw/byOrder/33/7abdc1aa-a538-43e7-a2e5-c59e9e2e60b1.jpeg', '2019-03-07 02:31:10', '0', '0', '33', '红黄蓝造谣者.jpeg', 'uploadfile/raw/byOrder/33/红黄蓝造谣者.jpeg', '1', null, '0'), ('19', 'd15de5ac-3375-4e02-a961-c323a3e54420.jpeg', 'uploadfile/raw/byOrder/33/d15de5ac-3375-4e02-a961-c323a3e54420.jpeg', 'uploadfile/raw/byOrder/33/d15de5ac-3375-4e02-a961-c323a3e54420.jpeg', '2019-03-07 02:31:10', '0', '0', '33', '纽约时报.jpeg', 'uploadfile/raw/byOrder/33/纽约时报.jpeg', '1', null, '0'), ('20', 'c93f1c29-1901-4fb5-811c-77ab149fd22c.jpeg', 'uploadfile/raw/byOrder/41/c93f1c29-1901-4fb5-811c-77ab149fd22c.jpeg', 'uploadfile/raw/byOrder/41/c93f1c29-1901-4fb5-811c-77ab149fd22c.jpeg', '2019-03-18 21:42:34', '0', '0', '41', 'large.jpeg', 'uploadfile/raw/byOrder/41/large.jpeg', '1', null, '0'), ('21', 'b03feaac-81c4-4c01-acad-7ffee3caef29.png', 'uploadfile/raw/byOrder/41/b03feaac-81c4-4c01-acad-7ffee3caef29.png', 'uploadfile/raw/byOrder/41/b03feaac-81c4-4c01-acad-7ffee3caef29.png', '2019-03-18 21:44:39', '0', '0', '41', '183614qwmfwh3jklpmvzfy.png', 'uploadfile/raw/byOrder/41/183614qwmfwh3jklpmvzfy.png', '1', null, '0'), ('22', 'ae1f45ef-6327-4ac2-8c00-4871f18b7fae.jpeg', 'uploadfile/raw/byOrder/49/ae1f45ef-6327-4ac2-8c00-4871f18b7fae.jpeg', 'uploadfile/raw/byOrder/49/ae1f45ef-6327-4ac2-8c00-4871f18b7fae.jpeg', '2019-03-23 07:42:49', '0', '0', '49', 'large.jpeg', 'uploadfile/raw/byOrder/49/large.jpeg', '1', null, '0'), ('23', '505cfef8-279d-4942-a24b-cabc4b57d0ce.jpeg', 'uploadfile/raw/byOrder/49/505cfef8-279d-4942-a24b-cabc4b57d0ce.jpeg', 'uploadfile/raw/byOrder/49/505cfef8-279d-4942-a24b-cabc4b57d0ce.jpeg', '2019-03-23 07:43:00', '0', '0', '49', '纽约时报.jpeg', 'uploadfile/raw/byOrder/49/纽约时报.jpeg', '1', null, '0'), ('24', '87920bcf-d91a-4b9d-b26a-7ccec01fe98b.jpeg', 'uploadfile/raw/byOrder/51/87920bcf-d91a-4b9d-b26a-7ccec01fe98b.jpeg', 'uploadfile/raw/byOrder/51/87920bcf-d91a-4b9d-b26a-7ccec01fe98b.jpeg', '2019-03-23 08:28:27', '0', '0', '51', '纽约时报.jpeg', 'uploadfile/raw/byOrder/51/纽约时报.jpeg', '1', null, '0'), ('25', 'e2570d94-802e-4fc1-86a3-43a86ec0628c.jpeg', 'uploadfile/raw/byOrder/52/e2570d94-802e-4fc1-86a3-43a86ec0628c.jpeg', 'uploadfile/raw/byOrder/52/e2570d94-802e-4fc1-86a3-43a86ec0628c.jpeg', '2019-03-25 10:11:12', '0', '0', '52', 'large.jpeg', 'uploadfile/raw/byOrder/52/large.jpeg', '1', null, '0'), ('26', '5210ad0e-832f-4d5b-8abd-3fbe7cb2076e.jpeg', 'uploadfile/raw/byOrder/52/5210ad0e-832f-4d5b-8abd-3fbe7cb2076e.jpeg', 'uploadfile/raw/byOrder/52/5210ad0e-832f-4d5b-8abd-3fbe7cb2076e.jpeg', '2019-03-25 10:13:24', '0', '0', '52', '纽约时报.jpeg', 'uploadfile/raw/byOrder/52/纽约时报.jpeg', '1', null, '0'), ('27', '531c8d7e-54b5-4b5d-8d33-110807645d4e.jpeg', 'uploadfile/raw/byOrder/54/531c8d7e-54b5-4b5d-8d33-110807645d4e.jpeg', 'uploadfile/raw/byOrder/54/531c8d7e-54b5-4b5d-8d33-110807645d4e.jpeg', '2019-03-26 20:55:09', '0', '0', '54', 'WechatIMG1.jpeg', 'uploadfile/raw/byOrder/54/WechatIMG1.jpeg', '1', null, '0'), ('28', 'fb6540bb-f825-4b20-8e24-39b455f07570.jpeg', 'uploadfile/raw/byOrder/55/fb6540bb-f825-4b20-8e24-39b455f07570.jpeg', 'uploadfile/raw/byOrder/55/fb6540bb-f825-4b20-8e24-39b455f07570.jpeg', '2019-03-27 03:44:35', '0', '0', '55', 'large.jpeg', 'uploadfile/raw/byOrder/55/large.jpeg', '1', null, '0'), ('29', 'b443925a-7f55-4224-b770-c4f6e628f400.jpg', 'uploadfile/raw/byOrder/55/b443925a-7f55-4224-b770-c4f6e628f400.jpg', 'uploadfile/raw/byOrder/55/b443925a-7f55-4224-b770-c4f6e628f400.jpg', '2019-03-27 04:01:54', '0', '0', '55', 'IMG_20190327_165843_[B@2647bba.jpg', 'uploadfile/raw/byOrder/55/IMG_20190327_165843_[B@2647bba.jpg', '1', null, '0'), ('30', '70a54e7c-4e79-4bec-a3e5-c27cc166b866.jpeg', 'uploadfile/raw/byOrder/58/70a54e7c-4e79-4bec-a3e5-c27cc166b866.jpeg', 'uploadfile/raw/byOrder/58/70a54e7c-4e79-4bec-a3e5-c27cc166b866.jpeg', '2019-03-28 07:23:42', '0', '0', '58', 'WechatIMG1.jpeg', 'uploadfile/raw/byOrder/58/WechatIMG1.jpeg', '1', null, '0'), ('31', 'c0846e89-c002-4505-aeaa-ea929ba5c511.jpeg', 'uploadfile/raw/byOrder/59/c0846e89-c002-4505-aeaa-ea929ba5c511.jpeg', 'uploadfile/raw/byOrder/59/c0846e89-c002-4505-aeaa-ea929ba5c511.jpeg', '2019-03-28 08:03:00', '0', '0', '59', '纽约时报.jpeg', 'uploadfile/raw/byOrder/59/纽约时报.jpeg', '1', null, '0'), ('32', '29e9b0b9-2fc1-4cdd-93e5-6d4824711d2a.jpeg', 'uploadfile/raw/byOrder/59/29e9b0b9-2fc1-4cdd-93e5-6d4824711d2a.jpeg', 'uploadfile/raw/byOrder/59/29e9b0b9-2fc1-4cdd-93e5-6d4824711d2a.jpeg', '2019-03-28 08:05:31', '0', '0', '59', 'large (1).jpeg', 'uploadfile/raw/byOrder/59/large (1).jpeg', '1', null, '0'), ('33', '19fa4155-5fe2-41de-a4c3-530e135bd2ec.jpeg', 'uploadfile/raw/byOrder/60/19fa4155-5fe2-41de-a4c3-530e135bd2ec.jpeg', 'uploadfile/raw/byOrder/60/19fa4155-5fe2-41de-a4c3-530e135bd2ec.jpeg', '2019-03-28 09:39:19', '0', '0', '60', 'WechatIMG1.jpeg', 'uploadfile/raw/byOrder/60/WechatIMG1.jpeg', '1', null, '0'), ('34', 'feda7dac-d9d1-49ee-a90e-8be777e73c19.jpeg', 'uploadfile/raw/byOrder/61/feda7dac-d9d1-49ee-a90e-8be777e73c19.jpeg', 'uploadfile/raw/byOrder/61/feda7dac-d9d1-49ee-a90e-8be777e73c19.jpeg', '2019-03-28 20:31:42', '0', '0', '61', 'WechatIMG3.jpeg', 'uploadfile/raw/byOrder/61/WechatIMG3.jpeg', '1', null, '0'), ('35', '20c4f2b7-86ef-4f49-9c90-e0d86a83575e.jpeg', 'uploadfile/raw/byOrder/62/20c4f2b7-86ef-4f49-9c90-e0d86a83575e.jpeg', 'uploadfile/raw/byOrder/62/20c4f2b7-86ef-4f49-9c90-e0d86a83575e.jpeg', '2019-03-28 22:42:35', '0', '0', '62', 'WechatIMG5.jpeg', 'uploadfile/raw/byOrder/62/WechatIMG5.jpeg', '1', null, '0'), ('36', 'ac1d27fb-2c82-4804-8439-6ba83e845655.jpeg', 'uploadfile/raw/byOrder/63/ac1d27fb-2c82-4804-8439-6ba83e845655.jpeg', 'uploadfile/raw/byOrder/63/ac1d27fb-2c82-4804-8439-6ba83e845655.jpeg', '2019-04-02 02:07:02', '0', '0', '63', 'WechatIMG177.jpeg', 'uploadfile/raw/byOrder/63/WechatIMG177.jpeg', '1', null, '0'), ('37', '05b2d810-27cf-4dae-9c51-6bf6d52d01c6.jpeg', 'uploadfile/raw/byOrder/65/05b2d810-27cf-4dae-9c51-6bf6d52d01c6.jpeg', 'uploadfile/raw/byOrder/65/05b2d810-27cf-4dae-9c51-6bf6d52d01c6.jpeg', '2019-04-08 08:17:26', '0', '0', '65', 'large (3).jpeg', 'uploadfile/raw/byOrder/65/large (3).jpeg', '1', null, '0'), ('38', '403c7c04-3d52-4239-9f11-0d5600423254.jpeg', 'uploadfile/raw/byOrder/65/403c7c04-3d52-4239-9f11-0d5600423254.jpeg', 'uploadfile/raw/byOrder/65/403c7c04-3d52-4239-9f11-0d5600423254.jpeg', '2019-04-08 08:17:37', '0', '0', '65', 'large.jpeg', 'uploadfile/raw/byOrder/65/large.jpeg', '1', null, '0'), ('39', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg\"', '2019-04-12 05:31:53', '0', '0', '73', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('40', '\"https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg\"', '2019-04-12 05:31:53', '0', '0', '73', '\"https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('41', '\"https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg\"', '2019-04-12 05:31:53', '0', '0', '73', '\"https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('42', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg\"', '2019-04-12 05:31:53', '0', '0', '73', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('43', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg\"', '2019-04-12 05:31:53', '0', '0', '73', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/73/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('44', '\"https://static.dingtalk.com/media/lADPDgQ9qmjaFbPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/74/\"https://static.dingtalk.com/media/lADPDgQ9qmjaFbPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/74/\"https://static.dingtalk.com/media/lADPDgQ9qmjaFbPNBQDNAtA_720_1280.jpg\"', '2019-04-12 05:31:53', '0', '0', '74', '\"https://static.dingtalk.com/media/lADPDgQ9qmjaFbPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/74/\"https://static.dingtalk.com/media/lADPDgQ9qmjaFbPNBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('45', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg\"', '2019-04-12 05:38:07', '0', '0', '75', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('46', '\"https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg\"', '2019-04-12 05:38:07', '0', '0', '75', '\"https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('47', '\"https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg\"', '2019-04-12 05:38:07', '0', '0', '75', '\"https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('48', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg\"', '2019-04-12 05:38:07', '0', '0', '75', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('49', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg\"', '2019-04-12 05:38:07', '0', '0', '75', '\"https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/75/\"https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('50', '\"https://static.dingtalk.com/media/lADPDgQ9qmjaFbPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/76/\"https://static.dingtalk.com/media/lADPDgQ9qmjaFbPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/76/\"https://static.dingtalk.com/media/lADPDgQ9qmjaFbPNBQDNAtA_720_1280.jpg\"', '2019-04-12 05:38:07', '0', '0', '76', '\"https://static.dingtalk.com/media/lADPDgQ9qmjaFbPNBQDNAtA_720_1280.jpg\"', 'uploadfile/raw/byOrder/76/\"https://static.dingtalk.com/media/lADPDgQ9qmjaFbPNBQDNAtA_720_1280.jpg\"', '1', null, '0'), ('57', 'lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg', '2019-04-12 05:45:16', '0', '0', '79', 'lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg', '1', null, '0'), ('58', 'lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg', '2019-04-12 05:45:16', '0', '0', '79', 'lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg', '1', null, '0'), ('59', 'lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg', '2019-04-12 05:45:16', '0', '0', '79', 'lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg', '1', null, '0'), ('60', 'lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg', '2019-04-12 05:45:16', '0', '0', '79', 'lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg', '1', null, '0'), ('61', 'lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg', '2019-04-12 05:45:16', '0', '0', '79', 'lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg', 'uploadfile/raw/byOrder/79/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg', '1', null, '0'), ('81', '14f4e25b-09a7-496b-8370-1411d6317675.jpeg', 'uploadfile/raw/byOrder/80/14f4e25b-09a7-496b-8370-1411d6317675.jpeg', 'uploadfile/raw/byOrder/80/14f4e25b-09a7-496b-8370-1411d6317675.jpeg', '2019-04-17 12:47:34', '0', '1', '80', 'large (2).jpeg', 'uploadfile/raw/byOrder/80/large (2).jpeg', '1', null, '0'), ('82', 'c04bdd26-c1ae-4d75-b250-fd7bde1efaee.jpeg', 'uploadfile/raw/byOrder/80/c04bdd26-c1ae-4d75-b250-fd7bde1efaee.jpeg', 'uploadfile/raw/byOrder/80/c04bdd26-c1ae-4d75-b250-fd7bde1efaee.jpeg', '2019-04-17 12:47:34', '0', '1', '80', 'large (3).jpeg', 'uploadfile/raw/byOrder/80/large (3).jpeg', '1', null, '0'), ('83', '3cd675ca-ee40-4a53-bb13-ee9f90091afe.jpeg', 'uploadfile/raw/byOrder/80/3cd675ca-ee40-4a53-bb13-ee9f90091afe.jpeg', 'uploadfile/raw/byOrder/80/3cd675ca-ee40-4a53-bb13-ee9f90091afe.jpeg', '2019-04-17 12:47:34', '0', '1', '80', 'large (5).jpeg', 'uploadfile/raw/byOrder/80/large (5).jpeg', '1', null, '0'), ('84', '9aa8da97-4d9a-453f-923e-ede7f50b3250.jpeg', 'uploadfile/raw/byOrder/80/9aa8da97-4d9a-453f-923e-ede7f50b3250.jpeg', 'uploadfile/raw/byOrder/80/9aa8da97-4d9a-453f-923e-ede7f50b3250.jpeg', '2019-04-17 12:47:34', '0', '1', '80', 'large (4).jpeg', 'uploadfile/raw/byOrder/80/large (4).jpeg', '1', null, '0'), ('85', 'd53bbb6b-01ef-4bc2-a29b-b38fdfcb0f72.jpeg', 'uploadfile/raw/byOrder/80/d53bbb6b-01ef-4bc2-a29b-b38fdfcb0f72.jpeg', 'uploadfile/raw/byOrder/80/d53bbb6b-01ef-4bc2-a29b-b38fdfcb0f72.jpeg', '2019-04-17 12:47:42', '0', '2', '80', 'large (5).jpeg', 'uploadfile/raw/byOrder/80/large (5).jpeg', '1', null, '0'), ('86', 'f65ff2ad-aca4-43ae-9f1a-1c8a7e9cf86d.jpeg', 'uploadfile/raw/byOrder/80/f65ff2ad-aca4-43ae-9f1a-1c8a7e9cf86d.jpeg', 'uploadfile/raw/byOrder/80/f65ff2ad-aca4-43ae-9f1a-1c8a7e9cf86d.jpeg', '2019-04-17 12:47:42', '0', '2', '80', 'large (6).jpeg', 'uploadfile/raw/byOrder/80/large (6).jpeg', '1', null, '0'), ('87', '7ff18665-48d8-414c-b091-01a398b54bad.jpeg', 'uploadfile/raw/byOrder/80/7ff18665-48d8-414c-b091-01a398b54bad.jpeg', 'uploadfile/raw/byOrder/80/7ff18665-48d8-414c-b091-01a398b54bad.jpeg', '2019-04-17 12:47:42', '0', '2', '80', 'large (4).jpeg', 'uploadfile/raw/byOrder/80/large (4).jpeg', '1', null, '0'), ('88', '243de642-edc9-4097-8efa-0b6471eac9b2.jpeg', 'uploadfile/raw/byOrder/80/243de642-edc9-4097-8efa-0b6471eac9b2.jpeg', 'uploadfile/raw/byOrder/80/243de642-edc9-4097-8efa-0b6471eac9b2.jpeg', '2019-04-17 12:47:42', '0', '2', '80', 'large (3).jpeg', 'uploadfile/raw/byOrder/80/large (3).jpeg', '1', null, '0'), ('89', 'd3bfbf0a-8d48-47f1-bc58-9b3da646afc6.jpeg', 'uploadfile/raw/byOrder/80/d3bfbf0a-8d48-47f1-bc58-9b3da646afc6.jpeg', 'uploadfile/raw/byOrder/80/d3bfbf0a-8d48-47f1-bc58-9b3da646afc6.jpeg', '2019-04-17 12:47:48', '0', '3', '80', 'large (5).jpeg', 'uploadfile/raw/byOrder/80/large (5).jpeg', '1', null, '0'), ('90', 'a87e1d2c-119a-4b7b-9c1d-3968322a13f1.jpeg', 'uploadfile/raw/byOrder/80/a87e1d2c-119a-4b7b-9c1d-3968322a13f1.jpeg', 'uploadfile/raw/byOrder/80/a87e1d2c-119a-4b7b-9c1d-3968322a13f1.jpeg', '2019-04-17 12:47:48', '0', '3', '80', 'large (6).jpeg', 'uploadfile/raw/byOrder/80/large (6).jpeg', '1', null, '0'), ('91', '96a3978b-e1ef-43ec-b47d-73721147fea1.jpeg', 'uploadfile/raw/byOrder/80/96a3978b-e1ef-43ec-b47d-73721147fea1.jpeg', 'uploadfile/raw/byOrder/80/96a3978b-e1ef-43ec-b47d-73721147fea1.jpeg', '2019-04-17 12:47:48', '0', '3', '80', 'large.jpeg', 'uploadfile/raw/byOrder/80/large.jpeg', '1', null, '0'), ('92', '40ac615c-e56a-443b-ad49-ffdb57cb63e1.jpeg', 'uploadfile/raw/byOrder/80/40ac615c-e56a-443b-ad49-ffdb57cb63e1.jpeg', 'uploadfile/raw/byOrder/80/40ac615c-e56a-443b-ad49-ffdb57cb63e1.jpeg', '2019-04-17 13:49:57', '0', '1', '80', 'large (5).jpeg', 'uploadfile/raw/byOrder/80/large (5).jpeg', '1', null, '0'), ('93', '45fe2ad1-c49c-42d4-a9e4-3692d71a52d4.jpeg', 'uploadfile/raw/byOrder/80/45fe2ad1-c49c-42d4-a9e4-3692d71a52d4.jpeg', 'uploadfile/raw/byOrder/80/45fe2ad1-c49c-42d4-a9e4-3692d71a52d4.jpeg', '2019-04-17 13:49:57', '0', '1', '80', 'large (4).jpeg', 'uploadfile/raw/byOrder/80/large (4).jpeg', '1', null, '0'), ('94', '05cc48b8-cc5a-4fc5-b7cd-ffb68d0bdcca.jpeg', 'uploadfile/raw/byOrder/80/05cc48b8-cc5a-4fc5-b7cd-ffb68d0bdcca.jpeg', 'uploadfile/raw/byOrder/80/05cc48b8-cc5a-4fc5-b7cd-ffb68d0bdcca.jpeg', '2019-04-17 13:49:57', '0', '1', '80', 'large (6).jpeg', 'uploadfile/raw/byOrder/80/large (6).jpeg', '1', null, '0'), ('95', '95b6737a-e551-4753-86b8-276051c14df5.jpeg', 'uploadfile/raw/byOrder/80/95b6737a-e551-4753-86b8-276051c14df5.jpeg', 'uploadfile/raw/byOrder/80/95b6737a-e551-4753-86b8-276051c14df5.jpeg', '2019-04-17 13:50:17', '0', '1', '80', 'large (6).jpeg', 'uploadfile/raw/byOrder/80/large (6).jpeg', '1', null, '0'), ('96', 'c849a7a2-8a7a-41da-bb1d-5d7e4a3bf180.jpeg', 'uploadfile/raw/byOrder/80/c849a7a2-8a7a-41da-bb1d-5d7e4a3bf180.jpeg', 'uploadfile/raw/byOrder/80/c849a7a2-8a7a-41da-bb1d-5d7e4a3bf180.jpeg', '2019-04-17 13:50:17', '0', '1', '80', 'large.jpeg', 'uploadfile/raw/byOrder/80/large.jpeg', '1', null, '0'), ('97', 'f838f6b6-e7c5-4a6d-b7ac-dd0987d1a500.jpeg', 'uploadfile/raw/byOrder/80/f838f6b6-e7c5-4a6d-b7ac-dd0987d1a500.jpeg', 'uploadfile/raw/byOrder/80/f838f6b6-e7c5-4a6d-b7ac-dd0987d1a500.jpeg', '2019-04-18 01:04:06', '0', '2', '80', 'large (5).jpeg', 'uploadfile/raw/byOrder/80/large (5).jpeg', '1', null, '0'), ('98', 'e7d59725-c2a6-4a19-af60-4b154961461c.jpeg', 'uploadfile/raw/byOrder/80/e7d59725-c2a6-4a19-af60-4b154961461c.jpeg', 'uploadfile/raw/byOrder/80/e7d59725-c2a6-4a19-af60-4b154961461c.jpeg', '2019-04-18 01:04:18', '0', '3', '80', 'large.jpeg', 'uploadfile/raw/byOrder/80/large.jpeg', '1', null, '0'), ('99', 'a6481dce-bd48-46cb-b20b-c48e3ec914ef.jpeg', 'uploadfile/raw/byOrder/80/a6481dce-bd48-46cb-b20b-c48e3ec914ef.jpeg', 'uploadfile/raw/byOrder/80/a6481dce-bd48-46cb-b20b-c48e3ec914ef.jpeg', '2019-04-18 01:04:25', '0', '3', '80', 'large (1).jpeg', 'uploadfile/raw/byOrder/80/large (1).jpeg', '1', null, '0'), ('100', '4650bbee-b09c-43cb-b12e-0956a1973c3c.jpeg', 'uploadfile/raw/byOrder/82/身份证明/4650bbee-b09c-43cb-b12e-0956a1973c3c.jpeg', 'uploadfile/raw/byOrder/82/身份证明/4650bbee-b09c-43cb-b12e-0956a1973c3c.jpeg', '2019-04-21 15:28:28', '0', '1', '82', 'large (5).jpeg', 'uploadfile/raw/byOrder/82/身份证明/large (5).jpeg', '1', null, '0'), ('101', 'c3f436ca-8768-4593-b542-4bb6cff04217.jpeg', 'uploadfile/raw/byOrder/82/身份证明/c3f436ca-8768-4593-b542-4bb6cff04217.jpeg', 'uploadfile/raw/byOrder/82/身份证明/c3f436ca-8768-4593-b542-4bb6cff04217.jpeg', '2019-04-21 15:28:29', '0', '1', '82', 'large (6).jpeg', 'uploadfile/raw/byOrder/82/身份证明/large (6).jpeg', '1', null, '0'), ('102', '9edbfae1-4835-4d05-ac57-15f9b8f40fd8.jpeg', 'uploadfile/raw/byOrder/82/身份证明/9edbfae1-4835-4d05-ac57-15f9b8f40fd8.jpeg', 'uploadfile/raw/byOrder/82/身份证明/9edbfae1-4835-4d05-ac57-15f9b8f40fd8.jpeg', '2019-04-21 15:28:29', '0', '1', '82', 'large (4).jpeg', 'uploadfile/raw/byOrder/82/身份证明/large (4).jpeg', '1', null, '0'), ('103', 'lADPDgQ9qoYFyrLNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/88/身份证明/lADPDgQ9qoYFyrLNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/88/身份证明/lADPDgQ9qoYFyrLNA-DNAug_744_992.jpg', '2019-04-22 01:22:22', '0', '1', '88', 'lADPDgQ9qoYFyrLNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/88/身份证明/lADPDgQ9qoYFyrLNA-DNAug_744_992.jpg', '1', null, '0'), ('105', 'lADPDgQ9qoco1qjNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/89/身份证明/lADPDgQ9qoco1qjNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/89/身份证明/lADPDgQ9qoco1qjNA-DNAug_744_992.jpg', '2019-04-22 07:20:01', '0', '1', '89', 'lADPDgQ9qoco1qjNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/89/身份证明/lADPDgQ9qoco1qjNA-DNAug_744_992.jpg', '1', null, '0'), ('106', 'lADPDgQ9qoco1rLNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/89/房产证/lADPDgQ9qoco1rLNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/89/房产证/lADPDgQ9qoco1rLNA-DNAug_744_992.jpg', '2019-04-22 07:20:03', '0', '6', '89', 'lADPDgQ9qoco1rLNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/89/房产证/lADPDgQ9qoco1rLNA-DNAug_744_992.jpg', '1', null, '0'), ('107', 'lADPDgQ9qofyPeTNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/90/身份证明/lADPDgQ9qofyPeTNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/90/身份证明/lADPDgQ9qofyPeTNA-DNAug_744_992.jpg', '2019-04-22 10:40:05', '0', '1', '90', 'lADPDgQ9qofyPeTNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/90/身份证明/lADPDgQ9qofyPeTNA-DNAug_744_992.jpg', '1', null, '0'), ('108', 'lADPDgQ9qofyPerNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/90/房产证/lADPDgQ9qofyPerNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/90/房产证/lADPDgQ9qofyPerNA-DNAug_744_992.jpg', '2019-04-22 10:40:06', '0', '6', '90', 'lADPDgQ9qofyPerNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/90/房产证/lADPDgQ9qofyPerNA-DNAug_744_992.jpg', '1', null, '0'), ('109', 'lADPDgQ9qohZXgjNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/91/身份证明/lADPDgQ9qohZXgjNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/91/身份证明/lADPDgQ9qohZXgjNA-DNAug_744_992.jpg', '2019-04-22 15:00:04', '0', '1', '91', 'lADPDgQ9qohZXgjNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/91/身份证明/lADPDgQ9qohZXgjNA-DNAug_744_992.jpg', '1', null, '0'), ('110', 'lADPDgQ9qohZXhDNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/91/房产证/lADPDgQ9qohZXhDNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/91/房产证/lADPDgQ9qohZXhDNA-DNAug_744_992.jpg', '2019-04-22 15:00:07', '0', '6', '91', 'lADPDgQ9qohZXhDNA-DNAug_744_992.jpg', 'uploadfile/raw/byOrder/91/房产证/lADPDgQ9qohZXhDNA-DNAug_744_992.jpg', '1', null, '0'), ('111', 'lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', 'uploadfile/raw/byOrder/92/身份证明/lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', 'uploadfile/raw/byOrder/92/身份证明/lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', '2019-04-24 00:28:06', '0', '1', '92', 'lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', 'uploadfile/raw/byOrder/92/身份证明/lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', '1', null, '0'), ('112', 'lADPDgQ9qoteJwLNAq3NBA8_1039_685.jpg', 'uploadfile/raw/byOrder/92/身份证明/lADPDgQ9qoteJwLNAq3NBA8_1039_685.jpg', 'uploadfile/raw/byOrder/92/身份证明/lADPDgQ9qoteJwLNAq3NBA8_1039_685.jpg', '2019-04-24 00:28:08', '0', '1', '92', 'lADPDgQ9qoteJwLNAq3NBA8_1039_685.jpg', 'uploadfile/raw/byOrder/92/身份证明/lADPDgQ9qoteJwLNAq3NBA8_1039_685.jpg', '1', null, '0'), ('113', 'lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', 'uploadfile/raw/byOrder/92/房产证/lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', 'uploadfile/raw/byOrder/92/房产证/lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', '2019-04-24 00:28:09', '0', '6', '92', 'lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', 'uploadfile/raw/byOrder/92/房产证/lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', '1', null, '0'), ('114', 'lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', 'uploadfile/raw/byOrder/93/身份证明/lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', 'uploadfile/raw/byOrder/93/身份证明/lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', '2019-04-24 02:00:04', '0', '1', '93', 'lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', 'uploadfile/raw/byOrder/93/身份证明/lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', '1', null, '0'), ('115', 'lADPDgQ9qouyxBzNAq3NBA8_1039_685.jpg', 'uploadfile/raw/byOrder/93/身份证明/lADPDgQ9qouyxBzNAq3NBA8_1039_685.jpg', 'uploadfile/raw/byOrder/93/身份证明/lADPDgQ9qouyxBzNAq3NBA8_1039_685.jpg', '2019-04-24 02:00:06', '0', '1', '93', 'lADPDgQ9qouyxBzNAq3NBA8_1039_685.jpg', 'uploadfile/raw/byOrder/93/身份证明/lADPDgQ9qouyxBzNAq3NBA8_1039_685.jpg', '1', null, '0'), ('116', 'lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', 'uploadfile/raw/byOrder/93/房产证/lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', 'uploadfile/raw/byOrder/93/房产证/lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', '2019-04-24 02:00:08', '0', '6', '93', 'lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', 'uploadfile/raw/byOrder/93/房产证/lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', '1', null, '0'), ('117', 'lADPDgQ9qovirwPNAq3NBA8_1039_685.jpg', 'uploadfile/raw/byOrder/94/身份证明/lADPDgQ9qovirwPNAq3NBA8_1039_685.jpg', 'uploadfile/raw/byOrder/94/身份证明/lADPDgQ9qovirwPNAq3NBA8_1039_685.jpg', '2019-04-24 03:00:26', '0', '1', '94', 'lADPDgQ9qovirwPNAq3NBA8_1039_685.jpg', 'uploadfile/raw/byOrder/94/身份证明/lADPDgQ9qovirwPNAq3NBA8_1039_685.jpg', '1', null, '0'), ('118', 'lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', 'uploadfile/raw/byOrder/94/身份证明/lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', 'uploadfile/raw/byOrder/94/身份证明/lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', '2019-04-24 03:00:28', '0', '1', '94', 'lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', 'uploadfile/raw/byOrder/94/身份证明/lADPDgQ9qoteJv3NAULNAfA_496_322.jpg', '1', null, '0'), ('119', 'lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', 'uploadfile/raw/byOrder/94/房产证/lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', 'uploadfile/raw/byOrder/94/房产证/lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', '2019-04-24 03:00:30', '0', '6', '94', 'lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', 'uploadfile/raw/byOrder/94/房产证/lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg', '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_cbs_order_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_order_log`;
CREATE TABLE `t_cbs_order_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action_desc` varchar(255) DEFAULT NULL,
  `button_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `operator_time` datetime DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `order_product_id` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `format_info_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=439 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_order_log`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_order_log` VALUES ('1', '', '5', '2019-03-08 08:56:06', '0', '2019-03-08 08:56:06', '0', '0', '1', null, null, '1', '0'), ('2', '', '5', '2019-03-08 08:59:37', '0', '2019-03-08 08:59:37', '21', '0', '1', null, null, '1', '0'), ('3', '资料有问题', '6', '2019-03-08 09:13:21', '0', '2019-03-08 09:13:21', '21', '0', '1', null, null, '1', '0'), ('4', '', '7', '2019-03-09 04:28:40', '0', '2019-03-09 04:28:40', '30', '0', '1', null, null, '1', '0'), ('5', null, '1', '2019-03-14 09:34:17', '1', null, '42', '0', '1', null, null, '1', '0'), ('6', null, '1', '2019-03-14 09:50:01', '1', null, '0', '0', '1', null, null, '1', '0'), ('7', null, '1', '2019-03-14 09:52:34', '1', null, '0', '0', '1', null, null, '1', '0'), ('8', null, '1', '2019-03-14 20:03:00', '1', null, '0', '0', '1', null, null, '1', '0'), ('9', null, '1', '2019-03-14 20:03:25', '1', null, '0', '0', '1', null, null, '1', '0'), ('10', null, '1', '2019-03-14 20:04:55', '1', null, '0', '0', '1', null, null, '1', '0'), ('11', '', '5', '2019-03-16 08:41:57', '0', '2019-03-16 08:41:57', '0', '0', '1', null, null, '1', '0'), ('12', '', '5', '2019-03-16 08:43:11', '0', '2019-03-16 08:43:11', '0', '0', '1', null, null, '1', '0'), ('13', null, '1', '2019-03-18 20:36:22', '1', null, '43', '0', '1', null, null, '1', '0'), ('14', null, '3', '2019-03-18 21:26:30', '1', null, '41', '0', '1', null, null, '1', '0'), ('15', null, '3', '2019-03-18 21:30:54', '1', null, '41', '0', '1', null, null, '1', '0'), ('16', null, '2', '2019-03-18 21:42:34', '1', null, '41', '0', '1', null, null, '1', '0'), ('17', null, '2', '2019-03-18 21:44:39', '1', null, '41', '0', '1', null, null, '1', '0'), ('18', null, '4', '2019-03-18 21:49:10', '1', null, '41', '0', '1', null, null, '1', '0'), ('19', null, '1', '2019-03-20 21:04:42', '1', null, '44', '0', '1', null, null, '1', '0'), ('20', null, '1', '2019-03-20 21:29:53', '1', null, '45', '0', '1', null, null, '1', '0'), ('21', null, '1', '2019-03-20 21:33:11', '1', null, '46', '0', '1', null, null, '1', '0'), ('22', null, '1', '2019-03-22 22:26:59', '13', null, '0', '0', '1', null, null, '13', '0'), ('23', null, '71', '2019-03-22 23:47:07', '13', null, '47', '0', '1', null, null, '13', '0'), ('24', null, '71', '2019-03-22 23:54:14', '13', null, '48', '0', '1', null, null, '13', '0'), ('25', null, '72', '2019-03-23 01:09:33', '13', null, '0', '0', '1', null, null, '13', '0'), ('26', null, '72', '2019-03-23 01:14:50', '13', null, '0', '0', '1', null, null, '13', '0'), ('27', null, '72', '2019-03-23 01:23:00', '13', null, '0', '0', '1', null, null, '13', '0'), ('28', null, '72', '2019-03-23 01:25:22', '13', null, '0', '0', '1', null, null, '13', '0'), ('29', null, '72', '2019-03-23 01:29:19', '13', null, '0', '0', '1', null, null, '13', '0'), ('30', null, '72', '2019-03-23 01:29:53', '13', null, '0', '0', '1', null, null, '13', '0'), ('31', null, '71', '2019-03-23 01:53:01', '13', null, '49', '0', '1', null, null, '13', '0'), ('32', null, '72', '2019-03-23 01:53:26', '13', null, '0', '0', '1', null, null, '13', '0'), ('33', null, '75', '2019-03-23 01:58:44', '14', null, '0', '0', '1', null, null, '14', '0'), ('34', null, '74', '2019-03-23 02:04:16', '8', null, '0', '0', '1', null, null, '8', '0'), ('35', null, '2', '2019-03-23 07:42:50', '13', null, '49', '0', '1', null, null, '13', '0'), ('36', null, '2', '2019-03-23 07:43:00', '13', null, '49', '0', '1', null, null, '13', '0'), ('37', null, '72', '2019-03-23 07:43:10', '13', null, '0', '0', '1', null, null, '13', '0'), ('38', null, '81', '2019-03-23 07:44:25', '8', null, '0', '0', '1', null, null, '8', '0'), ('39', null, null, '2019-03-23 08:08:16', '13', null, '0', '0', '1', null, null, '13', '0'), ('40', null, '71', '2019-03-23 08:20:49', '13', null, '0', '0', '1', null, null, '13', '0'), ('41', null, '71', '2019-03-23 08:22:29', '13', null, '50', '0', '1', null, null, '13', '0'), ('42', null, '72', '2019-03-23 08:25:16', '13', '2019-03-23 08:25:16', '50', '0', '1', null, null, '13', '0'), ('43', null, '75', '2019-03-23 08:27:17', '14', '2019-03-23 08:27:17', '50', '0', '1', null, null, '14', '0'), ('44', null, '71', '2019-03-23 08:28:10', '13', '2019-03-23 08:28:10', '51', '0', '1', null, null, '13', '0'), ('45', null, '2', '2019-03-23 08:28:27', '13', '2019-03-23 08:28:27', '51', '0', '1', null, null, '13', '0'), ('46', null, '72', '2019-03-23 08:28:48', '13', '2019-03-23 08:28:48', '51', '0', '1', null, null, '13', '0'), ('47', null, '75', '2019-03-23 08:38:13', '14', '2019-03-23 08:38:13', '51', '0', '1', null, null, '14', '0'), ('48', null, '74', '2019-03-23 10:31:30', '8', '2019-03-23 10:31:30', '51', '0', '1', null, null, '8', '0'), ('49', null, '74', '2019-03-24 23:02:14', '8', '2019-03-24 23:02:14', '50', '0', '1', null, null, '8', '0'), ('50', null, '102', '2019-03-25 01:31:20', '13', '2019-03-25 01:31:20', '51', '0', '1', null, null, '13', '0'), ('51', null, '103', '2019-03-25 01:31:40', '13', '2019-03-25 01:31:40', '51', '0', '1', null, null, '13', '0'), ('52', null, '72', '2019-03-25 01:53:15', '13', '2019-03-25 01:53:15', '51', '0', '1', null, null, '13', '0'), ('53', null, '72', '2019-03-25 01:53:25', '13', '2019-03-25 01:53:25', '50', '0', '1', null, null, '13', '0'), ('54', null, '80', '2019-03-25 01:54:03', '8', '2019-03-25 01:54:03', '51', '0', '1', null, null, '8', '0'), ('55', null, '80', '2019-03-25 01:54:10', '8', '2019-03-25 01:54:10', '50', '0', '1', null, null, '8', '0'), ('56', null, '84', '2019-03-25 01:55:33', '10', '2019-03-25 01:55:33', '51', '0', '1', null, null, '10', '0'), ('57', null, '84', '2019-03-25 01:55:39', '10', '2019-03-25 01:55:39', '50', '0', '1', null, null, '10', '0'), ('58', null, '85', '2019-03-25 01:56:33', '9', '2019-03-25 01:56:33', '51', '0', '1', null, null, '9', '0'), ('59', null, '85', '2019-03-25 01:56:52', '9', '2019-03-25 01:56:52', '50', '0', '1', null, null, '9', '0'), ('60', null, '89', '2019-03-25 01:57:11', '9', '2019-03-25 01:57:11', '50', '0', '1', null, null, '9', '0'), ('61', null, '89', '2019-03-25 01:57:17', '9', '2019-03-25 01:57:17', '51', '0', '1', null, null, '9', '0'), ('62', null, '90', '2019-03-25 02:08:18', '10', '2019-03-25 02:08:18', '50', '0', '1', null, null, '10', '0'), ('63', null, '90', '2019-03-25 02:08:25', '10', '2019-03-25 02:08:25', '51', '0', '1', null, null, '10', '0'), ('64', null, '92', '2019-03-25 02:10:23', '7', '2019-03-25 02:10:23', '51', '0', '1', null, null, '7', '0'), ('65', null, '92', '2019-03-25 02:10:30', '7', '2019-03-25 02:10:30', '50', '0', '1', null, null, '7', '0'), ('66', null, '94', '2019-03-25 02:11:07', '10', '2019-03-25 02:11:07', '50', '0', '1', null, null, '10', '0'), ('67', null, '94', '2019-03-25 02:11:13', '10', '2019-03-25 02:11:13', '51', '0', '1', null, null, '10', '0'), ('68', null, '95', '2019-03-25 02:11:22', '10', '2019-03-25 02:11:22', '50', '0', '1', null, null, '10', '0'), ('69', null, '95', '2019-03-25 02:11:26', '10', '2019-03-25 02:11:26', '51', '0', '1', null, null, '10', '0'), ('70', null, '96', '2019-03-25 02:12:16', '9', '2019-03-25 02:12:16', '51', '0', '1', null, null, '9', '0'), ('71', null, '96', '2019-03-25 02:12:23', '9', '2019-03-25 02:12:23', '50', '0', '1', null, null, '9', '0'), ('72', null, '97', '2019-03-25 02:12:29', '9', '2019-03-25 02:12:29', '50', '0', '1', null, null, '9', '0'), ('73', null, '97', '2019-03-25 02:12:34', '9', '2019-03-25 02:12:34', '51', '0', '1', null, null, '9', '0'), ('74', null, '98', '2019-03-25 02:13:03', '10', '2019-03-25 02:13:03', '50', '0', '1', null, null, '10', '0'), ('75', null, '98', '2019-03-25 02:13:08', '10', '2019-03-25 02:13:08', '51', '0', '1', null, null, '10', '0'), ('76', null, '99', '2019-03-25 02:13:50', '9', '2019-03-25 02:13:50', '50', '0', '1', null, null, '9', '0'), ('77', null, '99', '2019-03-25 02:13:55', '9', '2019-03-25 02:13:55', '51', '0', '1', null, null, '9', '0'), ('78', null, '100', '2019-03-25 02:14:12', '14', '2019-03-25 02:14:12', '50', '0', '1', null, null, '14', '0'), ('79', null, '100', '2019-03-25 02:14:17', '14', '2019-03-25 02:14:17', '51', '0', '1', null, null, '14', '0'), ('80', null, '71', '2019-03-25 10:09:32', '13', '2019-03-25 10:09:32', '52', '0', '1', null, null, '13', '0'), ('81', null, '102', '2019-03-25 10:11:12', '13', '2019-03-25 10:11:12', '52', '0', '1', null, null, '13', '0'), ('82', null, '72', '2019-03-25 10:11:26', '13', '2019-03-25 10:11:26', '52', '0', '1', null, null, '13', '0'), ('83', null, '74', '2019-03-25 10:12:11', '14', '2019-03-25 10:12:11', '52', '0', '1', null, null, '14', '0'), ('84', null, '102', '2019-03-25 10:13:24', '13', '2019-03-25 10:13:24', '52', '0', '1', null, null, '13', '0'), ('85', null, '72', '2019-03-25 10:13:27', '13', '2019-03-25 10:13:27', '52', '0', '1', null, null, '13', '0'), ('86', null, '80', '2019-03-25 10:13:48', '8', '2019-03-25 10:13:48', '52', '0', '1', null, null, '8', '0'), ('87', null, '71', '2019-03-26 04:42:55', '13', '2019-03-26 04:42:55', '53', '0', '1', null, null, '13', '0'), ('88', null, '71', '2019-03-26 20:54:26', '13', '2019-03-26 20:54:26', '54', '0', '1', null, null, '13', '0'), ('89', null, '102', '2019-03-26 20:55:09', '13', '2019-03-26 20:55:09', '54', '0', '1', null, null, '13', '0'), ('90', null, '72', '2019-03-26 20:55:26', '13', '2019-03-26 20:55:26', '54', '0', '1', null, null, '13', '0'), ('91', null, '74', '2019-03-26 20:59:02', '14', '2019-03-26 20:59:02', '54', '0', '1', null, null, '14', '0'), ('92', null, '72', '2019-03-26 20:59:35', '13', '2019-03-26 20:59:35', '54', '0', '1', null, null, '13', '0'), ('93', null, '80', '2019-03-26 21:02:38', '8', '2019-03-26 21:02:38', '54', '0', '1', null, null, '8', '0'), ('94', null, '80', '2019-03-27 00:50:32', '8', '2019-03-27 00:50:32', '54', '0', '1', null, null, '8', '0'), ('95', null, '80', '2019-03-27 00:59:40', '8', '2019-03-27 00:59:40', '54', '0', '1', null, null, '8', '0'), ('96', null, '80', '2019-03-27 01:10:27', '8', '2019-03-27 01:10:27', '54', '0', '1', null, null, '8', '0'), ('97', null, '80', '2019-03-27 01:11:49', '8', '2019-03-27 01:11:49', '54', '0', '1', null, null, '8', '0'), ('98', null, '80', '2019-03-27 01:14:20', '8', '2019-03-27 01:14:20', '54', '0', '1', null, null, '8', '0'), ('99', null, '80', '2019-03-27 01:48:02', '8', '2019-03-27 01:48:02', '54', '0', '1', null, null, '8', '0'), ('100', null, '80', '2019-03-27 03:18:25', '8', '2019-03-27 03:18:25', '54', '0', '1', null, null, '8', '0'), ('101', null, '80', '2019-03-27 03:21:19', '8', '2019-03-27 03:21:19', '54', '0', '1', null, null, '8', '0'), ('102', null, '80', '2019-03-27 03:32:04', '8', '2019-03-27 03:32:04', '54', '0', '1', null, null, '8', '0'), ('103', null, '71', '2019-03-27 03:40:48', '13', '2019-03-27 03:40:48', '55', '0', '1', null, null, '13', '0'), ('104', null, '102', '2019-03-27 03:44:07', '13', '2019-03-27 03:44:07', '55', '0', '1', null, null, '13', '0'), ('105', null, '103', '2019-03-27 03:44:28', '13', '2019-03-27 03:44:28', '55', '0', '1', null, null, '13', '0'), ('106', null, '101', '2019-03-27 03:44:35', '13', '2019-03-27 03:44:35', '55', '0', '1', null, null, '13', '0'), ('107', null, '72', '2019-03-27 03:44:38', '13', '2019-03-27 03:44:38', '55', '0', '1', null, null, '13', '0'), ('108', null, '101', '2019-03-27 03:44:59', '14', '2019-03-27 03:44:59', '55', '0', '1', null, null, '14', '0'), ('109', null, '74', '2019-03-27 03:45:28', '14', '2019-03-27 03:45:28', '55', '0', '1', null, null, '14', '0'), ('110', null, '72', '2019-03-27 03:46:25', '13', '2019-03-27 03:46:25', '55', '0', '1', null, null, '13', '0'), ('111', null, '80', '2019-03-27 03:48:18', '8', '2019-03-27 03:48:18', '55', '0', '1', null, null, '8', '0'), ('112', null, '101', '2019-03-27 04:01:54', '10', '2019-03-27 04:01:54', '55', '0', '1', null, null, '10', '0'), ('113', null, '84', '2019-03-27 04:42:11', '10', '2019-03-27 04:42:11', '55', '0', '1', null, null, '10', '0'), ('114', null, '85', '2019-03-27 04:42:45', '9', '2019-03-27 04:42:45', '55', '0', '1', null, null, '9', '0'), ('115', null, '89', '2019-03-27 04:42:53', '9', '2019-03-27 04:42:53', '55', '0', '1', null, null, '9', '0'), ('116', null, '89', '2019-03-27 05:01:21', '9', '2019-03-27 05:01:21', '55', '0', '1', null, null, '9', '0'), ('117', null, '89', '2019-03-27 06:27:19', '9', '2019-03-27 06:27:19', '55', '0', '1', null, null, '9', '0'), ('118', null, '89', '2019-03-27 06:29:52', '9', '2019-03-27 06:29:52', '55', '0', '1', null, null, '9', '0'), ('119', null, '89', '2019-03-27 06:43:12', '9', '2019-03-27 06:43:12', '55', '0', '1', null, null, '9', '0'), ('120', null, '89', '2019-03-27 07:00:03', '9', '2019-03-27 07:00:03', '55', '0', '1', null, null, '9', '0'), ('121', null, '89', '2019-03-27 07:01:19', '9', '2019-03-27 07:01:19', '55', '0', '1', null, null, '9', '0'), ('122', null, '89', '2019-03-27 07:03:07', '9', '2019-03-27 07:03:07', '55', '0', '1', null, null, '9', '0'), ('123', null, '89', '2019-03-27 07:04:06', '9', '2019-03-27 07:04:06', '55', '0', '1', null, null, '9', '0'), ('124', null, '89', '2019-03-27 07:04:54', '9', '2019-03-27 07:04:54', '55', '0', '1', null, null, '9', '0'), ('125', null, '89', '2019-03-27 07:08:29', '9', '2019-03-27 07:08:29', '55', '0', '1', null, null, '9', '0'), ('126', null, '90', '2019-03-27 07:11:45', '10', '2019-03-27 07:11:45', '55', '0', '1', null, null, '10', '0'), ('127', null, '92', '2019-03-27 07:13:06', '7', '2019-03-27 07:13:06', '55', '0', '1', null, null, '7', '0'), ('128', null, '94', '2019-03-27 07:13:43', '10', '2019-03-27 07:13:43', '55', '0', '1', null, null, '10', '0'), ('129', null, '95', '2019-03-27 07:14:04', '10', '2019-03-27 07:14:04', '55', '0', '1', null, null, '10', '0'), ('130', null, '96', '2019-03-27 07:14:20', '9', '2019-03-27 07:14:20', '55', '0', '1', null, null, '9', '0'), ('131', null, '97', '2019-03-27 07:14:23', '9', '2019-03-27 07:14:23', '55', '0', '1', null, null, '9', '0'), ('132', null, '98', '2019-03-27 07:14:52', '10', '2019-03-27 07:14:52', '55', '0', '1', null, null, '10', '0'), ('133', null, '99', '2019-03-27 07:15:25', '9', '2019-03-27 07:15:25', '55', '0', '1', null, null, '9', '0'), ('134', null, '100', '2019-03-27 07:15:40', '14', '2019-03-27 07:15:40', '55', '0', '1', null, null, '14', '0'), ('135', null, '99', '2019-03-27 07:25:03', '9', '2019-03-27 07:25:03', '55', '0', '1', null, null, '9', '0'), ('136', null, '100', '2019-03-27 07:26:01', '14', '2019-03-27 07:26:01', '55', '0', '1', null, null, '14', '0'), ('137', null, '100', '2019-03-27 07:39:43', '14', '2019-03-27 07:39:43', '55', '0', '1', null, null, '14', '0'), ('139', null, '71', '2019-03-28 06:45:33', '13', '2019-03-28 06:45:33', '56', '0', '1', null, null, '13', '0'), ('140', null, '71', '2019-03-28 06:50:10', '15', '2019-03-28 06:50:10', '57', '0', '1', null, null, '15', '0'), ('141', null, '71', '2019-03-28 07:15:11', '16', '2019-03-28 07:15:11', '58', '0', '1', null, null, '16', '0'), ('142', null, '102', '2019-03-28 07:21:20', '16', '2019-03-28 07:21:20', '58', '0', '1', null, null, '16', '0'), ('143', null, '103', '2019-03-28 07:21:42', '16', '2019-03-28 07:21:42', '58', '0', '1', null, null, '16', '0'), ('144', null, '72', '2019-03-28 07:21:57', '16', '2019-03-28 07:21:57', '58', '0', '1', null, null, '16', '0'), ('145', null, '74', '2019-03-28 07:23:11', '14', '2019-03-28 07:23:11', '58', '0', '1', null, null, '14', '0'), ('146', null, '101', '2019-03-28 07:23:42', '16', '2019-03-28 07:23:42', '58', '0', '1', null, null, '16', '0'), ('147', null, '72', '2019-03-28 07:23:47', '16', '2019-03-28 07:23:47', '58', '0', '1', null, null, '16', '0'), ('148', null, '80', '2019-03-28 07:24:18', '8', '2019-03-28 07:24:18', '58', '0', '1', null, null, '8', '0'), ('149', null, '84', '2019-03-28 07:28:50', '10', '2019-03-28 07:28:50', '58', '0', '1', null, null, '10', '0'), ('150', null, '85', '2019-03-28 07:29:07', '9', '2019-03-28 07:29:07', '58', '0', '1', null, null, '9', '0'), ('151', null, '89', '2019-03-28 07:29:20', '9', '2019-03-28 07:29:20', '58', '0', '1', null, null, '9', '0'), ('152', null, '71', '2019-03-28 08:01:59', '16', '2019-03-28 08:01:59', '59', '0', '1', null, null, '16', '0'), ('153', null, '102', '2019-03-28 08:02:40', '16', '2019-03-28 08:02:40', '59', '0', '1', null, null, '16', '0'), ('154', null, '103', '2019-03-28 08:02:52', '16', '2019-03-28 08:02:52', '59', '0', '1', null, null, '16', '0'), ('155', null, '101', '2019-03-28 08:03:00', '16', '2019-03-28 08:03:00', '59', '0', '1', null, null, '16', '0'), ('156', null, '72', '2019-03-28 08:03:07', '16', '2019-03-28 08:03:07', '59', '0', '1', null, null, '16', '0'), ('157', null, '74', '2019-03-28 08:05:04', '14', '2019-03-28 08:05:04', '59', '0', '1', null, null, '14', '0'), ('158', null, '101', '2019-03-28 08:05:32', '16', '2019-03-28 08:05:32', '59', '0', '1', null, null, '16', '0'), ('159', null, '72', '2019-03-28 08:05:49', '16', '2019-03-28 08:05:49', '59', '0', '1', null, null, '16', '0'), ('160', null, '80', '2019-03-28 08:06:04', '8', '2019-03-28 08:06:04', '59', '0', '1', null, null, '8', '0'), ('161', null, '84', '2019-03-28 08:07:28', '10', '2019-03-28 08:07:28', '59', '0', '1', null, null, '10', '0'), ('162', null, '85', '2019-03-28 08:07:43', '9', '2019-03-28 08:07:43', '59', '0', '1', null, null, '9', '0'), ('163', null, '89', '2019-03-28 08:08:03', '9', '2019-03-28 08:08:03', '59', '0', '1', null, null, '9', '0'), ('164', null, '90', '2019-03-28 08:09:19', '10', '2019-03-28 08:09:19', '59', '0', '1', null, null, '10', '0'), ('165', null, '92', '2019-03-28 08:09:51', '7', '2019-03-28 08:09:51', '59', '0', '1', null, null, '7', '0'), ('166', null, '94', '2019-03-28 08:10:47', '10', '2019-03-28 08:10:47', '59', '0', '1', null, null, '10', '0'), ('167', null, '95', '2019-03-28 08:10:49', '10', '2019-03-28 08:10:49', '59', '0', '1', null, null, '10', '0'), ('168', null, '96', '2019-03-28 08:11:07', '9', '2019-03-28 08:11:07', '59', '0', '1', null, null, '9', '0'), ('169', null, '97', '2019-03-28 08:11:10', '9', '2019-03-28 08:11:10', '59', '0', '1', null, null, '9', '0'), ('170', null, '98', '2019-03-28 08:11:37', '10', '2019-03-28 08:11:37', '59', '0', '1', null, null, '10', '0'), ('171', null, '99', '2019-03-28 08:11:51', '9', '2019-03-28 08:11:51', '59', '0', '1', null, null, '9', '0'), ('172', null, '100', '2019-03-28 08:12:05', '14', '2019-03-28 08:12:05', '59', '0', '1', null, null, '14', '0'), ('173', null, '71', '2019-03-28 09:35:14', '16', '2019-03-28 09:35:14', '60', '0', '1', null, null, '16', '0'), ('174', null, '102', '2019-03-28 09:36:54', '16', '2019-03-28 09:36:54', '60', '0', '1', null, null, '16', '0'), ('175', null, '103', '2019-03-28 09:37:05', '16', '2019-03-28 09:37:05', '60', '0', '1', null, null, '16', '0'), ('176', null, '72', '2019-03-28 09:38:08', '16', '2019-03-28 09:38:08', '60', '0', '1', null, null, '16', '0'), ('177', null, '74', '2019-03-28 09:38:43', '14', '2019-03-28 09:38:43', '60', '0', '1', null, null, '14', '0'), ('178', null, '101', '2019-03-28 09:39:19', '16', '2019-03-28 09:39:19', '60', '0', '1', null, null, '16', '0'), ('179', null, '72', '2019-03-28 09:39:20', '16', '2019-03-28 09:39:20', '60', '0', '1', null, null, '16', '0'), ('180', null, '80', '2019-03-28 09:39:43', '8', '2019-03-28 09:39:43', '60', '0', '1', null, null, '8', '0'), ('181', null, '84', '2019-03-28 09:40:25', '10', '2019-03-28 09:40:25', '60', '0', '1', null, null, '10', '0'), ('182', null, '85', '2019-03-28 09:40:48', '9', '2019-03-28 09:40:48', '60', '0', '1', null, null, '9', '0'), ('183', null, '89', '2019-03-28 09:40:52', '9', '2019-03-28 09:40:52', '60', '0', '1', null, null, '9', '0'), ('184', null, '90', '2019-03-28 09:43:13', '10', '2019-03-28 09:43:13', '60', '0', '1', null, null, '10', '0'), ('185', null, '92', '2019-03-28 09:43:27', '7', '2019-03-28 09:43:27', '60', '0', '1', null, null, '7', '0'), ('186', null, '94', '2019-03-28 09:44:04', '10', '2019-03-28 09:44:04', '60', '0', '1', null, null, '10', '0'), ('187', null, '95', '2019-03-28 09:44:05', '10', '2019-03-28 09:44:05', '60', '0', '1', null, null, '10', '0'), ('188', null, '96', '2019-03-28 09:44:19', '9', '2019-03-28 09:44:19', '60', '0', '1', null, null, '9', '0'), ('189', null, '97', '2019-03-28 09:44:20', '9', '2019-03-28 09:44:20', '60', '0', '1', null, null, '9', '0'), ('190', null, '98', '2019-03-28 09:44:47', '10', '2019-03-28 09:44:47', '60', '0', '1', null, null, '10', '0'), ('191', null, '99', '2019-03-28 09:45:08', '9', '2019-03-28 09:45:08', '60', '0', '1', null, null, '9', '0'), ('192', null, '100', '2019-03-28 09:45:22', '14', '2019-03-28 09:45:22', '60', '0', '1', null, null, '14', '0'), ('193', null, '71', '2019-03-28 20:30:24', '16', '2019-03-28 20:30:24', '61', '0', '1', null, null, '16', '0'), ('194', null, '102', '2019-03-28 20:31:18', '16', '2019-03-28 20:31:18', '61', '0', '1', null, null, '16', '0'), ('195', null, '103', '2019-03-28 20:31:30', '16', '2019-03-28 20:31:30', '61', '0', '1', null, null, '16', '0'), ('196', null, '101', '2019-03-28 20:31:42', '16', '2019-03-28 20:31:42', '61', '0', '1', null, null, '16', '0'), ('197', null, '72', '2019-03-28 20:32:08', '16', '2019-03-28 20:32:08', '61', '0', '1', null, null, '16', '0'), ('198', null, '74', '2019-03-28 20:32:22', '14', '2019-03-28 20:32:22', '61', '0', '1', null, null, '14', '0'), ('199', null, '72', '2019-03-28 20:33:12', '16', '2019-03-28 20:33:12', '61', '0', '1', null, null, '16', '0'), ('200', null, '80', '2019-03-28 20:33:27', '8', '2019-03-28 20:33:27', '61', '0', '1', null, null, '8', '0'), ('201', null, '84', '2019-03-28 20:36:05', '10', '2019-03-28 20:36:05', '61', '0', '1', null, null, '10', '0'), ('202', null, '85', '2019-03-28 20:36:33', '9', '2019-03-28 20:36:33', '61', '0', '1', null, null, '9', '0'), ('203', null, '89', '2019-03-28 20:36:35', '9', '2019-03-28 20:36:35', '61', '0', '1', null, null, '9', '0'), ('204', null, '90', '2019-03-28 20:42:27', '10', '2019-03-28 20:42:27', '61', '0', '1', null, null, '10', '0'), ('205', null, '92', '2019-03-28 20:42:46', '7', '2019-03-28 20:42:46', '61', '0', '1', null, null, '7', '0'), ('206', null, '94', '2019-03-28 20:43:26', '10', '2019-03-28 20:43:26', '61', '0', '1', null, null, '10', '0'), ('207', null, '95', '2019-03-28 20:43:27', '10', '2019-03-28 20:43:27', '61', '0', '1', null, null, '10', '0'), ('208', null, '96', '2019-03-28 20:43:48', '9', '2019-03-28 20:43:48', '61', '0', '1', null, null, '9', '0'), ('209', null, '97', '2019-03-28 20:43:49', '9', '2019-03-28 20:43:49', '61', '0', '1', null, null, '9', '0'), ('210', null, '98', '2019-03-28 20:44:13', '10', '2019-03-28 20:44:13', '61', '0', '1', null, null, '10', '0'), ('211', null, '99', '2019-03-28 20:44:25', '9', '2019-03-28 20:44:25', '61', '0', '1', null, null, '9', '0'), ('212', null, '100', '2019-03-28 20:46:32', '14', '2019-03-28 20:46:32', '61', '0', '1', null, null, '14', '0'), ('213', null, '71', '2019-03-28 22:41:09', '16', '2019-03-28 22:41:09', '62', '0', '1', null, null, '16', '0'), ('214', null, '102', '2019-03-28 22:41:45', '16', '2019-03-28 22:41:45', '62', '0', '1', null, null, '16', '0'), ('215', null, '103', '2019-03-28 22:41:58', '16', '2019-03-28 22:41:58', '62', '0', '1', null, null, '16', '0'), ('216', null, '72', '2019-03-28 22:42:02', '16', '2019-03-28 22:42:02', '62', '0', '1', null, null, '16', '0'), ('217', null, '74', '2019-03-28 22:42:18', '14', '2019-03-28 22:42:18', '62', '0', '1', null, null, '14', '0'), ('218', null, '101', '2019-03-28 22:42:35', '16', '2019-03-28 22:42:35', '62', '0', '1', null, null, '16', '0'), ('219', null, '72', '2019-03-28 22:42:37', '16', '2019-03-28 22:42:37', '62', '0', '1', null, null, '16', '0'), ('220', null, '80', '2019-03-28 22:42:51', '8', '2019-03-28 22:42:51', '62', '0', '1', null, null, '8', '0'), ('221', null, '84', '2019-03-28 22:43:25', '10', '2019-03-28 22:43:25', '62', '0', '1', null, null, '10', '0'), ('222', null, '85', '2019-03-28 22:43:41', '9', '2019-03-28 22:43:41', '62', '0', '1', null, null, '9', '0'), ('223', null, '89', '2019-03-28 22:43:42', '9', '2019-03-28 22:43:42', '62', '0', '1', null, null, '9', '0'), ('224', null, '90', '2019-03-28 22:49:54', '10', '2019-03-28 22:49:54', '62', '0', '1', null, null, '10', '0'), ('225', null, '92', '2019-03-28 22:50:13', '7', '2019-03-28 22:50:13', '62', '0', '1', null, null, '7', '0'), ('226', null, '94', '2019-03-28 22:53:18', '10', '2019-03-28 22:53:18', '62', '0', '1', null, null, '10', '0'), ('227', null, '95', '2019-03-28 22:53:19', '10', '2019-03-28 22:53:19', '62', '0', '1', null, null, '10', '0'), ('228', null, '96', '2019-03-28 22:53:30', '9', '2019-03-28 22:53:30', '62', '0', '1', null, null, '9', '0'), ('229', null, '97', '2019-03-28 22:53:32', '9', '2019-03-28 22:53:32', '62', '0', '1', null, null, '9', '0'), ('230', null, '98', '2019-03-28 22:53:50', '10', '2019-03-28 22:53:50', '62', '0', '1', null, null, '10', '0'), ('231', null, '99', '2019-03-28 22:54:09', '9', '2019-03-28 22:54:09', '62', '0', '1', null, null, '9', '0'), ('232', null, '100', '2019-03-28 22:56:36', '14', '2019-03-28 22:56:36', '62', '0', '1', null, null, '14', '0'), ('233', null, '71', '2019-04-02 02:06:47', '16', '2019-04-02 02:06:47', '63', '0', '1', null, null, '16', '0'), ('234', null, '101', '2019-04-02 02:07:02', '16', '2019-04-02 02:07:02', '63', '0', '1', null, null, '16', '0'), ('235', null, '72', '2019-04-02 02:07:15', '16', '2019-04-02 02:07:15', '63', '0', '1', null, null, '16', '0'), ('236', null, '74', '2019-04-02 02:07:39', '14', '2019-04-02 02:07:39', '63', '0', '1', null, null, '14', '0'), ('237', null, '102', '2019-04-02 02:08:36', '16', '2019-04-02 02:08:36', '63', '0', '1', null, null, '16', '0'), ('238', null, '103', '2019-04-02 02:08:54', '16', '2019-04-02 02:08:54', '63', '0', '1', null, null, '16', '0'), ('239', null, '72', '2019-04-02 02:09:01', '16', '2019-04-02 02:09:01', '63', '0', '1', null, null, '16', '0'), ('240', null, '80', '2019-04-02 02:09:26', '8', '2019-04-02 02:09:26', '63', '0', '1', null, null, '8', '0'), ('241', null, '84', '2019-04-02 02:10:22', '10', '2019-04-02 02:10:22', '63', '0', '1', null, null, '10', '0'), ('242', null, '85', '2019-04-02 02:10:55', '9', '2019-04-02 02:10:55', '63', '0', '1', null, null, '9', '0'), ('243', null, '89', '2019-04-02 02:11:01', '9', '2019-04-02 02:11:01', '63', '0', '1', null, null, '9', '0'), ('244', null, '90', '2019-04-02 02:12:02', '10', '2019-04-02 02:12:02', '63', '0', '1', null, null, '10', '0'), ('245', null, '92', '2019-04-02 02:12:21', '7', '2019-04-02 02:12:21', '63', '0', '1', null, null, '7', '0'), ('246', null, '94', '2019-04-02 02:12:55', '10', '2019-04-02 02:12:55', '63', '0', '1', null, null, '10', '0'), ('247', null, '95', '2019-04-02 02:13:00', '10', '2019-04-02 02:13:00', '63', '0', '1', null, null, '10', '0'), ('248', null, '96', '2019-04-02 02:13:16', '9', '2019-04-02 02:13:16', '63', '0', '1', null, null, '9', '0'), ('249', null, '97', '2019-04-02 02:13:20', '9', '2019-04-02 02:13:20', '63', '0', '1', null, null, '9', '0'), ('250', null, '98', '2019-04-02 02:13:45', '10', '2019-04-02 02:13:45', '63', '0', '1', null, null, '10', '0'), ('251', null, '99', '2019-04-02 02:14:13', '9', '2019-04-02 02:14:13', '63', '0', '1', null, null, '9', '0'), ('252', null, '100', '2019-04-02 02:14:24', '14', '2019-04-02 02:14:24', '63', '0', '1', null, null, '14', '0'), ('253', null, '71', '2019-04-02 04:53:10', '16', '2019-04-02 04:53:10', '64', '0', '1', null, null, '16', '0'), ('254', null, '72', '2019-04-02 04:53:15', '16', '2019-04-02 04:53:15', '64', '0', '1', null, null, '16', '0'), ('255', null, '74', '2019-04-02 04:53:35', '14', '2019-04-02 04:53:35', '64', '0', '1', null, null, '14', '0'), ('256', null, '102', '2019-04-02 04:54:13', '16', '2019-04-02 04:54:13', '64', '0', '1', null, null, '16', '0'), ('257', null, '72', '2019-04-02 04:54:16', '16', '2019-04-02 04:54:16', '64', '0', '1', null, null, '16', '0'), ('258', null, '80', '2019-04-02 04:54:34', '8', '2019-04-02 04:54:34', '64', '0', '1', null, null, '8', '0'), ('259', null, '84', '2019-04-02 04:55:09', '10', '2019-04-02 04:55:09', '64', '0', '1', null, null, '10', '0'), ('260', null, '85', '2019-04-02 04:55:21', '9', '2019-04-02 04:55:21', '64', '0', '1', null, null, '9', '0'), ('261', null, '89', '2019-04-02 04:55:33', '9', '2019-04-02 04:55:33', '64', '0', '1', null, null, '9', '0'), ('262', null, '90', '2019-04-02 04:56:33', '10', '2019-04-02 04:56:33', '64', '0', '1', null, null, '10', '0'), ('263', null, '92', '2019-04-02 04:56:49', '7', '2019-04-02 04:56:49', '64', '0', '1', null, null, '7', '0'), ('264', null, '94', '2019-04-02 04:57:29', '10', '2019-04-02 04:57:29', '64', '0', '1', null, null, '10', '0'), ('265', null, '95', '2019-04-02 04:57:31', '10', '2019-04-02 04:57:31', '64', '0', '1', null, null, '10', '0'), ('266', null, '96', '2019-04-02 04:57:50', '9', '2019-04-02 04:57:50', '64', '0', '1', null, null, '9', '0'), ('267', null, '97', '2019-04-02 04:57:51', '9', '2019-04-02 04:57:51', '64', '0', '1', null, null, '9', '0'), ('268', null, '98', '2019-04-02 04:58:15', '10', '2019-04-02 04:58:15', '64', '0', '1', null, null, '10', '0'), ('269', null, '99', '2019-04-02 04:58:25', '9', '2019-04-02 04:58:25', '64', '0', '1', null, null, '9', '0'), ('270', null, '100', '2019-04-02 08:05:20', '14', '2019-04-02 08:05:20', '64', '0', '1', null, null, '14', '0'), ('271', null, '71', '2019-04-08 08:16:44', '16', '2019-04-08 08:16:44', '65', '0', '1', null, null, '16', '0'), ('272', null, '101', '2019-04-08 08:17:26', '16', '2019-04-08 08:17:26', '65', '0', '1', null, null, '16', '0'), ('273', null, '101', '2019-04-08 08:17:37', '16', '2019-04-08 08:17:37', '65', '0', '1', null, null, '16', '0'), ('274', null, '72', '2019-04-11 15:14:33', '0', '2019-04-11 15:14:33', '67', '0', '1', null, null, '0', '0'), ('275', null, '72', '2019-04-11 15:14:50', '0', '2019-04-11 15:14:50', '68', '0', '1', null, null, '0', '0'), ('276', null, '72', '2019-04-11 15:14:50', '0', '2019-04-11 15:14:50', '69', '0', '1', null, null, '0', '0'), ('277', null, '72', '2019-04-11 15:14:53', '0', '2019-04-11 15:14:53', '70', '0', '1', null, null, '0', '0'), ('278', null, '72', '2019-04-12 01:20:41', '0', '2019-04-12 01:20:41', '71', '0', '1', null, null, '0', '0'), ('279', null, '72', '2019-04-12 01:20:41', '0', '2019-04-12 01:20:41', '72', '0', '1', null, null, '0', '0'), ('280', null, '74', '2019-04-12 01:21:01', '0', '2019-04-12 01:21:01', '71', '0', '1', null, null, '0', '0'), ('281', null, '74', '2019-04-12 01:21:01', '0', '2019-04-12 01:21:01', '72', '0', '1', null, null, '0', '0'), ('284', null, '72', '2019-04-12 05:45:16', '0', '2019-04-12 05:45:16', '79', '0', '1', null, null, '0', '0'), ('285', null, '72', '2019-04-12 05:45:16', '0', '2019-04-12 05:45:16', '80', '0', '1', null, null, '0', '0'), ('286', null, '74', '2019-04-12 05:47:28', '0', '2019-04-12 05:47:28', '79', '0', '1', null, null, '0', '0'), ('287', null, '74', '2019-04-12 05:47:28', '0', '2019-04-12 05:47:28', '80', '0', '1', null, null, '0', '0'), ('288', null, '71', '2019-04-13 16:26:53', '1', '2019-04-13 16:26:53', '81', '0', '1', null, null, '1', '0'), ('289', null, '71', '2019-04-14 02:02:12', '16', '2019-04-14 02:02:12', '82', '0', '1', null, null, '16', '0'), ('290', null, '71', '2019-04-14 02:57:32', '16', '2019-04-14 02:57:32', '83', '0', '1', null, null, '16', '0'), ('291', null, '71', '2019-04-14 03:01:19', '16', '2019-04-14 03:01:19', '84', '0', '1', null, null, '16', '0'), ('292', null, '71', '2019-04-14 06:07:17', '16', '2019-04-14 06:07:17', '85', '0', '1', null, null, '16', '0'), ('293', null, '71', '2019-04-15 15:47:44', '16', '2019-04-15 15:47:44', '86', '0', '1', null, null, '16', '0'), ('294', null, '72', '2019-04-16 03:29:49', '16', '2019-04-16 03:29:49', '86', '0', '1', null, null, '16', '0'), ('295', null, '74', '2019-04-16 05:56:09', '14', '2019-04-16 05:56:09', '86', '0', '1', null, null, '14', '0'), ('296', null, '72', '2019-04-16 05:57:03', '16', '2019-04-16 05:57:03', '86', '0', '1', null, null, '16', '0'), ('297', null, '72', '2019-04-16 05:58:03', '16', '2019-04-16 05:58:03', '85', '0', '1', null, null, '16', '0'), ('298', null, '101', '2019-04-17 11:36:01', '16', '2019-04-17 11:36:01', '80', '0', '1', null, null, '16', '0'), ('299', null, '101', '2019-04-17 11:55:45', '16', '2019-04-17 11:55:45', '80', '0', '1', null, null, '16', '0'), ('300', null, '101', '2019-04-17 12:23:21', '16', '2019-04-17 12:23:21', '80', '0', '1', null, null, '16', '0'), ('301', null, '101', '2019-04-17 12:23:29', '16', '2019-04-17 12:23:29', '80', '0', '1', null, null, '16', '0'), ('302', null, '101', '2019-04-17 12:23:40', '16', '2019-04-17 12:23:40', '80', '0', '1', null, null, '16', '0'), ('303', null, '101', '2019-04-17 12:47:34', '16', '2019-04-17 12:47:34', '80', '0', '1', null, null, '16', '0'), ('304', null, '101', '2019-04-17 12:47:42', '16', '2019-04-17 12:47:42', '80', '0', '1', null, null, '16', '0'), ('305', null, '101', '2019-04-17 12:47:48', '16', '2019-04-17 12:47:48', '80', '0', '1', null, null, '16', '0'), ('306', null, '101', '2019-04-17 13:49:57', '16', '2019-04-17 13:49:57', '80', '0', '1', null, null, '16', '0'), ('307', null, '101', '2019-04-17 13:50:17', '16', '2019-04-17 13:50:17', '80', '0', '1', null, null, '16', '0'), ('308', null, '101', '2019-04-17 15:21:00', '16', '2019-04-17 15:21:00', '80', '0', '1', null, null, '16', '0'), ('309', null, '101', '2019-04-17 15:21:10', '16', '2019-04-17 15:21:10', '80', '0', '1', null, null, '16', '0'), ('310', null, '101', '2019-04-18 01:04:06', '16', '2019-04-18 01:04:06', '80', '0', '1', null, null, '16', '0'), ('311', null, '101', '2019-04-18 01:04:18', '16', '2019-04-18 01:04:18', '80', '0', '1', null, null, '16', '0'), ('312', null, '101', '2019-04-18 01:04:25', '16', '2019-04-18 01:04:25', '80', '0', '1', null, null, '16', '0'), ('313', null, '72', '2019-04-18 06:21:03', '16', '2019-04-18 06:21:03', '80', '0', '1', null, null, '16', '0'), ('314', null, '72', '2019-04-18 06:27:38', '16', '2019-04-18 06:27:38', '84', '0', '1', null, null, '16', '0'), ('315', null, '72', '2019-04-18 06:34:17', '16', '2019-04-18 06:34:17', '82', '0', '1', null, null, '16', '0'), ('317', null, '72', '2019-04-18 08:15:29', '16', '2019-04-18 08:15:29', '65', '0', '1', null, null, '16', '0'), ('318', null, '71', '2019-04-19 15:44:22', '16', '2019-04-19 15:44:22', '87', '0', '1', null, null, '16', '0'), ('319', null, '72', '2019-04-19 15:46:46', '16', '2019-04-19 15:46:46', '87', '0', '1', null, null, '16', '0'), ('320', null, '74', '2019-04-19 15:47:31', '14', '2019-04-19 15:47:31', '87', '0', '1', null, null, '14', '0'), ('321', null, '101', '2019-04-21 15:28:29', '14', '2019-04-21 15:28:29', '82', '0', '1', null, null, '14', '0'), ('322', null, '72', '2019-04-22 01:22:29', '0', '2019-04-22 01:22:29', '88', '0', '1', null, null, '0', '0'), ('323', null, '74', '2019-04-22 02:00:05', '0', '2019-04-22 02:00:05', '88', '0', '1', null, null, '0', '0'), ('324', null, '72', '2019-04-22 07:20:04', '0', '2019-04-22 07:20:04', '89', '0', '1', null, null, '0', '0'), ('325', null, '74', '2019-04-22 07:21:59', '14', '2019-04-22 07:21:59', '89', '0', '1', null, null, '14', '0'), ('326', null, '0', '2019-04-22 07:21:59', '14', '2019-10-09 16:00:00', '89', '0', '1', null, null, '14', '4'), ('327', null, '0', '2019-04-22 07:21:59', '14', '2019-08-18 16:00:00', '89', '0', '1', null, null, '14', '5'), ('328', null, '0', '2019-04-22 07:21:59', '14', '2019-09-08 16:00:00', '89', '0', '1', null, null, '14', '6'), ('332', null, '72', '2019-04-22 08:28:11', '15', '2019-04-22 08:28:11', '89', '0', '1', null, null, '15', '0'), ('333', null, '0', '2019-04-22 08:28:11', '15', '2009-10-09 16:00:00', '89', '0', '1', null, null, '15', '78'), ('334', null, '0', '2019-04-22 08:28:11', '15', '2025-10-09 16:00:00', '89', '0', '1', null, null, '15', '79'), ('335', null, '80', '2019-04-22 09:10:42', '8', '2019-04-22 09:10:42', '89', '0', '1', null, null, '8', '0'), ('336', null, '84', '2019-04-22 09:13:06', '10', '2019-04-22 09:13:06', '89', '0', '1', null, null, '10', '0'), ('337', null, '85', '2019-04-22 09:14:39', '9', '2019-04-22 09:14:39', '89', '0', '1', null, null, '9', '0'), ('338', null, '0', '2019-04-22 09:14:39', '9', '2019-10-09 16:00:00', '89', '0', '1', '2019-04-22 09:16:02', '9', '9', '8'), ('339', null, '0', '2019-04-22 09:14:39', '9', '2019-10-09 16:00:00', '89', '0', '1', '2019-04-22 09:16:02', '9', '9', '9'), ('340', null, '0', '2019-04-22 09:14:39', '9', '2019-10-09 16:00:00', '89', '0', '1', '2019-04-22 09:16:02', '9', '9', '10'), ('341', null, '0', '2019-04-22 09:14:39', '9', '2019-10-09 16:00:00', '89', '0', '1', '2019-04-22 09:16:02', '9', '9', '11'), ('342', null, '0', '2019-04-22 09:14:39', '9', '2019-10-09 16:00:00', '89', '0', '1', '2019-04-22 09:16:02', '9', '9', '12'), ('343', null, '0', '2019-04-22 09:14:39', '9', '2019-10-09 16:00:00', '89', '0', '1', '2019-04-22 09:16:02', '9', '9', '13'), ('344', null, '89', '2019-04-22 09:16:02', '9', '2019-04-22 09:16:02', '89', '0', '1', null, null, '9', '0'), ('345', null, '0', '2019-04-22 09:16:02', '9', '2019-10-09 16:00:00', '89', '0', '1', null, null, '9', '14'), ('346', null, '90', '2019-04-22 09:19:00', '10', '2019-04-22 09:19:00', '89', '0', '1', null, null, '10', '0'), ('347', null, '92', '2019-04-22 09:30:33', '7', '2019-04-22 09:30:33', '89', '0', '1', null, null, '7', '0'), ('348', null, '94', '2019-04-22 09:31:09', '10', '2019-04-22 09:31:09', '89', '0', '1', null, null, '10', '0'), ('349', null, '95', '2019-04-22 09:31:34', '10', '2019-04-22 09:31:34', '89', '0', '1', null, null, '10', '0'), ('350', null, '0', '2019-04-22 09:31:34', '10', '2019-10-09 16:00:00', '89', '0', '1', null, null, '10', '20'), ('351', null, '72', '2019-04-22 10:40:08', '15', '2019-04-22 10:40:08', '90', '0', '1', null, null, '15', '0'), ('352', null, '74', '2019-04-22 10:46:57', '14', '2019-04-22 10:46:57', '90', '0', '1', null, null, '14', '0'), ('353', null, '0', '2019-04-22 10:46:57', '14', '2019-10-09 16:00:00', '90', '0', '1', null, null, '14', '4'), ('354', null, '0', '2019-04-22 10:46:57', '14', '2019-08-18 16:00:00', '90', '0', '1', null, null, '14', '5'), ('355', null, '0', '2019-04-22 10:46:57', '14', '2019-09-08 16:00:00', '90', '0', '1', null, null, '14', '6'), ('356', null, '72', '2019-04-22 11:19:26', '15', '2019-04-22 11:19:26', '90', '0', '1', null, null, '15', '0'), ('357', null, '0', '2019-04-22 11:19:26', '15', '2009-10-09 16:00:00', '90', '0', '1', null, null, '15', '78'), ('358', null, '0', '2019-04-22 11:19:26', '15', '2025-10-09 16:00:00', '90', '0', '1', null, null, '15', '79'), ('359', null, '80', '2019-04-22 11:26:59', '8', '2019-04-22 11:26:59', '90', '0', '1', null, null, '8', '0'), ('360', null, '84', '2019-04-22 11:27:46', '10', '2019-04-22 11:27:46', '90', '0', '1', null, null, '10', '0'), ('361', null, '85', '2019-04-22 11:28:54', '9', '2019-04-22 11:28:54', '90', '0', '1', null, null, '9', '0'), ('362', null, '0', '2019-04-22 11:28:54', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '8'), ('363', null, '0', '2019-04-22 11:28:54', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '9'), ('364', null, '0', '2019-04-22 11:28:54', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '10'), ('365', null, '0', '2019-04-22 11:28:54', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '11'), ('366', null, '0', '2019-04-22 11:28:54', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '12'), ('367', null, '0', '2019-04-22 11:28:54', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '13'), ('368', null, '89', '2019-04-22 11:50:41', '9', '2019-04-22 11:50:41', '90', '0', '1', null, null, '9', '0'), ('369', null, '0', '2019-04-22 11:50:41', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '7'), ('370', null, '0', '2019-04-22 11:50:41', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '14'), ('371', null, '0', '2019-04-22 11:50:41', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '15'), ('372', null, '0', '2019-04-22 11:50:41', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '18'), ('373', null, '0', '2019-04-22 11:50:41', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '22'), ('374', null, '0', '2019-04-22 11:50:41', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '24'), ('375', null, '0', '2019-04-22 11:50:41', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '26'), ('376', null, '0', '2019-04-22 11:50:41', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '27'), ('377', null, '0', '2019-04-22 11:50:41', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '28'), ('378', null, '0', '2019-04-22 11:50:41', '9', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:27', '9', '9', '29'), ('379', null, '90', '2019-04-22 11:52:14', '10', '2019-04-22 11:52:14', '90', '0', '1', null, null, '10', '0'), ('380', null, '92', '2019-04-22 11:52:45', '7', '2019-04-22 11:52:45', '90', '0', '1', null, null, '7', '0'), ('381', null, '94', '2019-04-22 11:53:15', '10', '2019-04-22 11:53:15', '90', '0', '1', null, null, '10', '0'), ('382', null, '95', '2019-04-22 11:53:24', '10', '2019-04-22 11:53:24', '90', '0', '1', null, null, '10', '0'), ('383', null, '0', '2019-04-22 11:53:24', '10', '2019-10-09 16:00:00', '90', '0', '1', '2019-04-22 11:55:02', '10', '10', '20'), ('384', null, '96', '2019-04-22 11:54:08', '9', '2019-04-22 11:54:08', '90', '0', '1', null, null, '9', '0'), ('385', null, '97', '2019-04-22 11:54:16', '9', '2019-04-22 11:54:16', '90', '0', '1', null, null, '9', '0'), ('386', null, '98', '2019-04-22 11:55:02', '10', '2019-04-22 11:55:02', '90', '0', '1', null, null, '10', '0'), ('387', null, '0', '2019-04-22 11:55:02', '10', '2019-10-09 16:00:00', '90', '0', '1', null, null, '10', '30'), ('388', null, '0', '2019-04-22 11:55:02', '10', '2019-10-09 16:00:00', '90', '0', '1', null, null, '10', '31'), ('389', null, '99', '2019-04-22 11:55:27', '9', '2019-04-22 11:55:27', '90', '0', '1', null, null, '9', '0'), ('390', null, '72', '2019-04-22 15:00:08', '15', '2019-04-22 15:00:08', '91', '0', '1', null, null, '15', '0'), ('391', null, '100', '2019-04-22 15:04:55', '14', '2019-04-22 15:04:55', '90', '0', '1', null, null, '14', '0'), ('392', null, '74', '2019-04-22 15:05:20', '14', '2019-04-22 15:05:20', '91', '0', '1', null, null, '14', '0'), ('393', null, '0', '2019-04-22 15:05:20', '14', '2019-10-09 16:00:00', '91', '0', '1', null, null, '14', '4'), ('394', null, '0', '2019-04-22 15:05:20', '14', '2019-08-18 16:00:00', '91', '0', '1', null, null, '14', '5'), ('395', null, '0', '2019-04-22 15:05:20', '14', '2019-09-08 16:00:00', '91', '0', '1', null, null, '14', '6'), ('396', null, '72', '2019-04-24 00:28:12', '15', '2019-04-24 00:28:12', '92', '0', '1', null, null, '15', '0'), ('397', null, '74', '2019-04-24 01:54:51', '14', '2019-04-24 01:54:51', '92', '0', '1', null, null, '14', '0'), ('398', null, '0', '2019-04-24 01:54:51', '14', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:44', '14', '14', '4'), ('399', null, '0', '2019-04-24 01:54:51', '14', '2019-08-18 16:00:00', '92', '0', '1', '2019-04-24 02:05:44', '14', '14', '5'), ('400', null, '0', '2019-04-24 01:54:51', '14', '2019-09-08 16:00:00', '92', '0', '1', '2019-04-24 02:05:44', '14', '14', '6'), ('401', null, '72', '2019-04-24 01:56:10', '15', '2019-04-24 01:56:10', '92', '0', '1', null, null, '15', '0'), ('402', null, '0', '2019-04-24 01:56:10', '15', '2009-10-09 16:00:00', '92', '0', '1', null, null, '15', '78'), ('403', null, '0', '2019-04-24 01:56:10', '15', '2025-10-09 16:00:00', '92', '0', '1', null, null, '15', '79'), ('404', null, '80', '2019-04-24 01:56:48', '8', '2019-04-24 01:56:48', '92', '0', '1', null, null, '8', '0'), ('405', null, '84', '2019-04-24 01:57:55', '10', '2019-04-24 01:57:55', '92', '0', '1', null, null, '10', '0'), ('406', null, '85', '2019-04-24 01:59:01', '9', '2019-04-24 01:59:01', '92', '0', '1', null, null, '9', '0'), ('407', null, '0', '2019-04-24 01:59:01', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '8'), ('408', null, '0', '2019-04-24 01:59:01', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '9'), ('409', null, '0', '2019-04-24 01:59:01', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '10'), ('410', null, '0', '2019-04-24 01:59:01', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '11'), ('411', null, '0', '2019-04-24 01:59:01', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '12'), ('412', null, '0', '2019-04-24 01:59:01', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '13'), ('413', null, '89', '2019-04-24 01:59:46', '9', '2019-04-24 01:59:46', '92', '0', '1', null, null, '9', '0'), ('414', null, '0', '2019-04-24 01:59:46', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '15'), ('415', null, '0', '2019-04-24 01:59:46', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '18'), ('416', null, '72', '2019-04-24 02:00:10', '15', '2019-04-24 02:00:10', '93', '0', '1', null, null, '15', '0'), ('417', null, '90', '2019-04-24 02:00:44', '10', '2019-04-24 02:00:44', '92', '0', '1', null, null, '10', '0'), ('418', null, '92', '2019-04-24 02:02:43', '7', '2019-04-24 02:02:43', '92', '0', '1', null, null, '7', '0'), ('419', null, '94', '2019-04-24 02:03:06', '10', '2019-04-24 02:03:06', '92', '0', '1', null, null, '10', '0'), ('420', null, '95', '2019-04-24 02:03:28', '10', '2019-04-24 02:03:28', '92', '0', '1', null, null, '10', '0'), ('421', null, '0', '2019-04-24 02:03:28', '10', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:04:52', '10', '10', '20'), ('422', null, '96', '2019-04-24 02:04:01', '9', '2019-04-24 02:04:01', '92', '0', '1', null, null, '9', '0'), ('423', null, '0', '2019-04-24 02:04:01', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '22'), ('424', null, '0', '2019-04-24 02:04:01', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '24'), ('425', null, '0', '2019-04-24 02:04:01', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '26'), ('426', null, '97', '2019-04-24 02:04:11', '9', '2019-04-24 02:04:11', '92', '0', '1', null, null, '9', '0'), ('427', null, '0', '2019-04-24 02:04:11', '9', '2019-12-08 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '7'), ('428', null, '0', '2019-04-24 02:04:11', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '27'), ('429', null, '0', '2019-04-24 02:04:11', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '28'), ('430', null, '0', '2019-04-24 02:04:11', '9', '2019-10-09 16:00:00', '92', '0', '1', '2019-04-24 02:05:24', '9', '9', '29'), ('431', null, '98', '2019-04-24 02:04:52', '10', '2019-04-24 02:04:52', '92', '0', '1', null, null, '10', '0'), ('432', null, '0', '2019-04-24 02:04:52', '10', '2019-10-09 16:00:00', '92', '0', '1', null, null, '10', '30'), ('433', null, '0', '2019-04-24 02:04:52', '10', '2019-10-09 16:00:00', '92', '0', '1', null, null, '10', '31'), ('434', null, '99', '2019-04-24 02:05:24', '9', '2019-04-24 02:05:24', '92', '0', '1', null, null, '9', '0'), ('435', null, '100', '2019-04-24 02:05:44', '14', '2019-04-24 02:05:44', '92', '0', '1', null, null, '14', '0'), ('436', null, '72', '2019-04-24 03:00:32', '15', '2019-04-24 03:00:32', '94', '0', '1', null, null, '15', '0'), ('437', null, '74', '2019-04-24 03:11:07', '15', '2019-04-24 03:11:07', '94', '0', '1', null, null, '15', '0'), ('438', null, '74', '2019-04-24 03:11:07', '15', '2019-04-24 03:11:07', '93', '0', '1', null, null, '15', '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_cbs_order_pool`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_order_pool`;
CREATE TABLE `t_cbs_order_pool` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `into_time` datetime DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `do_state` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `into_pool_no` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=280 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_order_pool`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_order_pool` VALUES ('1', '2019-03-22 23:47:07', '2019-03-23 01:29:19', '47', '3', '13', '11', '1', '2019-03-22 23:47:07', '13', '2019-03-23 01:29:19', '13', '0'), ('2', '2019-03-22 23:54:14', '2019-03-23 01:29:53', '48', '3', '13', '11', '1', '2019-03-22 23:54:14', '13', '2019-03-23 01:29:53', '13', '0'), ('3', '2019-03-23 01:29:19', null, '47', '3', '0', '8', '1', '2019-03-23 01:29:19', '13', null, '0', '0'), ('4', '2019-03-23 01:29:53', null, '48', '3', '0', '8', '1', '2019-03-23 01:29:53', '13', null, '0', '0'), ('5', '2019-03-23 01:53:01', '2019-03-23 01:53:26', '49', '3', '13', '11', '1', '2019-03-23 01:53:01', '13', '2019-03-23 01:53:26', '13', '0'), ('6', '2019-03-23 01:53:26', '2019-03-23 01:58:44', '49', '3', '14', '8', '1', '2019-03-23 01:53:26', '13', '2019-03-23 01:58:44', '14', '0'), ('7', '2019-03-23 01:58:44', '2019-03-23 02:04:15', '49', '3', '8', '6', '1', '2019-03-23 01:58:44', '14', '2019-03-23 02:04:15', '8', '0'), ('8', '2019-03-23 02:04:15', '2019-03-23 07:43:10', '49', '3', '13', '11', '2', '2019-03-23 02:04:15', '8', '2019-03-23 07:43:10', '13', '0'), ('9', '2019-03-23 07:43:10', '2019-03-23 07:44:24', '49', '3', '8', '6', '2', '2019-03-23 07:43:10', '13', '2019-03-23 07:44:24', '8', '0'), ('10', '2019-03-23 07:44:25', '2019-03-23 08:08:16', '49', '3', '13', '11', '2', '2019-03-23 07:44:25', '8', '2019-03-23 08:08:16', '13', '0'), ('11', '2019-03-23 08:08:16', null, '49', '3', '13', '11', '3', '2019-03-23 08:08:16', '13', null, '0', '1'), ('12', '2019-03-23 08:22:29', '2019-03-23 08:25:16', '50', '3', '13', '11', '1', '2019-03-23 08:22:29', '13', '2019-03-23 08:25:16', '13', '1'), ('13', '2019-03-23 08:25:16', '2019-03-23 08:27:17', '50', '3', '14', '8', '1', '2019-03-23 08:25:16', '13', '2019-03-23 08:27:17', '14', '1'), ('14', '2019-03-23 08:27:17', '2019-03-24 23:02:14', '50', '3', '8', '6', '1', '2019-03-23 08:27:17', '14', '2019-03-24 23:02:14', '8', '1'), ('15', '2019-03-23 08:28:10', '2019-03-23 08:28:48', '51', '3', '13', '11', '1', '2019-03-23 08:28:10', '13', '2019-03-23 08:28:48', '13', '1'), ('16', '2019-03-23 08:28:48', '2019-03-23 08:38:13', '51', '3', '14', '8', '1', '2019-03-23 08:28:48', '13', '2019-03-23 08:38:13', '14', '1'), ('17', '2019-03-23 08:38:13', '2019-03-23 10:31:30', '51', '3', '8', '6', '1', '2019-03-23 08:38:13', '14', '2019-03-23 10:31:30', '8', '1'), ('18', '2019-03-23 10:31:30', '2019-03-25 01:53:15', '51', '3', '13', '11', '2', '2019-03-23 10:31:30', '8', '2019-03-25 01:53:15', '13', '1'), ('19', '2019-03-24 23:02:14', '2019-03-25 01:53:25', '50', '3', '13', '11', '2', '2019-03-24 23:02:14', '8', '2019-03-25 01:53:25', '13', '1'), ('20', '2019-03-25 01:53:15', '2019-03-25 01:54:03', '51', '3', '8', '6', '2', '2019-03-25 01:53:15', '13', '2019-03-25 01:54:03', '8', '1'), ('21', '2019-03-25 01:53:25', '2019-03-25 01:54:10', '50', '3', '8', '6', '2', '2019-03-25 01:53:25', '13', '2019-03-25 01:54:10', '8', '1'), ('24', '2019-03-25 01:55:33', '2019-03-25 01:56:32', '51', '3', '9', '7', '1', '2019-03-25 01:55:33', '10', '2019-03-25 01:56:32', '9', '1'), ('25', '2019-03-25 01:55:39', '2019-03-25 01:56:52', '50', '3', '9', '7', '1', '2019-03-25 01:55:39', '10', '2019-03-25 01:56:52', '9', '1'), ('26', '2019-03-25 01:56:33', '2019-03-25 01:57:17', '51', '3', '9', '7', '2', '2019-03-25 01:56:33', '9', '2019-03-25 01:57:17', '9', '1'), ('27', '2019-03-25 01:56:52', '2019-03-25 01:57:11', '50', '3', '9', '7', '2', '2019-03-25 01:56:52', '9', '2019-03-25 01:57:11', '9', '1'), ('30', '2019-03-25 02:08:18', '2019-03-25 02:10:30', '50', '3', '7', '14', '1', '2019-03-25 02:08:18', '10', '2019-03-25 02:10:30', '7', '1'), ('31', '2019-03-25 02:08:25', '2019-03-25 02:10:23', '51', '3', '7', '14', '1', '2019-03-25 02:08:25', '10', '2019-03-25 02:10:23', '7', '1'), ('36', '2019-03-25 02:11:22', '2019-03-25 02:12:23', '50', '3', '9', '7', '3', '2019-03-25 02:11:22', '10', '2019-03-25 02:12:23', '9', '1'), ('37', '2019-03-25 02:11:26', '2019-03-25 02:12:16', '51', '3', '9', '7', '3', '2019-03-25 02:11:26', '10', '2019-03-25 02:12:16', '9', '1'), ('38', '2019-03-25 02:12:16', '2019-03-25 02:12:34', '51', '3', '9', '7', '4', '2019-03-25 02:12:16', '9', '2019-03-25 02:12:34', '9', '1'), ('39', '2019-03-25 02:12:23', '2019-03-25 02:12:29', '50', '3', '9', '7', '4', '2019-03-25 02:12:23', '9', '2019-03-25 02:12:29', '9', '1'), ('42', '2019-03-25 02:13:03', '2019-03-25 02:13:50', '50', '3', '9', '7', '5', '2019-03-25 02:13:03', '10', '2019-03-25 02:13:50', '9', '1'), ('43', '2019-03-25 02:13:08', '2019-03-25 02:13:55', '51', '3', '9', '7', '5', '2019-03-25 02:13:08', '10', '2019-03-25 02:13:55', '9', '1'), ('44', '2019-03-25 02:13:50', null, '50', '3', '14', '8', '2', '2019-03-25 02:13:50', '9', null, '0', '1'), ('45', '2019-03-25 02:13:55', null, '51', '3', '14', '8', '2', '2019-03-25 02:13:55', '9', null, '0', '1'), ('46', '2019-03-25 10:09:32', '2019-03-25 10:11:26', '52', '3', '13', '11', '1', '2019-03-25 10:09:32', '13', '2019-03-25 10:11:26', '13', '1'), ('47', '2019-03-25 10:11:26', '2019-03-25 10:12:11', '52', '3', '14', '8', '1', '2019-03-25 10:11:26', '13', '2019-03-25 10:12:11', '14', '1'), ('48', '2019-03-25 10:12:11', '2019-03-25 10:13:27', '52', '3', '13', '11', '2', '2019-03-25 10:12:11', '14', '2019-03-25 10:13:27', '13', '1'), ('49', '2019-03-25 10:13:27', '2019-03-25 10:13:48', '52', '3', '8', '6', '1', '2019-03-25 10:13:27', '13', '2019-03-25 10:13:48', '8', '1'), ('51', '2019-03-26 04:42:55', null, '53', '3', '13', '11', '1', '2019-03-26 04:42:55', '13', null, '0', '1'), ('52', '2019-03-26 20:54:26', '2019-03-26 20:55:26', '54', '3', '13', '11', '1', '2019-03-26 20:54:26', '13', '2019-03-26 20:55:26', '13', '1'), ('53', '2019-03-26 20:55:26', '2019-03-26 20:59:02', '54', '3', '14', '8', '1', '2019-03-26 20:55:26', '13', '2019-03-26 20:59:02', '14', '1'), ('54', '2019-03-26 20:59:02', '2019-03-26 20:59:35', '54', '3', '13', '11', '2', '2019-03-26 20:59:02', '14', '2019-03-26 20:59:35', '13', '1'), ('55', '2019-03-26 20:59:35', '2019-03-27 03:32:04', '54', '3', '8', '6', '1', '2019-03-26 20:59:35', '13', '2019-03-27 03:32:04', '8', '1'), ('65', '2019-03-27 03:32:04', null, '54', '2', '10', '12', '1', '2019-03-27 03:32:04', '8', null, '0', '1'), ('66', '2019-03-27 03:40:48', '2019-03-27 03:44:38', '55', '3', '13', '11', '1', '2019-03-27 03:40:48', '13', '2019-03-27 03:44:38', '13', '1'), ('67', '2019-03-27 03:44:38', '2019-03-27 03:45:28', '55', '3', '14', '8', '1', '2019-03-27 03:44:38', '13', '2019-03-27 03:45:28', '14', '1'), ('68', '2019-03-27 03:45:28', '2019-03-27 03:46:25', '55', '3', '13', '11', '2', '2019-03-27 03:45:28', '14', '2019-03-27 03:46:25', '13', '1'), ('69', '2019-03-27 03:46:25', '2019-03-27 03:48:18', '55', '3', '8', '6', '1', '2019-03-27 03:46:25', '13', '2019-03-27 03:48:18', '8', '1'), ('70', '2019-03-27 03:48:18', '2019-03-27 04:42:11', '55', '3', '10', '12', '1', '2019-03-27 03:48:18', '8', '2019-03-27 04:42:11', '10', '1'), ('71', '2019-03-27 04:42:11', '2019-03-27 04:42:45', '55', '3', '9', '7', '1', '2019-03-27 04:42:11', '10', '2019-03-27 04:42:45', '9', '1'), ('72', '2019-03-27 04:42:45', '2019-03-27 07:08:29', '55', '3', '9', '7', '2', '2019-03-27 04:42:45', '9', '2019-03-27 07:08:29', '9', '1'), ('83', '2019-03-27 07:08:29', '2019-03-27 07:11:45', '55', '3', '10', '12', '2', '2019-03-27 07:08:29', '9', '2019-03-27 07:11:45', '10', '1'), ('84', '2019-03-27 07:11:45', '2019-03-27 07:13:06', '55', '3', '7', '14', '1', '2019-03-27 07:11:45', '10', '2019-03-27 07:13:06', '7', '1'), ('85', '2019-03-27 07:13:06', '2019-03-27 07:13:43', '55', '3', '10', '12', '3', '2019-03-27 07:13:06', '7', '2019-03-27 07:13:43', '10', '1'), ('86', '2019-03-27 07:13:43', '2019-03-27 07:14:04', '55', '3', '10', '12', '4', '2019-03-27 07:13:43', '10', '2019-03-27 07:14:04', '10', '1'), ('87', '2019-03-27 07:14:04', '2019-03-27 07:14:20', '55', '3', '9', '7', '3', '2019-03-27 07:14:04', '10', '2019-03-27 07:14:20', '9', '1'), ('88', '2019-03-27 07:14:20', '2019-03-27 07:14:23', '55', '3', '9', '7', '4', '2019-03-27 07:14:20', '9', '2019-03-27 07:14:23', '9', '1'), ('89', '2019-03-27 07:14:23', '2019-03-27 07:14:52', '55', '3', '10', '12', '5', '2019-03-27 07:14:23', '9', '2019-03-27 07:14:52', '10', '1'), ('90', '2019-03-27 07:14:52', '2019-03-27 07:25:03', '55', '3', '9', '7', '5', '2019-03-27 07:14:52', '10', '2019-03-27 07:25:03', '9', '1'), ('92', '2019-03-27 07:25:03', '2019-03-27 07:39:43', '55', '3', '14', '8', '2', '2019-03-27 07:25:03', '9', '2019-03-27 07:39:43', '14', '1'), ('93', '2019-03-28 06:45:33', null, '56', '2', '13', '11', '1', '2019-03-28 06:45:33', '13', null, '0', '1'), ('94', '2019-03-28 06:50:10', null, '57', '2', '15', '11', '1', '2019-03-28 06:50:10', '15', null, '0', '1'), ('95', '2019-03-28 07:15:11', '2019-03-28 07:21:57', '58', '3', '16', '11', '1', '2019-03-28 07:15:11', '16', '2019-03-28 07:21:57', '16', '1'), ('96', '2019-03-28 07:21:57', '2019-03-28 07:23:11', '58', '3', '14', '8', '1', '2019-03-28 07:21:57', '16', '2019-03-28 07:23:11', '14', '1'), ('97', '2019-03-28 07:23:11', '2019-03-28 07:23:47', '58', '3', '16', '11', '2', '2019-03-28 07:23:11', '14', '2019-03-28 07:23:47', '16', '1'), ('98', '2019-03-28 07:23:47', '2019-03-28 07:24:18', '58', '3', '8', '6', '1', '2019-03-28 07:23:47', '16', '2019-03-28 07:24:18', '8', '1'), ('99', '2019-03-28 07:24:18', '2019-03-28 07:28:50', '58', '3', '10', '12', '1', '2019-03-28 07:24:18', '8', '2019-03-28 07:28:50', '10', '1'), ('100', '2019-03-28 07:28:50', '2019-03-28 07:29:07', '58', '3', '9', '7', '1', '2019-03-28 07:28:50', '10', '2019-03-28 07:29:07', '9', '1'), ('101', '2019-03-28 07:29:07', '2019-03-28 07:29:20', '58', '3', '9', '7', '2', '2019-03-28 07:29:07', '9', '2019-03-28 07:29:20', '9', '1'), ('102', '2019-03-28 07:29:20', null, '58', '2', '10', '12', '2', '2019-03-28 07:29:20', '9', null, '0', '1'), ('103', '2019-03-28 08:01:59', '2019-03-28 08:03:07', '59', '3', '16', '11', '1', '2019-03-28 08:01:59', '16', '2019-03-28 08:03:07', '16', '1'), ('104', '2019-03-28 08:03:07', '2019-03-28 08:05:04', '59', '3', '14', '8', '1', '2019-03-28 08:03:07', '16', '2019-03-28 08:05:04', '14', '1'), ('105', '2019-03-28 08:05:04', '2019-03-28 08:05:49', '59', '3', '16', '11', '2', '2019-03-28 08:05:04', '14', '2019-03-28 08:05:49', '16', '1'), ('106', '2019-03-28 08:05:49', '2019-03-28 08:06:04', '59', '3', '8', '6', '1', '2019-03-28 08:05:49', '16', '2019-03-28 08:06:04', '8', '1'), ('107', '2019-03-28 08:06:04', '2019-03-28 08:07:28', '59', '3', '10', '12', '1', '2019-03-28 08:06:04', '8', '2019-03-28 08:07:28', '10', '1'), ('108', '2019-03-28 08:07:28', '2019-03-28 08:07:43', '59', '3', '9', '7', '1', '2019-03-28 08:07:28', '10', '2019-03-28 08:07:43', '9', '1'), ('109', '2019-03-28 08:07:43', '2019-03-28 08:08:03', '59', '3', '9', '7', '2', '2019-03-28 08:07:43', '9', '2019-03-28 08:08:03', '9', '1'), ('110', '2019-03-28 08:08:03', '2019-03-28 08:09:19', '59', '3', '10', '12', '2', '2019-03-28 08:08:03', '9', '2019-03-28 08:09:19', '10', '1'), ('111', '2019-03-28 08:09:19', '2019-03-28 08:09:51', '59', '3', '7', '14', '1', '2019-03-28 08:09:19', '10', '2019-03-28 08:09:51', '7', '1'), ('112', '2019-03-28 08:09:51', '2019-03-28 08:10:47', '59', '3', '10', '12', '3', '2019-03-28 08:09:51', '7', '2019-03-28 08:10:47', '10', '1'), ('113', '2019-03-28 08:10:47', '2019-03-28 08:10:49', '59', '3', '10', '12', '4', '2019-03-28 08:10:47', '10', '2019-03-28 08:10:49', '10', '1'), ('114', '2019-03-28 08:10:49', '2019-03-28 08:11:07', '59', '3', '9', '7', '3', '2019-03-28 08:10:49', '10', '2019-03-28 08:11:07', '9', '1'), ('115', '2019-03-28 08:11:07', '2019-03-28 08:11:10', '59', '3', '9', '7', '4', '2019-03-28 08:11:07', '9', '2019-03-28 08:11:10', '9', '1'), ('116', '2019-03-28 08:11:10', '2019-03-28 08:11:37', '59', '3', '10', '12', '5', '2019-03-28 08:11:10', '9', '2019-03-28 08:11:37', '10', '1'), ('117', '2019-03-28 08:11:37', '2019-03-28 08:11:51', '59', '3', '9', '7', '5', '2019-03-28 08:11:37', '10', '2019-03-28 08:11:51', '9', '1'), ('118', '2019-03-28 08:11:51', '2019-03-28 08:12:05', '59', '3', '14', '8', '2', '2019-03-28 08:11:51', '9', '2019-03-28 08:12:05', '14', '1'), ('119', '2019-03-28 09:35:14', '2019-03-28 09:38:08', '60', '3', '16', '11', '1', '2019-03-28 09:35:14', '16', '2019-03-28 09:38:08', '16', '1'), ('120', '2019-03-28 09:38:08', '2019-03-28 09:38:43', '60', '3', '14', '8', '1', '2019-03-28 09:38:08', '16', '2019-03-28 09:38:43', '14', '1'), ('121', '2019-03-28 09:38:43', '2019-03-28 09:39:20', '60', '3', '16', '11', '2', '2019-03-28 09:38:43', '14', '2019-03-28 09:39:20', '16', '1'), ('122', '2019-03-28 09:39:20', '2019-03-28 09:39:43', '60', '3', '8', '6', '1', '2019-03-28 09:39:20', '16', '2019-03-28 09:39:43', '8', '1'), ('123', '2019-03-28 09:39:43', '2019-03-28 09:40:25', '60', '3', '10', '12', '1', '2019-03-28 09:39:43', '8', '2019-03-28 09:40:25', '10', '1'), ('124', '2019-03-28 09:40:25', '2019-03-28 09:40:48', '60', '3', '9', '7', '1', '2019-03-28 09:40:25', '10', '2019-03-28 09:40:48', '9', '1'), ('125', '2019-03-28 09:40:48', '2019-03-28 09:40:52', '60', '3', '9', '7', '2', '2019-03-28 09:40:48', '9', '2019-03-28 09:40:52', '9', '1'), ('126', '2019-03-28 09:40:52', '2019-03-28 09:43:13', '60', '3', '10', '12', '2', '2019-03-28 09:40:52', '9', '2019-03-28 09:43:13', '10', '1'), ('127', '2019-03-28 09:43:13', '2019-03-28 09:43:27', '60', '3', '7', '14', '1', '2019-03-28 09:43:13', '10', '2019-03-28 09:43:27', '7', '1'), ('128', '2019-03-28 09:43:27', '2019-03-28 09:44:04', '60', '3', '10', '12', '3', '2019-03-28 09:43:27', '7', '2019-03-28 09:44:04', '10', '1'), ('129', '2019-03-28 09:44:04', '2019-03-28 09:44:05', '60', '3', '10', '12', '4', '2019-03-28 09:44:04', '10', '2019-03-28 09:44:05', '10', '1'), ('130', '2019-03-28 09:44:05', '2019-03-28 09:44:19', '60', '3', '9', '7', '3', '2019-03-28 09:44:05', '10', '2019-03-28 09:44:19', '9', '1'), ('131', '2019-03-28 09:44:19', '2019-03-28 09:44:20', '60', '3', '9', '7', '4', '2019-03-28 09:44:19', '9', '2019-03-28 09:44:20', '9', '1'), ('132', '2019-03-28 09:44:20', '2019-03-28 09:44:47', '60', '3', '10', '12', '5', '2019-03-28 09:44:20', '9', '2019-03-28 09:44:47', '10', '1'), ('133', '2019-03-28 09:44:47', '2019-03-28 09:45:08', '60', '3', '9', '7', '5', '2019-03-28 09:44:47', '10', '2019-03-28 09:45:08', '9', '1'), ('134', '2019-03-28 09:45:08', '2019-03-28 09:45:22', '60', '3', '14', '8', '2', '2019-03-28 09:45:08', '9', '2019-03-28 09:45:22', '14', '1'), ('135', '2019-03-28 20:30:24', '2019-03-28 20:32:08', '61', '3', '16', '11', '1', '2019-03-28 20:30:24', '16', '2019-03-28 20:32:08', '16', '1'), ('136', '2019-03-28 20:32:08', '2019-03-28 20:32:22', '61', '3', '14', '8', '1', '2019-03-28 20:32:08', '16', '2019-03-28 20:32:22', '14', '1'), ('137', '2019-03-28 20:32:22', '2019-03-28 20:33:12', '61', '3', '16', '11', '2', '2019-03-28 20:32:22', '14', '2019-03-28 20:33:12', '16', '1'), ('138', '2019-03-28 20:33:12', '2019-03-28 20:33:27', '61', '3', '8', '6', '1', '2019-03-28 20:33:12', '16', '2019-03-28 20:33:27', '8', '1'), ('139', '2019-03-28 20:33:27', '2019-03-28 20:36:05', '61', '3', '10', '12', '1', '2019-03-28 20:33:27', '8', '2019-03-28 20:36:05', '10', '1'), ('140', '2019-03-28 20:36:05', '2019-03-28 20:36:33', '61', '3', '9', '7', '1', '2019-03-28 20:36:05', '10', '2019-03-28 20:36:33', '9', '1'), ('141', '2019-03-28 20:36:33', '2019-03-28 20:36:35', '61', '3', '9', '7', '2', '2019-03-28 20:36:33', '9', '2019-03-28 20:36:35', '9', '1'), ('142', '2019-03-28 20:36:35', '2019-03-28 20:42:27', '61', '3', '10', '12', '2', '2019-03-28 20:36:35', '9', '2019-03-28 20:42:27', '10', '1'), ('143', '2019-03-28 20:42:27', '2019-03-28 20:42:46', '61', '3', '7', '14', '1', '2019-03-28 20:42:27', '10', '2019-03-28 20:42:46', '7', '1'), ('144', '2019-03-28 20:42:46', '2019-03-28 20:43:26', '61', '3', '10', '12', '3', '2019-03-28 20:42:46', '7', '2019-03-28 20:43:26', '10', '1'), ('145', '2019-03-28 20:43:26', '2019-03-28 20:43:27', '61', '3', '10', '12', '4', '2019-03-28 20:43:26', '10', '2019-03-28 20:43:27', '10', '1'), ('146', '2019-03-28 20:43:27', '2019-03-28 20:43:48', '61', '3', '9', '7', '3', '2019-03-28 20:43:27', '10', '2019-03-28 20:43:48', '9', '1'), ('147', '2019-03-28 20:43:48', '2019-03-28 20:43:49', '61', '3', '9', '7', '4', '2019-03-28 20:43:48', '9', '2019-03-28 20:43:49', '9', '1'), ('148', '2019-03-28 20:43:49', '2019-03-28 20:44:13', '61', '3', '10', '12', '5', '2019-03-28 20:43:49', '9', '2019-03-28 20:44:13', '10', '1'), ('149', '2019-03-28 20:44:13', '2019-03-28 20:44:25', '61', '3', '9', '7', '5', '2019-03-28 20:44:13', '10', '2019-03-28 20:44:25', '9', '1'), ('150', '2019-03-28 20:44:25', '2019-03-28 20:46:32', '61', '3', '14', '8', '2', '2019-03-28 20:44:25', '9', '2019-03-28 20:46:32', '14', '1'), ('151', '2019-03-28 22:41:09', '2019-03-28 22:42:02', '62', '3', '16', '11', '1', '2019-03-28 22:41:09', '16', '2019-03-28 22:42:02', '16', '1'), ('152', '2019-03-28 22:42:02', '2019-03-28 22:42:18', '62', '3', '14', '8', '1', '2019-03-28 22:42:02', '16', '2019-03-28 22:42:18', '14', '1'), ('153', '2019-03-28 22:42:18', '2019-03-28 22:42:37', '62', '3', '16', '11', '2', '2019-03-28 22:42:18', '14', '2019-03-28 22:42:37', '16', '1'), ('154', '2019-03-28 22:42:37', '2019-03-28 22:42:51', '62', '3', '8', '6', '1', '2019-03-28 22:42:37', '16', '2019-03-28 22:42:51', '8', '1'), ('155', '2019-03-28 22:42:51', '2019-03-28 22:43:25', '62', '3', '10', '12', '1', '2019-03-28 22:42:51', '8', '2019-03-28 22:43:25', '10', '1'), ('156', '2019-03-28 22:43:25', '2019-03-28 22:43:41', '62', '3', '9', '7', '1', '2019-03-28 22:43:25', '10', '2019-03-28 22:43:41', '9', '1'), ('157', '2019-03-28 22:43:41', '2019-03-28 22:43:42', '62', '3', '9', '7', '2', '2019-03-28 22:43:41', '9', '2019-03-28 22:43:42', '9', '1'), ('158', '2019-03-28 22:43:42', '2019-03-28 22:49:54', '62', '3', '10', '12', '2', '2019-03-28 22:43:42', '9', '2019-03-28 22:49:54', '10', '1'), ('159', '2019-03-28 22:49:54', '2019-03-28 22:50:13', '62', '3', '7', '14', '1', '2019-03-28 22:49:54', '10', '2019-03-28 22:50:13', '7', '1'), ('160', '2019-03-28 22:50:13', '2019-03-28 22:53:18', '62', '3', '10', '12', '3', '2019-03-28 22:50:13', '7', '2019-03-28 22:53:18', '10', '1'), ('161', '2019-03-28 22:53:18', '2019-03-28 22:53:19', '62', '3', '10', '12', '4', '2019-03-28 22:53:18', '10', '2019-03-28 22:53:19', '10', '1'), ('162', '2019-03-28 22:53:19', '2019-03-28 22:53:30', '62', '3', '9', '7', '3', '2019-03-28 22:53:19', '10', '2019-03-28 22:53:30', '9', '1'), ('163', '2019-03-28 22:53:30', '2019-03-28 22:53:32', '62', '3', '9', '7', '4', '2019-03-28 22:53:30', '9', '2019-03-28 22:53:32', '9', '1'), ('164', '2019-03-28 22:53:32', '2019-03-28 22:53:50', '62', '3', '10', '12', '5', '2019-03-28 22:53:32', '9', '2019-03-28 22:53:50', '10', '1'), ('165', '2019-03-28 22:53:50', '2019-03-28 22:54:09', '62', '3', '9', '7', '5', '2019-03-28 22:53:50', '10', '2019-03-28 22:54:09', '9', '1'), ('166', '2019-03-28 22:54:09', '2019-03-28 22:56:36', '62', '3', '14', '8', '2', '2019-03-28 22:54:09', '9', '2019-03-28 22:56:36', '14', '1'), ('167', '2019-04-02 02:06:47', '2019-04-02 02:07:15', '63', '3', '16', '11', '1', '2019-04-02 02:06:47', '16', '2019-04-02 02:07:15', '16', '1'), ('168', '2019-04-02 02:07:15', '2019-04-02 02:07:39', '63', '3', '14', '8', '1', '2019-04-02 02:07:15', '16', '2019-04-02 02:07:39', '14', '1'), ('169', '2019-04-02 02:07:39', '2019-04-02 02:09:01', '63', '3', '16', '11', '2', '2019-04-02 02:07:39', '14', '2019-04-02 02:09:01', '16', '1'), ('170', '2019-04-02 02:09:01', '2019-04-02 02:09:26', '63', '3', '8', '6', '1', '2019-04-02 02:09:01', '16', '2019-04-02 02:09:26', '8', '1'), ('171', '2019-04-02 02:09:26', '2019-04-02 02:10:22', '63', '3', '10', '12', '1', '2019-04-02 02:09:26', '8', '2019-04-02 02:10:22', '10', '1'), ('172', '2019-04-02 02:10:22', '2019-04-02 02:10:55', '63', '3', '9', '7', '1', '2019-04-02 02:10:22', '10', '2019-04-02 02:10:55', '9', '1'), ('173', '2019-04-02 02:10:55', '2019-04-02 02:11:01', '63', '3', '9', '7', '2', '2019-04-02 02:10:55', '9', '2019-04-02 02:11:01', '9', '1'), ('174', '2019-04-02 02:11:01', '2019-04-02 02:12:02', '63', '3', '10', '12', '2', '2019-04-02 02:11:01', '9', '2019-04-02 02:12:02', '10', '1'), ('175', '2019-04-02 02:12:02', '2019-04-02 02:12:21', '63', '3', '7', '14', '1', '2019-04-02 02:12:02', '10', '2019-04-02 02:12:21', '7', '1'), ('176', '2019-04-02 02:12:21', '2019-04-02 02:12:55', '63', '3', '10', '12', '3', '2019-04-02 02:12:21', '7', '2019-04-02 02:12:55', '10', '1'), ('177', '2019-04-02 02:12:55', '2019-04-02 02:13:00', '63', '3', '10', '12', '4', '2019-04-02 02:12:55', '10', '2019-04-02 02:13:00', '10', '1'), ('178', '2019-04-02 02:13:00', '2019-04-02 02:13:16', '63', '3', '9', '7', '3', '2019-04-02 02:13:00', '10', '2019-04-02 02:13:16', '9', '1'), ('179', '2019-04-02 02:13:16', '2019-04-02 02:13:20', '63', '3', '9', '7', '4', '2019-04-02 02:13:16', '9', '2019-04-02 02:13:20', '9', '1'), ('180', '2019-04-02 02:13:20', '2019-04-02 02:13:45', '63', '3', '10', '12', '5', '2019-04-02 02:13:20', '9', '2019-04-02 02:13:45', '10', '1'), ('181', '2019-04-02 02:13:45', '2019-04-02 02:14:13', '63', '3', '9', '7', '5', '2019-04-02 02:13:45', '10', '2019-04-02 02:14:13', '9', '1'), ('182', '2019-04-02 02:14:13', '2019-04-02 02:14:24', '63', '3', '14', '8', '2', '2019-04-02 02:14:13', '9', '2019-04-02 02:14:24', '14', '1'), ('183', '2019-04-02 04:53:10', '2019-04-02 04:53:15', '64', '3', '16', '11', '1', '2019-04-02 04:53:10', '16', '2019-04-02 04:53:15', '16', '1'), ('184', '2019-04-02 04:53:15', '2019-04-02 04:53:35', '64', '3', '14', '8', '1', '2019-04-02 04:53:15', '16', '2019-04-02 04:53:35', '14', '1'), ('185', '2019-04-02 04:53:35', '2019-04-02 04:54:16', '64', '3', '16', '11', '2', '2019-04-02 04:53:35', '14', '2019-04-02 04:54:16', '16', '1'), ('186', '2019-04-02 04:54:16', '2019-04-02 04:54:34', '64', '3', '8', '6', '1', '2019-04-02 04:54:16', '16', '2019-04-02 04:54:34', '8', '1'), ('187', '2019-04-02 04:54:34', '2019-04-02 04:55:09', '64', '3', '10', '12', '1', '2019-04-02 04:54:34', '8', '2019-04-02 04:55:09', '10', '1'), ('188', '2019-04-02 04:55:09', '2019-04-02 04:55:21', '64', '3', '9', '7', '1', '2019-04-02 04:55:09', '10', '2019-04-02 04:55:21', '9', '1'), ('189', '2019-04-02 04:55:21', '2019-04-02 04:55:33', '64', '3', '9', '7', '2', '2019-04-02 04:55:21', '9', '2019-04-02 04:55:33', '9', '1'), ('190', '2019-04-02 04:55:33', '2019-04-02 04:56:33', '64', '3', '10', '12', '2', '2019-04-02 04:55:33', '9', '2019-04-02 04:56:33', '10', '1'), ('191', '2019-04-02 04:56:33', '2019-04-02 04:56:49', '64', '3', '7', '14', '1', '2019-04-02 04:56:33', '10', '2019-04-02 04:56:49', '7', '1'), ('192', '2019-04-02 04:56:49', '2019-04-02 04:57:29', '64', '3', '10', '12', '3', '2019-04-02 04:56:49', '7', '2019-04-02 04:57:29', '10', '1'), ('193', '2019-04-02 04:57:29', '2019-04-02 04:57:31', '64', '3', '10', '12', '4', '2019-04-02 04:57:29', '10', '2019-04-02 04:57:31', '10', '1'), ('194', '2019-04-02 04:57:31', '2019-04-02 04:57:50', '64', '3', '9', '7', '3', '2019-04-02 04:57:31', '10', '2019-04-02 04:57:50', '9', '1'), ('195', '2019-04-02 04:57:50', '2019-04-02 04:57:51', '64', '3', '9', '7', '4', '2019-04-02 04:57:50', '9', '2019-04-02 04:57:51', '9', '1'), ('196', '2019-04-02 04:57:51', '2019-04-02 04:58:15', '64', '3', '10', '12', '5', '2019-04-02 04:57:51', '9', '2019-04-02 04:58:15', '10', '1'), ('197', '2019-04-02 04:58:15', '2019-04-02 04:58:25', '64', '3', '9', '7', '5', '2019-04-02 04:58:15', '10', '2019-04-02 04:58:25', '9', '1'), ('198', '2019-04-02 04:58:25', '2019-04-02 08:05:20', '64', '3', '14', '8', '2', '2019-04-02 04:58:25', '9', '2019-04-02 08:05:20', '14', '1'), ('199', '2019-04-08 08:16:44', '2019-04-18 08:15:29', '65', '3', '16', '11', '1', '2019-04-08 08:16:44', '16', '2019-04-18 08:15:29', '16', '1'), ('200', '2019-04-11 15:14:33', null, '67', '2', '14', '8', '1', '2019-04-11 15:14:33', '0', null, '0', '1'), ('201', '2019-04-11 15:14:50', null, '68', '2', '14', '8', '1', '2019-04-11 15:14:50', '0', null, '0', '1'), ('202', '2019-04-11 15:14:50', null, '69', '2', '14', '8', '1', '2019-04-11 15:14:50', '0', null, '0', '1'), ('203', '2019-04-11 15:14:53', null, '70', '2', '14', '8', '1', '2019-04-11 15:14:53', '0', null, '0', '1'), ('204', '2019-04-12 01:20:41', '2019-04-12 01:21:01', '71', '3', '14', '8', '1', '2019-04-12 01:20:41', '0', '2019-04-12 01:21:01', '0', '1'), ('205', '2019-04-12 01:20:41', '2019-04-12 01:21:01', '72', '3', '14', '8', '1', '2019-04-12 01:20:41', '0', '2019-04-12 01:21:01', '0', '1'), ('206', '2019-04-12 01:21:01', null, '71', '2', '16', '11', '1', '2019-04-12 01:21:01', '0', null, '0', '1'), ('207', '2019-04-12 01:21:01', null, '72', '2', '15', '11', '1', '2019-04-12 01:21:01', '0', null, '0', '1'), ('210', '2019-04-12 05:45:16', '2019-04-12 05:47:28', '79', '3', '14', '8', '1', '2019-04-12 05:45:16', '0', '2019-04-12 05:47:28', '0', '1'), ('211', '2019-04-12 05:45:16', '2019-04-12 05:47:28', '80', '3', '14', '8', '1', '2019-04-12 05:45:16', '0', '2019-04-12 05:47:28', '0', '1'), ('212', '2019-04-12 05:47:28', null, '79', '2', '13', '11', '1', '2019-04-12 05:47:28', '0', null, '0', '1'), ('213', '2019-04-12 05:47:28', '2019-04-18 06:21:03', '80', '3', '16', '11', '1', '2019-04-12 05:47:28', '0', '2019-04-18 06:21:03', '16', '1'), ('214', '2019-04-14 02:02:12', '2019-04-18 06:34:17', '82', '3', '16', '11', '1', '2019-04-14 02:02:12', '16', '2019-04-18 06:34:17', '16', '1'), ('215', '2019-04-14 03:01:19', '2019-04-18 06:27:38', '84', '3', '16', '11', '1', '2019-04-14 03:01:19', '16', '2019-04-18 06:27:38', '16', '1'), ('216', '2019-04-14 06:07:17', '2019-04-16 05:58:03', '85', '3', '16', '11', '1', '2019-04-14 06:07:17', '16', '2019-04-16 05:58:03', '16', '1'), ('217', '2019-04-15 15:47:44', '2019-04-16 03:29:49', '86', '3', '16', '11', '1', '2019-04-15 15:47:44', '16', '2019-04-16 03:29:49', '16', '1'), ('218', '2019-04-16 03:29:49', '2019-04-16 05:56:09', '86', '3', '14', '8', '1', '2019-04-16 03:29:49', '16', '2019-04-16 05:56:09', '14', '1'), ('219', '2019-04-16 05:56:09', '2019-04-16 05:57:03', '86', '3', '16', '11', '2', '2019-04-16 05:56:09', '14', '2019-04-16 05:57:03', '16', '1'), ('220', '2019-04-16 05:57:03', null, '86', '2', '8', '6', '1', '2019-04-16 05:57:03', '16', null, '0', '1'), ('221', '2019-04-16 05:58:03', null, '85', '2', '14', '8', '1', '2019-04-16 05:58:03', '16', null, '0', '1'), ('222', '2019-04-18 06:21:03', null, '80', '2', '8', '6', '1', '2019-04-18 06:21:03', '16', null, '0', '1'), ('223', '2019-04-18 06:27:38', null, '84', '2', '14', '8', '1', '2019-04-18 06:27:38', '16', null, '0', '1'), ('224', '2019-04-18 06:34:17', null, '82', '2', '14', '8', '1', '2019-04-18 06:34:17', '16', null, '0', '1'), ('226', '2019-04-18 08:15:29', null, '65', '2', '14', '8', '1', '2019-04-18 08:15:29', '16', null, '0', '1'), ('227', '2019-04-19 15:44:22', '2019-04-19 15:46:46', '87', '3', '16', '11', '1', '2019-04-19 15:44:22', '16', '2019-04-19 15:46:46', '16', '1'), ('228', '2019-04-19 15:46:46', '2019-04-19 15:47:31', '87', '3', '14', '8', '1', '2019-04-19 15:46:46', '16', '2019-04-19 15:47:31', '14', '1'), ('229', '2019-04-19 15:47:31', null, '87', '2', '16', '11', '2', '2019-04-19 15:47:31', '14', null, '0', '1'), ('230', '2019-04-22 01:22:29', '2019-04-22 02:00:05', '88', '3', '14', '8', '1', '2019-04-22 01:22:29', '0', '2019-04-22 02:00:05', '0', '1'), ('231', '2019-04-22 02:00:05', null, '88', '2', '16', '11', '1', '2019-04-22 02:00:05', '0', null, '0', '1'), ('232', '2019-04-22 07:20:04', '2019-04-22 07:21:59', '89', '3', '14', '8', '1', '2019-04-22 07:20:04', '0', '2019-04-22 07:21:59', '14', '1'), ('233', '2019-04-22 07:21:59', '2019-04-22 08:28:11', '89', '3', '15', '11', '1', '2019-04-22 07:21:59', '14', '2019-04-22 08:28:11', '15', '1'), ('235', '2019-04-22 08:28:11', '2019-04-22 09:10:42', '89', '3', '8', '6', '1', '2019-04-22 08:28:11', '15', '2019-04-22 09:10:42', '8', '1'), ('236', '2019-04-22 09:10:42', '2019-04-22 09:13:06', '89', '3', '10', '12', '1', '2019-04-22 09:10:42', '8', '2019-04-22 09:13:06', '10', '1'), ('237', '2019-04-22 09:13:06', '2019-04-22 09:14:39', '89', '3', '9', '7', '1', '2019-04-22 09:13:06', '10', '2019-04-22 09:14:39', '9', '1'), ('238', '2019-04-22 09:14:39', '2019-04-22 09:16:02', '89', '3', '9', '7', '2', '2019-04-22 09:14:39', '9', '2019-04-22 09:16:02', '9', '1'), ('239', '2019-04-22 09:16:02', '2019-04-22 09:19:00', '89', '3', '10', '12', '2', '2019-04-22 09:16:02', '9', '2019-04-22 09:19:00', '10', '1'), ('240', '2019-04-22 09:19:00', '2019-04-22 09:30:33', '89', '3', '7', '14', '1', '2019-04-22 09:19:00', '10', '2019-04-22 09:30:33', '7', '1'), ('241', '2019-04-22 09:30:33', '2019-04-22 09:31:09', '89', '3', '10', '12', '3', '2019-04-22 09:30:33', '7', '2019-04-22 09:31:09', '10', '1'), ('242', '2019-04-22 09:31:09', '2019-04-22 09:31:34', '89', '3', '10', '12', '4', '2019-04-22 09:31:09', '10', '2019-04-22 09:31:34', '10', '1'), ('243', '2019-04-22 09:31:34', null, '89', '2', '9', '7', '3', '2019-04-22 09:31:34', '10', null, '0', '1'), ('244', '2019-04-22 10:40:08', '2019-04-22 10:46:57', '90', '3', '14', '8', '1', '2019-04-22 10:40:08', '15', '2019-04-22 10:46:57', '14', '1'), ('245', '2019-04-22 10:46:57', '2019-04-22 11:19:26', '90', '3', '15', '11', '1', '2019-04-22 10:46:57', '14', '2019-04-22 11:19:26', '15', '1'), ('246', '2019-04-22 11:19:26', '2019-04-22 11:26:59', '90', '3', '8', '6', '1', '2019-04-22 11:19:26', '15', '2019-04-22 11:26:59', '8', '1'), ('247', '2019-04-22 11:26:59', '2019-04-22 11:27:46', '90', '3', '10', '12', '1', '2019-04-22 11:26:59', '8', '2019-04-22 11:27:46', '10', '1'), ('248', '2019-04-22 11:27:46', '2019-04-22 11:28:54', '90', '3', '9', '7', '1', '2019-04-22 11:27:46', '10', '2019-04-22 11:28:54', '9', '1'), ('249', '2019-04-22 11:28:54', '2019-04-22 11:50:41', '90', '3', '9', '7', '2', '2019-04-22 11:28:54', '9', '2019-04-22 11:50:41', '9', '1'), ('250', '2019-04-22 11:50:41', '2019-04-22 11:52:14', '90', '3', '10', '12', '2', '2019-04-22 11:50:41', '9', '2019-04-22 11:52:14', '10', '1'), ('251', '2019-04-22 11:52:14', '2019-04-22 11:52:45', '90', '3', '7', '14', '1', '2019-04-22 11:52:14', '10', '2019-04-22 11:52:45', '7', '1'), ('252', '2019-04-22 11:52:45', '2019-04-22 11:53:15', '90', '3', '10', '12', '3', '2019-04-22 11:52:45', '7', '2019-04-22 11:53:15', '10', '1'), ('253', '2019-04-22 11:53:15', '2019-04-22 11:53:24', '90', '3', '10', '12', '4', '2019-04-22 11:53:15', '10', '2019-04-22 11:53:24', '10', '1'), ('254', '2019-04-22 11:53:24', '2019-04-22 11:54:08', '90', '3', '9', '7', '3', '2019-04-22 11:53:24', '10', '2019-04-22 11:54:08', '9', '1'), ('255', '2019-04-22 11:54:08', '2019-04-22 11:54:16', '90', '3', '9', '7', '4', '2019-04-22 11:54:08', '9', '2019-04-22 11:54:16', '9', '1'), ('256', '2019-04-22 11:54:16', '2019-04-22 11:55:02', '90', '3', '10', '12', '5', '2019-04-22 11:54:16', '9', '2019-04-22 11:55:02', '10', '1'), ('257', '2019-04-22 11:55:02', '2019-04-22 11:55:27', '90', '3', '9', '7', '5', '2019-04-22 11:55:02', '10', '2019-04-22 11:55:27', '9', '1'), ('258', '2019-04-22 11:55:27', '2019-04-22 15:04:55', '90', '3', '14', '8', '2', '2019-04-22 11:55:27', '9', '2019-04-22 15:04:55', '14', '1'), ('259', '2019-04-22 15:00:08', '2019-04-22 15:05:20', '91', '3', '14', '8', '1', '2019-04-22 15:00:08', '15', '2019-04-22 15:05:20', '14', '1'), ('260', '2019-04-22 15:05:20', null, '91', '2', '15', '11', '1', '2019-04-22 15:05:20', '14', null, '0', '1'), ('261', '2019-04-24 00:28:12', '2019-04-24 01:54:51', '92', '3', '14', '8', '1', '2019-04-24 00:28:12', '15', '2019-04-24 01:54:51', '14', '1'), ('262', '2019-04-24 01:54:51', '2019-04-24 01:56:10', '92', '3', '15', '11', '1', '2019-04-24 01:54:51', '14', '2019-04-24 01:56:10', '15', '1'), ('263', '2019-04-24 01:56:10', '2019-04-24 01:56:48', '92', '3', '8', '6', '1', '2019-04-24 01:56:10', '15', '2019-04-24 01:56:48', '8', '1'), ('264', '2019-04-24 01:56:48', '2019-04-24 01:57:55', '92', '3', '10', '12', '1', '2019-04-24 01:56:48', '8', '2019-04-24 01:57:55', '10', '1'), ('265', '2019-04-24 01:57:55', '2019-04-24 01:59:01', '92', '3', '9', '7', '1', '2019-04-24 01:57:55', '10', '2019-04-24 01:59:01', '9', '1'), ('266', '2019-04-24 01:59:01', '2019-04-24 01:59:46', '92', '3', '9', '7', '2', '2019-04-24 01:59:01', '9', '2019-04-24 01:59:46', '9', '1'), ('267', '2019-04-24 01:59:46', '2019-04-24 02:00:44', '92', '3', '10', '12', '2', '2019-04-24 01:59:46', '9', '2019-04-24 02:00:44', '10', '1'), ('268', '2019-04-24 02:00:10', '2019-04-24 03:11:07', '93', '3', '14', '8', '1', '2019-04-24 02:00:10', '15', '2019-04-24 03:11:07', '15', '1'), ('269', '2019-04-24 02:00:44', '2019-04-24 02:02:43', '92', '3', '7', '14', '1', '2019-04-24 02:00:44', '10', '2019-04-24 02:02:43', '7', '1'), ('270', '2019-04-24 02:02:43', '2019-04-24 02:03:06', '92', '3', '10', '12', '3', '2019-04-24 02:02:43', '7', '2019-04-24 02:03:06', '10', '1'), ('271', '2019-04-24 02:03:06', '2019-04-24 02:03:28', '92', '3', '10', '12', '4', '2019-04-24 02:03:06', '10', '2019-04-24 02:03:28', '10', '1'), ('272', '2019-04-24 02:03:28', '2019-04-24 02:04:01', '92', '3', '9', '7', '3', '2019-04-24 02:03:28', '10', '2019-04-24 02:04:01', '9', '1'), ('273', '2019-04-24 02:04:01', '2019-04-24 02:04:11', '92', '3', '9', '7', '4', '2019-04-24 02:04:01', '9', '2019-04-24 02:04:11', '9', '1'), ('274', '2019-04-24 02:04:11', '2019-04-24 02:04:52', '92', '3', '10', '12', '5', '2019-04-24 02:04:11', '9', '2019-04-24 02:04:52', '10', '1'), ('275', '2019-04-24 02:04:52', '2019-04-24 02:05:24', '92', '3', '9', '7', '5', '2019-04-24 02:04:52', '10', '2019-04-24 02:05:24', '9', '1'), ('276', '2019-04-24 02:05:24', '2019-04-24 02:05:44', '92', '3', '14', '8', '2', '2019-04-24 02:05:24', '9', '2019-04-24 02:05:44', '14', '1'), ('277', '2019-04-24 03:00:32', '2019-04-24 03:11:07', '94', '3', '14', '8', '1', '2019-04-24 03:00:32', '15', '2019-04-24 03:11:07', '15', '1'), ('278', '2019-04-24 03:11:07', null, '94', '2', '15', '11', '1', '2019-04-24 03:11:07', '15', null, '0', '1'), ('279', '2019-04-24 03:11:07', null, '93', '2', '15', '11', '1', '2019-04-24 03:11:07', '15', null, '0', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_cbs_order_prod_cust`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_order_prod_cust`;
CREATE TABLE `t_cbs_order_prod_cust` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `identity_type` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `order_product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_order_prod_cust`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_order_prod_cust` VALUES ('11', '1', '1', '30', '9'), ('12', '1', '2', '30', '9'), ('13', '1', '1', '30', '10'), ('14', '1', '2', '30', '10'), ('15', '1', '1', '30', '11'), ('16', '1', '2', '30', '11'), ('17', '5', '1', '36', '12'), ('18', '5', '2', '36', '12'), ('19', '1', '1', '9', '13'), ('20', '1', '2', '9', '13'), ('21', '1', '1', '30', '14'), ('22', '1', '2', '30', '14'), ('23', '9', '1', '37', '15'), ('24', '9', '2', '37', '15'), ('25', '10', '1', '33', '16'), ('26', '10', '2', '33', '16'), ('27', '11', '1', '41', '17'), ('28', '11', '2', '41', '17'), ('29', '13', '1', '51', '18'), ('30', '13', '2', '51', '18'), ('31', '14', '1', '55', '19'), ('32', '14', '2', '55', '19'), ('33', '15', '1', '58', '20'), ('34', '15', '2', '58', '20'), ('35', '16', '1', '59', '21'), ('36', '16', '2', '59', '21'), ('37', '17', '1', '60', '22'), ('38', '17', '2', '60', '22'), ('39', '18', '1', '61', '23'), ('40', '18', '2', '61', '23'), ('41', '19', '1', '62', '24'), ('42', '19', '2', '62', '24'), ('43', '20', '1', '63', '25'), ('44', '20', '2', '63', '25');
COMMIT;

-- ----------------------------
--  Table structure for `t_cbs_order_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_order_product`;
CREATE TABLE `t_cbs_order_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `approve_state` int(11) DEFAULT NULL,
  `approve_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `fee` decimal(19,2) DEFAULT NULL,
  `is_muti_loaner` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `order_prod_state` int(11) NOT NULL,
  `payment_time` datetime DEFAULT NULL,
  `plan_amount` decimal(19,2) DEFAULT NULL,
  `plan_interest` decimal(19,2) DEFAULT NULL,
  `plan_pay_way` bigint(20) DEFAULT NULL,
  `plan_period_num` int(11) DEFAULT NULL,
  `plan_period_type` bigint(20) DEFAULT NULL,
  `plan_source` int(11) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `real_amount` decimal(19,2) DEFAULT NULL,
  `real_interest` decimal(19,2) DEFAULT NULL,
  `real_pay_way` bigint(20) DEFAULT NULL,
  `real_period_num` bigint(20) DEFAULT NULL,
  `real_period_type` bigint(20) DEFAULT NULL,
  `relationship` int(11) DEFAULT NULL,
  `service_id` bigint(20) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `state` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_order_product`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_order_product` VALUES ('10', '0', '2019-02-06 10:00:00', '2018-12-06 22:47:34', '0', null, null, '0', '7', null, '55.00', '22.00', '1', '22', '1', '0', '21', '66.00', null, '1', '0', '1', '0', '0', '2019-03-07 06:12:48', '0', '1'), ('11', '0', '2019-02-06 10:00:00', '2018-12-06 23:23:20', '0', null, null, '0', '7', null, '22.00', '22.00', '1', '22', '1', '0', '21', '66.00', null, '1', '0', '1', '0', '0', '2019-03-07 06:13:02', '0', '1'), ('16', '0', '2019-02-01 10:00:00', '2019-03-06 06:38:40', '0', null, null, '0', '7', null, '22.00', '22.00', '2', '11', '1', '0', '4', '11.00', '11.00', '2', '11', '1', '0', '0', '2019-03-07 05:43:22', '0', '1'), ('17', '0', '2019-03-04 11:00:00', '2019-03-18 21:49:10', '0', null, null, '0', '51', null, '22.00', '22.00', '1', '22', '1', '0', '8', '22.00', '22.00', '1', '22', '1', '0', '0', '2019-03-18 21:51:52', '0', '1'), ('18', '0', null, '2019-03-25 01:31:40', '0', null, null, '0', '104', null, '11.00', '11.00', '1', '22', '1', '0', '23', '22.00', '22.00', '1', '22', '1', '0', '0', null, null, '1'), ('19', '0', null, '2019-03-27 03:44:28', '0', null, null, '0', '101', null, '22.00', '22.00', '1', '22', '1', '0', '24', '90.00', '22.00', '1', '22', '1', '0', '0', null, null, '1'), ('20', '0', null, '2019-03-28 07:21:42', '0', null, null, '58', '101', null, '22.00', '22.00', '2', '22', '1', '0', '24', '22.00', '22.00', '1', '13', '1', '0', '0', null, null, '1'), ('21', '0', null, '2019-03-28 08:02:52', '0', null, null, '59', '101', null, null, null, '0', '0', '0', '0', '23', null, null, '0', '0', '0', '0', '0', null, null, '1'), ('22', '0', null, '2019-03-28 09:37:05', '0', null, null, '60', '101', null, null, null, '0', '0', '0', '0', '24', null, null, '0', '0', '0', '0', '0', null, null, '1'), ('23', '0', null, '2019-03-28 20:31:30', '0', null, null, '61', '101', null, '22.00', '22.00', '1', '22', '1', '0', '22', '22.00', '22.00', '1', '22', '0', '0', '0', null, null, '1'), ('24', '0', null, '2019-03-28 22:41:58', '0', null, null, '62', '101', null, '22.00', '22.00', '1', '22', '0', '0', '23', null, null, '0', '0', '0', '0', '0', null, null, '1'), ('25', '0', null, '2019-04-02 02:08:54', '0', null, null, '63', '104', null, '22.00', '22.00', '1', '2', '1', '0', '24', null, null, '0', '0', '0', '0', '0', null, null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_cbs_prod_interest`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_prod_interest`;
CREATE TABLE `t_cbs_prod_interest` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `begin_date` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `interest` decimal(19,2) DEFAULT NULL,
  `period_type` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_prod_interest`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_prod_interest` VALUES ('1', '2018-12-31 10:00:00', '2019-03-06 21:43:11', '0', '2019-12-31 10:00:00', '0.10', '0', '32', '100', '2019-03-06 21:49:02', '0'), ('2', '2018-12-31 10:00:00', '2019-03-06 21:43:34', '0', '2019-12-31 10:00:00', '0.20', '1', '4', '1', null, '0'), ('3', '2018-12-31 10:00:00', '2019-03-06 21:53:16', '0', '2019-12-31 10:00:00', '0.20', '2', '4', '1', null, '0'), ('4', '2018-12-31 10:00:00', '2019-03-06 21:53:30', '0', '2019-12-31 10:00:00', '0.30', '3', '32', '1', null, '0'), ('5', '2018-12-31 10:00:00', '2019-03-06 21:53:47', '0', '2019-12-31 10:00:00', '0.50', '4', '32', '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_cbs_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_product`;
CREATE TABLE `t_cbs_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_type` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `product_state` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `begin_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `brokerage` decimal(19,2) DEFAULT NULL,
  `fair_fee` decimal(19,2) DEFAULT NULL,
  `interest` decimal(19,2) DEFAULT NULL,
  `law_fee` decimal(19,2) DEFAULT NULL,
  `license_fee` decimal(19,2) DEFAULT NULL,
  `busi_type` int(3) NOT NULL,
  `interest_way` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_product`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_product` VALUES ('0', '0', '全部', '0', '2019-03-14 06:37:05', '0', '0', null, '0', '2018-12-31 10:00:00', '2019-12-30 10:00:00', '1', null, null, null, null, null, '0', null), ('1', '1', '中信经营贷', '3', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '1', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('2', '1', '华夏经营贷', '3', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '1', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('3', '1', '包商经营贷', '3', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '1', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('4', '1', '招商经营贷', '3', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '1', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('5', '1', '招商二抵', '3', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('6', '1', '招商超级抵押贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('7', '1', '兴业经营贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('8', '1', '廊坊经营贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('9', '6', '筑梦贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('10', '7', '宅易通', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('11', '1', '工商经营贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('12', '1', '浙商经营贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('13', '1', '广发经营贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('14', '1', '交通银行经营贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('15', '1', '邮储银行经营贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('16', '1', '友利银行经营贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('17', '1', '浦发房抵快贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('18', '1', '民生经营贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('19', '1', '民生云快贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('20', '1', '南京鑫快捷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('21', '1', '光大银行经营贷', '1', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('22', '1', '工行消费贷', '2', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('23', '1', '招行消费贷', '2', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('24', '1', '厦门银行消费贷', '2', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('25', '1', '交通银行消费贷', '2', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('26', '1', '中信消费贷', '2', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('27', '1', '南京消费贷', '2', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('28', '1', '光大消费贷', '2', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('29', '1', '包商消费贷', '2', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('30', '1', '廊坊银行消费贷', '2', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('31', '1', '平安银行消费贷', '2', '2018-12-05 13:49:42', '0', '1', '2018-12-05 14:13:20', '0', '2018-12-05 13:49:32', '2018-12-05 13:52:42', '100', '0.10', '0.10', '0.10', '0.10', '0.10', '1', null), ('32', '4', '贯泽信抵押贷', '0', '2019-03-06 20:27:36', '0', '1', null, '0', '2018-12-31 10:00:00', '2019-12-31 10:00:00', '1', '0.10', '0.10', '0.10', '0.10', '0.10', '3', null), ('33', '5', '小科垫资', '0', '2019-03-09 21:32:52', '0', '1', null, '0', '2018-12-31 10:00:00', '2019-12-31 10:00:00', '1', '0.10', '0.00', '0.20', '0.00', '0.00', '2', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_cbs_product_rule`
-- ----------------------------
DROP TABLE IF EXISTS `t_cbs_product_rule`;
CREATE TABLE `t_cbs_product_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `rule_elastic` bigint(20) DEFAULT NULL,
  `rule_expression` varchar(255) DEFAULT NULL,
  `rule_state` bigint(20) DEFAULT NULL,
  `rule_type` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `and_group_id` bigint(20) DEFAULT NULL,
  `expression_desc` varchar(255) DEFAULT NULL,
  `or_group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cbs_product_rule`
-- ----------------------------
BEGIN;
INSERT INTO `t_cbs_product_rule` VALUES ('1', '2018-07-19 16:29:08', '0', '1', '1', 'estateType in (1,2)', '1', '1', null, null, '0', null, null), ('2', '2018-07-19 16:29:08', '0', '1', '1', 'changeMasterMonths>3', '1', '1', null, null, '0', null, null), ('3', '2018-07-19 16:29:08', '0', '1', '1', 'estateType=3 and houseDate<2007-12-1 and NewHouseBookRegistMonths>3', '1', '1', null, null, '0', null, null), ('4', '2018-07-19 16:29:08', '0', '1', '1', 'estateArea in (1,2,3,4,5,6)', '1', '1', null, null, '0', null, null), ('5', '2018-07-19 16:29:08', '0', '1', '1', 'mortgagerCountry=1', '1', '1', null, null, '0', null, null), ('6', '2018-07-19 16:29:08', '0', '1', '1', 'borrowerAge>18 and borrowerAge<65', '1', '1', null, null, '0', null, null), ('7', '2018-07-19 16:29:08', '0', '1', '1', 'continuousDelay<2 and totalDelay <9 and sigalLoanTotalDelay<6 and maxDelay<30', '1', '1', null, null, '0', null, null), ('8', '2018-07-19 16:29:08', '0', '1', '1', 'creditCardTotalDelay<9 and creditCardState !=1 and freezeAmount<5000', '1', '1', null, null, '0', null, null), ('9', '2018-07-19 16:29:08', '0', '1', '1', 'houseAge<25', '1', '1', null, null, '0', null, null), ('10', '2018-07-19 16:29:08', '0', '1', '2', '(estateType=1 and percent<=0.6) or (estateType!=1 and percent<=0.5)', '1', '2', null, null, '0', null, null), ('11', '2018-07-19 16:29:08', '0', '1', '2', 'amount<200', '1', '2', null, null, '0', null, null), ('12', '2018-07-19 16:29:08', '0', '1', '2', 'borrowLoanSame=2 and relationship=1 and loanPeriodType=1', '1', '3', null, null, '0', null, null), ('13', '2018-07-19 16:29:08', '0', '1', '2', 'loanDuration<80-mortgagerAge and loanDuration<=50-houseAge', '1', '4', null, null, '0', null, null), ('14', '2018-07-19 16:29:08', '0', '1', '2', 'loanDuration<=70-borrowerAge and loanDuration<=25', '1', '4', null, null, '0', null, null), ('17', '2018-07-19 16:29:08', '0', '1', '2', 'borrowerAge>55 and childShareLoan=N', '1', '5', null, null, '0', null, null), ('18', '2018-07-19 16:29:08', '0', '2', '1', 'estateType not in (3,4,6)', '1', '1', null, null, '0', null, null), ('19', '2018-07-19 16:29:08', '0', '2', '1', 'estateType=3 and buyHouseDate<2008-4-11', '1', '1', null, null, '0', null, null), ('20', '2018-07-19 16:29:08', '0', '2', '2', 'estateArea in (1,2,3,4,5,6)', '1', '1', null, null, '0', null, null), ('21', '2018-07-19 16:29:08', '0', '2', '2', 'mortgagerCountry=1', '1', '1', null, null, '0', null, null), ('22', '2018-07-19 16:29:08', '0', '2', '2', 'mortgagerAge<60', '1', '1', null, null, '0', null, null), ('23', '2018-07-19 16:29:08', '0', '2', '2', 'ifOverdue=N', '1', '1', null, null, '0', null, null), ('24', '2018-07-19 16:29:08', '0', '2', '2', 'houseAge<20', '1', '1', null, null, '0', null, null), ('25', '2018-07-19 16:29:08', '0', '2', '2', '(estateType=1 and percent<=0.7) or (estateType=2 and percent=0.6) or (estateType not in (1,2) and percent<=0.5)', '1', '2', null, null, '0', null, null), ('26', '2018-07-19 16:29:08', '0', '2', '1', 'amount<2000', '1', '2', null, null, '0', null, null), ('27', '2018-07-19 16:29:08', '0', '3', '1', 'estateType in (1,7)  or (estateType=9 and estateRight=70) or (estateType=12 and houseAge<35)', '1', '1', null, null, '0', null, null), ('28', '2018-07-19 16:29:08', '0', '3', '1', 'estateType!=11', '1', '1', null, null, '0', null, null), ('29', '2018-07-19 16:29:08', '0', '3', '2', 'estateArea in (1,2,3,4,5,6)', '1', '1', null, null, '0', null, null), ('30', '2018-07-19 16:29:08', '0', '3', '1', 'mortgagerCountry=1', '1', '1', null, null, '0', null, null), ('31', '2018-07-19 16:29:08', '0', '3', '1', 'borrowerAge<=64 and borrowerMate<=64 and mortgagerAge<=64 and mortgagerMate<=64', '1', '1', null, null, '0', null, null), ('32', '2018-07-19 16:29:08', '0', '3', '1', 'borrowerArea not in (1,2)', '1', '1', null, null, '0', null, null), ('33', '2018-07-19 16:29:08', '0', '3', '2', 'contD3Times2Y<1 and DTimes2Y<6 and contD2Times2Y<2 and DTimes6M<2', '1', '1', null, null, '0', null, null), ('34', '2018-07-19 16:29:08', '0', '3', '2', 'estateType = 1 and estateRight=70 and percent<0.75', '1', '2', null, null, null, null, '1'), ('35', '2018-07-19 16:29:08', '0', '3', '2', 'estateType in (8,10,13) and estateRight=79 and percent<0.7', '1', '2', null, null, null, null, '1'), ('36', '2018-07-19 16:29:08', '0', '3', '2', 'estateType in (9,14) and estateRight=70 and percent<0.6', '1', '2', null, null, null, null, '1'), ('37', '2018-07-19 16:29:08', '0', '3', '2', 'estateType in(1,2,8,9) and estateType=70 and loanDuration<20 ', '1', '3', null, null, null, null, '2'), ('38', '2018-07-19 16:29:08', '0', '3', '2', 'estateType in (4,15) and estateRight != 70 and mortgageYear<10 and loanDuration<30-houseAge and buildedDuration<20', '1', '3', null, null, null, null, '2'), ('39', '2018-07-19 16:29:08', '0', '3', '2', 'estateType=12 and buildedDuration<35 and loanDuration<50-houseAge', '1', '3', null, null, null, null, '2'), ('40', '2018-07-19 16:29:08', '0', '3', '1', 'amount<1000', '1', '2', null, null, '0', null, null), ('41', '2018-07-19 16:29:08', '0', '3', '1', 'borrowLoanSame=2 and relationship in(1,2)', '1', '3', null, null, '0', null, null), ('42', '2018-07-19 16:29:08', '0', '4', null, 'eatateRight=70', '1', '1', null, null, '0', null, null), ('43', '2018-07-19 16:29:08', '0', '4', null, 'estateType!=16', '1', '1', null, null, '0', null, null), ('44', '2018-07-19 16:29:08', '0', '4', null, '(estateType=3 and buyTime<2007-12-31 and houseBook<2012-1-1) or estateType != 3', '1', '1', null, null, '0', null, null), ('45', '2018-07-19 16:29:08', '0', '4', null, 'estateArea in (1,2,3,4,5,6)', '1', '1', null, null, '0', null, null), ('46', '2018-07-19 16:29:08', '0', '4', null, 'mortgagerCountry = 1', '1', '1', null, null, '0', null, null), ('47', '2018-07-19 16:29:08', '0', '4', null, 'loanDuration<=40-houseAge and loanDuration<=70-borrowerAge', '1', '3', null, null, '0', null, null), ('48', '2018-07-19 16:29:08', '0', '4', null, '(borrowerAge>55 and borrowerAge<=70 and bj2house=Y) or (borrowerAge>18 and borrowerAge<=55)', '1', '1', null, null, '0', null, null), ('49', '2018-07-19 16:29:08', '0', '4', null, 'creditType = creditCard and contD3Times5Y<1 and DTimes5Y<=10 ', '1', '1', null, null, '0', null, null), ('50', '2018-07-19 16:29:08', '0', '4', null, 'creditType = houseLoan and contD2Times5Y<1 and DTimes5Y<=15', '1', '1', null, null, '0', null, null), ('51', '2018-07-19 16:29:08', '0', '4', null, 'houseAge<30', '1', '1', null, null, '0', null, null), ('52', '2018-07-19 16:29:08', '0', '4', null, 'estateType=1 and percent=0.7', '1', '2', null, null, null, null, '3'), ('53', '2018-07-19 16:29:08', '0', '4', null, 'estateType= 17 and estateRight=70 and percent<=0.7', '1', '2', null, null, null, null, '3'), ('54', '2018-07-19 16:29:08', '0', '4', null, 'estateType=18 and estateRight=70 and percent<=0.6', '1', '2', null, null, null, null, '3'), ('55', '2018-07-19 16:29:08', '0', '4', null, 'amount<=1000', '1', '1', null, null, '0', null, null), ('56', '2018-07-19 16:29:08', '0', '4', null, 'borrowLoanSame=2 and relationship=2', '1', '1', null, null, '0', null, null), ('57', '2018-07-19 16:29:08', '0', '7', '1', 'houseTime>1990-1-1 and area>50 and estateType in(1,2,3,19,10) and transferBusiness=Y', '1', '1', null, null, '0', null, null), ('58', '2018-07-19 16:29:08', '0', '7', '1', 'changeStructure=N and rendObj not in (1,2,3)', '1', '1', null, null, '0', null, null), ('59', '2018-07-19 16:29:08', '0', '7', '1', 'planEqualRealUse=Y', '1', '1', null, null, '0', null, null), ('60', '2018-07-19 16:29:08', '0', '7', '1', '(estateType in (1,2) and estateRight=70) or (estateType=3 and transferBusiness=Y) or(estateType not in (1,2,3))', '1', '1', null, null, '0', null, null), ('61', '2018-07-19 16:29:08', '0', '7', '1', 'estateArea in (1,2,3,4) or (estateArea in (8,9,12) and subwayNear=Y) or (estateType=10 and estate2Area in (1,2))', '1', '1', null, null, '0', null, null), ('62', '2018-07-19 16:29:08', '0', '7', '1', 'borrowerCountry=1', '1', '1', null, null, '0', null, null), ('63', '2018-07-19 16:29:08', '0', '7', '2', 'contD3Times2Y<1 and DTimes2Y<=6', '1', '1', null, null, '0', null, null), ('64', '2018-07-19 16:29:08', '0', '7', '2', 'estateType=1 and percent<0.7', '1', '2', null, null, null, null, '4'), ('65', '2018-07-19 16:29:08', '0', '7', '2', 'estateType=8 and estateRigth=70 and percent<0.7', '1', '2', null, null, null, null, '4'), ('66', '2018-07-19 16:29:08', '0', '7', '2', 'estateType=2 and percent<0.6', '1', '2', null, null, null, null, '4'), ('67', '2018-07-19 16:29:08', '0', '7', '2', 'estateType not in (1,2,8) and percent<0.6', '1', '2', null, null, null, null, '4'), ('68', '2018-07-19 16:29:08', '0', '7', '2', 'estateArea in (8,9,10,12) and houseAddress  =56 and percent<0.67', '1', '2', null, null, null, null, '5'), ('69', '2018-07-19 16:29:08', '0', '7', '2', 'estateArea in (8,9,10,12) and houseAddress  =610 and percent<0.65', '1', '2', null, null, null, null, '5'), ('70', '2018-07-19 16:29:08', '0', '7', '2', 'houseTime>=1990 and houseTime<=1999 and percent <0.68', '1', '2', null, null, '0', null, null), ('71', '2018-07-19 16:29:08', '0', '7', '2', 'realHavingAge>=50 and realHavingAge<=55 and percent<0.67', '1', '2', null, null, null, null, '6'), ('72', '2018-07-19 16:29:08', '0', '7', '2', 'realHavingAge>55 and realHavingAge<=60 and percent<0.65', '1', '2', null, null, null, null, '6'), ('73', '2018-07-19 16:29:08', '0', '7', '2', 'loanDuration<=64-borrowerAge', '1', '3', null, null, '0', null, null), ('74', '2018-07-19 16:29:08', '0', '7', '2', 'loanDuration<=69-mortagerAge', '1', '3', null, null, '0', null, null), ('75', '2018-07-19 16:29:08', '0', '7', '1', 'borrowerAge >=18 and borrowerAge<=60 and mortgagerAge>=18 and mortgage<=69', '1', '1', null, null, '0', null, null), ('76', '2018-07-19 16:29:08', '0', '7', '2', 'borrowerAge>=18 and borrowerAge<=25 and persentShareLoan =Y', '1', '1', null, null, null, null, '7'), ('77', '2018-07-19 16:29:08', '0', '7', '2', 'borrowerAge>=55 and borrowerAge<=60 and childShareLoan=Y', '1', '1', null, null, null, null, '7'), ('78', '2018-07-19 16:29:08', '0', '7', '2', 'loanDuration<=10', '1', '3', null, null, '0', null, null), ('79', '2018-07-19 16:29:08', '0', '7', '2', 'amount<=800', '1', '2', null, null, '0', null, null), ('80', '2018-07-19 16:29:08', '0', '7', '2', 'borrowLoanSame=2 and relationship in (1,2)', '1', '4', null, null, '0', null, null), ('81', '2018-07-19 16:29:08', '0', '9', '1', 'estateType in (1,8,2,19,20)', '1', '1', null, null, '0', null, null), ('82', '2018-07-19 16:29:08', '0', '9', '1', 'mortgagerCountry=1', '1', '1', null, null, '0', null, null), ('83', '2018-07-19 16:29:08', '0', '9', '1', 'DDays2Y<=30 and DTimes2Y<=6', '1', '1', null, null, '0', null, null), ('84', '2018-07-19 16:29:08', '0', '9', '1', 'houseArea>=40 and houseAge<=25', '1', '1', null, null, null, null, '8'), ('85', '2018-07-19 16:29:08', '0', '9', '1', 'houseArea<40 and houseAge<=20', '1', '1', null, null, null, null, '8'), ('86', '2018-07-19 16:29:08', '0', '9', '2', 'borrowerAge>=25 and borrowerAge<=60', '1', '1', null, null, '0', null, null), ('87', '2018-07-19 16:29:08', '0', '9', '2', 'loanDuration<=70-borrowerAge', '1', '3', null, null, '0', null, null), ('88', '2018-07-19 16:29:08', '0', '9', '1', 'amount<=3000', '1', '2', null, null, '0', null, null), ('89', '2018-07-19 16:29:08', '0', '10', '1', 'estateType in (22,23)', '1', '1', null, null, null, null, '9'), ('90', '2018-07-19 16:29:08', '0', '10', '1', 'estateType = 8 and estateRigth=70', '1', '1', null, null, null, null, '9'), ('91', '2018-07-19 16:29:08', '0', '10', '1', 'mortgagerCountry=1', '1', '1', null, null, '0', null, null), ('92', '2018-07-19 16:29:08', '0', '10', '1', 'criditNum>=740', '1', '1', null, null, '0', null, null), ('93', '2018-07-19 16:29:08', '0', '10', '1', 'contD4Times2Y<1 and contD3Times1Y<1 and contD2Times6M<1', '1', '1', null, null, '0', null, null), ('94', '2018-07-19 16:29:08', '0', '10', '1', 'selectCredit<=4', '1', '1', null, null, '0', null, null), ('95', '2018-07-19 16:29:08', '0', '10', '1', 'houseAge<=25', '1', '1', null, null, '0', null, null), ('96', '2018-07-19 16:29:08', '0', '10', '2', 'loanDuration<=50-houseAge', '1', '3', null, null, '0', null, null), ('97', '2018-07-19 16:29:08', '0', '10', '2', 'estateType =1 and percent<=0.7', '1', '2', null, null, '0', null, null), ('98', '2018-07-19 16:29:08', '0', '10', '1', 'borrowerAge>=18 and borroweragen<=65', '1', '1', null, null, '0', null, null), ('99', '2018-07-19 16:29:08', '0', '10', '2', 'loanDuration<=70-borrowerAge', '1', '3', null, null, '0', null, null), ('100', '2018-07-19 16:29:08', '0', '10', '1', 'mortgagerAge>=18 and mortgagerAge<=65', '1', '1', null, null, '0', null, null), ('101', '2018-07-19 16:29:08', '0', '10', '1', 'loanDuration<=10', '1', '3', null, null, '0', null, null), ('102', '2018-07-19 16:29:08', '0', '10', '2', 'amount<=500', '1', '2', null, null, '0', null, null), ('103', '2018-07-19 16:29:08', '0', '10', '1', 'relationship in (1,2,3,4)', '1', '1', null, null, '0', null, null), ('104', '2018-07-19 16:29:08', '0', '11', '1', 'estateType =1', '1', '1', null, null, '0', null, null), ('105', '2018-07-19 16:29:08', '0', '11', '1', 'estateArea in (1,2,3,4,5,6,8,9,17,18,19,20,21,22)', '1', '1', null, null, '0', null, null), ('106', '2018-07-19 16:29:08', '0', '11', '1', 'mortgagerCountry=1', '1', '1', null, null, '0', null, null), ('107', '2018-07-19 16:29:08', '0', '11', '1', 'contD3Times2Y<1 and DTimes2Y<=6', '1', '1', null, null, '0', null, null), ('108', '2018-07-19 16:29:08', '0', '11', '2', 'houseAge>=20 and houseAge<=25', '1', '1', null, null, '0', null, null), ('109', '2018-07-19 16:29:08', '0', '11', '2', 'estateType =1 and percent<=0.7', '1', '2', null, null, null, null, '10'), ('110', '2018-07-19 16:29:08', '0', '11', '2', 'estateType !=1 and percent<=0.5', '1', '2', null, null, null, null, '10'), ('111', '2018-07-19 16:29:08', '0', '11', '2', 'borrowerAge>=18 and borrowerAge<=60', '1', '1', null, null, '0', null, null), ('112', '2018-07-19 16:29:08', '0', '11', '1', 'amount<=1000', '1', '2', null, null, '0', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `t_crm_cust`
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_cust`;
CREATE TABLE `t_crm_cust` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `be_stockholder_months` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `card_no` varchar(255) DEFAULT NULL,
  `certi_code` varchar(255) DEFAULT NULL,
  `city` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `info_original` int(11) DEFAULT NULL,
  `is_new_stockholder` int(11) DEFAULT NULL,
  `job` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sales_state` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `why_borrow` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_cs_knowledge`
-- ----------------------------
DROP TABLE IF EXISTS `t_cs_knowledge`;
CREATE TABLE `t_cs_knowledge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `question_name` varchar(255) DEFAULT NULL,
  `question_type` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_cs_work_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_cs_work_order`;
CREATE TABLE `t_cs_work_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `cs_desc` varchar(255) DEFAULT NULL,
  `cs_name` varchar(255) DEFAULT NULL,
  `cs_state` int(11) DEFAULT NULL,
  `cstype` int(11) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_cust_company`
-- ----------------------------
DROP TABLE IF EXISTS `t_cust_company`;
CREATE TABLE `t_cust_company` (
  `company_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `capital` decimal(19,2) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `registered_date` datetime DEFAULT NULL,
  `share_percent` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_cust_credit`
-- ----------------------------
DROP TABLE IF EXISTS `t_cust_credit`;
CREATE TABLE `t_cust_credit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ddays2y` int(11) DEFAULT NULL,
  `dtimes2y` int(11) DEFAULT NULL,
  `dtimes5y` int(11) DEFAULT NULL,
  `dtimes6m` int(11) DEFAULT NULL,
  `contd2times2y` int(11) DEFAULT NULL,
  `contd2times6m` int(11) DEFAULT NULL,
  `contd3times1y` int(11) DEFAULT NULL,
  `contd3times2y` int(11) DEFAULT NULL,
  `contd3times5y` int(11) DEFAULT NULL,
  `contd4times2y` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `extend1` int(11) DEFAULT NULL,
  `extend2` int(11) DEFAULT NULL,
  `extend3` int(11) DEFAULT NULL,
  `extend4` int(11) DEFAULT NULL,
  `freeze_amount` decimal(19,2) DEFAULT NULL,
  `max_delay` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cust_credit`
-- ----------------------------
BEGIN;
INSERT INTO `t_cust_credit` VALUES ('17', '11', '0', '0', '0', '11', '0', '0', '0', '0', '0', '2018-12-06 20:46:23', '0', '1', '0', '0', '0', '0', '11.00', '11', '2019-03-03 21:35:24', '0'), ('18', '222', '0', '0', '0', '222', '0', '0', '0', '0', '0', '2018-12-06 22:34:29', '0', '2', '0', '0', '0', '0', '222.00', '22', '2019-02-28 20:04:45', '0'), ('19', '333', '0', '0', '0', '333', '0', '0', '0', '0', '0', '2018-12-06 22:39:27', '0', '3', '0', '0', '0', '0', '333.00', '333', '2019-02-28 20:00:22', '0'), ('20', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2018-12-07 10:17:47', '0', '4', '0', '0', '0', '0', null, '0', null, '0'), ('21', '11', '0', '0', '0', '11', '0', '0', '0', '0', '0', '2018-12-07 10:18:38', '0', '5', '0', '0', '0', '0', '11.00', '11', '2019-03-01 04:00:48', '0'), ('22', '2', '0', '0', '0', '2', '0', '0', '0', '0', '0', '2019-02-27 00:28:01', '0', '6', '0', '0', '0', '0', '2.00', '2', null, '0'), ('23', '999', '0', '0', '0', '999', '0', '0', '0', '0', '0', '2019-02-27 21:41:09', '0', '7', '0', '0', '0', '0', '999.00', '999', null, '0'), ('24', '222', '0', '0', '0', '222', '0', '0', '0', '0', '0', '2019-02-28 19:44:16', '0', '8', '0', '0', '0', '0', '222.00', '22', null, '0'), ('25', '1212', '0', '0', '0', '121', '0', '0', '0', '0', '0', '2019-03-01 04:37:28', '0', '9', '0', '0', '0', '0', '1212.00', '1212', null, '0'), ('26', '11', '0', '0', '0', '11', '0', '0', '0', '0', '0', '2019-03-06 06:38:08', '0', '10', '0', '0', '0', '0', '11.00', '11', null, '0'), ('27', '444', '0', '0', '0', '444', '0', '0', '0', '0', '0', '2019-03-18 21:26:30', '0', '11', '0', '0', '0', '0', '444.00', '444', null, '0'), ('28', '22', '0', '0', '0', '22', '0', '0', '0', '0', '0', '2019-03-18 21:30:54', '0', '12', '0', '0', '0', '0', '22.00', '22', null, '0'), ('29', '11', '0', '0', '0', '11', '0', '0', '0', '0', '0', '2019-03-25 01:31:20', '0', '13', '0', '0', '0', '0', '11.00', '11', null, '0'), ('30', '22', '0', '0', '0', '22', '0', '0', '0', '0', '0', '2019-03-27 03:44:07', '0', '14', '0', '0', '0', '0', '22.00', '22', null, '0'), ('31', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2019-03-28 07:21:20', '0', '15', '0', '0', '0', '0', null, '0', null, '0'), ('32', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2019-03-28 08:02:40', '0', '16', '0', '0', '0', '0', '22.00', '0', null, '0'), ('33', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2019-03-28 09:36:54', '0', '17', '0', '0', '0', '0', null, '0', null, '0'), ('34', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2019-03-28 20:31:18', '0', '18', '0', '0', '0', '0', null, '0', null, '0'), ('35', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2019-03-28 22:41:45', '0', '19', '0', '0', '0', '0', null, '0', null, '0'), ('36', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2019-04-02 02:08:36', '0', '20', '0', '0', '0', '0', null, '0', null, '0'), ('37', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2019-04-02 04:54:13', '0', '21', '0', '0', '0', '0', null, '0', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_cust_mortgage`
-- ----------------------------
DROP TABLE IF EXISTS `t_cust_mortgage`;
CREATE TABLE `t_cust_mortgage` (
  `mortgage_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `belong_type` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `estate_age` int(11) DEFAULT NULL,
  `estate_area` int(11) DEFAULT NULL,
  `estate_price` decimal(19,2) DEFAULT NULL,
  `estate_type` int(11) DEFAULT NULL,
  `house_address` int(11) DEFAULT NULL,
  `mortgage_type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `mortgage_count` int(11) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `order_product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`mortgage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_cust_mortgage`
-- ----------------------------
BEGIN;
INSERT INTO `t_cust_mortgage` VALUES ('19', '0', '2018-12-06 20:46:23', '0', '1', '11', '2', '11.00', '2', '0', '0', '2019-03-03 21:35:24', '0', null, null, null), ('20', '0', '2018-12-06 22:34:29', '0', '2', '222', '1', '222.00', '2', '0', '0', '2019-02-28 20:04:45', '0', null, null, null), ('21', '0', '2018-12-06 22:39:27', '0', '3', '333', '2', '333.00', '2', '0', '0', '2019-02-28 20:00:22', '0', null, null, null), ('22', '0', '2018-12-07 10:17:47', '0', '4', '0', '0', null, '0', '0', '0', null, '0', null, null, null), ('23', '0', '2018-12-07 10:18:38', '0', '5', '11', '2', '11.00', '2', '0', '0', '2019-03-01 04:00:48', '0', null, null, null), ('24', '0', '2019-02-27 00:28:01', '0', '6', '20', '2', '22.00', '2', '0', '0', null, '0', null, null, null), ('25', '0', '2019-02-27 21:41:09', '0', '7', '999', '3', '999.00', '2', '0', '0', null, '0', null, null, null), ('26', '0', '2019-02-28 19:44:16', '0', '8', '222', '1', '222.00', '2', '0', '0', null, '0', null, null, null), ('27', '0', '2019-03-01 04:37:28', '0', '9', '121', '1', '1212.00', '1', '0', '0', null, '0', null, null, null), ('28', '0', '2019-03-06 06:38:08', '0', '10', '11', '1', '11.00', '1', '0', '0', null, '0', null, null, null), ('29', '0', '2019-03-18 21:26:30', '0', '11', '444', '1', '444.00', '1', '0', '0', null, '0', null, null, null), ('30', '0', '2019-03-18 21:30:54', '0', '12', '22', '1', '22.00', '1', '0', '0', null, '0', null, null, null), ('31', '0', '2019-03-25 01:31:20', '0', '13', '1', '1', '11.00', '2', '0', '0', null, '0', null, null, null), ('32', '0', '2019-03-27 03:44:07', '0', '14', '0', '2', '222.00', '1', '0', '0', null, '0', '2', null, null), ('33', '0', '2019-03-28 07:21:20', '0', '15', '0', '2', '22.00', '1', '0', '0', null, '0', '1', null, null), ('34', '0', '2019-03-28 08:02:40', '0', '16', '0', '1', '22.00', '1', '0', '0', null, '0', '1', null, null), ('35', '0', '2019-03-28 09:36:54', '0', '17', '0', '1', '22.00', '1', '0', '0', null, '0', '2', null, null), ('36', '0', '2019-03-28 20:31:18', '0', '18', '0', '2', '22.00', '1', '0', '0', null, '0', '2', null, null), ('37', '0', '2019-03-28 22:41:45', '0', '19', '0', '1', '22.00', '1', '0', '0', null, '0', '2', null, null), ('38', '0', '2019-04-02 02:08:36', '0', '20', '0', '2', null, '0', '0', '0', null, '0', '2', null, null), ('39', '0', '2019-04-02 04:54:13', '0', '21', '0', '2', '111.00', '1', '0', '0', null, '0', '1', null, null), ('40', '0', '2019-04-23 11:50:45', '15', '0', '0', '2', null, '2', '0', '0', null, '0', '1', '91', '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `be_stockholder_months` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `certi_code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `cust_state` bigint(20) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `is_new_stockholder` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `bank_code` varchar(255) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_customer`
-- ----------------------------
BEGIN;
INSERT INTO `t_customer` VALUES ('1', '11', '11', '0', null, '11', '2018-12-06 20:46:23', '0', '1', '11', null, null, '王润海', '30', '11', '2019-03-03 21:35:24', '0', null, '1'), ('2', '222', '222', '0', null, '222', null, null, '1', '222', null, '222', '我8887', '30', '222', '2019-02-28 20:04:45', '0', null, '1'), ('3', '333', '333', '0', null, '333', null, null, '1', '33', null, '333', '我666', '30', '333', '2019-02-28 20:00:22', '0', null, '1'), ('4', '', '0', '0', null, '', '2018-12-07 10:17:47', '0', '100', '0', null, '', '王润海02', '36', '', '2019-03-01 03:58:39', null, null, '1'), ('5', '11', '111', '0', null, '11', '2018-12-07 10:18:37', '0', '1', '11', null, '11', '我2', '36', '18611300304', '2019-03-01 04:00:47', '0', null, '1'), ('6', '22', '22', '0', null, '222', '2019-02-27 00:28:01', '0', '1', '2', null, '22', '王刚', '21', '22', null, null, null, '1'), ('7', '9999', '999', '0', null, '9999', '2019-02-27 21:41:08', '0', '1', '999', null, '999', '王润海', '34', '999', null, null, null, '1'), ('8', '222', '222', '0', null, '222', '2019-02-28 19:44:16', '0', '100', '222', null, '222', '我999', '30', '222', '2019-02-28 20:04:38', null, null, '1'), ('9', '1212', '1212', '0', null, '12121', '2019-03-01 04:37:28', '0', '1', '12120', null, '1212', '王', '37', '1212', null, null, null, '1'), ('10', '11', '11', '0', null, '11', '2019-03-06 06:38:08', '0', '1', '11', null, null, '王双', '33', '11', null, null, '11', '3'), ('11', '444', '444', '0', null, '444', '2019-03-18 21:26:30', '0', '1', '444', null, null, '王刚', '41', '444', null, null, '444', '2'), ('12', '22', '22', '0', null, '22', '2019-03-18 21:30:54', '0', '1', '22', null, null, '王姐', '41', '22', null, null, '22', '2'), ('13', '11', '11', '0', null, '11', '2019-03-25 01:31:20', '0', '1', '11', null, null, '紫荆化', '51', '11', null, null, '11', '2'), ('14', '22', '22', '0', null, '222', '2019-03-27 03:44:07', '0', '1', '1', null, null, '我爸', '55', '18611300304', null, null, '22', '2'), ('15', '22', '22', '0', null, '222', '2019-03-28 07:21:20', '0', '1', '22', null, null, '全能王1', '58', '22', null, null, '22', '2'), ('16', '22', '0', '0', null, '222', '2019-03-28 08:02:40', '0', '1', '0', null, null, '王润海02', '59', '22', null, null, '22', '2'), ('17', '22', '22', '0', null, '410726197906105416', '2019-03-28 09:36:54', '0', '1', '22', null, null, '王刚', '60', '22', null, null, '22', '3'), ('18', '22', '22', '0', null, '222', '2019-03-28 20:31:18', '0', '1', '22', null, null, '胜利王', '61', '22', null, null, '22', '2'), ('19', '22', '22', '0', null, '222', '2019-03-28 22:41:45', '0', '1', '2', null, null, '小刀王', '62', '22', null, null, '22', '2'), ('20', '444', '22', '0', null, '444', '2019-04-02 02:08:36', '0', '1', '2', null, null, '六小灵通', '63', '333', null, null, '11', '2'), ('21', '22', '22', '0', null, '222', '2019-04-02 04:54:13', '0', '1', '3', null, null, '七七', '64', '18611300304', null, null, '33', '3');
COMMIT;

-- ----------------------------
--  Table structure for `t_finance_account`
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_account`;
CREATE TABLE `t_finance_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_names` varchar(255) DEFAULT NULL,
  `account_state` int(11) DEFAULT NULL,
  `account_no` varchar(255) DEFAULT NULL,
  `bank` int(11) DEFAULT NULL,
  `company` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_finance_account`
-- ----------------------------
BEGIN;
INSERT INTO `t_finance_account` VALUES ('1', '工行-446', '1', '333446', '1', '1', '2019-03-27 10:53:19', '0', '1', null, '0'), ('2', '农行-114', '1', '222114', '3', '1', '2019-03-27 11:01:11', '0', '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_finance_accounting_entry`
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_accounting_entry`;
CREATE TABLE `t_finance_accounting_entry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accounting_date` datetime DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `debit` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=864 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_finance_accounting_entry`
-- ----------------------------
BEGIN;
INSERT INTO `t_finance_accounting_entry` VALUES ('755', '2019-03-30 18:08:53', '11.00', '2019-03-30 18:08:53', '0', '12', '37', '1', null, null), ('756', '2019-03-30 18:08:53', '11.00', '2019-03-30 18:08:53', '0', '37', '5', '1', null, null), ('757', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('758', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('759', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('760', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('761', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('762', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('763', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('764', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('765', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('766', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('767', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('768', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('769', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('770', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('771', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('772', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('773', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('774', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('775', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('776', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('777', '2019-03-30 18:08:53', '7.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('778', '2019-03-30 18:08:53', '7.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('779', '2019-03-30 18:08:53', '7.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('780', '2019-03-30 18:08:53', '7.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('781', '2019-03-30 18:08:53', '11.00', '2019-03-30 18:08:53', '0', '3', '12', '1', null, null), ('782', '2019-03-30 18:08:53', '7.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('783', '2019-03-30 18:08:53', '7.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('784', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('785', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('786', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('787', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('788', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('789', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('790', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('791', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('792', '2019-03-30 18:08:53', '1200.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('793', '2019-03-30 18:08:53', '1200.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('794', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('795', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('796', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('797', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('798', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('799', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('800', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('801', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('802', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('803', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('804', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('805', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('806', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('807', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('808', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('809', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('810', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('811', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('812', '2019-03-30 18:08:53', '553.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('813', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('814', '2019-03-30 18:08:53', '6.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('815', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('816', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('817', '2019-03-30 18:08:53', '333.00', '2019-03-30 18:08:53', '0', '12', '37', '1', null, null), ('818', '2019-03-30 18:08:53', '333.00', '2019-03-30 18:08:53', '0', '3', '12', '1', null, null), ('819', '2019-03-30 18:08:53', '333.00', '2019-03-30 18:08:53', '0', '37', '5', '1', null, null), ('820', '2019-03-30 18:08:53', '333.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('821', '2019-03-30 18:08:53', '600.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('822', '2019-03-30 18:08:53', '600.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('823', '2019-03-30 18:08:53', '3.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('824', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('825', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('826', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('827', '2019-03-30 18:08:53', '0.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('828', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('829', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('830', '2019-03-30 18:08:53', '400.00', '2019-03-30 18:08:53', '0', '12', '37', '1', null, null), ('831', '2019-03-30 18:08:53', '400.00', '2019-03-30 18:08:53', '0', '3', '12', '1', null, null), ('832', '2019-03-30 18:08:53', '400.00', '2019-03-30 18:08:53', '0', '37', '5', '1', null, null), ('833', '2019-03-30 18:08:53', '400.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('834', '2019-03-30 18:08:53', '1200.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('835', '2019-03-30 18:08:53', '1200.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('836', '2019-03-30 18:08:53', '5.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('837', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('838', '2019-03-30 18:08:53', '1.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('839', '2019-03-30 18:08:53', '300.00', '2019-03-30 18:08:53', '0', '12', '37', '1', null, null), ('840', '2019-03-30 18:08:53', '300.00', '2019-03-30 18:08:53', '0', '3', '12', '1', null, null), ('841', '2019-03-30 18:08:53', '300.00', '2019-03-30 18:08:53', '0', '37', '5', '1', null, null), ('842', '2019-03-30 18:08:53', '300.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('843', '2019-03-30 18:08:53', '1200.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('844', '2019-03-30 18:08:53', '1200.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('845', '2019-03-30 18:08:53', '8.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('846', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('847', '2019-03-30 18:08:53', '2.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('848', '2019-03-30 18:08:53', '900.00', '2019-03-30 18:08:53', '0', '12', '37', '1', null, null), ('849', '2019-03-30 18:08:53', '900.00', '2019-03-30 18:08:53', '0', '3', '12', '1', null, null), ('850', '2019-03-30 18:08:53', '900.00', '2019-03-30 18:08:53', '0', '37', '5', '1', null, null), ('851', '2019-03-30 18:08:53', '900.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('852', '2019-03-30 18:08:53', '1200.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('853', '2019-03-30 18:08:53', '1200.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('854', '2019-03-30 18:08:53', '243000.00', '2019-03-30 18:08:53', '0', '25', '7', '1', null, null), ('855', '2019-03-30 18:08:53', '18000.00', '2019-03-30 18:08:53', '0', '26', '5', '1', null, null), ('856', '2019-03-30 18:08:53', '18000.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('857', '2019-03-30 18:08:53', '9000000.00', '2019-03-30 18:08:53', '0', '12', '37', '1', null, null), ('858', '2019-03-30 18:08:53', '9000000.00', '2019-03-30 18:08:53', '0', '3', '12', '1', null, null), ('859', '2019-03-30 18:08:53', '9000000.00', '2019-03-30 18:08:53', '0', '37', '5', '1', null, null), ('860', '2019-03-30 18:08:53', '9000000.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('861', '2019-03-30 18:08:53', '9000000.00', '2019-03-30 18:08:53', '0', '5', '3', '1', null, null), ('862', '2019-03-31 00:00:00', '243615.00', '2019-03-30 18:24:41', '0', '22', '25', '1', null, null), ('863', '2019-03-31 00:00:00', '23442.00', '2019-03-30 18:24:41', '0', '22', '26', '1', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `t_finance_accounting_period`
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_accounting_period`;
CREATE TABLE `t_finance_accounting_period` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `period_state` int(11) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_finance_accounting_period`
-- ----------------------------
BEGIN;
INSERT INTO `t_finance_accounting_period` VALUES ('1', '2019-03-29 03:09:39', '0', '2019-03-31 11:00:00', '201903', '3', '2019-02-28 10:00:00', '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_finance_accounting_rule`
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_accounting_rule`;
CREATE TABLE `t_finance_accounting_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `credit_side` int(11) DEFAULT NULL,
  `debit_side` int(11) DEFAULT NULL,
  `fee_type` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_finance_accounting_rule`
-- ----------------------------
BEGIN;
INSERT INTO `t_finance_accounting_rule` VALUES ('1', '2019-02-25 20:19:36', '0', '1', '1', '0', '100', '2019-02-25 20:19:42', '0'), ('2', '2019-03-29 00:59:57', '0', '25', '7', '1', '1', null, '0'), ('3', '2019-03-29 01:03:11', '0', '26', '5', '3', '100', '2019-03-29 01:05:28', '0'), ('4', '2019-03-29 01:04:04', '0', '26', '5', '9', '1', null, '0'), ('5', '2019-03-29 01:05:02', '0', '26', '5', '30', '1', null, '0'), ('6', '2019-03-29 01:06:00', '0', '7', '3', '8', '1', null, '0'), ('7', '2019-03-29 01:06:28', '0', '5', '3', '15', '1', null, '0'), ('8', '2019-03-29 01:06:44', '0', '5', '3', '31', '1', null, '0'), ('9', '2019-03-29 01:34:20', '0', '12', '37', '21', '1', null, '0'), ('10', '2019-03-29 01:35:02', '0', '3', '12', '19', '1', null, '0'), ('11', '2019-03-29 01:36:45', '0', '37', '5', '26', '1', null, '0'), ('12', '2019-03-29 01:37:02', '0', '5', '3', '28', '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_finance_balance`
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_balance`;
CREATE TABLE `t_finance_balance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accounting_period` int(11) DEFAULT NULL,
  `amount_credit` decimal(19,2) DEFAULT NULL,
  `amount_debit` decimal(19,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `end_amount_credit` decimal(19,2) DEFAULT NULL,
  `end_amount_debit` decimal(19,2) DEFAULT NULL,
  `start_amount_credit` decimal(19,2) DEFAULT NULL,
  `start_amount_debit` decimal(19,2) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `subject` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_finance_balance`
-- ----------------------------
BEGIN;
INSERT INTO `t_finance_balance` VALUES ('9', '1', '9001944.00', '9001944.00', '2019-03-30 18:08:53', '0', '9001944.00', '9001944.00', '0.00', '0.00', null, '12', '2019-03-30 18:08:53', null), ('10', '1', '9001944.00', '9001944.00', '2019-03-30 18:08:53', '0', '9001944.00', '9001944.00', '0.00', '0.00', null, '37', '2019-03-30 18:08:53', null), ('11', '1', '18025352.00', '9025386.00', '2019-03-30 18:08:53', '0', '18025352.00', '9025386.00', '0.00', '0.00', null, '5', '2019-03-30 18:08:53', null), ('12', '1', '243615.00', '0.00', '2019-03-30 18:08:53', '0', '243615.00', '0.00', '0.00', '0.00', null, '25', '2019-03-30 18:08:53', null), ('13', '1', '0.00', '243615.00', '2019-03-30 18:08:53', '0', '0.00', '243615.00', '0.00', '0.00', null, '7', null, null), ('14', '1', '23442.00', '0.00', '2019-03-30 18:08:53', '0', '23442.00', '0.00', '0.00', '0.00', null, '26', '2019-03-30 18:08:53', null), ('15', '1', '9001944.00', '18025352.00', '2019-03-30 18:08:53', '0', '9001944.00', '18025352.00', '0.00', '0.00', null, '3', '2019-03-30 18:08:53', null), ('18', '1', '267057.00', '0.00', '2019-03-30 18:24:41', '0', '267057.00', '0.00', '0.00', '0.00', null, '22', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `t_finance_payment`
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_payment`;
CREATE TABLE `t_finance_payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `comp_card_no` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `in_out` int(11) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `other_card_no` varchar(255) DEFAULT NULL,
  `pay_date` datetime DEFAULT NULL,
  `pay_state` int(11) DEFAULT NULL,
  `pay_type` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `offset` int(11) DEFAULT NULL,
  `other_bank_id` bigint(20) DEFAULT NULL,
  `related_id` bigint(20) DEFAULT NULL,
  `if_real` int(11) DEFAULT NULL,
  `order_product_id` bigint(20) DEFAULT NULL,
  `posted` varchar(3) NOT NULL COMMENT 'Y:已过账；2:未过账',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=206976 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_finance_payment`
-- ----------------------------
BEGIN;
INSERT INTO `t_finance_payment` VALUES ('206602', '王双', '11.00', null, '2019-03-07 19:40:08', '0', '2', '0', '33', null, '2019-03-01 00:00:00', '6', '21', '1', null, '0', '1', '0', '206632', '2', '16', 'Y'), ('206603', '王双', '11.00', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-07-19 00:00:00', '7', '26', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206604', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-03-01 00:00:00', '6', '1', '1', null, '0', '1', '0', '206633', '2', '16', 'Y'), ('206605', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-03-08 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206606', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-03-15 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206607', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-03-22 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206608', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-03-29 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206609', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-04-05 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206610', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-04-12 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206611', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-04-19 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206612', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-04-26 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206613', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-05-03 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206614', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-05-10 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206615', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-05-17 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206616', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-05-24 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206617', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-05-31 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206618', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-06-07 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206619', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-06-14 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206620', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-06-21 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206621', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-06-28 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206622', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-07-05 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206623', '王双', '2.20', null, '2019-03-07 19:40:08', '0', '1', '0', '33', null, '2019-07-12 00:00:00', '7', '1', '1', null, '0', '2', '0', '0', '2', '16', 'Y'), ('206624', '王润海', '6.60', null, '2019-03-07 19:41:24', '0', '1', '0', '30', null, '2019-03-07 19:41:24', '6', '3', '1', null, '0', '1', '0', '206634', '2', '10', 'Y'), ('206625', '王润海', '6.60', null, '2019-03-07 19:41:24', '0', '1', '0', '30', null, '2019-03-07 19:41:24', '6', '9', '1', null, '0', '1', '0', '206636', '2', '10', 'Y'), ('206626', '王润海', '6.60', null, '2019-03-07 19:41:24', '0', '1', '0', '30', null, '2019-03-07 19:41:24', '6', '10', '1', null, '0', '1', '0', '206637', '2', '10', 'Y'), ('206627', '王润海', '6.60', null, '2019-03-07 19:41:24', '0', '1', '0', '30', null, '2019-03-07 19:41:24', '6', '11', '1', null, '0', '1', '0', '206639', '2', '10', 'Y'), ('206628', '王润海', '6.60', null, '2019-03-07 19:41:24', '0', '1', '0', '30', null, '2019-03-07 19:41:24', '6', '3', '1', null, '0', '1', '0', '206635', '2', '11', 'Y'), ('206629', '王润海', '6.60', null, '2019-03-07 19:41:24', '0', '1', '0', '30', null, '2019-03-07 19:41:24', '6', '9', '1', null, '0', '1', '0', '206640', '2', '11', 'Y'), ('206630', '王润海', '6.60', null, '2019-03-07 19:41:24', '0', '1', '0', '30', null, '2019-03-07 19:41:24', '6', '10', '1', null, '0', '1', '0', '206638', '2', '11', 'Y'), ('206631', '王润海', '6.60', null, '2019-03-07 19:41:24', '0', '1', '0', '30', null, '2019-03-07 19:41:24', '6', '11', '1', null, '0', '1', '0', '206641', '2', '11', 'Y'), ('206632', '王双', '11.00', '666', '2019-03-07 05:43:11', '0', '2', '0', '33', '666', '2019-02-01 10:00:00', '5', '19', '1', null, '0', '1', '1', '206602', '1', '16', 'Y'), ('206633', '王双', '2.20', '777', '2019-03-07 05:43:22', '0', '1', '0', '33', '777', '2019-02-01 10:00:00', '5', '18', '1', null, '0', '1', '1', '206604', '1', '16', 'Y'), ('206634', '王润海', '6.60', '888', '2019-03-07 05:44:05', '0', '1', '0', '30', '888', '2019-02-01 10:00:00', '5', '14', '1', null, '0', '1', '1', '206624', '1', '10', 'Y'), ('206635', '王润海', '6.60', '999', '2019-03-07 05:44:31', '0', '1', '0', '30', '999', '2019-02-01 10:00:00', '5', '14', '1', null, '0', '1', '1', '206628', '1', '11', 'Y'), ('206636', '王润海', '6.60', '222', '2019-03-07 06:10:45', '0', '1', '0', '30', '222', '2019-02-01 10:00:00', '5', '15', '1', null, '0', '1', '1', '206625', '1', '10', 'Y'), ('206637', '王润海', '6.60', '666', '2019-03-07 06:12:04', '0', '1', '0', '30', '22', '2019-02-01 10:00:00', '5', '16', '1', null, '0', '1', '1', '206626', '1', '10', 'Y'), ('206638', '王润海', '6.60', '666', '2019-03-07 06:12:26', '0', '1', '0', '30', '22', '2019-02-01 10:00:00', '5', '16', '1', null, '0', '1', '1', '206630', '1', '11', 'Y'), ('206639', '王润海', '6.60', '666', '2019-03-07 06:12:48', '0', '1', '0', '30', '22', '2019-02-01 10:00:00', '5', '17', '1', null, '0', '1', '1', '206627', '1', '10', 'Y'), ('206640', '王润海', '6.60', '22', '2019-03-07 06:12:56', '0', '1', '0', '30', '22', '2019-02-01 10:00:00', '5', '15', '1', null, '0', '1', '1', '206629', '1', '11', 'Y'), ('206641', '王润海', '6.60', '22', '2019-03-07 06:13:02', '0', '1', '0', '30', '22', '2019-02-01 10:00:00', '5', '17', '1', null, '0', '1', '1', '206631', '1', '11', 'Y'), ('206842', '王刚', '2.20', null, '2019-03-19 15:26:05', '0', '1', '0', '41', null, '2019-03-19 15:26:05', '6', '3', '100', '2019-03-27 04:25:52', '0', '2', '0', '0', '2', '17', 'Y'), ('206843', '王刚', '2.20', null, '2019-03-19 15:26:05', '0', '1', '0', '41', null, '2019-03-19 15:26:05', '6', '9', '100', '2019-03-27 04:25:52', '0', '2', '0', '0', '2', '17', 'Y'), ('206844', '王刚', '2.20', null, '2019-03-19 15:26:05', '0', '1', '0', '41', null, '2019-03-19 15:26:05', '6', '10', '100', '2019-03-27 04:25:51', '0', '2', '0', '0', '2', '17', 'Y'), ('206845', '王刚', '2.20', null, '2019-03-19 15:26:05', '0', '1', '0', '41', null, '2019-03-19 15:26:05', '6', '11', '100', '2019-03-27 04:25:51', '0', '2', '0', '0', '2', '17', 'Y'), ('206846', null, '0.00', null, null, '8', '1', '0', '54', null, '2019-03-26 21:02:38', '6', '30', '100', '2019-03-27 04:25:50', '0', '2', '0', '0', '2', '0', 'Y'), ('206847', null, '0.00', null, null, '8', '1', '0', '54', null, '2019-03-27 00:50:31', '6', '30', '100', '2019-03-27 04:25:50', '0', '2', '0', '0', '2', '0', 'Y'), ('206848', null, '0.00', null, null, '8', '1', '0', '54', null, '2019-03-27 00:59:40', '6', '30', '100', '2019-03-27 04:25:49', '0', '2', '0', '0', '2', '0', 'Y'), ('206849', null, '0.00', null, null, '8', '1', '0', '54', null, '2019-03-27 03:18:25', '6', '30', '100', '2019-03-27 04:25:49', '0', '2', '0', '0', '2', '0', 'Y'), ('206850', null, '0.00', null, null, '8', '1', '0', '54', null, '2019-03-27 03:21:19', '6', '30', '100', '2019-03-27 04:25:48', '0', '2', '0', '0', '2', '0', 'Y'), ('206851', null, '0.00', null, null, '8', '1', '0', '54', null, '2019-03-27 03:32:04', '6', '30', '100', '2019-03-27 04:25:47', '0', '2', '0', '0', '2', '0', 'Y'), ('206852', null, '1200.00', null, null, '8', '1', '0', '55', null, '2019-03-27 03:48:17', '6', '30', '1', null, '0', '1', '0', '0', '2', '0', 'Y'), ('206853', '666', '1200.00', '666', '2019-03-27 04:16:54', '0', '1', '0', '55', '22', '2019-03-27 11:00:00', '5', '31', '1', null, '0', '1', '1', '206852', '1', '0', 'Y'), ('206854', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 04:42:53', '6', '1', '100', '2019-03-27 07:10:34', '0', '2', '0', '0', '2', '0', 'Y'), ('206855', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 04:42:53', '6', '9', '100', '2019-03-27 07:10:35', '0', '2', '0', '0', '2', '0', 'Y'), ('206856', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 05:01:21', '6', '1', '100', '2019-03-27 07:10:35', '0', '2', '0', '0', '2', '0', 'Y'), ('206857', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 05:01:21', '6', '9', '100', '2019-03-27 07:10:36', '0', '2', '0', '0', '2', '0', 'Y'), ('206858', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 06:27:19', '6', '1', '100', '2019-03-27 07:10:37', '0', '2', '0', '0', '2', '0', 'Y'), ('206859', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 06:27:19', '6', '9', '100', '2019-03-27 07:10:37', '0', '2', '0', '0', '2', '0', 'Y'), ('206860', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 06:29:52', '6', '1', '100', '2019-03-27 07:10:38', '0', '2', '0', '0', '2', '0', 'Y'), ('206861', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 06:29:52', '6', '9', '100', '2019-03-27 07:10:38', '0', '2', '0', '0', '2', '0', 'Y'), ('206862', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 06:43:12', '6', '1', '100', '2019-03-27 07:10:39', '0', '2', '0', '0', '2', '0', 'Y'), ('206863', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 06:43:12', '6', '9', '100', '2019-03-27 07:10:39', '0', '2', '0', '0', '2', '0', 'Y'), ('206864', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 07:00:03', '6', '1', '100', '2019-03-27 07:10:33', '0', '2', '0', '0', '2', '0', 'Y'), ('206865', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 07:00:03', '6', '9', '100', '2019-03-27 07:10:40', '0', '2', '0', '0', '2', '0', 'Y'), ('206866', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 07:01:19', '6', '1', '100', '2019-03-27 07:10:40', '0', '2', '0', '0', '2', '0', 'Y'), ('206867', null, '0.67', null, null, '9', '1', '0', '55', null, '2019-03-27 07:01:19', '6', '9', '100', '2019-03-27 07:10:41', '0', '2', '0', '0', '2', '0', 'Y'), ('206868', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 07:03:07', '6', '1', '100', '2019-03-27 07:10:41', '0', '2', '0', '0', '2', '0', 'Y'), ('206869', null, '0.67', null, null, '9', '1', '0', '55', null, '2019-03-27 07:03:07', '6', '9', '100', '2019-03-27 07:10:41', '0', '2', '0', '0', '2', '0', 'Y'), ('206870', null, '0.00', null, null, '9', '1', '0', '55', null, '2019-03-27 07:04:06', '6', '1', '100', '2019-03-27 07:10:42', '0', '2', '0', '0', '2', '0', 'Y'), ('206871', null, '0.67', null, null, '9', '1', '0', '55', null, '2019-03-27 07:04:06', '6', '9', '100', '2019-03-27 07:10:43', '0', '2', '0', '0', '2', '0', 'Y'), ('206872', null, '552.78', null, null, '9', '1', '0', '55', null, '2019-03-27 07:04:54', '6', '1', '100', '2019-03-27 07:10:44', '0', '2', '0', '0', '2', '0', 'Y'), ('206873', null, '0.67', null, null, '9', '1', '0', '55', null, '2019-03-27 07:04:54', '6', '9', '100', '2019-03-27 07:10:44', '0', '2', '0', '0', '2', '0', 'Y'), ('206874', null, '5.53', null, null, '9', '1', '0', '55', null, '2019-03-27 07:08:26', '6', '1', '1', null, '0', '1', '0', '206876', '2', '0', 'Y'), ('206875', null, '0.67', null, null, '9', '1', '0', '55', null, '2019-03-27 07:08:26', '6', '9', '1', null, '0', '1', '0', '206877', '2', '0', 'Y'), ('206876', '666', '5.53', '666', '2019-03-27 07:11:02', '0', '1', '0', '55', '44', '2019-03-27 11:00:00', '5', '18', '1', null, '0', '1', '1', '206874', '1', '0', 'Y'), ('206877', '44', '0.67', '333', '2019-03-27 07:11:12', '0', '1', '0', '55', '444', '2019-03-27 11:00:00', '5', '15', '1', null, '0', '1', '1', '206875', '1', '0', 'Y'), ('206878', null, '333.00', null, null, '7', '1', '0', '55', null, '2019-03-27 07:13:06', '6', '21', '1', null, '0', '1', '0', '206879', '2', '0', 'Y'), ('206879', '333', '333.00', '666', '2019-03-27 07:13:36', '0', '2', '0', '55', '333', '2019-03-27 11:00:00', '5', '19', '1', null, '0', '1', '1', '206878', '1', '0', 'Y'), ('206880', null, '333.00', null, null, '9', '1', '0', '55', null, '2019-03-27 07:14:23', '6', '26', '1', null, '0', '1', '0', '206881', '2', '0', 'Y'), ('206881', '33', '333.00', '666', '2019-03-27 07:14:44', '0', '1', '0', '55', '33', '2019-03-27 11:00:00', '5', '28', '1', null, '0', '1', '1', '206880', '1', '0', 'Y'), ('206882', null, '600.00', null, null, '8', '1', '0', '58', null, '2019-03-28 07:24:18', '6', '30', '1', null, '0', '1', '0', '206883', '2', '0', 'Y'), ('206883', '666', '600.00', '222114', '2019-03-28 07:28:42', '0', '1', '0', '58', '666', '2019-03-27 11:00:00', '5', '31', '1', null, '0', '1', '1', '206882', '1', '0', 'Y'), ('206884', null, '2.66', null, null, '9', '1', '0', '58', null, '2019-03-28 07:29:20', '6', '1', '1', null, '0', '1', '0', '206936', '2', '0', 'Y'), ('206885', null, '0.67', null, null, '9', '1', '0', '58', null, '2019-03-28 07:29:20', '6', '9', '1', null, '0', '1', '0', '206937', '2', '0', 'Y'), ('206886', null, '0.00', null, null, '8', '1', '0', '59', null, '2019-03-28 08:06:04', '6', '30', '1', null, '0', '1', '0', '206887', '2', '0', 'Y'), ('206887', '666', '0.00', '333446', '2019-03-28 08:07:19', '0', '1', '0', '59', '22', '2019-03-27 11:00:00', '5', '31', '1', null, '0', '1', '1', '206886', '1', '0', 'Y'), ('206888', null, '0.00', null, null, '9', '1', '0', '59', null, '2019-03-28 08:08:03', '6', '1', '1', null, '0', '1', '0', '206890', '2', '0', 'Y'), ('206889', null, '0.80', null, null, '9', '1', '0', '59', null, '2019-03-28 08:08:03', '6', '9', '1', null, '0', '1', '0', '206891', '2', '0', 'Y'), ('206890', '666', '0.00', '333446', '2019-03-28 08:09:05', '0', '1', '0', '59', '666', '2019-03-27 11:00:00', '5', '18', '1', null, '0', '1', '1', '206888', '1', '0', 'Y'), ('206891', '666', '0.80', '333446', '2019-03-28 08:09:12', '0', '1', '0', '59', '666', '2019-03-27 11:00:00', '5', '15', '1', null, '0', '1', '1', '206889', '1', '0', 'Y'), ('206892', null, '400.00', null, null, '7', '1', '0', '59', null, '2019-03-28 08:09:51', '6', '21', '1', null, '0', '1', '0', '206893', '2', '0', 'Y'), ('206893', '666', '400.00', '333446', '2019-03-28 08:10:39', '0', '2', '0', '59', '666', '2019-03-27 11:00:00', '5', '19', '1', null, '0', '1', '1', '206892', '1', '0', 'Y'), ('206894', null, '400.00', null, null, '9', '2', '0', '59', null, '2019-03-28 08:11:10', '6', '26', '1', null, '0', '1', '0', '206895', '2', '0', 'Y'), ('206895', '666', '400.00', '333446', '2019-03-28 08:11:32', '0', '1', '0', '59', '666', '2019-03-27 11:00:00', '5', '28', '1', null, '0', '1', '1', '206894', '1', '0', 'Y'), ('206896', null, '1200.00', null, null, '8', '1', '0', '60', null, '2019-03-28 09:39:43', '6', '30', '1', null, '0', '1', '0', '206897', '2', '0', 'Y'), ('206897', '666', '1200.00', '333446', '2019-03-28 09:40:17', '0', '1', '0', '60', '666', '2019-03-27 11:00:00', '5', '31', '1', null, '0', '1', '1', '206896', '1', '0', 'Y'), ('206898', null, '4.80', null, null, '9', '1', '0', '60', null, '2019-03-28 09:40:52', '6', '1', '1', null, '0', '1', '0', '206900', '2', '0', 'Y'), ('206899', null, '0.60', null, null, '9', '1', '0', '60', null, '2019-03-28 09:40:52', '6', '9', '1', null, '0', '1', '0', '206901', '2', '0', 'Y'), ('206900', '666', '4.80', '333446', '2019-03-28 09:42:58', '0', '1', '0', '60', '666', '2019-03-27 11:00:00', '5', '18', '1', null, '0', '1', '1', '206898', '1', '0', 'Y'), ('206901', '666', '0.60', '333446', '2019-03-28 09:43:05', '0', '1', '0', '60', '666', '2019-03-27 11:00:00', '5', '15', '1', null, '0', '1', '1', '206899', '1', '0', 'Y'), ('206902', null, '300.00', null, null, '7', '1', '0', '60', null, '2019-03-28 09:43:27', '6', '21', '1', null, '0', '1', '0', '206903', '2', '0', 'Y'), ('206903', '666', '300.00', '333446', '2019-03-28 09:43:52', '0', '2', '0', '60', '666', '2019-03-27 11:00:00', '5', '19', '1', null, '0', '1', '1', '206902', '1', '0', 'Y'), ('206904', null, '300.00', null, null, '9', '2', '0', '60', null, '2019-03-28 09:44:20', '6', '26', '1', null, '0', '1', '0', '206905', '2', '0', 'Y'), ('206905', '666', '300.00', '333446', '2019-03-28 09:44:38', '0', '1', '0', '60', '666', '2019-03-27 11:00:00', '5', '28', '1', null, '0', '1', '1', '206904', '1', '0', 'Y'), ('206906', null, '1200.00', null, null, '8', '1', '0', '61', null, '2019-03-28 20:33:27', '6', '30', '1', null, '0', '1', '0', '206907', '2', '0', 'Y'), ('206907', '666', '1200.00', '333446', '2019-03-28 20:34:05', '0', '1', '0', '61', '666', '2019-03-28 11:00:00', '5', '31', '1', null, '0', '1', '1', '206906', '1', '0', 'Y'), ('206908', null, '8.10', null, null, '9', '1', '0', '61', null, '2019-03-28 20:36:35', '6', '1', '1', null, '0', '1', '0', '206910', '2', '0', 'Y'), ('206909', null, '1.80', null, null, '9', '1', '0', '61', null, '2019-03-28 20:36:35', '6', '9', '1', null, '0', '1', '0', '206911', '2', '0', 'Y'), ('206910', '666', '8.10', '333446', '2019-03-28 20:42:12', '0', '1', '0', '61', '666', '2019-03-28 11:00:00', '5', '18', '1', null, '0', '1', '1', '206908', '1', '0', 'Y'), ('206911', '666', '1.80', '333446', '2019-03-28 20:42:18', '0', '1', '0', '61', '666', '2019-03-28 11:00:00', '5', '15', '1', null, '0', '1', '1', '206909', '1', '0', 'Y'), ('206912', null, '900.00', null, null, '7', '1', '0', '61', null, '2019-03-28 20:42:46', '6', '21', '1', null, '0', '1', '0', '206913', '2', '0', 'Y'), ('206913', '666', '900.00', '333446', '2019-03-28 20:43:14', '0', '2', '0', '61', '666', '2019-03-28 11:00:00', '5', '19', '1', null, '0', '1', '1', '206912', '1', '0', 'Y'), ('206914', null, '900.00', null, null, '9', '2', '0', '61', null, '2019-03-28 20:43:49', '6', '26', '1', null, '0', '1', '0', '206915', '2', '0', 'Y'), ('206915', '666', '900.00', '333446', '2019-03-28 20:44:06', '0', '1', '0', '61', '666', '2019-03-28 11:00:00', '5', '28', '1', null, '0', '1', '1', '206914', '1', '0', 'Y'), ('206916', null, '1200.00', null, null, '8', '1', '0', '62', null, '2019-03-28 22:42:51', '6', '30', '1', null, '0', '1', '0', '206917', '2', '0', 'Y'), ('206917', '666', '1200.00', '333446', '2019-03-28 22:43:11', '0', '1', '0', '62', '666', '2019-03-28 11:00:00', '5', '31', '1', null, '0', '1', '1', '206916', '1', '0', 'Y'), ('206918', null, '243000.00', null, null, '9', '1', '0', '62', null, '2019-03-28 22:43:42', '6', '1', '1', null, '0', '1', '0', '206920', '2', '0', 'Y'), ('206919', null, '18000.00', null, null, '9', '1', '0', '62', null, '2019-03-28 22:43:42', '6', '9', '1', null, '0', '1', '0', '206921', '2', '0', 'Y'), ('206920', '666', '243000.00', '333446', '2019-03-28 22:49:29', '0', '1', '0', '62', '666', '2019-03-28 11:00:00', '5', '18', '1', null, '0', '1', '1', '206918', '1', '0', 'Y'), ('206921', '666', '18000.00', '333446', '2019-03-28 22:49:47', '0', '1', '0', '62', '666', '2019-03-27 11:00:00', '5', '15', '1', null, '0', '1', '1', '206919', '1', '0', 'Y'), ('206922', null, '9000000.00', null, null, '7', '1', '0', '62', null, '2019-03-28 22:50:13', '6', '21', '1', null, '0', '1', '0', '206923', '2', '0', 'Y'), ('206923', '666', '9000000.00', '333446', '2019-03-28 22:53:12', '0', '2', '0', '62', '666', '2019-03-28 11:00:00', '5', '19', '1', null, '0', '1', '1', '206922', '1', '0', 'Y'), ('206924', null, '9000000.00', null, null, '9', '2', '0', '62', null, '2019-03-28 22:53:32', '6', '26', '1', null, '0', '1', '0', '206925', '2', '0', 'Y'), ('206925', '666', '9000000.00', '333446', '2019-03-28 22:53:44', '0', '1', '0', '62', '22', '2019-03-28 11:00:00', '5', '28', '1', null, '0', '1', '1', '206924', '1', '0', 'Y'), ('206926', null, '1200.00', null, null, '8', '1', '0', '63', null, '2019-04-02 02:09:26', '6', '30', '1', null, '0', '1', '0', '206927', '2', '0', 'N'), ('206927', '666', '1200.00', '222114', '2019-04-02 02:10:11', '0', '1', '0', '63', '33', '2019-03-27 11:00:00', '5', '31', '1', null, '0', '1', '1', '206926', '1', '0', 'N'), ('206928', null, '51948.00', null, null, '9', '1', '0', '63', null, '2019-04-02 02:11:01', '6', '1', '1', null, '0', '1', '0', '206930', '2', '0', 'N'), ('206929', null, '4440.00', null, null, '9', '1', '0', '63', null, '2019-04-02 02:11:01', '6', '9', '1', null, '0', '1', '0', '206931', '2', '0', 'N'), ('206930', '22', '51948.00', '333446', '2019-04-02 02:11:48', '0', '1', '0', '63', '22', '2019-03-27 11:00:00', '5', '18', '1', null, '0', '1', '1', '206928', '1', '0', 'N'), ('206931', '666', '4440.00', '333446', '2019-04-02 02:11:55', '0', '1', '0', '63', '666', '2019-03-27 11:00:00', '5', '15', '1', null, '0', '1', '1', '206929', '1', '0', 'N'), ('206932', null, '2220000.00', null, null, '7', '1', '0', '63', null, '2019-04-02 02:12:21', '6', '21', '1', null, '0', '1', '0', '206933', '2', '0', 'N'), ('206933', '666', '2220000.00', '222114', '2019-04-02 02:12:46', '0', '2', '0', '63', '666', '2019-03-27 11:00:00', '5', '19', '1', null, '0', '1', '1', '206932', '1', '0', 'N'), ('206934', null, '2220000.00', null, null, '9', '2', '0', '63', null, '2019-04-02 02:13:20', '6', '26', '1', null, '0', '1', '0', '206935', '2', '0', 'N'), ('206935', '33', '2220000.00', '222114', '2019-04-02 02:13:39', '0', '1', '0', '63', '33', '2019-03-27 11:00:00', '5', '28', '1', null, '0', '1', '1', '206934', '1', '0', 'N'), ('206936', '', '2.66', '333446', '2019-04-02 02:28:56', '0', '1', '0', '58', '', null, '5', '18', '1', null, '0', '1', '1', '206884', '1', '0', 'N'), ('206937', '', '0.67', '333446', '2019-04-02 02:28:58', '0', '1', '0', '58', '', null, '5', '15', '1', null, '0', '1', '1', '206885', '1', '0', 'N'), ('206938', null, '600.00', null, null, '8', '1', '0', '64', null, '2019-04-02 04:54:34', '6', '30', '1', null, '0', '1', '0', '206939', '2', '0', 'N'), ('206939', '666', '600.00', '333446', '2019-04-02 04:55:02', '0', '1', '0', '64', '666', '2019-03-28 11:00:00', '5', '31', '1', null, '0', '1', '1', '206938', '1', '0', 'N'), ('206940', null, '77922.00', null, null, '9', '1', '0', '64', null, '2019-04-02 04:55:33', '6', '1', '1', null, '0', '1', '0', '206942', '2', '0', 'N'), ('206941', null, '6660.00', null, null, '9', '1', '0', '64', null, '2019-04-02 04:55:33', '6', '9', '1', null, '0', '1', '0', '206943', '2', '0', 'N'), ('206942', '666', '77922.00', '333446', '2019-04-02 04:56:15', '0', '1', '0', '64', '666', '2019-03-28 11:00:00', '5', '18', '1', null, '0', '1', '1', '206940', '1', '0', 'N'), ('206943', '666', '6660.00', '333446', '2019-04-02 04:56:22', '0', '1', '0', '64', '22', '2019-03-27 11:00:00', '5', '15', '1', null, '0', '1', '1', '206941', '1', '0', 'N'), ('206944', null, '3330000.00', null, null, '7', '1', '0', '64', null, '2019-04-02 04:56:49', '6', '21', '1', null, '0', '1', '0', '206945', '2', '0', 'N'), ('206945', '666', '3330000.00', '333446', '2019-04-02 04:57:16', '0', '2', '0', '64', '666', '2019-03-31 11:00:00', '5', '19', '1', null, '0', '1', '1', '206944', '1', '0', 'N'), ('206946', null, '3330000.00', null, null, '9', '2', '0', '64', null, '2019-04-02 04:57:51', '6', '26', '1', null, '0', '1', '0', '206947', '2', '0', 'N'), ('206947', '666', '3330000.00', '333446', '2019-04-02 04:58:06', '0', '1', '0', '64', '666', '2019-03-31 11:00:00', '5', '28', '1', null, '0', '1', '1', '206946', '1', '0', 'N'), ('206948', null, '0.00', null, null, '8', '1', '0', '89', null, '2019-04-22 09:10:42', '6', '30', '1', null, '0', '1', '0', '206949', '2', '0', 'N'), ('206949', '666', '0.00', '333446', '2019-04-22 09:12:55', '0', '1', '0', '89', '666', '2019-03-27 16:00:00', '5', '31', '1', null, '0', '1', '1', '206948', '1', '0', 'N'), ('206950', null, '0.00', null, null, '9', '1', '0', '89', null, '2019-04-22 09:16:02', '6', '1', '1', null, '0', '1', '0', '206952', '2', '0', 'N'), ('206951', null, '12000.00', null, null, '9', '1', '0', '89', null, '2019-04-22 09:16:02', '6', '9', '1', null, '0', '1', '0', '206953', '2', '0', 'N'), ('206952', '666', '0.00', '333446', '2019-04-22 09:18:44', '0', '1', '0', '89', '666', '2019-03-27 16:00:00', '5', '18', '1', null, '0', '1', '1', '206950', '1', '0', 'N'), ('206953', '666', '12000.00', '333446', '2019-04-22 09:18:50', '0', '1', '0', '89', '22', '2019-03-27 16:00:00', '5', '15', '1', null, '0', '1', '1', '206951', '1', '0', 'N'), ('206954', null, '6000000.00', null, null, '7', '1', '0', '89', null, '2019-04-22 09:30:33', '6', '21', '1', null, '0', '1', '0', '206955', '2', '0', 'N'), ('206955', '11', '6000000.00', '333446', '2019-04-22 09:31:02', '0', '2', '0', '89', '666', '2019-03-31 16:00:00', '5', '19', '1', null, '0', '1', '1', '206954', '1', '0', 'N'), ('206956', null, '0.00', null, null, '8', '1', '0', '90', null, '2019-04-22 11:26:59', '6', '30', '1', null, '0', '1', '0', '206957', '2', '0', 'N'), ('206957', '666', '0.00', '333446', '2019-04-22 11:27:34', '0', '1', '0', '90', '22', '2019-03-27 16:00:00', '5', '31', '1', null, '0', '1', '1', '206956', '1', '0', 'N'), ('206958', null, '0.00', null, null, '9', '1', '0', '90', null, '2019-04-22 11:50:41', '6', '1', '1', null, '0', '1', '0', '206960', '2', '0', 'N'), ('206959', null, '4700.00', null, null, '9', '1', '0', '90', null, '2019-04-22 11:50:41', '6', '9', '1', null, '0', '1', '0', '206961', '2', '0', 'N'), ('206960', '666', '0.00', '333446', '2019-04-22 11:51:52', '0', '1', '0', '90', '666', '2019-10-09 16:00:00', '5', '18', '1', null, '0', '1', '1', '206958', '1', '0', 'N'), ('206961', '22', '4700.00', '333446', '2019-04-22 11:52:00', '0', '1', '0', '90', '22', '2019-10-09 16:00:00', '5', '15', '1', null, '0', '1', '1', '206959', '1', '0', 'N'), ('206962', null, '2350000.00', null, null, '7', '1', '0', '90', null, '2019-04-22 11:52:45', '6', '21', '1', null, '0', '1', '0', '206963', '2', '0', 'N'), ('206963', '666', '2350000.00', '333446', '2019-04-22 11:53:08', '0', '2', '0', '90', '666', '2019-10-09 16:00:00', '5', '19', '1', null, '0', '1', '1', '206962', '1', '0', 'N'), ('206964', null, '2350000.00', null, null, '9', '2', '0', '90', null, '2019-04-22 11:54:16', '6', '26', '1', null, '0', '1', '0', '206965', '2', '0', 'N'), ('206965', '666', '2350000.00', '333446', '2019-04-22 11:54:43', '0', '1', '0', '90', '666', '2019-03-27 16:00:00', '5', '28', '1', null, '0', '1', '1', '206964', '1', '0', 'N'), ('206966', null, '1200.00', null, null, '8', '1', '0', '92', null, '2019-04-24 01:56:48', '6', '30', '1', null, '0', '1', '0', '206967', '2', '0', 'N'), ('206967', '666', '1200.00', '333446', '2019-04-24 01:57:42', '0', '1', '0', '92', '11', '2019-03-27 16:00:00', '5', '31', '1', null, '0', '1', '1', '206966', '1', '0', 'N'), ('206968', null, '93760.00', null, null, '9', '1', '0', '92', null, '2019-04-24 01:59:46', '6', '1', '1', null, '0', '1', '0', '206970', '2', '0', 'N'), ('206969', null, '11720.00', null, null, '9', '1', '0', '92', null, '2019-04-24 01:59:46', '6', '9', '1', null, '0', '1', '0', '206971', '2', '0', 'N'), ('206970', '666', '93760.00', '333446', '2019-04-24 02:00:24', '0', '1', '0', '92', '11', '2019-03-27 16:00:00', '5', '18', '1', null, '0', '1', '1', '206968', '1', '0', 'N'), ('206971', '666', '11720.00', '333446', '2019-04-24 02:00:30', '0', '1', '0', '92', '22', '2019-03-28 16:00:00', '5', '15', '1', null, '0', '1', '1', '206969', '1', '0', 'N'), ('206972', null, '5860000.00', null, null, '7', '1', '0', '92', null, '2019-04-24 02:02:43', '6', '21', '1', null, '0', '1', '0', '206973', '2', '0', 'N'), ('206973', '666', '5860000.00', '333446', '2019-04-24 02:03:00', '0', '2', '0', '92', '666', '2019-03-27 16:00:00', '5', '19', '1', null, '0', '1', '1', '206972', '1', '0', 'N'), ('206974', null, '5860000.00', null, null, '9', '2', '0', '92', null, '2019-04-24 02:04:11', '6', '26', '1', null, '0', '1', '0', '206975', '2', '0', 'N'), ('206975', '666', '5860000.00', '333446', '2019-04-24 02:04:40', '0', '1', '0', '92', '666', '2019-03-27 16:00:00', '5', '28', '1', null, '0', '1', '1', '206974', '1', '0', 'N');
COMMIT;

-- ----------------------------
--  Table structure for `t_format_info_obj`
-- ----------------------------
DROP TABLE IF EXISTS `t_format_info_obj`;
CREATE TABLE `t_format_info_obj` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_provision_date` datetime DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `apply_days` int(11) DEFAULT NULL,
  `approved_date` datetime DEFAULT NULL,
  `assessment_date` datetime DEFAULT NULL,
  `big_data_date` datetime DEFAULT NULL,
  `big_date_conclusion` varchar(255) DEFAULT NULL,
  `certino` varchar(255) DEFAULT NULL,
  `chain_family_evaluation_date` datetime DEFAULT NULL,
  `chain_family_fast_out_price` decimal(19,2) DEFAULT NULL,
  `check_expiration_date` datetime DEFAULT NULL,
  `customer_capital_accountno` varchar(255) DEFAULT NULL,
  `customer_capital_account_name` varchar(255) DEFAULT NULL,
  `customer_capital_bank` varchar(255) DEFAULT NULL,
  `customer_first_pay_days` int(11) DEFAULT NULL,
  `deduction_date` datetime DEFAULT NULL,
  `deposit_certificates_date` datetime DEFAULT NULL,
  `exception_days` int(11) DEFAULT NULL,
  `extension_fee` decimal(19,2) DEFAULT NULL,
  `fee_date` datetime DEFAULT NULL,
  `file_collection_date` datetime DEFAULT NULL,
  `file_report_date` datetime DEFAULT NULL,
  `finish_date` datetime DEFAULT NULL,
  `first_extension_days` int(11) DEFAULT NULL,
  `house_address` varchar(500) DEFAULT NULL,
  `house_evaluate_price` decimal(19,2) DEFAULT NULL,
  `house_ownership_expected_receive_date` datetime DEFAULT NULL,
  `house_ownership_real_receive_date` datetime DEFAULT NULL,
  `house_square` decimal(19,2) DEFAULT NULL,
  `house_type` int(11) DEFAULT NULL,
  `if_extension` int(11) DEFAULT NULL,
  `loan_date` datetime DEFAULT NULL,
  `marital_status` int(11) DEFAULT NULL,
  `next_aount` decimal(19,2) DEFAULT NULL,
  `next_capital_account_name` varchar(255) DEFAULT NULL,
  `next_capital_account_provider` varchar(255) DEFAULT NULL,
  `next_capital_bank` varchar(255) DEFAULT NULL,
  `next_exception_loan_date` datetime DEFAULT NULL,
  `next_house_other_receive_date` datetime DEFAULT NULL,
  `next_house_ownership_deposit_date` datetime DEFAULT NULL,
  `next_house_ownership_send_date` datetime DEFAULT NULL,
  `next_if_limit_purpose` int(11) DEFAULT NULL,
  `next_if_notarization` int(11) DEFAULT NULL,
  `next_interest_payment_date` datetime DEFAULT NULL,
  `next_loan_way` int(11) DEFAULT NULL,
  `next_name` varchar(255) DEFAULT NULL,
  `next_real_loan_date` datetime DEFAULT NULL,
  `next_verification_date` datetime DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `overdue_days` int(11) DEFAULT NULL,
  `pay_interest_alert_date` datetime DEFAULT NULL,
  `property_owner` varchar(255) DEFAULT NULL,
  `re_contract_date` datetime DEFAULT NULL,
  `reminder_date` datetime DEFAULT NULL,
  `reserved_repayment_date` datetime DEFAULT NULL,
  `spouse_certino` varchar(255) DEFAULT NULL,
  `spouse_name` varchar(255) DEFAULT NULL,
  `tell_up_days` int(11) DEFAULT NULL,
  `title_certificateno` varchar(500) DEFAULT NULL,
  `unzip_doc_expected_receive_date` datetime DEFAULT NULL,
  `unzip_doc_real_receive_date` datetime DEFAULT NULL,
  `unzip_doc_undeposit_date` datetime DEFAULT NULL,
  `up_capital_accountno` varchar(255) DEFAULT NULL,
  `up_capital_account_name` varchar(255) DEFAULT NULL,
  `up_capital_bank` varchar(255) DEFAULT NULL,
  `up_if_house_deposit` int(11) DEFAULT NULL,
  `up_if_overdue` int(11) DEFAULT NULL,
  `up_name` varchar(255) DEFAULT NULL,
  `up_overdue_days` int(11) DEFAULT NULL,
  `up_penalty_interest` decimal(19,2) DEFAULT NULL,
  `up_residue_capital` decimal(19,2) DEFAULT NULL,
  `up_residue_interest` decimal(19,2) DEFAULT NULL,
  `up_unzip_doc` datetime DEFAULT NULL,
  `verification_approval_date` datetime DEFAULT NULL,
  `verification_date` datetime DEFAULT NULL,
  `verification_notarization_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `next_integererest_payment_date` datetime DEFAULT NULL,
  `pay_integererest_alert_date` datetime DEFAULT NULL,
  `up_penalty_integererest` decimal(19,2) DEFAULT NULL,
  `up_residue_integererest` decimal(19,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `belong_type` varchar(255) DEFAULT NULL,
  `certi_address` varchar(255) DEFAULT NULL,
  `certi_end_date` datetime DEFAULT NULL,
  `certi_issue` varchar(255) DEFAULT NULL,
  `certi_start_date` datetime DEFAULT NULL,
  `covered_area` decimal(19,2) DEFAULT NULL,
  `house_certi_no` varchar(255) DEFAULT NULL,
  `house_get_way` varchar(255) DEFAULT NULL,
  `house_ownership` varchar(255) DEFAULT NULL,
  `house_purpose` varchar(255) DEFAULT NULL,
  `house_rigth_type` varchar(255) DEFAULT NULL,
  `house_unit_no` varchar(255) DEFAULT NULL,
  `land_get_way` varchar(255) DEFAULT NULL,
  `land_purpose` varchar(255) DEFAULT NULL,
  `land_right_type` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `service_life` varchar(255) DEFAULT NULL,
  `next_organ_type` int(11) DEFAULT NULL,
  `apply_tel` varchar(255) DEFAULT NULL,
  `house_area` int(11) DEFAULT NULL,
  `mortgage_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_format_info_obj`
-- ----------------------------
BEGIN;
INSERT INTO `t_format_info_obj` VALUES ('1', null, null, '0', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, '1', '1', null, '1', null, null, '1', null, null, null, null, null, '1', '1', null, '1', null, null, null, '83', '0', '2019-09-08 16:00:00', null, null, null, null, null, null, '0', null, null, null, null, null, null, null, '1', '1', null, '0', null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('2', null, null, '0', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, '1', '1', null, '1', null, null, '1', null, null, null, null, null, '1', '1', null, '1', null, null, null, '84', '0', '2019-09-08 16:00:00', null, null, null, null, null, null, '0', null, null, null, null, null, null, null, '1', '1', null, '0', null, null, null, null, null, null, null, '100', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('3', null, null, '0', null, null, null, null, null, '2019-08-18 16:00:00', null, null, null, null, null, '0', null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, '1', '1', null, '1', null, null, '1', null, null, null, null, null, '1', '1', null, '1', null, null, null, '85', '0', '2019-09-08 16:00:00', null, null, null, null, null, null, '0', null, null, null, null, null, null, null, '1', '1', null, '0', null, null, null, null, null, null, null, '100', null, null, null, null, null, '0', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('4', null, null, '0', null, null, null, null, null, '2019-09-17 16:00:00', null, null, null, null, null, '0', null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, '1', '1', null, '1', null, null, '1', null, null, null, null, null, '1', '1', '2019-09-09 16:00:00', '1', null, null, null, '86', '0', '2019-09-08 16:00:00', null, null, null, null, null, null, '0', null, null, null, null, null, null, null, '1', '1', null, '0', null, null, null, null, null, null, null, '100', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('5', null, null, '0', null, null, null, '', '', '2019-09-17 16:00:00', null, null, '', '', '', '0', null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, '1', '1', null, '1', null, '', '1', '', null, null, null, null, '1', '1', '2019-09-09 16:00:00', '1', '', null, null, '86', '0', '2019-09-08 16:00:00', '', null, null, null, '', '', '0', null, null, null, null, '', '', '', '1', '1', '', '0', null, null, null, null, null, null, null, '100', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('6', null, null, '0', null, null, null, '', '', '2019-09-17 16:00:00', null, null, '', '', '', '0', null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, '1', '1', null, '1', null, '', '1', '', null, null, null, null, '1', '1', '2019-09-09 16:00:00', '1', '', null, null, '86', '0', '2019-09-08 16:00:00', '', null, '2019-09-18 16:00:00', null, '', '', '0', null, null, null, null, '', '', '', '1', '1', '', '0', null, null, null, null, null, null, null, '100', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('7', null, null, '0', null, null, null, '', '', '2019-09-17 16:00:00', null, null, '', '', '', '0', null, null, '0', null, null, null, '2019-09-18 16:00:00', null, '0', null, null, null, null, null, '1', '1', null, '1', null, '', '1', '', null, null, null, null, '1', '1', '2019-09-09 16:00:00', '1', '', null, null, '86', '0', '2019-09-08 16:00:00', '', null, '2019-09-18 16:00:00', null, '', '', '0', null, null, null, null, '', '', '', '1', '1', '', '0', null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('8', null, null, '0', null, '2019-10-09 16:00:00', null, '', '', '2019-08-18 16:00:00', null, null, '', '', '', '0', null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, '1', '1', null, '1', null, '', '1', '', null, null, null, null, '1', '1', null, '1', '', null, null, '85', '0', '2019-09-08 16:00:00', '', null, null, null, '', '', '0', null, null, null, null, '', '', '', '1', '1', '', '0', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('9', null, null, null, null, null, null, '', '', null, null, null, '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, '0', null, '', '0', '', null, null, null, null, '0', '0', null, '0', '', null, null, '80', null, null, '', null, null, null, '', '', null, null, null, null, null, '', '', '', '0', '0', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('10', null, null, '0', null, '2019-10-09 16:00:00', null, '', '', null, null, null, '', '', '', '0', null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, '0', '1', null, '1', null, '', '1', '', null, null, null, null, '1', '1', '2019-09-09 16:00:00', '1', '', null, null, '84', '0', '2019-09-08 16:00:00', '', null, null, '2019-12-08 16:00:00', '', '', '0', null, null, null, null, '', '', '', '1', '1', '', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('11', null, null, null, null, '2019-10-09 16:00:00', null, '', '', null, null, null, '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, '0', null, '', '0', '', null, null, null, null, '0', '0', '2019-09-09 16:00:00', '0', '', null, null, '82', null, '2019-09-08 16:00:00', '', null, null, null, '', '', null, null, null, null, null, '', '', '', '0', '0', '', null, null, null, null, null, null, null, null, '1', null, null, null, null, '2019-04-18 06:34:17', '16', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('12', null, null, null, null, null, null, '', '', null, null, null, '', '', '', null, null, null, '222', null, null, null, null, null, null, '222', null, null, null, null, null, '0', null, '0', null, '', '0', '', null, null, null, null, '0', '0', '2019-09-09 16:00:00', '0', '', null, null, '65', null, '2019-09-08 16:00:00', '', null, null, null, '', '', null, null, null, null, null, '', '', '', '0', '0', '', null, null, null, null, null, null, null, null, '1', null, null, null, null, '2019-04-18 08:15:29', '16', null, '0', '222', '', null, '', null, null, '', '', '', '', '', '22', '', '', '222', '', '', '1', null, '2', null), ('13', null, null, null, null, null, null, null, '', null, null, null, '', '', '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, '0', null, null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '87', null, null, '', null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100', null, null, null, null, '2019-04-19 15:44:22', '16', null, '0', '', '', null, '', null, null, '', '', null, '', '', '', '', '', '', '', '', '1', null, '2', null), ('14', null, null, null, null, null, null, null, '222', null, null, null, '', '', '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '87', null, null, '', null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100', null, null, null, null, '2019-04-19 15:46:46', '16', null, '0', '', '', null, '', null, null, '', '', null, '', '', '', '', '', '', '', '', '1', null, '2', null), ('15', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '87', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '2019-04-19 15:47:31', '14', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('16', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '88', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2019-04-22 01:22:25', '0', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('17', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '88', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2019-04-22 01:22:29', '0', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('18', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '89', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100', null, null, null, null, '2019-04-22 07:20:04', '0', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('19', null, null, null, null, '2019-10-09 16:00:00', '2019-09-08 16:00:00', '通过', null, '2019-08-18 16:00:00', '100.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '89', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100', null, null, null, null, '2019-04-22 07:21:59', '14', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('20', null, null, '10', null, null, null, null, '000', null, null, null, '000', '000', '000', null, null, null, null, null, null, null, null, null, null, '000', null, null, null, '0.00', '1', null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '89', null, null, '0000', null, null, null, '000', '000', null, '000', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100', null, null, null, null, '2019-04-22 08:28:11', '15', null, '0', '000', '000', '2025-10-09 16:00:00', '000', '2009-10-09 16:00:00', '0.00', '000', '000', null, '000', '000', '000', '000', '000', '0000', '000', '000', '1', null, '2', null), ('21', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '89', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100', null, null, null, null, '2019-04-22 09:10:42', '8', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('22', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '89', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100', null, null, null, null, '2019-04-22 09:13:06', '10', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('23', '2019-10-09 16:00:00', null, null, null, null, null, null, null, null, null, '2019-10-09 16:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, '22.00', '22', '1', '22', null, null, null, null, '1', '1', null, '1', '22', null, '2019-10-09 16:00:00', '89', null, null, null, null, null, null, null, null, null, null, null, null, null, '222', '22', '222', '1', '1', '222', null, '22.00', '222.00', '22.00', null, '2019-10-09 16:00:00', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '100', null, null, null, null, '2019-04-22 09:14:39', '9', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('24', '2019-10-09 16:00:00', null, null, null, null, null, null, null, null, null, '2019-10-09 16:00:00', null, null, null, '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, '22.00', '22', '1', '22', null, null, null, null, '1', '1', null, '1', '22', null, '2019-10-09 16:00:00', '89', null, null, null, '2019-10-09 16:00:00', null, null, null, null, '3', null, null, null, null, '222', '22', '222', '1', '1', '222', null, '22.00', '222.00', '22.00', null, '2019-10-09 16:00:00', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '100', null, null, null, null, '2019-04-22 09:16:02', '9', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('25', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '89', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100', null, null, null, null, '2019-04-22 09:19:00', '10', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('26', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '89', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100', null, null, null, null, '2019-04-22 09:30:33', '7', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('27', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '89', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100', null, null, null, null, '2019-04-22 09:31:09', '10', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('28', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2019-10-09 16:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '89', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '2019-04-22 09:31:34', '10', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('29', '2019-10-09 16:00:00', null, null, null, null, null, '', null, null, null, '2019-10-09 16:00:00', null, null, null, '22', '2019-10-09 16:00:00', '2019-10-09 16:00:00', null, '22.00', null, '2019-10-09 16:00:00', null, null, '22', null, null, '2019-10-09 16:00:00', null, null, null, '2', null, null, '222.00', '222', '1', '222', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '1', '1', null, '1', '222', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '90', '22', null, null, '2019-10-09 16:00:00', null, '2019-10-09 16:00:00', null, null, '22', null, '2019-10-09 16:00:00', null, '2019-10-09 16:00:00', '222', '222', '222', '1', '1', '222', '22', '222.00', '222.00', '222.00', null, '2019-10-09 16:00:00', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '1', null, null, null, null, '2019-04-22 10:40:08', '0', '2019-04-22 15:04:55', '14', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('30', null, null, null, null, '2019-10-09 16:00:00', '2019-09-08 16:00:00', '通过', null, '2019-08-18 16:00:00', '100.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '100.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '91', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '2019-04-22 15:00:08', '0', '2019-04-22 15:05:20', '14', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2', null), ('31', '2019-10-09 16:00:00', null, null, null, '2019-10-09 16:00:00', '2019-09-08 16:00:00', '通过', '000', '2019-08-18 16:00:00', '100.00', '2019-10-09 16:00:00', '000', '000', '000', '22', '2019-10-09 16:00:00', '2019-10-09 16:00:00', null, null, null, '2019-10-09 16:00:00', null, null, null, '222', '100.00', '2019-10-09 16:00:00', null, '222.00', '1', '2', null, '1', '22.00', '22', '1', '22', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '2', '1', null, '1', '22', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '92', null, null, '0000', null, null, '2019-12-08 16:00:00', '', '', '22', '000', '2019-10-09 16:00:00', null, '2019-10-09 16:00:00', '222', '22', '222', '1', '2', '222', null, '22.00', '222.00', '22.00', null, '2019-10-09 16:00:00', '2019-10-09 16:00:00', '2019-10-09 16:00:00', '1', null, null, null, null, '2019-04-24 00:28:12', '0', '2019-04-24 02:05:43', '14', '111', '000', '2025-10-09 16:00:00', '000', '2009-10-09 16:00:00', '111.00', '000', '000', null, '000', '000', '111', '000', '000', '222', '111', '111', '1', '', '3', '2'), ('32', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '93', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '2019-04-24 02:00:08', '0', null, '0', null, '房屋(构筑物)所有权', '2015-09-06 16:00:00', null, '2005-09-06 16:00:00', null, null, '出让', null, '成套住宅', null, null, '出让', '城镇住宅用地', null, '国有建设用地使用权', null, null, null, null, null), ('33', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '西工区纱厂北路101号升龙广场C区7号楼1单元602', null, null, null, '128.24', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '94', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '2019-04-24 03:00:32', '0', null, '0', '单独所有', '华盛顿特区宾夕法尼亚大道1600号', '2015-09-06 16:00:00', '新丰县公安局', '2005-09-06 16:00:00', null, null, '出让', null, '成套住宅', '房屋(构筑物)所有权', '410121003018Gb00337F00011602', '出让', '城镇住宅用地', '国有建设用地使用权', '汉', '国有建设用地使用权利2089年04月21日止', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `t_hr_action`
-- ----------------------------
DROP TABLE IF EXISTS `t_hr_action`;
CREATE TABLE `t_hr_action` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `busi_type` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_hr_action`
-- ----------------------------
BEGIN;
INSERT INTO `t_hr_action` VALUES ('1', '2019-03-08 09:01:35', '0', '录入订单', '100', '2019-03-20 04:51:06', '0', '1'), ('2', '2019-03-08 09:02:09', '0', '上传资料', '100', '2019-03-20 04:51:04', '0', '1'), ('3', '2019-03-08 09:02:58', '0', '录入客户', '100', '2019-03-20 04:51:06', '0', '1'), ('4', '2019-03-08 09:03:27', '0', '匹配产品', '100', '2019-03-20 04:51:07', '0', '1'), ('5', '2019-03-08 09:03:46', '0', '下户完成', '100', '2019-03-20 04:51:07', '0', '1'), ('6', '2019-03-08 09:04:03', '0', '材料复核完成', '100', '2019-03-20 04:51:08', '0', '1'), ('7', '2019-03-08 09:04:11', '0', '产品复核完成', '100', '2019-03-20 04:51:08', '0', '1'), ('8', '2019-03-08 09:04:20', '0', '申请材料提交给银行', '100', '2019-03-20 04:51:09', '0', '1'), ('9', '2019-03-08 09:07:47', '0', '财务收费', '100', '2019-03-20 04:51:10', '0', '1'), ('10', '2019-03-08 09:08:42', '0', '材料已归档', '100', '2019-03-20 04:51:11', '0', '1'), ('11', '2019-03-08 09:08:58', '0', '订单完结', '100', '2019-03-20 04:51:12', '0', '1'), ('16', '2019-03-20 04:53:39', '0', '预收', '1', null, '0', '1'), ('17', '2019-03-20 04:54:33', '0', '初审', '1', null, '0', '1'), ('18', '2019-03-20 04:55:08', '0', '初审', '1', null, '0', '1'), ('19', '2019-03-20 04:55:45', '0', '补充材料', '1', null, '0', '1'), ('20', '2019-03-20 04:56:07', '0', '复审', '1', null, '0', '1'), ('21', '2019-03-20 04:58:08', '0', '下户完成', '1', null, '0', '1'), ('22', '2019-03-20 04:59:11', '0', '签约', '1', null, '0', '1'), ('23', '2019-03-20 05:00:30', '0', '提交给机构', '1', null, '0', '1'), ('24', '2019-03-20 05:00:58', '0', '归档', '1', null, '0', '1'), ('25', '2019-03-20 05:01:24', '0', '放款', '1', null, '0', '1'), ('26', '2019-03-20 05:01:56', '0', '确认扣款成功', '1', null, '0', '1'), ('27', '2019-03-20 05:02:47', '0', '解抵押', '1', null, '0', '1'), ('28', '2019-03-20 05:03:22', '0', '给下家材料', '1', null, '0', '1'), ('29', '2019-03-20 05:04:12', '0', '和下家抵押', '1', null, '0', '1'), ('30', '2019-03-20 05:04:43', '0', '回款完成', '1', null, '0', '1'), ('31', '2019-03-20 05:05:23', '0', '交接完成', '1', null, '0', '1'), ('32', '2019-03-20 05:05:55', '0', '开完结清证明', '1', null, '0', '1'), ('33', '2019-03-21 19:37:32', '0', '添加订单', '1', null, '0', '1'), ('34', '2019-03-21 19:37:32', '0', '完善信息', '1', null, '0', '1'), ('35', '2019-03-21 19:37:32', '0', '添加订单', '1', null, '0', '1'), ('36', '2019-03-21 19:37:32', '0', '初审', '1', null, '0', '1'), ('37', '2019-03-21 19:37:32', '0', '联系客户', '1', null, '0', '1'), ('38', '2019-03-21 19:37:32', '0', '复审', '1', null, '0', '1'), ('39', '2019-03-21 19:37:32', '0', '收下户费', '1', null, '0', '1'), ('40', '2019-03-21 19:37:32', '0', '下户', '1', null, '0', '1'), ('41', '2019-03-21 19:37:32', '0', '汇审', '1', null, '0', '1'), ('42', '2019-03-21 19:37:32', '0', '签约', '1', null, '0', '1'), ('43', '2019-03-21 19:37:32', '0', '收服务费', '1', null, '0', '1'), ('44', '2019-03-21 19:37:32', '0', '上报机构', '1', null, '0', '1'), ('45', '2019-03-21 19:37:32', '0', '总经理审批', '1', null, '0', '1'), ('46', '2019-03-21 19:37:32', '0', '退服务费', '1', null, '0', '1'), ('47', '2019-03-21 19:37:32', '0', '放款', '1', null, '0', '1'), ('48', '2019-03-21 19:37:32', '0', '检查扣款', '1', null, '0', '1'), ('49', '2019-03-21 19:37:32', '0', '领解押材料', '1', null, '0', '1'), ('50', '2019-03-21 19:37:32', '0', '给下家材料', '1', null, '0', '1'), ('51', '2019-03-21 19:37:32', '0', '回款', '1', null, '0', '1'), ('52', '2019-03-21 19:37:32', '0', '交接材料', '1', null, '0', '1'), ('53', '2019-03-21 19:37:32', '0', '开结清证明', '1', null, '0', '1'), ('55', '2019-03-21 19:40:33', '0', '全部', '1', null, '0', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_hr_attendance`
-- ----------------------------
DROP TABLE IF EXISTS `t_hr_attendance`;
CREATE TABLE `t_hr_attendance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ask_begin_time` datetime DEFAULT NULL,
  `ask_end_time` datetime DEFAULT NULL,
  `ask_type` int(11) DEFAULT NULL,
  `check_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `work_day` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_hr_curriculum`
-- ----------------------------
DROP TABLE IF EXISTS `t_hr_curriculum`;
CREATE TABLE `t_hr_curriculum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pos_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_hr_dept`
-- ----------------------------
DROP TABLE IF EXISTS `t_hr_dept`;
CREATE TABLE `t_hr_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_hr_dept`
-- ----------------------------
BEGIN;
INSERT INTO `t_hr_dept` VALUES ('0', '2019-03-14 19:25:41', '0', '全部', '1', '2019-03-20 04:48:16', '0'), ('1', '2019-03-08 00:49:01', '0', '销售部', '100', '2019-03-20 04:26:39', '0'), ('2', '2019-03-08 00:49:07', '0', '风控部', '1', '2019-03-20 04:48:20', '0'), ('3', '2019-03-08 09:07:20', '0', '财务部', '100', '2019-03-20 04:27:02', '0'), ('5', '2019-03-20 04:26:59', '0', '市场部', '1', '2019-03-20 04:48:28', '0'), ('6', '2019-03-20 04:48:40', '0', '人力行政财务部', '1', null, '0'), ('7', '2019-03-22 10:00:40', '0', 'IT', '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_hr_emp_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_hr_emp_log`;
CREATE TABLE `t_hr_emp_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `after_dept_id` bigint(20) DEFAULT NULL,
  `after_employment_time` float DEFAULT NULL,
  `after_manage_grade` int(11) DEFAULT NULL,
  `after_post_id` bigint(20) DEFAULT NULL,
  `after_salary` decimal(19,2) DEFAULT NULL,
  `after_tech_grade` int(11) DEFAULT NULL,
  `befor_employment_time` float DEFAULT NULL,
  `before_dept_id` bigint(20) DEFAULT NULL,
  `before_manage_grade` int(11) DEFAULT NULL,
  `before_post_id` bigint(20) DEFAULT NULL,
  `before_salary` decimal(19,2) DEFAULT NULL,
  `before_tech_grade` int(11) DEFAULT NULL,
  `change_cause` int(11) DEFAULT NULL,
  `change_valid_date` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_hr_employee`
-- ----------------------------
DROP TABLE IF EXISTS `t_hr_employee`;
CREATE TABLE `t_hr_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `card_no` varchar(255) DEFAULT NULL,
  `certi_code` varchar(255) DEFAULT NULL,
  `city` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `dept` int(11) DEFAULT NULL,
  `emg_name` varchar(255) DEFAULT NULL,
  `emg_phone` varchar(255) DEFAULT NULL,
  `hiredate` datetime DEFAULT NULL,
  `leavedate` datetime DEFAULT NULL,
  `manage_grade` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  `salary` decimal(19,2) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `tech_grade` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_hr_employee`
-- ----------------------------
BEGIN;
INSERT INTO `t_hr_employee` VALUES ('0', null, null, null, null, '0', null, '0', '0', null, null, null, null, '0', '全部', null, '0', null, '1', '0', null, '0', '0', null), ('1', '22', '2019-02-19 10:00:00', '22', '222', '0', '2019-02-26 05:55:59', '0', '2', '22', '22', '2019-02-19 10:00:00', '2019-02-19 10:00:00', '2', '王润海', '22', '2', '4000.00', '100', '2', '2019-03-22 09:59:32', '0', '1', null), ('5', '33', '2019-02-19 10:00:00', '33', '333', '1', '2019-03-08 10:51:59', '0', '2', '33', '33', '2019-02-19 10:00:00', '2019-02-19 10:00:00', '1', '王二', '22', '2', '33.00', '100', '1', '2019-03-22 09:59:30', '0', '4', null), ('6', '22', '1983-09-17 11:00:00', '22', '222', '1', '2019-03-20 21:59:36', '0', '2', '22', '22', '2013-03-18 11:00:00', null, '2', '小松', '22', '7', '4000.00', '100', '3', '2019-03-22 09:59:28', '0', '0', null), ('7', '22', '1983-09-17 11:00:00', '22', '410726197906105416', '1', '2019-03-22 10:05:10', '0', '7', '22', '22', '2013-03-18 11:00:00', null, '4', '王润海', '18611300304', '16', '4000.00', '1', '3', null, '0', '0', null), ('8', '22', '1983-09-17 11:00:00', '22', '111', '1', '2019-03-22 10:06:19', '0', '2', '22', '22', '2013-03-18 11:00:00', null, '4', '王海明', '22', '14', '4000.00', '1', '3', '2019-03-22 10:24:54', '0', '7', null), ('9', '22', '1983-09-17 11:00:00', '22', '410726197906105416', '1', '2019-03-22 10:07:51', '0', '2', '22', '22', '2013-03-18 11:00:00', null, '3', '刘小松', '22', '7', '4000.00', '1', '3', '2019-03-22 10:25:20', '0', '9', null), ('10', '22', '1983-09-17 11:00:00', '22', '22', '1', '2019-03-22 10:08:59', '0', '2', '22', '22', '2013-03-18 11:00:00', null, '4', '刘雅胜', '22', '6', '4000.00', '1', '3', '2019-03-22 10:25:11', '0', '8', null), ('11', '', '1983-09-17 11:00:00', '', '222', '1', '2019-03-22 10:33:41', '0', '5', '', '', '2013-03-18 11:00:00', null, '2', '张销售', '', '11', '4000.00', '1', '2', '2019-03-22 10:45:43', '0', '13', null), ('12', '', '1983-09-17 11:00:00', '', '222', '1', '2019-03-22 10:11:03', '0', '6', '', '', '2013-03-18 11:00:00', null, '3', '李新', '', '12', '4000.00', '1', '3', '2019-03-22 10:25:38', '0', '10', null), ('13', '', '1983-09-17 11:00:00', '', '222', '1', '2019-03-22 10:12:06', '0', '5', '', '', '2013-03-18 11:00:00', null, '2', '和许', '', '8', '4000.00', '1', '2', '2019-03-22 10:46:42', '0', '14', null), ('14', '22', '1983-09-17 11:00:00', '22', '222', '1', '2019-03-28 01:04:02', '0', '5', '22', '22', '2013-03-18 11:00:00', null, '2', '王销售', '22', '11', '4000.00', '1', '1', '2019-03-28 06:49:05', '0', '15', null), ('15', '22', '1983-09-17 11:00:00', '22', '222', '1', '2019-03-28 07:07:56', '0', '5', '22', '22', '2013-03-18 11:00:00', null, '2', '张小溪', '22', '11', '4000.00', '1', '1', '2019-03-28 07:08:28', '0', '16', 'zhangxx');
COMMIT;

-- ----------------------------
--  Table structure for `t_hr_employee_position`
-- ----------------------------
DROP TABLE IF EXISTS `t_hr_employee_position`;
CREATE TABLE `t_hr_employee_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `pos_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_hr_position`
-- ----------------------------
DROP TABLE IF EXISTS `t_hr_position`;
CREATE TABLE `t_hr_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `is_commission` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `salary_max` decimal(19,2) DEFAULT NULL,
  `salary_min` decimal(19,2) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_hr_position`
-- ----------------------------
BEGIN;
INSERT INTO `t_hr_position` VALUES ('0', '2019-03-14 07:05:54', '0', '0', '0', '0', '全部', null, null, '1', null, '0'), ('1', '2019-03-08 01:04:09', '0', '2', '1', '3', '风控管理岗', null, null, '100', '2019-03-20 04:48:58', '0'), ('2', '2019-03-08 01:04:19', '0', '1', '1', '2', '销售岗', null, null, '100', '2019-03-20 04:48:59', '0'), ('3', '2019-03-08 09:07:25', '0', '1', '0', '1', '财务出纳', null, null, '100', '2019-03-20 04:48:59', '0'), ('4', '2019-03-13 20:51:16', '0', '3', '2', '1', '会计岗', null, null, '100', '2019-03-20 04:49:00', '0'), ('6', '2019-03-20 06:14:08', '0', '2', '1', '1', '风控总监岗', null, null, '1', null, '0'), ('7', '2019-03-20 04:49:43', '0', '2', '1', '1', '风控专员岗', null, null, '1', null, '0'), ('8', '2019-03-20 04:49:54', '0', '2', '1', '1', '运营岗', null, null, '1', null, '0'), ('9', '2019-03-20 04:50:12', '0', '5', '1', '1', '市场总监', null, null, '1', null, '0'), ('10', '2019-03-20 04:50:28', '0', '5', '1', '1', '团队经理', null, null, '1', null, '0'), ('11', '2019-03-20 04:50:39', '0', '5', '1', '1', '业务员', null, null, '1', null, '0'), ('12', '2019-03-20 04:50:54', '0', '6', '2', '1', '财务出纳', null, null, '1', null, '0'), ('13', '2019-03-20 06:11:23', '0', '2', '1', '1', '风控总监岗', null, null, '100', '2019-03-20 06:11:37', '0'), ('14', '2019-03-21 06:41:55', '0', '5', '2', '1', '总经理', null, null, '1', null, '0'), ('15', '2019-03-21 10:11:30', '0', '2', '1', '1', '汇审岗', null, null, '1', null, '0'), ('16', '2019-03-22 10:04:20', '0', '7', '2', '1', 'IT管理员岗', null, null, '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_hr_salary`
-- ----------------------------
DROP TABLE IF EXISTS `t_hr_salary`;
CREATE TABLE `t_hr_salary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `basic_salary` decimal(19,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `current_salary` decimal(19,2) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `extend_date` datetime DEFAULT NULL,
  `extend_state` int(11) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_mis_period`
-- ----------------------------
DROP TABLE IF EXISTS `t_mis_period`;
CREATE TABLE `t_mis_period` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_mis_period`
-- ----------------------------
BEGIN;
INSERT INTO `t_mis_period` VALUES ('1', '2019-03-30 08:56:07', '0', null, '当前周', null, '1', null, '0'), ('2', '2019-03-30 08:56:21', '0', null, '当前月', null, '1', null, '0'), ('3', '2019-03-30 08:56:29', '0', null, '上一周', null, '1', null, '0'), ('4', '2019-03-30 08:57:19', '0', null, '上一月', null, '1', null, '0'), ('5', null, '0', null, '最近三个月', null, '1', null, '0'), ('6', null, '0', null, '最近半年', null, '1', null, '0'), ('7', null, '0', null, '最近一年', null, '1', null, '0'), ('8', null, '0', null, '上一年', null, '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_mis_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_mis_task`;
CREATE TABLE `t_mis_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) DEFAULT NULL,
  `begin_date` datetime DEFAULT NULL,
  `complete_amount` decimal(19,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `end_date` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `task_desc` varchar(255) DEFAULT NULL,
  `task_name` varchar(255) DEFAULT NULL,
  `task_state` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `task_period` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_order_paras`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_paras`;
CREATE TABLE `t_order_paras` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `para_id` bigint(20) DEFAULT NULL,
  `para_value` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_prod_bank`
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_bank`;
CREATE TABLE `t_prod_bank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_sales_agent`
-- ----------------------------
DROP TABLE IF EXISTS `t_sales_agent`;
CREATE TABLE `t_sales_agent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank_code` varchar(255) DEFAULT NULL,
  `business_type` int(11) DEFAULT NULL,
  `centi_code` varchar(255) DEFAULT NULL,
  `channel_type` int(11) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `cooperate_begin_date` datetime DEFAULT NULL,
  `cooperate_end_date` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `job_years` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phoneno` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `dd_user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_sales_agent`
-- ----------------------------
BEGIN;
INSERT INTO `t_sales_agent` VALUES ('0', null, '0', null, '2', '0', null, null, null, '0', '0', '全部', null, '1', null, '0', null, '0', '0', '0', '2', null), ('1', null, '0', null, '0', null, null, null, '2018-12-24 19:28:54', '0', '0', null, null, '100', '2018-12-24 20:13:14', '0', null, '0', '1', '1', '2', null), ('2', null, '0', null, '0', null, null, null, '2018-12-24 19:48:13', '0', '0', null, null, '100', '2018-12-24 20:13:16', '0', null, '0', '2', '2', '2', null), ('3', '222', '0', '22', '0', '22', '2018-12-18 10:00:00', '2019-12-18 10:00:00', '2018-12-24 20:00:36', '0', '22', '王润海', '22', '100', null, '0', '22', '0', '2', '2', '2', null), ('4', '33', '2', '421', '2', '33', '2018-12-18 10:00:00', '2019-12-18 10:00:00', '2018-12-24 20:01:19', '0', '3', '王润海02', '33', '1', '2019-03-14 02:55:41', '0', '33', '1', '3', '2', '2', null), ('5', '33', '2', '421', '2', '33', '2018-12-22 10:00:00', '2018-12-22 10:00:00', '2018-12-24 20:17:17', '0', '3', '王润海02', '18611300304', '1', '2019-03-08 10:53:04', '0', '33', '5', '4', '2', '2', null), ('8', '22', '0', '222', '1', '贯泽信', '2013-03-18 11:00:00', null, '2019-03-28 01:04:02', '0', '0', '王销售', '22', '1', null, '0', null, '15', '5', '2', '2', 'manager8154'), ('9', '22', '0', '222', '1', '贯泽信', '2013-03-18 11:00:00', null, '2019-03-28 07:07:56', '0', '0', '张小溪', '22', '1', '2019-03-28 07:08:28', '0', 'zhangxx', '16', '15', '0', '2', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_sales_commission`
-- ----------------------------
DROP TABLE IF EXISTS `t_sales_commission`;
CREATE TABLE `t_sales_commission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `base_type` int(11) DEFAULT NULL,
  `business_type` int(11) DEFAULT NULL,
  `channel_type` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `percent` decimal(19,2) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_type` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `sum` decimal(19,2) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `way` int(11) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `pay_way` int(3) DEFAULT NULL COMMENT '1、按月发放；2、逐笔发放',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_sales_commission`
-- ----------------------------
BEGIN;
INSERT INTO `t_sales_commission` VALUES ('1', '1', '3', '1', '2019-03-07 09:02:02', '0', '1', '0.10', '1', '3', '100', null, '1', '2019-03-07 09:44:25', '0', '1', '2019-06-27 11:28:09', '2018-07-05 11:00:00', '1'), ('2', '1', '1', '1', '2019-03-07 09:43:42', '0', '2', '0.25', '8', null, '100', null, '1', '2019-03-20 09:10:58', '0', '1', '2019-06-27 11:28:09', '2018-07-05 11:00:00', '1'), ('3', '1', '3', '2', '2019-03-07 09:44:08', '0', '1', '0.10', '32', null, '100', null, '1', '2019-03-20 09:10:59', '0', '1', '2019-06-27 11:28:09', '2018-07-05 11:00:00', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_sales_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_sales_group`;
CREATE TABLE `t_sales_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_sales_group`
-- ----------------------------
BEGIN;
INSERT INTO `t_sales_group` VALUES ('1', '2019-03-31 00:00:22', '0', '1', '销售部', '0', '1', null, '0', '11'), ('2', '2019-03-30 11:22:57', '0', '2', '第一组', '1', '1', null, '0', '11'), ('3', '2019-03-30 23:59:57', '0', '0', '全部', '0', '1', null, '0', '11');
COMMIT;

-- ----------------------------
--  Table structure for `t_sales_performance_comm_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_sales_performance_comm_detail`;
CREATE TABLE `t_sales_performance_comm_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commission` decimal(19,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `performance` decimal(19,2) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `order_product_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) NOT NULL,
  `interest` decimal(19,2) NOT NULL,
  `max_commission` decimal(19,2) DEFAULT NULL,
  `min_commission` decimal(19,2) DEFAULT NULL,
  `saler_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_sales_performance_comm_detail`
-- ----------------------------
BEGIN;
INSERT INTO `t_sales_performance_comm_detail` VALUES ('1', '0.00', '2019-03-19 14:40:18', '0', '22.00', '1', null, '0', '17', '0', '0.00', null, null, null), ('27', '5.50', '2019-03-19 15:15:35', '0', '22.00', '1', null, '0', '17', '0', '0.00', null, null, null), ('29', '5.50', '2019-03-19 15:18:08', '0', '22.00', '1', null, '0', '17', '0', '0.00', null, null, null), ('31', '5.50', '2019-03-19 15:24:51', '0', '22.00', '1', null, '0', '17', '0', '0.00', null, null, null), ('32', '5.50', '2019-03-19 15:26:05', '0', '22.00', '1', null, '0', '17', '0', '0.00', null, null, null), ('33', '0.24', '2019-03-28 09:45:22', '0', '300.00', '1', null, '0', '0', '60', '5.00', '0.38', '0.24', '9'), ('35', '0.41', '2019-03-28 20:46:32', '0', '900.00', '1', null, '0', '0', '61', '8.00', '0.65', '0.41', '9'), ('38', '12150.00', '2019-03-28 22:56:36', '0', '9000000.00', '1', null, '0', '0', '62', '243000.00', '19440.00', '12150.00', '9'), ('39', '4155.84', '2019-04-02 02:14:24', '0', '2220000.00', '1', null, '0', '0', '63', '51948.00', '4155.84', '2597.40', '9'), ('41', '6233.76', '2019-04-02 08:05:20', '0', '3330000.00', '1', null, '0', '0', '64', '77922.00', '6233.76', '3896.10', '9'), ('44', '0.00', '2019-04-22 15:04:55', '0', '2350000.00', '1', null, '0', '0', '90', '0.00', '0.00', '0.00', '8'), ('45', '4688.00', '2019-04-24 02:05:44', '0', '5860000.00', '1', null, '0', '0', '92', '93760.00', '7500.80', '4688.00', '8');
COMMIT;

-- ----------------------------
--  Table structure for `t_sales_performance_commission`
-- ----------------------------
DROP TABLE IF EXISTS `t_sales_performance_commission`;
CREATE TABLE `t_sales_performance_commission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commission` decimal(19,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `performance` decimal(19,2) DEFAULT NULL,
  `process` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `interest` decimal(19,2) NOT NULL,
  `max_commission` decimal(19,2) DEFAULT NULL,
  `min_commission` decimal(19,2) DEFAULT NULL,
  `saler_id` bigint(20) DEFAULT NULL,
  `saler_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_sales_performance_commission`
-- ----------------------------
BEGIN;
INSERT INTO `t_sales_performance_commission` VALUES ('1', '20.00', null, '0', '201901', '30.00', '0', '1', null, '0', '0.00', null, null, '17', null), ('4', '27.50', '2019-03-19 15:15:35', '0', '201903', '110.00', '0', '1', '2019-03-19 15:26:05', '0', '0.00', null, null, '16', null), ('5', '11.00', '2019-03-19 15:18:08', '0', '201903', '44.00', '0', '100', null, '0', '0.00', null, null, '15', null), ('6', '12150.65', '2019-03-28 20:46:32', '0', '201903', '9001200.00', '0', '1', '2019-03-28 22:56:36', '0', '243013.00', '19441.03', '12150.65', '9', 'zhangxs'), ('7', '10389.60', '2019-04-02 02:14:24', '0', '201904', '5550000.00', '0', '1', '2019-04-02 08:05:20', '0', '129870.00', '10389.60', '6493.50', '9', '张小溪'), ('8', '0.00', '2019-04-22 15:04:55', '0', '201906', '0.00', '0', '1', '2019-04-24 02:05:44', '0', '0.00', '0.00', '0.00', '8', '王销售');
COMMIT;

-- ----------------------------
--  Table structure for `t_sales_tel_sales`
-- ----------------------------
DROP TABLE IF EXISTS `t_sales_tel_sales`;
CREATE TABLE `t_sales_tel_sales` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `hist_desc` varchar(255) DEFAULT NULL,
  `mark_desc` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `result` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `task_date` datetime DEFAULT NULL,
  `task_delay` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_ums_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_ums_resource`;
CREATE TABLE `t_ums_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `res_url` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `column_name` varchar(255) DEFAULT NULL,
  `value_set` varchar(255) DEFAULT NULL,
  `grade` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_ums_resource`
-- ----------------------------
BEGIN;
INSERT INTO `t_ums_resource` VALUES ('0', '2019-03-11 11:55:58', '0', '根资源', '0', '/', '1', '1', null, '0', null, null, '1'), ('1', '2018-12-12 17:25:45', '0', '核心业务系统', '0', '', '1', '1', null, '0', null, null, '1'), ('2', '2019-03-27 10:38:24', '0', '订单处理', '1', '/order/list', '1', '1', null, '0', '', '', '2'), ('3', '2018-12-12 17:27:12', '0', '人力系统', '0', '', '1', '1', null, '0', null, null, '1'), ('4', '2018-12-12 17:27:49', '0', '雇员管理', '3', '/hr/employee', '1', '1', null, '0', null, null, '2'), ('5', '2018-12-12 17:28:24', '0', '销售系统', '0', '', '1', '1', null, '0', null, null, '1'), ('6', '2019-03-28 01:07:29', '0', '销售人员管理', '5', '/sales/agent', '1', '1', null, '0', '', '', '2'), ('7', '2018-12-12 17:29:44', '0', '财务系统', '0', '', '1', '1', null, '0', null, null, '1'), ('8', '2018-12-12 17:30:21', '0', '收付费管理', '7', '/finance/payment', '1', '1', null, '0', null, null, '2'), ('22', '2019-03-11 15:51:19', '0', '订单数据', '2', null, '1', '3', null, '0', 'orderState', '(1,2)', '3'), ('23', '2019-03-11 15:52:13', '0', '订单数据1-2', '2', null, '1', '3', null, '0', 'orderState', '(1,2)', '3'), ('24', '2019-03-11 15:52:24', '0', '订单数据3', '2', null, '1', '3', null, '0', 'orderState', '(3)', '3'), ('25', '2019-03-11 15:52:30', '0', '订单数据4', '2', null, '1', '3', null, '0', 'orderState', '(4)', '3'), ('26', '2019-03-11 15:52:34', '0', '订单数据5', '2', null, '1', '3', null, '0', 'orderState', '(5)', '3'), ('27', '2019-03-12 15:22:17', '0', '产品管理', '1', '/cbs/product', '1', '1', null, '0', null, null, '2'), ('28', '2019-03-12 15:23:30', '0', '产品利息', '1', '/cbs/prodInterest', '1', '1', null, '0', null, null, '2'), ('29', '2019-03-12 15:28:33', '0', '部门管理', '3', '/hr/dept', '1', '1', null, '0', null, null, '2'), ('30', '2019-03-12 15:28:33', '0', '岗位管理', '3', '/hr/position', '1', '1', null, '0', null, null, '2'), ('31', '2019-03-12 15:28:33', '0', '工作管理', '3', '/hr/action', '1', '1', null, '0', null, null, '2'), ('32', '2019-03-12 15:28:33', '0', '考勤管理', '3', '/hr/attendance', '1', '1', null, '0', null, null, '2'), ('33', '2019-03-12 15:28:33', '0', '薪酬管理', '3', '/hr/salary', '1', '1', null, '0', null, null, '2'), ('34', '2019-03-12 15:28:33', '0', '培训管理', '3', '/hr/curriculum', '1', '1', null, '0', null, null, '2'), ('35', '2019-03-12 15:31:15', '0', '提成比例管理', '5', '/sales/commission', '1', '1', null, '0', null, null, '2'), ('36', '2019-03-12 15:31:15', '0', '提成管理', '5', '/sales/performanceCommission', '1', '1', null, '0', null, null, '2'), ('37', '2019-03-12 15:33:29', '0', '账户管理', '7', '/finance/account', '1', '1', null, '0', null, null, '2'), ('38', '2019-03-12 15:34:03', '0', '记账规则管理', '7', '/finance/accountingRule', '1', '1', null, '0', null, null, '2'), ('39', '2019-03-12 15:35:01', '0', 'IT管理', '0', '', '1', '1', null, '0', null, null, '1'), ('40', '2019-03-12 15:37:22', '0', '角色管理', '39', '/ums/role', '1', '1', null, '0', null, null, '2'), ('41', '2019-03-12 15:37:22', '0', '用户角色管理', '39', '/ums/userRole', '1', '1', null, '0', null, null, '2'), ('42', '2019-03-12 15:37:22', '0', '资源管理', '39', '/ums/resource', '1', '1', null, '0', null, null, '2'), ('43', '2019-03-12 15:37:22', '0', '角色资源管理', '39', '/ums/roleResource', '1', '1', null, '0', null, null, '2'), ('44', '2019-03-12 15:37:23', '0', '工作流配置', '39', '/util/workFlow', '1', '1', null, '0', null, null, '2'), ('45', '2019-03-12 15:41:44', '0', '订单数据5', '2', null, '1', '3', null, '0', 'orderState', '(5)', '3'), ('66', '2019-03-13 09:59:53', '0', '用户管理', '39', '/ums/user', '1', '1', null, '0', '', '', '2'), ('67', '2019-03-18 03:55:16', '0', '雇员岗位管理', '3', '/hr/employeePosition', '1', '1', null, '0', '', '', '2'), ('68', '2019-03-19 02:43:57', '0', '决策系统', '0', '', '1', '1', null, '0', '', '', '1'), ('69', '2019-03-19 02:45:50', '0', '业务报表', '68', '/mis/showBusiReport', '1', '1', null, '0', '', '', '2'), ('70', '2019-03-19 03:46:09', '0', '财务大盘', '68', '/mis/showFinReport', '1', '1', null, '0', '', '', '2'), ('71', '2019-03-21 19:54:27', '0', '暂存订单', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('72', '2019-03-21 19:54:27', '0', '提交订单', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('73', '2019-03-21 19:54:27', '0', '初审不通过', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('74', '2019-03-21 19:54:27', '0', '初审通过', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('75', '2019-03-21 19:54:27', '0', '初审上报', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('76', '2019-03-21 19:54:27', '0', '上传资料', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('77', '2019-03-21 19:54:27', '0', '查看资料', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('78', '2019-03-21 19:54:27', '0', '添加客户', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('79', '2019-03-21 19:54:27', '0', '添加产品', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('80', '2019-03-21 19:54:27', '0', '复审通过', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('81', '2019-03-21 19:54:27', '0', '复审不通过', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('82', '2019-03-21 19:54:27', '0', '订单关闭', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('83', '2019-03-21 19:54:27', '0', '暂存订单', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('84', '2019-03-21 19:54:27', '0', '收下户费成功', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('85', '2019-03-21 19:54:27', '0', '下户通过', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('86', '2019-03-21 19:54:27', '0', '下户不通过', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('87', '2019-03-21 19:54:27', '0', '汇审通过', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('88', '2019-03-21 19:54:27', '0', '汇审不通过', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('89', '2019-03-21 19:54:28', '0', '签约完成', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('90', '2019-03-21 19:54:28', '0', '收服务费成功', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('91', '2019-03-21 19:54:28', '0', '已上报机构', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('92', '2019-03-21 19:54:28', '0', '同意放款', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('93', '2019-03-21 19:54:28', '0', '不同意放款', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('94', '2019-03-21 19:54:28', '0', '放款成功', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('95', '2019-03-21 19:54:28', '0', '扣款完成', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('96', '2019-03-21 19:54:28', '0', '解押材料已领取', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('97', '2019-03-21 19:54:28', '0', '下家已抵押', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('98', '2019-03-21 19:54:28', '0', '回款完成', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('99', '2019-03-21 19:54:28', '0', '已交接材料', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('100', '2019-03-21 19:54:28', '0', '已完结', '2', '/order/edit', '1', '2', null, '0', null, null, '3'), ('101', '2019-03-25 14:46:41', '0', '上传资料', '1', null, '1', '2', null, '0', null, null, '3'), ('102', '2019-03-25 14:46:41', '0', '录入客户', '1', null, '1', '2', null, '0', null, null, '3'), ('103', '2019-03-25 14:46:41', '0', '添加产品', '1', null, '1', '2', null, '0', null, null, '3'), ('104', '2019-03-25 20:40:37', '0', '公式管理', '39', '/util/calcFormula', '1', '1', null, '0', '', '', '2'), ('105', '2019-03-25 20:41:03', '0', '参数管理', '39', '/util/calcParam', '1', '1', null, '0', '', '', '2'), ('106', '2019-03-27 10:06:44', '0', '订单查询', '1', '/order/readList', '1', '1', null, '0', '', '', '2'), ('107', '2019-03-29 02:56:21', '0', '记账明细', '7', '/finance/accountingEntry', '1', '1', null, '0', '', '', '2'), ('108', '2019-03-29 02:56:53', '0', '科目余额', '7', '/finance/balance', '1', '1', null, '0', '', '', '2'), ('109', '2019-03-29 02:57:43', '0', '账期管理', '7', '/finance/accountingPeriod', '1', '1', null, '0', '', '', '2'), ('110', '2019-03-30 08:54:32', '0', '统计周期管理', '68', '/mis/period', '100', '1', '2019-03-30 08:58:04', '0', '', '', '2'), ('111', '2019-03-30 11:15:54', '0', '销售组织管理', '5', '/sales/group', '1', '1', null, '0', '', '', '2'), ('112', '2019-04-01 07:15:57', '0', '现金流报表', '68', '/mis/cashFlowReport', '1', '1', null, '0', '', '', '2'), ('115', '2019-04-12 07:52:16', '0', '格式化信息', '39', '/util/formatInfo', '1', '1', null, '0', '', '', '2'), ('116', '2019-04-15 06:36:42', '0', '要件管理', '1', '/cbs/certificate', '1', '1', null, '0', '', '', '2');
COMMIT;

-- ----------------------------
--  Table structure for `t_ums_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_ums_role`;
CREATE TABLE `t_ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_ums_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_ums_role` VALUES ('0', '2019-03-14 19:30:40', '0', '全部', '1', null, '0'), ('1', '2019-03-20 06:09:42', '0', '超级管理员', '1', null, '0'), ('2', '2019-03-20 09:44:48', '0', '业务处理员', '1', null, '0'), ('4', '2019-03-20 06:09:19', '0', '财务出纳', '1', null, '0'), ('5', '2019-03-20 06:09:11', '0', 'IT管理员', '1', null, '0'), ('6', '2019-03-13 09:55:17', '0', '人力', '1', null, '0'), ('7', '2019-03-13 09:55:42', '0', '风控', '100', '2019-03-20 06:05:53', '0'), ('9', '2019-03-20 06:05:51', '0', '风控专员', '1', null, '0'), ('10', '2019-03-20 06:10:02', '0', '风控总监', '1', null, '0'), ('11', '2019-03-20 09:37:41', '0', '业务总监', '1', null, '0'), ('12', '2019-03-20 09:37:54', '0', '业务团队经理', '100', '2019-03-20 09:40:21', '0'), ('13', '2019-03-22 11:01:00', '0', '战略决策者', '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_ums_role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `t_ums_role_privilege`;
CREATE TABLE `t_ums_role_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `privilege_type` int(11) DEFAULT NULL,
  `res_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_ums_role_privilege`
-- ----------------------------
BEGIN;
INSERT INTO `t_ums_role_privilege` VALUES ('1', '2018-12-12 17:34:50', '1', '1', '1', '1', '1', null, '1'), ('2', '2018-12-12 17:34:50', '1', '1', '2', '1', '1', null, '1'), ('3', '2018-12-12 17:34:50', '1', '1', '3', '1', '1', null, '1'), ('4', '2018-12-12 17:34:50', '1', '1', '4', '1', '1', null, '1'), ('5', '2018-12-12 17:34:50', '1', '1', '5', '1', '1', null, '1'), ('6', '2018-12-12 17:34:50', '1', '1', '6', '1', '1', null, '1'), ('7', '2018-12-12 17:34:50', '1', '1', '7', '1', '1', null, '1'), ('8', '2018-12-12 17:34:50', '1', '1', '8', '1', '1', null, '1'), ('9', '2018-12-12 17:34:50', '1', '1', '1', '2', '1', null, '1'), ('10', '2018-12-12 17:34:50', '1', '1', '2', '2', '1', null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_ums_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_ums_role_resource`;
CREATE TABLE `t_ums_role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `res_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_ums_role_resource`
-- ----------------------------
BEGIN;
INSERT INTO `t_ums_role_resource` VALUES ('1', '2019-03-11 00:42:58', '0', '1', '1', '1', '1', null, '0'), ('2', '2019-03-11 00:43:06', '0', '2', '1', '1', '1', null, '0'), ('3', '2019-03-11 00:43:14', '0', '3', '1', '1', '1', null, '0'), ('4', '2019-03-11 00:43:19', '0', '4', '1', '1', '1', null, '0'), ('5', '2019-03-11 00:43:25', '0', '5', '1', '100', '1', '2019-03-13 07:06:57', '0'), ('6', '2019-03-11 00:43:29', '0', '1', '1', '100', '0', '2019-03-11 00:43:46', '0'), ('7', '2019-03-11 00:43:39', '0', '1', '1', '100', '0', '2019-03-11 00:43:47', '0'), ('8', '2019-03-11 04:27:18', '0', '7', '1', '1', '1', null, '0'), ('9', '2019-03-11 04:28:27', '0', '8', '1', '1', '1', null, '0'), ('10', '2019-03-12 01:40:56', '0', '23', '1', '1', '3', null, '0'), ('11', '2019-03-12 01:41:07', '0', '24', '1', '1', '3', null, '0'), ('12', '2019-03-12 01:41:15', '0', '25', '1', '1', '3', null, '0'), ('13', '2019-03-12 01:41:24', '0', '26', '1', '1', '3', null, '0'), ('14', '2019-03-12 15:48:56', '0', '27', '1', '1', '1', null, '0'), ('15', '2019-03-12 15:48:56', '0', '28', '1', '1', '1', null, '0'), ('16', '2019-03-12 15:48:56', '0', '29', '1', '1', '1', null, '0'), ('17', '2019-03-12 15:48:56', '0', '30', '1', '1', '1', null, '0'), ('18', '2019-03-12 15:48:56', '0', '31', '1', '1', '1', null, '0'), ('19', '2019-03-12 15:48:56', '0', '32', '1', '1', '1', null, '0'), ('20', '2019-03-12 15:48:56', '0', '33', '1', '1', '1', null, '0'), ('21', '2019-03-12 15:48:56', '0', '34', '1', '1', '1', null, '0'), ('22', '2019-03-12 15:48:56', '0', '35', '1', '1', '1', null, '0'), ('23', '2019-03-12 15:48:56', '0', '36', '1', '1', '1', null, '0'), ('24', '2019-03-12 15:48:56', '0', '37', '1', '1', '1', null, '0'), ('25', '2019-03-12 15:48:56', '0', '38', '1', '1', '1', null, '0'), ('26', '2019-03-12 15:48:56', '0', '39', '1', '1', '1', null, '0'), ('27', '2019-03-12 15:48:56', '0', '40', '1', '1', '1', null, '0'), ('28', '2019-03-12 15:48:56', '0', '41', '1', '1', '1', null, '0'), ('29', '2019-03-12 15:48:56', '0', '42', '1', '1', '1', null, '0'), ('30', '2019-03-12 15:48:56', '0', '43', '1', '1', '1', null, '0'), ('31', '2019-03-12 15:48:56', '0', '44', '1', '1', '1', null, '0'), ('32', '2019-03-12 15:48:56', '0', '45', '1', '1', '1', null, '0'), ('39', '2019-03-13 07:07:29', '0', '5', '1', '1', '1', null, '0'), ('40', '2019-03-13 10:00:32', '0', '66', '1', '1', '1', null, '0'), ('41', '2019-03-13 20:44:55', '0', '5', '2', '100', '0', '2019-03-13 21:59:18', '0'), ('42', '2019-03-13 20:45:43', '0', '5', '2', '1', '1', null, '0'), ('43', '2019-03-13 20:46:07', '0', '7', '4', '1', '1', null, '0'), ('44', '2019-03-13 20:46:32', '0', '39', '5', '100', '1', '2019-03-20 09:21:59', '0'), ('45', '2019-03-13 20:46:44', '0', '3', '6', '1', '1', null, '0'), ('46', '2019-03-13 20:46:57', '0', '1', '7', '100', '1', '2019-03-20 09:34:22', '0'), ('47', '2019-03-20 20:53:55', '0', '11', '1', '100', '1', null, '0'), ('48', '2019-03-19 02:46:13', '0', '68', '1', '1', '1', null, '0'), ('49', '2019-03-20 04:18:17', '0', '69', '1', '1', '1', null, '0'), ('50', '2019-03-20 06:00:19', '0', '70', '1', '1', '1', null, '0'), ('51', '2019-03-20 06:01:06', '0', '67', '1', '1', '1', null, '0'), ('52', '2019-03-20 06:01:31', '0', '6', '1', '1', '1', null, '0'), ('53', '2019-03-20 09:21:10', '0', '39', '5', '1', '1', null, '0'), ('54', '2019-03-20 09:21:23', '0', '40', '5', '1', '1', null, '0'), ('55', '2019-03-20 09:21:36', '0', '41', '5', '1', '1', null, '0'), ('56', '2019-03-20 09:22:31', '0', '42', '0', '1', '1', null, '0'), ('57', '2019-03-20 09:22:46', '0', '43', '5', '1', '1', null, '0'), ('58', '2019-03-20 09:23:13', '0', '44', '5', '1', '1', null, '0'), ('59', '2019-03-20 09:23:26', '0', '66', '5', '1', '1', null, '0'), ('60', '2019-03-20 09:23:57', '0', '42', '5', '1', '1', null, '0'), ('61', '2019-03-20 09:24:36', '0', '8', '4', '1', '1', null, '0'), ('62', '2019-03-20 09:25:14', '0', '37', '4', '1', '1', null, '0'), ('63', '2019-03-20 09:25:43', '0', '4', '6', '1', '1', null, '0'), ('64', '2019-03-20 09:26:09', '0', '29', '6', '1', '1', null, '0'), ('65', '2019-03-20 09:26:33', '0', '30', '6', '1', '1', null, '0'), ('66', '2019-03-20 09:26:47', '0', '31', '6', '1', '1', null, '0'), ('67', '2019-03-20 09:27:01', '0', '32', '6', '1', '1', null, '0'), ('68', '2019-03-20 09:27:13', '0', '33', '6', '1', '1', null, '0'), ('69', '2019-03-20 09:27:28', '0', '34', '6', '100', '1', '2019-03-20 09:28:15', '0'), ('70', '2019-03-20 09:27:45', '0', '34', '6', '1', '1', null, '0'), ('71', '2019-03-20 09:27:59', '0', '67', '6', '1', '1', null, '0'), ('72', '2019-03-20 09:29:18', '0', '1', '2', '1', '1', null, '0'), ('73', '2019-03-20 09:29:31', '0', '2', '2', '1', '1', null, '0'), ('74', '2019-03-20 09:30:16', '0', '36', '2', '1', '1', null, '0'), ('75', '2019-03-20 09:32:05', '0', '1', '9', '100', '0', '2019-03-20 09:33:00', '0'), ('76', '2019-03-20 09:32:15', '0', '2', '9', '100', '0', '2019-03-20 09:33:04', '0'), ('77', '2019-03-20 09:32:22', '0', '1', '10', '100', '0', '2019-03-20 09:33:08', '0'), ('78', '2019-03-20 09:32:31', '0', '2', '10', '100', '0', '2019-03-20 09:33:11', '0'), ('79', '2019-03-20 09:33:22', '0', '1', '9', '100', '1', '2019-03-20 09:46:41', '0'), ('80', '2019-03-20 09:33:32', '0', '2', '9', '100', '1', '2019-03-20 09:46:45', '0'), ('81', '2019-03-20 09:33:41', '0', '1', '10', '100', '1', '2019-03-20 09:46:54', '0'), ('82', '2019-03-20 09:33:51', '0', '2', '10', '100', '1', '2019-03-20 09:46:58', '0'), ('83', '2019-03-20 09:38:42', '0', '1', '11', '100', '1', '2019-03-20 09:45:37', '0'), ('84', '2019-03-20 09:38:51', '0', '2', '11', '100', '1', '2019-03-20 09:45:45', '0'), ('85', '2019-03-20 09:39:01', '0', '5', '11', '100', '1', '2019-03-20 09:55:53', '0'), ('86', '2019-03-20 09:39:30', '0', '36', '11', '100', '1', '2019-03-20 09:45:52', '0'), ('87', '2019-03-20 09:39:44', '0', '6', '11', '1', '1', null, '0'), ('88', '2019-03-22 11:01:25', '0', '68', '13', '1', '1', null, '0'), ('89', '2019-03-22 11:01:45', '0', '69', '13', '1', '1', null, '0'), ('90', '2019-03-22 11:02:02', '0', '70', '13', '1', '1', null, '0'), ('91', '2019-03-22 11:05:05', '0', '35', '13', '1', '1', null, '0'), ('92', '2019-03-25 20:41:22', '0', '104', '1', '1', '1', null, '0'), ('93', '2019-03-25 20:41:34', '0', '105', '1', '1', '1', null, '0'), ('94', '2019-03-27 10:07:16', '0', '106', '2', '1', '1', null, '0'), ('95', '2019-03-29 02:58:08', '0', '107', '4', '1', '1', null, '0'), ('96', '2019-03-29 02:58:19', '0', '108', '4', '1', '1', null, '0'), ('97', '2019-03-29 02:58:31', '0', '109', '4', '1', '1', null, '0'), ('98', '2019-03-29 02:58:47', '0', '38', '4', '1', '1', null, '0'), ('99', '2019-03-30 08:55:06', '0', '110', '13', '1', '0', null, '0'), ('100', '2019-03-30 11:16:39', '0', '111', '11', '1', '1', null, '0'), ('101', '2019-03-30 11:16:49', '0', '111', '1', '1', '1', null, '0'), ('102', '2019-04-01 07:16:16', '0', '112', '13', '1', '1', null, '0'), ('103', '2019-04-01 07:16:38', '0', '112', '1', '1', '1', null, '0'), ('104', '2019-04-12 07:52:32', '0', '115', '1', '1', '1', null, '0'), ('105', '2019-04-15 06:37:01', '0', '116', '1', '1', '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_ums_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_ums_user`;
CREATE TABLE `t_ums_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `last_log_in_time` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `dduser_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_ums_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_ums_user` VALUES ('0', '2019-03-14 19:31:25', '0', null, '0', '1', '2019-03-14 19:31:44', '0', '全部', null), ('1', '2018-12-12 09:17:09', '1', '2018-12-12 09:50:18', 'C4CA4238A0B923820DCC509A6F75849B', '1', '2019-03-14 02:55:41', '0', 'admin', null), ('7', '2019-03-22 10:24:54', '0', null, 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '0', 'wanghm', null), ('8', '2019-03-22 10:25:11', '0', null, 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '0', 'liuys', null), ('9', '2019-03-22 10:25:20', '0', null, 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '0', 'liuxs', null), ('10', '2019-03-22 10:25:38', '0', null, 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '0', 'lixin', null), ('13', '2019-03-22 10:45:43', '0', null, 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '0', 'zhangxs', null), ('14', '2019-03-22 10:46:42', '0', null, 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '0', 'hexu', null), ('15', '2019-03-28 06:49:05', '0', null, 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '0', 'wangxs', null), ('16', '2019-03-28 07:08:28', '0', null, 'B6D767D2F8ED5D21A44B0E5886680CB9', '1', '2019-04-02 00:14:44', '16', 'zhangxx', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_ums_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_ums_user_role`;
CREATE TABLE `t_ums_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_ums_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_ums_user_role` VALUES ('1', '2019-03-10 21:57:07', '0', '1', '100', '2019-03-13 09:57:20', '0', '2'), ('2', '2019-03-10 21:57:14', '0', '1', '1', null, '0', '1'), ('3', '2019-03-13 21:54:55', '0', '2', '1', null, '0', '7'), ('4', '2019-03-22 10:32:31', '0', '2', '1', null, '0', '8'), ('5', '2019-03-22 10:32:45', '0', '2', '1', null, '0', '9'), ('6', '2019-03-22 10:33:00', '0', '2', '1', null, '0', '10'), ('7', '2019-03-22 10:33:10', '0', '2', '100', '2019-03-22 10:47:41', '0', '11'), ('8', '2019-03-22 10:33:21', '0', '2', '100', '2019-03-22 10:47:43', '0', '12'), ('9', '2019-03-22 10:49:04', '0', '2', '1', null, '0', '13'), ('10', '2019-03-22 10:49:13', '0', '2', '1', null, '0', '14'), ('11', '2019-03-22 11:02:28', '0', '13', '1', null, '0', '7'), ('12', '2019-03-22 11:06:21', '0', '6', '1', null, '0', '10'), ('13', '2019-03-22 11:07:03', '0', '4', '1', null, '0', '10'), ('14', '2019-03-28 06:49:19', '0', '2', '1', null, '0', '15'), ('15', '2019-03-28 07:10:39', '0', '2', '1', null, '0', '16');
COMMIT;

-- ----------------------------
--  Table structure for `t_user_behavior_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_behavior_log`;
CREATE TABLE `t_user_behavior_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `behavior_time` datetime DEFAULT NULL,
  `resource_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` VALUES ('1', '2018-12-12 17:24:57', '1', '1', '1', null, '1', '1'), ('3', '2018-12-12 17:37:32', '1', '2', '1', null, '1', '2');
COMMIT;

-- ----------------------------
--  Table structure for `t_util_calc_formula`
-- ----------------------------
DROP TABLE IF EXISTS `t_util_calc_formula`;
CREATE TABLE `t_util_calc_formula` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `begin_date` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `expression` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_util_calc_formula`
-- ----------------------------
BEGIN;
INSERT INTO `t_util_calc_formula` VALUES ('4', '2018-12-31 10:00:00', '2019-03-25 22:27:57', '0', '2019-12-31 10:00:00', '(orderArea==1||orderArea==2||orderArea==3)&&(demandDate==applyDateAdd1Day)&&amount<=8000000?(0.008*using10DaysNum+0.003*using3DaysNum)*amount:0', '利息1', '1', '1', null, '0'), ('8', '2018-12-31 10:00:00', '2019-03-25 22:36:51', '0', '2019-12-31 10:00:00', '(orderArea==1||orderArea==2||orderArea==3)&&(demandDate==applyDateAdd1Day)&&amount>8000000?(0.009*using10DaysNum+0.003*using3DaysNum)*amount:0', '利息2', '1', '1', null, '0'), ('9', '2018-12-31 10:00:00', '2019-03-25 22:48:35', '0', '2019-12-31 10:00:00', '(orderArea==1||orderArea==2||orderArea==3)&&(demandDate!=applyDateAdd1Day)&&amount<=8000000&&nextOrg==1?(0.0068*using10DaysNum+0.003*using3DaysNum)*amount:0', '利息5', '1', '1', null, '0'), ('11', '2018-12-31 10:00:00', '2019-03-25 22:50:16', '0', '2019-12-31 10:00:00', '(orderArea==1||orderArea==2||orderArea==3)&&(demandDate!=applyDateAdd1Day)&&amount<=8000000&&nextOrg==2?(0.0075*using10DaysNum+0.003*using3DaysNum)*amount:0', '利息7', '1', '1', null, '0'), ('13', '2018-12-31 10:00:00', '2019-03-25 22:52:33', '0', '2019-12-31 10:00:00', '(orderArea==1||orderArea==2||orderArea==3)&&(demandDate!=applyDateAdd1Day)&&amount>8000000&&amount<=13000000?(0.008*using10DaysNum+0.003*using3DaysNum)*amount:0', '利息9', '1', '1', null, '0'), ('15', '2018-12-31 10:00:00', '2019-03-25 22:56:38', '0', '2019-12-31 10:00:00', 'orderArea==4&&(demandDate==applyDateAdd1Day)?(0.009*using10DaysNum+0.003*using3DaysNum)*amount:0', '利息11', '1', '1', null, '0'), ('17', '2018-12-31 10:00:00', '2019-03-25 22:57:18', '0', '2019-12-31 10:00:00', 'orderArea==4&&(demandDate==applyDateAdd2Day)?(0.008*using10DaysNum+0.003*using3DaysNum)*amount:0', '利息12', '1', '1', null, '0'), ('18', '2018-12-31 10:00:00', '2019-03-25 22:58:51', '0', '2019-12-31 10:00:00', 'busiType==5?(0.008*using10DaysNum+0.003*using3DaysNum)*amount:0', '利息13', '1', '1', null, '0'), ('19', '2018-12-31 10:00:00', '2019-03-26 00:45:51', '0', '2019-12-31 10:00:00', '(orderArea==1||orderArea==2||orderArea==3)&&mortgageNum1>=1?(600+(mortgageNum1-1)*200):0', '下户1', '1', '2', '2019-03-26 03:06:20', '0'), ('20', '2018-12-31 10:00:00', '2019-03-26 00:46:38', '0', '2019-12-31 10:00:00', '(orderArea==4&&mortgageNum1>=1)?(1500+(mortgageNum1-1)*200):0', '下户2', '1', '2', '2019-03-26 03:07:58', '0'), ('22', '2018-12-31 10:00:00', '2019-03-26 00:48:17', '0', '2019-12-31 10:00:00', '0.002*amount', '律师费', '1', '3', null, '0'), ('23', '2018-12-31 10:00:00', '2019-03-26 03:06:54', '0', '2019-12-31 10:00:00', '(orderArea==1||orderArea==2||orderArea==3)&&mortgageNum2>=1?(1200+(mortgageNum2-1)*200):0', '下户3', '1', '2', null, '0'), ('24', '2018-12-31 10:00:00', '2019-03-26 03:08:23', '0', '2019-12-31 10:00:00', '(orderArea==4&&mortgageNum2>=1)?(1500+(mortgageNum2-1)*200):0', '下户4', '1', '2', null, '0'), ('25', '2018-12-31 10:00:00', '2019-03-26 10:02:12', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM==calcYYYYMM&&positionId==2&&enterCompanyDay>=1&&enterCompanyDay<=10&&monthInterest>30000?4000:0', '专员工资1', '1', '4', null, '0'), ('26', '2018-12-31 10:00:00', '2019-03-26 10:02:58', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM==calcYYYYMM&&positionId==2&&enterCompanyDay>=1&&enterCompanyDay<=10&&monthInterest<=30000?2500:0', '专员工资2', '1', '4', null, '0'), ('27', '2018-12-31 10:00:00', '2019-03-26 10:04:06', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM==calcYYYYMM&&positionId==2&&enterCompanyDay>10&&enterCompanyDay<=20&&monthInterest>15000?4000:0', '专员工资3', '1', '4', '2019-03-26 10:05:07', '0'), ('28', '2018-12-31 10:00:00', '2019-03-26 10:04:54', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM==calcYYYYMM&&positionId==2&&enterCompanyDay>10&&enterCompanyDay<=20&&monthInterest<=15000?2500:0', '专员工资4', '1', '4', null, '0'), ('29', '2018-12-31 10:00:00', '2019-03-26 10:07:07', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM==calcYYYYMM&&positionId==10&&enterCompanyDay>=1&&enterCompanyDay<=10&&groupInterest>300000?7000:0', '经理工资1', '1', '6', null, '0'), ('30', '2018-12-31 10:00:00', '2019-03-26 10:07:54', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM==calcYYYYMM&&positionId==10&&enterCompanyDay>=1&&enterCompanyDay<=10&&groupInterest<=300000?5000:0', '经理工资2', '1', '6', null, '0'), ('31', '2018-12-31 10:00:00', '2019-03-26 10:08:59', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM==calcYYYYMM&&positionId==10&&enterCompanyDay>10&&enterCompanyDay<=20&&groupInterest>150000?7000:0', '经理工资3', '1', '6', null, '0'), ('32', '2018-12-31 10:00:00', '2019-03-26 10:09:46', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM==calcYYYYMM&&positionId==10&&enterCompanyDay>10&&enterCompanyDay<=20&&groupInterest<=150000?5000:0', '经理工资4', '1', '6', null, '0'), ('33', '2018-12-31 10:00:00', '2019-03-26 10:10:40', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM==calcYYYYMM&&positionId==10&&enterCompanyDay>20?7000:0', '经理工资5', '1', '6', null, '0'), ('34', '2018-12-31 10:00:00', '2019-03-26 10:12:19', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM==calcYYYYMM&&positionId==2&&enterCompanyDay>20?4000:0', '专员工资5', '1', '4', null, '0'), ('35', '2018-12-31 10:00:00', '2019-03-26 10:22:37', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM!=calcYYYYMM&&positionId==2&&monthInterest>30000&&newBusinessCount>=1?4000:0', '专员工资6', '1', '4', null, '0'), ('36', '2018-12-31 10:00:00', '2019-03-26 10:26:30', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM!=calcYYYYMM&&positionId==2&&monthInterest<=30000?2500:0', '专员工资7', '1', '4', '2019-03-26 10:27:50', '0'), ('37', '2018-12-31 10:00:00', '2019-03-26 10:29:30', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM!=calcYYYYMM&&positionId==10&&groupInterest>300000&&groupCount>=6?7000:0', '经理工资6', '1', '6', null, '0'), ('38', '2018-12-31 10:00:00', '2019-03-26 10:30:28', '0', '2019-12-31 10:00:00', 'enterCompanyYYYMM!=calcYYYYMM&&positionId==10&&(groupInterest<=300000||groupCount<6)?5000:0', '经理工资7', '1', '6', null, '0'), ('39', '2018-12-31 10:00:00', '2019-03-26 10:32:51', '0', '2019-12-31 10:00:00', 'monthInterest>50000?0.08*orderInterest:0', '专员提成1', '1', '5', '2019-03-28 01:14:57', '0'), ('40', '2018-12-31 10:00:00', '2019-03-26 10:33:26', '0', '2019-12-31 10:00:00', 'monthInterest<=50000?0.05*orderInterest:0', '专员提成2', '1', '5', '2019-03-28 01:15:12', '0'), ('41', '2018-12-31 10:00:00', '2019-03-26 10:34:12', '0', '2019-12-31 10:00:00', 'groupInterest>600000?0.04*groupInterest:0', '经理提成1', '1', '7', null, '0'), ('42', '2018-12-31 10:00:00', '2019-03-26 10:35:47', '0', '2019-12-31 10:00:00', 'groupInterest>300000&&groupInterest<=600000?0.02*groupInterest:0', '经理提成2', '1', '7', null, '0'), ('43', '2018-12-31 10:00:00', '2019-03-26 10:36:23', '0', '2019-12-31 10:00:00', 'groupInterest<=300000?0.01*groupInterest:0', '经理提成3', '1', '7', null, '0'), ('44', '2018-12-31 10:00:00', '2019-03-28 01:55:17', '0', '2019-12-31 10:00:00', '0.05*orderInterest', '专员最低提成', '1', '8', null, '0'), ('45', '2018-12-31 10:00:00', '2019-03-28 01:55:43', '0', '2019-12-31 10:00:00', '0.08*orderInterest', '专员最高提成', '1', '9', null, '0'), ('46', '2018-12-31 10:00:00', '2019-03-28 01:57:52', '0', '2019-12-31 10:00:00', '0.07*orderInterest', '外勤提成', '1', '10', null, '0'), ('47', '2018-12-31 10:00:00', '2019-03-30 21:47:16', '0', '2019-12-31 10:00:00', '0.04*orderInterest', '经理最高提成', '1', '11', '2019-03-30 21:50:21', '0'), ('48', '2018-12-31 10:00:00', '2019-03-30 21:47:32', '0', '2019-12-31 10:00:00', '0.01*orderInterest', '经理最低', '1', '12', '2019-03-30 21:50:39', '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_util_calc_param`
-- ----------------------------
DROP TABLE IF EXISTS `t_util_calc_param`;
CREATE TABLE `t_util_calc_param` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `expression` varchar(255) DEFAULT NULL,
  `formula_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `formula_type_id` int(11) DEFAULT NULL,
  `para_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_util_calc_param`
-- ----------------------------
BEGIN;
INSERT INTO `t_util_calc_param` VALUES ('1', '2019-03-26 01:11:15', '0', 'area', null, '区域', '1', null, '0', '1', ''), ('2', '2019-03-26 01:11:47', '0', 'usingDateAdd1', null, '用款日加1天', '1', null, '0', '1', '都按照当天的零时零点'), ('3', '2019-03-26 01:12:00', '0', 'applyDate', null, '申请日', '1', null, '0', '1', ''), ('4', '2019-03-26 01:12:13', '0', 'amount', null, '垫资金额', '1', null, '0', '1', ''), ('5', '2019-03-26 01:12:29', '0', 'usingDateAdd10', null, '用款日加10天', '1', null, '0', '1', ''), ('6', '2019-03-26 01:12:43', '0', 'endDate', null, '用款结束日', '1', null, '0', '1', ''), ('7', '2019-03-26 01:12:59', '0', 'usingDateAdd3', null, '用款日加3天', '1', null, '0', '1', ''), ('8', '2019-03-26 01:13:16', '0', 'nextOrg', null, '下家机构', '1', null, '0', '1', '1、银行；2、机构'), ('9', '2019-03-26 01:13:47', '0', 'busiType', null, '业务类型', '1', null, '0', '1', ''), ('10', '2019-03-26 01:14:18', '0', 'mortgageNum', null, '抵押次数', '100', '2019-03-26 01:47:22', '0', '2', ''), ('11', '2019-03-26 01:15:14', '0', 'houseNum', null, '机构下房子数', '100', '2019-03-26 01:47:23', '0', '2', ''), ('12', '2019-03-26 01:16:40', '0', 'orgNum', null, '机构数', '100', '2019-03-26 01:47:26', '0', '2', ''), ('13', '2019-03-26 01:48:10', '0', 'mortgageNum1', null, '一抵房子数', '1', null, '0', '2', ''), ('14', '2019-03-26 01:48:24', '0', 'mortgageNum2', null, '二抵房子数', '1', null, '0', '2', '');
COMMIT;

-- ----------------------------
--  Table structure for `t_util_format_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_util_format_info`;
CREATE TABLE `t_util_format_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `busi_type` int(11) DEFAULT NULL,
  `ch_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `data_type` int(11) DEFAULT NULL,
  `en_name` varchar(255) DEFAULT NULL,
  `if_scatter` int(11) DEFAULT NULL,
  `need_step` varchar(200) DEFAULT NULL,
  `scatter_obj` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `who_object` int(11) DEFAULT NULL,
  `can_modify_role_set` varchar(255) DEFAULT NULL,
  `can_see_role_set` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_util_format_info`
-- ----------------------------
BEGIN;
INSERT INTO `t_util_format_info` VALUES ('1', '2', '付息提醒日', '2019-04-12 17:22:53', '0', '4', 'payInterestAlertDate', '2', '-1', '', '1', null, '0', '1', '0', '2,7,16,14,6,11,12,8'), ('2', '2', '下次付息日', '2019-04-12 17:22:54', '0', '4', 'nextInterestPaymentDate', '2', '-1', '', '1', null, '0', '1', '0', '2,7,16,14,6,11,12,8'), ('3', '2', '提醒日期', '2019-04-12 17:22:54', '0', '4', 'reminderDate', '2', '-1', '', '1', null, '0', '1', '0', '2,7,16,14,6,11,12,8'), ('4', '2', '评估日期', '2019-04-12 17:22:54', '0', '4', 'assessmentDate', '2', '102', '', '1', null, '0', '1', '8', '2,7,16,14,6,11,12,8'), ('5', '2', '链家评估日期', '2019-04-12 17:22:54', '0', '4', 'chainFamilyEvaluationDate', '2', '102', '', '1', null, '0', '1', '8', '2,7,16,14,6,11,12,8'), ('6', '2', '大数据日期', '2019-04-12 17:22:54', '0', '4', 'bigDataDate', '2', '102', '', '1', null, '0', '1', '8', '2,7,16,14,6,11,12,8'), ('7', '2', '预约还款日', '2019-04-12 17:22:54', '0', '4', 'reservedRepaymentDate', '2', '123', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('8', '2', '上家核实到期日期', '2019-04-12 17:22:54', '0', '4', 'checkExpirationDate', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('9', '2', '上家核实日期', '2019-04-12 17:22:54', '0', '4', 'verificationDate', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('10', '2', '下家核实批贷日期', '2019-04-12 17:22:54', '0', '4', 'verificationApprovalDate', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('11', '2', '下家核实公证日期', '2019-04-12 17:22:54', '0', '4', 'verificationNotarizationDate', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('12', '2', '下家放款账户提供日期', '2019-04-12 17:22:54', '0', '4', 'accountProvisionDate', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('13', '2', '下家核实日期', '2019-04-12 17:22:54', '0', '4', 'nextVerificationDate', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('14', '2', '签约日期', '2019-04-12 17:22:54', '0', '4', 'reContractDate', '2', '112,114', '', '100', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('15', '2', '卷齐日期', '2019-04-12 17:22:54', '0', '4', 'fileCollectionDate', '2', '112,114', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('16', '2', '报卷日期', '2019-04-12 17:22:54', '0', '4', 'fileReportDate', '2', '-1', '', '1', null, '0', '1', '0', '2,7,16,14,6,11,12,8'), ('17', '2', '批贷日期', '2019-04-12 17:22:54', '0', '4', 'approvedDate', '2', '118', '', '1', null, '0', '1', '8', '2,7,16,14,6,11,12,8'), ('18', '2', '证件收押日期', '2019-04-12 17:22:54', '0', '4', 'depositCertificatesDate', '2', '112,114', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('19', '2', '垫资放款日期', '2019-04-12 17:22:54', '0', '4', 'loanDate', '2', '-1', '', '1', null, '0', '1', '0', '2,7,16,14,6,11,12,8'), ('20', '2', '上家扣款日期', '2019-04-12 17:22:54', '0', '4', 'deductionDate', '2', '121', '', '1', null, '0', '1', '12', '2,7,16,14,6,11,12,8'), ('21', '2', '收费日期', '2019-04-12 17:22:54', '0', '4', 'feeDate', '2', '-1', '', '1', null, '0', '1', '0', '2,7,16,14,6,11,12,8'), ('22', '2', '上家房本预计领取日期', '2019-04-12 17:22:54', '0', '4', 'houseOwnershipExpectedReceiveDate', '2', '122', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('23', '2', '上家房本实际领取日期', '2019-04-12 17:22:54', '0', '4', 'houseOwnershipRealReceiveDate', '2', '-1', '', '1', null, '0', '1', '0', '2,7,16,14,6,11,12,8'), ('24', '2', '解压材料预计领取日期', '2019-04-12 17:22:54', '0', '4', 'unzipDocExpectedReceiveDate', '2', '122', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('25', '2', '解压材料实际领取日期', '2019-04-12 17:22:54', '0', '4', 'unzipDocRealReceiveDate', '2', '-1', '', '1', null, '0', '1', '0', '2,7,16,14,6,11,12,8'), ('26', '2', '解压材料解押日期', '2019-04-12 17:22:54', '0', '4', 'unzipDocUndepositDate', '2', '122', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('27', '2', '下家房本送至日期', '2019-04-12 17:22:54', '0', '4', 'nextHouseOwnershipSendDate', '2', '123', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('28', '2', '下家房本抵押日期', '2019-04-12 17:22:54', '0', '4', 'nextHouseOwnershipDepositDate', '2', '123', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('29', '2', '下家房本他证领取日期', '2019-04-12 17:22:54', '0', '4', 'nextHouseOtherReceiveDate', '2', '123', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('30', '2', '下家放款预计放款日期', '2019-04-12 17:22:54', '0', '4', 'nextExceptionLoanDate', '2', '124', '', '1', null, '0', '1', '12', '2,7,16,14,6,11,12,8'), ('31', '2', '下家放款实际放款日期', '2019-04-12 17:22:54', '0', '4', 'nextRealLoanDate', '2', '124', '', '1', null, '0', '1', '12', '2,7,16,14,6,11,12,8'), ('32', '2', '完结日期', '2019-04-12 17:22:54', '0', '4', 'finishDate', '2', '-1', '', '1', null, '0', '1', '0', '2,7,16,14,6,11,12,8'), ('33', '2', '产权人', '2019-04-12 17:22:54', '0', '3', 'propertyOwner', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('34', '2', '身份证号', '2019-04-12 17:22:54', '0', '3', 'certiNO', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('35', '2', '是否已婚', '2019-04-12 17:22:54', '0', '1', 'maritalStatus', '1', '104', 'YesNo', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('36', '2', '配偶姓名', '2019-04-12 17:22:55', '0', '3', 'spouseName', '2', '-1', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('37', '2', '配偶身份证号', '2019-04-12 17:22:55', '0', '3', 'spouseCertiNO', '2', '-1', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('38', '2', '大数据结论', '2019-04-12 17:22:55', '0', '3', 'bigDateConclusion', '2', '102', '', '1', null, '0', '1', '8', '2,7,16,14,6,11,12,8'), ('39', '2', '客户本金收款户名', '2019-04-12 17:22:55', '0', '3', 'customerCapitalAccountName', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('40', '2', '客户本金收款账号', '2019-04-12 17:22:55', '0', '3', 'customerCapitalAccountNO', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('41', '2', '客户本金收款开户行', '2019-04-12 17:22:55', '0', '3', 'customerCapitalBank', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('42', '2', '产权证号', '2019-04-12 17:22:55', '0', '3', 'titleCertificateNO', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('43', '2', '房屋坐落', '2019-04-12 17:22:55', '0', '3', 'houseAddress', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('44', '2', '建筑面积', '2019-04-12 17:22:55', '0', '5', 'houseSquare', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('45', '2', '房屋类型', '2019-04-12 17:22:55', '0', '1', 'houseType', '1', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('46', '2', '评估总价', '2019-04-12 17:22:55', '0', '5', 'houseEvaluatePrice', '2', '102', '', '1', null, '0', '1', '8', '2,7,16,14,6,11,12,8'), ('47', '2', '链家快出总价', '2019-04-12 17:22:55', '0', '5', 'chainFamilyFastOutPrice', '2', '102', '', '1', null, '0', '1', '8', '2,7,16,14,6,11,12,8'), ('48', '2', '垫资金额', '2019-04-12 17:22:55', '0', '5', 'amount', '2', '0', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('49', '2', '预计天数', '2019-04-12 17:22:55', '0', '1', 'exceptionDays', '2', '-1', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('50', '2', '报信托天数', '2019-04-12 17:22:55', '0', '1', 'tellUpDays', '2', '112,114', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('51', '2', '客户首付天数', '2019-04-12 17:22:55', '0', '1', 'customerFirstPayDays', '2', '112,114', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('52', '2', '逾期天数', '2019-04-12 17:22:55', '0', '1', 'overdueDays', '2', '-1', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('53', '2', '申请天数', '2019-04-12 17:22:55', '0', '1', 'applyDays', '2', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('54', '2', '垫资是否展期', '2019-04-12 17:22:55', '0', '1', 'ifExtension', '1', '122', 'YesNo', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('55', '2', '首展天数', '2019-04-12 17:22:55', '0', '1', 'firstExtensionDays', '2', '-1', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('56', '2', '展期收费', '2019-04-12 17:22:55', '0', '5', 'extensionFee', '2', '-1', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('57', '2', '上家名称', '2019-04-12 17:22:55', '0', '3', 'upName', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('58', '2', '剩余本金', '2019-04-12 17:22:55', '0', '5', 'upResidueCapital', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('59', '2', '剩余利息', '2019-04-12 17:22:55', '0', '5', 'upResidueInterest', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('60', '2', '罚息/其他', '2019-04-12 17:22:55', '0', '5', 'upPenaltyInterest', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('61', '2', '是否逾期', '2019-04-12 17:22:55', '0', '1', 'upIfOverdue', '1', '111', 'YesNo', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('62', '2', '上家逾期天数', '2019-04-12 17:22:55', '0', '1', 'upOverdueDays', '2', '-1', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('63', '2', '房本是否收押', '2019-04-12 17:22:55', '0', '1', 'upIfHouseDeposit', '1', '111', 'YesNo', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('64', '2', '解押材料', '2019-04-12 17:22:55', '0', '3', 'upUnzipDoc', '2', '102', '', '100', null, '0', '1', '0', '2,7,16,14,6,11,12,8'), ('65', '2', '上家本金收款户名', '2019-04-12 17:22:55', '0', '3', 'upCapitalAccountName', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('66', '2', '上家本金收款开户行', '2019-04-12 17:22:55', '0', '3', 'upCapitalBank', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('67', '2', '上家本金收款账号', '2019-04-12 17:22:55', '0', '3', 'upCapitalAccountNO', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('68', '2', '下家名称', '2019-04-12 17:22:55', '0', '3', 'nextName', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('69', '2', '批贷额', '2019-04-12 17:22:55', '0', '5', 'nextAount', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('70', '2', '是否带用途批', '2019-04-12 17:22:55', '0', '1', 'nextIfLimitPurpose', '1', '111', 'YesNo', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('71', '2', '是否公证', '2019-04-12 17:22:55', '0', '1', 'nextIfNotarization', '1', '111', 'YesNo', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('72', '2', '放款形式', '2019-04-12 17:22:55', '0', '1', 'nextLoanWay', '1', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('73', '2', '下家放款账户提供方', '2019-04-12 17:22:55', '0', '3', 'nextCapitalAccountProvider', '1', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('74', '2', '下家放款户名', '2019-04-12 17:22:55', '0', '3', 'nextCapitalAccountName', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('75', '2', '下家放款开户行', '2019-04-12 17:22:55', '0', '3', 'nextCapitalBank', '2', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('76', '2', '民族', '2019-04-18 15:48:00', '0', '3', 'nationality', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('77', '2', '发证地址', '2019-04-18 15:48:00', '0', '3', 'certiAddress', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('78', '2', '身份证有效期起', '2019-04-18 15:48:00', '0', '4', 'certiStartDate', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('79', '2', '身份证有效期止', '2019-04-18 15:48:00', '0', '4', 'certiEndDate', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('80', '2', '发证机关', '2019-04-18 15:48:00', '0', '3', 'certiIssue', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('81', '2', '房产证号', '2019-04-18 15:48:00', '0', '3', 'houseCertiNo', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('82', '2', '权利人', '2019-04-18 15:48:01', '0', '3', 'houseOwnership', '2', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('83', '2', '共有情况', '2019-04-18 15:48:01', '0', '3', 'belongType', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('85', '2', '不动产单元号', '2019-04-18 15:48:01', '0', '3', 'houseUnitNo', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('86', '2', '土地权利类型', '2019-04-18 15:48:01', '0', '3', 'landRightType', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('87', '2', '房屋权利类型', '2019-04-18 15:48:01', '0', '3', 'houseRigthType', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('88', '2', '土地权利性质/取得方式', '2019-04-18 15:48:01', '0', '3', 'landGetWay', '2', '104', 'certiIssue', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('89', '2', '房屋权利性质/取得方式', '2019-04-18 15:48:01', '0', '3', 'houseGetWay', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('90', '2', '土地用途', '2019-04-18 15:48:01', '0', '3', 'landPurpose', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('91', '2', '房屋用途', '2019-04-18 15:48:01', '0', '3', 'housePurpose', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('92', '2', '建筑面积', '2019-04-18 15:48:01', '0', '5', 'coveredArea', '2', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('93', '2', '使用期限', '2019-04-18 15:48:01', '0', '3', 'serviceLife', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('94', '2', '业务类型', '2019-04-19 15:15:20', '0', '1', 'busiType', '1', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('95', '2', '业务状态', '2019-04-19 15:15:20', '0', '1', 'orderState', '1', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('96', '2', '最新提醒事项', '2019-04-19 15:15:20', '0', '3', 'latestReminders', '2', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('97', '2', '提醒事项办理人', '2019-04-19 15:15:20', '0', '1', 'reminderPeople', '2', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('98', '2', '业务员', '2019-04-19 15:15:20', '0', '1', 'salerId', '2', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('99', '2', '风控专员', '2019-04-19 15:15:20', '0', '1', 'riskController', '2', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('100', '2', '合作渠道/个人', '2019-04-19 15:15:20', '0', '4', 'channelName', '2', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('101', '2', '贷款类型', '2019-04-19 15:15:20', '0', '1', 'upLoanType', '2', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('102', '2', '房本领取日期', '2019-04-19 15:15:20', '0', '4', 'upHouseReceiveDate', '2', '104', '', '100', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('103', '2', '下家机构类型', '2019-04-22 23:16:33', '0', '1', 'nextOrganType', '1', '111', '', '1', null, '0', '1', '7', '2,7,16,14,6,11,12,8'), ('104', '2', '申请人电话', '2019-04-22 23:44:33', '0', '3', 'applyTel', '2', '-1', '', '1', null, '0', '1', '11', '11'), ('105', '2', '房屋区域', '2019-04-23 20:06:41', '0', '1', 'houseArea', '1', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8'), ('106', '2', '几抵', '2019-04-23 20:06:41', '0', '1', 'mortgageNum', '2', '104', '', '1', null, '0', '1', '11', '2,7,16,14,6,11,12,8');
COMMIT;

-- ----------------------------
--  Table structure for `t_util_work_flow`
-- ----------------------------
DROP TABLE IF EXISTS `t_util_work_flow`;
CREATE TABLE `t_util_work_flow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `after_state` int(11) DEFAULT NULL,
  `before_state` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `trans_condition` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `work_type` int(11) DEFAULT NULL,
  `action_id` int(11) DEFAULT NULL,
  `busi_type` int(11) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `button_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `t_util_work_flow`
-- ----------------------------
BEGIN;
INSERT INTO `t_util_work_flow` VALUES ('1', '101', '0', '2019-03-21 09:52:46', '0', '1', '', null, '0', '1', '0', '2', '11', '71'), ('2', '102', '101', '2019-03-21 09:57:10', '0', '1', '', null, '0', '1', '0', '2', '11', '72'), ('3', '103', '102', '2019-03-21 09:59:56', '0', '1', '', null, '0', '1', '0', '2', '8', '73'), ('4', '104', '102', '2019-03-21 10:00:21', '0', '1', '', null, '0', '1', '0', '2', '8', '74'), ('5', '105', '102', '2019-03-21 10:00:53', '0', '1', '', null, '0', '1', '0', '2', '8', '75'), ('6', '103', '105', '2019-03-21 10:02:37', '0', '1', '', null, '0', '1', '0', '2', '6', '73'), ('7', '104', '105', '2019-03-21 10:03:12', '0', '1', '', null, '0', '1', '0', '2', '6', '74'), ('8', '106', '103', '2019-03-21 10:03:39', '0', '1', '', null, '0', '1', '0', '2', '11', '82'), ('9', '101', '103', '2019-03-21 10:04:18', '0', '1', '', null, '0', '1', '0', '2', '11', '71'), ('10', '107', '104', '2019-03-21 10:04:55', '0', '1', '', null, '0', '1', '0', '2', '11', '72'), ('11', '108', '107', '2019-03-21 10:05:58', '0', '1', '', null, '0', '1', '0', '2', '6', '80'), ('12', '109', '107', '2019-03-21 10:06:44', '0', '1', '', null, '0', '1', '0', '2', '6', '81'), ('13', '106', '109', '2019-03-21 10:07:31', '0', '1', '', null, '0', '1', '0', '2', '11', '82'), ('14', '110', '109', '2019-03-21 10:08:09', '0', '1', '', null, '0', '1', '0', '2', '11', '71'), ('15', '107', '110', '2019-03-21 10:08:50', '0', '1', '', null, '0', '1', '0', '2', '11', '72'), ('16', '111', '108', '2019-03-21 10:09:35', '0', '1', '', null, '0', '1', '0', '2', '12', '84'), ('17', '112', '111', '2019-03-21 10:10:10', '0', '1', '', null, '0', '1', '0', '2', '7', '85'), ('18', '113', '111', '2019-03-21 10:10:34', '0', '1', '', null, '0', '1', '0', '2', '7', '86'), ('19', '114', '113', '2019-03-21 10:12:26', '0', '1', '', null, '0', '1', '0', '2', '15', '87'), ('20', '115', '113', '2019-03-21 10:12:55', '0', '1', '', null, '0', '1', '0', '2', '15', '88'), ('21', '106', '115', '2019-03-21 10:13:27', '0', '1', '', null, '0', '1', '0', '2', '11', '82'), ('22', '116', '112', '2019-03-21 10:14:07', '0', '1', '', null, '0', '1', '0', '2', '7', '89'), ('23', '116', '114', '2019-03-21 10:14:32', '0', '1', '', null, '0', '1', '0', '2', '7', '89'), ('24', '117', '116', '2019-03-21 10:15:03', '0', '1', '', null, '0', '1', '0', '2', '12', '90'), ('25', '118', '117', '2019-03-21 10:16:28', '0', '100', '', null, '0', '1', '0', '2', '8', '91'), ('26', '119', '117', '2019-03-21 10:16:56', '0', '1', '', null, '0', '1', '0', '2', '14', '92'), ('27', '120', '117', '2019-03-21 10:17:29', '0', '1', '', null, '0', '1', '0', '2', '14', '93'), ('28', '106', '120', '2019-03-21 10:17:50', '0', '1', '', null, '0', '1', '0', '2', '11', '82'), ('29', '121', '119', '2019-03-21 10:18:30', '0', '1', '', null, '0', '1', '0', '2', '12', '94'), ('30', '122', '121', '2019-03-21 10:18:59', '0', '1', '', null, '0', '1', '0', '2', '12', '95'), ('31', '123', '122', '2019-03-21 10:19:33', '0', '1', '', null, '0', '1', '0', '2', '7', '96'), ('32', '124', '123', '2019-03-21 10:19:52', '0', '1', '', null, '0', '1', '0', '2', '7', '97'), ('33', '125', '124', '2019-03-21 10:20:31', '0', '1', '', null, '0', '1', '0', '2', '12', '98'), ('34', '126', '125', '2019-03-21 10:21:09', '0', '1', '', null, '0', '1', '0', '2', '7', '99'), ('35', '127', '126', '2019-03-21 10:21:36', '0', '1', '', null, '0', '1', '0', '2', '8', '100');
COMMIT;

-- ----------------------------
--  Procedure structure for `calc_person_commission`
-- ----------------------------
DROP PROCEDURE IF EXISTS `calc_person_commission`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calc_person_commission`()
BEGIN
end
 ;;
delimiter ;

-- ----------------------------
--  Procedure structure for `calc_product_commission`
-- ----------------------------
DROP PROCEDURE IF EXISTS `calc_product_commission`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calc_product_commission`()
begin
	#生成居间业务、垫资业务各项佣金
	declare v_id,v_prod_id,v_business_type,v_order_id,v_in_out,v_pay_type INT;
	declare v_name,v_bank_code VARCHAR(30);
	declare v_amount,v_broker,v_law_fee,v_fair_fee,v_license_fee DECIMAL(10,2);
	declare done boolean default 0;
	#计算应收手续费、律师费、公证费、执照费；
	#计算t_cbs_order_product，状态为1,2,3,4,5计算完后，修改为51
	DECLARE mycursor CURSOR FOR
		SELECT t1.id,t1.product_id,t1.real_amount,
			   t2.business_type,t2.id,
			   t4.name,t4.bank_code
		from t_cbs_order_product t1,t_cbs_order t2,t_cbs_order_prod_cust t3,t_customer t4
		where t1.order_id=t2.id
		and t1.id = t3.order_product_id
		and t3.customer_id = t4.id
		and t3.identity_type=1
		and t2.business_type in (1,2)
		and t1.approve_time<SYSDATE()
		and t1.state<>100
		and t2.state<>100
		and t1.order_prod_state =5;
	declare continue handler for sqlstate '02000' set done=1;
	OPEN mycursor;
	repeat
	FETCH mycursor INTO v_id,v_prod_id,v_amount,v_business_type,v_order_id,v_name,v_bank_code;
	
	if not done then
		update t_cbs_order_product set order_prod_state=51 where id=v_id;
		select t.brokerage,t.law_fee,t.fair_fee,t.license_fee
		into v_broker,v_law_fee,v_fair_fee,v_license_fee
		from t_cbs_product t where t.id=v_prod_id;
		
		if v_broker <>0 then
			insert into t_finance_payment(order_product_id,
			account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
			pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
			values(v_id,v_name,v_amount*v_broker,sysdate(),0,1,0,v_order_id,sysdate(),
			6,1,2,2,3,0,0,0);#应收手续费
		end if;
		
		if v_law_fee <>0 then
			insert into t_finance_payment(order_product_id,
			account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
			pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
			values(v_id,v_name,v_amount*v_law_fee,sysdate(),0,1,0,v_order_id,sysdate(),
			6,1,2,2,9,0,0,0);#律师费
		end if;

		if v_fair_fee <>0 then
			insert into t_finance_payment(order_product_id,
			account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
			pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
			values(v_id,v_name,v_amount*v_fair_fee,sysdate(),0,1,0,v_order_id,sysdate(),
			6,1,2,2,10,0,0,0);#公证费
		end if;

		if v_license_fee <>0 then
			insert into t_finance_payment(order_product_id,
			account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
			pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
			values(v_id,v_name,v_amount*v_license_fee,sysdate(),0,1,0,v_order_id,sysdate(),
			6,1,2,2,11,0,0,0);#执照费
		end if;
	end if;
	until done end repeat;
	CLOSE mycursor;
end
 ;;
delimiter ;

-- ----------------------------
--  Procedure structure for `calc_salary`
-- ----------------------------
DROP PROCEDURE IF EXISTS `calc_salary`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calc_salary`()
begin
declare a,b INT;
	declare done boolean default 0;
	#declare b,c VARCHAR;
	DECLARE mycursor CURSOR FOR SELECT id from gzx.cfg_cbs_estate_area;
	declare continue handler for sqlstate '02000' set done=1;
	OPEN mycursor;

	repeat
	FETCH mycursor INTO a;
	update cfg_cbs_estate_area set city=2 where id=a;
	
	until done end repeat;

	CLOSE mycursor;
end
 ;;
delimiter ;

-- ----------------------------
--  Procedure structure for `payment_12`
-- ----------------------------
DROP PROCEDURE IF EXISTS `payment_12`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `payment_12`()
begin
	#生成居间业务、垫资业务的各项手续费；生成产品佣金
	declare v_id,v_prod_id,v_business_type,v_order_id,v_in_out,v_pay_type,v_user_id,v_action_id INT;
	declare v_name,v_bank_code VARCHAR(30);
	declare v_amount,v_broker,v_law_fee,v_fair_fee,v_license_fee DECIMAL(10,2);
	declare done boolean default 0;
	declare v_sign_date,v_approved_date DATE;

	#计算t_cbs_order_product，状态为5计算完后，修改为51
	DECLARE mycursor CURSOR FOR
		SELECT t1.id,t1.product_id,t1.real_amount,
			   t2.business_type,t2.id,
			   t4.name,t4.bank_code,t1.approve_time
		from t_cbs_order_product t1,t_cbs_order t2,t_cbs_order_prod_cust t3,t_customer t4
		where t1.order_id=t2.id
		and t1.id = t3.order_product_id
		and t3.customer_id = t4.id
		and t3.identity_type=1
		and t2.business_type in (1,2)
		and t1.approve_time<SYSDATE()
		and t1.state<>100
		and t2.state<>100
		and t1.order_prod_state =5;
	declare continue handler for sqlstate '02000' set done=1;
	OPEN mycursor;
	repeat
	FETCH mycursor INTO v_id,v_prod_id,v_amount,v_business_type,v_order_id,v_name,v_bank_code,v_approved_date;
	if not done then
		update t_cbs_order_product set order_prod_state=51 where id=v_id;
		
		select t.brokerage,t.law_fee,t.fair_fee,t.license_fee
		into v_broker,v_law_fee,v_fair_fee,v_license_fee
		from t_cbs_product t where t.id=v_prod_id;
		
		if v_broker <>0 then
			insert into t_finance_payment(order_product_id,
			account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
			pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
			values(v_id,v_name,v_amount*v_broker,sysdate(),0,1,0,v_order_id,sysdate(),
			6,1,2,2,3,0,0,0);#应收手续费
		end if;
		
		if v_law_fee <>0 then
			insert into t_finance_payment(order_product_id,
			account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
			pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
			values(v_id,v_name,v_amount*v_law_fee,sysdate(),0,1,0,v_order_id,sysdate(),
			6,1,2,2,9,0,0,0);#律师费
		end if;

		if v_fair_fee <>0 then
			insert into t_finance_payment(order_product_id,
			account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
			pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
			values(v_id,v_name,v_amount*v_fair_fee,sysdate(),0,1,0,v_order_id,sysdate(),
			6,1,2,2,10,0,0,0);#公证费
		end if;

		if v_license_fee <>0 then
			insert into t_finance_payment(order_product_id,
			account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
			pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
			values(v_id,v_name,v_amount*v_license_fee,sysdate(),0,1,0,v_order_id,sysdate(),
			6,1,2,2,11,0,0,0);#执照费
		end if;		
		
		#计算每个人的提成,一个人可能有多个算佣的action，可能在多个岗位
		#只计算了简单累进比例，没有计算分段累进比例
		##假设1、佣金的计算基础只和岗位有关
		##假设2、佣金的发放方式只和岗位、渠道类型有关
		##假设3、简单累计比例是按照业绩越高，佣金比例越高的方式配置的
		BEGIN
		DECLARE v_count,v_position_id,v_level,v_count_2,v_base_type,v_way,v_channel_type,v_pay_way,v_agent_id,v_employee_id INT;
		DECLARE v_percent,v_commission ,v_total_performance,v_total_commission DECIMAL(10,4);
		DECLARE v_employee_name,v_agent_name,v_month VARCHAR(100);
		declare done2 boolean default 0;
		
		#查询出在这个订单下所有的工作，以及该工作所属于的岗位，如果一个人多个岗位算佣，则累加
		DECLARE mycursor2 CURSOR FOR 
		select distinct o.user_id,p.id from t_cbs_order_log o,t_hr_action a,t_hr_position p
		where o.order_id = v_order_id
		and o.action_id = a.id
		and a.position_id = p.id
		and a.state<>100
		and a.is_commission=1
		and p.is_commission=1;
		declare continue handler for sqlstate '02000' set done2=1;
		open mycursor2;
		REPEAT
		fetch mycursor2 into v_user_id,v_position_id;
		if not done2 then	
			select count(*) into v_count from t_hr_employee e where e.user_id= v_user_id;
			#是我们公司的员工
			if v_count=1 then
				select e.manage_grade,name,id into v_level,v_employee_name,v_employee_id from t_hr_employee e where e.user_id= v_user_id;
				set v_channel_type = 1;
			#其他公司的业务员
			ELSE 
				select name,id into v_agent_name,v_agent_id from t_sales_agent a where a.user_id = v_user_id;
				set v_level = 0;
				set v_channel_type = 2;
            end if;
			##假设1：佣金的计算基础只和岗位有关
			select min(base_type) into v_base_type from t_sales_commission c where c.type= v_position_id;
			##假设2:佣金的发放方式只和岗位、渠道类型有关
			select min(pay_way) into v_pay_way from t_sales_commission c where c.type = v_position_id and c.channel_type = v_channel_type;
			
			select count(c.base_type) into v_count_2 from t_sales_commission c where c.type=v_position_id 
			and c.product_id = v_prod_id
			and c.state=1 and c.channel_type =v_channel_type
			and c.start_date<v_approved_date
			and c.end_date>=v_approved_date
			and c.level=v_level
			and c.way = 1 #简单比例
			and c.business_type = v_business_type;
			
			#说明的确是简单比例
			if v_count_2 = 1 then
				select c.percent,c.pay_way,c.base_type into v_percent,v_pay_way,v_base_type from t_sales_commission c where c.type=v_position_id 
				and c.product_id = v_prod_id
				and c.state=1 and c.channel_type =v_channel_type
				and c.start_date<v_approved_date
				and c.end_date>=v_approved_date
				and c.level=v_level
				and c.way = 1 #简单比例
				and c.business_type = v_business_type;
				
				if v_base_type = 1 then
					set v_commission=v_amount*v_percent;
				elseif v_base_type = 2 then 
					set v_commission=v_amount*v_broker*v_percent;
				end if;
			end if;
			
			#查询累计比例配置
			select count(c.base_type) into v_count_2 from t_sales_commission c where c.type=v_position_id 
			and c.product_id = v_prod_id
			and c.state=1 and c.channel_type =v_channel_type
			and c.start_date<v_approved_date
			and c.end_date>=v_approved_date
			and c.level=v_level
			and c.way = 2 #累进比例
			and c.business_type = v_business_type
			and c.sum>=v_amount;				
			
			#如果累计比例配置大于1，则说明是累计比例
			if v_count_2>1 THEN
				#取出累进比例中大于sum的最小比例系数
				#假设3：简单累计比例是按照业绩越高，佣金比例越高的方式配置的
				select min(c.percent) into v_percent from t_sales_commission c where c.type=v_position_id 
				and c.product_id = v_prod_id
				and c.state=1 and c.channel_type =v_channel_type
				and c.start_date<v_approved_date
				and c.end_date>=v_approved_date
				and c.level=v_level
				and c.way = 2 #累进比例
				and c.business_type = v_business_type
				and c.sum<=v_amount;

				if v_base_type = 1 then
					set v_commission=v_amount*v_percent;
				elseif v_base_type = 2 then 
					set v_commission=v_amount*v_broker*v_percent;
				end if;
			end if;  
		
			if v_commission is not null and v_commission<>0 then 
				#先写入明细表
				insert into t_sales_performance_comm_detail(agent_id,commission,create_time,creator,employee_id,performance,state,updator,order_product_id)
				values(ifnull(v_agent_id,0),ifnull(v_commission,0),sysdate(),0,ifnull(v_employee_id,0),v_amount,1,0,v_id);
				#按月发放，需要汇总到按月发放表中
				if ifnull(v_pay_way,0) = 1 then
					select date_format(SYSDATE(),'%Y%m') into v_month;
					
					select count(*) into v_count from t_sales_performance_commission p where p.month = v_month and (agent_id = v_agent_id or employee_id = v_employee_id);
					
					if v_count=0 then
						insert into t_sales_performance_commission(agent_id,agent_name,commission,create_time,creator,month,performance,process,state,updator,employee_id,employee_name)
						values(ifnull(v_agent_id,0),v_agent_name,v_commission,SYSDATE(),0,v_month,v_amount,0,1,0,ifnull(v_employee_id,0),v_employee_name);
					ELSE
						select sum(p.commission),sum(p.performance) into v_total_commission,v_total_performance from t_sales_performance_commission p 
						where p.month = v_month and (agent_id = v_agent_id or employee_id = v_employee_id) and state<>100;
						set v_total_commission = v_total_commission + v_commission,v_total_performance = v_total_performance + v_amount;
						
						update t_sales_performance_commission p set commission=v_total_commission,performance=v_total_performance,update_time=SYSDATE()
						where p.month = v_month and (agent_id = v_agent_id or employee_id = v_employee_id) and state<>100;
					end if;							
				#如果是逐笔发放，写入费用表中
				ELSEIF ifnull(v_pay_way,0) = 2 then 
					insert into t_finance_payment(order_product_id,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
					pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
					values(v_id,v_commission,sysdate(),0,2,0,v_order_id,sysdate(),
					6,1,2,2,6,0,0,0);#应付佣金
				end if;			
			end if;
			
			
		end if;
		until done2 end REPEAT;
		close mycursor2;
		END;


	end if;
	until done end repeat;
	CLOSE mycursor;
end
 ;;
delimiter ;

-- ----------------------------
--  Procedure structure for `payment_34`
-- ----------------------------
DROP PROCEDURE IF EXISTS `payment_34`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `payment_34`()
    DETERMINISTIC
begin
	#生成抵押业务、融资业务应收付本金
	declare v_id,v_prod_id,v_business_type,v_order_id,v_period_type,v_period_num INT;
	declare v_in_out,v_pay_type,v_pay_interest_way INT;
	declare i int default 1;
	declare v_name,v_bank_code VARCHAR(30);
	declare v_amount,v_interest DECIMAL(10,2);
	declare v_sign_date,v_end_date,v_period_date DATE;
	declare done boolean default 0;
	#计算应收手续费、律师费、公证费、执照费；计算应收利息、应付利息；并插入相应费用表
	#计算t_cbs_order_product，状态为1,2,3,4，计算完后，修改为51
	#按业务类型进行计算：1、抵押业务、资金业务需要按照签约时间计算费用;2、居间业务、垫资业务需要按照批贷时间计算费用；
	DECLARE mycursor CURSOR FOR
		SELECT t1.id,t1.product_id,t1.real_amount,
			   t2.business_type,t2.id,t2.pay_interest_way,t2.sign_date,t2.period_type,t2.period_num,
			   t4.name,t4.bank_code
		from t_cbs_order_product t1,t_cbs_order t2,t_cbs_order_prod_cust t3,t_customer t4
		where t1.order_id=t2.id
		and t1.id = t3.order_product_id
		and t3.customer_id = t4.id
		and t3.identity_type=1
		and t2.business_type in (3,4)
		and t2.sign_date<=SYSDATE()
		and t1.state<>100
		and t2.state<>100
		and t1.order_prod_state =4;
	declare continue handler for sqlstate '02000' set done=1;
	OPEN mycursor;
	repeat
	FETCH mycursor INTO v_id,v_prod_id,v_amount,v_business_type,v_order_id,v_pay_interest_way,
	v_sign_date,v_period_type,v_period_num,v_name,v_bank_code;
	
	if not done then
		update t_cbs_order_product set order_prod_state=51 where id=v_id;
		if v_business_type=3 THEN
			set v_in_out=2;#流出
			set v_pay_type=21;#应付客户借款
		elseif v_business_type=4 THEN
			set v_in_out=1;#流入
			set v_pay_type=20;#应收客户储金
		end if;
		#对于抵押贷款、融资业务需要插入本金的应收付
		insert into t_finance_payment(order_product_id,
		account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
		pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
		values(v_id,v_name,v_amount,sysdate(),0,v_in_out,0,v_order_id,v_sign_date,
		6,1,2,2,v_pay_type,0,0,0);
		
		#对于抵押贷款、融资业务需要插入满期本金的应付收
		if v_business_type=3 THEN
			set v_in_out=1;#流入
			set v_pay_type=26;#应收客户借款
		elseif v_business_type=4 THEN
			set v_in_out=2;#流出
			set v_pay_type=27;#应收客户储金
		end if;	
		#计算到期日期
		if v_period_type=1 THEN
			set v_end_date = date_add(v_sign_date,interval v_period_num*1 day);
		elseif v_period_type=2 then
			set v_end_date = date_add(v_sign_date,interval v_period_num*7 day);
		elseif v_period_type=3 then
			set v_end_date = date_add(v_sign_date,interval v_period_num*30 day);
		elseif v_period_type=4 then
			set v_end_date = date_add(v_sign_date,interval v_period_num*365 day);
		end if;
		
		insert into t_finance_payment(order_product_id,
		account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
		pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
		values(v_id,v_name,v_amount,sysdate(),0,v_in_out,0,v_order_id,v_end_date,
		7,1,2,2,v_pay_type,0,0,0);
		
		#计算利息
		select t.interest into v_interest from t_cbs_prod_interest t 
		where t.product_id = v_prod_id and t.period_type=v_period_type
		and t.begin_date<v_sign_date and t.end_date>= v_sign_date
		and t.state<>100;
		
		#一次性支付利息，金额=周期利息*周期数*本金
		if v_pay_interest_way=1 then
			set v_amount=v_amount*v_interest*v_period_num;
		#按周期支付利息，金额=周期利息*本金
		elseif v_pay_interest_way=2 THEN
			set v_amount=v_amount*v_interest;
		end if;
		
		if v_business_type=3 THEN
			set v_in_out=1;#流入
			set v_pay_type=1;#应收利息
		elseif v_buiness_type=4 THEN
			set v_in_out=2;#流出
			set v_pay_type=2;#应付利息
		end if;
		
		insert into t_finance_payment(order_product_id,
		account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
		pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
		values(v_id,v_name,v_amount,sysdate(),0,v_in_out,0,v_order_id,v_sign_date,
		6,1,2,2,v_pay_type,0,0,0);
		
		#如果是按周期结算利息，需要将以后各个周期的利息应收付插入，费用状态为待确认
		if v_pay_interest_way=2 THEN
			WHILE i<v_period_num DO
				if v_period_type=1 THEN
					set v_period_date=DATE_ADD(v_sign_date,INTERVAL i*1 day);
				elseif v_period_type=2 THEN
					set v_period_date=DATE_ADD(v_sign_date,INTERVAL i*7 day);
				elseif v_period_type=2 THEN
					set v_period_date=DATE_ADD(v_sign_date,INTERVAL i*30 day);
				elseif v_period_type=2 THEN
					set v_period_date=DATE_ADD(v_sign_date,INTERVAL i*365 day);
				end if;
				
				insert into t_finance_payment(order_product_id,
				account_name,amount,create_time,creator,in_out,operator_id,order_id,pay_date,
				pay_state,state,offset,if_real,pay_type,other_bank_id,related_id,updator)
				values(v_id,v_name,v_amount,sysdate(),0,v_in_out,0,v_order_id,v_period_date,
				7,1,2,2,v_pay_type,0,0,0);
			set i=i+1;
			end WHILE;
		end if;
	end if;
	until done end repeat;
	CLOSE mycursor;
end
 ;;
delimiter ;

-- ----------------------------
--  Procedure structure for `p_accounting`
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_accounting`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_accounting`()
begin
	declare v_id,v_pay_type,v_debit,v_credit,v_count,v_period_id INT;
	declare v_accounting_period VARCHAR(10);
	declare v_pay_date,v_period_end DATE;
	declare v_amount DECIMAL;
	declare done boolean default 0;
	#正常每日进行记账
	DECLARE mycursor CURSOR FOR select p.id,p.amount,p.pay_type,p.pay_date from t_finance_payment p where p.posted='N';
	declare continue handler for sqlstate '02000' set done=1;
	OPEN mycursor;
	repeat
	FETCH mycursor INTO v_id,v_amount,v_pay_type,v_pay_date;
		update t_finance_payment set posted='Y' where id=v_id;
		select count(*) into v_count from t_finance_accounting_rule r where r.fee_type = v_pay_type;
		if v_count=1 then
			#根据记账规则记账
			select r.debit_side,r.credit_side into v_debit,v_credit from t_finance_accounting_rule r where r.fee_type = v_pay_type;
			insert into t_finance_accounting_entry(accounting_date,amount,debit,credit,creator,create_time,state)values(SYSDATE(),v_amount,v_debit,v_credit,0,SYSDATE(),1);	
			
			select count(*) into v_count from t_finance_accounting_period p where p.start_date <= SYSDATE() and p.end_date>= SYSDATE()  and p.period_state =1 and p.state <> 100;
			if v_count=1 THEN
				select id into v_period_id from t_finance_accounting_period p where p.start_date <= SYSDATE()  and p.end_date>= SYSDATE()  and p.period_state =1 and p.state <> 100;
				select count(*) into v_count from t_finance_balance b where b.accounting_period = v_period_id and b.subject = v_credit;
 				if v_count =1 then
					update t_finance_balance b set b.amount_credit = b.amount_credit + v_amount,b.end_amount_credit = b.end_amount_credit + v_amount,update_time =SYSDATE() where b.accounting_period = v_period_id and b.subject=v_credit;
				ELSE
					insert into t_finance_balance(accounting_period,subject,amount_credit,amount_debit,start_amount_credit,start_amount_debit,end_amount_credit,end_amount_debit,creator,create_time)
					values(v_period_id,v_credit,v_amount,0,0,0,v_amount,0,0,SYSDATE());
				end if;
				select count(*) into v_count from t_finance_balance b where b.accounting_period = v_period_id and b.subject = v_debit;
				if v_count=1 THEN
					update t_finance_balance b set b.amount_debit = b.amount_debit + v_amount,b.end_amount_debit = b.end_amount_debit + v_amount where b.accounting_period = v_period_id and b.subject=v_debit;
				ELSE
					insert into t_finance_balance(accounting_period,subject,amount_credit,amount_debit,start_amount_credit,start_amount_debit,end_amount_credit,end_amount_debit,creator,create_time)
					values(v_period_id,v_debit,0,v_amount,0,0,0,v_amount,0,SYSDATE());
				end if;		
			end if;	
		end if;
		commit;
	until done end repeat;
	CLOSE mycursor;
END
 ;;
delimiter ;

-- ----------------------------
--  Procedure structure for `p_transfer_profit`
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_transfer_profit`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_transfer_profit`()
begin
	declare v_id,v_pay_type,v_count,v_period_id INT;
	declare v_in_amount,v_out_amount,v_credit_amount,v_debit_amount DECIMAL default 0;
	declare v_end_date DATE;
	declare done boolean default 0;

	#将收入结转成本年利润
	DECLARE mycursor CURSOR FOR select b.id from cfg_account_balance b where b.type=4;
	DECLARE mycursor2 CURSOR FOR select b.id from cfg_account_balance b where b.type=5;
	declare continue handler for sqlstate '02000' set done=1;
	
	select count(*) into v_count from t_finance_accounting_period p where p.end_date<=ADDDATE(SYSDATE(),INTERVAL 2 DAY) and p.period_state = 1;
	#如果今天是账期结束日期，需要进行利润的结转，记录科目结转
	if v_count = 1 THEN
		select id,end_date into v_period_id,v_end_date from t_finance_accounting_period p where p.end_date<=ADDDATE(SYSDATE(),INTERVAL 2 DAY)  and p.period_state=1;
		OPEN mycursor;
		repeat
		FETCH mycursor INTO v_id;
			select count(a.end_amount_credit) into v_count from t_finance_balance a where a.subject = v_id and a.accounting_period=v_period_id;
			if v_count = 1 THEN
				select a.end_amount_credit into v_in_amount from t_finance_balance a where a.subject = v_id and a.accounting_period = v_period_id;
				insert into t_finance_accounting_entry(accounting_date,amount,debit,credit,state,creator,create_time)values(v_end_date,v_in_amount,v_id,22,1,0,SYSDATE());
				set v_credit_amount = v_credit_amount + v_in_amount;
			end if;
		until done end repeat;
		CLOSE mycursor;	

		set done=0;
		OPEN mycursor2;
		repeat
		FETCH mycursor2 INTO v_id;
			select count(a.end_amount_credit) into v_count from t_finance_balance a where a.subject = v_id and a.accounting_period=v_period_id;
			if v_count = 1 THEN
				select a.end_amount_credit into v_in_amount from t_finance_balance a where a.subject = v_id and a.accounting_period = v_period_id;
				insert into t_finance_accounting_entry(accounting_date,amount,debit,credit,state,creator,create_time)values(v_end_date,v_in_amount,22,v_id,1,0,SYSDATE());
				set v_debit_amount = v_debit_amount + v_out_amount;
			end if;
		until done end repeat;
		CLOSE mycursor2;	
	end if;
	##查看当期的利润科目是否有值，第一期会没有值,更新当期的本年利润
	select count(*) into v_count from t_finance_balance where subject = 22 and accounting_period=v_period_id;
	if v_count = 1 then
		update t_finance_balance b set b.amount_credit = b.amount_credit + v_credit_amount,b.end_amount_credit = b.end_amount_credit + v_credit_amount where b.accounting_period = v_period_id and b.subject=22;
		update t_finance_balance b set b.amount_debit = b.amount_debit + v_debit_amount,b.end_amount_debit = b.end_amount_debit + v_debit_amount where b.accounting_period = v_period_id and b.subject=22;
	ELSEIF v_count =0 then
		insert into t_finance_balance(accounting_period,subject,amount_credit,amount_debit,start_amount_credit,start_amount_debit,end_amount_credit,end_amount_debit,creator,create_time)
		values(v_period_id,22,v_credit_amount,v_debit_amount,0,0,v_credit_amount,v_debit_amount,0,SYSDATE());
	end if;
	
	update t_finance_accounting_period set period_state = 3 where id = v_period_id;
end
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
