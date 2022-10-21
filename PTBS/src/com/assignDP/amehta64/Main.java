package com.assignDP.amehta64;

import java.io.FileNotFoundException;

import com.assignDP.amehta64.facade.Facade;
import com.assignDP.amehta64.product.Product;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Facade facade = new Facade();
        Product selectedProduct;
        facade.createProductList();

        facade.login();
        facade.AttachProductToUser();
        selectedProduct = facade.SelectProduct();
        facade.productOperation();
        facade.addTrading();
        facade.viewTrading();
        facade.remind(selectedProduct.tradingList);
    }
}
