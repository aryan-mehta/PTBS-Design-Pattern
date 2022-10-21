package com.assignDP.amehta64.menu;

import com.assignDP.amehta64.facade.Facade;
import com.assignDP.amehta64.product.Product;

// Bridge Design Pattern
public class MeatProductMenu implements ProductMenu{
    @Override public void showMenu() {
        System.out.println("Showing ProduceProductMenu");
        for (Product product: Facade.theProductList.products) {
            if (product.category=="Produce") System.out.println(product);
        }
    }

    @Override public void showAddButton() {

    }

    @Override public void showViewButton() {

    }

    @Override public void showRadioButton() {

    }

    @Override public void showLabels() {

    }

    @Override public void showComboxes() {

    }
}
