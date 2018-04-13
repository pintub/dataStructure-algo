package com.p2;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map<String, String> m = new HashMap();
        String i = "Hi";

        m.put(i, "Pintu");

        i="Hii";

        System.out.println(m.get(i));
        System.out.println( "Hello World!" );
    }
}
