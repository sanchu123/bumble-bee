create table users (user_id bigint not null auto_increment, enabled bit not null, password varchar(255), role varchar(255), username varchar(255), primary key (user_id)) engine=InnoDB;
