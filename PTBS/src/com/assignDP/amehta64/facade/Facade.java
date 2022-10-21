package com.assignDP.amehta64.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import com.assignDP.amehta64.login.UserInfoItem;
import com.assignDP.amehta64.login.UserType;
import com.assignDP.amehta64.product.ClassProductList;
import com.assignDP.amehta64.product.Product;
import com.assignDP.amehta64.trade.TradeCategory;
import com.assignDP.amehta64.trade.Trading;
import com.assignDP.amehta64.visitor.Reminder;
import com.assignDP.amehta64.users.Buyer;
import com.assignDP.amehta64.users.Person;
import com.assignDP.amehta64.users.Seller;

import static com.assignDP.amehta64.facade.Constants.BuyerInfo;
import static com.assignDP.amehta64.facade.Constants.ProductInfo;
import static com.assignDP.amehta64.facade.Constants.SellerInfo;
import static com.assignDP.amehta64.facade.Constants.UserProduct;
import static com.assignDP.amehta64.facade.Constants.filePath;

//Facade Design Pattern
public class Facade {

    private int userType; // Buyer:0, Seller:1

    private Product theSelectedProduct; // object that holds currently selected product

    private int nProductCategory; // Selected product category - Meat:0, Produce:1

    public static ClassProductList theProductList; // List of products of entire system

    private Person thePerson; // the current logged in person


    // show login gui and return login result
    public boolean login() throws FileNotFoundException {

        System.out.print("Type of User?\n0 for Buyer\n1 for Seller\nEnter your type: ");
        Scanner scan = new Scanner(System.in);
        UserInfoItem userInformation = new UserInfoItem();
        userType = scan.nextInt();
        scan.nextLine();

        File file = null;
        System.out.println("Username: ");
        userInformation.username = scan.nextLine();
        System.out.println("Password: ");
        userInformation.password = scan.nextLine();

        if (userType == 0) {
            userInformation.userType = UserType.Buyer;
            file = new File(filePath+BuyerInfo);

        } else if (userType == 1) {
            userInformation.userType = UserType.Seller;
            file = new File(filePath+SellerInfo);
        }

        scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] arr = line.split(":");
            String db_username = arr[0];
            String db_password = arr[1];
            if (userInformation.username.equals(db_username) && userInformation.password.equals(db_password)) {
                System.out.println("Login successful: ");
                System.out.println("-----------------------------------------------------------------------------------------");
                createUser(userInformation);
                return true;
            }
        }
        return false;
    }


    // call this function when clicking the addButton in ProductMenu. This function
    // will add a new trade and fill the
    // required information. SellerTradingMenu and BuyerTradingMenu will be called
    // according to the type of user logged in.
    public void addTrading() {
        theSelectedProduct.tradingList = new ArrayList<>();
        theSelectedProduct.tradingList.add(new Trading(TradeCategory.Buy,100,new Date()));
        theSelectedProduct.tradingList.add(new Trading(TradeCategory.Sell,100,new Date()));
        theSelectedProduct.tradingList.add(new Trading(TradeCategory.Buy,80,new Date()));
        System.out.println("Added tradings for selected product "+theSelectedProduct);
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    // call this function when clicking the viewButton in ProductMenu.
    // Pass Trading pointer and Person pointer to this function.
    // The function views the SellerTradingMenu or BuyerTradingMenu based on type of
    // user logged in
    public void viewTrading() {
        System.out.println("Showing tradings for selected product "+theSelectedProduct);
        for (Trading trade:theSelectedProduct.tradingList) {
            System.out.println(trade.toString());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public void decideBidding() {

    }

    public void discussBidding() {

    }

    // show the remind box to remind buyer of the upcoming overdue trading window.
    public void remind(List<Trading> tradings) {
        Reminder reminder = new Reminder();
        System.out.println("Visiting facade");
        reminder.visitFacade(this);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Visiting trades of selected product = " + theSelectedProduct);
        reminder.visitProduct(theSelectedProduct);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Reminding trades of selected product = " + theSelectedProduct);
        reminder.remind(tradings);
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    // create a user object aaccording to the userinfoitem, the object can
    // be a buyer or a seller.
    public void createUser(UserInfoItem userInformation) {
        if (userInformation.userType.equals(UserType.Buyer)) {
            thePerson = new Buyer();
        }
        else if (userInformation.userType.equals(UserType.Seller)){
            thePerson = new Seller();
        }
        thePerson.userInfoItem = userInformation;
        System.out.println("Created user = " + thePerson.toString());
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    // create product list of the entire system.
    public void createProductList() throws FileNotFoundException {
        // read from file ProductInfo
        ArrayList<Product> arrayList = new ArrayList<Product>();
        File file = new File(filePath+ProductInfo);
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] arr = line.split(":");
            arrayList.add(new Product(arr[0],arr[1]));
        }

        theProductList = new ClassProductList();
        theProductList.products = arrayList;

        System.out.println("Created product list of the entire system");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    // call this function after creating the user. Create productList by reading
    // the UserProduct.txt file. Match the product name with theProductList.
    // Attach the matched product object to the new create user:
    // Facade.thePerson.ProductList
    public void AttachProductToUser() throws FileNotFoundException {
        // read from file UserProductInfo

        ArrayList<Product> arrayList = new ArrayList<Product>();
        File file = new File(filePath+UserProduct);
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] arr = line.split(":");
            if (arr[0].equals(thePerson.userInfoItem.username)) arrayList.add(new Product(arr[1]));
        }

        thePerson.userProductList = arrayList;

        System.out.println("Attached product list to user");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    // show the product list in the dialog and return the selected product.
    public Product SelectProduct() {
        Random rand = new Random();
        theSelectedProduct = theProductList.products.get(rand.nextInt(theProductList.products.size()));
        switch (theSelectedProduct.category){
        case "Meat": nProductCategory = 0;
        break;
        case "Produce": nProductCategory = 1;
        break;
        }

        System.out.println("Selected product = "+theSelectedProduct.toString());
        System.out.println("-----------------------------------------------------------------------------------------");
        return theSelectedProduct;
    }

    // calls thePerson.CreateProductMenu() and call different menu creator to show
    // the menu acc to type of user
    public void productOperation() {
        thePerson.theProductMenu = thePerson.CreateProductMenu(nProductCategory);
        System.out.println("Created menu as per userType and selected product category");
        System.out.println("-----------------------------------------------------------------------------------------");
        thePerson.showMenu();
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
