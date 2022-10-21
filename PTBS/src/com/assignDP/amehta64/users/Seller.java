package com.assignDP.amehta64.users;

import com.assignDP.amehta64.menu.MeatProductMenu;
import com.assignDP.amehta64.menu.ProduceProductMenu;
import com.assignDP.amehta64.menu.ProductMenu;

public class Seller extends Person{
    // Factory Design Pattern
    @Override public void showMenu() {
        theProductMenu.showMenu();
    }
    // Factory Design Pattern
    @Override public ProductMenu CreateProductMenu(int productCategory)
    {
        switch (productCategory){
        case 0 : return new MeatProductMenu();
        case 1 : return new ProduceProductMenu();
        }
        return null;
    }
}
