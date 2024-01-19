package org.projekt_java_hibernate;


import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Adam Seweryn
 */
@Data

public class SaveEntityApp {
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
//        stworzenie obiektu
        Employee employee = Employee.builder()
                .idEmployee(4)
                .firstName("Jan")
                .lastName("Kowalski")
                .salary(10000)
                .build();
//        rozpoczecie transakcji
session.beginTransaction();
//        zapisanie pracownika
session.persist(employee);
//        zakonczenie transakcji
session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
factory.close();

    }
}
