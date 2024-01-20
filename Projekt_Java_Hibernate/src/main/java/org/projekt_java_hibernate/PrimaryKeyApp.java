package org.projekt_java_hibernate;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.projekt_java_hibernate.entity.Employee;

/**
 * Created by Adam Seweryn
 */
@Data
public class PrimaryKeyApp {
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
//        stworzenie 3 obiektow
        Employee employee1 = Employee.builder()
                .firstName("Krzysztof")
                .lastName("Nowak")
                .salary(10000)
                .build();

        Employee employee2 = Employee.builder()
                .firstName("Janina")
                .lastName("Kowalski")
                .salary(10000)
                .build();

        Employee employee3 = Employee.builder()
                .firstName("Andrzej")
                .lastName("Sienkiewicz")
                .salary(10000)
                .build();
//        rozpoczecie transakcji
        session.beginTransaction();
//        zapisanie 3 pracownikow
        session.persist(employee1);
        session.persist(employee2);
        session.persist(employee3);
//        zakonczenie transakcji
        session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
