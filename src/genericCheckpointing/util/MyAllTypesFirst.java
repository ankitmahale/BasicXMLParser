/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

/**
 *
 * @author Ankit Mahale
 */
public class MyAllTypesFirst extends SerializableObject {
    
    private int myInt;
    private long myLong;
    private String myString;
    private boolean myBool;
    private String importantField;
    
    public void setInt(Object myIntIn )
    {
        //System.out.println("This is int");
        myInt=Integer.parseInt(myIntIn.toString());
    }
    public void setLong(Object myLongIn )
    {
        //System.out.println("This is long");
        myLong=Long.parseLong(myLongIn.toString());
    }
    public void setString(Object myStringIn )
    {
        //System.out.println("This is String");
        myString= myStringIn.toString();
    }
    public void setBoolean(Object myBoolIn )
    {
        //System.out.println("This is boolean");
        myBool=Boolean.parseBoolean(myBoolIn.toString());
    }
    
    @Override
    public String toString()
    {
        String objectVal = null;
        objectVal="ClassName : "+ this.getClass().toString()+"\nmyInt : "+this.getIntVal()+"\nmyLong : "+ this.getLongVal() +"\nmyString : "+this.getStringVal()+"\nmyBool : "+this.getBooleanVal()+"\n";
        return objectVal;
    
    }
    
    public boolean equals(Object so)
    {
        if(so.getClass()!=getClass())
            return false;
        MyAllTypesFirst first=(MyAllTypesFirst) so;
        if(getIntVal()!=first.getIntVal()) return false;
        if(getLongVal()!=first.getLongVal()) return false;
        if(getBooleanVal()!=first.getBooleanVal()) return false;
        if(!getStringVal().equals(first.getStringVal())) return false;
        if (importantField == null) {
            if (first.importantField != null)
                return false;
        } else if (!importantField.equals(first.importantField))
            return false;
        return true;
    }    
    
    
     @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((importantField == null) ? 0 : importantField.hashCode());
        return result;
    }
    
    
    
    
    
    public int getIntVal()
    {
        return myInt;
    }        
    public long getLongVal()
    {
        return myLong;
    }
    public String getStringVal()
    {
        return myString;
    }
    public boolean getBooleanVal()
    {
        return myBool;
    }
   
}
