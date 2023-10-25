package client.views.uppercase;//package client.views.uppercase;
//
//import client.core.ViewHandler;
//import client.core.ViewModelFactory;
//import client.views.ViewController;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//
//
//
//public class UppercaseViewController implements ViewController {
//
//    @FXML
//    private Label errorLabel;
//    @FXML
//    private TextField requestField;
//    @FXML
//    private TextField replyField;
//
//    //-------Umar code----------
//    @FXML
//    private TextField userIdField;
//    @FXML
//    private TextField passwardField;
//    @FXML
//    private TextField createPasswardField;
//    @FXML
//    private TextField createUserIdField;
//
//    private UppercaseViewModel viewModel;
//    private ViewHandler vh;
//
//    public void init(ViewHandler vh, ViewModelFactory vmf) {
//        this.vh = vh;
//        this.viewModel = vmf.getUppercaseViewModel();
////        replyField.setDisable(true);
//        errorLabel.textProperty().bind(viewModel.errorProperty());
//        requestField.textProperty().bindBidirectional(viewModel.requestProperty());
//        replyField.textProperty().bind(viewModel.replyProperty());
//        //------------umar code-----------------------------
//        userIdField.textProperty().bindBidirectional(viewModel.userIdProperty());
//        passwardField.textProperty().bindBidirectional(viewModel.passwardProperty());
//        createUserIdField.textProperty().bindBidirectional(viewModel.createuserIdProperty());
//        createPasswardField.textProperty().bindBidirectional(viewModel.createPasswardProperty());
//    }
//    @FXML
//    void onLogIn() {
//        viewModel.onLogIn();
//    }
//
//    @FXML
//    private void onSubmitButton() {
//        viewModel.convert();
//    }
//
//    // I can make this method public, or do like above, make it private and mark it @FXML.
//    // The result is the same
//    public void onLogButton() {
//        vh.openLog();
//    }
//    @FXML
//    void onCreateLoginButton() {viewModel.createLogin();}
//}
//
