package biblioteca.security;

import org.mindrot.jbcrypt.BCrypt;

public class CriptografarPwd {

    public String crypt(String passwd){
        String salt = BCrypt.gensalt();

        String hashPasswd = BCrypt.hashpw(passwd, salt);

        return hashPasswd;
    }

    public boolean validHashPasswd(String hash, String passwd){
        return BCrypt.checkpw(hash, passwd);
    }
    
}
