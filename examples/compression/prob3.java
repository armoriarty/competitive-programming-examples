/**
 * techdevguide.withgoogle.com/paths/advanced/compress-decompression/#!
 *
 * Former google interview question.
 *
 */
import java.io.*;
import java.util.*;

public class prob3 {

    private static Scanner in;
    private static PrintWriter out;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob3.in"));
        out = new PrintWriter ("prob3.out");

        while(in.hasNext()){
            String aLine = in.nextLine();
            String actualData = decompress(aLine);
            out.println(actualData);
        }

        in.close ();
        out.close ();
    }

    public static String decompress(String aLine){
        if(aLine.length() == 0){
            return "";
        }
        if(aLine.charAt(0) >= '0' && aLine.charAt(0) <= '9'){
            int offset = 0;
            while(aLine.charAt(0) >= '0' && aLine.charAt(0) <= '9'){
                offset++;
            }
            int intSize = new Integer(aLine.substring(0, offset + 1));
            String repeatingString = getRepeatingString(aLine, offset);
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < intSize; i++){
                result.append(repeatingString);
            }
            return repeatingString + decompress(aLine.substring(offset + repeatingString.length() + 1));
        }
        return aLine.substring(0, 1) + decompress(aLine.substring(1));
    }

    public static String getRepeatingString(String characters, int offset){
        assert(characters.charAt(offset) == '[');
        int endOfString = offset + 1;
        while(characters.charAt(endOfString) != ']'){
            endOfString++;
        }
        return characters.substring(offset + 1, endOfString + 1);
    }
}
