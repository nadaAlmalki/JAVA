create database bank;

create table customer ( id varchar(25) primary key ,
username varchar(20) not null , email varchar(255) unique ,
 password varchar(20) not null ,
  role varchar(5) check( role='admin' or role = 'user' ) );

create table account ( id varchar(10) primary key ,
 balance int default 0 , customer_id varchar(25) ,
  foreign key (customer_id) references customer(id) );

create table loan ( id varchar(10) primary key ,
loanAmount int default 100 check ( loanAmount >= 100 ), isPaid boolean default false,
 account_id varchar(10) , foreign key (account_id) references account(id) );

create database store;

Create table countries(
    country_code int primary key ,
    name varchar(20) unique,
    continent_name varchar(20) not null
);

insert into countries values (1, 'Jeedah','KSA');

create table users(
    user_id int primary key,
    full_name  varchar(20),
    email varchar(20) unique,
    gender char(1) check ( gender='f' or gender='m'),
    date_of_birth varchar(15),
    created_at datetime DEFAULT timestamp(),
    country_code int,
    foreign key (country_code) references countries (country_code)
);
insert into users values (99, 'Nada Almalki','nada@hotmail.com','f','24/2/17', 1);

create table orders(
    order_id int primary key ,
    status varchar(6) check ( status='start' or status='finish'),
    created_at datetime DEFAULT timestamp(),
    user_id int,
     foreign key (user_id) references users (user_id)
);
insert into orders values (101, 'start', 99);

create table order_products(
    product_id int primary key ,
    quantity int default 0,
    order_id int,
    foreign key (order_id) references orders (order_id)

);
insert into order_products values (202,101);

create table products(
    id int primary key ,
    name varchar(10) not null ,
    price int default 0,
    status varchar(10) check ( status='valid' or status='expired'),
    created_at datetime DEFAULT timestamp(),
    product_id int,
     foreign key (product_id) references products (product_id)
);

insert into products values (303, 'product1', 'valid', 202);
insert into products values (304, 'product2', 'expired', 202);

update countries set name = 'Makkah'
where country_code = 1;

delete from products where id =  304;
