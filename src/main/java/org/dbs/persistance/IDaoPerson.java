package org.dbs.persistance;

import org.dbs.business.Person;

import java.util.List;

public interface IDaoPerson {
    void save(Person person) throws JPAException;
    List<Person> retrieveAllPerson() throws JPAException;
    Person retrievePersonById(Long id) throws JPAException;
    List<Person> retrievePersonByName(String name) throws JPAException;
}
