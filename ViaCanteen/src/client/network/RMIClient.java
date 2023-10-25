package client.network;

import shared.networking.ClientCallback;
import shared.networking.RMIServer;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient implements Client, ClientCallback
{

  private RMIServer server;
  private PropertyChangeSupport support;
  //    private MenuBroadCastServer menuBroadCastServer;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    Registry registry = null;
    try
    {
      registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("UppercaseServer");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String verifyUserIdAndCode(String str, String code)
  {
    try
    {
      return server.verifyUserIdAndCode(str, code);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }

  @Override public void addMenu(Menu menu)
  {
    try
    {
      server.addMenu(menu);
      System.out.println("client added menu");
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }


  @Override public void deleteMenu(Menu menu)
  {
    try
    {
      server.deleteMenu( menu);
      System.out.println("RmiClient delete menu");
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }


  @Override public List<Reservation> getReservationList()
  {
    //        result = "";
    try
    {
      return server.getReservationList();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Could not get reservation List form server :(");
    }
  }



  @Override public List<Menu> getMenuList()
  {
    //        result = "";
    try
    {
      return server.getMenuList();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not get menuList form server :(");
    }
    //            result = server.toUpperCase(arg, this);
    //           return menuBroadCastServer.getMenuList(menu,this)
  }

  @Override public void createReservation(Reservation reservation)
  {
    try
    {
      server.createReservation(reservation);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Could not able to create reservation RMI client :(");
    }
  }

  @Override public void update(Menu menu) throws RemoteException
  {
    support.firePropertyChange("NewMenuEntry", null, menu);
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

  //    @Override public void createLogin(String userId, String passward)
  //    {
  //        try
  //        {
  //            server.createLogin(userId,passward);
  //        }
  //        catch (Exception e)
  //        {
  //            e.printStackTrace();
  //        }
  //
  //    }

  //    @Override
  //    public String toUppercase(String str) {
  //        try {
  //            return server.toUppercase(str);
  //        } catch (RemoteException e) {
  //            throw new RuntimeException("Could not connect to the server :(");
  //        }
  //    }

  //    @Override
  //    public List<LogEntry> getLog() {
  //        try {
  //            return server.getLogs();
  //        } catch (RemoteException e) {
  //            throw new RuntimeException("Could not connect to the server :(");
  //        }
  //    }

}


