package org.example.service;

import org.example.dto.Client;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientService {


    public Client getClientById(long id)  {
        Client client;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            client = session.get(Client.class, id);
            if (client == null) {
                throw new RuntimeException("Client not found");
            }
        }
        return client;
    }

    public void createClient(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    public void updateClient(long id, String name)  {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            Client client1 = session.get(Client.class, id);
            if (client1 != null) {
                client1.setName(name);
                session.persist(client1);
            } else throw new RuntimeException("Client don't found");
            transaction.commit();
        } catch (Exception e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    public void deleteByID(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.remove(client);
            transaction.commit();
        } catch (Exception e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    public List<Client> getAll() {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            return session.createQuery("from Client ", Client.class).list();
        }
    }
}
