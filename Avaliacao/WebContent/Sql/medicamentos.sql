create database if not exists medicamentos;
use medicamentos;

create table medicamentos (
id int(11) NOT NULL auto_increment,
nome varchar(45) not null,
dosagem varchar(45) not null,
intervalo varchar(45) not null,
duracao varchar(45) not null,
primary key (id)
);