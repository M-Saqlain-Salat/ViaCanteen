package server.database.reservation;

import shared.transferobjects.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationDAO
{
  ArrayList<Reservation> getReservationList() throws SQLException;

  void createReservation(Reservation reservation) throws SQLException;
  //Request updateReservation(String phone, String menuName, String menuType, String isMenuPickedUp)throws SQLException;
  // Request createReservation(String phone, Menu i)   throws SQLException;;

}
