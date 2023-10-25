package shared.transferobjects;

import java.io.Serializable;

public class Reservation implements Serializable
{
  private String phone;

  @Override public String toString()
  {
    return "Reservation{" + "phone='" + phone + '\'' + ", menuName='" + menuName
        + '\'' + ", menuPrice='" + menuPrice + '\'' + ", menuQuantity="
        + menuQuantity + ", IsMenuPickedUp='" + IsMenuPickedUp + '\''
        + ", menuType='" + menuType + '\'' + '}';
  }

  private String menuName;
  private String menuPrice;
  private int menuQuantity;
  private String IsMenuPickedUp;
  private String menuType;

  public Reservation(String phone, String menuName, String menuPrice,
      int menuQuantity, String isMenuPickedUp, String menuType)
  {
    this.phone = phone;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.menuQuantity = menuQuantity;
    IsMenuPickedUp = isMenuPickedUp;
    this.menuType = menuType;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getMenuName()
  {
    return menuName;
  }

  public void setMenuName(String menuName)
  {
    this.menuName = menuName;
  }

  public String getMenuPrice()
  {
    return menuPrice;
  }

  public void setMenuPrice(String menuPrice)
  {
    this.menuPrice = menuPrice;
  }

  public int getMenuQuantity()
  {
    return menuQuantity;
  }

  public void setMenuQuantity(int menuQuantity)
  {
    this.menuQuantity = menuQuantity;
  }

  public String getIsMenuPickedUp()
  {
    return IsMenuPickedUp;
  }

  public void setIsMenuPickedUp(String isMenuPickedUp)
  {
    IsMenuPickedUp = isMenuPickedUp;
  }

  public String getMenuType()
  {
    return menuType;
  }

  public void setMenuType(String menuType)
  {
    this.menuType = menuType;
  }



}