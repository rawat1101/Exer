package org.example.funProg;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

/**
 * This example shows two method implementations that remove a string
 * from a list of strings.  One method uses classic Java 7 features
 * and the other uses basic modern Java features.
 */
@SuppressWarnings("SameParameterValue")
public class ex0 {
    /**
     * The main entry point into this program.
     */
    static public void main(String[] argv) {
        // The array of names.
        String[] nameArray = {"Barbara", "James", "Mary", "John", "Robert", "Michael", "Linda", "james", "mary"};

        // Remove "Robert" from the list created from nameArray.
        List<String> l1 = zap7(List.of(nameArray), "Robert");

        // Remove "Robert" from the list created from nameArray.
        List<String> l2 = zapModern(List.of(nameArray), "Robert");

        // Check to ensure the zap*() methods work.
        if (l1.contains("Robert") || l2.contains("Robert")) System.out.println("Test failed");
        else System.out.println("Test succeeded");
    }

    /**
     * Remove any strings matching {@code omit} from the list of
     * strings using basic Java 7 features.
     */
    static List<String> zap7(List<String> lines, String omit) {
        // Create an ArrayList to return the results.
        List<String> results = new ArrayList<>();

        // Iterate through all the lines in the List.
        for (String line : lines)
            // If 'line' doesn't equal 'omit'
            // add it to the List of results.
            if (!omit.equals(line)) results.add(line);

        // Return the List of results.
        return results;
    }

    /**
     * Remove any strings matching {@code omit} from the list of
     * strings using basic modern Java features.
     */
    static List<String> zapModern(List<String> lines, String omit) {
        return lines
                // Convert the List to a sequential stream.
                .stream()

                // Remove any strings that match omit.
                .filter(not(omit::equals))

                // Trigger intermediate operation processing and return
                // new list of results.
                .collect(toList());
    }
}
