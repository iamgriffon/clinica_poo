create database clinica;

use clinica;

create table medico (
    crm varchar(20) primary key,
    nome varchar(100),
    telefone char(11),
    senha char(8),
	especialidade varchar(50)
);

create table recepcionista (
     cpf char(11) primary key,
     nome varchar(100),
     telefone char(11),
     senha char(8)
);

create table receita (
	id int primary key auto_increment,
    id_consulta int,
    data_receita date,
    descritivo varchar(100)
);

create table exame (
	id int primary key auto_increment,
    id_consulta int,
    data_exame date,
    descritivo varchar(100)
);



