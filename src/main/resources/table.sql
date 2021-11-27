CREATE SCHEMA if not exists pharmacy_repository;
create table users
(
    id       int auto_increment
        primary key,
    login    varchar(50)  not null,
    name     varchar(50)  not null,
    surname  varchar(50)  not null,
    email    varchar(128) not null,
    password varchar(64)  not null,
    constraint email
        unique (email),
    constraint login
        unique (login)
);

create table if not exists cure
(
    id            int primary key auto_increment,
    name          varchar(128) not null unique,
    type          varchar(128) not null,
    dose          varchar(128) not null,
    delivery_time varchar(128),
    description   varchar(255) not null
);

create table if not exists cure_type
(
    id int auto_increment primary key ,
    cure_id int references cure(id),
    type varchar(128) not null
);

CREATE table if not exists user_order
(
    user_id int references users (id),
    cure_id int references cure (id),
    order_date    date not null
);

