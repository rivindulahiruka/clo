package lk.icet.crm.bo.custom;

import javafx.collections.ObservableList;
import lk.icet.crm.bo.SuperBo;
import lk.icet.crm.dto.Suppliers;
import lk.icet.crm.entity.SuppliersEntity;

public interface SuppliersBo extends SuperBo {
    ObservableList<SuppliersEntity> getAll();

    boolean addSuppliers(Suppliers suppliers);

    void updateSupplier(Suppliers suppliers);

    void deleteSupplier(Suppliers suppliers);
}
