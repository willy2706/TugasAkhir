package helper;

import java.security.SecureRandom;

/**
 * Created by nim_13512065 on 5/31/16.
 */
public class Helper {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();
    public static String randomStringFixedLength(int len) {
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
    public static int randomNumberWithLimit(int limit) {
        return rnd.nextInt(limit);
    }
}
