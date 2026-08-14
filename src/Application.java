import java.util.Scanner;

public class Application {


    // user to allocate entet  opinion of managing
    static Scanner input = new Scanner(System.in);
    // [kamal],[jagath],[puspa],[],[],[],[]
    static String[] custmers = new String[10];  // save customer's  name

    static int customerPointer = 0;

    public static void printPrimaryQ() {


        System.out.println("==================================");
        System.out.println("choose an option (Enter the number)");
        System.out.println("==================================");
        System.out.println("1) Customer Managment");
        System.out.println("2) Product Managment");
        System.out.println("3) Order Managment");
        System.out.println("4) exit");
        System.out.println("=========================================================================");


    }


    public static void printWelcomeNote() {
        System.out.println("=========================================================================");
        System.out.println("======================== Hello, Welcome to the CLI-POS ==========================");


    }

    static String[] customerQ = {
            "1)Save Customer",
            "2)Update Customer",
            "3)Delete Customer",
            "4)Search Customer",
            "5)Back",
            "6)Exit"
    };


    // ===========Customer Managment===========
    public static void saveCustomer() {

        for (String customer : custmers) {
            System.out.print(customer + ", ");
        }
        System.out.println();

        if (customerPointer >= custmers.length) {

            System.out.println("oops, Cannot add more than customers! ");
            return;
        }


        System.out.println("Pleasr Enter Customer (" + (customerPointer + 1) + ")" + "Name");
        String name = input.nextLine();

        if (custmers[0] != null) {
            if (isCostomerExits(name)) {
                System.out.println("Customer already exits!");
                return;

            }


        }
        custmers[customerPointer++] = name;
        System.out.println("Customer saved sucess!");


    }


    public static boolean isCostomerExits(String name) {

        for (int i = 0; i < customerPointer; i++) {

            if (custmers[i].equalsIgnoreCase(name)) {
                return true;


            }


        }

        return false;


    }

    // ===========Customer Managment===========


    public static void manageCustomer() {
        System.out.println("Manage your Customers");

        // -----------print Q-----------------

        while (true) {

            for (String customerQ : customerQ) {

                System.out.println(customerQ);

            }
            // -----------print Q-----------------

            int num = input.nextInt();
            input.nextLine();

            switch (num) {

                case 1:  // save customer
                    saveCustomer();
                    break;
                case 2: // update customer
                    break;
                case 3: // search customer
                    break;
                case 4: // delete customer
                    break;
                case 5: // back to home
                    break;
                default:
                    System.out.println("Idiot..Please Try Again..");
                    return;
            }


        }


    }

    public static void manageProduct() {
        System.out.println("Manage Your Products");
    }

    public static void manageOrder() {
        System.out.println("Manage your Orders");
    }


    public static void main(String[] args) {

        // print welcome Note first
        printWelcomeNote();


        while (true) {
            // print primary questions secondly
            printPrimaryQ();


            int num = input.nextInt();
            input.nextLine();

            switch (num) {

                case 1:
                    manageCustomer();
                    break;
                case 2:
                    manageProduct();
                    break;
                case 3:
                    manageOrder();
                    break;
                default:
                    System.out.println("Idiot..Try Again..");
                    return;

            }
        }


    }
}


