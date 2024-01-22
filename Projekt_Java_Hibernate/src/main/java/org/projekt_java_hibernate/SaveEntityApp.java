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
        Employee employee = new Employee();
        employee.setIdEmployee(55);
        employee.setFirstName("Adam");
        employee.setLastName("Seweryn");
        employee.setSalary(10000);
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
