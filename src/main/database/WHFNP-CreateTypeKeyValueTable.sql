create table type
(id int(1) NOT NULL auto_increment,
user_id int(11) NOT NULL,
type varchar(255) NOT NULL,
field_name varchar(255) NOT NULL,
field_value varchar(255) DEFAULT null,
date_created datetime NOT NULL,
date_modified datetime NOT NULL,
primary key (id, user_id, field_name),
foreign key (user_id) references user(user_id)
);