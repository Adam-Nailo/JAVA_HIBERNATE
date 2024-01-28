package org.projekt_java_hibernateAssociationsManyToMany;

import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.projekt_java_hibernateAssociationsManyToMany.entity.*;


/**
 * Created by Adam Seweryn
 */
@Data

public class ManyToManySaveApp {
    public static void main(String[] args) {
//        stworzenie obiektu Configuration
        Configuration configuration = new Configuration();
//        wczytanie pliku konfiguracyjnego
        configuration.configure("hibernate.cfg.xml");
//        wczytanie adnotacji
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);
        configuration.addAnnotatedClass(Property.class);
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Training.class);
//        stworzenie obiektu SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();
//        pobranie sesji
        Session session = factory.getCurrentSession();


//        rozpoczecie transakcji
        session.beginTransaction();

        Training training = new Training("sales training");

        Employee employee1 = new Employee("Jan","Kowalski", 10000);
        Employee employee2 = new Employee("Paweł","Nowak", 13000);

        training.addEmployee(employee1);
        training.addEmployee(employee2);

        session.persist(training);

//        zakonczenie transakcji
        session.getTransaction().commit();

//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
