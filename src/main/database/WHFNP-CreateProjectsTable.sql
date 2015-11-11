create table project
(project_id int(11) NOT NULL auto_increment,
project_name varchar(255) NOT NULL,
non_profit_id int(11) default NULL,
description varchar(255) DEFAULT NULL,
no_of_volunteers_required int(11) DEFAULT NULL,
technology_stack varchar(255) DEFAULT NULL,
start_date datetime default NULL,
deadline datetime default NULL,
approved_by int(11) default NULL,
date_approved datetime default NULL,
status int(2) DEFAULT NULL,
primary key (project_id),
foreign key (non_profit_id) references user(user_id),
foreign key (approved_by) references user(user_id),
foreign key (status) references status(id)
);