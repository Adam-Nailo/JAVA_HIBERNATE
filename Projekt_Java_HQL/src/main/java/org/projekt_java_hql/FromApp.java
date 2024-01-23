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

public class FromApp {
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
//

//        rozpoczecie transakcji
        session.beginTransaction();

        String from = "FROM Employee";

        Query<Employee> query= session.createQuery(from, Employee.class);

        List<Employee> list = query.getResultList();
//
//        zakonczenie transakcji
        session.getTransaction().commit();

        for (Employee employee : list) {
            System.out.println(employee);
        }
//

//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
