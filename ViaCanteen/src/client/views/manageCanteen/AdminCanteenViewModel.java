package client.views.manageCanteen;

import client.clientmodel.Admin;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.util.ArrayList;
import java.util.List;

public class AdminCanteenViewModel
{

  private Admin admin;
 // private StringProperty totalMenuNo;

  //------------Constructor--------------------------------
  public AdminCanteenViewModel(Admin admin)
  {
    this.admin = admin;
    error = new SimpleStringProperty();
    //totalMenuNo = new SimpleStringProperty();
    selectedAdminMenus=new ArrayList<>();
  }

//---------------Code for reservation list----------------------
  private ObservableList<Reservation> reservationObservableList;
  private StringProperty error;

  public void loadReservation()
  {
    if (true)
    {
      List<Reservation> reservationList = admin.getReservationList();
      reservationObservableList = FXCollections.observableArrayList(reservationList);
      error.set("load reservation list");
    }
    else
      error.set("load reservation list failed");
  }

  ObservableList<Reservation> getReservationList() {return reservationObservableList;}

  //------------------code for Admin menu list----------------------
  private ObservableList<Menu> menuAdminObservableList;
  private List<Menu> selectedAdminMenus;
  public void loadAdminMenus()
  {
    List<Menu> menuList = admin.getMenuList();
    System.out.println(menuList+"admin menulist are here");
    menuAdminObservableList = FXCollections.observableArrayList(menuList);
  }
  ObservableList<Menu> getAdminMenuList()
  {
    return menuAdminObservableList;
  }

  public void onDeleteMenu()
  {
   Menu menu=selectedAdminMenus.get(0);
    admin.deleteMenu(menu);
    menuAdminObservableList.remove(selectedAdminMenus.get(0));
    selectedAdminMenus.clear();
    System.out.println(selectedAdminMenus.get(0).toString());
  }
  public void setSelectedAdminMenu(ObservableList<Menu> selectedAdminMenus)
  {
    for (Menu i : selectedAdminMenus)
    {
      this.selectedAdminMenus.add(i);
      System.out.println(selectedAdminMenus);
    }
  }


  public void upDateMenuList()
  {
loadAdminMenus();
   // admin.getTotalMenuNo();
    }

  StringProperty getError() {return error;}
  //StringProperty getTotalMenuNo() {return totalMenuNo;}


}
