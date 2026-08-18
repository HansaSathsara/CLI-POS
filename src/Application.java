import java.util.Scanner;

public class Application {


    // user to allocate entet  opinion of managing
    static Scanner input = new Scanner(System.in);
    // [kamal],[jagath],[puhspa],[],[],[],[]
    static String[] custmers = new String[10];  // save customer
    // [earbuds] [headphone] [mobiles] [laptop] []
    static String[] products = new String[10]; // save product

    static String[] orders = new String[10]; // save order

    static double productsPrices[] = new double[10]; // save product' prices
    static int quantity[] = new int[10];
    static int[] productStockes = new int[10];

    static int customerPointer = -1; // currently pointer to inserted new slot
    static int productPointer = -1;// currently pointer to inserted new slot
    static int counterCustomer = 1; // show to user how many items currently fill
    static int counterProduct = 1;
    static int counterOrder = -1;

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

    static String[] customerQ = {"1)Save Customer", "2)Update Customer", "3)Delete Customer", "4)Search Customer", "5)Back", "6)Exit"};


    static String[] productQ = {

            "1)Add Product", "2)Update Product", "3)Delete Product", "4)Search Product", "5)Back", "6)Exit"

    };

    static String[] orderQ = {
            "1)Place Order",
            "2)View All Order",
            "3)Cancel Order",
            "4)Back",
            "5)Exit",
            "Choose an Option : "


    };

    public static boolean custmerIsEmpty() {
        return customerPointer == -1;

    }


    public static boolean orderIsEmpty() {
        return counterOrder == -1;

    }

    public static boolean productIsEmpty() {
        return productPointer == -1;
    }

    public static boolean customerisFull() {
        return custmers.length - 1 == customerPointer;
    }

    public static boolean productIsFull() {
        return products.length - 1 == productPointer;
    }


    // ===========Customer Managment===========
    public static void saveCustomer() {

        loadAllCustomer();

        if (customerisFull()) {

            System.out.println("oops, Cannot add more than customers! ");
            return;
        }


        System.out.println("Pleasr Enter Customer (" + (counterCustomer++) + ")" + "Name");
        String name = input.nextLine();

        if (custmers[0] != null) {
            if (isCostomerExits(name) != -1) {
                System.out.println("Customer already exits!");
                return;

            }

        }
        custmers[++customerPointer] = name;
        System.out.println("Customer saved sucess!");


    }


    public static int isCostomerExits(String name) {

        if (name != null) {
            for (int i = 0; i <= customerPointer; i++) {

                if (custmers[i].contains(name)) {
                    return i;


                }


            }

        }
        return -1;


    }


    public static void clearNewLine() {

        input.nextLine();
    }

    public static void updateCustomer() {
        if (custmerIsEmpty()) {
            System.out.println("cannot search operation! array is empty!");
            return;
        }

        System.out.println("Please Enter Customer Id :");
        int customerIndex = input.nextInt();
        clearNewLine();
        customerIndex--; // dont insert 0
        clearNewLine();


        String customerName = custmers[customerIndex];
        if (customerName != null) {
            System.out.println("Customer found and name is :" + customerName);
            System.out.println("Insert New Customer name : ");
            String tempName = input.nextLine();

            custmers[customerIndex] = tempName;
            System.out.println("Custmer Updated new name is " + tempName);
        } else {

            System.out.println("Customer not found!");
        }


    }


    public static void deleteCustomer() {

        if (custmerIsEmpty()) {
            System.out.println("cannot search operation! array is empty!");
            return;
        }

        System.out.println("Please Enter Customer Id :");
        int customerIndex = input.nextInt();
        customerIndex--; // dont insert 0

        String tempName = custmers[customerIndex];
        clearNewLine();

        if (null != tempName) {

            custmers[customerIndex] = null;
            customerIndex--;
            System.out.println("Customer Deleted : " + tempName);

        } else {

            System.out.println("Customer not found!");
        }


    }


    public static void searchCustomer() {

        if (custmerIsEmpty()) {
            System.out.println("cannot search operation! array is empty!");
            return;
        }

        System.out.println("Please Enter Customer name :");
        String tempName = input.nextLine();

        int customerIndex = isCostomerExits(tempName);

        if (isCostomerExits(tempName) != -1) {
            System.out.println("Customer found and id is: " + (customerIndex + 1));
        } else {

            System.out.println("Customer not found!");
        }


    }


    public static void loadAllCustomer() {

        for (String customer : custmers) {
            System.out.print(customer + ", ");
        }
        System.out.println();
    }

    public static void loadAllProduct() {

        for (String product : products) {

            System.out.print(product + ", ");
        }
        System.out.println();

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
            clearNewLine();

            switch (num) {

                case 1:  // save customer
                    saveCustomer();
                    break;
                case 2: // update customer
                    updateCustomer();
                    break;
                case 3:  // delete customer
                    deleteCustomer();
                    break;
                case 4: // search customer
                    searchCustomer();
                    break;
                case 5: // back to home
                    return;
                case 6:
                    goodBye();
                default:
                    System.out.println("Idiot..Please Try Again..");
                    return;
            }


        }


    }

    // ==========Product Managment================


    public static int isProductExits(String pname) {

        if (pname != null) {
            for (int i = 0; i <= productPointer; i++) {

                if (products[i].contains(pname)) {
                    return i;

                }


            }

        }
        return -1;


    }

    public static String isProductExitsbyIndex(int index) {

        if (index >= 0 && productPointer >= index) {

            String pname = products[index];
            if (pname != null) {

                return pname;
            }
        }


        return null;

    }


    public static void addProduct() {

        loadAllProduct();

        System.out.println("please Enter product ( " + (counterProduct++) + " )" + "name :");
        String pName = input.nextLine();

        System.out.println("Enter product Price (LKR) :");
        double price = input.nextDouble();


        System.out.println("Enter product QTY :");
        int qty = input.nextInt();
        clearNewLine();


        if (productIsFull()) {

            System.out.println("oops, Cannot add more than products!");

        } else {

            if (products[0] != null) {

                int index = isProductExits(pName);
                if (index != -1) {

                    System.out.println("product already exits!");
                    return;

                }

            }

            ++productPointer;
            products[productPointer] = pName;
            productsPrices[productPointer] = price;
            productStockes[productPointer] = qty;

            System.out.println("product saved " + pName);


        }
    }


    public static void updateProduct() {

        if (productIsEmpty()) {
            System.out.println("Cannot operate! empty of array!");
        } else {

            System.out.println("Please insert Product Id: ");
            int index = input.nextInt() - 1;
            clearNewLine();

            String name = products[index];

            if (name != null) {

                System.out.println("Product found and name is :" + name);
                System.out.println("Insert new Product name :");
                String tempP = input.nextLine();

                products[index] = tempP;
                System.out.println("Updated product!");
            } else {

                System.out.println("Product not found!");
            }


        }

    }


    public static void deleteProduct() {

        System.out.println("Please Enter Product Id: ");
        int index = input.nextInt() - 1;
        clearNewLine();

        if (isProductExitsbyIndex(index) != null) {

            products[index] = null;
            System.out.println("Product deleted ");
        } else {
            System.out.println("product not found!");
        }


    }

    public static void searchProduct() {

        System.out.println("Please insert SearchText:");
        String searchText = input.nextLine();
        clearNewLine();

        int index = isProductExits(searchText);

        if (index != -1) {

            System.out.println("Product found and id is : " + index);
        } else {

            System.out.println("Product not found");

        }

    }


    // ==========Product Managment================


    public static void manageProduct() {
        System.out.println("Manage Your Products");

        //-----show product question list

        while (true) {

            for (String prodQ : productQ) {
                System.out.println(prodQ);
            }

            int num = input.nextInt();
            clearNewLine();

            switch (num) {

                case 1: // add product
                    addProduct();
                    break;
                case 2: // update product
                    updateProduct();
                    break;
                case 3: // delete product
                    deleteProduct();
                    break;
                case 4: // search product
                    searchProduct();
                    break;
                case 5: // back
                    return;
                case 6: // exit
                    goodBye();
                    break;
                default:
                    System.out.println("Idiot..Try Again..");

            }


            //-----show product question list


        }


    }

    // =======================Order managment =======================
    public static void placeOrder() {
        // pick customer
        loadAllCustomer();
        System.out.println("Please Enter Customer id: ");
        int index = input.nextInt() - 1;
        clearNewLine();

        if (index < 0 || index > customerPointer || custmers[index] == null) {

            System.out.println("Customer not found!");
            return;

        }

        // pick product
        loadAllProduct();
        System.out.println("Please Enter Product id: ");
        int pid = input.nextInt() - 1;
        clearNewLine();

        if (pid < 0 || pid > productPointer || products[pid] == null) {

            System.out.println("Product not found");
            return;
        }

        // pick quantity

        System.out.println("Enter QTY :");
        int qty = input.nextInt();

        if (qty <= 0) {

            System.out.println("Invalid Quantity");
            return;

        }
        if (qty > productStockes[pid]) {

            System.out.println("Not enough stocK available :" + productStockes[pid]);
            return;
        }

        double total = productsPrices[pid] * qty;
        productStockes[pid] -= qty;

        String orderSummery = String.format("Order# %d | Customer: %s | Product: %s | Qty: %d | Total: LKR %.2f ", (counterOrder + 1 + 1), custmers[index], products[pid], qty, total);

        orders[++counterOrder] = orderSummery;
        System.out.println("Order Placed! " + orderSummery);
    }


    public static void viewOrder() {

        if (orderIsEmpty()) {
            System.out.println("Not yet Order placed!");
            return;
        }
        for (int i = 0; i <= counterOrder; i++) {

            System.out.println(orders[i]);

        }
    }

    public static void cancelOrder() {

        if (orderIsEmpty()) {
            System.out.println("Not yet Order placed!");
            return;
        }

        System.out.println("Please Enter order id");
        int index = input.nextInt();

        String order = orders[index];

        if (order != null) {

            System.out.println("Order Found and name is :" + order);
            orders[index] = null;
            System.out.println("Order Cancelled!");
            counterOrder--;
        } else {

            System.out.println("Order not found!");
        }

    }

    // =======================Order managment =======================

    public static void printDivider() {

        System.out.println("========================================================");
    }

    public static void manageOrder() {
        System.out.println("Manage your Orders");

        while (true) {

            for (String order : orderQ) {
                System.out.println(order);
            }
            System.out.println();

            int num = input.nextInt();
            clearNewLine();


            switch (num) {

                case 1:
                    placeOrder();
                    break;
                case 2: // viewOrder
                    viewOrder();
                    break;
                case 3: // cancelOrder
                    cancelOrder();
                    break;
                case 4: // back
                    return;
                case 5:
                    goodBye();
                    break;
                default: // exit
                    System.out.println("Idiot..Try Again..");
            }


        }


    }

    public static void goodBye() {

        System.out.println("Good bye..");
        System.exit(0);

    }


    public static void main(String[] args) {

        // print welcome Note first
        printWelcomeNote();


        while (true) {
            // print primary questions secondly
            printPrimaryQ();


            int num = input.nextInt();
            clearNewLine();

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


