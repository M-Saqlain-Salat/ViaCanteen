package client.core;

import client.views.addMenu.addMenuViewModel;
import client.views.manageCanteen.AdminCanteenViewModel;
import client.views.manageCanteen.AdminUserIdViewModel;
import client.views.manageOrdering.ManageOrderingViewModel;

public class ViewModelFactory
{

  //-----------Umar code--------------
  private final ModelFactory mf;
  private AdminUserIdViewModel adminUserIdViewModel;
  private addMenuViewModel addMenuVM;
  private ManageOrderingViewModel manageOrderingViewModel;

  private AdminCanteenViewModel adminCanteenViewModel;
  //------------------------------------------------

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public AdminUserIdViewModel getUppercaseViewModel()
  {
    if (adminUserIdViewModel == null)
      adminUserIdViewModel = new AdminUserIdViewModel(mf.getAdmin());
    return adminUserIdViewModel;
  }

  public addMenuViewModel getAddMenuViewModel()
  {
    if (addMenuVM == null)
      addMenuVM = new addMenuViewModel(mf.getAdmin());
    return addMenuVM;
  }

  public ManageOrderingViewModel getManageOrderingViewModel()
  {
    if (manageOrderingViewModel == null)
      manageOrderingViewModel = new ManageOrderingViewModel(mf.getAdmin());
    return manageOrderingViewModel;
  }

  public AdminCanteenViewModel getAdminCanteenViewModel()
  {

    if (adminCanteenViewModel == null)
      adminCanteenViewModel = new AdminCanteenViewModel(mf.getAdmin());
    return adminCanteenViewModel;

  }

  //--------------------------------------------------------------------------------
  //    public LogViewModel getLogViewModel() {
  //        return (logViewModel = logViewModel == null ?
  //            new LogViewModel(mf.getTextConverter()) :
  //            logViewModel);
  //    }

}
