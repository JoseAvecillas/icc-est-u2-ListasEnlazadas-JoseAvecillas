package controller;

import models.Contact;
import view.ConsoleView;

public class MenuController {

    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController(ContactManager contactManager, ConsoleView consoleView) {
        this.contactManager = contactManager;
        this.consoleView = consoleView;
    }

    public void showMenu() {
        boolean exit = false;

        while (!exit) {
            consoleView.displayMenu();
            String choice = consoleView.getInput("Elige una opción: ");

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    findContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    printList();
                    break;
                case "5":
                    consoleView.showMessage("¡Hasta luego!");
                    exit = true;
                    break;
                default:
                    consoleView.showMessage("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private void addContact() {
        String name = consoleView.getInput("Nombre del contacto: ");
        String phone = consoleView.getInput("Teléfono del contacto: ");
        Contact<String, String> contact = new Contact<>(name, phone);
        contactManager.addContact(contact);
        consoleView.showMessage("Contacto agregado exitosamente.");
    }

    private void findContact() {
        String name = consoleView.getInput("Nombre a buscar: ");
        Contact<?, ?> contact = contactManager.findContactByName(name);
        if (contact != null) {
            consoleView.showMessage("Contacto encontrado: " + contact);
        } else {
            consoleView.showMessage("No se encontró el contacto.");
        }
    }

    private void deleteContact() {
        String name = consoleView.getInput("Nombre a eliminar: ");
        Contact<?, ?> contact = contactManager.findContactByName(name);
        if (contact != null) {
            contactManager.deleteContactByName(name);
            consoleView.showMessage("Contacto eliminado.");
        } else {
            consoleView.showMessage("No se encontró el contacto.");
        }
    }

    private void printList() {
        consoleView.showMessage("Lista de contactos:");
        contactManager.printList();
    }
}