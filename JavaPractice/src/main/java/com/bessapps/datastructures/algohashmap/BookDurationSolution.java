package com.bessapps.datastructures.algohashmap;
import java.util.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.stream.Collectors;

public class BookDurationSolution {

    // Example usage
    public static void main(String[] args) {
        //String logs = "1 solve 09:00 50, 2 solve 10:00 60, 1 fail 11:00, 3 solve 13:00 40, 2 fail 14:00, 3 solve 15:00 70";
        String logs = "1 borrow 09:00, 2 borrow 10:00, 1 return 12:20, 3 borrow 13:00, 2 return 15:00, 3 return 16:00";
        List<String> result = solution(logs);

        for (String entry : result) {
            System.out.println(entry);
        }
    }

    public static List<String> solution(String logs) {

        System.out.println("####: " + logs);
        Map<Integer, Book> bookMap = new HashMap<>();
        String[] entries = logs.split(", ");

        for (String entry : entries) {
            String[] parts = entry.split(" ");
            int bookId = Integer.parseInt(parts[0]);
            String action = parts[1];
            LocalTime time = LocalTime.parse(parts[2]);

            Book book = bookMap.computeIfAbsent(bookId, Book::new);

            if (action.equals("borrow")) {
                book.lastBorrowTime = time;
            } else if (action.equals("return")) {
                Duration borrowed = Duration.between(book.lastBorrowTime, time);
                book.totalDuration = book.totalDuration.plus(borrowed);
                book.lastBorrowTime = null; // clear borrow time
            }
        }

        // Find max duration
        Duration maxDuration = bookMap.values().stream()
                .map(book -> book.totalDuration)
                .max(Comparator.naturalOrder())
                .orElse(Duration.ZERO);

        // Collect books with max duration
        return bookMap.values().stream()
                .filter(book -> book.totalDuration.equals(maxDuration))
                .sorted(Comparator.comparingInt(book -> book.id))
                .map(book -> {
                    long hours = book.totalDuration.toHours();
                    long minutes = book.totalDuration.toMinutes() % 60;
                    String durationStr = String.format("%02d:%02d", hours, minutes);
                    return book.id + " " + durationStr;
                })
                .collect(Collectors.toList());
    }
}

class Book {
    int id;
    Duration totalDuration = Duration.ZERO;
    LocalTime lastBorrowTime;

    public Book(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " " + totalDuration;
    }
}