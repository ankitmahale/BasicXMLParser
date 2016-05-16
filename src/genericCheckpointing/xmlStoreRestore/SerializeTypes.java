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
public class SerializeTypes {
    public String Serialize(Object xsdType, String Fname, Object val)
    {
        String serializedLine;
        if(xsdType.toString().endsWith("String"))
        serializedLine="<"+Fname+" xsi:type="+"\"xsd:"+"string"+"\""+">"+val+"</"+Fname+">\n";
        else
            serializedLine="<"+Fname+" xsi:type="+"\"xsd:"+xsdType+"\""+">"+val+"</"+Fname+">\n";
        
        return serializedLine;        
        
    }        
}




