package org.projekt_java_hibernateAssociationsOneToMany;

import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.projekt_java_hibernateAssociationsOneToMany.entity.Company;
import org.projekt_java_hibernateAssociationsOneToMany.entity.CompanyDetail;
import org.projekt_java_hibernateAssociationsOneToMany.entity.Property;

import java.util.List;

/**
 * Created by Adam Seweryn
 */
@Data

public class OneToManyHqlApp {
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

        String getCompany ="select c.name from Property p join p.company c where p.city ='Sevilla' ";
        String getCompany2 ="select c.name from Property p join p.company c join c.companyDetail cd where p.city ='Barcelona' and cd.residence = 'Switzerland' ";
        String getCompany3 ="select c.name from Company c where size(c.properties) > 4";

//        rozpoczecie transakcji
        session.beginTransaction();
        Query query = session.createQuery(getCompany3);
        List<String> resultList = query.getResultList();
//        zakonczenie transakcji
        session.getTransaction().commit();
        for (String name :resultList) {
            System.out.println(name);
        }
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
