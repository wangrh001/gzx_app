set names utf8;
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

delete from t_hr_action where id <>0;
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
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (17,sysdate(),0,'下家抵押',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (18,sysdate(),0,'关注下家放款',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (19,sysdate(),0,'和客户交接材料',1,0,2);
insert into  t_hr_action (id,create_time, creator, name, state, updator, busi_type)values (20,sysdate(),0,'给客户打印交接单，完结订单',1,0,2);

#增加一个节点的流程
insert into cfg_cbs_order_state (id, name, busi_type) values (128,'机构已通过',1);
update t_util_work_flow set state = 1 where id = 25;
update t_util_work_flow set before_state = 128 where id in (26,27);
##需要确认action_id 和 button_id是不是一样
insert into t_util_work_flow (after_state, before_state, create_time, creator, state, trans_condition, updator, work_type, action_id, busi_type, position_id, button_id) values
  (128,118,sysdate(),0,1,'',0,1,56,2,8,117);
insert into t_hr_action (create_time, creator, name, state, updator, busi_type) values
  (sysdate(),0,'确认机构通过',1,0,2);
update t_ums_resource set name = '上报机构' where id = 91;
insert t_ums_resource (create_time, creator, name, parent_id, res_url, state, type, updator, column_name, value_set, grade)
values (sysdate(),0,'确认机构通过',2,'/order/edit',1,2,0,'','',3);
update t_util_work_flow set action_id = 13 where before_state = 128;