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
        for (int i = 0; i < contacts.getSize(); i++) {
            Contact<?, ?> c = contacts.get(i);
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public void deleteContactByName(String name) {
        for (int i = 0; i < contacts.getSize(); i++) {
            Contact<?, ?> c = contacts.get(i);
            if (c.getName().equals(name)) {
                contacts.deleteByValue(c);
                break;
            }
        }
    }

    public void printList() {
        contacts.print();
    }
}