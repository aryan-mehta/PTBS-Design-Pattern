package com.assignDP.amehta64.iterators;
//Iterator Design Pattern
import java.util.ArrayList;

import com.assignDP.amehta64.product.Offering;

public class OfferingItertor implements ListIterator{

    ArrayList<Offering> offerings= new ArrayList<>();

    @Override public boolean hasNext() {
        return false;
    }

    @Override public Object Next() {
        return null;
    }

    @Override public void MoveToHead() {

    }

    @Override public void Remove() {

    }
}
