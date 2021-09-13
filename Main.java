import AddressBook.SerializationToFilePersistence;
import AddressBook.*;
import AddressBookFrames.*;

import java.awt.*;
import java.io.File;

public class Main {
    private static final String ADDRESS_KITABI_DEFAULT = "AdressKitabi.ak";
    private SerializationToFilePersistence persistance;
    private AddressBookModel model;
    private Frame mainFrame;
    private Controller controller;

    public Main() throws AddressBookException{
        initModelAndPersistance();
        PersonPanel personPanel = new PersonPanel(model);
        Button newPersonButton = new Button("Yeni Girdi");
        mainFrame = new AddressBookMainFrame(personPanel, newPersonButton);
        controller = new Controller(model, personPanel, persistance, mainFrame);
        newPersonButton.addActionListener(controller);
        mainFrame.addWindowListener(controller);
        mainFrame.setVisible(true);
    }

    private void initModelAndPersistance() throws AddressBookException{
        String adressKitabiDirPath = System.getProperty("user.home") + "/adresskitabi";
        File adressKitabiDir = new File(adressKitabiDirPath);
        adressKitabiDir.mkdir();
        String adressKitabiPath = adressKitabiDirPath + "/" + ADDRESS_KITABI_DEFAULT;
        persistance = new SerializationToFilePersistence(adressKitabiPath);
        File adressKitabiDosyasi = new File(adressKitabiPath);
        if (adressKitabiDosyasi.exists()){
            System.out.println("Adress kitabi bulundu, yükleniyor...");
            model = persistance.loadBook();
        } else {
            System.out.println("Kitap bulunamadi! Olusturuluyor...");
            model = new ArrayListAddressBookDataModel();
        }
    }

    public static void main(String[] args) throws AddressBookException {
        new Main();
    }
}
