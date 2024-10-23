package lk.icet.crm.bo.custom;

import javafx.collections.ObservableList;
import lk.icet.crm.bo.SuperBo;
import lk.icet.crm.dto.Products;
import lk.icet.crm.entity.ProductsEntity;

public interface ProductsBo extends SuperBo {
    ObservableList<ProductsEntity> getAll();

    boolean addProducts(Products products);

    boolean updateProducts(Products products);

    void deleteProducts(Products products);
}
