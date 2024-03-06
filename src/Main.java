import java.util.Scanner;

public class Main {
    /**
     * This will be a different version of our Burger Joint - it only takes smoothie orders.
     * Algorithm:
     *  1. Provide a main menu with choices to display receipt, order smoothie, or exit & pay
     *  2. Loop until person is done (exit and pay) with order
     *  3. Have sub-menu for ordering smoothies based on set fruit
     *      - Strawberry
     *      - Peach
     *      - Banana
     *      - Orange
     *      - Mango
     *      - Melon
     *  4. Loop until they finish order and add that to a string
     *  5. Add each smoothie to larger "order" string (until done)
     */

    //global scanner element for all functions
    static Scanner scan = new Scanner(System.in);

    /**
     * Should use a similar mechanic to the Main menu and as for items (see above)
     * Then build a smoothie with those items or repeat the choices if incorrect one made
     *
     * @return The new smoothie to be added to our order ("Smoothie: Mango Banana Peach")
     */
    static String orderSmoothie() {
        // TODO: Replace this String with a StringBuilder
        String smoothie = "Smoothie: ";

        // You can use a flag here (its fine if you do) but we don't have to
        // Because we will return (i.e. Break out of the function itself) on option 7
        while (true) {
            // Print out menu
            System.out.print("""
                    Please select a flavor:
                    1. Strawberry
                    2. Peach
                    3. Banana
                    4. Orange
                    5. Mango
                    6. Melon
                    7. Finished Selecting
                    Make Selection:\s""");

            // I could make a variable here to hold our choice but then I'd just erase it after
            // So I'll use scanner's return directly here
            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    smoothie += "Strawberry ";
                    break;
                case 2:
                    smoothie += "Peach ";
                    break;
                case 3:
                    smoothie += "Banana ";
                    break;
                case 4:
                    smoothie += "Orange ";
                    break;
                case 5:
                    smoothie += "Mango ";
                    break;
                case 6:
                    smoothie += "Melon ";
                    break;
                case 7:
                    // See because we return this also exits the switch & while loop
                    // So no break or flag needed
                    return smoothie;
                default:
                    System.out.println("Please enter an option between 1 & 7.");

            }
        }
    }

    /**
     * To keep it simple we price as:
     *  - Base price = $10 per smoothie
     *  - We'll add $2 for every time the length of the string is over 4
     * Then just return and print that.
     */
    static int calcTotal(String order) {
        // TODO: Use a List to fully track flavors
        return 10 + (order.length()/4) * 2;
    }

    public static void main(String[] args) {
        // Flag because we are breaking out of an inner switch & loop
        boolean stillOrdering = true;
        // String to hold total order
        String order = "";

        while (stillOrdering) {
            /* Display main menu (done for you as example)
             * This is a textblock (\s says leave the space) another fun way of printing
             * Use a textblock with """ <-- everything between the first and second --> """
             * Prints exactly as we wrote it
             */
            System.out.print("""
                    Please choose from the following items:
                    \t1. Order Smoothie
                    \t2. Display receipt
                    \t3. Exit and Pay
                    Enter Selection:\s""");

            // Based on main menu we'll call a function (ensuring correct value chosen)
            // TODO: What needs to be added to the default case? Is it needed?
            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    order += orderSmoothie();
                    break;
                case 2:
                    System.out.printf("\n\n\n\nYour order is \n\t%s\n", order);
                    System.out.printf("Price is $%d\n", calcTotal(order));
                    break;
                case 3:
                    System.out.printf("\n\n\n\nThanks for ordering your order is: \n\t%s\n",
                            order);
                    System.out.printf("Your total is $%d", calcTotal(order));
                    stillOrdering = false;
                    break;
                default:
                    System.out.println("Please enter an option between 1 & 3.");
            }
        }
    }
}