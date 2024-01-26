package org.projekt_java_hibernateAssociations;

import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.projekt_java_hibernateAssociations.entity.Company;
import org.projekt_java_hibernateAssociations.entity.CompanyDetail;

/**
 * Created by Adam Seweryn
 */
@Data

public class CascadeRemoveApp {
    public static void main(String[] args) {
//        stworzenie obiektu Configuration
        Configuration configuration = new Configuration();
//        wczytanie pliku konfiguracyjnego
        configuration.configure("hibernate.cfg.xml");
//        wczytanie adnotacji
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);
//        stworzenie obiektu SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();
//        pobranie sesji
        Session session = factory.getCurrentSession();
//        rozpoczecie transakcji
        session.beginTransaction();

        Company company = session.get(Company.class,2);
        session.remove(company);
//        zakonczenie transakcji
        session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
