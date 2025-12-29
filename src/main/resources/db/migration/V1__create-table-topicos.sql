create table topico(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem varchar(200) not null,
    dataDeCriacao varchar(10) not null,
    estadoDoTopico varchar(30) not null,
    autor varchar(100) not null,
    curso varchar(100) not null,

);
