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
        // TODO: Add switch statement then while loop
        // TODO: Why does this only need a while(true) and not a flag?
        System.out.println("This will ask for toppings, just send default order for now:" +
                "\nAdding an Orange Mango Smoothie");
        return "Smoothie: Orange Mango";
    }

    /**
     * To keep it simple we price as:
     *  - Base price = $10 per smoothie
     *  - We'll add $2 for every time the length of the string is over 4
     * Then just return and print that.
     */
    static int calcTotal(String order) {
        // TODO: complete the equation (add the math needed) - what's length do?
        return order.length();
    }

    public static void main(String[] args) {
        boolean stillOrdering = true;

        // TODO: THERE IS AN ERROR BELOW - What is it and how do we fix it?
        // TODO: Why does this need a flag instead of just while(true)?
        while (stillOrdering) {
            // String to hold total order
            String order = "";

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
                    continue; // this just says move on (basically ignore me)
            }
        }
    }
}