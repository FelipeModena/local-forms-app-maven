package modena;

import modena.matricula.MenuFrame;
import modena.matricula.db.sqlite.connect.ConnectionManagerSQLite;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        ConnectionManagerSQLite.getDbConnection();

        MenuFrame menuFrame = new MenuFrame();
        menuFrame.initialize();
    }


}
