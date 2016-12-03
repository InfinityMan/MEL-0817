/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.crypto;

import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Dmig
 */
public final class KeyWorker {
    
    /**
     * Get base64 encoded version of the key
     * @param secretKey key
     * @return base64 encoded version of the key
     */
    
    public static String keyToString(SecretKey secretKey) {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
    
    /**
     * Get SecretKey from encoded string
     * @param encodedKey String (key)
     * @param algorithm Algorithm of the needed key
     * @return SecretKey of the key
     */
    
    public static SecretKey stringToKey(String encodedKey, String algorithm) {
        // decode the base64 encoded string
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        // rebuild key using SecretKeySpec
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, algorithm);
    }
}
