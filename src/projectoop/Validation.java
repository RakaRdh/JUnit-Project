package projectoop;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validation {
    static boolean isUniqueUsername(String username, List<Account> accountList) {
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
     
    static boolean isUniquePhoneNumber(String phoneNumber, List<Account> accountList) {
        for (Account account : accountList) {
            if (account.getPhoneNumber().equals(phoneNumber)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBalance(String balance) {
        String balanceRegex = "^[1-9]\\d*(\\.\\d+)?$";
        return balance.matches(balanceRegex);
    }

    public static boolean isValidNik(String nik) {
        String nikRegex = "^\\d{16}$";
        return nik.matches(nikRegex);
    }
    
    
    public static boolean isValidEmail(String email) {
        String emailRegex = "^\\S+@\\S+\\.\\S+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

     
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^08\\d{8,12}$";
        return phoneNumber.matches(phoneRegex);
    }

    
    
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        return password.matches(passwordRegex);
    }
    
    
    
    static boolean isValidConfirmation(String input) {
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no");
    }

    
}