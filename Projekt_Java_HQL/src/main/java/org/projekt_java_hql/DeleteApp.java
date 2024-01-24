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

public class DeleteApp {
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

//        rozpoczecie transakcji
        session.beginTransaction();
        String delete = "delete Employee e where e.idEmployee =: idEmployee";
        Query query = session.createQuery(delete);
        query.setParameter("idEmployee", idEmployee);
        int rows = query.executeUpdate();
        System.out.println("Liczba usunietych wierszy: " + rows);
        session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
