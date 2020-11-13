package stars;
import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class LoginController {
    private static final String SALT= "STARWARS";
    public boolean validateLogin(String userName, String enteredPassword, String typeOfUser)
    {   if(userName!=null && enteredPassword!=null&& (typeOfUser=="Student" || typeOfUser=="Admin") )
        {
        String hashedPassword = buildPasswordHash(enteredPassword);
        //now need to use FileController to verify the username and the password
            return true;
        }
        else
        {
        return false;
        }

    }
    private static String getHash(String password) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256"); // using SHA-256 algorithm for password hashing
            byte[] hashedBytes = sha.digest(password.getBytes());
            char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
            for (int idx = 0; idx < hashedBytes.length; idx++) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            // hash generation failure
        }

        return (hash.toString());
    }

    public static String buildPasswordHash(String password) {
        String saltedPassword = password+SALT;
        String hashedPassword = getHash(saltedPassword);
        return hashedPassword;
    }
}
