INSERT INTO users (id_user, user, password, active) VALUES
(1, 'usuario1', 'contraseña1', 1),
(2, 'usuario2', 'contraseña2', 1),
(3, 'usuario3', 'contraseña3', 1);
INSERT INTO likes (id_like, id_user, id_liked_user) VALUES
(1, 1, 2),
(2, 2, 1);
INSERT INTO conversations (id_conversation, id_user1, id_user2) VALUES
(1, 1, 2);
INSERT INTO messages (id_message, id_conversation, id_sender, content) VALUES
(1, 1, 1, '¡Hola, usuario2! ¿Cómo estás?'),
(2, 1, 2, 'Hola, usuario1. Estoy bien, gracias. ¿Y tú?');
