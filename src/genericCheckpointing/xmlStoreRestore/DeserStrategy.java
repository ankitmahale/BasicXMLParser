/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import driver.SerializableObject;
import java.io.BufferedReader;

/**
 *
 * @author Ankit Mahale
 */
public interface DeserStrategy {

    public SerializableObject processOutput(BufferedReader bufferedReaderIn);
    
    
    
}
