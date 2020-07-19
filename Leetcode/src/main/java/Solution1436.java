import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> nonDestCities = new HashSet<>();
        Set<String> destCities = new HashSet<>();
        for(List<String> path : paths){
            String pathFrom = path.get(0);
            nonDestCities.add(pathFrom);
            destCities.remove(pathFrom);
            String pathTo = path.get(1);
            if(!nonDestCities.contains(pathTo)){
                destCities.add(pathTo);
            }
        }
        return (String)destCities.toArray()[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1436().destCity(Arrays.asList(Arrays.asList("London","New York")
                , Arrays.asList("Lima","Sao Paulo")
                    , Arrays.asList("New York","Lima"))));
    }
}
