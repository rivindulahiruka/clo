package lk.icet.crm.bo.custom.Impl;

import javafx.collections.ObservableList;
import lk.icet.crm.bo.custom.ProductsBo;
import lk.icet.crm.dao.DaoFactory;
import lk.icet.crm.dao.custom.ProductsDao;
import lk.icet.crm.dto.Products;
import lk.icet.crm.entity.ProductsEntity;
import lk.icet.crm.util.DaoType;
import org.modelmapper.ModelMapper;

public class ProductsBoImpl implements ProductsBo {
    @Override
    public ObservableList<ProductsEntity> getAll() {
        ProductsDao productsDao= DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
        return productsDao.getAll();
    }

    @Override
    public boolean addProducts(Products products) {
ProductsEntity entity=new ModelMapper().map(products, ProductsEntity.class);
ProductsDao productsDao=DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
productsDao.save(entity);
        return false;
    }

    @Override
    public boolean updateProducts(Products products) {
        ProductsEntity entity=new ModelMapper().map(products, ProductsEntity.class);
        ProductsDao productsDao=DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
        productsDao.update(entity);
        return false;
    }

    @Override
    public void deleteProducts(Products products) {
        ProductsEntity entity=new ModelMapper().map(products, ProductsEntity.class);
        ProductsDao productsDao=DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
        productsDao.delete(entity);
    }
}
