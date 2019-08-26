/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import threadz.SingleCharThreads;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.lang.Thread;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import threadz.SingleLineThreads;
import threadz.SingleWordThreads;
import threadz.WholeFileThreads;

/**
 *
 * @author Szaman
 */
public class FXMLDocumentController
{
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button exit;
    @FXML
    private TextArea threadArea1;
    @FXML
    private TextArea threadArea2;
    @FXML
    private TextArea threadArea3;
    @FXML
    private TextArea comboPit;
    
    String lineReader = null;
    
    String eol = System.getProperty("line.separator");
    
    String file1Location = "src/text1.txt";
    String file2Location = "src/text2.txt";
    String file3Location = "src/text3.txt";
    
    FileWriter fileWriter1 = null;
    FileWriter fileWriter2 = null;
    FileWriter fileWriter3 = null;
    
    FileWriter fileWriter = null;
    
    private char[] array = null;
    
    List<Thread> threadList = new ArrayList<Thread>();
    
    private String reader;
    private String container;
    
    FileReader readFromFile = null;
    BufferedReader bufforForFile = null;
    
    @FXML
    private void handleAction1(ActionEvent event) throws IOException, InterruptedException 
    {
        System.out.println("1");
        
        Path path = Paths.get("src/singleCharThreadsOutput.txt");
        Files.deleteIfExists(path);
        
        comboPit.clear();
        threadArea1.clear();
        threadArea2.clear();
        threadArea3.clear();
        
        threadList.clear();
        
        Thread thread1 = new SingleCharThreads("Thread1", file1Location, threadArea1);
        Thread thread2 = new SingleCharThreads("Thread2", file2Location, threadArea2);
        Thread thread3 = new SingleCharThreads("Thread3", file3Location, threadArea3);
        thread1.start();
        thread2.start();
        thread3.start();

        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);
        for(Thread t : threadList) 
        {
            t.join();
        }
        System.out.println("Koniec watkowania!");
                
        try
        {
            try 
            {
                fileWriter = new FileWriter("src/singleCharThreadsOutput.txt", true);
                BufferedWriter buffer = new BufferedWriter(fileWriter);
                PrintWriter output = new PrintWriter(buffer);
                output.println("KONIEC");
                output.close();
                fileWriter.close();
                buffer.close();
            } 
            catch (IOException ex) 
            {
                System.out.println("Problem z plikiem wyjsciowym");
            }
            
            container = null;
            
            try 
            {
                readFromFile = new FileReader("src/singleCharThreadsOutput.txt");
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("Problem z plikiem txt!");
            }
            bufforForFile = new BufferedReader(readFromFile);
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
            bufforForFile.close();
            readFromFile.close();
            System.out.println(container);
            comboPit.setText(container);
        }
        catch(Exception e)
        {
            System.out.println("ComboPit doesn't work properly.");
        }
    }
    
    @FXML
    private void handleAction2(ActionEvent event) throws IOException, InterruptedException 
    {
        System.out.println("2");
        Path path = Paths.get("src/singleWordThreadsOutput.txt");
        Files.deleteIfExists(path);
        
        comboPit.clear();
        threadArea1.clear();
        threadArea2.clear();
        threadArea3.clear();
        
        threadList.clear();
        
        Thread thread1 = new SingleWordThreads("Thread1", file1Location, threadArea1);
        Thread thread2 = new SingleWordThreads("Thread2", file2Location, threadArea2);
        Thread thread3 = new SingleWordThreads("Thread3", file3Location, threadArea3);
        thread1.start();
        thread2.start();
        thread3.start();

        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);
        for(Thread t : threadList) 
        {
            t.join();
        }
        System.out.println("Koniec watkowania!");
                
        try
        {
            try 
            {
                fileWriter = new FileWriter("src/singleWordThreadsOutput.txt", true);
                BufferedWriter buffer = new BufferedWriter(fileWriter);
                PrintWriter output = new PrintWriter(buffer);
                output.println("KONIEC");
                output.close();
                fileWriter.close();
                buffer.close();
            } 
            catch (IOException ex) 
            {
                System.out.println("Problem z plikiem wyjsciowym");
            }
            
            container = null;
            
            try 
            {
                readFromFile = new FileReader("src/singleWordThreadsOutput.txt");
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("Problem z plikiem txt!");
            }
            bufforForFile = new BufferedReader(readFromFile);
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
            bufforForFile.close();
            readFromFile.close();
            System.out.println(container);
            comboPit.setText(container);
        }
        catch(Exception e)
        {
            System.out.println("ComboPit doesn't work properly.");
        }
    }
    
    @FXML
    private void handleAction3(ActionEvent event) throws IOException, InterruptedException 
    {
        System.out.println("3");
        Path path = Paths.get("src/singleLineThreadsOutput.txt");
        Files.deleteIfExists(path);
        
        comboPit.clear();
        threadArea1.clear();
        threadArea2.clear();
        threadArea3.clear();
        
        threadList.clear();
        
        Thread thread1 = new SingleLineThreads("Thread1", file1Location, threadArea1);
        Thread thread2 = new SingleLineThreads("Thread2", file2Location, threadArea2);
        Thread thread3 = new SingleLineThreads("Thread3", file3Location, threadArea3);
        thread1.start();
        thread2.start();
        thread3.start();

        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);
        for(Thread t : threadList) 
        {
            t.join();
        }
        System.out.println("Koniec watkowania!");
                
        try
        {
            try 
            {
                fileWriter = new FileWriter("src/singleLineThreadsOutput.txt", true);
                BufferedWriter buffer = new BufferedWriter(fileWriter);
                PrintWriter output = new PrintWriter(buffer);
                output.println("KONIEC");
                output.close();
                fileWriter.close();
                buffer.close();
            } 
            catch (IOException ex) 
            {
                System.out.println("Problem z plikiem wyjsciowym");
            }
            
            container = null;
            
            try 
            {
                readFromFile = new FileReader("src/singleLineThreadsOutput.txt");
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("Problem z plikiem txt!");
            }
            bufforForFile = new BufferedReader(readFromFile);
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
            bufforForFile.close();
            readFromFile.close();
            System.out.println(container);
            comboPit.setText(container);
        }
        catch(Exception e)
        {
            System.out.println("ComboPit doesn't work properly.");
        }
    }
    
    @FXML
    private void handleAction4(ActionEvent event) throws IOException, InterruptedException 
    {
        System.out.println("4");
        Path path = Paths.get("src/wholeFileThreadsOutput.txt");
        Files.deleteIfExists(path);
        
        comboPit.clear();
        threadArea1.clear();
        threadArea2.clear();
        threadArea3.clear();
        
        threadList.clear();
        
        Thread thread1 = new WholeFileThreads("Thread1", file1Location, threadArea1);
        Thread thread2 = new WholeFileThreads("Thread2", file2Location, threadArea2);
        Thread thread3 = new WholeFileThreads("Thread3", file3Location, threadArea3);
        thread1.start();
        thread2.start();
        thread3.start();

        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);
        for(Thread t : threadList) 
        {
            t.join();
        }
        System.out.println("Koniec watkowania!");
        
        
                
        try
        {
            try 
            {
                fileWriter = new FileWriter("src/wholeFileThreadsOutput.txt", true);
                BufferedWriter buffer = new BufferedWriter(fileWriter);
                PrintWriter output = new PrintWriter(buffer);
                output.println("KONIEC");
                output.close();
                fileWriter.close();
                buffer.close();
            } 
            catch (IOException ex) 
            {
                System.out.println("Problem z plikiem wyjsciowym");
            }
            
            container = null;
            
            try 
            {
                readFromFile = new FileReader("src/wholeFileThreadsOutput.txt");
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("Problem z plikiem txt!");
            }
            bufforForFile = new BufferedReader(readFromFile);
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
            bufforForFile.close();
            readFromFile.close();
            System.out.println(container);
            comboPit.setText(container);
        }
        catch(Exception e)
        {
            System.out.println("ComboPit doesn't work properly.");
        }
    }
    
    @FXML
    private void handleExit(ActionEvent event) 
    {
        System.out.println("Bye!");
        System.exit(0);
    }
}
