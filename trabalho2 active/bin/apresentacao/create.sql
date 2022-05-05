drop table endereco CASCADE;
drop table pessoajuridica CASCADE;
drop table contato CASCADE;




create table contato(
    id serial,
    cpf text not null,
    nome text not null,
    PRIMARY KEY (id),
    UNIQUE (cpf)
);

create table pessoajuridica 
(
    id serial,
    cnpj text not null, 
    nomefantasia text not null,
    contato INTEGER not null,
    PRIMARY KEY (id), 
    FOREIGN KEY (contato) REFERENCES contato(id),
    UNIQUE (cnpj)
);

create TABLE endereco(
    id serial,
    bairro text not null,
    logradouro text NOT NULL,
	numero integer not null,
    complemento text,    
    contato integer not null,
    pessoajuridica integer,
    PRIMARY KEY (id),
    FOREIGN KEY (contato) REFERENCES contato(id),   
    FOREIGN KEY (pessoajuridica) REFERENCES pessoajuridica(id)

);









