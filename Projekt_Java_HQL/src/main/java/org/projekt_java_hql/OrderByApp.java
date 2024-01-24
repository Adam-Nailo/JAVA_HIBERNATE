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

public class OrderByApp {
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

        String orderBy = "select e.firstName, e.lastName from Employee e order by e.firstName, e.lastName";
        String orderBy2 = "select e.firstName, e.lastName from Employee e order by e.firstName desc";

        Query query = session.createQuery(orderBy);
        List<Object[]> result = query.getResultList();
        //        zakonczenie transakcji
        session.getTransaction().commit();
        for (Object[] values : result) {
            System.out.println("first name: " + values[0] + ", last name: " + values[1]);
        }
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
