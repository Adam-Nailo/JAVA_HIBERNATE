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

public class WhereApp {
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

        String where = "from Employee where firstName='Adam'";
        String where2 ="from Employee where salary > 12000";
        String where3 ="from Employee where salary > 13000 or salary < 3000";
        String where4 ="from Employee where salary is null";
        String where5 = "from Employee where lastName in ('Nowak','Sienkiewicz')";

        Query<Employee> query= session.createQuery(where5, Employee.class);

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
