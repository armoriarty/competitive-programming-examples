// Robin Moriarty
// Have not tried compiling probably doesn't work
// I believe I have solve most of this except for find ing the intersection points for the height
// and the polygon edges
import java.io.*;
import java.util.*;

public class prob12 {

    private static Scanner in;
    private static PrintWriter out;
    private static double[] points;
    private static double correctVolume;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob12.in"));
        out = new PrintWriter ("prob12.out");
        int count = 1;

        while(in.hasNext()){

            int count = in.nextInt();
            double breath = in.nextDouble();
            double water = in.nextDouble();
            correctVolume = (polArea * breath) / 1000;

            buildPointsArray();

            double upperBound = areaHeight();
            double lowerBound = areaDepth();

            double polArea = findArea()

            double height = binarySearchHeight((upperBound - lowerBound) / 2, upperBound, lowerBound);

            printf("Case %d: %.4f", count , height);
            count++;
        }

        //Search for height
        


        in.close ();
        out.close ();
    }

    public static void buildPointsArray(int counter){

        points = new double[counter * 2];

        while(counter > 0){
            counter--;
            points[counter * 2] = in.nextDouble();
            points[(counter * 2) + 1] = in.nextDouble();
        }
    }

    public static double areaHeight(){
        int currentBest = points[0];
        for(int i = 0; i < points.length - 1; i+=2){
            if(points[i] > currentBest){
                currentBest = points[i];
            }
        }
        return currentBest;
    }
    public static double areaDepth(){
        int currentBest = points[0];
        for(int i = 0; i < points.length - 1; i+=2){
            if(points[i] < currentBest){
                currentBest = points[i];
            }
        }
        return currentBest;
    }

    public static double findModifiedArea(int height){
        for(int i = 0; i < points.length - 1; i+=2){
            if(points[i] > height && notHitYet){
                // add two custom points by finding the intersectiosn of height and the two edges.
                // calc area for the first point and the last point
                // calc area for the first added point and my second added point
                //
                // Move through points until I rejoin the polygon on the other side
                while(points[i] > height) i += 2;
                // calc area for the second point and the next point handling the case where I am looping to the first point
            }
            area += (points[i] * points[i + 3]) - (points[i + 2]*points[i + 1]); 
        }
        area += (points[0] * points[points.length -  2]) - (points[points.length - 3]*points[ 1]); 
    }

    public static double binarySearchHeight(double currentGuess, double upperBound, double lowerBound){
        if(findModifiedArea(currentGuess) == correctVolume){
            return currentGuess;
        }
        if(findModifiedArea(currentGuess) >= correctVolume){
            upperBound = currentGuess;
            currentGuess = (upperBound - lowerBound )/ 2;
            return binarySearchHeight(currentGuess, upperBound, lowerBound);
        }
        if(findModifiedArea(currentGuess) <= correctVolume){
            lowerBound = currentGuess;
            currentGuess = (upperBound - lowerBound )/ 2;
            return binarySearchHeight(currentGuess, upperBound, lowerBound);
        }
    }
}
