
create table products
(
    id           bigserial        not null
        constraint products_pkey
            primary key,
    date_created timestamp,
    date_updated timestamp,
    code         varchar(255),
    description  varchar(255),
    name         varchar(50),
    price        double precision not null,
    url_image    varchar(255)
);


alter sequence products_id_seq owner to ppl;

alter table products
    owner to ppl;
