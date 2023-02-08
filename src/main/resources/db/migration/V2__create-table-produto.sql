create table produto(

    id bigint not null auto_increment,
    codigo varchar(100) not null unique,
    descricao varchar(100) not null unique,
    categoriaID bigint not null,
    ativo tinyint,

    primary key(id),
    foreign key(categoriaID) references categoria(id)
);