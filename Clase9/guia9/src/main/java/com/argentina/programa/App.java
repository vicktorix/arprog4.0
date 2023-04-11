package com.argentina.programa;

import com.argentina.programa.db.Connect;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!");

        Connect conn = new Connect();
        conn.checkDbExist();
        if (!conn.tableExists("Departamentos")) {
            conn.createTableDepartamento();
        }
        if (!conn.tableExists("Empleados")) {
            conn.createTableEmpleado();
        }
        conn.listTables();
    }
}
