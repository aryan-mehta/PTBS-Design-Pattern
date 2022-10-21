package com.assignDP.amehta64.users;

import java.util.ArrayList;

import com.assignDP.amehta64.facade.Facade;
import com.assignDP.amehta64.product.Product;
import com.assignDP.amehta64.login.UserInfoItem;
import com.assignDP.amehta64.menu.ProductMenu;

//Bridge Pattern - abstract class on one side of the bridge
public abstract class Person {
    // use this variable to point to a concrete productMenu object.
    public Facade facade;

    public ProductMenu theProductMenu;

    public ArrayList<Product> userProductList;

    public UserInfoItem userInfoItem;


    /**
     *
     */
    public abstract void showMenu();

    /**
     *
     */
    //Call this function to show the 'Add' Button
    public void showAddButton() { System.out.println("Show Add Button"); }

    /**
     *
     */
    //Call this function to show the 'View' Button
    public void showViewButton() {
        System.out.println("Show View Button");
    }

    //Call this function to show the 'Radio' Button
    public void showRadioButton() {
        System.out.println("Show Radio Button");
    }

    //Call this function to show the 'Labels'
    public void showLabels() {
        System.out.println("Show Labels");
    }

    //The Abstract Factory Method - According to the product type create product menu
    public abstract ProductMenu CreateProductMenu(int productCategory);

    @Override
    public String toString(){
        return this.userInfoItem.userType + ":" + this.userInfoItem.username;
    }
}

