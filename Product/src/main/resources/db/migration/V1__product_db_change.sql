create table product
(
    id    integer generated by default as identity,
    name  varchar(30),
    price float,
    count integer,
    primary key (id)
);
insert into product(name, price, count)
values ('Пылесос',5500,10),
       ('Холодильник',2200,8),
       ('Телевизор',30000,7),
       ('Компьютер',40000,5),
       ('Стиральная машина',14,11);