package client.views.manageOrdering;

import client.clientmodel.Admin;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class ManageOrderingViewModel
{
  //  private ManageOrdering manageOrdering;
  private Admin admin;
  private ObservableList<Menu> menuObservableList;
  private StringProperty error;
  private StringProperty phone;

  private List<Menu> selectedMenus;

  public ManageOrderingViewModel(Admin admin)
  {
    //    this.manageOrdering=manageOrdering;
    this.admin = admin;
    admin.addListener("NewMenuEntry", this::onNewMenuEntry);

    //----------Reservation Menu-------------------
    error = new SimpleStringProperty();
    phone = new SimpleStringProperty();
    selectedMenus = new ArrayList<>();
    //---TODO-----------------------------
    // roomsModel.addListener(Observer.AVAILABLEROOMS.toString(), this::roomFromServer);
  }

  public void loadMenus()
  {
    List<Menu> MenuList = admin.getMenuList();
    menuObservableList = FXCollections.observableArrayList(MenuList);
  }

  private void onNewMenuEntry(PropertyChangeEvent evt)
  {
    menuObservableList.add((Menu) evt.getNewValue());
  }

  ObservableList<Menu> getMenuList()
  {
    return menuObservableList;
  }

  StringProperty getError()
  {
    return error;
  }

  StringProperty getPhone()
  {
    return phone;
  }

  /**
   * A function that will set selected room
   *
   * @param selectedMenus
   */
  public void setSelectedMenu(ObservableList<Menu> selectedMenus)
  {
    for (Menu i : selectedMenus)
    {
      this.selectedMenus.add(i);
      System.out.println(selectedMenus);
    }
  }

  /**
   * A function that will remove an element
   *
   * @param event
   */
  private void roomFromServer(PropertyChangeEvent event)
  {
    Platform.runLater(() -> {
      menuObservableList.clear();
      List<Menu> menus = (List<Menu>) event.getNewValue();
      menuObservableList.addAll(menus);
    });
  }

  public void reserveMenu()
  {
    Reservation reservation = new Reservation(phone.get().trim(),
        selectedMenus.get(0).getMenuName(), selectedMenus.get(0).getMenuPrice(),
        selectedMenus.get(0).getMenuQuantity(),
        selectedMenus.get(0).getIsMenuVeg(),
        selectedMenus.get(0).getMenuType());
    selectedMenus.get(0).getId();
    admin.createReservation(reservation);
    menuObservableList.remove(selectedMenus.get(0));
    selectedMenus.clear();
    System.out.println(reservation.toString());
  }
}
