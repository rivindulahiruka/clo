package lk.icet.crm.dao;

import javafx.collections.ObservableList;
import lk.icet.crm.entity.ProductsEntity;

public interface CrudDao <T> extends SuperDao {
    ObservableList<T> getAll();

    boolean save(T t);

    boolean update(T t);

    void delete(T t);
}
