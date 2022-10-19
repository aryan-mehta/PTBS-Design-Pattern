
// import javax.swing.*; // for the frame
// import java.awt.*; // for the checkBox and the label
// import java.awt.event.*; // for the checkBox listener
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class tst {
    public static void main(String[] args) throws FileNotFoundException {
        Boolean b = login();
        System.out.println(b);
    }

    public static boolean login() throws FileNotFoundException{
        System.out.println("Type of User?\nEnter 0 for Buyer\n 1 for Seller: ");
		Scanner s = new Scanner(System.in);
		int UserType = s.nextInt();
		int flag = 0;
		// Scanner scan;
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
			try {Scanner scan = new Scanner(System.in);
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
            finally{
                System.out.println("The 'try catch' is finished.");
            }
		}
		// scan.close();
		try{
            sc.close();
		    s.close();}
            finally{
                System.out.println("The 'try catch' is finished.");
            }
		    return false;
    }

}
// // create pointers
// private boolean checkedOnce; // this boolean says if the checkBox is checked
// or not
// private JFrame window;
// private JLabel label;
// private JCheckBox cb;
// private Container c;
// public static void main(String[]x)
// {
// new tst();
// }
// public tst() //Constructor
// {

// //create objects to pointers
// label = new JLabel("checkBox activated");
// cb = new JCheckBox("check here" , false);

// window = new JFrame("test");
// window.setBounds(100,100,200,200);
// window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// // define c
// c = window.getContentPane();
// // create and set layout
// FlowLayout fl = new FlowLayout();
// c.setLayout(fl);
// // add Items to Container
// c.add(cb);
// c.add(label);

// checkedOnce = false; // checkedOnce must have a value, otherwise it is null

// window.setVisible(true);
// label.setVisible(false);

// cb.addActionListener(this);
// }
// public void actionPerformed(ActionEvent e) // this method is called when one
// of the objects that have a listener is activated
// {
// if(checkedOnce == false)
// {
// label.setVisible(true);
// checkedOnce = true; // set true, so that the next time the checkBox is
// klicked on, the label dissapears
// }
// else
// {
// checkedOnce = false;
// label.setVisible(false);
// }
// }
