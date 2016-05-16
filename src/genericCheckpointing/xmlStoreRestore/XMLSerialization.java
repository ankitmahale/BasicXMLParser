/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import driver.SerializableObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ankit Mahale
 */
public class XMLSerialization implements SerStrategy{

    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;
    SerializeTypes srTypes=new SerializeTypes();
    
    @Override
   public void processInput(SerializableObject sObject,BufferedWriter bufferedWriterIn) {
        try {
            bufferedWriter=bufferedWriterIn;
            Object obj=sObject; 
            Class<?> cls=obj.getClass();
            Field[] flist=cls.getDeclaredFields();
            bufferedWriter.write("<DPSerialization>\n");
            String line="<complexType xsi:type=\"genericCheckpointing.util."+cls.getSimpleName()+"\">\n";
            bufferedWriter.write(line);
            for(int i=0;i<flist.length;i++)
            {
                Field oneField=flist[i];
                String output;
                output = oneField.getType().toString().substring(0, 1).toUpperCase() + oneField.getType().toString().substring(1);
                if(output.contains("String"))
                    output="String";
                output="get"+output+"Val";
                Method oneMethod=cls.getMethod(output);
                Object x= oneMethod.invoke(obj);
                line=srTypes.Serialize(oneField.getType(),oneField.getName() , x);
                bufferedWriter.write(line);
            }
            bufferedWriter.write("</complexType>\n"+"</DPSerialization>\n");
        } catch (IOException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    
     
    
    
}
