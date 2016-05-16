/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import driver.SerializableObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ankit Mahale
 */
public class XMLDeserialization implements DeserStrategy {
    
    BufferedReader bufferedReader;
    SerializableObject so;
    DeserializeTypes deserTypes=new DeserializeTypes();
    
    
    public SerializableObject processOutput(BufferedReader bufferedReaderIn) {

        try {
            bufferedReader=bufferedReaderIn;
            
            String readline;
            String objName;
            Class cls = null;
            
            while((readline=bufferedReader.readLine())!= null)
            {
                
                if(readline.contains("genericCheckpointing"))
                {
                    objName=readline.substring(readline.lastIndexOf(".")+1,readline.lastIndexOf("\""));
                    cls =  Class.forName("driver."+objName);
                    so=(SerializableObject) cls.newInstance();
                    
                    
                }
                if(readline.contains("my"))
                {
                    Method[] methods = cls.getMethods();
                    Object val=deserTypes.deserialize(readline);
                    String type= readline.substring(readline.lastIndexOf(":") + 1, readline.lastIndexOf("\""));
                    for(int i=0;i<methods.length;i++)
                    {
                        if(methods[i].getName().contains("set"+type.substring(0, 1).toUpperCase() + type.substring(1)))
                        {
                            methods[i].invoke(so,val);
                            
                        }
                    }
                }
                if(readline.contains("/DPSerialization"))
                {
                    return so;
                }
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(XMLDeserialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XMLDeserialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(XMLDeserialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(XMLDeserialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(XMLDeserialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(XMLDeserialization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
}
