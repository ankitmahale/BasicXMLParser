/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.server;

import driver.SerializableObject;

/**
 *
 * @author Ankit Mahale
 */
public interface RestoreI extends StoreRestoreI{
    SerializableObject readObj(String wireFormat);
}
