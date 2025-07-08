-- Tabla USUARIOS

CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    fec_registro DATE NOT NULL,
    pais VARCHAR(50) NOT NULL,
    rol VARCHAR(10) NOT NULL,
    es_activo BOOLEAN NOT NULL

);

-- Tabla CUENTAS

CREATE TABLE cuentas (
    id BIGSERIAL PRIMARY KEY,
    nom_cuenta VARCHAR(30) NOT NULL,
    tipo_cuenta VARCHAR(20) NOT NULL,
    fec_creacion DATE NOT NULL,
    bal_inicial DECIMAL(10,2) NOT NULL,
    bal_actual DECIMAL(10,2) NOT NULL,
    lim_credito DECIMAL(10,2),
    descripcion VARCHAR(255),
    es_predeterminada BOOLEAN NOT NULL,
    estado VARCHAR(20) NOT NULL,
    moneda VARCHAR(3) NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Table CATEGORIA

CREATE TABLE categorias (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    color VARCHAR(50) NOT NULL,
    icono VARCHAR(255),
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
)