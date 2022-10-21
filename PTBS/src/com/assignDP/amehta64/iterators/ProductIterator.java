package com.assignDP.amehta64.iterators;

import java.util.ArrayList;

import com.assignDP.amehta64.product.Product;

//Interator Design Pattern
public class ProductIterator implements ListIterator{

    ArrayList<Product> products;
    int currentPosition;
    public ProductIterator(ArrayList<Product> products){
        this.products = products;
        currentPosition = -1;
    }

    @Override public boolean hasNext() {
        return currentPosition<products.size();
    }

    @Override public Object Next() {
        currentPosition+=1;
        if (hasNext()) return products.get(currentPosition);
        return null;
    }

    @Override public void MoveToHead() {
        currentPosition=-1;
    }

    @Override public void Remove() {
        products.remove(products.get(currentPosition));
        currentPosition-=1;
    }
}
