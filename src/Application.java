import java.util.Scanner;

public class Application {

    public static void printPrimaryQ() {

        String[] questions = {
                "=========================================================================",
                "======================== Hello, Welcome to the CLI-POS ==========================",

                "==================================",
                "choose an option (Enter the number)",
                "==================================",

                "1) Customer Managment",
                "2) Product Managment",
                "3) Order Managment",
                "4) exit",
                "=========================================================================",

        };

        for (String question : questions) {

            System.out.println(question);
        }


    }

    public static void main(String[] args) {

        printPrimaryQ();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

    }
}


