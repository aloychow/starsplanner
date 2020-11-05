package stars;
import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class LoginController {
    private static final String SALT= "STARWARS";
    public boolean validateLogin(String userName, String enteredPassword, String typeOfUser)
    {   if(userName!=null && enteredPassword!=null)
        {
        String hashedPassword = generateHashedPassword(enteredPassword);
        //now need to use FileController to verify the username and the password
            return true;
        }
        else
        {
        return false;
        }

    }
    private static String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256"); // use SHA-256 Algorithm
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
            for (int idx = 0; idx < hashedBytes.length; idx++) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            // failed to generate hash
        }

        return hash.toString();
    }

    /**
     * Turns plain password into hashed password.
     *
     * @param password
     *            plain password.
     * @return hashed password.
     */
    public static String generateHashedPassword(String password) {
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);
        return hashedPassword;
    }
}
