package lk.icet.crm.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.icet.crm.bo.BoFactory;
import lk.icet.crm.bo.custom.ProductsBo;
import lk.icet.crm.bo.custom.SuppliersBo;
import lk.icet.crm.dto.Products;
import lk.icet.crm.dto.Suppliers;
import lk.icet.crm.entity.ProductsEntity;
import lk.icet.crm.entity.SuppliersEntity;
import lk.icet.crm.util.BoType;

import java.net.URL;
import java.util.ResourceBundle;

public class UserDashboardController implements Initializable {

    public TableColumn colSupplierId;
    public TableColumn colSupplierName;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colProductName;
    public JFXTextField txtProductName;
    public JFXTextField txtAddress;
    public JFXTextField txtSupplierName;
    public JFXTextField txtSupplierId;
    public JFXTextField txtContact;
    public TableView <SuppliersEntity> tblSuppliersView;
    private AnchorPane loadPage;
    @FXML
    private JFXComboBox<String> cmbCategory;

    @FXML
    private TableView<ProductsEntity> tblProductView;

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colSize;

    @FXML
    private AnchorPane productsPage;

    @FXML
    private AnchorPane supliersPage;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtSize;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Products products = new Products(
                Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue()
        );
        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.addProducts(products);


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Products products = new Products(
                Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue()
        );
        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.deleteProducts(products);

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Products products = new Products(
                Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue()
        );
        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.updateProducts(products);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage=productsPage;
        loadPage.setVisible(true);

        ObservableList<String> category= FXCollections.observableArrayList();
        category.add("Gens");
        category.add("Ledies");
        category.add("Kids");
        cmbCategory.setItems(category);

        tblProductView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if (newValue!=null){
                setTextToValues(newValue);
            }
        } );
        tblSuppliersView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToSuppliersValue(newValue);
         }
});
    }


    private void setTextToValues(ProductsEntity newValue) {
        txtItemCode.setText(newValue.getItemCode().toString());
        txtItemName.setText(newValue.getItemName());
        txtSize.setText(newValue.getSize());
        txtQuantity.setText(newValue.getQty().toString());
        txtPrice.setText(newValue.getPrice().toString());
        cmbCategory.setValue(newValue.getCategory());
    }
    private void setTextToSuppliersValue(SuppliersEntity newValue) {
        txtSupplierId.setText(newValue.getSupplierId().toString());
        txtSupplierName.setText(newValue.getSuppliersName());
        txtContact.setText(newValue.getSuppliersContact());
        txtAddress.setText(newValue.getSuppliersAddress());
        txtProductName.setText(newValue.getSuppliersProductName());
}

    public void btnSupliersPageOnAction(ActionEvent actionEvent) {
        loadPage.setVisible(false);
        loadPage=supliersPage;
        loadPage.setVisible(true);

        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("suppliersName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("suppliersContact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("suppliersAddress"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("suppliersProductName"));
        tblSuppliersView.setItems(suppliersBo.getAll());

    }

    public void btnProductsPageOnAction(ActionEvent actionEvent) {
        loadPage.setVisible(false);
        loadPage=productsPage;
        loadPage.setVisible(true);

        ProductsBo productsBo= BoFactory.getInstance().getBoType(BoType.PRODUCTS);


        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tblProductView.setItems(productsBo.getAll());
    }

    public void btnAddSupplierOnAction(ActionEvent actionEvent) {
        Suppliers suppliers=new Suppliers(
                Integer.parseInt(txtSupplierId.getText()),
                txtSupplierName.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtProductName.getText()
        );
        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.addSuppliers(suppliers);
    }

    public void btnSupplierUpdateOnAction(ActionEvent actionEvent) {
        Suppliers suppliers=new Suppliers(
                Integer.parseInt(txtSupplierId.getText()),
                txtSupplierName.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtProductName.getText()
        );
        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.updateSupplier(suppliers);
    }

    public void btnSupplierDeleteOnAction(ActionEvent actionEvent) {
        Suppliers suppliers=new Suppliers(
                Integer.parseInt(txtSupplierId.getText()),
                txtSupplierName.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtProductName.getText()
        );
        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.deleteSupplier(suppliers);
    }
}
