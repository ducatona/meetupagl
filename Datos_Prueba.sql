USE meet_up_agl;

-- Datos de prueba para la tabla de Usuarios
INSERT INTO users (user, password, active, email, first_name, last_name, age, gender, bio, profile_picture) VALUES
                ('jdoe', 'password123', TRUE, 'jdoe@example.com', 'John', 'Doe', 20, 'Masculino', 'Aficionado a la lectura y amante del café.', 'https://example.com/profiles/jdoe.jpg'),
                ('asmith', 'password456', TRUE, 'asmith@example.com', 'Anna', 'Smith', 22, 'Femenino', 'Amante de las caminatas y las aventuras al aire libre.', 'https://example.com/profiles/asmith.jpg'),
                ('bwilliams', 'password789', TRUE, 'bwilliams@example.com', 'Bob', 'Williams', 21, 'Masculino', 'Geek de la tecnología y gamer.', 'https://example.com/profiles/bwilliams.jpg'),
                ('cjones', 'password012', TRUE, 'cjones@example.com', 'Cathy', 'Jones', 19, 'Femenino', 'Amante de la música y chef aficionada.', 'https://example.com/profiles/cjones.jpg');

-- Datos de prueba para la tabla de Me gusta
INSERT INTO likes (id_user, id_liked_user) VALUES
                (1, 2),
                (2, 1),
                (1, 3),
                (3, 4),
                (4, 1);

-- Datos de prueba para la tabla de Conversaciones
INSERT INTO conversations (id_user1, id_user2) VALUES
                (1, 2),
                (1, 3),
                (3, 4);

-- Datos de prueba para la tabla de Mensajes
INSERT INTO messages (id_conversation, id_sender, content) VALUES
                (1, 1, 'Hola Anna, ¿cómo estás?'),
                (1, 2, 'Hola John, ¡estoy bien! ¿Y tú?'),
                (2, 1, 'Hola Bob, ¿quieres jugar unos juegos esta noche?'),
                (2, 3, '¡Claro John, suena genial!'),
                (3, 3, 'Hola Cathy, encantado de conocerte.'),
                (3, 4, 'Encantada de conocerte también, Bob.');


-- Datos de prueba para la tabla de Amigos
INSERT INTO friends (id_user1, id_user2, status) VALUES
                (1, 2, 'aceptada'),
                (1, 3, 'aceptada'),
                (3, 4, 'pendiente'),
                (4, 1, 'aceptada');

-- Datos de prueba para la tabla de Comentarios
INSERT INTO comments (id_user, content, id_post) VALUES
                (1, '¡Gran perfil, Anna!', 2),
                (2, '¡Gracias, John!', 2),
                (3, '¡Interesante bio, Bob!', 3),
                (4, '¡Me encanta tu bio, Cathy!', 4);

-- Datos de prueba para la tabla de Publicaciones
INSERT INTO posts (id_user, content) VALUES
                (1, '¡Acabo de terminar un gran libro!', CURRENT_TIMESTAMP),
                (2, '¡Tuve una increíble caminata hoy!', CURRENT_TIMESTAMP),
                (3, '¡Construí una nueva PC para juegos!', CURRENT_TIMESTAMP),
                (4, '¡Probé una nueva receta hoy, estaba deliciosa!', CURRENT_TIMESTAMP);

-- Datos de prueba para la tabla de Notificaciones
INSERT INTO notifications (id_user, message) VALUES
                (1, '¡Anna le gustó tu perfil!', CURRENT_TIMESTAMP),
                (2, '¡John te envió un mensaje!', CURRENT_TIMESTAMP),
                (3, '¡Cathy le gustó tu publicación!', CURRENT_TIMESTAMP),
                (4, '¡Bob comentó en tu publicación!', CURRENT_TIMESTAMP);



/*INSERT INTO users (id_user, user, password, active) VALUES
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
*/