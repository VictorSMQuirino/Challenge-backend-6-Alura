CREATE TABLE pets (
    id SERIAL PRIMARY KEY,
    abrigo_id INTEGER NOT NULL,
    nome VARCHAR(20) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    adotado BOOLEAN NOT NULL,
    idade VARCHAR(50) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    imagem VARCHAR(100) NOT NULL,

    CONSTRAINT fk_pets_abrigos FOREIGN KEY (abrigo_id) REFERENCES abrigos(id)
)