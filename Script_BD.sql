CREATE DATABASE IF NOT EXISTS meet_up_agl;

USE meet_up_agl;

-- Tabla de Usuarios
CREATE TABLE users (
    id_user INT PRIMARY KEY auto_increment,
    user VARCHAR(255),
    password VARCHAR(255),
    active BOOLEAN 
    
);

-- Tabla de Me gusta
CREATE TABLE likes (
    id_like INT PRIMARY KEY auto_increment,
    id_user INT,
    id_liked_user INT,
    FOREIGN KEY (id_user) REFERENCES users(id_user),
    FOREIGN KEY (id_liked_user) REFERENCES users(id_user)
);

-- Tabla de Conversaciones
CREATE TABLE conversations (
    id_conversation INT PRIMARY KEY auto_increment,
    id_user1 INT,
    id_user2 INT,
    FOREIGN KEY (id_user1) REFERENCES users(id_user),
    FOREIGN KEY (id_user2) REFERENCES users(id_user)
);

-- Tabla de Mensajes
CREATE TABLE messages (
    id_message INT PRIMARY KEY auto_increment,
    id_conversation INT,
    id_sender INT,
    content TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_conversation) REFERENCES conversations(id_conversation),
    FOREIGN KEY (id_sender) REFERENCES users(id_user)
);

