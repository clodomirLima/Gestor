create database db;

use db;

create table gestor(
id int not null primary key auto_increment,
nome varchar(10),
idade int,
endereco varchar(10),
telefone int);

insert into gestor
values(null, 'ana', 20, 'qnn', 5555);

select * from gestor;
