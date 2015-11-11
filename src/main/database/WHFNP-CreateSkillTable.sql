create table skill 
(skill_id int(11) NOT NULL auto_increment,
project_id int(11) default NULL,
user_id int(11) default NULL,
skill varchar(255) NOT NULL,
description varchar(255) default NULL,
level int(1) NOT NULL,
primary key (skill_id),
foreign key (project_id) references project(project_id),
foreign key (user_id) references user(user_id)
);