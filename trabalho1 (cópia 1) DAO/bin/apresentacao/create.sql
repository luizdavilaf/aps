drop table endereco CASCADE;
drop table contato CASCADE;




create table contato(
    id serial,
    cpf text not null,
    nome text not null,
    PRIMARY KEY (id_contato),
    UNIQUE (cpf)
);

create TABLE endereco(
    endereco_id serial,
    bairro text not null,
    logradouro text NOT NULL,
	numero integer not null,
    complemento text,    
    id_contato integer not null,
    PRIMARY KEY (endereco_id),
    FOREIGN KEY (id_contato) REFERENCES contato(id_contato)

);

create table pessoajuridica
(     
    cnpj text not null, 
    nomefantasia text not null,     
    UNIQUE (cnpj)
) INHERITS (contato);







