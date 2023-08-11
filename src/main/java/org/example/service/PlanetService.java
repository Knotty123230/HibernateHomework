package org.example.service;

import org.example.dto.Planet;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class PlanetService {

    public Planet getPlanetByID(String id) {
        Planet planet;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            planet = session.get(Planet.class, id);
            if (planet == null) {
                throw new RuntimeException("planet not found");
            }
        }
        return planet;
    }

    public void createPlanet(String id, String name) {
        Transaction transaction = null;
        Planet planet = new Planet();
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            planet.setName(name);
            planet.setId(id);
            transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (Exception e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    public void deleteById(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.remove(planet);
            } else {
                throw new RuntimeException("Planet not found by id");
            }
            transaction.commit();
        } catch (Exception e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    public void updateById(String id, String name) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                planet.setName(name);
                transaction = session.beginTransaction();
                session.persist(planet);
                transaction.commit();
            } else throw new RuntimeException("planet not found, you need to create");
        } catch (Exception e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    public List<Planet> getAll() {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

}
