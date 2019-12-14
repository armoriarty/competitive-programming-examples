import java.io.*;
import java.util.*;

public class prob3 {

    private static Scanner in;
    private static PrintWriter out;

    private static class Stuff{
        public int cost;
        public String candidate;
        public Stuff(int aCost, String aCandidate){
            cost = aCost;
            candidate = aCandidate;
        }
    }

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob3.in"));
        out = new PrintWriter ("prob3.out");
        int count = 1;

        while(in.hasNext()){
            String current = in.nextLine();
            Stuff result = process(current);
            if(result == null){
                out.print("Failed Case\r\r");
                continue;
            }
            out.printf("Case %d: sequence %s, cost = %d, length = %d\r\n", count, result.candidate, result.cost, result.candidate.length());
            count++;
        }

        in.close ();
        out.close ();
    }

    public static Stuff process(String aString){
        Set<String> alphabet = new HashSet<>();
        for(int i = 0; i < aString.length(); i++){
            alphabet.add(aString.substring(i, i + 1));
        }

        Set<String> visitedStrings = new HashSet<>();
        LinkedList<Stuff> queue = new LinkedList<>();
        queue.add(new Stuff(0, aString));
        while(!(queue.isEmpty())){
            Stuff current = queue.remove();
            int cost = current.cost;
            String candidate = current.candidate;

            if(isPalandrome(candidate)){
                return current;
            }

            if(visitedStrings.contains(candidate)){
                continue;
            }
            visitedStrings.add(candidate);

            int newCost = cost + 1;
            
            queue.add(new Stuff(newCost, aString.substring(1, aString.length())));
            queue.add(new Stuff(newCost, aString.substring(0, aString.length() - 1)));
        }
        return null;
    }
    
    private static boolean isPalandrome(String aString){
        for(int i = 0; i <= (aString.length() / 2); i++){
            if(aString.charAt(i) != aString.charAt(aString.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
