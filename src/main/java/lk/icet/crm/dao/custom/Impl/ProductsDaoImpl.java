package lk.icet.crm.dao.custom.Impl;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.icet.crm.dao.custom.ProductsDao;
import lk.icet.crm.entity.ProductsEntity;
import lk.icet.crm.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductsDaoImpl implements ProductsDao {
    @Override
    public ObservableList<ProductsEntity> getAll() {
        ObservableList<ProductsEntity> productsEntityObservableList= FXCollections.observableArrayList();
       Session session= HibernateUtil.getSession();
       session.beginTransaction();
        List<ProductsEntity> productsEntities=session.createQuery("from ProductsEntity", ProductsEntity.class).list();
        productsEntityObservableList.addAll(productsEntities);
        session.getTransaction().commit();
        session.close();
        return productsEntityObservableList;



    }

    @Override
    public boolean save(ProductsEntity productsEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(productsEntity);
        session.getTransaction().commit();
        session.close();

        return false;
    }

    @Override
    public boolean update(ProductsEntity entity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public void delete(ProductsEntity entity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();

    }
}
