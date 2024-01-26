package org.projekt_java_hibernateAssociations;

import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.projekt_java_hibernateAssociations.entity.Company;
import org.projekt_java_hibernateAssociations.entity.CompanyDetail;

import java.util.List;

/**
 * Created by Adam Seweryn
 */
@Data

public class OneToOneHqlApp {
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
        String select = "select c from Company c";
        String where = "select c from Company c join c.companyDetail cd where cd.residence ='Italy'";
        String sum = "select sum(c.value) from Company c join c.companyDetail cd where cd.residence ='Poland'";
        String orderBy ="select c.name from CompanyDetail cd join cd.company c where cd.employeeNumber < 35000 order by c.value";
        Query query = session.createQuery(orderBy);
//        List<CompanyDetail> resultList = query.getResultList();

//        long result = (long) query.getSingleResult();
        List<String> resultList = query.getResultList();
//        zakonczenie transakcji
        session.getTransaction().commit();

//        for (CompanyDetail cd :resultList){
//            System.out.println(cd.getCompany()+", "+cd);
//        }

//        System.out.println(result);

        for (String name :resultList){
            System.out.println(name);
        }
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}
