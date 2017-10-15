/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author pascal
 */
public class CmdProcess implements Runnable{
    
    private String cmdBefehl;
    public CmdProcess(String befehl) {
        this.cmdBefehl = befehl;
    }

    @Override
    public void run() {
        
        try {
            Process process =  Runtime.getRuntime().exec("cmd /c "+this.cmdBefehl);
            process.waitFor();
            
            InputStream s = process.getInputStream();
            int cmdFeet = s.read();
            while (cmdFeet != -1) {
                
                System.out.print((char)cmdFeet);
                cmdFeet = s.read();
            }
        } catch (Exception e) {
            System.out.print("Error try it again!\n");
        }
       
    }
    
}