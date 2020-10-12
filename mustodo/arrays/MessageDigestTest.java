package mustodo.arrays;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Base64;

public class MessageDigestTest {

    private static byte[] salt = new byte[16];
    static{
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
            byte[] salt = new byte[16];
            //Get a random salt
            sr.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        //Create array for salt

    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchProviderException {
        String s="Lo52172bLoa81170Pa101103Pa102984Pa102073Pa101442Pr117832Pr100188";

        test(s,salt);
        test(s,salt);
        test(s,salt);
        test(s,salt);
        test(s,salt);
    }

    /*//Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }*/

    private static void test(String s, byte[] salt) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchProviderException {
        byte[] data1 = s.getBytes("UTF-8");

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(salt);
        byte[] digest = messageDigest.digest(data1);

        System.out.println(Base64.getEncoder().encodeToString(digest));
    }



}
