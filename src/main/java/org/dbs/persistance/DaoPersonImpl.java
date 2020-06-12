package org.dbs.persistance;

import org.dbs.business.Person;
import org.hibernate.Session;

import java.util.List;

public class DaoPersonImpl implements IDaoPerson {
    @Override
    public void save(Person person) throws JPAException {
        Session session = DaoFactory.getSession();
        session.beginTransaction();

        session.save(person);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Person> retrieveAllPerson() throws JPAException {
        Session session = DaoFactory.getSession();
        List <Person> persons = session.createQuery("from Person").list();
        session.close();

        return persons;
    }

    @Override
    public Person retrievePersonById(Long id) throws JPAException {
        Session session = DaoFactory.getSession();
        Person produit = session.find(Person.class, id);
        session.close();

        return produit;
    }

    @Override
    public List<Person> retrievePersonByName(String name) throws JPAException {
        Session session = DaoFactory.getSession();
        String request = "select p from Person p where p.name= :nom";
        List<Person> persons = session.createQuery(request).setParameter("nom", name).getResultList();
        session.close();

        return persons;
    }
}
