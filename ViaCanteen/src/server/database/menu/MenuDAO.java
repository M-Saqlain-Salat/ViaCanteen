package server.database.menu;

import shared.transferobjects.Menu;
import shared.transferobjects.Request;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author umar saleem
 * The data access object for room
 */
public interface MenuDAO
{
  void create(Menu menu) throws SQLException;

  ArrayList<Menu> getMenuList() throws SQLException;
  void deleteMenu(Menu menu) throws SQLException;

  //    void updateRoom(Room room) throws SQLException;
  //    List<Room> getAllRoomsByType(String category) throws SQLException;
  //    List<Room> getAllAvailableRoomsByType(String category, LocalDate dateFrom, LocalDate dateTo) throws SQLException;

}
