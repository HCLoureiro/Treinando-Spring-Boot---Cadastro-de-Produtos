create table categoria(

    id bigint not null auto_increment,
    codigo varchar(100) not null unique,
    descricao varchar(100) not null unique,
    ativo tinyint,

    primary key(id)
);