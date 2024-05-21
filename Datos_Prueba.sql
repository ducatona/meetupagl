USE meet_up_agl;

-- Insert records into users table
INSERT INTO users (username, password, active, email, first_name, last_name, age, gender, bio, profile_picture)
VALUES 
('user1', 'password1', TRUE, 'user1@example.com', 'John', 'Doe', 25, 'Male', 'Bio of user1', 'pic1.jpg'),
('user2', 'password2', TRUE, 'user2@example.com', 'Jane', 'Doe', 28, 'Female', 'Bio of user2', 'pic2.jpg'),
('user3', 'password3', TRUE, 'user3@example.com', 'Alice', 'Smith', 22, 'Female', 'Bio of user3', 'pic3.jpg');

-- Insert records into posts table
INSERT INTO posts (id_user, content)
VALUES 
(1, 'This is the first post by user1.'),
(2, 'This is the first post by user2.'),
(3, 'This is the first post by user3.');

-- Insert records into likes table
INSERT INTO likes (id_user, id_liked_user)
VALUES 
(1, 2),
(2, 3),
(3, 1);

-- Insert records into conversations table
INSERT INTO conversations (id_user1, id_user2)
VALUES 
(1, 2),
(2, 3),
(1, 3);

-- Insert records into messages table
INSERT INTO messages (id_conversation, id_sender, content)
VALUES 
(1, 1, 'Hi user2! This is user1.'),
(2, 2, 'Hi user3! This is user2.'),
(3, 3, 'Hi user1! This is user3.');

-- Insert records into friends table
INSERT INTO friends (id_user1, id_user2, status)
VALUES 
(1, 2, 'accepted'),
(2, 3, 'pending'),
(1, 3, 'accepted');

-- Insert records into comments table
INSERT INTO comments (id_user, content, id_post)
VALUES 
(1, 'Nice post!', 2),
(2, 'Thanks!', 3),
(3, 'Great post!', 1);

-- Insert records into notifications table
INSERT INTO notifications (id_user, message)
VALUES 
(1, 'You have a new like from user2.'),
(2, 'You have a new friend request from user3.'),
(3, 'You have a new message from user1.');
