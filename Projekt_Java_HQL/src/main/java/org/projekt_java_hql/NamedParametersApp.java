package org.projekt_java_hql;


import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.projekt_java_hql.entity.Employee;

import java.util.List;

/**
 * Created by Adam Seweryn
 */
@Data

public class NamedParametersApp {
    public static void main(String[] args) {
//        stworzenie obiektu Configuration
        Configuration configuration = new Configuration();
//        wczytanie pliku konfiguracyjnego
        configuration.configure("hibernate.cfg.xml");
//        wczytanie adnotacji
        configuration.addAnnotatedClass(Employee.class);
//        stworzenie obiektu SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();
//        pobranie sesji
        Session session = factory.getCurrentSession();

        String emplyeeFirstName = "Adam";
        String emplyeeLastName = "Seweryn";
//        rozpoczecie transakcji
        session.beginTransaction();

        String namedParameters = "select e.firstName, e.lastName, e.salary from Employee e where e.firstName=:firstName and e.lastName=:lastName";

        Query query = session.createQuery(namedParameters);
        query.setParameter("firstName",emplyeeFirstName);
        query.setParameter("lastName",emplyeeLastName);

        List<Object[]> result = query.getResultList();
        //        zakonczenie transakcji
        session.getTransaction().commit();
        for (Object[] values : result) {
            System.out.println("first name: " + values[0] + ", last name: " + values[1]+ ", salary: " + values[2]);
        }
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
