package shared.networking;

import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote
{

  String verifyUserIdAndCode(String str, String code) throws RemoteException;
  void addMenu(Menu menu) throws RemoteException;
  void deleteMenu(Menu menu) throws RemoteException;;
  List<Menu> getMenuList() throws RemoteException;

  ;
  void registerCallback(ClientCallback ccb) throws RemoteException;
  void createReservation(Reservation reservation) throws RemoteException;
  List<Reservation> getReservationList() throws RemoteException;


  ;

  //    String toUppercase(String str) throws RemoteException;
  //    List<LogEntry> getLogs() throws RemoteException;

  //  void createLogin(String userId, String passward) throws RemoteException;
}
