package client.views.manageCanteen;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

public class AdminCanteenController implements ViewController
{

  //----------reservationList--------------------------------------
  @FXML private TableView<Reservation> reservationTableView;
  @FXML private TableColumn<String, Reservation> phone;
  @FXML private TableColumn<String, Reservation> menuName;
  @FXML private TableColumn<String, Reservation> menuPrice;
  @FXML private TableColumn<String, Reservation> menuQuantity;
  @FXML private TableColumn<String, Reservation> IsMenuPickedUp;
  @FXML private TableColumn<String, Reservation> menuType;


  //-----------menuList--------------------------------------
  @FXML private TableView<Menu> menuTableViewAdmin;
  @FXML private TableColumn<String, Menu> menuNameAdmin;
  @FXML private TableColumn<String, Menu> menuPriceAdmin;
  @FXML private TableColumn<String, Menu> IsMenuVegAdmin;
  @FXML private TableColumn<String, Menu> menuIngredientAdmin;
  @FXML private TableColumn<String, Menu> menuTypeAdmin;
  @FXML private TableColumn<Integer, Menu> idMenuAdmin;

  @FXML private Label errorField;

  private ViewHandler vh;
  private AdminCanteenViewModel vm;
  @FXML private TextField totalMenuNo;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    vm = vmf.getAdminCanteenViewModel();
    errorField.textProperty().bind(vm.getError());
    //totalMenuNo.textProperty().bindBidirectional(vm.getTotalMenuNo());


//vm.getTotalMenuNo();
    vm.loadReservation();

    //-----Getter method-----------------
    reservationTableView.setItems(vm.getReservationList());
    //-----------Create binding for reservation list with view model---------------------
    phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    menuName.setCellValueFactory(new PropertyValueFactory<>("menuName"));
    menuPrice.setCellValueFactory(new PropertyValueFactory<>("menuPrice"));
    menuQuantity.setCellValueFactory(new PropertyValueFactory<>("menuQuantity"));
    IsMenuPickedUp.setCellValueFactory(new PropertyValueFactory<>("IsMenuPickedUp"));
    menuType.setCellValueFactory(new PropertyValueFactory<>("menuType"));

    //------------Create binding for Admin menu list--------------------------
    initializeMenuTableViewAdmin();
  }

  public void initializeMenuTableViewAdmin()
  {
    vm.loadAdminMenus();
    menuNameAdmin.setCellValueFactory(new PropertyValueFactory<>("menuName"));
    menuPriceAdmin.setCellValueFactory(new PropertyValueFactory<>("menuPrice"));
    IsMenuVegAdmin.setCellValueFactory(new PropertyValueFactory<>("IsMenuVeg"));
    menuIngredientAdmin.setCellValueFactory(new PropertyValueFactory<>("menuIngredient"));
    menuTypeAdmin.setCellValueFactory(new PropertyValueFactory<>("menuType"));
    idMenuAdmin.setCellValueFactory(new PropertyValueFactory<>("id"));
    menuTableViewAdmin.setItems(vm.getAdminMenuList());
    initializeAdminMenuList();
  }

  @FXML
  void onDeleteMenu() {
    vm.setSelectedAdminMenu(menuTableViewAdmin.getSelectionModel().getSelectedItems());
    vm.onDeleteMenu();
    initializeAdminMenuList();
  }
  private void initializeAdminMenuList()
  {menuTableViewAdmin.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);}

  @FXML void onAddMenu()
  {
    vh.openToAddMenu();
  }
//----------------Admin Menulist end here

  @FXML
  void upDateMenuList() {
   // vh.openToAdminCanteen();
//vm.upDateMenuList();
    initializeMenuTableViewAdmin();


  }
}
