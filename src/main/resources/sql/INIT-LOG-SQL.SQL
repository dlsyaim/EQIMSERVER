--创建日志表,MYSQL
create table GISINFO_LOG
(
	id varchar(32) not null,
	business_name varchar(100) null,
	operation_date datetime null,
	operator varchar(32) null,
	application_code varchar(32) null,
	content varchar(4000) null,
	constraint table_name_pk
		primary key (id)
);

