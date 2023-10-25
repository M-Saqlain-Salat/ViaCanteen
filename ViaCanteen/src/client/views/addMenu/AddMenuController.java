package client.views.addMenu;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import shared.transferobjects.MenuType;

public class AddMenuController implements ViewController
{

  private ViewHandler vh;
  private addMenuViewModel vM;

  @FXML private TextField IsMenuVegField;
  @FXML private TextField menuIngredientField;
  @FXML private TextField menuNameField;
  @FXML private TextField menuPriceField;
  @FXML private TextField menuQuantityField;

  @FXML private ComboBox<String> menuTypeChoiceBox;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    this.vM = vmf.getAddMenuViewModel();
    menuNameField.textProperty().bindBidirectional(vM.menuNameProperty());
    IsMenuVegField.textProperty().bindBidirectional(vM.isMenuVegProperty());
    menuQuantityField.textProperty()
        .bindBidirectional(vM.menuQuantityProperty());
    menuIngredientField.textProperty()
        .bindBidirectional(vM.menuIngredientProperty());
    menuPriceField.textProperty().bindBidirectional(vM.priceProperty());
    menuTypeChoiceBox.valueProperty().bindBidirectional(vM.getMenuType());
    menuTypeChoiceBox.setItems(
        FXCollections.observableArrayList(MenuType.SAND_WITCH.toString(),
            MenuType.WARM_MENU.toString(), MenuType.COLD_MENU.toString()));
    menuTypeChoiceBox.getSelectionModel().selectFirst();
  }

  @FXML void addMenu()
  {

    vM.addMenu();
    System.out.println("add menu working");
  }

  @FXML void cancelMenu()
  {
    vh.openToAdminCanteen();
  }

  @FXML void back()
  {
    vh.openToAdminCanteen();
  }

}
