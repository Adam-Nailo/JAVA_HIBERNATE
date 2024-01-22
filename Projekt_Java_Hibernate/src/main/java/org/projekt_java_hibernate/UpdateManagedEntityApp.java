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
public class UpdateManagedEntityApp {
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
        Employee employee = session.get(Employee.class, 1);
        employee.setFirstName("Jan");
        session.getTransaction().commit();
        System.out.println("Zaktualizowane dane pracownika" + employee);
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
