package com.bessapps.datastructures.arraylists;

import java.util.ArrayList;
import java.util.List;

public class StudentScoreProblem {
    public static void main(String args[]) {
        List<Integer> player_id = List.of(57, 92, 19, 28, 70, 52, 48, 62, 72, 95, 86, 58, 60, 10, 98, 30, 87, 4, 100, 41, 5, 79, 65, 2, 31, 96, 14, 71, 91, 21, 3, 27, 35, 38, 9, 64, 59, 47, 90, 11, 34, 53, 80, 33, 15, 55, 12, 97, 8, 16, 37, 51, 61, 75, 17, 50, 56, 73, 88, 78, 20, 89, 25, 69, 82, 6, 40, 45, 74, 46, 24, 32, 67, 1, 93, 22, 36, 44, 77, 42, 99, 76, 26, 84, 39, 49, 85, 81, 13, 94, 29, 54, 63, 68, 23, 43, 7, 18, 83, 66);

        List<Integer> player_scores = List.of(255973, 326890, 399265, 612599, 86839, 643248, -989677, -651115, -675891, 73521, 783582, 839610, -322297, 981306, -575396, -177516, -295723, -884999, -135836, -395591, 921359, 890819, 252244, -23601, -347525, 96941, 834756, 825342, -765044, -512531, -497194, 849103, 749482, -514919, -987941, 860894, 168681, 423176, -701566, -560958, 821690, 280999, 402346, -894708, 322148, 550602, -62855, 799518, -45307, 803707, 541569, -320954, 156743, -638534, 890617, -764134, 930389, -760143, -287151, -886602, -987695, 268141, -283176, -97988, 873059, -102802, -83350, -966273, 19386, -613419, -18965, 434348, 492847, -913455, -1869, -583971, 18381, -79559, -534374, 163391, 123593, -583916, 196081, 83208, -973103, 301450, -677991, 715727, -873992, 538078, -502157, 216061, 322704, -317333, -242738, -283259, 256465, -95657, -410238, -308645);

        List<Integer> queries = List.of(101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120);

        List<Integer> result = solution(player_id, player_scores,queries);
        System.out.println(result.toString());
    }

    public static List<Integer> solution(List<Integer> player_ids, List<Integer> player_scores, List<Integer> queries) {

//        System.out.println(player_ids.toString());
//        System.out.println(player_scores.toString());
//        System.out.println(queries.toString());

        // TODO: implement your solution here
        List<Integer> resultList = new ArrayList<>();
        for(int x: queries) {
            if(player_ids.contains(x)) {
                int index = player_ids.indexOf(x);
                Integer a = player_scores.get(index);
                System.out.println(a);
                resultList.add(a);
            }
        }
        return resultList;
    }
}