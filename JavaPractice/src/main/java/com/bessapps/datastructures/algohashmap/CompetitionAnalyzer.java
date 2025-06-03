package com.bessapps.datastructures.algohashmap;

import java.util.*;
import java.util.stream.Collectors;

public class CompetitionAnalyzer {

    static class Student {
        int id;
        int score = 0;
        int solves = 0;
        int fails = 0;

        public Student(int id) {
            this.id = id;
        }
    }

    public static List<int[]> analyzeCompetition(String logs) {
        String[] entries = logs.split(", ");
        Map<Integer, Student> studentMap = new HashMap<>();

        for (String entry : entries) {
            String[] parts = entry.split(" ");
            int studentId = Integer.parseInt(parts[0]);
            String action = parts[1];

            Student student = studentMap.computeIfAbsent(studentId, Student::new);

            if (action.equals("solve")) {
                int difficulty = Integer.parseInt(parts[3]);
                student.score += difficulty;
                student.solves++;
            } else if (action.equals("fail")) {
                student.fails++;
            }
        }

        // Filter out students who never solved a problem
        return studentMap.values().stream()
                .filter(s -> s.solves > 0)
                .sorted(Comparator.comparingInt((Student s) -> s.score).reversed())
                .map(s -> new int[]{s.id, s.score, s.solves, s.fails})
                .collect(Collectors.toList());
    }

    // Example usage
    public static void main(String[] args) {
        //String logs = "1 solve 09:00 50, 2 solve 10:00 60, 1 fail 11:00, 3 solve 13:00 40, 2 fail 14:00, 3 solve 15:00 70";
        String logs = "1 fail 09:00, 1 solve 10:00 50, 2 solve 11:00 60, 3 solve 12:00 70, 2 fail 13:00, 3 fail 14:00";
        List<int[]> result = analyzeCompetition(logs);

        for (int[] entry : result) {
            System.out.println(Arrays.toString(entry));
        }
    }
}


/*
This is working code below:

package com.app;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public List<int[]> analyzeCompetition(String logs) {
        List<String> t1List = Arrays.asList(logs.split(", "));
        Map<Integer, Student> studentMap = new HashMap<>();
        for(String x: t1List) {
            String[] arr = x.split(" ");
            Student student = studentMap.computeIfAbsent(Integer.parseInt(arr[0].trim()), Student::new);
            if(arr[1].equals("solve")) {
                student.score += Integer.parseInt(arr[3]);
                student.solveCount++;
            } else {
                student.failCount++;
            }
        }

        List<int[]> resultList = new ArrayList<>();

        studentMap.forEach((k, v) -> {
            resultList.add(new int[] {v.id, v.score, v.solveCount, v.failCount});
        });

        resultList.sort((a, b) -> Integer.compare(b[1], a[1]));
        return resultList;
    }
}

class Student {
    int id;
    int score;
    int solveCount;
    int failCount;

    public Student(int id) {
        this.id = id;
    }

}
 */