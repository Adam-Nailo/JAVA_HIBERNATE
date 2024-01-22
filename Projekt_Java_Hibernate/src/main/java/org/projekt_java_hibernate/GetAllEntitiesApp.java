package org.projekt_java_hibernate;


import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.projekt_java_hibernate.entity.Employee;

import java.util.List;

/**
 * Created by Adam Seweryn
 */
@Data

public class GetAllEntitiesApp {
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
//        rozpoczecie transakcji
        session.beginTransaction();

        List<Employee> resultList = session.createQuery("FROM Employee", Employee.class).getResultList();
        for (Employee employee : resultList) {
            System.out.println(employee);
        }

//        zakonczenie transakcji
        session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
