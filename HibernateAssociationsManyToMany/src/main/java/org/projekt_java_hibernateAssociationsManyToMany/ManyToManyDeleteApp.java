package org.projekt_java_hibernateAssociationsManyToMany;

import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.projekt_java_hibernateAssociationsManyToMany.entity.*;

/**
 * Created by Adam Seweryn
 */
@Data

public class ManyToManyDeleteApp {
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

        int idEmployee = 158;
        int idTraining = 1;

//        rozpoczecie transakcji
        session.beginTransaction();

//        Employee employee = session.get(Employee.class, idEmployee);
//        session.delete(employee);
        Training training = session.get(Training.class,idTraining);
        session.delete(training);
//        zakonczenie transakcji
        session.getTransaction().commit();

//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
