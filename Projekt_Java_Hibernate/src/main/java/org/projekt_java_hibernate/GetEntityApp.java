package org.projekt_java_hibernate;


import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.projekt_java_hibernate.entity.Employee;

/**
 * Created by Adam Seweryn
 */
@Data

public class GetEntityApp {
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
                .firstName("Tadeusz")
                .lastName("Wisnewski")
                .salary(10000)
                .build();
//        rozpoczecie transakcji
        session.beginTransaction();
//        zapisanie pracownika
        session.persist(employee);
        session.flush();
        int id = employee.getIdEmployee();
//        zakonczenie transakcji
        session.getTransaction().commit();

        session = factory.getCurrentSession();
        session.beginTransaction();
        Employee retrivedEmployee = session.get(Employee.class, id);
        session.getTransaction().commit();
        System.out.println("Dane pracownika:" + retrivedEmployee);

//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
