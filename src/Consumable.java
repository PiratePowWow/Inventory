/**
 * Created by PiratePowWow on 2/9/16.
 */
public class Consumable extends Item {
    public Consumable(String item, int quantity) {
        super(item, quantity);
        this.category = "consumable";
    }
}
