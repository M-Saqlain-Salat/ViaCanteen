package server;

import server.networking.RMIServerImpl;
import server.servermodel.Admin.AdminProxy;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {

    RMIServerImpl ss = new RMIServerImpl(new AdminProxy());
    ss.startServer();
    System.out.println("server starting");
  }
}
