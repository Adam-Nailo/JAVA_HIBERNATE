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
public class DeleteEntityApp {
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

        session.beginTransaction();
        Employee employee = session.get(Employee.class, 13);
        session.delete(employee);
        session.getTransaction().commit();

//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
