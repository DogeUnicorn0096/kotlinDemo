create table sys_user
(
    id          bigserial    not null
        constraint user_pkey
            primary key,
    account     varchar(255) not null,
    create_time timestamp    not null,
    password    varchar(255) not null
);
