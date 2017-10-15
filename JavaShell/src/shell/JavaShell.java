/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA_2_3.portable.InputStream;

/**
 *
 * @author pascal
 */
public class JavaShell {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) throws InterruptedException {
        
        Scanner scanner = new Scanner(System.in);;
        String userInput;
        Boolean isRunning = true;
        
        System.out.print("With every new input you will start \nat the project directory.\nIf you want do see an other directory you need to \nwrite somthing like cd .. && dir.\nexit to exit\n"); 
        
        while(isRunning == true){
            
            System.out.print("Cmd:");
            userInput = scanner.nextLine();

           
                if(userInput.equals("exit")){
                    isRunning = false;
                }
                else{
                    UseCmd(userInput);
                }
                   Thread.sleep(250);
        }
        
    }
    
    private static void UseCmd(String arg){
        
        Runnable r = new CmdProcess(arg);
        Thread t = new Thread(r);
        t.start();
        
    }
    
    
    
}