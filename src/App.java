import controller.ContactManager;
import controller.MenuController;
import view.ConsoleView;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Trabajo 3");

        ContactManager contactManager = new ContactManager();
        ConsoleView view = new ConsoleView();
        MenuController menu = new MenuController(contactManager, view);

        menu.showMenu();

    }
}
