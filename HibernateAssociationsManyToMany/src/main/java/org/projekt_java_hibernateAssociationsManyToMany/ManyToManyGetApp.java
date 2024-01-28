package org.projekt_java_hibernateAssociationsManyToMany;

import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.projekt_java_hibernateAssociationsManyToMany.entity.*;

import java.util.List;


/**
 * Created by Adam Seweryn
 */
@Data

public class ManyToManyGetApp {
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

        int id = 1;

//        rozpoczecie transakcji
        session.beginTransaction();

//        Training training = new Training("java training");
//
//        Employee employee1 = session.get(Employee.class,157);
//        Employee employee2 = session.get(Employee.class,158);
//
//        training.addEmployee(employee1);
//        training.addEmployee(employee2);
//        session.persist(training);

        String getTraining = "from Training";

        Query query = session.createQuery(getTraining);

        List<Training> resultList = query.getResultList();

        for (Training training: resultList){
            System.out.println("\n" + training);
            for (Employee employee: training.getEmployees()){
                System.out.println("- " + employee);
            }
        }

//        Training training = session.get(Training.class,id);
//
//        System.out.println(training);
//
//        for (Employee employee: training.getEmployees()){
//            System.out.println(employee);
//        }

//        zakonczenie transakcji
        session.getTransaction().commit();

//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
