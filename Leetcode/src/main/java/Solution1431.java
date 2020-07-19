import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Solution1431 {
    public List<Boolean> kidsWithCandiesv2(int[] candies, int extraCandies) {
        int maxCandies = Arrays.stream(candies).max().getAsInt();
        List<Boolean> booleanList = Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= maxCandies)
                .collect(Collectors.toList());

        return booleanList;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = -1;
        for (int i : candies) {
            if (i > maxCandies) {
                maxCandies = i;
            }
        }

        List<Boolean> booleanList = new ArrayList<>();
        for (int candy : candies) {
            Boolean aBoolean = candy + extraCandies >= maxCandies || candy == maxCandies;
            booleanList.add(aBoolean);
        }

        return booleanList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1431().kidsWithCandies(new int[]{4,2,1,1,2}, 1));
    }
}
