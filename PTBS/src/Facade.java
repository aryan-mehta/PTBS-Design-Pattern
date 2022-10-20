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
		System.out.print("Type of User?\n0 for Buyer\n1 for Seller\nEnter your type: ");
		Scanner scan = new Scanner(System.in);
		UserInfoItem userInformation = new UserInfoItem();
		UserType = scan.nextInt();
		scan.nextLine();
//		userInformation.username=scan.nextLine();
//		userInformation.password=scan.nextLine();
		int flag = 0;
		Scanner sc;
		File file=null;
		String user_type;
		if (UserType == 0) {
			userInformation.type_of_user = TypeOfUser.Buyer;
			file = new File("E:\\ARYAN\\Desktop\\ASU\\Sem1 Fall22\\SER515 - Fondations of Software Engineering\\Assignments\\Design Pattern Assignment\\PTBS-Design-Pattern\\PTBS\\src\\BuyerInfo.txt");
			flag = 1;
			user_type="Buyer";
		} else {
			userInformation.type_of_user = TypeOfUser.Seller;
			file = new File("E:\\ARYAN\\Desktop\\ASU\\Sem1 Fall22\\SER515 - Fondations of Software Engineering\\Assignments\\Design Pattern Assignment\\PTBS-Design-Pattern\\PTBS\\src\\SellerInfo.txt");
			flag = 1;
			user_type="Seller";
		}
		sc = new Scanner(file);
		if (flag == 1) {
			try {
				System.out.print("Enter Username: ");
				userInformation.username=scan.nextLine();
//				String username = scan.nextLine();
				System.out.print("Enter Password: ");
				userInformation.password=scan.nextLine();
//				String password = scan.nextLine();
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] arr = line.split(":");
					String db_username = arr[0];
					String db_password = arr[1];
					if (userInformation.username.equals(db_username) && userInformation.password.equals(db_password)) {
						System.out.print("Logged in as " + user_type);
						createUser(userInformation);
						return true;
					}
				}
			} finally {
				System.out.println();
			}
		}

		sc.close();

		System.out.println("Login Failed! Invalid Credentials or User Not Found.");
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
		if (userinfoitem.type_of_user.equals(TypeOfUser.Buyer)) {
			thePerson = new Buyer();
		}
		else if (userinfoitem.type_of_user.equals(TypeOfUser.Seller)){
			thePerson = new Seller();
		}
		thePerson.personInformation = userinfoitem;
	}

	// create product list of the entire system.
	public void createProductList() {
		
	}

	// call this function after creating the user. Create productList by reading
	// the UserProduct.txt file. Match the product name with theProductList.
	// Attach the matched product object to the new create user:
	// Facade.thePerson.ProductList
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
