select position0_.id as id1_157_, position0_.create_time as create_t2_157_, position0_.creator as creator3_157_, position0_.dept_id as dept_id4_157_, position0_.is_commission as is_commi5_157_, position0_.level as level6_157_, position0_.name as name7_157_, position0_.salary_max as salary_m8_157_, position0_.salary_min as salary_m9_157_, position0_.state as state10_157_, position0_.update_time as update_11_157_, position0_.updator as updator12_157_ from t_hr_position position0_ where position0_.dept_id=9  and cast(position0_.state as signed)<>100;


select * from cfg_employee_tech_grade;
update cfg_employee_tech_grade set id = -1,name='--请选择--' where id = 0;
update cfg_employee_manage_grade set id = -1,name='--请选择--' where id = 0;
update cfg_employee_city set id = -1,name='--请选择--' where id = 0;
update cfg_employee_position_type set id = -1,name='--请选择--' where id = 0;


select * from t_ums_resource where grade = 2 and type = 1;
select * from t_ums_role_resource where res_id  = 160;
delete from t_ums_resource where id= 160;
delete from t_ums_role_resource where res_id  = 160;
select * from t_util_entitys;
select * from t_util_attribute;
ALTER TABLE t_util_attribute DROP if_modify_card_key;
update t_ums_resource set en_name='bridgecbs' where name = '核心业务系统';
update t_ums_resource set en_name='hr' where name = '人力系统';
update t_ums_resource set en_name='sales' where name = '销售系统';
update t_ums_resource set en_name='finance' where name = '财务系统';
update t_ums_resource set en_name='util' where name = 'IT管理';
update t_ums_resource set en_name='mis' where name = '决策系统';

select * from t_ums_role_resource;
select * from cfg_yes_no;
insert into cfg_attribute_data_type values (-1,'--请选择--');
insert into cfg_attribute_data_type values (1,'int');
insert into cfg_attribute_data_type values (2,'long');
insert into cfg_attribute_data_type values (3,'String');
insert into cfg_attribute_data_type values (4,'Date');
insert into cfg_attribute_data_type values (5,'BigDecimal');

select * from t_ums_resource where grade =1 and state <>100 and id <> -1;

select * from t_cbs_order_pool where order_id = 18;
select * from t_ums_user where id = 19;
update t_ums_user set dduser_name = 'manager8154' where id = 19;
select * from t_hr_employee;
update t_cbs_order_pool set user_id = 19 where id = 526;

update t_ums_user set password = 'C4CA4238A0B923820DCC509A6F75849B' where id = 0;
select * from t_hr_position where state = 1;
select * from t_hr_employee where position = 9;
select * from t_ums_user where id = 18;
update t_bridge_order set order_state = 140 where id =18;
delete from t_cbs_order_pool where id = 519;
update t_cbs_order_pool set do_state = 2,leave_time = null where id = 518;
select * from cfg_yes_no;
select * from t_hr_position;
select order_id,state from t_bridgecbs_card_controller;
select order_state from t_bridge_order where id =18;
select * from t_cbs_order_pool where order_id = 18;
select * from t_ums_user where id = 8;
select * From t_util_work_flow where before_state = 132 and busi_type = 3 and state <> 100;
update cfg_bridge_order_product_id set id = -1 where id = 1;
select * from cfg_cbs_order_state;
select * from t_util_format_info where busi_type = 3 and need_button ='131';
update t_util_format_info set busi_type = 2 where id >= 179 and id <= 183;

insert into cfg_card_controller_account_type values (-1,'--请选择--');
insert into cfg_card_controller_account_type values (1,'赎楼卡');
insert into cfg_card_controller_account_type values (2,'三方卡');
insert into cfg_card_controller_account_type values (3,'赎楼过账卡');
insert into cfg_card_controller_account_type values (4,'三方过账卡');

insert into cfg_card_controller_card_attribute values (-1,'--请选择--');
insert into cfg_card_controller_card_attribute values (1,'对公全控');
insert into cfg_card_controller_card_attribute values (2,'对私全控');

insert into cfg_card_controller_controll_state values (-1,'--请选择--');
insert into cfg_card_controller_controll_state values (1,'已控');
insert into cfg_card_controller_controll_state values (2,'未控');

insert into cfg_yes_no values (-1,'--请选择--');
insert into cfg_yes_no values (1,'是');
insert into cfg_yes_no values (2,'否');

update t_bridge_order set channel_type=0,channel_follow_type=0,customer_fee_tpye=0,three_party_give_type=0,report_organ_days=0;

insert into cfg_bridge_order_channel_follow_type values (-1,'--请选择--');
insert into cfg_bridge_order_channel_follow_type values (1,'直接转客户');
insert into cfg_bridge_order_channel_follow_type values (2,'直接转出借人');

insert into cfg_bridge_order_channel_type values (-1,'--请选择--');
insert into cfg_bridge_order_channel_type values (1,'机构');
insert into cfg_bridge_order_channel_type values (2,'个人');

insert into cfg_bridge_order_three_part_type values (-1,'--请选择--');
insert into cfg_bridge_order_three_part_type values (1,'客户自行提供');
insert into cfg_bridge_order_three_part_type values (2,'我司提供');
insert into cfg_bridge_order_three_part_type values (3,'渠道提供');

insert into cfg_bridge_order_cust_fee_type values (-1,'--请选择--');
insert into cfg_bridge_order_cust_fee_type values (1,'按10天/档付息');
insert into cfg_bridge_order_cust_fee_type values (2,'一次行收齐');
insert into cfg_bridge_order_cust_fee_type values (3,'其他方式');


update t_bridge_original_loan_info set pass_card_bank_id = 0;
update t_bridge_new_loan_info set pass_card_bank_id =0;

select * from cfg_order_doc_type;
update cfg_order_doc_type set file_desc = concat('（',file_desc) where id in (9,15,18,19);

select * from t_hr_action where busi_type = 3 and if_can_expect = 'Y';
update t_hr_action set if_can_expect = 'Y' where id in (62,68,70,72,73,74,75,76,77,78,79,80);
ALTER TABLE t_bridge_order DROP tack_clear_prove_time;
update t_hr_action set expect_action_time_column_name ='supplyDataTime' where id = 59;
update t_hr_action set expect_action_time_column_name ='firstApproveTime' where id = 60;
update t_hr_action set expect_action_time_column_name ='specialOrderDealTime' where id = 61;
update t_hr_action set expect_action_time_column_name ='downFeeTime' where id = 62;
update t_hr_action set expect_action_time_column_name ='specialPassTime' where id = 63;
update t_hr_action set expect_action_time_column_name ='downHouseTime' where id = 64;
update t_hr_action set expect_action_time_column_name ='inputDownInfoTime' where id = 65;
update t_hr_action set expect_action_time_column_name ='secondApproveTime' where id = 66;
update t_hr_action set expect_action_time_column_name ='captialDistributeTime' where id = 67;
update t_hr_action set expect_action_time_column_name ='intrestTime' where id = 68;
update t_hr_action set expect_action_time_column_name ='reportOrganTime' where id = 69;
update t_hr_action set expect_action_time_column_name ='inputOrganInfoTime' where id = 70;
update t_hr_action set expect_action_time_column_name ='thirdApproveTime' where id = 71;
update t_hr_action set expect_action_time_column_name ='outputMoneyTime' where id = 72;
update t_hr_action set expect_action_time_column_name ='confirmUpGetMoneyTime' where id = 73;
update t_hr_action set expect_action_time_column_name ='takeZipDocTime' where id = 74;
update t_hr_action set expect_action_time_column_name ='giveDownDocTime' where id = 75;
update t_hr_action set expect_action_time_column_name ='confirmDownGiveMoneyTime' where id = 76;
update t_hr_action set expect_action_time_column_name ='backMoneyTime' where id = 77;
update t_hr_action set expect_action_time_column_name ='giveCustomerDocTime' where id = 78;
update t_hr_action set expect_action_time_column_name ='takeClearProveTime' where id = 79;
update t_hr_action set expect_action_time_column_name ='takeHouseBookTime' where id = 80;

update t_util_format_info set need_button = '123' where id in (111,112,113,114,115,203,153,154,158,159,160,161,170,175,176,177,178,179,187,188,189);
update t_util_format_info set need_button = '125' where id in (200);
update t_util_format_info set need_button = '133' where id in (201);
update t_util_format_info set need_button = '141' where id in (202);
update t_util_format_info set need_button = '135,139' where id in (184,185);
update t_util_format_info set need_button = '138' where id in (186);

select * from t_util_format_info where busi_type =3 and if_need is null;
select * from t_util_format_info where busi_type =3 and ch_name = '过账卡号';
update t_util_format_info set who_object = 'order' where id>=109 and id<=121;
update t_util_format_info set who_object = 'order' where id>=175 and id<=202;
update t_util_format_info set who_object = 'customer' where id>=122 and id<=126;
update t_util_format_info set who_object = 'mortgage' where id>=127 and id<=137;
update t_util_format_info set who_object = 'order' where id in (138,153,154,158,159,160,161,170);
update t_util_format_info set who_object = 'originalLoan' where id>=139 and id<=152;
update t_util_format_info set who_object = 'originalBankAccount' where id>=155 and id<=157;
update t_util_format_info set who_object = 'newLoan' where id>=162 and id<=169;
update t_util_format_info set who_object = 'newBankAccount' where id = 205;

select * from t_bridge_customer;
select * from t_util_format_info where en_name='certiTypes';
update t_util_format_info set en_name = 'certiType' where id = 124
update t_util_format_info set who_object = 'order' where id = 203;
update t_util_format_info set who_object = 'mortgage' where id = 204;

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'订单名称',sysdate(),0,1,'projectName',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'订单编号',sysdate(),0,1,'orderCode',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'产品名称',sysdate(),0,1,'productId',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'业务类型',sysdate(),0,1,'busiType',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'收费类型',sysdate(),0,1,'payType',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'所属城市',sysdate(),0,1,'city',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'借款人',sysdate(),0,1,'loanName',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'性别',sysdate(),0,1,'sex',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'婚姻状况',sysdate(),0,1,'marriage',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'证件类型',sysdate(),0,1,'certiType',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'手机号码',sysdate(),0,1,'phoneNO',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'证件号码',sysdate(),0,1,'certiCode',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'现居住地址',sysdate(),0,1,'address',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'关系人类型',sysdate(),0,1,'custType',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'姓名',sysdate(),0,1,'name',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'证件类型',sysdate(),0,1,'certiTypes',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'证件号码',sysdate(),0,1,'certiCode',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'联系电话',sysdate(),0,1,'phone',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'物业业务类型',sysdate(),0,1,'propertyType',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'产权状态',sysdate(),0,1,'propertyState',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'房屋类型',sysdate(),0,1,'estateType',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'物业名称',sysdate(),0,1,'propertyName',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'面积',sysdate(),0,1,'square',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'房产证号',sysdate(),0,1,'propertyNO',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'物业所在地',sysdate(),0,1,'estateArea',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'登记价(元)',sysdate(),0,1,'用途',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'用途',sysdate(),0,1,'propertyUse',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'评估价(元)',sysdate(),0,1,'estimatePrice',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'可贷比例(%)',sysdate(),0,1,'percent',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'可贷金额(元)',sysdate(),0,1,'canLoanAmount',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'总登记价(元)',sysdate(),0,1,'totalRegisterPrice',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'总评估价(元)',sysdate(),0,1,'totalEstimatePrice',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款类型',sysdate(),0,1,'type',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款方',sysdate(),0,1,'organType',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款银行',sysdate(),0,1,'organCode',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款金额(元)',sysdate(),0,1,'amount',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款本息余额(元)',sysdate(),0,1,'capitalInterest',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款结束时间',sysdate(),0,1,'endDate',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款还款账号',sysdate(),0,1,'accountNO',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'有无预存',sysdate(),0,1,'hasPreStorage',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'预存天数',sysdate(),0,1,'prostorageDays',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款开户行',sysdate(),0,1,'bankCode',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款户名',sysdate(),0,1,'accountName',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款联系人',sysdate(),0,1,'contactName',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款联系电话',sysdate(),0,1,'contactPhone',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'赎楼方式',sysdate(),0,1,'foreclosureType',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款总金额(元)',sysdate(),0,1,'originalLoadAmount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'原贷款本息总余额(元)',sysdate(),0,1,'originalCaptialInterest',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'过账卡号户名',sysdate(),0,1,'accountName',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'过账卡号',sysdate(),0,1,'accountCode',1,1,0);

insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'过账卡号开户行',sysdate(),0,1,'bankId',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'过账卡号',sysdate(),0,1,'accountCode',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'收款户名',sysdate(),0,1,'acceptionAccountName',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'收款卡号',sysdate(),0,1,'acceptionCardNO',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'收款开户行',sysdate(),0,1,'acceptionBankCode',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'收款开户行支行',sysdate(),0,1,'acceptionBranchBank',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'新贷款方',sysdate(),0,1,'organType',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'新贷款银行',sysdate(),0,1,'organCode',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'是否第三方回款',sysdate(),0,1,'ifOtherPart',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'批复金额(元)',sysdate(),0,1,'approveAmount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'贷款方式',sysdate(),0,1,'loanType',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'放款条件',sysdate(),0,1,'loanCondition',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'新贷款联系人',sysdate(),0,1,'contactName',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'联系电话',sysdate(),0,1,'contactPhone',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'总批复金额(元)',sysdate(),0,1,'totalApproveAmount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'过账卡号户名',sysdate(),0,1,'bankId',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'过账卡号开户行',sysdate(),0,1,'bankId3',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'过账户证件号',sysdate(),0,1,'accountCertiCode',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'过账金额(元)',sysdate(),0,1,'amount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'借款金额(元)',sysdate(),0,1,'loanAmount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'借款天数',sysdate(),0,1,'loanDays',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'计划放款日期',sysdate(),0,1,'planLoanDate',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'赎楼成数',sysdate(),0,1,'percent',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'咨询费(元)',sysdate(),0,1,'consultFee',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'手续费(元)',sysdate(),0,1,'fee',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'手续费补贴(元)',sysdate(),0,1,'feeAllowance',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'应付佣金(元)',sysdate(),0,1,'commission',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'待收费用(元)',sysdate(),0,1,'dueFee',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'计划机构放款(元)',sysdate(),0,1,'planOrganAmount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'自己放款(元)',sysdate(),0,1,'selfAmount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'实际机构放款(元)',sysdate(),0,1,'organAmount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'总成交价(元)',sysdate(),0,1,'totalDealPrice',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'定金(元)',sysdate(),0,1,'frontMoney',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'首付款金额(元)',sysdate(),0,1,'firstAmount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'资金监管金额(元)',sysdate(),0,1,'captialWatchAmount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'资金监管收款账号',sysdate(),0,1,'captialWatchAccount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'监管账号开户行',sysdate(),0,1,'watchAccountBank',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'资金监管银行',sysdate(),0,1,'watchBank',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'资金监管解冻收款户名',sysdate(),0,1,'watchUnfreezeAccount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'公积金贷款金额(元)',sysdate(),0,1,'publicFundAmount',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'公积金户名',sysdate(),0,1,'publicFundName',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'公积金开户行',sysdate(),0,1,'publicFundAccountBank',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'公积金卡号',sysdate(),0,1,'publicFundCardNO',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'公积金银行',sysdate(),0,1,'publicFundBank',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'初审不通过原因',sysdate(),0,1,'firstTrialNoCause',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'终审不通过原因',sysdate(),0,1,'secondTrialNoCause',1,1,0);
insert into t_util_format_info(busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, state, updator)
values (3,'审批不通过原因',sysdate(),0,1,'thirdTrialNoCause',1,1,0);



update t_util_format_info set busi_type = 2;
select * from t_ums_resource where busi_type = 3;

update t_bridge_order set order_state = 131 where id = 10;
select * from cfg_bridge_order_busi_type;
insert into cfg_order_doc_type values(7,'配偶身份证','matCertificate');
update t_bridge_order set product_id = 2;
select * from t_bridge_customer where order_id = 10;
select * from t_bridge_mortgage where order_id = 10;
select * from t_bridge_original_loan_info;
select * from t_bridge_bank_account where order_id = 10;
update t_bridge_bank_account set type = 1 where id in (1,2);
update t_bridge_bank_account set type = 4 where id in (4,5);
select * from t_bridge_new_loan_info;
select * from t_hr_position;
select * from t_hr_employee;
select * from t_ums_user;
select * from t_cbs_order_pool where order_id = 10;
select * from t_util_work_flow t where t.before_state = 146;
select * from t_cbs_order_pool where order_id = 10;
update  t_cbs_order_pool set leave_time = sysdate(),do_state=3 where id = 450;
insert into t_cbs_order_pool (into_time, leave_time, order_id, do_state, user_id, position_id, into_pool_no, create_time, creator, update_time, updator, state)
values (sysdate(),null,10,2,7,14,1,sysdate(),0,null,0,1);
select * from  t_cbs_order_pool;
update t_cbs_order_pool set user_id = 18 where id = 449;
select t.trans_condition,t.position_id,t.action_id,t.button_id,t.before_state,t.after_state from t_util_work_flow t;
ALTER TABLE t_ums_role_resource drop busi_type;
select * from cfg_cbs_order_state where id = 158;
insert into cfg_cbs_order_state (name, busi_type) values ('机构已反馈',3);
select * from t_ums_resource where type =3;
select * from t_hr_position where state =1;
select * From t_hr_action where busi_type =3;
select * from t_util_work_flow where busi_type <> 2;
update t_util_work_flow set busi_type = 3,work_type=1 where busi_type <> 2;

select * from t_ums_resource where busi_type = 3;

select * from t_cbs_order_doc where order_id = 10;
select * from cfg_order_doc_type;
delete from cfg_order_doc_type where id = 7;
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('房产评估','houseEstimate','（编码：A2_02-）有：评估报告（评估截图）；无则无须上传。','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('原贷款合同','originalLoanContract','编码：A3_01-）有：所有合同的关键信息页(借款时间、金额、借款帐户、抵押物清单、签字页等)无：三选一，①查档+征信体现原贷款；②查档+放款流水+还款流水；③查档+原贷款信息核实表','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('还款清单','backLoanList','（编码：A3_02-）征信未显示最近1期还款记录：最新还款清单或还款凭证；征信已显示最近1期还款记录：则无须上传。','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('提前还款回执','beforeBackReceived','（编码：A3_03-）有：提前还款回执；无则无须上传。','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('赎楼要件','houseImportFile','（编码：A3_04-）银行卡复印件/公司印鉴卡','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('贷款批复','loanApproved','（编码：A4_01-）有：银行系统截图/贷款合同；无：同贷批复核实表','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('回款要件','backMoneyImpFiles','（编码：A4_02-）银行卡复印件','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('第三方资料','thiredDocs','编码：A4_08-）身份证/营业执照','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('查档','consultFiles','（编码：A5_01-）有效期内查档单','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('公证书','notarization','（编码：A5_02-）有：整本，首页至尾页；无则无须上传。	','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('法律文本','lawFile','编码：A5_03-）一套原件','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('面签照','faceApprovePic','编码：A5_04-）清晰人物及签字照/视频（机构面签）','');
insert into cfg_order_doc_type (ch_name, en_name,file_desc,need_condition)
values ('其他','others','（编码：A6_01-）其他补充资料','');
update cfg_order_doc_type set file_desc = '（编码：A1_01-）①大陆人士：身份证+新身份证办理回执（若身份证有效期6个月以下）。②港澳人士：港澳居民身份证+港澳居民来往内地通行证（回乡证）+身份变更声明书（如有）' where id = 1;
update cfg_order_doc_type set file_desc = '（编码：A1_02-）①未婚：单身承诺书；②已婚：结婚证；③A离异（有离婚证）：离婚证+离婚协议+单身承诺书；③B离异（无离婚证）：离婚判决书+单身承诺书；④丧偶：配偶死亡证明+单身承诺书' where id = 2;
update cfg_order_doc_type set file_desc = '（编码：A1_03-）整本，首页至尾页' where id = 3;
update cfg_order_doc_type set file_desc = '（编码：A1_04-）有诉讼：判决书、执行结案证明等；无诉讼则无须上传。' where id = 4;
update cfg_order_doc_type set file_desc = '（编码：A1_05-）整本，首页至尾页' where id = 5;
update cfg_order_doc_type set file_desc = '（编码：A2_01-）整本，首页至尾页' where id = 6;
update cfg_order_doc_type set file_type = '个人资料' where id in (1,2,3,4,5);
update cfg_order_doc_type set file_type = '房产' where id in (6,8);
update cfg_order_doc_type set file_type = '原贷款资料' where id in (9,10,11,12);
update cfg_order_doc_type set file_type = '新贷款资料' where id in (13,14,15);
update cfg_order_doc_type set file_type = '放款资料' where id in (16,17,18,19);
update cfg_order_doc_type set file_type = '其他' where id in (20);

select * from t_ums_resource where busi_type = 3;
select * from t_hr_action where busi_type = 3;
select * from cfg_cbs_order_state where busi_type = 3;
select * from t_util_work_flow where busi_type = 3;

insert into cfg_cbs_order_state (name, busi_type)values ('已报单',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已完成初审准备',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已初审通过',3);
insert into cfg_cbs_order_state (name, busi_type)values ('初审不通过',3);
insert into cfg_cbs_order_state (name, busi_type)values ('初审特殊通过',3);
insert into cfg_cbs_order_state (name, busi_type)values ('订单关闭',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已收下户费',3);
insert into cfg_cbs_order_state (name, busi_type)values ('缓收下户费',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已安排下户',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已下户完成',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已终审通过',3);
insert into cfg_cbs_order_state (name, busi_type)values ('终审不通过',3);
insert into cfg_cbs_order_state (name, busi_type)values ('终审特殊通过',3);
insert into cfg_cbs_order_state (name, busi_type)values ('资金已调度',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已收费',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已上报机构',3);
insert into cfg_cbs_order_state (name, busi_type)values ('资金不平衡',3);
insert into cfg_cbs_order_state (name, busi_type)values ('资金已平衡',3);
insert into cfg_cbs_order_state (name, busi_type)values ('同意放款',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已放款',3);
insert into cfg_cbs_order_state (name, busi_type)values ('上家已扣款',3);
insert into cfg_cbs_order_state (name, busi_type)values ('材料已经领取',3);
insert into cfg_cbs_order_state (name, busi_type)values ('下家已抵押',3);
insert into cfg_cbs_order_state (name, busi_type)values ('机构已放款',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已回款',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已交接',3);
insert into cfg_cbs_order_state (name, busi_type)values ('已完结',3);


insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'暂存',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'提交初审',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'初审通过',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'初审不通过',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'改为特殊单',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'维持原判',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'到账确认',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'暂不收下户费',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'确认安排下户',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'提交终审',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'终审通过',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'终审不通过',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'特殊通过',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'已调度',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'确认已收利息',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'已上报机构',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'机构已反馈',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'已平衡',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'同意',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'不同意',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'已放款',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'上家已扣款',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'已领取解押材料',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'确认下家已抵押',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'确认机构已放款',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'确认已回款',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'确认已交接',2,null,1,2,null,0,null,null,3,3);
insert into t_ums_resource(create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
values (sysdate(),0,'确认已完结',2,null,1,2,null,0,null,null,3,3);




insert into t_hr_position (create_time, creator, dept_id, is_commission, level, name, salary_max, salary_min, state, update_time, updator)
VALUES (sysdate(),0,5,0,1,'资金调度岗',null,null,1,null,0);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'补充数据信息',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'初审',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'特殊单处理',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'确认收下户费',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'特殊通过',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'安排下户',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'录入下户信息',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'终审',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'资金调度',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'收利息',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'上报机构',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'录入机构信息',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'审批',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'放款',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'确认上家扣款',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'领取解押材料',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'给下家材料',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'确认下家回款',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'回款已到账',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'交接材料',1,null,0,3);
insert into t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
values (sysdate(),0,'开结清证明',1,null,0,3);


select * from cfg_cbs_order_state;

select * from t_cbs_order_doc where order_id = 10;
delete from t_cbs_order_doc where order_id = 10 and uuidname = "null";

select * from  t_bridge_bank_account;

update t_bridge_customer set state = 1;
update t_bridge_bank_account set type = 2 where id = 3;
select * from cfg_Bridge_Order_Product_Id;
select * from t_hr_dept;
update t_hr_dept set parent_id = 0;
select * from cfg_Bridge_Order_Busi_Type;
select * from t_util_format_info;
select * from t_util_work_flow;
update t_util_work_flow set busi_type = 3;
select * from cfg_order_doc_type;
select * from cfg_bridge_Order_acception_Bank_Code;
select * from cfg_bridge_Order_busi_Type;
select concat('insert into ',table_name,' values();') from information_schema.tables where table_name like '%cfg_bridge%';

insert into cfg_bridge_mortgage_busi_type values();
insert into cfg_bridge_mortgage_state values();
insert into cfg_bridge_mortgage_type values();

select * from cfg_bridge_cust_relation_type;
delete from cfg_bridge_Order_public_Fund_Bank where id > 49;


insert into cfg_bridge_cust_relation_type values(1,'--请选择--');
insert into cfg_bridge_cust_relation_type values(2,'卖方');
insert into cfg_bridge_cust_relation_type values(3,'新贷款共借人');
insert into cfg_bridge_cust_relation_type values(4,'共借人');
insert into cfg_bridge_cust_relation_type values(5,'担保方');
insert into cfg_bridge_cust_relation_type values(6,'承保方');
insert into cfg_bridge_cust_relation_type values(7,'买方');
insert into cfg_bridge_cust_relation_type values(8,'产权人');
insert into cfg_bridge_cust_certi_type values(1,'--请选择--');
insert into cfg_bridge_cust_certi_type values(2,'身份证');
insert into cfg_bridge_cust_certi_type values(3,'回乡证（仅港澳）');
insert into cfg_bridge_cust_certi_type values(4,'营业执照');
insert into cfg_bridge_estate_type values(1,'--请选择--');
insert into cfg_bridge_estate_type values(2,'住宅');
insert into cfg_bridge_estate_type values(3,'公寓');
insert into cfg_bridge_estate_type values(4,'别墅');
insert into cfg_bridge_estate_type values(5,'商业');
insert into cfg_bridge_estate_type values(6,'办公');
insert into cfg_bridge_property_type values(1,'--请选择--');
insert into cfg_bridge_property_type values(2,'无赎楼无抵押');
insert into cfg_bridge_property_type values(3,'只赎楼');
insert into cfg_bridge_property_type values(4,'只抵押');
insert into cfg_bridge_property_type values(5,'赎楼且抵押');
insert into cfg_bridge_property_state values(1,'--请选择--');
insert into cfg_bridge_property_state values(2,'正常');
insert into cfg_bridge_property_state values(3,'抵押');
insert into cfg_bridge_property_state values(4,'查封');

delete from cfg_bridge_Order_acception_Bank_Code where id>49;

select * from cfg_bridge_Order_acception_Bank_Code;
 insert into cfg_bridge_order_acception_bank_code values(-1,'--请选择--');
 insert into cfg_bridge_order_acception_bank_code values(1,'农村商业银行');
 insert into cfg_bridge_order_acception_bank_code values(2,'中国建设银行');
 insert into cfg_bridge_order_acception_bank_code values(3,'中国银行');
 insert into cfg_bridge_order_acception_bank_code values(4,'中国农业银行');

 insert into cfg_bridge_order_acception_bank_code values(5,'中国工商银行');

 insert into cfg_bridge_order_acception_bank_code values(6,'民生银行');

 insert into cfg_bridge_order_acception_bank_code values(7,'兴业银行');

 insert into cfg_bridge_order_acception_bank_code values(8,'广发银行');

 insert into cfg_bridge_order_acception_bank_code values(9,'上海浦东发展银行');

 insert into cfg_bridge_order_acception_bank_code values(10,'招商银行');

 insert into cfg_bridge_order_acception_bank_code values(11,'交通银行');

 insert into cfg_bridge_order_acception_bank_code values(12,'平安银行');

 insert into cfg_bridge_order_acception_bank_code values(13,'光大银行');

 insert into cfg_bridge_order_acception_bank_code values(14,'华夏银行');

 insert into cfg_bridge_order_acception_bank_code values(15,'中信银行');

 insert into cfg_bridge_order_acception_bank_code values(16,'永亨银行');

 insert into cfg_bridge_order_acception_bank_code values(17,'东亚银行');

 insert into cfg_bridge_order_acception_bank_code values(18,'南洋商业银行');

 insert into cfg_bridge_order_acception_bank_code values(19,'渣打银行');

 insert into cfg_bridge_order_acception_bank_code values(20,'盘谷银行');

 insert into cfg_bridge_order_acception_bank_code values(21,'汇丰银行');

 insert into cfg_bridge_order_acception_bank_code values(22,'星展银行');

 insert into cfg_bridge_order_acception_bank_code values(23,'荷兰银行');

 insert into cfg_bridge_order_acception_bank_code values(24,'恒生银行');

 insert into cfg_bridge_order_acception_bank_code values(25,'花旗银行');

 insert into cfg_bridge_order_acception_bank_code values(26,'中信嘉华银行');

 insert into cfg_bridge_order_acception_bank_code values(27,'北京银行');

 insert into cfg_bridge_order_acception_bank_code values(28,'东莞银行');

 insert into cfg_bridge_order_acception_bank_code values(29,'邮政储蓄银行');

 insert into cfg_bridge_order_acception_bank_code values(30,'包商银行');

 insert into cfg_bridge_order_acception_bank_code values(32,'上海银行 ');

 insert into cfg_bridge_order_acception_bank_code values(33,'华兴银行');

 insert into cfg_bridge_order_acception_bank_code values(34,'华商银行');

 insert into cfg_bridge_order_acception_bank_code values(35,'华润银行');

 insert into cfg_bridge_order_acception_bank_code values(36,'南京银行');

 insert into cfg_bridge_order_acception_bank_code values(37,'南粤银行');

 insert into cfg_bridge_order_acception_bank_code values(38,'友利银行');

 insert into cfg_bridge_order_acception_bank_code values(39,'大众银行');

 insert into cfg_bridge_order_acception_bank_code values(40,'大新银行');

 insert into cfg_bridge_order_acception_bank_code values(41,'宁波银行');

 insert into cfg_bridge_order_acception_bank_code values(42,'宝安融兴村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(43,'工银亚洲银行');

 insert into cfg_bridge_order_acception_bank_code values(44,'广州银行');

 insert into cfg_bridge_order_acception_bank_code values(45,'杭州银行');

 insert into cfg_bridge_order_acception_bank_code values(46,'桂银村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(47,'浙商银行');

 insert into cfg_bridge_order_acception_bank_code values(48,'浙江明泰商业银行');

 insert into cfg_bridge_order_acception_bank_code values(49,'深圳发展银行');

 insert into cfg_bridge_order_acception_bank_code values(50,'深圳坪山珠江村镇银行股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(51,'渤海银行');

 insert into cfg_bridge_order_acception_bank_code values(52,'金山银行');

 insert into cfg_bridge_order_acception_bank_code values(53,'(珠海)中国银行');

 insert into cfg_bridge_order_acception_bank_code values(54,'(珠海)交通银行');

 insert into cfg_bridge_order_acception_bank_code values(55,'(珠海)光大银行');

 insert into cfg_bridge_order_acception_bank_code values(56,'(珠海)农业银行');

 insert into cfg_bridge_order_acception_bank_code values(57,'(珠海)农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(58,'(珠海)华夏银行');

 insert into cfg_bridge_order_acception_bank_code values(59,'(珠海)工商银行');

 insert into cfg_bridge_order_acception_bank_code values(60,'(珠海)建设银行');

 insert into cfg_bridge_order_acception_bank_code values(61,'(珠海)招商银行');

 insert into cfg_bridge_order_acception_bank_code values(62,'(珠海)民生银行');

 insert into cfg_bridge_order_acception_bank_code values(63,'(珠海)永亨银行');

 insert into cfg_bridge_order_acception_bank_code values(64,'(珠海)邮政银行');

 insert into cfg_bridge_order_acception_bank_code values(66,'恒丰银行');

 insert into cfg_bridge_order_acception_bank_code values(1121,'滨河村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1180,'福田银座村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1068,'蓝海村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1040,'江苏银行');

 insert into cfg_bridge_order_acception_bank_code values(1041,'新韩银行');

 insert into cfg_bridge_order_acception_bank_code values(1066,'龙岗鼎业村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1104,'开泰银行');

 insert into cfg_bridge_order_acception_bank_code values(1106,'厦门国际银行');

 insert into cfg_bridge_order_acception_bank_code values(1108,'天津银行');

 insert into cfg_bridge_order_acception_bank_code values(1110,'中德住房储蓄银行');

 insert into cfg_bridge_order_acception_bank_code values(1112,'天津农商银行');

 insert into cfg_bridge_order_acception_bank_code values(1114,'滨海农商银行');

 insert into cfg_bridge_order_acception_bank_code values(1116,'哈尔滨银行');

 insert into cfg_bridge_order_acception_bank_code values(1118,'廊坊银行');

 insert into cfg_bridge_order_acception_bank_code values(1123,'宝生村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1220,'浙江稠州商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1222,'宁波通商银行');

 insert into cfg_bridge_order_acception_bank_code values(1240,'江西银行');

 insert into cfg_bridge_order_acception_bank_code values(1242,'九江银行');

 insert into cfg_bridge_order_acception_bank_code values(1244,'（南昌）大丰村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1246,'厦门银行');

 insert into cfg_bridge_order_acception_bank_code values(1260,'海峡银行');

 insert into cfg_bridge_order_acception_bank_code values(1262,'石嘴山银行');

 insert into cfg_bridge_order_acception_bank_code values(1280,'平安普惠');

 insert into cfg_bridge_order_acception_bank_code values(1282,'长沙银行');

 insert into cfg_bridge_order_acception_bank_code values(1300,'神灯金融');

 insert into cfg_bridge_order_acception_bank_code values(1320,'深圳泛华联合投资集团有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1322,'点融网');

 insert into cfg_bridge_order_acception_bank_code values(1324,'天津北辰村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1362,'大房东金融科技有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1364,'广州惠金小额贷款有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1380,'融时代');

 insert into cfg_bridge_order_acception_bank_code values(1381,'红岭创投电子商务股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1383,'中原银行');

 insert into cfg_bridge_order_acception_bank_code values(1402,'深圳市邦信小额贷款有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1406,'富民银行');

 insert into cfg_bridge_order_acception_bank_code values(1412,'成都易捷金融服务外包有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1462,'诺亚融易通小额贷款有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1482,'大众小额贷款股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1483,'广州平安好贷小额贷款有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1487,'深圳市赢众通非融资性担保有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1489,'厦门思明百应小额贷款有限责任公司');

 insert into cfg_bridge_order_acception_bank_code values(1512,'中佳信');

 insert into cfg_bridge_order_acception_bank_code values(1518,'杭州维仕金融服务有限公司北京分公司');

 insert into cfg_bridge_order_acception_bank_code values(1520,'威海蓝海银行');

 insert into cfg_bridge_order_acception_bank_code values(1528,'汉口银行');

 insert into cfg_bridge_order_acception_bank_code values(1530,'中信信托');

 insert into cfg_bridge_order_acception_bank_code values(1539,'快客金服');

 insert into cfg_bridge_order_acception_bank_code values(1541,'深圳保利资产管理有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1543,'上海港开投资管理有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1565,'上海信邦典当行');

 insert into cfg_bridge_order_acception_bank_code values(1572,'长安国际信托股份有公司');

 insert into cfg_bridge_order_acception_bank_code values(1573,'长安国际信托股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1579,'上海市公积金管理中心');

 insert into cfg_bridge_order_acception_bank_code values(1583,'大业信托有限责任公司');

 insert into cfg_bridge_order_acception_bank_code values(1587,'华东小额贷款股份有限责任公司');

 insert into cfg_bridge_order_acception_bank_code values(1603,'成都农商银行');

 insert into cfg_bridge_order_acception_bank_code values(1604,'浦发银行');

 insert into cfg_bridge_order_acception_bank_code values(1606,'江南农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1608,'上海农商银行');

 insert into cfg_bridge_order_acception_bank_code values(1622,'重庆南川石银村镇银行南大街支行');

 insert into cfg_bridge_order_acception_bank_code values(1623,'广东发展银行');

 insert into cfg_bridge_order_acception_bank_code values(1624,'海南屯昌长江村镇银行股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1642,'邯郸银行');

 insert into cfg_bridge_order_acception_bank_code values(1643,'洛阳银行');

 insert into cfg_bridge_order_acception_bank_code values(1651,'贵阳银行');

 insert into cfg_bridge_order_acception_bank_code values(1652,'山西尧都农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1666,'乐山市商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1669,'郑州珠江村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1686,'遂宁银行');

 insert into cfg_bridge_order_acception_bank_code values(1688,'定兴县农村信用联社股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1691,'本溪银行');

 insert into cfg_bridge_order_acception_bank_code values(1692,'北京国际信托有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1694,'公积金管理中心');

 insert into cfg_bridge_order_acception_bank_code values(1696,'河北大厂农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1697,'佛山市三水区农村信用合作联社');

 insert into cfg_bridge_order_acception_bank_code values(1700,'银川掌政石银村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1726,'江苏苏宁银行');

 insert into cfg_bridge_order_acception_bank_code values(1730,'四川简阳农村商业银行股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1747,'徽商银行');

 insert into cfg_bridge_order_acception_bank_code values(1757,'珠江村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1340,'民生村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1342,'华融湘江银行');

 insert into cfg_bridge_order_acception_bank_code values(1347,'(房互网)北京百乘科技有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1360,'米缸互联网信息服务有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1400,'中诚信托有限责任公司');

 insert into cfg_bridge_order_acception_bank_code values(1408,'亚富路小贷银行');

 insert into cfg_bridge_order_acception_bank_code values(1414,'富勋资产管理');

 insert into cfg_bridge_order_acception_bank_code values(1440,'深圳市世联小额贷款有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1442,'江苏紫金农村商业银行股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1460,'上海逸牧资产');

 insert into cfg_bridge_order_acception_bank_code values(1485,'平顶山银行');

 insert into cfg_bridge_order_acception_bank_code values(1500,'牡丹江通达小额贷款有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1502,'新华信托股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1504,'温州银行');

 insert into cfg_bridge_order_acception_bank_code values(1508,'米仓财行');

 insert into cfg_bridge_order_acception_bank_code values(1514,'北京宝瑞通典当行');

 insert into cfg_bridge_order_acception_bank_code values(1522,'沧州银行');

 insert into cfg_bridge_order_acception_bank_code values(1526,'衡水银行');

 insert into cfg_bridge_order_acception_bank_code values(1534,'国美金融');

 insert into cfg_bridge_order_acception_bank_code values(1536,'深圳市强业投资担保有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1562,'新网银行');

 insert into cfg_bridge_order_acception_bank_code values(1566,'上海宏获资产管理有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1574,'深圳市银顺通小额贷款有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1576,'广州拉卡拉网络小额贷款有限责任公司');

 insert into cfg_bridge_order_acception_bank_code values(1577,'四川信托有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1581,'海宁皮革城担保有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1584,'深圳市领达小额贷款有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1585,'中国人民财产保险股份有限公司深圳市分公司新洲支公司');

 insert into cfg_bridge_order_acception_bank_code values(1586,'杭州市江干区万事利科创小额贷款股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1620,'重庆市南川石银村镇银行股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1646,'常熟农商银行');

 insert into cfg_bridge_order_acception_bank_code values(1647,'苏南村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1648,'大连银行');

 insert into cfg_bridge_order_acception_bank_code values(1650,'海南银行');

 insert into cfg_bridge_order_acception_bank_code values(1667,'晋城银行');

 insert into cfg_bridge_order_acception_bank_code values(1687,'威海蓝海银行股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1690,'上海华瑞银行');

 insert into cfg_bridge_order_acception_bank_code values(1695,'河北大厂农村商业银行营业部');

 insert into cfg_bridge_order_acception_bank_code values(1699,' 双流诚民村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1701,'广东华兴银行');

 insert into cfg_bridge_order_acception_bank_code values(1702,'莱商银行');

 insert into cfg_bridge_order_acception_bank_code values(1704,'四川宣汉农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1705,'长城华西银行');

 insert into cfg_bridge_order_acception_bank_code values(1706,'上海浦东恒通村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1707,'重庆市江津石银村镇银行股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1709,'东莞市大朗东盈村镇银行股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1728,'海口联合农村商业银行股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1749,'承德银行');

 insert into cfg_bridge_order_acception_bank_code values(1754,'重庆南川石银村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1756,'佛山农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1345,'重庆银行');

 insert into cfg_bridge_order_acception_bank_code values(1404,'泛华金融');

 insert into cfg_bridge_order_acception_bank_code values(1410,'超能金融');

 insert into cfg_bridge_order_acception_bank_code values(1420,'信桥金融');

 insert into cfg_bridge_order_acception_bank_code values(1464,'上海邦成典当有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1480,'郑州银行');

 insert into cfg_bridge_order_acception_bank_code values(1491,'重庆海尔小额贷款有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1506,'武汉众邦银行');

 insert into cfg_bridge_order_acception_bank_code values(1510,'中融鸿泰众筹资产管理（北京）有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1516,'中航信托股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1524,'上海浦东新区鑫隆小额贷款股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1532,'一点钱投资控股有限公司 ');

 insert into cfg_bridge_order_acception_bank_code values(1545,'中国对外经济贸易信托有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1560,'赚赚金融');

 insert into cfg_bridge_order_acception_bank_code values(1564,'大华银行');

 insert into cfg_bridge_order_acception_bank_code values(1568,'华鑫国际信托有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1569,'芜湖金坤小额贷款股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1570,'河北银行');

 insert into cfg_bridge_order_acception_bank_code values(1582,'重庆两江新区寰润小额贷款有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1600,'深圳德昌利金融服务有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1601,'河北南和农村商业银行股份有限公司邵屯支行');

 insert into cfg_bridge_order_acception_bank_code values(1602,'北京大兴九银村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1605,'上海市徐汇公证处');

 insert into cfg_bridge_order_acception_bank_code values(1607,'三湘银行');

 insert into cfg_bridge_order_acception_bank_code values(1609,'渤海国际信托');

 insert into cfg_bridge_order_acception_bank_code values(1621,' 焦作中旅银行');

 insert into cfg_bridge_order_acception_bank_code values(1640,'吴江农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1641,'中国邮政储蓄银行');

 insert into cfg_bridge_order_acception_bank_code values(1644,'攀枝花市商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1645,'苏州银行');

 insert into cfg_bridge_order_acception_bank_code values(1649,'双流诚民村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1653,'成都银行');

 insert into cfg_bridge_order_acception_bank_code values(1670,'湖北银行股份有限公司');

 insert into cfg_bridge_order_acception_bank_code values(1671,'湖北银行武汉分行营业部');

 insert into cfg_bridge_order_acception_bank_code values(1689,' 燕郊信用社');

 insert into cfg_bridge_order_acception_bank_code values(1693,'浙江泰隆商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1698,'三水区农村信用社');

 insert into cfg_bridge_order_acception_bank_code values(1703,'达州农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1708,'北京怀柔融兴村镇银行有限责任公司');

 insert into cfg_bridge_order_acception_bank_code values(1727,'北京密云汇丰村镇银行');

 insert into cfg_bridge_order_acception_bank_code values(1746,'河北南和农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1750,'新都桂城村镇银行有限责任公司');

 insert into cfg_bridge_order_acception_bank_code values(1751,'广州农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1753,'广东南海农村商业银行');

 insert into cfg_bridge_order_acception_bank_code values(1755,'盛京银行');

insert into cfg_bridge_order_busi_type values(1,'--请选择--');
insert into cfg_bridge_order_busi_type values(2,'交易');
insert into cfg_bridge_order_busi_type values(3,'非交易');

insert into cfg_bridge_order_city values(1,'--请选择--');
insert into cfg_bridge_order_city values(2,'北京市');
insert into cfg_bridge_order_marriage values(1,'--请选择--');
insert into cfg_bridge_order_marriage values(2,'已婚');
insert into cfg_bridge_order_marriage values(3,'未婚');
insert into cfg_bridge_order_marriage values(4,'离异');
insert into cfg_bridge_order_marriage values(5,'丧偶');
insert into cfg_bridge_order_pay_type values(1,'--请选择--');
insert into cfg_bridge_order_pay_type values(2,'标准业务');
insert into cfg_bridge_order_pay_type values(3,'非标准业务');
insert into cfg_bridge_order_product_id values(1,'--请选择--');
insert into cfg_bridge_order_product_id values(2,'赎楼贷（交易）');
insert into cfg_bridge_order_product_id values(3,'赎楼贷（非交易）');
insert into cfg_bridge_order_product_id values(4,'提放贷（交易）-赎楼即放款');
insert into cfg_bridge_order_product_id values(5,'提放贷（交易）-过户即放款');
insert into cfg_bridge_order_product_id values(6,'提放贷（非交易）-赎楼即放款');
insert into cfg_bridge_order_product_id values(7,'提放贷（非交易）-抵押即放款');
insert into cfg_bridge_order_product_id values(8,'代购');
insert into cfg_bridge_order_product_id values(9,'二押贷（赎）');
insert into cfg_bridge_order_sex values(1,'--请选择--');
insert into cfg_bridge_order_sex values(2,'男');
insert into cfg_bridge_order_sex values(3,'女');

insert into cfg_new_load_condition values(1,'--请选择--');
insert into cfg_new_load_condition values(2,'他证');
insert into cfg_new_load_condition values(3,'回执');
insert into cfg_new_load_condition values(4,'其他');
insert into cfg_new_load_way values(1,'--请选择--');
insert into cfg_new_load_way values(2,'抵押贷');
insert into cfg_new_load_way values(3,'按揭贷');
insert into cfg_new_load_way values(4,'公积金');
insert into cfg_new_load_way values(5,'组合贷');
insert into cfg_new_load_way values(6,'一次性付款');
insert into cfg_original_loan_bank values(1,'--请选择--');
insert into cfg_original_loan_foreclosure_type values(1,'--请选择--');
insert into cfg_original_loan_foreclosure_type values(2,'柜台手动扣款');
insert into cfg_original_loan_foreclosure_type values(3,'系统自动扣款');
insert into cfg_original_loan_foreclosure_type values(4,'客户经理手动操作');
insert into cfg_original_loan_foreclosure_type values(5,'APP操作扣款');
insert into cfg_original_loan_foreclosure_type values(6,'网银操作扣款');
insert into cfg_original_loan_foreclosure_type values(7,'电话银行预约扣款');
insert into cfg_original_loan_foreclosure_type values(8,'预存系统扣款');
insert into cfg_original_loan_organ_type values(1,'--请选择--');
insert into cfg_original_loan_organ_type values(2,'银行');
insert into cfg_original_loan_organ_type values(3,'机构');
insert into cfg_original_loan_organ_type values(4,'个人');
insert into cfg_original_loan_type values(1,'--请选择--');
insert into cfg_original_loan_type values(2,'抵押贷');
insert into cfg_original_loan_type values(3,'按揭贷');
insert into cfg_original_loan_type values(4,'公积金');








select * from t_bridgecbs_bridge_Order;






insert into cfg_bridge_order_certi_type values(1,'--请选择--');
insert into cfg_bridge_order_certi_type values(2,'身份证');
insert into cfg_bridge_order_certi_type values(3,'回乡证(仅港澳)');
insert into cfg_bridge_order_certi_type values(4,'营业执照');
insert into cfg_bridge_order_public_fund_bank select id,name from cfg_bridge_order_acception_bank_code;
insert into cfg_bridge_order_watch_bank select id,name from cfg_bridge_order_acception_bank_code;


select * from t_hr_dept;
select * from t_sales_agent;
select * from t_sales_group;
select * from t_util_format_info where ch_name like '%快出%';



insert cfg_cbs_order_state(id,name,busi_type)values (129,'确认下家已放款',1);
insert t_util_work_flow (after_state, before_state, create_time, creator, state, trans_condition, update_time, updator, work_type, action_id, busi_type, position_id, button_id)values
  (129,124,sysdate(),0,1,null,sysdate(),0,1,58,2,12,120);
insert t_hr_action (create_time, creator, name, state, update_time, updator, busi_type)
    values (sysdate(),0,'跟踪下家放款进度',1,sysdate(),0,2);
insert t_ums_resource (create_time, creator, name, parent_id, res_url, state, type, update_time, updator, column_name, value_set, grade,busi_type)
    values (sysdate(),0,'确认下家已放款',2,'/order/edit',1,2,sysdate(),0,null,null,3);
update t_util_work_flow set before_state = 129 where id = 33;
update `t_util_work_flow` set `position_id`  = 7 where id = 39;
update `gzx`.`t_util_format_info` set `can_modify_role_set`='7' where `id`='30';
update `gzx`.`t_util_format_info` set `can_modify_role_set`='7' where `id`='31';
select * from t_cbs_order where last_amount is null;
update t_cbs_order set last_amount = 1000000;
select * from t_sales_agent where id = 9;
select * from t_hr_employee;
select * from t_sales_performance_commission;
update t_hr_employee set dept=9;
select * From t_sales_performance_commission where saler_id in (0,1,2,3,4,5,8,9);
select * from t_sales_agent;
select distinct dept from t_hr_employee where state = 1;
select * from t_hr_dept;
select * from t_ums_user;

select (50000/1.03 + 50000/(1.03*1.03)+50000)*pow(1.03,15);
select * from t_sales_agent where group_id = 2;
delete from t_hr_dept where dd_id is null;
select * from t_ums_resource;
select * from t_hr_action;
select * from t_util_work_flow;
select * from t_hr_position;
select * from cfg_format_info_client_mapping;
select * from cfg_cbs_order_state;
select * from t_util_format_info;
insert into t_util_format_info (busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, need_step, scatter_obj, state, update_time, updator, who_object, can_modify_role_set, can_see_role_set)
    values (2,null,sysdate(),0,4,'signDate',2,'112,114',null,1,sysdate(),0,1);
select * from cfg_cbs_order_state;
update t_util_format_info set state = 1,en_name='signDate' where  id = 14;
update `gzx`.`t_hr_action` set `name`='从下家扣款' where `id`='18';
select * from t_util_format_info where ch_name like '%放款日期%';

select * from t_finance_payment;
select * from cfg_payment_pay_type where name like '%实收%';

select * from t_cbs_order where id = 116;
select * from t_cbs_order_pool where order_id = 116;
select * From t_ums_user where id = 15;
select * from t_sales_agent where dd_user_name is not null;
update t_sales_agent set dd_user_name = '045263345421425871' where id = 9;
select * from t_hr_employee;
select * from t_ums_user;
update t_ums_user set dduser_name = '045263345421425871' where id= 16;
select * from t_sales_agent;
select * from t_util_format_info where need_step = -1;
select * from cfg_cbs_order_state;
select * from t_util_work_flow where before_state = 117;
update t_util_work_flow set trans_condition = 'organAmount!=0?1:0' where id = 25;
SELECT table_name from information_schema.columns where TABLE_SCHEMA='gzx' and COLUMN_NAME='busi_type';

update t_format_info_obj set self_amount = 0,organ_amount=1000000;
select * from t_cbs_order_log where order_id = 114;
update t_cbs_order_log set action_id=  0;
update  t_hr_employee set dd_user_name = '045254653829320258',dept =9 where id = 8;
update  t_hr_employee set dd_user_name = '045263345421425871',dept =10 where id = 10;
update  t_hr_employee set dd_user_name = 'manager8154',dept=11 where id = 7;
delete from t_hr_employee where id > 39;
update t_util_format_info set state =100  where ch_name like '%下家名称%';

select * from t_hr_employee;
select business_type from t_cbs_order where business_type is null;
select * from  t_cbs_order;
update t_cbs_order set last_org_type = 1;
select * from t_sales_agent;

insert into t_util_work_flow
(after_state, before_state, create_time, creator, state, trans_condition, updator, work_type, action_id, busi_type, position_id, button_id) values
  (119,117,sysdate(),0,1,'organAmount==0?1:0',0,1,13,2,14,92);
insert into t_util_work_flow
(after_state, before_state, create_time, creator, state, trans_condition, updator, work_type, action_id, busi_type, position_id, button_id) values
  (120,117,sysdate(),0,1,'organAmount==0?1:0',0,1,13,2,14,93);

select * from t_util_work_flow;

insert into t_util_format_info (busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, need_step, scatter_obj, state, updator, who_object, can_modify_role_set, can_see_role_set) values
  (2,'渠道金额',sysdate(),0,5,'organAmount',2,107,null,1,0,1,6,'2,7,16,14,6,11,12,8');
insert into t_util_format_info (busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, need_step, scatter_obj, state, updator, who_object, can_modify_role_set, can_see_role_set) values
  (2,'自有金额',sysdate(),0,5,'selfAmount',2,107,null,1,0,1,6,'2,7,16,14,6,11,12,8');


select * from t_cbs_order_pool where do_state = 2;

select * from t_cbs_order ;
select * from t_cbs_order order by id desc;
select * from t_cbs_order_pool where order_id = 111;
select * from t_batch_job;
select * from t_batch_BTask;
select * From t_util_calc_formula;

update t_util_calc_formula a set a.expression = replace(a.expression,'amount','selfAmount')  where a.expression like '%amount%';

select * from t_hr_employee;
select * from t_util_calc_formula;
select * from cfg_reminder_type;
update cfg_reminder_type set name = '关键节点提醒' where id = 1;
update cfg_reminder_type set name = '业务类通知' where id = 3;
select * from t_util_reminder;
select * from t_cbs_order order by id desc;
select * from t_cbs_order_log where order_id in (98,99,101);

select * from cfg_reminder_way;
select * from t_util_reminder_log where order_id = 102;
update t_util_reminder_log set state = 100 where id = 4;
insert into cfg_reminder_way (name)values ('钉钉');
insert into cfg_reminder_way (name)values ('短信');
insert into cfg_reminder_way (name)values ('微信');
insert into cfg_reminder_way (name)values ('全部');
update cfg_reminder_way set id = 0 where id = 4;
alter table t_util_reminder drop column users;

select * from t_cbs_order where id = 103;

select * from t_cbs_order where id in (104,105,109);
select * from t_cbs_order where state <> 100 and order_state <> 127;
select * from t_cbs_order_pool where order_id = 104;
select * from t_format_info_obj where order_id in(102,104,109);
select * from t_hr_position;
select * From t_ums_user where id = 14;
select * from cfg_cbs_order_state;
select * from t_sales_agent;
select * from t_sales_commission;
update t_cbs_order_log set action_id = 0 ;
select * from t_cbs_order_pool where order_id = 114 and do_state = 2;
select * from t_cbs_order where id = 114;
select * from t_hr_employee where user_id = 15;
select * from t_cbs_order_log where order_id = 114;
select * from t_util_work_flow where before_state = 113;
select * from t_hr_position where id=  7;
select * from t_hr_employee where position = 7;
select now();
select * from t_cbs_order_pool where order_id  = 110;
select * from t_hr_position where id = 15;
select * from t_hr_employee where position = 15;

select * from t_ums_resource where name like '%下户%';
select * from t_hr_employee where state <> 100;
update t_hr_employee set user_id = 1 where id  =7;
select * from t_ums_user;

select * from cfg_cbs_order_state;
select * from cfg_payment_pay_type;
select * from t_hr_position where state = 1;
select * from t_util_work_flow where after_state =119;
select * from t_cbs_product;
select * from t_cbs_order;
select * from t_hr_action;
select * from t_util_calc_formula;
select * from t_util_work_flow;
select * from t_cbs_order_product;
select * from t_cbs_order_pool;
select * from t_hr_position where id = 14;
select * from t_ums_resource where id = 93;
select * from t_util_format_info where ch_name like '%领取%';
select * from t_hr_action;
insert into t_hr_action (create_time, creator, name, state, updator, busi_type)
values(sysdate(),0,'分配处理人',1,0,2);

update t_util_work_flow set state = 1 where id = 25;
update t_util_work_flow set before_state = 128 where id in (26,27);
insert into t_util_work_flow (after_state, before_state, create_time, creator, state, trans_condition, updator, work_type, action_id, busi_type, position_id, button_id) values
  (128,118,sysdate(),0,1,null,0,1,56,2,8,117);
insert into t_hr_action (create_time, creator, name, state, updator, busi_type) values
  (sysdate(),0,'确认机构通过',1,0,2);
update t_ums_resource set name = '上报机构' where id = 91;
insert t_ums_resource (create_time, creator, name, parent_id, res_url, state, type, updator, column_name, value_set, grade,busi_type)
    values (sysdate(),0,'确认机构通过',2,'/order/edit',1,2,0,null,null,3);
update t_util_work_flow set action_id = 13 where before_state = 128;

select * from t_hr_action where before_state = 128;
select * from t_cbs_order_log where order_id = 96 and button_id <>0;
select * from t_cbs_order_log where order_id = 96 and format_info_id  <>0;

update t_util_work_flow set action_id = 1 where before_state = 102; #初审
update t_util_work_flow set action_id = 2 where before_state = 103; #检查订单或关闭
update t_util_work_flow set action_id = 3 where before_state = 105; #初审复核
update t_util_work_flow set action_id = 4 where before_state = 104; #补充资料
update t_util_work_flow set action_id = 5 where before_state = 107; #复审
update t_util_work_flow set action_id = 6 where before_state = 108; #收下户费
update t_util_work_flow set action_id = 2 where before_state = 109; #检查订单或关闭
update t_util_work_flow set action_id = 4 where before_state = 110; #补充资料
update t_util_work_flow set action_id = 7 where before_state = 111; #下户
update t_util_work_flow set action_id = 8 where before_state = 112; #签约
update t_util_work_flow set action_id = 9 where before_state = 113; #汇审
update t_util_work_flow set action_id = 8 where before_state = 114; #签约
update t_util_work_flow set action_id = 10 where before_state = 115; #关闭
update t_util_work_flow set action_id = 11 where before_state = 116; #收利息和律师费
update t_util_work_flow set action_id = 12 where before_state = 117; #上报机构
update t_util_work_flow set action_id = 13 where before_state = 118; #终审
update t_util_work_flow set action_id = 14 where before_state = 119; #放款
update t_util_work_flow set action_id = 10 where before_state = 120; #关闭
update t_util_work_flow set action_id = 15 where before_state = 121; #关注上家扣款
update t_util_work_flow set action_id = 16 where before_state = 122; #领解抵押材料
update t_util_work_flow set action_id = 17 where before_state = 123; #去下家抵押
update t_util_work_flow set action_id = 18 where before_state = 124; #关注下家放款
update t_util_work_flow set action_id = 19 where before_state = 125; #和客户交接材料
update t_util_work_flow set action_id = 20 where before_state = 126; #给客户打印交接单，完结订单

delete from  t_hr_action  where id <>0;

select * from t_cbs_order where id = 96;
select distinct(before_state) from t_util_work_flow;
select * from t_hr_action where id = 5;
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (1,sysdate(),0,'初审',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (2,sysdate(),0,'检查订单或关闭',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (3,sysdate(),0,'初审复核',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (4,sysdate(),0,'补充资料',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (5,sysdate(),0,'复审',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (6,sysdate(),0,'收下户费',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (7,sysdate(),0,'下户',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (8,sysdate(),0,'签约',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (9,sysdate(),0,'汇审',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (10,sysdate(),0,'关闭',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (11,sysdate(),0,'收利息和律师费',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (12,sysdate(),0,'上报机构',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (13,sysdate(),0,'终审',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (14,sysdate(),0,'放款',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (15,sysdate(),0,'关注上家扣款',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (16,sysdate(),0,'领解抵押材料',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (17,sysdate(),0,'去下家抵押',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (18,sysdate(),0,'关注下家放款',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (19,sysdate(),0,'和客户交接材料',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (20,sysdate(),0,'给客户打印交接单，完结订单',1,0,2);

update t_hr_action set name = '下家抵押' where id = 17;

select * from t_hr_action;
select * from t_util_work_flow;
select * from cfg_cbs_order_state;
select * from t_ums_resource where id = 72;



update t_ums_resource set name = '确认领取解押材料' where id = 96;
update t_ums_resource set name = '确认材料完成交接' where id = 99;
select * from t_util_format_info where ch_name like '%身份证号%';
select * from t_ums_resource where name like '%交接%';

select * from t_hr_action;
delete from t_hr_action where state =100;

select * from t_sales_performance_comm_detail where order_id = 94;
select * from t_sales_performance_commission;
select * from t_cbs_order where id = 94;

update cfg_account_account_state set id = 0 where name='全部';
update cfg_account_balance set id = 0 where name='全部';
update cfg_account_bank set id = 0 where name='全部';
update cfg_account_company set id = 0 where name='全部';
update cfg_accounting_period_period_state set id = 0 where name='全部';
update cfg_accounting_rule_fee_type set id = 0 where name='全部';
update cfg_agent_business_type set id = 0 where name='全部';
update cfg_agent_channel_type set id = 0 where name='全部';
update cfg_attendance_ask_type set id = 0 where name='全部';
update cfg_balance_credit set id = 0 where name='全部';
update cfg_balance_debit set id = 0 where name='全部';
update cfg_btask_result set id = 0 where name='全部';
update cfg_calc_formula_type set id = 0 where name='全部';
update cfg_cbs_business_type set id = 0 where name='全部';
update cfg_cbs_cust_city set id = 0 where name='全部';
update cfg_cbs_estate_area set id = 0 where name='全部';
update cfg_cbs_estate_type set id = 0 where name='全部';
update cfg_cbs_identity_type set id = 0 where name='全部';
update cfg_cbs_order_state set id = 0 where name='全部';
update cfg_cbs_pay_interest_way set id = 0 where name='全部';
update cfg_cbs_pay_way set id = 0 where name='全部';
update cfg_cbs_period_type set id = 0 where name='全部';
update cfg_cbs_prod_bank set id = 0 where name='全部';
update cfg_cbs_prod_type set id = 0 where name='全部';
update cfg_cbs_rend_object set id = 0 where name='全部';
update cfg_certificate_certi_state set id = 0 where name='全部';
update cfg_certificate_type set id = 0 where name='全部';
update cfg_commission_base_type set id = 0 where name='全部';
update cfg_commission_business_type set id = 0 where name='全部';
update cfg_commission_channel_type set id = 0 where name='全部';
update cfg_commission_level set id = 0 where name='全部';
update cfg_commission_product_type set id = 0 where name='全部';
update cfg_commission_type set id = 0 where name='全部';
update cfg_commission_way set id = 0 where name='全部';
update cfg_cswork_cs_state set id = 0 where name='全部';
update cfg_cswork_cstype set id = 0 where name='全部';
update cfg_curriculum_pos_id set id = 0 where name='全部';
update cfg_curriculum_type set id = 0 where name='全部';
update cfg_cust_city set id = 0 where name='全部';
update cfg_cust_info_original set id = 0 where name='全部';
update cfg_cust_is_new_stockholder set id = 0 where name='全部';
update cfg_cust_job set id = 0 where name='全部';
update cfg_cust_sales_state set id = 0 where name='全部';
update cfg_cust_sex set id = 0 where name='全部';
update cfg_cust_why_borrow set id = 0 where name='全部';
update cfg_employee_city set id = 0 where name='全部';
update cfg_employee_manage_grade set id = 0 where name='全部';
update cfg_employee_position_type set id = 0 where name='全部';
update cfg_employee_tech_grade set id = 0 where name='全部';
update cfg_format_info_client_mapping set id = 0 where name='全部';
update cfg_format_info_data_type set id = 0 where name='全部';
update cfg_format_info_if_scatter set id = 0 where name='全部';
update cfg_format_info_who_object set id = 0 where name='全部';
update cfg_group_grade set id = 0 where name='全部';
update cfg_job_type set id = 0 where name='全部';
update cfg_knowledge_question_type set id = 0 where name='全部';
update cfg_order_doc_type set id = 0 where name='全部';
update cfg_organ_type set id = 0 where name='全部';
update cfg_paraters set id = 0 where name='全部';
update cfg_payment_in_out set id = 0 where name='全部';
update cfg_payment_offset set id = 0 where name='全部';
update cfg_payment_pay_data_type set id = 0 where name='全部';
update cfg_payment_pay_state set id = 0 where name='全部';
update cfg_payment_pay_type set id = 0 where name='全部';
update cfg_performance_commission_process set id = 0 where name='全部';
update cfg_position_dept_id set id = 0 where name='全部';
update cfg_position_is_commission set id = 0 where name='全部';
update cfg_prod_interest_period_type set id = 0 where name='全部';
update cfg_product_bank_id set id = 0 where name='全部';
update cfg_product_end_date set id = 0 where name='全部';
update cfg_product_interest_way set id = 0 where name='全部';
update cfg_product_product_state set id = 0 where name='全部';
update cfg_product_product_type set id = 0 where name='全部';
update cfg_resource_parent_id set id = 0 where name='全部';
update cfg_resource_type set id = 0 where name='全部';
update cfg_role_resource_type set id = 0 where name='全部';
update cfg_salary_extend_state set id = 0 where name='全部';
update cfg_task_end_date set id = 0 where name='全部';
update cfg_task_task_period set id = 0 where name='全部';
update cfg_task_task_state set id = 0 where name='全部';
update cfg_task_type set id = 0 where name='全部';
update cfg_tel_sales_result set id = 0 where name='全部';
update cfg_tel_sales_task_delay set id = 0 where name='全部';
update cfg_work_flow_after_state set id = 0 where name='全部';
update cfg_work_flow_befor_state set id = 0 where name='全部';
update cfg_work_flow_work_type set id = 0 where name='全部';
update cfg_work_order_cs_state set id = 0 where name='全部';
update cfg_work_order_cstype set id = 0 where name='全部';
update t_bank set id = 0 where name='全部';
update t_batch_btask set id = 0 where name='全部';
update t_batch_job set id = 0 where name='全部';
update t_cbs_certi_log set id = 0 where name='全部';
update t_cbs_certificate set id = 0 where name='全部';
update t_cbs_order set id = 0 where name='全部';
update t_cbs_order_doc set id = 0 where name='全部';
update t_cbs_order_log set id = 0 where name='全部';
update t_cbs_order_pool set id = 0 where name='全部';
update t_cbs_order_prod_cust set id = 0 where name='全部';
update t_cbs_order_product set id = 0 where name='全部';
update t_cbs_prod_interest set id = 0 where name='全部';
update t_cbs_product set id = 0 where name='全部';
update t_cbs_product_rule set id = 0 where name='全部';
update t_crm_cust set id = 0 where name='全部';
update t_cs_knowledge set id = 0 where name='全部';
update t_cs_work_order set id = 0 where name='全部';
update t_cust_company set id = 0 where name='全部';
update t_cust_credit set id = 0 where name='全部';
update t_cust_mortgage set id = 0 where name='全部';
update t_customer set id = 0 where name='全部';
update t_finance_account set id = 0 where name='全部';
update t_finance_accounting_entry set id = 0 where name='全部';
update t_finance_accounting_period set id = 0 where name='全部';
update t_finance_accounting_rule set id = 0 where name='全部';
update t_finance_balance set id = 0 where name='全部';
update t_finance_payment set id = 0 where name='全部';
update t_format_info_obj set id = 0 where name='全部';
update t_hr_action set id = 0 where name='全部';
update t_hr_attendance set id = 0 where name='全部';
update t_hr_curriculum set id = 0 where name='全部';
update t_hr_dept set id = 0 where name='全部';
update t_hr_emp_log set id = 0 where name='全部';
update t_hr_employee set id = 0 where name='全部';
update t_hr_employee_position set id = 0 where name='全部';
update t_hr_position set id = 0 where name='全部';
update t_hr_salary set id = 0 where name='全部';
update t_mis_period set id = 0 where name='全部';
update t_mis_task set id = 0 where name='全部';
update t_order_paras set id = 0 where name='全部';
update t_prod_bank set id = 0 where name='全部';
update t_sales_agent set id = 0 where name='全部';
update t_sales_commission set id = 0 where name='全部';
update t_sales_group set id = 0 where name='全部';
update t_sales_performance_comm_detail set id = 0 where name='全部';
update t_sales_performance_commission set id = 0 where name='全部';
update t_sales_tel_sales set id = 0 where name='全部';
update t_ums_resource set id = 0 where name='全部';
update t_ums_role set id = 0 where name='全部';
update t_ums_role_privilege set id = 0 where name='全部';
update t_ums_role_resource set id = 0 where name='全部';
update t_ums_user set id = 0 where name='全部';
update t_ums_user_role set id = 0 where name='全部';
update t_user_behavior_log set id = 0 where name='全部';
update t_user_role set id = 0 where name='全部';
update t_util_calc_formula set id = 0 where name='全部';
update t_util_calc_param set id = 0 where name='全部';
update t_util_format_info set id = 0 where name='全部';
update t_util_work_flow set id = 0 where name='全部';



select * from BATCH_STEP_EXECUTION;
# BATCH_JOB_EXECUTION
# BATCH_JOB_EXECUTION_CONTEXT
# BATCH_JOB_EXECUTION_PARAMS
# BATCH_JOB_EXECUTION_SEQ
# BATCH_JOB_INSTANCE
# BATCH_JOB_SEQ
# BATCH_STEP_EXECUTION
# BATCH_STEP_EXECUTION_CONTEXT
# BATCH_STEP_EXECUTION_SEQ

select * from t_util_format_info where ch_name in('卷齐日期','证件收押日期');
select a.big_data_date from t_format_info_obj a where order_id = 90;
update t_util_format_info set state = 100 where id = 64;
select *  from t_cbs_order where id = 90;

select * from t_util_format_info where ch_name like '%下家%';



select * from t_hr_employee;
update cfg_group_grade set id = 0  where id =3;
update t_hr_dept set name = '全部'  where id = 0;
insert into cfg_cbs_period_type values (3,'七天');
select * from t_hr_position;
select * from cfg_cbs_prod_bank;
select * from cfg_cbs_period_type;
select * from t_sales_performance_commission;
select * from cfg_group_grade;
select * from t_util_format_info where can_modify_role_set like '%8%' and need_step not like '%102%';
select * from t_util_format_info where need_step like '%102%' and state =1 ;
update t_util_format_info t set data_type = 3 where ch_name in ('房屋坐落','产权证号','解押材料');

select * from information_schema.tables where table_schema='gzx' and table_type='BASE TABLE';

select * from cfg_cbs_order_state;
select * from cfg_cbs_business_type;
select * from t_ums_resource where type = 2;
select * from t_cbs_order order by id desc;
select * from cfg_cbs_business_type;
select house_type from t_format_info_obj where order_id=86;
update cfg_cbs_order_state set id = 0 where id = 130;

select * from t_cbs_order_pool where user_id in(13,15,16) and do_state = 2;

select * from t_hr_position where state = 1;

select * from t_sales_agent where channel_type =2;
update t_sales_agent set name = '全部' where id=0;
update t_sales_agent set user_id = 15 where id = 8;
select * from t_hr_employee where user_id = 16;
select * from t_hr_employee where position = 11;
select * from t_ums_user where state =1;

update t_hr_employee set name = '张小溪' where id = 15;

select * from t_cbs_order_pool where order_id = 89;
update t_cbs_order_pool set user_id = 15 where id = 233;

select * from t_finance_payment where order_id = 89;

select * from t_hr_employee where position = 11;
select * from t_sales_agent where channel_type = 1;

select * from t_util_format_info where need_step = 122;
update t_util_format_info set need_step = -1 where id in (52,55,56,62)
ALTER TABLE t_format_info_obj MODIFY title_certificateno varchar(500);
select * from cfg_order_doc_type;
select * from t_cbs_order where id in(71,87,88,89,90);
select * from t_format_info_obj where order_id = 89;
select * from t_cbs_order_doc where order_id = 88 and doc_type =1 ;
delete from t_cbs_order_doc where id = 104;
update t_cbs_order_doc set doc_type = 1 where order_id = 88;

select * from t_util_format_info where ch_name like '%展期%';
update t_util_format_info set need_step = -1 where id in (36,37);
update t_sales_agent set dd_user_name = 'manager8154' where id = 8;

select * from t_cust_mortgage where order_id = 91;
select * from t_sales_agent;
select * From t_util_work_flow where after_state = 102 and button_id = 72;
select * from t_cbs_order_log where order_id in (79,80);
select * from t_cbs_order_pool where order_id in (91);
select * from t_cbs_order_doc where order_id in (79,80);
select * from t_ums_user where id = 14;
select * from t_ums_resource where parent_id=0;
select * from cfg_format_info_who_object;
update cfg_format_info_who_object set id = 0 where id = 1;
select * from t_ums_user;
select * from t_format_info_obj;
insert into cfg_format_info_who_object(id,name)values(0,'全部');
insert into cfg_format_info_who_object(id,name)values(1,'Order');
insert into cfg_forma_info_who_object(id,name)values(2,'否');
insert into cfg_format_info_data_type(id,name)values(3,'String');
insert into cfg_format_info_data_type(id,name)values(4,'Date');
insert into cfg_format_info_data_type(id,name)values(5,'BigDecimal');

select concat('update t_format_info_obj set ',en_name,'=1') from t_util_format_info where if_scatter=1;

update t_util_format_info set if_scatter = 1 where id = 73;
update t_util_format_info set can_modify_role_set = '(1,2,4,5,6,7,9,10,11,12,13)',can_see_role_set= '(1,2,4,5,6,7,9,10,11,12,13)';

select * from cfg_certificate_type;
select * from cfg_certificate_certi_state;
update cfg_certificate_certi_state set id = 0 where id = 1;
insert into cfg_certificate_type(id,name)values(0,'全部');
insert into cfg_certificate_type(id,name)values(1,'身份证');
insert into cfg_certificate_type(id,name)values(2,'房产证');
insert into cfg_certificate_certi_state (id,name)values(0,'全部');
insert into cfg_certificate_certi_state (id,name)values(1,'收押中');
insert into cfg_certificate_certi_state (id,name)values(2,'出借中');
insert into cfg_certificate_certi_state (id,name)values(3,'已归还');
insert into cfg_certificate_certi_state (id,name)values(4,'免归还');

select * from t_ums_role;
update t_ums_role set id = 0 where id = 14;

delete from t_cbs_order where id in (77,78);
delete from t_cbs_order_pool where order_id in (91);
delete from t_cbs_order_log where order_id in (77,78);
delete from t_cbs_order_doc where order_id in (77,78);

select * from cfg_cbs_business_type;
select * from t_util_format_info where ch_name like '%签约%';
select * from BATCH_JOB_EXECUTION;

update t_util_format_info set state = 100 where id = 53;

select * from t_format_info_obj where order_id = 84;
update t_format_info_obj set state = 1;
select * from t_util_work_flow where before_state = 101 and busi_type =2;
select * from cfg_order_doc_type;
insert into cfg_order_doc_type(ch_name,en_name) values('身份证明','certificate');
insert into cfg_order_doc_type(ch_name,en_name) values('婚姻证明','marriage');
insert into cfg_order_doc_type(ch_name,en_name) values('户口本','householdRegister');
insert into cfg_order_doc_type(ch_name,en_name) values('诉讼材料','litigationMaterials');
insert into cfg_order_doc_type(ch_name,en_name) values('征信','creditReporting');
insert into cfg_order_doc_type(ch_name,en_name) values('房产证','propertyOwnership');

select * from t_cbs_certi_log;
select * from t_cbs_order order by id desc;
update t_format_info_obj set marital_status=1;
update t_format_info_obj set house_type=1;
update t_format_info_obj set if_extension=1;
update t_format_info_obj set up_if_overdue=1;
update t_format_info_obj set up_if_house_deposit=1;
update t_format_info_obj set next_if_limit_purpose=1;
update t_format_info_obj set next_if_notarization=1;
update t_format_info_obj set next_loan_way=1;
update t_format_info_obj set next_capital_account_provider=1;

select pay_interest_alert_date from t_format_info_obj where order_id = 80;
delete from t_cbs_order_doc where order_id = 84;
select * from cfg_order_doc_type;
update t_cbs_order_doc set doc_type=1 where order_id= 80;
select * from t_format_info_obj where order_id = 84 and state = 1;
select * from t_util_format_info where data_type=1 and if_scatter = 2;
update t_util_format_info set can_modify_role_set = '1,2,4,5,6,7,9,10,11,12,13',can_see_role_set='1,2,4,5,6,7,9,10,11,12,13' where can_modify_role_set is null;
select
  case
  when data_type=1 then CONCAT('private int ',en_name,';')
  when data_type=2 then CONCAT('private long ',en_name,';')
  when data_type=3 then CONCAT('private String ',en_name,';')
  when data_type=4 then CONCAT('private Date ',en_name,';')
  when data_type=5 then CONCAT('private BigDecimal ',en_name,';')
  end data_type
from t_util_format_info
where create_time > sysdate()-1000;

select * From t_util_calc_formula where expression like '%%';
select * from cfg_format_info_client_mapping;
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)values()

update t_util_format_info set scatter_obj='YesNo' where ch_name like '%是否%';
update t_util_format_info set ch_name = '是否带用途批' where id = 70;
update t_util_format_info set ch_name = '房本是否收押' where id = 63;

select * from t_util_format_info where ch_name like '%下家机构%';

select * from t_util_format_info where need_step = 0 and state = 1;
update t_util_format_info set need_step = -1 where id in (49);

select * from cfg_cbs_estate_area;
update cfg_cbs_estate_area set id = 0 where id = 23;

delete from t_util_format_info where id = 84;
update t_util_format_info set state=100 where id = 82;

ALTER TABLE t_format_info_obj MODIFY house_address varchar(500);

update t_format_info_obj set house_area = 1;

select * from t_format_info_obj where order_id = 92;
select * from t_cbs_order where id = 92;
update t_util_format_info set can_see_role_set =  11 where ch_name='申请人电话';

select ch_name from t_util_format_info group by ch_name having count(*) >1;
select * from t_util_format_info where ch_name in ('建筑面积','逾期天数');
update t_util_format_info set state = 100 where id = 92;
update t_util_format_info set ch_name = '上家逾期天数' where id = 62;
select * from cfg_format_info_who_object;
select * from t_cbs_order_doc where order_id= 92;
insert into cfg_format_info_who_object (id, name) values ();
select * from t_format_info_obj where order_id = 93;

#谁都不能修改的字段,只能系统自动生成
update t_util_format_info set can_see_role_set = '2,7,16,14,6,11,12,8';
select * from t_util_format_info where state =1;
select creator from t_format_info_obj where order_id = 85;
update t_format_info_obj set house_area = 2;

update t_format_info_obj set next_organ_type = 1;
select * from t_format_info_obj where house_area = 1;

select * from cfg_format_info_client_mapping;

select concat("update gzx.",table_name," set id = 0 where name='全部';") from information_schema.tables where table_schema = 'gzx' and table_name not like '%cfg%';

select * from cfg_cbs_order_state;
select * from t_ums_role;
select * from t_util_work_flow where before_state in(104);
select * from t_hr_position;
select * from t_ums_user;
select distinct position from t_hr_employee where user_id is not null;
select * from t_sales_agent where user_id is not null;
select * from t_hr_position;
select * from cfg_cbs_business_type;
update t_util_format_info set need_step='102',can_modify_role_set='8' where ch_name in ('评估日期','链家评估日期','大数据日期','大数据结论','评估总价','链家快出总价');
update t_util_format_info set need_step='123',can_modify_role_set='7' where ch_name in ('预约还款日');
update t_util_format_info set need_step='111',can_modify_role_set='7' where ch_name in ('上家核实到期日期','上家核实日期','下家核实批贷日期','下家核实公证日期','下家放款账户提供日期','下家核实日期','上家名称','剩余本金','剩余利息','罚息/其他','是否逾期','逾期天数','房本是否收押');
update t_util_format_info set need_step='111',can_modify_role_set='7' where ch_name in ('上家本金收款户名','上家本金收款开户行','上家本金收款账号','下家名称','批贷额','是否带用途批','是否公证','放款形式','下家放款账户提供方','下家放款户名','下家放款开户行','房本是否收押');
update t_util_format_info set need_step='(112,114)',can_modify_role_set='7' where ch_name in ('签约日期','报信托天数','客户首付天数');
update t_util_format_info set need_step='117',can_modify_role_set='8' where ch_name in ('卷齐日期','证件收押日期');
update t_util_format_info set need_step='118',can_modify_role_set='8' where ch_name in ('批贷日期');
update t_util_format_info set need_step='121',can_modify_role_set='12' where ch_name in ('上家扣款日期');
update t_util_format_info set need_step='122',can_modify_role_set='7' where ch_name in ('上家房本预计领取日期','逾期天数');
update t_util_format_info set need_step='122',can_modify_role_set='7' where ch_name in ('上家房本预计领取日期','解压材料预计领取日期','解压材料解押日期','垫资是否展期','展期收费');
update t_util_format_info set need_step='123',can_modify_role_set='7' where ch_name in ('下家房本送至日期','下家房本抵押日期','下家房本他证领取日期');
update t_util_format_info set need_step='124',can_modify_role_set='12' where ch_name in ('下家放款预计放款日期','下家放款实际放款日期');
update t_util_format_info set need_step='104',can_modify_role_set='11' where ch_name in ('产权人','身份证号','是否已婚','配偶姓名','配偶身份证号','客户本金收款户名','客户本金收款账号','客户本金收款开户行','产权证号','房屋坐落','建筑面积','房屋类型','申请天数');
update t_util_format_info set need_step='0',can_modify_role_set='11' where ch_name in ('垫资金额','预计天数');


insert into t_util_format_info (busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, need_step, scatter_obj, state,  updator, who_object, can_modify_role_set, can_see_role_set)
values (2,'下家机构类型',sysdate(),0,1,'nextOrganType',1,111,null,1,0,1,7,'2,7,16,14,6,11,12,8');
insert into t_util_format_info (busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, need_step, scatter_obj, state,  updator, who_object, can_modify_role_set, can_see_role_set)
values (2,'申请人电话',sysdate(),0,3,'applyTel',2,-1,null,1,0,1,11,'2,7,16,14,6,11,12,8');

insert into t_util_format_info (busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, need_step, scatter_obj, state,  updator, who_object, can_modify_role_set, can_see_role_set)
values (2,'房屋区域',sysdate(),0,1,'houseArea',1,104,null,1,0,1,11,'2,7,16,14,6,11,12,8');
insert into t_util_format_info (busi_type, ch_name, create_time, creator, data_type, en_name, if_scatter, need_step, scatter_obj, state,  updator, who_object, can_modify_role_set, can_see_role_set)
values (2,'几抵',sysdate(),0,1,'mortgageNum',2,104,null,1,0,1,11,'2,7,16,14,6,11,12,8');

insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'付息提醒日',sysdate(),0,4,'payInterestAlertDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下次付息日',sysdate(),0,4,'nextInterestPaymentDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'提醒日期',sysdate(),0,4,'reminderDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'评估日期',sysdate(),0,4,'assessmentDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'链家评估日期',sysdate(),0,4,'chainFamilyEvaluationDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'大数据日期',sysdate(),0,4,'bigDataDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'预约还款日',sysdate(),0,4,'reservedRepaymentDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'上家核实到期日期',sysdate(),0,4,'checkExpirationDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'上家核实日期',sysdate(),0,4,'verificationDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家核实批贷日期',sysdate(),0,4,'verificationApprovalDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家核实公证日期',sysdate(),0,4,'verificationNotarizationDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家放款账户提供日期',sysdate(),0,4,'accountProvisionDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家核实日期',sysdate(),0,4,'nextVerificationDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'签约日期',sysdate(),0,4,'reContractDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'卷齐日期',sysdate(),0,4,'fileCollectionDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'报卷日期',sysdate(),0,4,'fileReportDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'批贷日期',sysdate(),0,4,'approvedDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'证件收押日期',sysdate(),0,4,'depositCertificatesDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'垫资放款日期',sysdate(),0,4,'loanDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'上家扣款日期',sysdate(),0,4,'deductionDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'收费日期',sysdate(),0,4,'feeDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'上家房本预计领取日期',sysdate(),0,4,'houseOwnershipExpectedReceiveDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'上家房本实际领取日期',sysdate(),0,4,'houseOwnershipRealReceiveDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'解压材料预计领取日期',sysdate(),0,4,'unzipDocExpectedReceiveDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'解压材料实际领取日期',sysdate(),0,4,'unzipDocRealReceiveDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'解压材料解押日期',sysdate(),0,4,'unzipDocUndepositDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家房本送至日期',sysdate(),0,4,'nextHouseOwnershipSendDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家房本抵押日期',sysdate(),0,4,'nextHouseOwnershipDepositDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家房本他证领取日期',sysdate(),0,4,'nextHouseOtherReceiveDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家放款预计放款日期',sysdate(),0,4,'nextExceptionLoanDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家放款实际放款日期',sysdate(),0,4,'nextRealLoanDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'完结日期',sysdate(),0,4,'finishDate',2,0,null,1,0,1);

insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'产权人',sysdate(),0,3,'propertyOwner',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'身份证号',sysdate(),0,3,'certiNO',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'婚姻状况',sysdate(),0,1,'maritalStatus',1,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'配偶姓名',sysdate(),0,3,'spouseName',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'身份证号',sysdate(),0,3,'spouseCertiNO',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'大数据结论',sysdate(),0,3,'bigDateConclusion',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'客户本金收款户名',sysdate(),0,3,'customerCapitalAccountName',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'客户本金收款账号',sysdate(),0,3,'customerCapitalAccountNO',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'客户本金收款开户行',sysdate(),0,3,'customerCapitalBank',2,0,null,1,0,1);

insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'产权证号',sysdate(),0,4,'titleCertificateNO',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'房屋坐落',sysdate(),0,4,'houseAddress',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'建筑面积',sysdate(),0,5,'houseSquare',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'房屋类型',sysdate(),0,1,'houseType',1,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'评估总价',sysdate(),0,5,'houseEvaluatePrice',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'链家快出总价',sysdate(),0,5,'chainFamilyFastOutPrice',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'垫资金额',sysdate(),0,5,'amount',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'预计天数',sysdate(),0,1,'exceptionDays',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'报信托天数',sysdate(),0,1,'tellUpDays',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'客户首付天数',sysdate(),0,1,'customerFirstPayDays',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'逾期天数',sysdate(),0,1,'overdueDays',2,0,null,1,0,1);

insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'申请天数',sysdate(),0,1,'applyDays',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'垫资是否展期',sysdate(),0,1,'ifExtension',1,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'首展天数',sysdate(),0,1,'firstExtensionDays',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'展期收费',sysdate(),0,5,'extensionFee',2,0,null,1,0,1);

insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'上家名称',sysdate(),0,3,'upName',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'剩余本金',sysdate(),0,5,'upResidueCapital',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'剩余利息',sysdate(),0,5,'upResidueInterest',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'罚息/其他',sysdate(),0,5,'upPenaltyInterest',2,0,null,1,0,1);

insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'是否逾期',sysdate(),0,1,'upIfOverdue',1,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'逾期天数',sysdate(),0,1,'upOverdueDays',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'房本收押',sysdate(),0,1,'upIfHouseDeposit',1,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'解押材料',sysdate(),0,4,'upUnzipDoc',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'上家本金收款户名',sysdate(),0,3,'upCapitalAccountName',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'上家本金收款开户行',sysdate(),0,3,'upCapitalBank',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'上家本金收款账号',sysdate(),0,3,'upCapitalAccountNO',2,0,null,1,0,1);

insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家名称',sysdate(),0,3,'nextName',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'批贷额',sysdate(),0,5,'nextAount',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'带用途批',sysdate(),0,1,'nextIfLimitPurpose',1,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'是否公证',sysdate(),0,1,'nextIfNotarization',1,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'放款形式',sysdate(),0,1,'nextLoanWay',1,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家放款账户提供方',sysdate(),0,3,'nextCapitalAccountProvider',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家放款户名',sysdate(),0,3,'nextCapitalAccountName',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'下家放款开户行',sysdate(),0,3,'nextCapitalBank',2,0,null,1,0,1);


insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('address','发证地址',1);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('nationality','民族',1);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('start_date','身份证有效期起',1);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('end_date','身份证有效期止',1);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('issue',null,1);

update cfg_format_info_client_mapping set format_info_key = '发证机关' where id = 5;
update cfg_format_info_client_mapping set format_info_key = '房产证号' where id = 6;
update cfg_format_info_client_mapping set format_info_key = '产权人' where id = 7;
update cfg_format_info_client_mapping set format_info_key = '共有情况' where id = 8;
update cfg_format_info_client_mapping set format_info_key = '房屋坐落' where id = 9;
update cfg_format_info_client_mapping set format_info_key = '不动产单元号' where id = 10;
update cfg_format_info_client_mapping set format_info_key = '土地权利类型' where id = 11;
update cfg_format_info_client_mapping set format_info_key = '房屋权利类型' where id = 12;

select * from cfg_format_info_client_mapping;
update t_cbs_order set state = 100  where id < 94;

insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'民族',sysdate(),0,3,'nationality',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'发证地址',sysdate(),0,3,'certiAddress',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'身份证有效期起',sysdate(),0,4,'certiStartDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'身份证有效期止',sysdate(),0,4,'certiEndDate',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'发证机关',sysdate(),0,3,'certiIssue',2,0,null,1,0,1);

insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('房产证号','发证地址',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('权利人','民族',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('共有情况','发证地址',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('坐落','民族',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('不动产单元号','发证地址',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('土地权利类型','民族',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('房屋权利类型','发证地址',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('土地权利性质/取得方式','土地权利性质/取得方式',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('房屋权利性质/取得方式','房屋权利性质/取得方式',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('土地用途','土地用途',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('房屋用途','房屋用途',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('建筑面积','建筑面积',6);
insert into cfg_format_info_client_mapping(client_key,format_info_key,ocr_file_type)
values('使用期限','使用期限',6);

insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'房产证号',sysdate(),0,3,'houseCertiNo',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'权利人',sysdate(),0,3,'houseOwnership',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'共有情况',sysdate(),0,3,'belongType',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'坐落',sysdate(),0,3,'houseAddress',2,0,'certiIssue',1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'不动产单元号',sysdate(),0,3,'houseUnitNo',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'土地权利类型',sysdate(),0,3,'landRightType',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'房屋权利类型',sysdate(),0,3,'houseRigthType',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'土地权利性质/取得方式',sysdate(),0,3,'landGetWay',2,0,'certiIssue',1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'房屋权利性质/取得方式',sysdate(),0,3,'houseGetWay',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'土地用途',sysdate(),0,3,'landPurpose',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'房屋用途',sysdate(),0,3,'housePurpose',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'建筑面积',sysdate(),0,5,'coveredArea',2,0,null,1,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'使用期限',sysdate(),0,3,'serviceLife',2,0,null,1,0,1);



#以下字段不需要保存
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'业务类型',sysdate(),0,1,'busiType',1,0,null,100,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'业务状态',sysdate(),0,1,'orderState',1,0,null,100,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'最新提醒事项',sysdate(),0,3,'latestReminders',2,0,null,100,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'提醒事项办理人',sysdate(),0,1,'reminderPeople',2,0,null,100,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'业务员',sysdate(),0,1,'salerId',2,0,null,100,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'风控专员',sysdate(),0,1,'riskController',2,0,null,100,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'合作渠道/个人',sysdate(),0,4,'channelName',2,0,null,100,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'贷款类型',sysdate(),0,1,'upLoanType',2,0,null,100,0,1);
insert into t_util_format_info (busi_type,ch_name,create_time,creator,data_type,en_name,if_scatter,need_step,scatter_obj,state,updator,who_object)
values(2,'房本领取日期',sysdate(),0,4,'upHouseReceiveDate',2,0,null,100,0,1);

