package org.dbs.application;

import org.dbs.business.Employee;
import org.dbs.business.Person;
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
            Set<Role> roles = new HashSet<>();
            Person person = new Person();
            Employee employeeABNPP = new Employee();
            employeeABNPP.setDescription("Travail pour BNP Paribas avec ferveur");
            employeeABNPP.setActif(Boolean.TRUE);
            employeeABNPP.setDateEntree(simpleDateFormat.parse("01/05/2009"));
            employeeABNPP.setPerson(person);
            roles.add(employeeABNPP);

            Employee employeeATSYS = new Employee();
            employeeATSYS.setDescription("Travail pour T-System trop cool");
            employeeATSYS.setActif(Boolean.FALSE);
            employeeATSYS.setDateEntree(simpleDateFormat.parse("01/11/2002"));
            employeeATSYS.setDateSortie(simpleDateFormat.parse("30/04/2009"));
            employeeABNPP.setPerson(person);
            roles.add(employeeATSYS);

            person.setName("Jhon Doe");
            person.setRoles(roles);

            daoPerson.save(person);
        } catch (ParseException e) {
            System.out.println("Pb de parse de date");
            e.printStackTrace();
        } catch (JPAException e) {
            System.out.println("Pb de JPA manipulation :-(");
            e.printStackTrace();
        }
    }
}
