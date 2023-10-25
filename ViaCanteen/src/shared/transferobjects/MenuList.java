package shared.transferobjects;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuList implements Serializable
{
  private ArrayList<Menu> list;

  public MenuList()
  {
    this.list = new ArrayList<>();
  }

}
