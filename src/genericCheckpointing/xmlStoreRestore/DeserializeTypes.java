/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

/**
 *
 * @author Ankit Mahale
 */
public class DeserializeTypes {
    
    public Object deserialize(String str)
    {
        Object val;
       // System.out.println(str.indexOf(">"));
       // System.out.println(str.lastIndexOf("<"));
        val= str.substring(str.indexOf(">") + 1, str.lastIndexOf("<"));
        return val;
    }        
    
    
    
    
}
