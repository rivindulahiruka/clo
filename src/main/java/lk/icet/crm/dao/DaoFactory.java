package lk.icet.crm.dao;

import static javafx.scene.input.KeyCode.T;
import static lk.icet.crm.util.DaoType.PRODUCTS;

import lk.icet.crm.dao.custom.Impl.ProductsDaoImpl;

import lk.icet.crm.dao.custom.Impl.SuppliersDaoImpl;
import lk.icet.crm.util.DaoType;


public class DaoFactory {
   private static DaoFactory instance;

   private DaoFactory(){}

    public static DaoFactory getInstance() {
        return instance==null?new DaoFactory():instance;
    }
    public <T extends SuperDao> T getDaoType(DaoType type){
       switch (type){
           case PRODUCTS : return (T) new ProductsDaoImpl();
           case SUPPLIERS:  return (T) new SuppliersDaoImpl();
       }
       return null;
    }

}

