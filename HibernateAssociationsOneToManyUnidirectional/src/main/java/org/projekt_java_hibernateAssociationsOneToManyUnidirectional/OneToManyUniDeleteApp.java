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

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by Adam Seweryn
 */
@Data

public class OneToManyUniDeleteApp {
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

        int id = 3;
        int idCompany = 24;
        String departmentToDelete = "HR";
        int idHql = 2;

        String delete ="delete Department d where d.idDepartment =:idDepartment";

//        rozpoczecie transakcji
        session.beginTransaction();

//        Department department = session.get(Department.class, id);
//        session.delete(department);

//        Company company = session.get(Company.class, idCompany);
//
//        for (Department department : company.getDepartments()) {
//            if (Objects.equals(department.getName(), departmentToDelete)) {
//                company.getDepartments().remove(department);
//                session.delete(department);
//            }
//        }
        Query query = session.createQuery(delete);
        query.setParameter("idDepartment",idHql);
        int deletedRows = query.executeUpdate();

        System.out.println("Liczba usuniętych wierszy: "+deletedRows);

//        zakonczenie transakcji
        session.getTransaction().commit();
//        zamkniecie obiektu SessionFactory
        factory.close();

    }
}