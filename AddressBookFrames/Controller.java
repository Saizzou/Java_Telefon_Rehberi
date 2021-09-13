package AddressBookFrames;

import AddressBook.*;
import Main.*;
import java.awt.*;
import java.awt.event.*;

public class Controller extends WindowAdapter implements ActionListener {
    private PersonPanel view;
    private Frame mainFrame;
    private AddressBookModel model;
    private FullPersistance persistance;

    public Controller (AddressBookModel model, PersonPanel view, FullPersistance persistance, Frame mainFrame){
        this.model = model;
        this.view = view;
        this.persistance = persistance;
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        createAndShowNewPersonDialog ();
    }

    @Override
    public void windowClosing(WindowEvent e){
        try {
            persistance.storeBook(model);
            System.out.println("Adress Kitabi kaydedildi!");
        } catch (AddressBookException abe) {
            System.out.println("Adress Kitabi kaydedilemedi...");
            abe.printStackTrace();
        } finally{
            System.exit(0);
        }
    }

    private void createAndShowNewPersonDialog() {
        Dialog newPersonDialog = new Dialog(mainFrame, "Yeni Kisi", true);
        Panel dataPanel = new Panel(new GridLayout(4,2));
        TextField isimTextField = new TextField(30);
        TextField soyisimTextField = new TextField(30);
        TextField telefonTextField = new TextField(30);
        dataPanel.add(new Label("Isim: "));
        dataPanel.add(isimTextField);
        dataPanel.add(new Label("Soyisim: "));
        dataPanel.add(soyisimTextField);
        dataPanel.add(new Label("Telefon No: "));
        dataPanel.add(telefonTextField);
        newPersonDialog.add(dataPanel, BorderLayout.CENTER);

        Button tmmButon = new Button("Tamam");
        tmmButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                Person newPerson = new Person(isimTextField.getText(),
                        soyisimTextField.getText(), telefonTextField.getText());
                model.addPerson(newPerson);
                view.refresh();
                newPersonDialog.dispose();
            }
        });
        Panel southPanel = new Panel();
        southPanel.add(tmmButon);
        newPersonDialog.add(southPanel, BorderLayout.SOUTH);

        newPersonDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                newPersonDialog.dispose();
            }
        });

        newPersonDialog.pack();
        newPersonDialog.setLocationRelativeTo(mainFrame);
        newPersonDialog.setVisible(true);
    }
}
