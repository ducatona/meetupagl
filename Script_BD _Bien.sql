-- Create the database if it does not exist
CREATE DATABASE IF NOT EXISTS meet_up_agl;

-- Use the database
USE meet_up_agl;

-- Table for Users
CREATE TABLE users (
    id_user INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INT,
    gender VARCHAR(10),
    bio TEXT,
    profile_picture VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Table for Posts
CREATE TABLE posts (
    id_post INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,
    content TEXT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);

-- Table for Likes
CREATE TABLE likes (
    id_like INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,
    id_liked_user INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_user) REFERENCES users(id_user),
    FOREIGN KEY (id_liked_user) REFERENCES users(id_user)
);

-- Table for Conversations
CREATE TABLE conversations (
    id_conversation INT PRIMARY KEY AUTO_INCREMENT,
    id_user1 INT NOT NULL,
    id_user2 INT NOT NULL,
    started_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_user1) REFERENCES users(id_user),
    FOREIGN KEY (id_user2) REFERENCES users(id_user)
);

-- Table for Messages
CREATE TABLE messages (
    id_message INT PRIMARY KEY AUTO_INCREMENT,
    id_conversation INT NOT NULL,
    id_sender INT NOT NULL,
    content TEXT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_conversation) REFERENCES conversations(id_conversation),
    FOREIGN KEY (id_sender) REFERENCES users(id_user)
);

-- Table for Friends
CREATE TABLE friends (
    id_friendship INT PRIMARY KEY AUTO_INCREMENT,
    id_user1 INT NOT NULL,
    id_user2 INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_user1) REFERENCES users(id_user),
    FOREIGN KEY (id_user2) REFERENCES users(id_user)
);

-- Table for Comments
CREATE TABLE comments (
    id_comment INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,
    content TEXT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_post INT NOT NULL,
    FOREIGN KEY (id_user) REFERENCES users(id_user),
    FOREIGN KEY (id_post) REFERENCES posts(id_post)
);

-- Table for Notifications
CREATE TABLE notifications (
    id_notification INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,
    message TEXT NOT NULL,
    leido BOOLEAN DEFAULT FALSE, -- Indicates if the notification has been read (TRUE) or not (FALSE)
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);


