DROP TABLE if exists users;
CREATE table if not exists users
(
    id       INT auto_increment primary key,
    login    VARCHAR(50)  not null unique,
    name     VARCHAR(50)  not null,
    surname  VARCHAR(50)  not null,
    email    varchar(128) not null unique,
    password varchar(64)  not null
);

DROP TABLE if exists courses;
CREATE TABLE courses
(
    id          INt auto_increment primary key,
    title       varchar(25)  not null,
    subtitle    varchar(50)  not null,
    description varchar(255) not null,
    date        date         not null,
    place       varchar(50)  not null,
    author      varchar(50)  not null,
    status      bool         not null,
    type        varchar(30)  not null,
    user_id     INT references users (id) on delete cascade
);

INSERT INTO training_repository.courses (title, subtitle, description, date, place, author, status, type, user_id) VALUES ('Java(18)', 'subtitile', 'new about java 18', '2021-11-25', 'Minsk', 'Labanovich Tsimafei', 1, 'Training', 1);
INSERT INTO training_repository.courses (title, subtitle, description, date, place, author, status, type, user_id) VALUES ('IT news 2021', 'subtitle', 'news about 2021 year', '2021-11-30', 'Gomel', 'Dima Veko', 0, 'Meeting', 2);
INSERT INTO training_repository.courses (title, subtitle, description, date, place, author, status, type, user_id) VALUES ('IT conference', 'subtitle', 'closed conference', '2021-11-11', 'Brest', 'Max Golub', 1, 'Conference', 7);