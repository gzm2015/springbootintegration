
drop database springboot-dev;
create database springboot-dev;

create table if not exists `sys_role`(
  role_id bigint not null  auto_increment,
  name varchar(120) not null unique ,
  role_type varchar(120) not null unique ,
  system_id bigint not null,
  primary key (`role_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#测试 jpa 的 cascade 特性 一方订单
create table if not exists `t_order`(
  id bigint not null auto_increment,
  name varchar(120) null,
  primary key (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

#多方订单明细
create table if not exists `t_item`(
  id bigint not null auto_increment,
  name varchar(120) null,
  order_id varchar (120) not null,
  primary key (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8