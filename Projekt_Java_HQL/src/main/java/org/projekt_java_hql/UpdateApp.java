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

public class UpdateApp {
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

        int idEmployee = 6;
        int salary = 15000;

//        rozpoczecie transakcji
        session.beginTransaction();
        String update = "update Employee e set e.salary =:salary where e.idEmployee =: idEmployee";
        Query query = session.createQuery(update);
        query.setParameter("salary",salary);
        query.setParameter("idEmployee",idEmployee);
        query.executeUpdate();
        session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
