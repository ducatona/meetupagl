/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosBD;

import entidades.Users;
import java.util.List;
import javafx.concurrent.Task;
import javax.persistence.*;


/**
 *
 * @author Usuario
 */
public class MetodosInteraccionBD {
    
    
     private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Meet_up_Agl");

    public static void login(String username, String password, Runnable callback) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                EntityTransaction transaction = null;
                try {
                    transaction = entityManager.getTransaction();
                    transaction.begin();

                    TypedQuery<Long> query = entityManager.createQuery(
                            "SELECT COUNT(u) FROM Users u WHERE u.username = :username AND u.password = :password", Long.class);
                    query.setParameter("username", username);
                    query.setParameter("password", password);

                    Long count = query.getSingleResult();

                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                } finally {
                    entityManager.close();
                }
                return null;
            }

            @Override
            protected void succeeded() {
                callback.run();
            }

            @Override
            protected void failed() {
                getException().printStackTrace();
            }
        };

        new Thread(task).start();
    }

    public static void register(String username, String password, String email, Runnable callback) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                EntityTransaction transaction = null;
                try {
                    transaction = entityManager.getTransaction();
                    transaction.begin();

                    // Check if the username or email already exists
                    Query existsQuery = entityManager.createQuery("SELECT COUNT(u) FROM Users u WHERE u.username = :username OR u.email = :email");
                    existsQuery.setParameter("username", username);
                    existsQuery.setParameter("email", email);
                    Long count = (Long) existsQuery.getSingleResult();
                    if (count > 0) {
                        // Username or email already exists
                        return null; 
                    }

                    // Create a new user
                    Users newUser = new Users();
                    newUser.setUsername(username);
                    newUser.setPassword(password);
                    newUser.setEmail(email);

                    entityManager.persist(newUser);

                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                } finally {
                    entityManager.close();
                }
                return null;
            }

            @Override
            protected void succeeded() {
                callback.run();
            }

            @Override
            protected void failed() {
                getException().printStackTrace();
            }
        };

        new Thread(task).start();
    }

    public static void getAllUsers(Runnable callback) {
        Task<List<Users>> task = new Task<List<Users>>() {
            @Override
            protected List<Users> call() throws Exception {
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                try {
                    // Creamos una consulta para recuperar todos los usuarios
                    TypedQuery<Users> query = entityManager.createQuery("SELECT u FROM Users u", Users.class);
                    return query.getResultList(); // Devuelve una lista de todos los usuarios
                } finally {
                    entityManager.close();
                }
            }

            @Override
            protected void succeeded() {
                List<Users> users = getValue();
                // Puedes realizar cualquier acción con la lista de usuarios aquí
                callback.run();
            }

            @Override
            protected void failed() {
                getException().printStackTrace();
            }
        };

        new Thread(task).start();
    }
}
