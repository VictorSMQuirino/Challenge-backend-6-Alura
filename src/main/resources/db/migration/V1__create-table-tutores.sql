create table tutores(
    id serial not null,
    nome varchar(100) not null,
    email varchar(100) not null,
    senha varchar(255) not null unique,

    primary key(id)
);