package biblioteca.security;

import org.mindrot.jbcrypt.BCrypt;

public class CriptografarPwd {

    public static String crypt(String passwd){
        String salt = BCrypt.gensalt();

        String hashPasswd = BCrypt.hashpw(passwd, salt);

        return hashPasswd;
    }

    public static boolean validHashPasswd(String hash, String passwd){
        return BCrypt.checkpw(passwd, hash);
    }
    
}
