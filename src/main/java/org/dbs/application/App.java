package org.dbs.application;

import org.dbs.business.Employee;
import org.dbs.business.Person;
import org.dbs.business.PostalAdress;
import org.dbs.business.Role;
import org.dbs.persistance.DaoFactory;
import org.dbs.persistance.IDaoPerson;
import org.dbs.persistance.JPAException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        IDaoPerson daoPerson = DaoFactory.getPersonDao();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


        try {
            Person person = createJohnDoe(simpleDateFormat);
            daoPerson.save(person);
        } catch (ParseException e) {
            System.out.println("Pb de parse de date");
            e.printStackTrace();
        } catch (JPAException e) {
            System.out.println("Pb de JPA manipulation :-(");
            e.printStackTrace();
        }
    }

    private static Person createJohnDoe(SimpleDateFormat simpleDateFormat) throws ParseException {
        Person person = new Person();

        Set<Role> roles = new HashSet<>();
        Employee employeeAEmp1 = new Employee();
        employeeAEmp1.setDescription("Travail pour Big Company avec ferveur");
        employeeAEmp1.setActif(Boolean.TRUE);
        employeeAEmp1.setDateEntree(simpleDateFormat.parse("01/05/2009"));
        employeeAEmp1.setPerson(person);
        roles.add(employeeAEmp1);

        Employee employeeAEnp2 = new Employee();
        employeeAEnp2.setDescription("Travail pour More little one trop cool");
        employeeAEnp2.setActif(Boolean.FALSE);
        employeeAEnp2.setDateEntree(simpleDateFormat.parse("01/11/2002"));
        employeeAEnp2.setDateSortie(simpleDateFormat.parse("30/04/2009"));
        employeeAEmp1.setPerson(person);
        roles.add(employeeAEnp2);

        PostalAdress postalAdress = new PostalAdress();
        postalAdress.setCity("KnockleZou les Oies");
        postalAdress.setNumber(4);
        postalAdress.setStreet("Rue de la belle vue");
        postalAdress.setZipCode("04320");

        Set<Person> persons = new HashSet<>();
        persons.add(person);
        postalAdress.setPersons(persons);

        person.setName("Jhon Doe");
        person.setPostalAdress(postalAdress);
        person.setRoles(roles);
        return person;
    }
}
