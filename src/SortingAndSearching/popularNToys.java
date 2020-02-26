package SortingAndSearching;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class popularNToys
{
    public static void main(String[] args) {
        System.out.println(topToys(6, 2,
                new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"}, 6,
                new String[]{
                        "Elmo is hottest toy of the season! Elmo will be every kid's wishlist!",
                        "The new Elmo dolls are super high quality.",
                        "Expect the Elsa dolls to be very popular this year",
                        "Elsa and Elmo are the toys I'll be buying for my kids",
                        "For parents of older kids, look into buying them a drone",
                        "Warcraft is slowly rising in popularity agead of the holiday season"
                }));
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

    public static List<String> topToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes){
        Map<String, int[]> freq = new HashMap<>();
        for (String toy : toys ){
            freq.put(toy, new int[]{0, 0});
        }
        for(String quote : quotes) {
            Set<String> used = new HashSet<>();
            String[] words = quote.toLowerCase().split("\\W+");
            for(String word : words) {
                if(!freq.containsKey(word)){
                    continue;
                }
                int[] nums = freq.get(word);
                nums[0]++;
                if (!used.contains(word)){
                    nums[1]++;
                }
                used.add(word);
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) -> {
            if(freq.get (t1)[0] != freq.get(t2)[0]){
                return freq.get (t1)[0] - freq.get(t2)[0];
            }
            if(freq.get (t1)[1] != freq.get(t2)[1]){
                return freq.get(t1)[1] - freq.get(t2)[1];
            }
            return t2.compareTo(t1);
        });
        if(topToys > numToys){
            for (String toy : freq.keySet()){
                if(freq.get(toy)[0] > 0){
                    pq.add(toy);
                }
            }
        } else {
            for (String toy : toys){
                pq.add(toy);
                if(pq.size() > topToys){
                    pq.poll();
                }
            }
        }
        List<String> output = new ArrayList<>();
        while (!pq.isEmpty()){
            output.add(pq.poll());
        }
        Collections.reverse(output);
        return output;
    }
    // METHOD SIGNATURE ENDS
}