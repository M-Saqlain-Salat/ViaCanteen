package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{

  private Scene uppercaseScene;

  private Stage stage;
  private ViewModelFactory vmf;
  private Scene logScene;
  //----------umar code--------------
  private Scene loginScene;
  private Scene reservationScene;
  private Scene adminScene;
  private Scene adminUserIdScene;
  private Scene addMenuScene;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start()
  {
    stage = new Stage();
    openToLogin();
    //        openToUppercase();

  }

  public void openToLogin()
  {
    if (loginScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/loginWindow/login.fxml");

        stage.setTitle("login window");
        loginScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(loginScene);
    stage.show();
  }

  public void openToReservation()
  {
    if (reservationScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/ManageOrdering/reservation.fxml");
        stage.setTitle("reservation window");
        reservationScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(reservationScene);
    stage.show();
  }

  public void openToAdminCanteen()
  {
    if (adminScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/manageCanteen/AdminCanteen.fxml");
        stage.setTitle("Admin window");
        adminScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(adminScene);
    stage.show();
  }

  public void openToAdminUserIdScene()
  {
    if (adminUserIdScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/manageCanteen/AdminUserId.fxml");
        stage.setTitle("Admin Userid Window");
        adminUserIdScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(adminUserIdScene);
    stage.show();
  }

  public void openToAddMenu()
  {
    if (addMenuScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/addMenu/AddMenu.fxml");

        stage.setTitle("Add Menu Window");
        addMenuScene = new Scene(root);
      }
      catch (IOException e)
      {

        e.printStackTrace();
      }
    }
    stage.setScene(addMenuScene);
    stage.show();
  }

  public void openLog()
  {
    // no reusing a logScene, because I want the log to reload the latest every time.
    if (logScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/log/Log.fxml");

        logScene = new Scene(root);
        stage.setTitle("Log");

      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(logScene);
    stage.show();
  }

  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }

}
