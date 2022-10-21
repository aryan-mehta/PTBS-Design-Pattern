package com.assignDP.amehta64.visitor;

import java.util.List;

import com.assignDP.amehta64.facade.Facade;
import com.assignDP.amehta64.product.Product;
import com.assignDP.amehta64.trade.Trading;

//Visitor Design Pattern
public class Reminder {
    private NodeVisitor nodeVisitor;

    public Reminder(){
        nodeVisitor = new ReminderVisitor();
    }

    public void visitFacade(Facade facade) {
        nodeVisitor.visitFacade(facade);
    }

    public void visitProduct(Product product) {
        product.accept(nodeVisitor);
    }

    public void visitTrading(Trading trading) {
        trading.accept(nodeVisitor);
    }

    public void remind(List<Trading> tradingList) {

        for(Trading trading : tradingList) {
            trading.accept(nodeVisitor);
        }

    }
}
