package server.database.reservation;

import server.database.DataBaseConnection;
import shared.transferobjects.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReservationDAOImp implements ReservationDAO
{

  /**
   * @author Umar
   * A class that will execute all the function from MenuDAO interface
   */
  private static ReservationDAO instance;
  private static Lock lock = new ReentrantLock();

  private ReservationDAOImp()
  {

    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  /**
   * A function that will do instance in singleton
   *
   * @return instance
   */
  public static ReservationDAO getInstance() throws SQLException
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new server.database.reservation.ReservationDAOImp();
        }
      }
    }
    return instance;
  }

  @Override public void createReservation(Reservation reservation)
      throws SQLException

  {
    try (Connection connection = DataBaseConnection.getConnection())
    {

      //            PreparedStatement statement = connection.prepareStatement("set schema 'umar';");
      PreparedStatement statement1 = connection.prepareStatement(
          //   "INSERT INTO \"Menu\"(\" menuName\",\"menuPrice\",\"menuQuantity\",\"menuIngredient\",\"IsMenuVeg\" ,\"menuType\")VALUES(?,?,?,?,?,?);");
          //"INSERT INTO Reservation (phone varchar NOT NULL primary key, menuName varchar,menuPrice varchar,menuQuantity int,,IsMenuPickedUp varchar,menuType varchar) VALUES (?,?,?,?,?,?);");
          "INSERT INTO Reservation (phone , menuName ,menuPrice,menuQuantity ,IsMenuPickedUp ,menuType) VALUES (?,?,?,?,?,?);");

      statement1.setString(1, reservation.getPhone());
      statement1.setString(2, reservation.getMenuName());
      statement1.setString(3, reservation.getMenuPrice());
      statement1.setInt(4, reservation.getMenuQuantity());
      statement1.setString(5, reservation.getIsMenuPickedUp());
      statement1.setString(6, reservation.getMenuType());
      statement1.executeUpdate();
    }
    //return new Request("Reservation created into the Database","null" );
  }

  /**
   * A function that will return all the reservation
   *
   * @return list of reservation
   * @throws SQLException
   */
  @Override public ArrayList<Reservation> getReservationList()
      throws SQLException
  {
    try (Connection connection = DataBaseConnection.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Reservation;");
      //"SELECT * FROM \"Menu\";");
      return (ArrayList<Reservation>) getReservation(statement);
    }
  }

  /**
   * A function that will return a list of reservation
   *
   * @param statement
   * @return list of reservation
   * @throws SQLException
   */
  private List<Reservation> getReservation(PreparedStatement statement)
      throws SQLException
  {
    ResultSet resultSet = statement.executeQuery();
    List<Reservation> reservationList = new ArrayList<>();
    while (resultSet.next())
    {

      String phone= resultSet.getString("phone");
      String menuName = resultSet.getString("menuName");
      String menuPrice = resultSet.getString("menuPrice");
      int menuQuantity = resultSet.getInt("menuQuantity");
      String IsMenuPickedUp = resultSet.getString("IsMenuPickedUp");
      String menuType = resultSet.getString("menuType");

     Reservation reservation = new Reservation(phone, menuName,
          menuPrice, menuQuantity, IsMenuPickedUp, menuType);

      reservationList.add(reservation);
    }
    return reservationList;
  }

}
