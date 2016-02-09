import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by PiratePowWow on 2/8/16.
 */
public class Main {
    private static Scanner scanner = new Scanner((System.in));



    public static void main(String[] args) throws CategoryException {
        HashMap<String, String> users = new HashMap<>();
        users.put("Bob", "Smith");
        users.put("Alice", "Smith");
        users.put("Charlie", "Work");
        ArrayList<Item> inventory = new ArrayList<>();

        login(users);


        while (true) {


            for (Item item : inventory){
                System.out.printf("%s: %s [%d]\n", item.category, item.item, item.quantity);
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
                    System.out.println("What category is the item?");
                    String category = scanner.nextLine();
                    inventory.add(createItem(item, quantity, category));
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
                    System.out.printf("What is the new quantity for your %s?:\n", item);
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
    public static void login(HashMap<String, String> users) {
        System.out.printf("Please enter login credentials\n Name: ");
        String name = scanner.nextLine();
        System.out.printf("Password: ");
        String password = scanner.nextLine();
        if (users.get(name).equals(password)) {
            System.out.printf("Listing %s's inventory:", name);

        }
        else {
            System.out.println("Login credentials not recognized.");
            login(users);
        }

    }

    public static Item createItem(String name, int quantity, String category) throws CategoryException {
        switch (category){
            case "Weapon":
                return new Weapon(name, quantity);
            case "Armor":
                return new Armor(name, quantity);
            case "Consumable":
                return new Consumable(name, quantity);
            case "Lore":
                return new Lore(name,quantity);
            case "Skill":
                return new Skill(name, quantity);
            default:
                throw new CategoryException("Invalid Category");

        }
    }

}
