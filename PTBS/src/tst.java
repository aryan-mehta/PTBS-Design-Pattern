import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class tst {
    public static void main(String[] args) throws FileNotFoundException {
        Boolean b = login();
        System.out.println(b);
    }

    public static boolean login() throws FileNotFoundException {
        System.out.print("Type of User?\n0 for Buyer\n1 for Seller\nEnter your type: ");
        Scanner scan = new Scanner(System.in);
        int UserType = scan.nextInt();
        scan.nextLine();
        int flag = 0;
        Scanner sc;
        File file;
        String user_type;
        if (UserType == 0) {
            file = new File("BuyerInfo.txt");
            flag = 1;
            user_type="Buyer";
        } else {
            file = new File("SellerInfo.txt");
            flag = 1;
            user_type="Seller";
        }
        sc = new Scanner(file);
        if (flag == 1) {
            try {
                System.out.print("Enter Username: ");
                String username = scan.nextLine();
                System.out.print("Enter Password: ");
                String password = scan.nextLine();
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] arr = line.split(":");
                    String db_username = arr[0];
                    String db_password = arr[1];
                    if (username.equals(db_username) && password.equals(db_password)) {
                        System.out.print("Logged in as " + user_type);
                        return true;
                    }
                }
            } finally {
                System.out.println();
            }
        }

        sc.close();
        scan.close();
        return false;
    }
}