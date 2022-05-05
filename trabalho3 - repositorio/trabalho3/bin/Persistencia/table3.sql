drop table bilhete CASCADE;
drop table sessao CASCADE;
drop table filme CASCADE;
drop table lugar CASCADE;
drop table sala CASCADE;


CREATE TABLE sala( 
	id serial, 
	nome text not null,
	Primary key (id)
);


CREATE TABLE lugar( 
    id serial,
    sala int not null,
	acento text not null,
	FOREIGN KEY(sala) REFERENCES sala (id),
	Primary key (id),
	UNIQUE(acento,
	sala)
);


CREATE TABLE filme( 
	id serial,
	nome text not null,
	Primary key (id)
);


CREATE TABLE sessao(
	id serial, 
	data date NOT NULL,
	hora time NOT NULL,
	filme int not null,
	sala int not null,
	valor real not null,
	Primary key (id),
	FOREIGN KEY(filme) REFERENCES filme (id),
	FOREIGN KEY(sala) REFERENCES sala (id)
);


CREATE TABLE bilhete( 
    id serial,       
    lugar int not null,
    sessao int not null,
    FOREIGN KEY(lugar) REFERENCES lugar (id),  
    FOREIGN KEY(sessao) REFERENCES sessao (id),
    Primary key (id),
    UNIQUE(lugar, sessao)
    
) ;