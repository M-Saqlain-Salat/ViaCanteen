package client.views.manageCanteen;

import client.clientmodel.Admin;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdminUserIdViewModel
{

  private Admin admin;

  private StringProperty userId;
  private StringProperty passward;
  private StringProperty error;

  private StringProperty createuserId;
  private StringProperty createPassward;
  private StringProperty request;
  private StringProperty reply;

  public AdminUserIdViewModel(Admin admin)
  {
    this.admin = admin;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();

    //-----------Umar code
    passward = new SimpleStringProperty();
    userId = new SimpleStringProperty();

    //      createuserId = new SimpleStringProperty();
    //      createPassward = new SimpleStringProperty();
  }

  //    void convert() {
  //        String input = request.get();
  //        if(input != null && !"".equals(input)) {
  //            String result = textConverter.toUppercase(input);
  //            reply.set(result);
  //        } else {
  //            error.set("Input cannot be empty");
  //        }
  //    }
  //  public void createLogin()
  //  {
  //String userId=createuserId.get();
  //String passward=createPassward.get();
  //    if(((userId != null) && !"".equals(userId)) && ((passward != null)
  //        && !"".equals(passward)))
  //    {textConverter.createLogin(userId,passward);
  //    error.set("login Created");
  //    createuserId.set("");
  //    createPassward.set("");}}
  ////    else
  ////    {error.set("login failed");}
  ////  }

  boolean onLogIn()
  {
    String input1 = userId.get();
    String input2 = passward.get();
    if (((input1 != null) && !"".equals(input1)) && ((input2 != null)
        && !"".equals(input2)))
    {
      String result = admin.verifyUserIdAndCode(input1, input2);

      if (result.equals("Invalid Username or Password!"))
      {
        error.set(result);
        userId.set("");
        passward.set("");
        return false;
      }
      else
      {
        error.set(result);
        return true;
      }
    }
    else
    {
      error.set("login failed");
      return false;
    }
  }

  StringProperty userIdProperty()
  {
    return userId;
  }

  StringProperty passwardProperty()
  {
    return passward;
  }

  StringProperty errorProperty()
  {
    return error;
  }

  //    StringProperty requestProperty() {
  //        return request;
  //    }
  //
  //    StringProperty replyProperty() {
  //        return reply;
  //    }

  //  StringProperty createuserIdProperty() {return createuserId;}
  //  StringProperty createPasswardProperty() {return createPassward;}

}
