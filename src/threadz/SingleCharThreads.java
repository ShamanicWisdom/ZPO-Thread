/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.TextArea;

public class SingleCharThreads extends Thread 
{
    private Thread thread;
    private String threadName;
    private String location;
    
    
    private TextArea threadArea;
    
    private char[] array = null;
    
    String eol = System.getProperty("line.separator");
    
    private String reader;
    private String container;
    
    StringBuilder builder = new StringBuilder();
    
    FileReader readFromFile = null;
    BufferedReader bufforForFile = null;
    FileInputStream fileInput = null;
    
    FileWriter fileWriter = null;// = new FileWriter("outfilename", true);
    BufferedWriter bufferedWriter = null;// = new BufferedWriter(fw);
    PrintWriter out = null;// new PrintWriter(bw))
    
    int singleChar;
    
    int i;
    
/****************************************************************************************************************************/
   
    public SingleCharThreads(String name, String location, TextArea threadArea) 
    {
        threadName = name;
        this.location = location;
        this.threadArea = threadArea;
        System.out.println("Tworzenie " + threadName);
    }
  
/****************************************************************************************************************************/
    
    @Override
    public synchronized void run() 
    {
        System.out.println(threadName + " dziala...");
        System.out.println(container);
        int length = array.length;
        threadArea.setText("" + container);
            try 
            {
                for (i = 0; i < length; i++) 
                {
                    out = new PrintWriter(bufferedWriter);

                    out.print(array[i]);

                    System.out.print("" + array[i]);
                    thread.sleep(10);
                    out.flush();
                }
            }
            catch (InterruptedException e) 
            {
                System.out.println("Watek " +  threadName + " przerwany.");
            }
        out.close();
        System.out.println("Watek " +  threadName + " zamykany.");
    }
   
/****************************************************************************************************************************/
    
    @Override
    public synchronized void start() 
    {
        System.out.println("Start watku: " +  threadName );
        threadArea.setText(null);
        
        if (thread == null) 
        {         
            try 
            {
                readFromFile = new FileReader(location);
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("Problem z plikiem txt!");
            }

            bufforForFile = new BufferedReader(readFromFile);

            try
            {
                
                while((reader = bufforForFile.readLine()) != null)
                {
                    if(container == null)
                    {
                        container = reader + System.lineSeparator();
                    }
                    else
                    {
                        container += reader + System.lineSeparator();
                    }
                }
            }
            catch (IOException e)
            {
                System.out.println("Problem z odczytem txt!");
            }
            array = container.toCharArray();
            
            System.out.println(array);
            
            try 
            {
                fileWriter = new FileWriter("src/singleCharThreadsOutput.txt", true);
            } 
            catch (IOException ex) 
            {
                System.out.println("Problem z plikiem wyjsciowym");
            }
            
            bufferedWriter = new BufferedWriter(fileWriter);
            out = new PrintWriter(bufferedWriter);
            
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}