import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by PiratePowWow on 2/8/16.
 */
public class Main {


    public static void main(String[] args) {
        ArrayList<Item> inventory = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            for (Item item : inventory){
                System.out.println(item.item + " [" + item.quantity + "]");
            }

            System.out.println("Please enter your selection:");
            System.out.println("1. Add a new item to your inventory");
            System.out.println("2. Remove an item from your inventory");
            System.out.println("3. Update an item's quantity");

            String selection = scanner.nextLine();
            switch  (selection){
                case ("1"):
                    System.out.println("What item would you like to add?:");
                    String item = scanner.nextLine();
                    System.out.println("How many would you like to add?:");
                    int quantity = Integer.valueOf(scanner.nextLine());
                    inventory.add(new Item(item, quantity));
                    System.out.println("Item added. Returning to main menu.");
                    break;
                case ("2"):
                    System.out.println("What item would you like to remove?:");
                    item = scanner.nextLine();
                    for (Item i: inventory){
                        if (i.item.equalsIgnoreCase(item)){
                            inventory.remove(i);
                        }
                    }
                    System.out.println("That item has been removed. Returning to main menu.");
                    break;
                case ("3"):
                    System.out.println("Which item would you like to update?:");
                    item = scanner.nextLine();
                    System.out.println("What is the new quantity for your " + item + "?:");
                    quantity = Integer.valueOf(scanner.nextLine());
                    for (Item i: inventory){
                        if (i.item.equalsIgnoreCase(item)){
                            i.quantity = quantity;
                        }
                    }
                    System.out.println("Item quantity has been updated. Returning to main menu.");

                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }

        }
    }
}
