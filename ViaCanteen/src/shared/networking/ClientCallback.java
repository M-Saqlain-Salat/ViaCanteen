package shared.networking;

import shared.transferobjects.Menu;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
  void update(Menu menu) throws RemoteException;
}
