create table volunteer_project
(vp_id int(11) NOT NULL auto_increment,
user_id int(11) NOT NULL,
project_id int(11) NOT NULL,
role varchar(255) NOT NULL,
status varchar(255) default NULL,
last_date_modified datetime default NULL,
primary key (vp_id, user_id, project_id),
foreign key (user_id) references user(user_id),
foreign key (project_id) references project(project_id)
);