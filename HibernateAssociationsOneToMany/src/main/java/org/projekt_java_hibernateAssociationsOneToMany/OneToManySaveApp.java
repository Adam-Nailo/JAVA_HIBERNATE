package org.projekt_java_hibernateAssociationsOneToMany;

import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.projekt_java_hibernateAssociationsOneToMany.entity.Company;
import org.projekt_java_hibernateAssociationsOneToMany.entity.CompanyDetail;
import org.projekt_java_hibernateAssociationsOneToMany.entity.Property;

/**
 * Created by Adam Seweryn
 */
@Data

public class OneToManySaveApp {
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

        String getCompany = "select c from Company c where c.name ='Strefakursow'";

//        rozpoczecie transakcji
        session.beginTransaction();

        Query query = session.createQuery(getCompany);

        Company company = (Company) query.getSingleResult();

        Property property1 = new Property("Warszawa",40);
        Property property2 = new Property("Gdynia",30);

        company.addProperty(property1);
        company.addProperty(property2);

        session.persist(property1);
        session.persist(property2);

//        zakonczenie transakcji
        session.getTransaction().commit();
        System.out.println(company);
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
