CREATE DATABASE IF NOT EXISTS meet_up_agl;

USE meet_up_agl;

-- Tabla de Usuarios
CREATE TABLE users (
                       id_user INT PRIMARY KEY AUTO_INCREMENT,
                       user VARCHAR(255),
                       password VARCHAR(255),
                       active BOOLEAN,
                       email VARCHAR(100),
                       first_name VARCHAR(50),
                       last_name VARCHAR(50),
                       age INT,
                       gender VARCHAR(10),
                       bio TEXT,
                       profile_picture VARCHAR(255),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla de Me gusta
CREATE TABLE likes (
                       id_like INT PRIMARY KEY AUTO_INCREMENT,
                       id_user INT,
                       id_liked_user INT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (id_user) REFERENCES users(id_user),
                       FOREIGN KEY (id_liked_user) REFERENCES users(id_user)
);

-- Tabla de Conversaciones
CREATE TABLE conversations (
                               id_conversation INT PRIMARY KEY AUTO_INCREMENT,
                               id_user1 INT,
                               id_user2 INT,
                               started_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (id_user1) REFERENCES users(id_user),
                               FOREIGN KEY (id_user2) REFERENCES users(id_user)
);

-- Tabla de Mensajes
CREATE TABLE messages (
                          id_message INT PRIMARY KEY AUTO_INCREMENT,
                          id_conversation INT,
                          id_sender INT,
                          content TEXT,
                          timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (id_conversation) REFERENCES conversations(id_conversation),
                          FOREIGN KEY (id_sender) REFERENCES users(id_user)
);



-- Tabla de Amigos
CREATE TABLE friends (
                         id_friendship INT PRIMARY KEY AUTO_INCREMENT,
                         id_user1 INT,
                         id_user2 INT,
                         status VARCHAR(20),
                         FOREIGN KEY (id_user1) REFERENCES users(id_user),
                         FOREIGN KEY (id_user2) REFERENCES users(id_user)
);

-- Tabla de Comentarios
CREATE TABLE comments (
                          id_comment INT PRIMARY KEY AUTO_INCREMENT,
                          id_user INT,
                          content TEXT,
                          timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          id_post INT,
                          FOREIGN KEY (id_user) REFERENCES users(id_user)
);

-- Tabla de Publicaciones
CREATE TABLE posts (
                       id_post INT PRIMARY KEY AUTO_INCREMENT,
                       id_user INT,
                       content TEXT,
                       timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (id_user) REFERENCES users(id_user)
);

-- Tabla de Notificaciones
CREATE TABLE notifications (
                               id_notification INT PRIMARY KEY AUTO_INCREMENT,
                               id_user INT,
                               message TEXT,
                               read BOOLEAN DEFAULT FALSE,
                               timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (id_user) REFERENCES users(id_user)
);

/*CREATE DATABASE IF NOT EXISTS meet_up_agl;

USE meet_up_agl;

-- Tabla de Usuarios
CREATE TABLE users (
    id_user INT PRIMARY KEY,
    user VARCHAR(255),
    password VARCHAR(255),
    active BOOLEAN
);

-- Tabla de Me gusta
CREATE TABLE likes (
    id_like INT PRIMARY KEY,
    id_user INT,
    id_liked_user INT,
    FOREIGN KEY (id_user) REFERENCES users(id_user),
    FOREIGN KEY (id_liked_user) REFERENCES users(id_user)
);

-- Tabla de Conversaciones
CREATE TABLE conversations (
    id_conversation INT PRIMARY KEY,
    id_user1 INT,
    id_user2 INT,
    FOREIGN KEY (id_user1) REFERENCES users(id_user),
    FOREIGN KEY (id_user2) REFERENCES users(id_user)
);

-- Tabla de Mensajes
CREATE TABLE messages (
    id_message INT PRIMARY KEY,
    id_conversation INT,
    id_sender INT,
    content TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_conversation) REFERENCES conversations(id_conversation),
    FOREIGN KEY (id_sender) REFERENCES users(id_user)
);*/
