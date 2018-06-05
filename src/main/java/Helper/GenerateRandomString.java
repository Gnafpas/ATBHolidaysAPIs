package Helper;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by George on 23/05/2018.
 */
public class GenerateRandomString {

    static final private String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    final static private Random rng = new SecureRandom();

    static char randomChar(){
        return ALPHABET.charAt(rng.nextInt(ALPHABET.length()));
    }

    public static String randomUUID(int length, int spacing, char spacerChar){
        StringBuilder sb = new StringBuilder();
        int spacer = 0;
        while(length > 0){
            if(spacer == spacing){
                sb.append(spacerChar);
                spacer = 0;
            }
            length--;
            spacer++;
            sb.append(randomChar());
        }
        return sb.toString();
    }
}
