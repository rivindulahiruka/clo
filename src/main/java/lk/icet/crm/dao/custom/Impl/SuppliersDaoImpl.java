package lk.icet.crm.dao.custom.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.icet.crm.dao.custom.SuppliersDao;
import lk.icet.crm.entity.ProductsEntity;
import lk.icet.crm.entity.SuppliersEntity;
import lk.icet.crm.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class SuppliersDaoImpl implements SuppliersDao {
    @Override
    public ObservableList<SuppliersEntity> getAll() {
        ObservableList<SuppliersEntity> suppliersEntityObservableList= FXCollections.observableArrayList();
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        List<SuppliersEntity>suppliersEntities=session.createQuery("from SuppliersEntity", SuppliersEntity.class).list();
        suppliersEntityObservableList.addAll(suppliersEntities);
        session.getTransaction().commit();
        session.close();
        return suppliersEntityObservableList;

    }

    @Override
    public boolean save(SuppliersEntity suppliersEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(suppliersEntity);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean update(SuppliersEntity suppliersEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.update(suppliersEntity);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public void delete(SuppliersEntity suppliersEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(suppliersEntity);
        session.getTransaction().commit();
        session.close();
    }


}
