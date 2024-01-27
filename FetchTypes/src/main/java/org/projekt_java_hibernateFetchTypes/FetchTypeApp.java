package org.projekt_java_hibernateFetchTypes;

import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.projekt_java_hibernateFetchTypes.entity.Company;
import org.projekt_java_hibernateFetchTypes.entity.CompanyDetail;
import org.projekt_java_hibernateFetchTypes.entity.Property;


/**
 * Created by Adam Seweryn
 */
@Data

public class FetchTypeApp {
    public static void main(String[] args) {
//        stworzenie obiektu Configuration
        Configuration configuration = new Configuration();
//        wczytanie pliku konfiguracyjnego
        configuration.configure("hibernate.cfg.xml");
//        wczytanie adnotacji
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);
        configuration.addAnnotatedClass(Property.class);
//        stworzenie obiektu SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();
//        pobranie sesji
        Session session = factory.getCurrentSession();

        int id = 19;

//        rozpoczecie transakcji
        session.beginTransaction();

        System.out.println("Pobieranie obiektu company");
        Company company = session.get(Company.class, id);
        System.out.println("Pobierano obiekt company");
        System.out.println(company);
        System.out.println("Nieruchomości:");
        for (Property property: company.getProperties()){
            System.out.println(property);
        }

//        zakonczenie transakcji
        session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
