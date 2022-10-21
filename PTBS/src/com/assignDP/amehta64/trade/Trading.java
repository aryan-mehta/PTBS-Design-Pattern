package com.assignDP.amehta64.trade;

import java.util.Date;

import com.assignDP.amehta64.visitor.NodeVisitor;
// Visitor Design Pattern
public class Trading {
    public TradeCategory tradeCategory;
    public float amount;
    public Date dueDate;
    public Trading(TradeCategory tradeCategory,float amount, Date dueDatete){
        this.tradeCategory=tradeCategory;
        this.amount=amount;
        this.dueDate=dueDatete;
    }
    public void accept(NodeVisitor nodeVisitor){
        nodeVisitor.visitTrading(this);
    }
    @Override
    public String toString(){
        return this.tradeCategory.toString() +":"+ this.dueDate.toString() +":"+ String.valueOf(this.amount);
    }
}
