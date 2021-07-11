
###############################
# mysql
###############################
create database previsao_tempo;
use previsao_tempo;

create table cidade (
	id integer not null primary key auto_increment,
	nome varchar(45)
);
