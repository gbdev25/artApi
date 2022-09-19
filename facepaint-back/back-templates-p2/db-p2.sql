drop table if exists users;
create table if not exists users(
id serial primary key,
username varchar(30) unique,
password varchar(30),
role_id int references user_role(id) default 2,
showcase_art text
);

insert into users (username, password,role_id) values ('admin', 'pass', 1);
insert into users (username, password) values ('basic', 'pass');
insert into users (username, password) values ('jdurtnal2', 'z0tfdD0');
insert into users (username, password) values ('sparish3', 'KFRglM');
insert into users (username, password) values ('kodrought4', 'mYG9Kta9JEy');
insert into users (username, password) values ('fdownton5', 'eL9JNdOAL');
insert into users (username, password) values ('kwiltshier6', '7Vx1WW');
insert into users (username, password) values ('fancliff7', 'enFMN9');
insert into users (username, password) values ('ylehr8', 'jIaULHA3c');
insert into users (username, password) values ('csineath9', 'drW43uf6WB');

drop table if exists user_role
create table if not exists user_role(
id serial primary key,
user_role varchar(30) default 'BASIC_USER'
);
insert into user_role (user_role) values('ADMIN');
insert into user_role (user_role) values('BASIC_USER');


drop table if exists art
create table if not exists art(
id serial primary key,
art_name varchar(30),
art_year int,
artist varchar(50),
image_id int,
showcase int references users(id)
);
