package com.argentina.programa.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private Connection conn = null;

    public boolean connect(String url){
        try {
            conn = DriverManager.getConnection(url);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
}
