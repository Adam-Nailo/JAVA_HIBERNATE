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

public class CascadeApp {
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

        Company company = new Company("KGHM",134550440);
        CompanyDetail detail = new CompanyDetail("Poland",4450);
        company.setCompanyDetail(detail);

//        rozpoczecie transakcji
        session.beginTransaction();

        session.persist(company);

//        zakonczenie transakcji
        session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
