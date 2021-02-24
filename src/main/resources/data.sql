drop table if exists price;
create table price (
    price_uuid uuid primary key,
    brand_id int not null,
    start_date timestamp not null,
    end_date timestamp not null,
    price_list int not null,
    product_id int not null,
    priority int not null,
    price double not null,
    curr varchar(5) not null
);
insert into price (price_uuid, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) values
 (random_uuid(), '1', {ts '2020-06-14 00.00.00'}, {ts '2020-12-31 23.59.59'}, 1, 35455, 0, 35.50, 'eur'),
 (random_uuid(), '1', {ts '2020-06-14 15.00.00'}, {ts '2020-06-14 18.30.00'}, 2, 35455, 1, 25.45, 'eur'),
 (random_uuid(), '1', {ts '2020-06-15 00.00.00'}, {ts '2020-06-15 11.00.00'}, 3, 35455, 1, 30.50, 'eur'),
 (random_uuid(), '1', {ts '2020-06-15 16.00.00'}, {ts '2020-12-31 23.59.59'}, 4, 35455, 1, 38.95, 'eur');