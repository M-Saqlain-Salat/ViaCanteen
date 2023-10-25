package server.servermodel.Admin;

import server.database.menu.MenuDAO;
import server.database.menu.MenuDAOImpl;
import server.database.reservation.ReservationDAO;
import server.database.reservation.ReservationDAOImp;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminImp implements Admin
{
  private MenuDAO menuDAO;
  private ReservationDAO reservationDAO;
  private PropertyChangeSupport support;
  private Menu menu;
  //    private List<LogEntry> logEntries;
  //  private ArrayList<Menu> menuList;
  //  private ArrayList<String> passwardBank;
  //    private HashMap<String,String> userIdBank;

  public AdminImp()
  {
    //      menuDAO = new MenuDAOImpl();
    try
    {
      menuDAO = MenuDAOImpl.getInstance();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    support = new PropertyChangeSupport(this);
    //        logEntries = new ArrayList<>();

    // menuList=new ArrayList<>();

    //         passwardBank=new ArrayList<>();
    //        userIdBank=new HashMap<>();
    try
    {
      reservationDAO = ReservationDAOImp.getInstance();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  //  @Override public void addMenu(String menu_name, String menu_price,
  //      String menu_quantity, String menu_ingredient, String menu_isMenuVeg)

  @Override public void addMenu(Menu menu)
  {
    try
    {
      int i = menu.getMenuQuantity();
      System.out.println(menu.getMenuQuantity());
      for (int j = 0; j <= i; j++)
      {
        //        menuList.add(menu);
        menuDAO.create(menu);
        support.firePropertyChange("NewMenuEntry", null, menu);

        System.out.println(
            "Admin Server model got menu data from GUI" + "" + "");
      }
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
    }
  }

  @Override public void deleteMenu(Menu menu)
  {
    try
    {
        menuDAO.deleteMenu(menu);
        support.firePropertyChange("NewMenuEntry", null, menu);

        System.out.println(
            "Admin Server model delete menu " + "" + "");
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
    }
  }

  @Override public List<Reservation> getReservationList()
  {
    ArrayList<Reservation> reservationList = new ArrayList<>();
    try
    {
      reservationList = reservationDAO.getReservationList();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return reservationList;
  }



  //  @Override public void addMenu(Menu menu)
  //  {
  ////    menu=new Menu(menu_name,menu_price,menu_quantity,menu_ingredient,menu_isMenuVeg);
  //    int i=menu.getMenuQuantity();
  //    System.out.println(menu.getMenuQuantity());
  //    for (int j=0; j<=i;j++)
  //    {
  //menuList.add(menu);
  //    support.firePropertyChange("NewMenuEntry", null, menu);
  //
  //    System.out.println("Admin Server model get menu data from GUI"+menuList
  //        + ""
  //        + "");
  //  }}

  @Override public List<Menu> getMenuList()
  {
    ArrayList<Menu> menusList = new ArrayList<>();
    try
    {
      menusList = menuDAO.getMenuList();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return menusList;
  }

  @Override public void createReservation(Reservation reservation)
  {
    try
    {
      reservationDAO.createReservation(reservation);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  //  @Override public List<Menu> getMenuList()
  //  {
  //    System.out.println("client get Menu list");
  //    return new ArrayList<>(menuList);
  //
  //  }

  //    @Override
  //    public String toUppercase(String str) {
  //        String result = str.toUpperCase();
  //        LogEntry logEntry = new LogEntry(str, result);
  //        logEntries.add(logEntry);
  //        support.firePropertyChange("NewLogEntry", null, logEntry);
  //        return result;
  //    }
  @Override public String verifyUserIdAndCode(String loginId, String code)
  {

    {
      if (loginId.equals("ViaCanteen") && code.equals("Decoder123"))
      {
        String result = "Verified and Access Granted! Welcome!";
        return result;
      }
      else
      {
        String result = ("Invalid Username or Password!");
        return result;
      }
    }
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

  //  else if (loginId.equals("ViaCanteen")) {
  //    String result =("Invalid Password!");
  //    return result;
  //  } else if (code.equals("Decoder123")) {
  //    String result =("Invalid Username!");
  //    return result;

  ////        String result = str.toUpperCase();
  //        LogEntry logEntry = new LogEntry(loginId, code);
  //        logEntries.add(logEntry);
  //        support.firePropertyChange("NewLogEntry", null, logEntry);
  ////        return result;

  //----------Create passWard code running
  //if (userIdBank.contains(loginId)&&(passwardBank.contains(code)))
  //    String result;
  //     result="welcome and logg in successfully";
  //     return result;
  //}
  //
  //         else{
  //     String result;
  //        result="loggin failed";
  //        return result;}
  //-------------Create passWard here-----------------------------------
  //----------------Hash map code to find some value into it------------------
  //        Iterator<Map.Entry<String, String> >
  //            iterator =userIdBank.entrySet().iterator();
  //        // flag to store result
  //
  //        if (true)
  //        {
  //            boolean isKeyPresent = false;
  //            // Iterate over the HashMap
  //            while (iterator.hasNext())
  //            {
  //                // Get the entry at this iteration
  //                Map.Entry<String, String> entry = iterator.next();
  //
  //                // Check if this key is the required key
  //                if (code == entry.getKey())
  //                {
  //                    isKeyPresent = true;
  //                }
  //            }
  //            String result = "Verified and Access Granted! Welcome!";
  //            return result;
  //        }
  //                else
  //                {
  //                    String result =("Invalid Username & Password!");
  //                              return result;
  //                }
  //-----------------Hash map code end here---------------------------------------------------

  //@Override public void createLogin(String userId, String passward)
  //    {

  //        userIdBank.add(userId);
  //       passwardBank.add(passward);
  ////        userIdBank.put(userId,passward);
  //     System.out.println("create login");
  //    }
  //
  //    @Override
  //    public List<LogEntry> getLog() {
  //        return new ArrayList<>(logEntries);
  //    }

}
