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

public class OneToManyGetApp {
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

        for (Property property: company.getProperties()){
            System.out.println(property);
        }
//        zakonczenie transakcji
        session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
