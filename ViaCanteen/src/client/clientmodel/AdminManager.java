package client.clientmodel;

import client.network.Client;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class AdminManager implements Admin
{

  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;

  public AdminManager(Client client)
  {
    this.client = client;
    client.startClient();
    client.addListener("NewMenuEntry", this::onNewMenuEntry);
  }

  private void onNewMenuEntry(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }
  //
  //    @Override
  //    public String toUppercase(String text) {
  //        return client.toUppercase(text);
  //    }
  //
  //
  //    @Override public void createLogin(String userId, String passward)
  //    {
  //         client.createLogin( userId, passward);
  //    }

  //----------Client side-----------------
  @Override public List<Menu> getMenuList()
  {
    return client.getMenuList();
  }

  @Override public void createReservation(Reservation reservation)
  {
    client.createReservation(reservation);
    System.out.println("client model manager added reservation");
  }



  //------Admin Side-------
  @Override public String verifyUserIdAndCode(String text, String code)
  {
    return client.verifyUserIdAndCode(text, code);
  }

  @Override public void addMenu(Menu menu)
  {
    client.addMenu(menu);
    System.out.println("Admin added menu");

  }

  @Override public List<Reservation> getReservationList()
  {
    return client.getReservationList();
  }

  @Override public void deleteMenu(Menu menu)
  {
client.deleteMenu(menu);
  }



  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}


