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
public class MyAllTypesSecond extends SerializableObject{
    private double myDoubleT;
    private float myFloatT;
    private short myShortT;
    private char myCharT;
    public void setDouble(Object myDoubleTIn )
    {
        myDoubleT=Double.parseDouble(myDoubleTIn.toString());
    }
    public void setFloat(Object myFloatTIn )
    {
        myFloatT=Float.parseFloat(myFloatTIn.toString());
    }
    public void setShort(Object myShortTIn )
    {
        myShortT=Short.parseShort(myShortTIn.toString());
    }
    public void setChar(Object myCharTIn )
    {
        myCharT=myCharTIn.toString().charAt(0);
    }
    public double getDoubleVal()
    {
        return myDoubleT;
    }        
    public float getFloatVal()
    {
        return myFloatT;
    }
    public short getShortVal()
    {
        return myShortT;
    }
    public char getCharVal()
    {
        return myCharT;
    }
    
    @Override
    public String toString()
    {
        String objectVal = null;
        objectVal="ClassName : "+ this.getClass().toString()+"\nmyDouble : "+this.getDoubleVal()+"\nmyFloat : "+ this.getFloatVal() +"\nmyShort : "+this.getShortVal()+"\nmyChar : "+this.getCharVal()+"\n";
        return objectVal;
    
    }
    
    public boolean equals(Object so)
    {
        if(so.getClass()!=getClass())
            return false;
        MyAllTypesSecond second=(MyAllTypesSecond) so;
        if(getDoubleVal()!=second.getDoubleVal()) return false;
        if(getFloatVal()!=second.getFloatVal()) return false;
        if(getShortVal()!=second.getShortVal()) return false;
        if(getCharVal()!=second.getCharVal()) return false;
        return true;
    } 
    
    
    
    
}
