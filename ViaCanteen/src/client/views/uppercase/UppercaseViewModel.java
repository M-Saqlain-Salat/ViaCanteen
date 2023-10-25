package client.views.uppercase;//package client.views.uppercase;
//
//import client.model.TextConverter;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
//
//
//public class UppercaseViewModel {
//
//  private StringProperty request;
//    private StringProperty reply;
//    private StringProperty error;
//    private TextConverter textConverter;
//
//    private StringProperty userId;
//    private StringProperty passward;
//  private StringProperty createuserId;
//  private StringProperty createPassward;
//
//
//
//  public UppercaseViewModel(TextConverter textConverter) {
//        this.textConverter = textConverter;
//        request = new SimpleStringProperty();
//        reply = new SimpleStringProperty();
//        error = new SimpleStringProperty();
//
//        //-----------Umar code
//       passward = new SimpleStringProperty();
//        userId = new SimpleStringProperty();
//      createuserId = new SimpleStringProperty();
//      createPassward = new SimpleStringProperty();
//    }
//
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
//
//    void onLogIn(){
//        String input = userId.get();
//        String input1 = passward.get();
//        if(((input != null) && !"".equals(input)) && ((input1 != null)
//            && !"".equals(input1)))
//        {
//            String result = textConverter.verifyUserIdAndCode(input,input1);
//            error.set(result);
//            userId.set("");
//          passward.set("");
//
//         error.set(result);
//        } else {
//            error.set("login failed");
//        }
//    }
//
//   StringProperty userIdProperty() {return userId;}
//    StringProperty passwardProperty() {return passward;}
//
//    StringProperty requestProperty() {
//        return request;
//    }
//
//    StringProperty replyProperty() {
//        return reply;
//    }
//
//    StringProperty errorProperty() {
//        return error;
//    }
//  StringProperty createuserIdProperty() {return createuserId;}
//  StringProperty createPasswardProperty() {return createPassward;}
//
//
//}
