package AddressBook;

public class AddressBookException extends Exception {
    public AddressBookException(String message) {
        super(message);
    }
    public AddressBookException(Throwable cause) {
        super(cause);
    }
}