package weapons.exceptions;

public class InventoryFullException extends Throwable {
    public InventoryFullException(String errorMessage) {
        super(errorMessage);
    }
}
