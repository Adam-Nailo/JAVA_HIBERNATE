package org.projekt_java_hibernateAssociationsOneToManyUnidirectional;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.projekt_java_hibernateAssociationsOneToManyUnidirectional.entity.Company;
import org.projekt_java_hibernateAssociationsOneToManyUnidirectional.entity.CompanyDetail;
import org.projekt_java_hibernateAssociationsOneToManyUnidirectional.entity.Department;
import org.projekt_java_hibernateAssociationsOneToManyUnidirectional.entity.Property;

/**
 * Created by Adam Seweryn
 */
@Data

public class OneToManyUniSaveApp {
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
//        stworzenie obiektu SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();
//        pobranie sesji
        Session session = factory.getCurrentSession();

        int id = 24;

//        rozpoczecie transakcji
        session.beginTransaction();

        Company company = session.get(Company.class,id);
        System.out.println(company);

        Department department1 = new Department("sales");
        Department department2 = new Department("production");
        Department department3 = new Department("HR");

        company.addDepartment(department1);
        company.addDepartment(department2);
        company.addDepartment(department3);

        session.persist(company);
//        zakonczenie transakcji
        session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}