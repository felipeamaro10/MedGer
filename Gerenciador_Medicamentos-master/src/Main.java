import Database.*;
import Interface.Menu;

public class Main {
    public static void main(String[] args) {
        Conector.getConnection();
        Menu.menu();
    }
}