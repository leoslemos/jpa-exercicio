create database jpa_exercicio;
use jpa_exercicio;

drop table pessoa;
drop table empresa;

create table pessoa(
	id_pessoa int not null auto_increment
    , nome varchar(45)
    , sobrenome varchar(45)
    , id_empresa int not null
    
    , primary key (id_pessoa)
    , foreign key (id_empresa) references empresa (id_empresa)
);

create table empresa(
	id_empresa int not null auto_increment
    , nome varchar(45)
    
    , primary key (id_empresa)
);

select * from pessoa;
select * from empresa;