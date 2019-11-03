//Robin Moriarty
import java.io.*;
import java.util.*;

public class prob9 {
    private static Scanner in;
    private static PrintWriter out;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob9.in"));
        out = new PrintWriter ("prob9.out");

        while(true){
            int treeA = in.nextInt();
            int treeB = in.nextInt();
            if(treeA == 0 && treeB == 0){
                break;
            }

            int heightA = treeA * 3;
            int heightB = treeB * 3;
            int maxHeight = ((heightA > heightB) ? heightA : heightB);

            int widthA = (treeA * 4) - 1;
            int widthB = (treeB * 4) - 1;


            int currentWidth = 1;
            for(int i = 1; i <= maxHeight; i++){
                if(i > heightA){
                    out.print(makeRepeatedString(' ', widthA));
                }else if (i > treeA * 2){
                    if(i > heightB){
                        out.print(makeStem2(widthA));
                    } else {
                        out.print(makeStem(widthA));
                    }
                } else {
                    out.print(makeRepeatedString(' ', (widthA / 2) - (currentWidth / 2)));
                    out.print(makeRepeatedString('*', currentWidth));
                    if(!(i > heightB)){
                        out.print(makeRepeatedString(' ', (widthA / 2) - (currentWidth / 2)));
                    } 
                }
                if(i > heightB){
                    //out.print(makeRepeatedString(' ', widthB));
                }else if( i > treeB * 2){
                    out.print(" ");
                    out.print(makeStem2(widthB));
                } else {
                    out.print(" ");
                    out.print(makeRepeatedString(' ', (widthB / 2) - (currentWidth / 2)));
                    out.print(makeRepeatedString('*', currentWidth));
                    //out.print(makeRepeatedString(' ', (widthB / 2) - (currentWidth / 2)));
                }
                out.println();
                currentWidth += 2;
            }
            out.println();
        }

        in.close ();
        out.close ();
    }

    public static String makeRepeatedString(char aChar, int length){
        String result = "";
        for(int i = 0; i < length; i++){
            result += aChar;
        }
        return result;
    }

    public static String makeStem(int aWidth){
        String result = "";
        for(int i = 0; i < aWidth / 2; i++){
            result += " ";
        }
        result += "*";
        for(int i = 0; i < aWidth / 2; i++){
            result += " ";
        }
        return result;
    }
    public static String makeStem2(int aWidth){
        String result = "";
        for(int i = 0; i < aWidth / 2; i++){
            result += " ";
        }
        result += "*";
        return result;
    }



}
