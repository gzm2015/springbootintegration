create table permission (
  id   int primary key,
  name varchar(20),
  code varchar(20)
)engine innodb default charset utf8;

create table role_permission(
  role_id int ,
  permission_id int,
  primary key (role_id,permission_id)
);

ALTER TABLE role_permission ADD constraint role_foreign_link23 foreign key (role_id) references sys_role(role_id);
ALTER TABLE role_permission ADD constraint permission_foreign_link foreign key (permission_id) references permission(id);


