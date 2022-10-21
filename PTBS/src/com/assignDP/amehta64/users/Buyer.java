package com.assignDP.amehta64.users;


import com.assignDP.amehta64.menu.MeatProductMenu;
import com.assignDP.amehta64.menu.ProduceProductMenu;
import com.assignDP.amehta64.menu.ProductMenu;

public class Buyer extends Person{
    // Factory Design Pattern
    @Override public void showMenu() {
        System.out.println("Showing menu for " + userInfoItem.userType + ":" + userInfoItem.username);
        theProductMenu.showMenu();
    } 
    @Override public ProductMenu CreateProductMenu(int productCategory) {
        switch (productCategory){
            case 0 : return new MeatProductMenu();
            case 1 : return new ProduceProductMenu();
        }
        return null;
    }
}
