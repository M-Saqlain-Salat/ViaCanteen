package client.network;

import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;
import shared.util.Subject;

import java.util.List;

public interface Client extends Subject
{

  void startClient();
  //-------Admin Side--------------------
  String verifyUserIdAndCode(String text, String code);
  void addMenu(Menu menu);
  List<Reservation> getReservationList();
  void deleteMenu(Menu menu);

  //-------Client side--------------------
  List<Menu> getMenuList();
  void createReservation(Reservation reservation);


  //    String toUppercase(String str);
  //    List<LogEntry> getLog();
  //    void createLogin(String userId, String passward);
}
