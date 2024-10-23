package lk.icet.crm.bo.custom.Impl;

import javafx.collections.ObservableList;
import lk.icet.crm.bo.custom.SuppliersBo;
import lk.icet.crm.dao.DaoFactory;
import lk.icet.crm.dao.custom.ProductsDao;
import lk.icet.crm.dao.custom.SuppliersDao;
import lk.icet.crm.dto.Products;
import lk.icet.crm.dto.Suppliers;
import lk.icet.crm.entity.ProductsEntity;
import lk.icet.crm.entity.SuppliersEntity;
import lk.icet.crm.util.DaoType;
import org.modelmapper.ModelMapper;

public class SuppliersBoImpl implements SuppliersBo {

    @Override
    public ObservableList<SuppliersEntity> getAll() {
        SuppliersDao suppliersDao= DaoFactory.getInstance().getDaoType(DaoType.SUPPLIERS);
        return suppliersDao.getAll();

    }

    @Override
    public boolean addSuppliers(Suppliers suppliers) {
        SuppliersEntity entity=new ModelMapper().map(suppliers, SuppliersEntity.class);
        SuppliersDao suppliersDao=DaoFactory.getInstance().getDaoType(DaoType.SUPPLIERS);
        suppliersDao.save(entity);
        return false;
    }

    @Override
    public void updateSupplier(Suppliers suppliers) {
        SuppliersEntity entity=new ModelMapper().map(suppliers, SuppliersEntity.class);
        SuppliersDao suppliersDao=DaoFactory.getInstance().getDaoType(DaoType.SUPPLIERS);
        suppliersDao.update(entity);

    }

    @Override
    public void deleteSupplier(Suppliers suppliers) {

            SuppliersEntity entity=new ModelMapper().map(suppliers, SuppliersEntity.class);
            SuppliersDao suppliersDao=DaoFactory.getInstance().getDaoType(DaoType.SUPPLIERS);
            suppliersDao.delete(entity);

    }
}
