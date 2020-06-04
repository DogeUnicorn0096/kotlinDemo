DROP TABLE IF EXISTS `user`;
create table "user"
(
    id          bigserial not null
        constraint user_pk
            primary key,
    account     varchar   not null,
    password    varchar   not null,
    create_time date      not null
);


