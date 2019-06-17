create table cfg_account_account_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_account_balance
(
	id int primary key,
	code varchar(255) null,
	name varchar(255) not null,
	type int null comment '1、资产；2、负债；3、所有者权益；4、损益'
)
;

create table cfg_account_bank
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_account_company
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_accounting_period_period_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_accounting_rule_fee_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_agent_business_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_agent_channel_type
(
	id int primary key,
	name varchar(255) not null,
	type int(3) not null
)
;

create table cfg_attendance_ask_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_balance_credit
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_balance_debit
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_btask_result
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_calc_formula_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cbs_business_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cbs_cust_city
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cbs_estate_area
(
	id bigint primary key,
	city varchar(255) not null,
	name varchar(255) not null
)
;

create table cfg_cbs_estate_type
(
	id bigint primary key,
	name varchar(255) not null
)
;

create table cfg_cbs_identity_type
(
	id bigint primary key,
	name varchar(255) not null
)
;

create table cfg_cbs_order_state
(
	id int primary key,
	name varchar(255) not null,
	busi_type int(3) not null
)
;

create table cfg_cbs_pay_interest_way
(
	id int primary key,
	name varchar(255) null
)
;

create table cfg_cbs_pay_way
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cbs_period_type
(
	id bigint primary key,
	name varchar(255) not null
)
;

create table cfg_cbs_prod_bank
(
	id bigint primary key,
	name varchar(255) null
)
;

create table cfg_cbs_prod_type
(
	id bigint primary key,
	name varchar(255) not null
)
;

create table cfg_cbs_rend_object
(
	id int not null
		primary key,
	name varchar(255) not null
)
;

create table cfg_certificate_certi_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_certificate_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_commission_base_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_commission_business_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_commission_channel_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_commission_level
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_commission_product_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_commission_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_commission_way
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cswork_cs_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cswork_cstype
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_curriculum_pos_id
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_curriculum_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cust_city
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cust_info_original
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cust_is_new_stockholder
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cust_job
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cust_sales_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cust_sex
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_cust_why_borrow
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_employee_city
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_employee_manage_grade
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_employee_position_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_employee_tech_grade
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_format_info_client_mapping
(
	id int primary key,
	client_key varchar(255) null,
	format_info_key varchar(255) null,
	ocr_file_type int null
)
;

create table cfg_format_info_data_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_format_info_if_scatter
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_format_info_who_object
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_group_grade
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_job_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_knowledge_question_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_order_doc_type
(
	id int primary key,
	ch_name varchar(255) null,
	en_name varchar(255) null
)
;

create table cfg_organ_type
(
	id int primary key,
	name varchar(255) null
)
;

create table cfg_paraters
(
	id bigint primary key,
	ch_name varchar(255) null,
	create_time datetime null,
	creator int null,
	en_name varchar(255) null,
	necessary int null,
	state int null,
	type int null,
	update_time datetime null,
	updator int null
)
;

create table cfg_payment_in_out
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_payment_offset
(
	id int primary key,
	name varchar(255) null
)
;

create table cfg_payment_pay_data_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_payment_pay_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_payment_pay_type
(
	id int primary key,
	name varchar(255) not null,
	busi_type int(3) not null,
	fee_type int(2) not null,
	relate_id int not null
)
;

create table cfg_performance_commission_process
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_position_dept_id
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_position_is_commission
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_prod_interest_period_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_product_bank_id
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_product_end_date
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_product_interest_way
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_product_product_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_product_product_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_resource_parent_id
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_resource_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_role_resource_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_salary_extend_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_task_end_date
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_task_task_period
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_task_task_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_task_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_tel_sales_result
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_tel_sales_task_delay
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_work_flow_after_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_work_flow_befor_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_work_flow_work_type
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_work_order_cs_state
(
	id int primary key,
	name varchar(255) not null
)
;

create table cfg_work_order_cstype
(
	id int primary key,
	name varchar(255) not null
)
;

create table t_bank
(
	id bigint auto_increment
		primary key,
	name varchar(255) null,
	org_type int(3) null
)
;

create table t_batch_btask
(
	id bigint auto_increment
		primary key,
	batch_id int null,
	batch_name varchar(255) null,
	create_time datetime null,
	creator bigint null,
	end_time datetime null,
	error_desc varchar(255) null,
	result int null,
	start_time datetime null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_batch_job
(
	id bigint auto_increment
		primary key,
	batch_name varchar(255) null,
	create_time datetime null,
	creator bigint null,
	last_time datetime null,
	next_time datetime null,
	period_num int null,
	start_time datetime null,
	state int null,
	type int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_cbs_certi_log
(
	id bigint auto_increment
		primary key,
	certi_id bigint null,
	operator bigint null,
	opt_time datetime null,
	opt_type int null
)
;

create table t_cbs_certificate
(
	id bigint auto_increment
		primary key,
	box_no int null,
	certi_state int null,
	create_time datetime null,
	creator bigint null,
	name varchar(255) null,
	order_id bigint null,
	receive_time datetime null,
	return_time datetime null,
	state int null,
	type int null,
	update_time datetime null,
	updator bigint null,
	user_id bigint null
)
;

create table t_cbs_order
(
	id bigint auto_increment
		primary key,
	saler_id int(11) unsigned zerofill null comment '内部单 是employeeid，外部单是agentId',
	applicant_name varchar(255) null,
	apply_time datetime not null,
	business_type int not null,
	cell_phone varchar(255) null,
	create_time datetime null,
	creator int null,
	demand_amount decimal(19,2) null,
	demand_date datetime null,
	demand_interest decimal(19,2) null,
	demand_pay_way int null,
	state int(3) not null,
	period_num int null,
	period_type int(3) null,
	update_time datetime null,
	updator int null,
	check_time datetime null,
	sign_date datetime null,
	order_state int(3) not null,
	pay_interest_way int null,
	next_org_type int null,
	channel_type int null,
	approve_id varchar(255) null
)
;

create table t_cbs_order_doc
(
	id bigint auto_increment
		primary key,
	uuidname varchar(255) null,
	uuidnamed_file_path varchar(255) null,
	condense_name_path varchar(255) null,
	create_time datetime null,
	creator int null,
	doc_type int null,
	order_id bigint null,
	origina_name varchar(255) null,
	original_file_path varchar(255) null,
	state int null,
	update_time datetime null,
	updator int null
)
;

create table t_cbs_order_log
(
	id bigint auto_increment
		primary key,
	action_desc varchar(255) null,
	button_id bigint null,
	create_time datetime null,
	creator int null,
	operator_time datetime null,
	order_id bigint null,
	order_product_id bigint null,
	state int null,
	update_time datetime null,
	updator int null,
	user_id bigint null
)
;

create table t_cbs_order_pool
(
	id bigint auto_increment
		primary key,
	into_time datetime null,
	leave_time datetime null,
	order_id bigint null,
	do_state int null,
	user_id bigint null,
	position_id int null,
	into_pool_no int null,
	create_time datetime null,
	creator int null,
	update_time datetime null,
	updator int null,
	state int null
)
;

create table t_cbs_order_prod_cust
(
	id bigint auto_increment
		primary key,
	customer_id bigint null,
	identity_type bigint null,
	order_id bigint null,
	order_product_id bigint null
)
;

create table t_cbs_order_product
(
	id bigint auto_increment
		primary key,
	approve_state int null,
	approve_time datetime null,
	create_time datetime null,
	creator int null,
	fee decimal(19,2) null,
	is_muti_loaner varchar(255) null,
	order_id bigint null,
	order_prod_state int not null,
	payment_time datetime null,
	plan_amount decimal(19,2) null,
	plan_interest decimal(19,2) null,
	plan_pay_way bigint null,
	plan_period_num int null,
	plan_period_type bigint null,
	plan_source int null,
	product_id bigint null,
	real_amount decimal(19,2) null,
	real_interest decimal(19,2) null,
	real_pay_way bigint null,
	real_period_num bigint null,
	real_period_type bigint null,
	relationship int null,
	service_id bigint not null,
	update_time datetime null,
	updator int null,
	state int(3) not null
)
;

create table t_cbs_prod_interest
(
	id bigint auto_increment
		primary key,
	begin_date datetime null,
	create_time datetime null,
	creator bigint null,
	end_date datetime null,
	interest decimal(19,2) null,
	period_type int null,
	product_id int null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_cbs_product
(
	id int auto_increment
		primary key,
	bank_id bigint null,
	product_name varchar(255) null,
	product_type bigint null,
	create_time datetime null,
	creator int null,
	product_state bigint null,
	update_time datetime null,
	updator int null,
	begin_date datetime null,
	end_date datetime null,
	state int null,
	brokerage decimal(19,2) null,
	fair_fee decimal(19,2) null,
	interest decimal(19,2) null,
	law_fee decimal(19,2) null,
	license_fee decimal(19,2) null,
	busi_type int(3) not null,
	interest_way int null
)
;

create table t_cbs_product_rule
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	product_id bigint null,
	rule_elastic bigint null,
	rule_expression varchar(255) null,
	rule_state bigint null,
	rule_type bigint null,
	update_time datetime null,
	updator bigint null,
	and_group_id bigint null,
	expression_desc varchar(255) null,
	or_group_id bigint null
)
;

create table t_crm_cust
(
	id bigint auto_increment
		primary key,
	address varchar(255) null,
	be_stockholder_months int null,
	birthday datetime null,
	card_no varchar(255) null,
	certi_code varchar(255) null,
	city int null,
	create_time datetime null,
	creator bigint null,
	info_original int null,
	is_new_stockholder int null,
	job int null,
	name varchar(255) null,
	phone varchar(255) null,
	sales_state int null,
	sex int null,
	state int null,
	update_time datetime null,
	updator bigint null,
	why_borrow int null
)
;

create table t_cs_knowledge
(
	id bigint auto_increment
		primary key,
	answer varchar(255) null,
	create_time datetime null,
	creator bigint null,
	question varchar(255) null,
	question_name varchar(255) null,
	question_type int null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_cs_work_order
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	cs_desc varchar(255) null,
	cs_name varchar(255) null,
	cs_state int null,
	cstype int null,
	customer_id bigint null,
	customer_name varchar(255) null,
	order_id bigint null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_cust_company
(
	company_id bigint auto_increment
		primary key,
	capital decimal(19,2) null,
	company_name varchar(255) null,
	registered_date datetime null,
	share_percent decimal(19,2) null
)
;

create table t_cust_credit
(
	id bigint auto_increment
		primary key,
	ddays2y int null,
	dtimes2y int null,
	dtimes5y int null,
	dtimes6m int null,
	contd2times2y int null,
	contd2times6m int null,
	contd3times1y int null,
	contd3times2y int null,
	contd3times5y int null,
	contd4times2y int null,
	create_time datetime null,
	creator int null,
	customer_id bigint null,
	extend1 int null,
	extend2 int null,
	extend3 int null,
	extend4 int null,
	freeze_amount decimal(19,2) null,
	max_delay int null,
	update_time datetime null,
	updator int null
)
;

create table t_cust_mortgage
(
	mortgage_id bigint auto_increment
		primary key,
	belong_type int null,
	create_time datetime null,
	creator int null,
	customer_id bigint null,
	estate_age int null,
	estate_area int null,
	estate_price decimal(19,2) null,
	estate_type int null,
	house_address int null,
	mortgage_type int null,
	update_time datetime null,
	updator int null,
	mortgage_count int null
)
;

create table t_customer
(
	id bigint auto_increment
		primary key,
	address varchar(255) null,
	age int null,
	be_stockholder_months int null,
	birthday datetime null,
	certi_code varchar(255) null,
	create_time datetime null,
	creator int null,
	cust_state bigint null,
	gender int null,
	is_new_stockholder varchar(255) null,
	job varchar(255) null,
	name varchar(255) null,
	order_id bigint null,
	phone varchar(255) null,
	update_time datetime null,
	updator int null,
	bank_code varchar(255) null,
	bank_id int null
)
;

create table t_finance_account
(
	id bigint auto_increment
		primary key,
	account_names varchar(255) null,
	account_state int null,
	account_no varchar(255) null,
	bank int null,
	company int null,
	create_time datetime null,
	creator bigint null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_finance_accounting_entry
(
	id bigint auto_increment
		primary key,
	accounting_date datetime null,
	amount decimal(19,2) null,
	create_time datetime null,
	creator bigint null,
	credit int null,
	debit int null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_finance_accounting_period
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	end_date datetime null,
	name varchar(255) null,
	period_state int null,
	start_date datetime null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_finance_accounting_rule
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	credit_side int null,
	debit_side int null,
	fee_type int null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_finance_balance
(
	id bigint auto_increment
		primary key,
	accounting_period int null,
	amount_credit decimal(19,2) null,
	amount_debit decimal(19,2) null,
	create_time datetime null,
	creator bigint null,
	end_amount_credit decimal(19,2) null,
	end_amount_debit decimal(19,2) null,
	start_amount_credit decimal(19,2) null,
	start_amount_debit decimal(19,2) null,
	state int null,
	subject int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_finance_payment
(
	id bigint auto_increment
		primary key,
	account_name varchar(255) null,
	amount decimal(19,2) null,
	comp_card_no varchar(255) null,
	create_time datetime null,
	creator bigint null,
	in_out int null,
	operator_id int null,
	order_id int null,
	other_card_no varchar(255) null,
	pay_date datetime null,
	pay_state int null,
	pay_type int null,
	state int null,
	update_time datetime null,
	updator bigint null,
	offset int null,
	other_bank_id bigint null,
	related_id bigint null,
	if_real int null,
	order_product_id bigint null,
	posted varchar(3) not null comment 'Y:已过账；2:未过账'
)
;

create table t_format_info_obj
(
	id bigint auto_increment
		primary key,
	account_provision_date datetime null,
	amount decimal(19,2) null,
	apply_days int null,
	approved_date datetime null,
	assessment_date datetime null,
	big_data_date datetime null,
	big_date_conclusion varchar(255) null,
	certino varchar(255) null,
	chain_family_evaluation_date datetime null,
	chain_family_fast_out_price decimal(19,2) null,
	check_expiration_date datetime null,
	customer_capital_accountno varchar(255) null,
	customer_capital_account_name varchar(255) null,
	customer_capital_bank varchar(255) null,
	customer_first_pay_days int null,
	deduction_date datetime null,
	deposit_certificates_date datetime null,
	exception_days int null,
	extension_fee decimal(19,2) null,
	fee_date datetime null,
	file_collection_date datetime null,
	file_report_date datetime null,
	finish_date datetime null,
	first_extension_days int null,
	house_address varchar(500) null,
	house_evaluate_price decimal(19,2) null,
	house_ownership_expected_receive_date datetime null,
	house_ownership_real_receive_date datetime null,
	house_square decimal(19,2) null,
	house_type int null,
	if_extension int null,
	loan_date datetime null,
	marital_status int null,
	next_aount decimal(19,2) null,
	next_capital_account_name varchar(255) null,
	next_capital_account_provider varchar(255) null,
	next_capital_bank varchar(255) null,
	next_exception_loan_date datetime null,
	next_house_other_receive_date datetime null,
	next_house_ownership_deposit_date datetime null,
	next_house_ownership_send_date datetime null,
	next_if_limit_purpose int null,
	next_if_notarization int null,
	next_interest_payment_date datetime null,
	next_loan_way int null,
	next_name varchar(255) null,
	next_real_loan_date datetime null,
	next_verification_date datetime null,
	order_id bigint null,
	overdue_days int null,
	pay_interest_alert_date datetime null,
	property_owner varchar(255) null,
	re_contract_date datetime null,
	reminder_date datetime null,
	reserved_repayment_date datetime null,
	spouse_certino varchar(255) null,
	spouse_name varchar(255) null,
	tell_up_days int null,
	title_certificateno datetime null,
	unzip_doc_expected_receive_date datetime null,
	unzip_doc_real_receive_date datetime null,
	unzip_doc_undeposit_date datetime null,
	up_capital_accountno varchar(255) null,
	up_capital_account_name varchar(255) null,
	up_capital_bank varchar(255) null,
	up_if_house_deposit int null,
	up_if_overdue int null,
	up_name varchar(255) null,
	up_overdue_days int null,
	up_penalty_interest decimal(19,2) null,
	up_residue_capital decimal(19,2) null,
	up_residue_interest decimal(19,2) null,
	up_unzip_doc datetime null,
	verification_approval_date datetime null,
	verification_date datetime null,
	verification_notarization_date datetime null,
	state int null,
	next_integererest_payment_date datetime null,
	pay_integererest_alert_date datetime null,
	up_penalty_integererest decimal(19,2) null,
	up_residue_integererest decimal(19,2) null,
	create_time datetime null,
	creator int null,
	update_time datetime null,
	updator int null,
	belong_type varchar(255) null,
	certi_address varchar(255) null,
	certi_end_date datetime null,
	certi_issue varchar(255) null,
	certi_start_date datetime null,
	covered_area decimal(19,2) null,
	house_certi_no varchar(255) null,
	house_get_way varchar(255) null,
	house_ownership varchar(255) null,
	house_purpose varchar(255) null,
	house_rigth_type varchar(255) null,
	house_unit_no varchar(255) null,
	land_get_way varchar(255) null,
	land_purpose varchar(255) null,
	land_right_type varchar(255) null,
	nationality varchar(255) null,
	service_life varchar(255) null
)
;

create table t_hr_action
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	name varchar(255) null,
	state int null,
	update_time datetime null,
	updator bigint null,
	busi_type int(3) not null
)
;

create table t_hr_attendance
(
	id bigint auto_increment
		primary key,
	ask_begin_time datetime null,
	ask_end_time datetime null,
	ask_type int null,
	check_time datetime null,
	create_time datetime null,
	creator bigint null,
	emp_id int null,
	emp_name varchar(255) null,
	month varchar(255) null,
	state int null,
	update_time datetime null,
	updator bigint null,
	work_day datetime null
)
;

create table t_hr_curriculum
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	emp_id int null,
	name varchar(255) null,
	pos_id int null,
	state int null,
	teacher_name varchar(255) null,
	type int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_hr_dept
(
	id int auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	name varchar(255) null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_hr_emp_log
(
	id bigint auto_increment
		primary key,
	after_dept_id bigint null,
	after_employment_time float null,
	after_manage_grade int null,
	after_post_id bigint null,
	after_salary decimal(19,2) null,
	after_tech_grade int null,
	befor_employment_time float null,
	before_dept_id bigint null,
	before_manage_grade int null,
	before_post_id bigint null,
	before_salary decimal(19,2) null,
	before_tech_grade int null,
	change_cause int null,
	change_valid_date datetime null,
	create_time datetime null,
	creator bigint null,
	emp_id bigint null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_hr_employee
(
	id bigint auto_increment
		primary key,
	address varchar(255) null,
	birthday datetime null,
	card_no varchar(255) null,
	certi_code varchar(255) null,
	city int null,
	create_time datetime null,
	creator bigint null,
	dept int null,
	emg_name varchar(255) null,
	emg_phone varchar(255) null,
	hiredate datetime null,
	leavedate datetime null,
	manage_grade int null,
	name varchar(255) null,
	phone varchar(255) null,
	position int null,
	salary decimal(19,2) null,
	state int null,
	tech_grade int null,
	update_time datetime null,
	updator bigint null,
	user_id bigint null,
	user_name varchar(255) null
)
;

create table t_hr_employee_position
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	emp_id int null,
	pos_id int null,
	state int null,
	type int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_hr_position
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	dept_id int null,
	is_commission int null,
	level int null,
	name varchar(20) null,
	salary_max decimal(19,2) null,
	salary_min decimal(19,2) null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_hr_salary
(
	id bigint auto_increment
		primary key,
	basic_salary decimal(19,2) null,
	create_time datetime null,
	creator bigint null,
	current_salary decimal(19,2) null,
	emp_id int null,
	emp_name varchar(255) null,
	extend_date datetime null,
	extend_state int null,
	month varchar(255) null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_mis_period
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	end_date datetime null,
	name varchar(255) null,
	start_date datetime null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_mis_task
(
	id bigint auto_increment
		primary key,
	amount decimal(19,2) null,
	begin_date datetime null,
	complete_amount decimal(19,2) null,
	create_time datetime null,
	creator bigint null,
	employee_id int null,
	end_date int null,
	state int null,
	task_desc varchar(255) null,
	task_name varchar(255) null,
	task_state int null,
	type int null,
	update_time datetime null,
	updator bigint null,
	task_period int null
)
;

create table t_order_paras
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator int null,
	order_id bigint null,
	para_id bigint null,
	para_value varchar(255) null,
	state int null,
	update_time datetime null,
	updator int null
)
;

create table t_prod_bank
(
	id bigint auto_increment
		primary key,
	name varchar(255) null
)
;

create table t_sales_agent
(
	id bigint auto_increment
		primary key,
	bank_code varchar(255) null,
	business_type int null,
	centi_code varchar(255) null,
	channel_type int null,
	company_name varchar(255) null,
	cooperate_begin_date datetime null,
	cooperate_end_date datetime null,
	create_time datetime null,
	creator bigint null,
	job_years int null,
	name varchar(255) null,
	phoneno varchar(255) null,
	state int null,
	update_time datetime null,
	updator bigint null,
	user_name varchar(255) null,
	user_id bigint null,
	employee_id bigint null,
	parent_id bigint null,
	group_id bigint null,
	dd_user_name varchar(255) null
)
;

create table t_sales_commission
(
	id bigint auto_increment
		primary key,
	base_type int null,
	business_type int null,
	channel_type int null,
	create_time datetime null,
	creator bigint null,
	level int null,
	percent decimal(19,2) null,
	product_id int null,
	product_type int null,
	state int null,
	sum decimal(19,2) null,
	type int null,
	update_time datetime null,
	updator bigint null,
	way int null,
	end_date datetime null,
	start_date datetime null,
	pay_way int(3) null comment '1、按月发放；2、逐笔发放'
)
;

create table t_sales_group
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	grade int null,
	name varchar(255) null,
	parent_id int null,
	state int null,
	update_time datetime null,
	updator bigint null,
	employee_id int null
)
;

create table t_sales_performance_comm_detail
(
	id bigint auto_increment
		primary key,
	commission decimal(19,2) null,
	create_time datetime null,
	creator bigint null,
	performance decimal(19,2) null,
	state int null,
	update_time datetime null,
	updator bigint null,
	order_product_id bigint null,
	order_id bigint not null,
	interest decimal(19,2) not null,
	max_commission decimal(19,2) null,
	min_commission decimal(19,2) null,
	saler_id bigint null
)
;

create table t_sales_performance_commission
(
	id bigint auto_increment
		primary key,
	commission decimal(19,2) null,
	create_time datetime null,
	creator bigint null,
	month varchar(255) null,
	performance decimal(19,2) null,
	process int null,
	state int null,
	update_time datetime null,
	updator bigint null,
	interest decimal(19,2) not null,
	max_commission decimal(19,2) null,
	min_commission decimal(19,2) null,
	saler_id bigint null,
	saler_name varchar(255) null
)
;

create table t_sales_tel_sales
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	hist_desc varchar(255) null,
	mark_desc varchar(255) null,
	phone varchar(255) null,
	result int null,
	state int null,
	task_date datetime null,
	task_delay int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_ums_resource
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	name varchar(255) null,
	parent_id bigint null,
	res_url varchar(255) null,
	state int null,
	type int null,
	update_time datetime null,
	updator bigint null,
	column_name varchar(255) null,
	value_set varchar(255) null,
	grade int(3) not null
)
;

create table t_ums_role
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	name varchar(255) null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_ums_role_privilege
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	privilege_type int null,
	res_id bigint null,
	role_id bigint null,
	state int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_ums_role_resource
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	res_id bigint null,
	role_id bigint null,
	state int null,
	type int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_ums_user
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	last_log_in_time datetime null,
	password varchar(255) null,
	state int null,
	update_time datetime null,
	updator bigint null,
	user_name varchar(255) null,
	dduser_name varchar(255) null
)
;

create table t_ums_user_role
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	role_id int null,
	state int null,
	update_time datetime null,
	updator bigint null,
	user_id int null
)
;

create table t_user_behavior_log
(
	id bigint auto_increment
		primary key,
	behavior_time datetime null,
	resource_id bigint null,
	user_id bigint null
)
;

create table t_user_role
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	role_id bigint null,
	state int null,
	update_time datetime null,
	updator bigint null,
	user_id bigint null
)
;

create table t_util_calc_formula
(
	id bigint auto_increment
		primary key,
	begin_date datetime null,
	create_time datetime null,
	creator bigint null,
	end_date datetime null,
	expression varchar(255) null,
	name varchar(255) null,
	state int null,
	type int null,
	update_time datetime null,
	updator bigint null
)
;

create table t_util_calc_param
(
	id bigint auto_increment
		primary key,
	create_time datetime null,
	creator bigint null,
	expression varchar(255) null,
	formula_id int null,
	name varchar(255) null,
	state int null,
	update_time datetime null,
	updator bigint null,
	formula_type_id int null,
	para_desc varchar(255) null
)
;

create table t_util_format_info
(
	id bigint auto_increment
		primary key,
	busi_type int null,
	ch_name varchar(255) null,
	create_time datetime null,
	creator bigint null,
	data_type int null,
	en_name varchar(255) null,
	if_scatter int null,
	need_step varchar(200) null,
	scatter_obj varchar(255) null,
	state int null,
	update_time datetime null,
	updator bigint null,
	who_object int null,
	can_modify_role_set varchar(255) null,
	can_see_role_set varchar(255) null
)
;

create table t_util_work_flow
(
	id bigint auto_increment
		primary key,
	after_state int null,
	before_state int null,
	create_time datetime null,
	creator bigint null,
	state int null,
	trans_condition varchar(255) null,
	update_time datetime null,
	updator bigint null,
	work_type int null,
	action_id int null,
	busi_type int null,
	position_id int null,
	button_id int null
)
;

