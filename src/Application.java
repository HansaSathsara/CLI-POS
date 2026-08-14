import java.util.Scanner;

public class Application {


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


    public static void manageCustomer() {
        System.out.println("Manage your Customers");

        for (String customerQ : customerQ) {

            System.out.println(customerQ);

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

            // user to allocate entet  opinion of managing
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();

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


