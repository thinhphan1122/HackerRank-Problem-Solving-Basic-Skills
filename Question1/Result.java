package Question1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {

    /*
     * Complete the 'nearlySimilarRectangles' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts 2D_LONG_INTEGER_ARRAY sides as parameter.
     */

    public static long nearlySimilarRectangles(List<List<Long>> sides) {
        // Write your code here

        // long count = 0;
        // for(int i = 0; i < sides.size(); i++) {
        //     for(int j = i + 1; j < sides.size(); j++) {
        //         long a = sides.get(i).get(0);
        //         long b = sides.get(i).get(1);
        //         long c = sides.get(j).get(0);
        //         long d = sides.get(j).get(1);
        //         if (a*d == b*c) {
        //             count++;
        //         }
        //     }
        // }
        // return count;

        // return sides.stream()
        //         .flatMap(a -> sides.stream()
        //                 .skip(sides.indexOf(a) + 1)  // Skip rectangles already compared
        //                 .filter(b -> a.get(0) * b.get(1) == a.get(1) * b.get(0)))  // Check if rectangles are nearly similar
        //         .count();

        Map<Double, Integer> aspectRatioCounts = new HashMap<>();
        long count = 0;
        for (List<Long> side : sides) {
            double aspectRatio = (double) side.get(0) / side.get(1);
            aspectRatioCounts.put(aspectRatio, aspectRatioCounts.getOrDefault(aspectRatio, 0) + 1);
        }
        for (int countValue : aspectRatioCounts.values()) {
            count += (long) countValue * (countValue - 1) / 2;
        }
        return count;
    }
}