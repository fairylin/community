create table User
(
    id int auto_increment,
    name varchar(100),
    account_id varchar(35),
    token varchar(55),
    gmt_create bigint,
    gmt_modified bigint,
    constraint User_pk
        primary key (id)
);

