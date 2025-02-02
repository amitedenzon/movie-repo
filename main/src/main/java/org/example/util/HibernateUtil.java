package org.example.util;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.DAO.Actor;
import org.example.entity.DAO.Director;
import org.example.entity.DAO.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Getter
@Setter
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver") // Update for your DB
                    .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/library") // Update for your DB
                    .setProperty("hibernate.connection.username", "fishi") // Replace with your username
                    .setProperty("hibernate.connection.password", "12345") // Replace with your password
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect") // Update for your DB
                    .addAnnotatedClass(Actor.class) // Add your entity classes
                    .addAnnotatedClass(Director.class)
                    .addAnnotatedClass(Movie.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
}
