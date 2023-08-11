package org.example.service;

import org.example.dto.Client;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientService {


    public Client getClientById(long id) throws RuntimeException {
        Client client;
        try (Session session = HibernateUtil.getInstance().openSession()) {
            client = session.get(Client.class, id);
            if (client == null) {
                throw new RuntimeException("Client not found");
            }
        }
        return client;
    }

    public void createClient(Client client) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateClient(long id, String name) throws RuntimeException {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client1 = session.get(Client.class, id);
            if (client1 != null) {
                client1.setName(name);
                session.persist(client1);
            } else throw new RuntimeException("Client don't found");
            transaction.commit();
        }
    }

    public void deleteByID(long id) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.remove(client);
            transaction.commit();
        }
    }
}
