package client.clientmodel;

import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;
import shared.util.Subject;

import java.util.List;

public interface Admin extends Subject
{

  String verifyUserIdAndCode(String text, String code);
  void addMenu(Menu menu);
  List<Reservation> getReservationList();

  //----------Clint side------------
  List<Menu> getMenuList();
  void createReservation(Reservation reservation);
  void deleteMenu(Menu menu);
  ;

  //  void addMenu(Menu menu);

  //    String toUppercase(String text);
  //    List<LogEntry> getLogs();

  //umar code-----//

  // void createLogin(String userId, String passward);
}


