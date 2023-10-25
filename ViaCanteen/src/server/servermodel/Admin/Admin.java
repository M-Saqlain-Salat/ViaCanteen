package server.servermodel.Admin;

import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;
import shared.util.Subject;

import java.util.List;

public interface Admin extends Subject
{
  String verifyUserIdAndCode(String loginId, String code);
  void addMenu(Menu menu);
  void deleteMenu(Menu menu);
  List<Reservation> getReservationList();

  //-------Client Side---------------
  List<Menu> getMenuList();
  void createReservation(Reservation reservation);


  //    String toUppercase(String str);
  //    List<LogEntry> getLog();
  //    void createLogin(String userId, String passward);
}
