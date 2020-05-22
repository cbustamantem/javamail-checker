/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.test.reader;

import java.io.Console;
import java.util.Scanner;

/**
 *
 * @author cbustamante
 */
public class InputReaderScanner  {

     private static Scanner scn = new Scanner(System.in);
    /**
     *
     * @param comments
     * @return
     */
    public String read(String comments) {
        System.out.print("Please enter > " + comments + ": ");
        String valorLeido = scn.nextLine();
        if (valorLeido != null) {
            return valorLeido.trim();
        } else {
            return "N/A";
        }
    }
    public String readPassword(String comments) {        
        
         Console console = System.console();
         console.printf("Please enter > " + comments + ": ");
         char[] pwd =console.readPassword();
        String valorLeido = new String (pwd);
        if (valorLeido != null) {
            return valorLeido.trim();
        } else {
            return "--";
        }
    }

    

}
