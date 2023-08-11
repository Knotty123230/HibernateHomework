package org.example.service;

import org.example.dto.Planet;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PlanetService {
    private final Logger logger = Logger.getLogger("Logger");

    public Planet getPlanetByID(String id) {
        Planet planet = null;
        try (Session session = HibernateUtil.getInstance().openSession();) {
            planet = session.get(Planet.class, id);
            if (planet == null) {
                throw new RuntimeException("planet not found");
            }
        }
        return planet;
    }

    public void createPlanet(String id, String name) {
        Planet planet = new Planet();
        try (Session session = HibernateUtil.getInstance().openSession()) {
            planet.setName(name);
            planet.setId(id);
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    public void deleteById(String id) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.remove(planet);
            } else {
                transaction.rollback();
                throw new RuntimeException("Planet not found by id");
            }
            transaction.commit();
        }
    }

    public void updateById(String id, String name) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                planet.setName(name);
                Transaction transaction = session.beginTransaction();
                session.persist(planet);
                transaction.commit();
            } else throw new RuntimeException("planet not found, you need to create");
        }
    }

    public static void main(String[] args) {
        new PlanetService().deleteById("KARS");
    }
}
