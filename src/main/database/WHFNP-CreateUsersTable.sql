create table user
  (user_id int(11) auto_increment NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL, 
  email_address varchar(255) NOT NULL, 
  telephone_number varchar(11) default NULL,
  role_id int(2) NOT NULL,
  type varchar (255) NOT NULL,
  date_created datetime NOT NULL, 
  date_modified datetime default NULL, 
  modified_by int(11) default NULL,
  primary key (user_id),
  foreign key (role_id) references role(id)
);