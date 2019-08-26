/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadz;

/**
 *
 * @author Szaman
 */
public class Threadz extends Thread
{
    private String strings;
    
    public Threadz(String filesContent)
    {
        strings = filesContent;
    }

    public void run()
    {
        for(int i = 0; i < strings.length(); i++)
        {
            System.out.print(strings.charAt(i));
            try 
            {
                    Thread.sleep(20);
            } 
            catch (InterruptedException e) 
            {
                    e.printStackTrace();
            }
        }
    }
}
