package controller;

import models.Contact;
import models.LinkedList;

public class ContactManager {

    private LinkedList<Contact<?, ?>> contacts;

    public ContactManager() {
        contacts = new LinkedList<>();
    }

    public void addContact(Contact<?, ?> contact) {
        contacts.appendToTail(contact);
    }

    public Contact<?, ?> findContactByName(String name) {
        Contact<?, ?> temp = new Contact<>(name, null);
        for (int i = 0; i < contacts.getSize(); i++) {
            if (contacts.get(i).equals(temp)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    public void deleteContactByName(String name) {
        Contact<?, ?> temp = new Contact<>(name, null);
        for (int i = 0; i < contacts.getSize(); i++) {
            if (contacts.get(i).equals(temp)) {
                contacts.deleteByValue(temp);
                break;
            }
        }
    }

    public void printList() {
        contacts.print();
    }
}