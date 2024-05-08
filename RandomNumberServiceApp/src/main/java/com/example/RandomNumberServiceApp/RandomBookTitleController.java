package com.example.RandomNumberServiceApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class RandomBookTitleController {
// port number 9095
    private final List<String> bookTitles = Arrays.asList(
            "To Kill a Mockingbird",
            "The Great Gatsby",
            "1984",
            "The Catcher in the Rye",
            "Pride and Prejudice",
            "The Hobbit",
            "The Lord of the Rings",
            "Harry Potter and the Sorcerer's Stone",
            "Moby Dick",
            "The Grapes of Wrath"
    );

    @GetMapping("/randomBookTitle")
    public String getRandomBookTitle() {
        Random random = new Random();
        int index = random.nextInt(bookTitles.size());
        return bookTitles.get(index);
    }
}