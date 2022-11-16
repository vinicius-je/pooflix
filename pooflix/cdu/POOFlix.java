package cdu;

import java.sql.Connection;
import persistence.DBConnection;
import ui.*;

public class POOFlix {
    public static void main(String[] args){
        DBConnection db = new DBConnection();
        Connection database = db.dataBaseCon();
        FormMain telaMain = new FormMain();
        CDUMain casoUsoMain = new CDUMain(telaMain);
        casoUsoMain.exec();
    }
}