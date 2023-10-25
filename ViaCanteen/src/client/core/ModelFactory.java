package client.core;

import client.clientmodel.Admin;
import client.clientmodel.AdminManager;

public class ModelFactory
{

  private final ClientFactory cf;
  private Admin admin;
  //  private ManageOrdering manageOrdering;

  public ModelFactory(ClientFactory cf)
  {
    this.cf = cf;
  }

  public Admin getAdmin()
  {
    if (admin == null)
      admin = new AdminManager(cf.getClient());
    return admin;
  }

  //  public ManageOrdering getManageOrdering()
  //  {
  //    if (manageOrdering==null)
  //      manageOrdering=new manageOrderingManager(cf.getClient());
  //    return manageOrdering;
  //  }
}


