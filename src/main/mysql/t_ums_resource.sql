﻿SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE `t_ums_resource`;
insert into `t_ums_resource`(`id`,`create_time`,`creator`,`name`,`parent_id`,`res_url`,`state`,`type`,`update_time`,`updator`,`column_name`,`value_set`,`grade`,`busi_type`) values
(-1,'2019-03-11 11:55:58',0,'根资源',-1,'/',1,1,null,0,null,null,1,0),
(1,'2018-12-12 17:25:45',0,'核心业务系统',-1,'',1,1,null,0,null,null,1,0),
(2,'2019-03-27 10:38:24',0,'订单处理',1,'/order/list',1,1,null,0,'','',2,0),
(3,'2018-12-12 17:27:12',0,'人力系统',-1,'',1,1,null,0,null,null,1,0),
(4,'2018-12-12 17:27:49',0,'雇员管理',3,'/hr/employee',1,1,null,0,null,null,2,0),
(5,'2018-12-12 17:28:24',0,'销售系统',-1,'',1,1,null,0,null,null,1,0),
(6,'2019-03-28 01:07:29',0,'销售人员管理',5,'/sales/agent',1,1,null,0,'','',2,0),
(7,'2018-12-12 17:29:44',0,'财务系统',-1,'',1,1,null,0,null,null,1,0),
(8,'2018-12-12 17:30:21',0,'收付费管理',7,'/finance/payment',1,1,null,0,null,null,2,0),
(22,'2019-03-11 15:51:19',0,'订单数据',2,null,1,3,null,0,'orderState','(1,2)',3,0),
(23,'2019-03-11 15:52:13',0,'订单数据1-2',2,null,1,3,null,0,'orderState','(1,2)',3,0),
(24,'2019-03-11 15:52:24',0,'订单数据3',2,null,1,3,null,0,'orderState','(3)',3,0),
(25,'2019-03-11 15:52:30',0,'订单数据4',2,null,1,3,null,0,'orderState','(4)',3,0),
(26,'2019-03-11 15:52:34',0,'订单数据5',2,null,1,3,null,0,'orderState','(5)',3,0),
(27,'2019-03-12 15:22:17',0,'产品管理',1,'/cbs/product',1,1,null,0,null,null,2,0),
(28,'2019-03-12 15:23:30',0,'产品利息',1,'/cbs/prodInterest',1,1,null,0,null,null,2,0),
(29,'2019-03-12 15:28:33',0,'部门管理',3,'/hr/dept',1,1,null,0,null,null,2,0),
(30,'2019-03-12 15:28:33',0,'岗位管理',3,'/hr/position',1,1,null,0,null,null,2,0),
(31,'2019-03-12 15:28:33',0,'工作管理',3,'/hr/action',1,1,null,0,null,null,2,0),
(32,'2019-03-12 15:28:33',0,'考勤管理',3,'/hr/attendance',1,1,null,0,null,null,2,0),
(33,'2019-03-12 15:28:33',0,'薪酬管理',3,'/hr/salary',1,1,null,0,null,null,2,0),
(34,'2019-03-12 15:28:33',0,'培训管理',3,'/hr/curriculum',1,1,null,0,null,null,2,0),
(35,'2019-03-12 15:31:15',0,'提成比例管理',5,'/sales/commission',1,1,null,0,null,null,2,0),
(36,'2019-03-12 15:31:15',0,'提成管理',5,'/sales/performanceCommission',1,1,null,0,null,null,2,0),
(37,'2019-03-12 15:33:29',0,'账户管理',7,'/finance/account',1,1,null,0,null,null,2,0),
(38,'2019-03-12 15:34:03',0,'记账规则管理',7,'/finance/accountingRule',1,1,null,0,null,null,2,0),
(39,'2019-03-12 15:35:01',0,'IT管理',-1,'',1,1,null,0,null,null,1,0),
(40,'2019-03-12 15:37:22',0,'角色管理',39,'/ums/role',1,1,null,0,null,null,2,0),
(41,'2019-03-12 15:37:22',0,'用户角色管理',39,'/ums/userRole',1,1,null,0,null,null,2,0),
(42,'2019-03-12 15:37:22',0,'资源管理',39,'/ums/resource',1,1,null,0,null,null,2,0),
(43,'2019-03-12 15:37:22',0,'角色资源管理',39,'/ums/roleResource',1,1,null,0,null,null,2,0),
(44,'2019-03-12 15:37:23',0,'工作流配置',39,'/util/workFlow',1,1,null,0,null,null,2,0),
(45,'2019-03-12 15:41:44',0,'订单数据5',2,null,1,3,null,0,'orderState','(5)',3,0),
(66,'2019-03-13 09:59:53',0,'用户管理',39,'/ums/user',1,1,null,0,'','',2,0),
(67,'2019-03-18 03:55:16',0,'雇员岗位管理',3,'/hr/employeePosition',1,1,null,0,'','',2,0),
(68,'2019-03-19 02:43:57',0,'决策系统',-1,'',1,1,null,0,'','',1,0),
(69,'2019-03-19 02:45:50',0,'业务报表',68,'/mis/showBusiReport',1,1,null,0,'','',2,0),
(70,'2019-03-19 03:46:09',0,'财务大盘',68,'/mis/showFinReport',1,1,null,0,'','',2,0),
(71,'2019-03-21 19:54:27',0,'暂存订单',2,'/order/edit',1,2,null,0,null,null,3,0),
(72,'2019-03-21 19:54:27',0,'提交订单',2,'/order/edit',1,2,null,0,null,null,3,0),
(73,'2019-03-21 19:54:27',0,'初审不通过',2,'/order/edit',1,2,null,0,null,null,3,0),
(74,'2019-03-21 19:54:27',0,'初审通过',2,'/order/edit',1,2,null,0,null,null,3,0),
(75,'2019-03-21 19:54:27',0,'初审上报',2,'/order/edit',1,2,null,0,null,null,3,0),
(76,'2019-03-21 19:54:27',0,'上传资料',2,'/order/edit',1,2,null,0,null,null,3,0),
(77,'2019-03-21 19:54:27',0,'查看资料',2,'/order/edit',1,2,null,0,null,null,3,0),
(78,'2019-03-21 19:54:27',0,'添加客户',2,'/order/edit',1,2,null,0,null,null,3,0),
(79,'2019-03-21 19:54:27',0,'添加产品',2,'/order/edit',1,2,null,0,null,null,3,0),
(80,'2019-03-21 19:54:27',0,'复审通过',2,'/order/edit',1,2,null,0,null,null,3,0),
(81,'2019-03-21 19:54:27',0,'复审不通过',2,'/order/edit',1,2,null,0,null,null,3,0),
(82,'2019-03-21 19:54:27',0,'订单关闭',2,'/order/edit',1,2,null,0,null,null,3,0),
(83,'2019-03-21 19:54:27',0,'暂存订单',2,'/order/edit',1,2,null,0,null,null,3,0),
(84,'2019-03-21 19:54:27',0,'收下户费成功',2,'/order/edit',1,2,null,0,null,null,3,0),
(85,'2019-03-21 19:54:27',0,'下户通过',2,'/order/edit',1,2,null,0,null,null,3,0),
(86,'2019-03-21 19:54:27',0,'下户不通过',2,'/order/edit',1,2,null,0,null,null,3,0),
(87,'2019-03-21 19:54:27',0,'汇审通过',2,'/order/edit',1,2,null,0,null,null,3,0),
(88,'2019-03-21 19:54:27',0,'汇审不通过',2,'/order/edit',1,2,null,0,null,null,3,0),
(89,'2019-03-21 19:54:28',0,'签约完成',2,'/order/edit',1,2,null,0,null,null,3,0),
(90,'2019-03-21 19:54:28',0,'收服务费成功',2,'/order/edit',1,2,null,0,null,null,3,0),
(91,'2019-03-21 19:54:28',0,'上报机构',2,'/order/edit',1,2,null,0,null,null,3,0),
(92,'2019-03-21 19:54:28',0,'同意放款',2,'/order/edit',1,2,null,0,null,null,3,0),
(93,'2019-03-21 19:54:28',0,'不同意放款',2,'/order/edit',1,2,null,0,null,null,3,0),
(94,'2019-03-21 19:54:28',0,'放款成功',2,'/order/edit',1,2,null,0,null,null,3,0),
(95,'2019-04-24 15:21:35',0,'确认上家扣款完成',2,'/order/edit',1,2,null,0,'','',2,0),
(96,'2019-03-21 19:54:28',0,'确认领取解押材料',2,'/order/edit',1,2,null,0,null,null,3,0),
(97,'2019-03-21 19:54:28',0,'确认下家已抵押',2,'/order/edit',1,2,null,0,null,null,3,0),
(98,'2019-03-21 19:54:28',0,'回款完成',2,'/order/edit',1,2,null,0,null,null,3,0),
(99,'2019-03-21 19:54:28',0,'确认材料完成交接',2,'/order/edit',1,2,null,0,null,null,3,0),
(100,'2019-03-21 19:54:28',0,'已完结',2,'/order/edit',1,2,null,0,null,null,3,0),
(101,'2019-03-25 14:46:41',0,'上传资料',1,null,1,2,null,0,null,null,3,0),
(102,'2019-03-25 14:46:41',0,'录入客户',1,null,1,2,null,0,null,null,3,0),
(103,'2019-03-25 14:46:41',0,'添加产品',1,null,1,2,null,0,null,null,3,0),
(104,'2019-03-25 20:40:37',0,'公式管理',39,'/util/calcFormula',1,1,null,0,'','',2,0),
(105,'2019-03-25 20:41:03',0,'参数管理',39,'/util/calcParam',1,1,null,0,'','',2,0),
(106,'2019-06-11 20:46:54',0,'订单查询',1,'/bridgecbs/bridgeOrder/readList',1,1,null,0,'','',2,0),
(107,'2019-03-29 02:56:21',0,'记账明细',7,'/finance/accountingEntry',1,1,null,0,'','',2,0),
(108,'2019-03-29 02:56:53',0,'科目余额',7,'/finance/balance',1,1,null,0,'','',2,0),
(109,'2019-03-29 02:57:43',0,'账期管理',7,'/finance/accountingPeriod',1,1,null,0,'','',2,0),
(110,'2019-03-30 08:54:32',0,'统计周期管理',68,'/mis/period',100,1,'2019-03-30 08:58:04',0,'','',2,0),
(111,'2019-03-30 11:15:54',0,'销售组织管理',5,'/sales/group',1,1,null,0,'','',2,0),
(112,'2019-04-01 07:15:57',0,'现金流报表',68,'/mis/cashFlowReport',1,1,null,0,'','',2,0),
(115,'2019-04-12 07:52:16',0,'格式化信息',39,'/util/formatInfo',1,1,null,0,'','',2,0),
(116,'2019-04-15 06:36:42',0,'要件管理',1,'/cbs/certificate',1,1,null,0,'','',2,0),
(117,'2019-04-25 10:53:44',0,'确认机构通过',2,'/order/edit',1,2,null,0,'','',3,0),
(118,'2019-04-26 01:03:07',0,'提醒配置',39,'/util/reminder',1,1,null,0,'','',2,0),
(119,'2019-04-30 09:04:46',0,'订单分配',1,'/order/allocation',1,1,null,0,'','',2,0),
(120,'2019-05-07 16:21:14',0,'确认下家已放款',2,'/order/edit',1,2,'2019-05-07 16:21:14',0,'','',3,0),
(121,'2019-06-02 23:26:35',0,'过桥订单处理',1,'/bridgecbs/bridgeOrder',1,1,null,0,'','',2,0),
(122,'2019-06-10 20:44:08',0,'暂存',2,null,1,2,null,0,null,null,3,3),
(123,'2019-06-10 20:44:08',0,'提交初审',2,null,1,2,null,0,null,null,3,3),
(124,'2019-06-10 20:44:08',0,'初审通过',2,null,1,2,null,0,null,null,3,3),
(125,'2019-06-10 20:44:08',0,'初审不通过',2,null,1,2,null,0,null,null,3,3),
(126,'2019-06-10 20:44:08',0,'改为特殊单',2,null,1,2,null,0,null,null,3,3),
(127,'2019-06-10 20:44:08',0,'维持原判',2,null,1,2,null,0,null,null,3,3),
(128,'2019-06-10 20:44:08',0,'到账确认',2,null,1,2,null,0,null,null,3,3),
(129,'2019-06-10 20:44:08',0,'暂不收下户费',2,null,1,2,null,0,null,null,3,3),
(130,'2019-06-10 20:44:09',0,'确认安排下户',2,null,1,2,null,0,null,null,3,3),
(131,'2019-06-10 20:44:09',0,'提交终审',2,null,1,2,null,0,null,null,3,3),
(132,'2019-06-10 20:44:09',0,'终审通过',2,null,1,2,null,0,null,null,3,3),
(133,'2019-06-10 20:44:09',0,'终审不通过',2,null,1,2,null,0,null,null,3,3),
(134,'2019-06-10 20:44:09',0,'特殊通过',2,null,1,2,null,0,null,null,3,3),
(135,'2019-06-10 20:44:09',0,'已调度',2,null,1,2,null,0,null,null,3,3),
(136,'2019-06-10 20:44:09',0,'确认已收利息',2,null,1,2,null,0,null,null,3,3),
(137,'2019-06-10 20:44:09',0,'已上报机构',2,null,1,2,null,0,null,null,3,3),
(138,'2019-06-10 20:44:09',0,'机构已反馈',2,null,1,2,null,0,null,null,3,3),
(139,'2019-06-10 20:44:09',0,'已平衡',2,null,1,2,null,0,null,null,3,3),
(140,'2019-06-10 20:44:09',0,'同意',2,null,1,2,null,0,null,null,3,3),
(141,'2019-06-10 20:44:09',0,'不同意',2,null,1,2,null,0,null,null,3,3),
(142,'2019-06-10 20:44:09',0,'已放款',2,null,1,2,null,0,null,null,3,3),
(143,'2019-06-10 20:44:09',0,'上家已扣款',2,null,1,2,null,0,null,null,3,3),
(144,'2019-06-10 20:44:09',0,'已领取解押材料',2,null,1,2,null,0,null,null,3,3),
(145,'2019-06-10 20:44:09',0,'确认下家已抵押',2,null,1,2,null,0,null,null,3,3),
(146,'2019-06-10 20:44:09',0,'确认机构已放款',2,null,1,2,null,0,null,null,3,3),
(147,'2019-06-10 20:44:09',0,'确认已回款',2,null,1,2,null,0,null,null,3,3),
(148,'2019-06-10 20:44:09',0,'确认材料已交接',2,null,1,2,null,0,null,null,3,3),
(149,'2019-06-10 20:44:09',0,'确认已完结',2,null,1,2,null,0,null,null,3,3),
(150,'2019-06-19 14:22:33',0,'已领取房本',1,'',100,2,null,0,'','',2,0),
(151,'2019-06-19 14:38:28',0,'确认房本已领取',1,'',1,2,null,0,'','',2,3),
(152,'2019-06-24 18:20:52',0,'确认已填写放款审批表',2,null,1,2,null,0,null,null,2,3),
(153,'2019-06-24 18:20:53',0,'确认已填写代收返费和跟投退款',2,null,1,2,null,0,null,null,2,3),
(154,'2019-06-24 18:20:53',0,'确认已填写用途退款',2,null,1,2,null,0,null,null,2,3),
(155,'2019-06-24 22:29:02',0,'确认已支付代收返费和跟投退款',2,null,1,2,null,0,null,null,2,3),
(156,'2019-06-24 22:29:02',0,'确认已支付用途退款',2,null,1,2,null,0,null,null,2,3),
(157,'2019-06-25 11:03:02',0,'卡控管理',1,'/bridgecbs/cardController',1,1,null,0,'','',2,0);
SET FOREIGN_KEY_CHECKS = 1;

