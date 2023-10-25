package server.servermodel.Admin;

import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.beans.PropertyChangeListener;
import java.util.List;

public class AdminProxy implements Admin
{
  private Admin admin;

  public AdminProxy()
  {
    admin = new AdminImp();
  }

  @Override public String verifyUserIdAndCode(String loginId, String code)
  {
    return admin.verifyUserIdAndCode(loginId, code);
  }

  @Override public void addMenu(Menu menu)
  {
    admin.addMenu(menu);
  }

  @Override public void deleteMenu(Menu menu)
  {
    admin.deleteMenu(menu);
  }

  @Override public List<Reservation> getReservationList()
  {
    return admin.getReservationList();
  }



  @Override public List<Menu> getMenuList()
  {
    return admin.getMenuList();
  }

  @Override public void createReservation(Reservation reservation)
  {
    admin.createReservation(reservation);
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    admin.addListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    admin.removeListener(eventName, listener);
  }

}
