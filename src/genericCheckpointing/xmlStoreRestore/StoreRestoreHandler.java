/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import driver.SerializableObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ankit Mahale
 */
public class StoreRestoreHandler implements InvocationHandler {

    String fileName;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    SerializableObject so;
    public static int LineInFile=1;
    SerializeTypes srTypes=new SerializeTypes();
    DeserializeTypes deserTypes=new DeserializeTypes();
    @Override
    public Object invoke(Object o, Method method, Object[] os) throws Throwable {
        
        
        if(method.getName().contains("write"))
        {
            if(os[1].equals("XML"))
            {
             serializeData((SerializableObject) os[0],new XMLSerialization());
            
            }
          /*   if(os[1].equals("JSon"))
            {
             serializeData((SerializableObject) os[0],new JSONSerialization());
            
            } */
            
            
        }
        if(method.getName().contains("read"))
        {
            
            if(os[0].equals("XML"))
            {
                  so=deSerializeData((DeserStrategy) new XMLDeserialization());
                  return so;
            }  
            
            
        }
        
        return null;
    }
    
    public void openFileForReading(String inputfileNameIn) throws FileNotFoundException
            
    {
        fileName=inputfileNameIn;
        FileReader fileReader = new FileReader(fileName);
        bufferedReader =new BufferedReader(fileReader);
        

    }        
    public void openFileForWriting(String outputfileNameIn) throws FileNotFoundException, IOException
    {
        fileName=outputfileNameIn;
        FileWriter fileWriter = new FileWriter(fileName);
        bufferedWriter =new BufferedWriter(fileWriter);
        
        
    
    }    
    public void closeFileAfterReading() throws IOException
    {
       bufferedReader.close();
    } 
    
    public void closeFileAfterWriting() throws IOException
    {
       bufferedWriter.close();
    }
    
    
    public void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
              sStrategy.processInput(sObject,bufferedWriter);
    }
    public SerializableObject deSerializeData(DeserStrategy deserStrategy) {
              return(deserStrategy.processOutput(bufferedReader));
    }
    
    
    
    
    
    
    
    
    
    
}
