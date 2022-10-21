package com.assignDP.amehta64.product;

import java.util.List;

import com.assignDP.amehta64.trade.Trading;
import com.assignDP.amehta64.visitor.NodeVisitor;

public class Product {
    public String name;
    public String category;
    public List<Trading> tradingList;

    public Product(String name){
        this.name=name;
    }
    public Product(String category, String name){
        this.name=name;
        this.category=category;
    }
    //Visitor Pattern
    public void accept(NodeVisitor nodeVisitor){
        nodeVisitor.visitProduct(this);
    }

    @Override
    public String toString(){
        return this.name + ":" + this.category;
    }
}
