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

public class AggregateFunctionsApp {
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
        String avg = "select avg(e.salary) from Employee e";
        String sum = "select sum(e.salary) from Employee e";
        String min = "select min(e.salary) from Employee e";
        String max = "select max(e.salary) from Employee e";
        String count = "select count(e) from Employee e";
        Query query = session.createQuery(count);

        long result = (long) query.getSingleResult();

        session.getTransaction().commit();

        System.out.println("wynik: "+result);

//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
