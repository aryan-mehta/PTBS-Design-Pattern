import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//Facade Design Pattern
public class Facade {

	private int UserType; // Buyer:0, Seller:1

	private Product theSelectedProduct; // object that holds currently selected product

	private int nProductCategory; // Selected product category - Meat:0, Produce:1

	private ClassProductList theProductList; // List of products of entire system

	private Person thePerson; // the current logged in person

	// show login gui and return login result
	public boolean login() throws FileNotFoundException {
		System.out.println("Type of User?\nEnter 0 for Buyer\n 1 for Seller: ");
		Scanner s = new Scanner(System.in);
		UserType = s.nextInt();
		int flag = 0;
		Scanner sc;
		if (UserType == 0) {
			File file = new File("BuyerInfo.txt");
			sc = new Scanner(file);
			flag = 1;
		} else if (UserType == 1) {
			File file = new File("SellerInfo.txt");
			sc = new Scanner(file);
			flag = 1;
		} else {
			System.out.println("Invalid Input!\n Please enter correct UserType...");
			login();
		}
		if (flag == 1) {
			Scanner scan = new Scanner(System.in);
			String username = scan.nextLine();
			String password = scan.nextLine();
			scan.close();
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] arr = line.split(":");
				String db_username = arr[0];
				String db_password = arr[1];
				if (username.equals(db_username) && password.equals(db_password)) {
					return true;
				}
			}
		}
		sc.close();
		s.close();
		return false;

	}

	// call this function when clicking the addButton in ProductMenu. This function
	// will add a new trade and fill the
	// required information. SellerTradingMenu and BuyerTradingMenu will be called
	// according to the type of user logged in.
	public void addTrading() {

	}

	// call this function when clicking the viewButton in ProductMenu.
	// Pass Trading pointer and Person pointer to this function.
	// The function views the SellerTradingMenu or BuyerTradingMenu based on type of
	// user logged in
	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	// show the remind box to remind buyer of the upcoming overdue trading window.
	public void remind() {

	}

	// create a user object aaccording to the userinfoitem, the object can
	// be a buyer or a seller.
	public void createUser(UserInfoItem userinfoitem) {

	}

	// create product list of the entire system.
	public void createProductList() {
		}

	}

	// call this function after creating the user. Create productList by reading
	// the UserProduct.txt file. Match the product name with theProductList.
	// Attach the matched product object to the new create user:
	// Facase.thePerson.ProductList
	public void AttachProductToUser() {

	}

	// show the product list in the dialog and return the selected product.
	public Product SelectProduct() {
		return null;
	}

	// calls thePerson.CreateProductMenu() and call different menu creator to show
	// the menu acc to type of user
	public void productOperation() {

	}

}
