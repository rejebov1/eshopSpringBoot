create sequence addresses_id_seq;

alter sequence addresses_id_seq owner to postgres;

create sequence brands_id_seq;

alter sequence brands_id_seq owner to postgres;

create sequence merch_models_id_seq;

alter sequence merch_models_id_seq owner to postgres;

create sequence offer_id_seq;

alter sequence offer_id_seq owner to postgres;

create sequence order_id_seq;

alter sequence order_id_seq owner to postgres;

create sequence order_item_id_seq;

alter sequence order_item_id_seq owner to postgres;

create sequence product_id_seq;

alter sequence product_id_seq owner to postgres;

create sequence seller_id_seq;

alter sequence seller_id_seq owner to postgres;

create sequence users_id_seq;

alter sequence users_id_seq owner to postgres;

create table if not exists addresses
(
  id      bigint not null
    constraint addresses_pkey
      primary key,
  address varchar(255)
);

alter table addresses
  owner to postgres;

create table if not exists brands
(
  id   bigint not null
    constraint brands_pkey
      primary key,
  name varchar(255)
);

alter table brands
  owner to postgres;

create table if not exists merch_models
(
  id       bigint not null
    constraint merch_models_pkey
      primary key,
  name     varchar(255),
  id_brand bigint
    constraint fkfptgogg3xuoh3eq899nxlomgg
      references brands
);

alter table merch_models
  owner to postgres;

create table if not exists offers
(
  id    bigint not null
    constraint offers_pkey
      primary key,
  price double precision
);

alter table offers
  owner to postgres;

create table if not exists orders
(
  id                  bigint not null
    constraint orders_pkey
      primary key,
  name                varchar(255),
  delivery_address_id bigint
    constraint fk3s2t83m5ddty3rgomn94d4ht6
      references addresses
);

alter table orders
  owner to postgres;

create table if not exists products
(
  id       bigint not null
    constraint products_pkey
      primary key,
  name     varchar(255),
  id_model bigint
    constraint fkteev0u65sndbfk1v74qxjgr00
      references merch_models
);

alter table products
  owner to postgres;

create table if not exists order_items
(
  id         bigint not null
    constraint order_items_pkey
      primary key,
  quantity   integer,
  id_order   bigint
    constraint fkj18ef1agdhkb3f8rmgrrgdbvu
      references orders,
  id_product bigint
    constraint fk2eoo5mp3khsag7l93o41u1w7g
      references products
);

alter table order_items
  owner to postgres;

create table if not exists product_has_offer
(
  id_product bigint not null
    constraint fk80a9sb5h1qmmagfridv3cy610
      references products,
  id_offer   bigint not null
    constraint fkr0py1ff91pfwu9xyhhaipw2vb
      references offers
);

alter table product_has_offer
  owner to postgres;

create table if not exists sellers
(
  id   bigint not null
    constraint sellers_pkey
      primary key,
  name varchar(255)
);

alter table sellers
  owner to postgres;

create table if not exists seller_has_address
(
  id_address bigint not null
    constraint fkdtvdfrb7ll5xsltgeta5tfgwh
      references sellers,
  id_seller  bigint not null
    constraint fkcn29wam4d62kqqu7u52i9mnti
      references addresses,
  constraint seller_has_address_pkey
    primary key (id_address, id_seller)
);

alter table seller_has_address
  owner to postgres;

create table if not exists seller_has_offer
(
  id_offer  bigint not null
    constraint fkingh14yjnxauyrn14hkw8n8ou
      references offers,
  id_seller bigint not null
    constraint uk_egudx07h9dfh6dno1vkav3wd3
      unique
    constraint fkt1ajqlh1pn1vkbroxekoam81k
      references sellers,
  constraint seller_has_offer_pkey
    primary key (id_offer, id_seller)
);

alter table seller_has_offer
  owner to postgres;

create table if not exists users
(
  id           bigint       not null
    constraint users_pkey
      primary key,
  email        varchar(255) not null,
  firstname    varchar(255),
  enabled      boolean      not null,
  lastname     varchar(255),
  nickname     varchar(255),
  passwordhash varchar(255) not null,
  role         varchar(255),
  id_address   bigint
    constraint fkohevr2hxidbx9tsunpjwhbbeo
      references addresses
);

alter table users
  owner to postgres;


