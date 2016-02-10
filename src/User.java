import java.util.ArrayList;

/**
 * Created by PiratePowWow on 2/9/16.
 */
public class User {
    String name;
    String password;
    ArrayList<Item> inventory = new ArrayList<>();
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
