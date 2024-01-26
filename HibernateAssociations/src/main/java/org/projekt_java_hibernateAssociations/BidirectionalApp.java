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

public class BidirectionalApp {
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

//        Company company = new Company("PZU", 10000000);
//        CompanyDetail detail = new CompanyDetail("Poland", 1500);
//        detail.setCompany(company);
//        company.setCompanyDetail(detail);

//        rozpoczecie transakcji
        session.beginTransaction();
//        dodanie obiektu
//        session.persist(detail);
//        odczyt danych
        CompanyDetail detail = session.get(CompanyDetail.class, 3);
//        usuwanie obiektu
        session.remove(detail);
//        zakonczenie transakcji
        session.getTransaction().commit();

//       System.out.println(detail.getCompany().getName());
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
