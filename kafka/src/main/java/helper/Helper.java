package helper;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by nim_13512065 on 5/31/16.
 */
public class Helper {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBER = "0123456789";
    private static SecureRandom rnd = new SecureRandom();
    private static Random random = new Random();
    public static String randomStringFixedLength(int len) {
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public static int randomIntegerWithLimit(int limit) {
        return rnd.nextInt(limit);
    }

    public static String randomNumberFixedLength(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; ++i) {
            sb.append(NUMBER.charAt(rnd.nextInt(NUMBER.length())));
        }
        return sb.toString();
    }

    public static int randomIntegerWithRange(int min, int max) {
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
