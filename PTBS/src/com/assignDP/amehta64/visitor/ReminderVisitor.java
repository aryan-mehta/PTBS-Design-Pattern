package com.assignDP.amehta64.visitor;

import java.util.ArrayList;

import com.assignDP.amehta64.facade.Facade;
import com.assignDP.amehta64.product.Product;
import com.assignDP.amehta64.trade.Trading;
import com.assignDP.amehta64.iterators.ListIterator;
import com.assignDP.amehta64.iterators.ProductIterator;

//Visitor Design Pattern
public class ReminderVisitor extends NodeVisitor{

    private ListIterator iterator;

    @Override public void visitProduct(Product product) {
        System.out.println("The following trades are pending for product: " + product.toString());
        for (Trading trade:product.tradingList) {
            System.out.println(trade);
        }
    }

    @Override public void visitTrading(Trading trading) {
        System.out.println("The due date for trade is " + trading.toString());
    }

    @Override public void visitFacade(Facade facade) {
        ArrayList<Product> products = facade.theProductList.products;
        iterator = new ProductIterator(products);
        while(iterator.hasNext()) {
            System.out.println(iterator.Next());
        }
    }
}
