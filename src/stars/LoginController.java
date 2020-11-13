package stars;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class LoginController {
    private static final String SALT= "STARWARS";

    public boolean validateLogin(String userName, String enteredPassword, String typeOfUser)
    {   FileController fc=new FileController();
        if(userName!=null && enteredPassword!=null&& (typeOfUser=="Student" || typeOfUser=="Admin") )
        {
        String hashedPassword = buildPasswordHash(enteredPassword);
            if(typeOfUser=="Student")
            {
                for(int i=0;i<fc.getStudentList().size();i++)
                {
                    if((fc.getStudentList().get(i).getUserName()==userName)&&(fc.getStudentList().get(i).getPassword()==hashedPassword))
                    return true;
                }
            }
           else if(typeOfUser=="Admin")
            {
                for(int i=0;i<fc.getAdminList().size();i++)
                {
                    if((fc.getAdminList().get(i).getUserName()==userName)&&(fc.getStudentList().get(i).getPassword()==hashedPassword))
                        return true;
                }
            }
           else
               return false;
        }

        return false;

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
