create table cart
(
    id            bigint auto_increment
        primary key,
    UUID          varchar(36) null,
    product_id    varchar(24) not null,
    product_count bigint      not null
);

create table authorities
(
    username  varchar(45) not null,
    authority varchar(45) not null
);

create table locations
(
    id          bigint auto_increment
        primary key,
    name        varchar(45)  null,
    address     varchar(45)  null,
    coordinates varchar(255) null
);

create table users
(
    uuid     varchar(36)  not null,
    enabled  int                          not null,
    password varchar(64)   not null,
    username varchar(45)   not null,
    name     varchar(45)                  null,
    discount int         default 0        null,
    email    varchar(255)                 null,
    is_guest int         default 0        null,
    phone    varchar(255)                 null,
    constraint username_UNIQUE
        unique (username),
    constraint uuid_UNIQUE
        unique (uuid)
);

alter table users
    add primary key (uuid);

create table orders
(
    id              bigint auto_increment
        primary key,
    user_uuid       varchar(36)                         not null,
    order_date_time timestamp default CURRENT_TIMESTAMP null,
    cost            decimal(19, 2)                      null,
    order_status    int       default 0                 null,
    discount        int                                 null,
    location_id     bigint                              null,
    constraint orders_ibfk_1
        foreign key (user_uuid) references users (uuid),
    constraint orders_locations
        foreign key (location_id) references locations (id)
);

create table order_detail
(
    id            bigint auto_increment
        primary key,
    order_id      bigint         not null,
    product_id    varchar(45)    not null,
    product_count int            not null,
    product_cost  decimal(10, 2) not null,
    product_name  varchar(255)   null,
    constraint fk_order_detail_orders1
        foreign key (order_id) references orders (id)
            on delete cascade
);

create index fk_order_detail_orders1_idx
    on order_detail (order_id);

create table order_userinfo
(
    id    bigint auto_increment
        primary key,
    phone varchar(45) null,
    name  varchar(45) null,
    constraint order_orderinfo
        foreign key (id) references orders (id)
);

create index order_location_idx
    on orders (location_id);

