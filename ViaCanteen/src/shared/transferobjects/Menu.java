package shared.transferobjects;

import java.io.Serializable;

public class Menu implements Serializable
{
  private String menuName;
  private String menuPrice;
  private Integer menuQuantity;
  private String menuIngredient;
  private String IsMenuVeg;
  private String menuType;
  private Integer id;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }


  public Menu(String menuName, String menuPrice, int menuQuantity,
      String menuIngredient, String isMenuVeg, String menuType)
  {

    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.menuQuantity = menuQuantity;
    this.menuIngredient = menuIngredient;
    IsMenuVeg = isMenuVeg;
    this.menuType = menuType;
  }
  public Menu(Integer id,String menuName, String menuPrice, int menuQuantity,
      String menuIngredient, String isMenuVeg, String menuType)
  {
this.id=id;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.menuQuantity = menuQuantity;
    this.menuIngredient = menuIngredient;
    IsMenuVeg = isMenuVeg;
    this.menuType = menuType;
  }
  //  @Override
  //  public boolean equals(Object object) {
  //    if (!(object instanceof Menu)) return false;
  //
  //    Menu menu = (Menu) object;
  //    return menu.menuType.equals(menuType);
  //  }

  @Override public String toString()
  {
    return "Menu{"+", id='" + id+ '\'' +  "menuName='" + menuName + '\'' + ", menuPrice='"
        + menuPrice + '\'' + ", menuQuantity=" + menuQuantity
        + ", menuIngredient='" + menuIngredient + '\'' + ", IsMenuVeg='"
        + IsMenuVeg + '\'' + ", menuType='" + menuType + '\'' + '}';
  }

  //  public enum MenuType {
  //    SAND_WITCH, WARM_MENU, COLD_MENU
  //  }

  public String getMenuType()
  {
    return menuType;
  }

  public void setMenuType(String menuType)
  {
    this.menuType = menuType;
  }

  public String getIsMenuVeg()
  {
    return IsMenuVeg;
  }

  public void setIsMenuVeg(String isMenuVeg)
  {
    IsMenuVeg = isMenuVeg;
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

  public String getMenuIngredient()
  {
    return menuIngredient;
  }

  public void setMenuIngredient(String menuIngredient)
  {
    this.menuIngredient = menuIngredient;
  }

}
