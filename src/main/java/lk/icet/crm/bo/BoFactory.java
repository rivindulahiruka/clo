package lk.icet.crm.bo;

import lk.icet.crm.bo.custom.Impl.ProductsBoImpl;
import lk.icet.crm.bo.custom.Impl.SuppliersBoImpl;
import lk.icet.crm.dao.DaoFactory;
import lk.icet.crm.dao.SuperDao;
import lk.icet.crm.dao.custom.Impl.ProductsDaoImpl;
import lk.icet.crm.util.BoType;
import lk.icet.crm.util.DaoType;

public class BoFactory {
    private static BoFactory instance;

    private BoFactory(){}

    public static BoFactory getInstance() {
        return instance==null?new BoFactory():instance;
    }
    public <T extends SuperBo> T getBoType(BoType type){
        switch (type){
            case PRODUCTS : return (T) new ProductsBoImpl();
            case SUPPLIERS: return (T) new SuppliersBoImpl();
        }
        return null;
    }
}
