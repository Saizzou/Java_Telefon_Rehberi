package AddressBook;

public interface FullPersistance {
    AddressBookModel loadBook() throws AddressBookException;
    void storeBook(AddressBookModel book) throws AddressBookException;
}
