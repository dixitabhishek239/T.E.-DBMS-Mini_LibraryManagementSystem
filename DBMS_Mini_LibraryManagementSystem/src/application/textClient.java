package application;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import libraryManagementSystem.beans.TestTable;
import libraryManagementSystem.helpers.UserDetailsHelper;

public class textClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String username = "ABC";
		
		 String myPassword = "abc";
	        
	        // Generate Salt. The generated value can be stored in DB. 
	        String salt = PasswordUtils.getSalt(30);
	        
	        // Protect user's password. The generated value can be stored in DB.
	        String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
	        
	        // Print out protected password 
//	        System.out.println("My secure password = " + mySecurePassword);
//	        System.out.println("Salt value = " + salt);

		
//	    TestTable userName = new TestTable(username,mySecurePassword,salt);
	        
		TestTable data = new UserDetailsHelper().getDecryptedPassword(username);
		
		
		
		
		
		 // User provided password to validate
        String providedPassword = myPassword;
                
        // Encrypted and Base64 encoded password read from database
        String securePassword = data.getPassword();
        
        // Salt value stored in database 
        String salt1 = data.getSalt();
        
        boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt1);
        
        if(passwordMatch) 
        {
            System.out.println("Provided user password " + providedPassword + " is correct.");
        } else {
            System.out.println("Provided password is incorrect");
        }

	}
	
}

class PasswordUtils {
    
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    
     public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
    public static String generateSecurePassword(String password, String salt) {
        String returnValue = null;
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
 
        returnValue = Base64.getEncoder().encodeToString(securePassword);
 
        return returnValue;
    }
    
    public static boolean verifyUserPassword(String providedPassword,
            String securedPassword, String salt)
    {
        boolean returnValue = false;
        
        // Generate New secure password with the same salt
        String newSecurePassword = generateSecurePassword(providedPassword, salt);
        
        // Check if two passwords are equal
        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
        
        return returnValue;
    }
}











//class ProtectUserPassword {
//    public static void main(String[] args)
//    {
//        String myPassword = "myPassword123";
//        
//        // Generate Salt. The generated value can be stored in DB. 
//        String salt = PasswordUtils.getSalt(30);
//        
//        // Protect user's password. The generated value can be stored in DB.
//        String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
//        
//        // Print out protected password 
//        System.out.println("My secure password = " + mySecurePassword);
//        System.out.println("Salt value = " + salt);
//    }
//}







//class VerifyProvidedPassword {
//    public static void main(String[] args)
//    {
//       
//    }
//}