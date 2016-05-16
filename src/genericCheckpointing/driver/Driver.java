
// Code developed by Kevin Johnson

package genericCheckpointing.driver;

import driver.MyAllTypesFirst;
import driver.MyAllTypesSecond;
import driver.SerializableObject;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;


public class Driver
{
    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 10;
    public static Random rand = new Random();
    public static String generateRandomString(){
         
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = rand.nextInt(60);
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
    
    
   public static void main(String[] args) throws IOException
   {
         
       String outputfile="C:\\Users\\Ankit Mahale\\Desktop\\Netbeans projects\\Driver\\src\\genericCheckpointing\\xmlStoreRestore\\output.txt";
       
       String mode="deser";
       int mismatchCount=0;
       int NUM_OF_OBJECTS=5;
       int integer;
       long longInteger;
       String stringVal;
       boolean boolVal;
       double doubleVal;
        float floatVal;
        short shortVal;
        char characterVal;
       
       
       
       ProxyCreator pc = new ProxyCreator();
       
       StoreRestoreHandler handler=new StoreRestoreHandler();
       
       StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
								 new Class[] {
								     StoreI.class, RestoreI.class
								 }, 
								 handler
								 );
	MyAllTypesFirst myFirst;
	MyAllTypesSecond  mySecond;
        SerializableObject myRecordRet;
        
        if(mode.equals("deser"))
        {
             
            handler.openFileForReading(outputfile);
            for (int j=0; j<2*NUM_OF_OBJECTS; j++) {

                myRecordRet = ((RestoreI) cpointRef).readObj("XML");
                System.out.println(myRecordRet.toString());
                
            }
            handler.closeFileAfterReading();
            
        }
        else if(mode.equals("serdeser"))
        {
            
              Vector <Object> vectorOld = new Vector <Object>(50);
              handler.openFileForWriting(outputfile);
              for (int i=0; i<NUM_OF_OBJECTS; i++) {
                myFirst = new MyAllTypesFirst();
                integer=rand.nextInt(100);
                longInteger=rand.nextLong();
                stringVal=generateRandomString();
                if(rand.nextInt(2)==0)
                   boolVal=true;
                else
                   boolVal=false;
                myFirst.setInt(integer);
                myFirst.setLong(longInteger);
                myFirst.setString(stringVal);
                myFirst.setBoolean(boolVal);
                mySecond = new MyAllTypesSecond();
                doubleVal=rand.nextDouble();
                floatVal=rand.nextFloat();
                shortVal=(short) rand.nextInt(32767);
                characterVal=(char) (rand.nextInt(52)+65);
                mySecond.setDouble(doubleVal);
                mySecond.setFloat(floatVal);
                mySecond.setShort(shortVal);
                mySecond.setChar(characterVal);
                vectorOld.add(myFirst);
                vectorOld.add(mySecond);
                ((StoreI) cpointRef).writeObj(myFirst, "XML");
                ((StoreI) cpointRef).writeObj(mySecond, "XML");
          
            }
            handler.closeFileAfterWriting();
            
            
            handler.openFileForReading(outputfile);
            Vector <Object> vectorNew = new Vector <Object>(50);
          
          for (int j=0; j<2*NUM_OF_OBJECTS; j++) {

                myRecordRet = ((RestoreI) cpointRef).readObj("XML");
                vectorNew.add(myRecordRet);
                if(!vectorNew.get(j).equals(vectorOld.get(j)))
                mismatchCount++;    
          }
         
          handler.closeFileAfterReading();
            System.out.println("Total number of Mismatched Objects are : "+mismatchCount);
          
        }  
        else
        System.out.println("Wrong mode of serialization");

   }
   
}
