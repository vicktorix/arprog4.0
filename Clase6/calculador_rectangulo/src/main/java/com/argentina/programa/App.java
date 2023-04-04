package com.argentina.programa;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        HashMap<String,Double> test = new HashMap<>();
        test.put("algo", 1.0);

        System.out.println(test.get("algo"));
    }
}
