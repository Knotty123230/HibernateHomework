package org.example.util;

import org.example.dto.Client;
import org.example.dto.Planet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private HibernateUtil() {
    }


    static {
        sessionFactory = new Configuration().addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }
    public static SessionFactory getConfiguration(){
        return sessionFactory;
    }
}
