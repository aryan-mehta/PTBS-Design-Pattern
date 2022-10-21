package com.assignDP.amehta64.visitor;

import com.assignDP.amehta64.facade.Facade;
import com.assignDP.amehta64.product.Product;
import com.assignDP.amehta64.trade.Trading;
//Visitor Design Pattern
public abstract class NodeVisitor {
    abstract public void visitProduct(Product product);

    abstract public void visitTrading(Trading trading);

    abstract public void visitFacade(Facade facade);
}
