import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Create an array of Car objects
        Car[] cars = new Car[10];
        // Initialize Car objects with make, model, and year
        cars[0] = new Car("Toyota", "Corolla", 2022);
        cars[1] = new Car("Honda", "Civic", 2019);
        cars[2] = new Car("Ford", "Mustang", 2015);
        cars[3] = new Car("Chevrolet", "Camaro", 2017);
        cars[4] = new Car("BMW", "X5", 2020);
        cars[5] = new Car("Audi", "A4", 2018);
        cars[6] = new Car("Mercedes-Benz", "E-Class", 2016);
        cars[7] = new Car("Volkswagen", "Golf", 2014);
        cars[8] = new Car("Hyundai", "Elantra", 2013);
        cars[9] = new Car("Kia", "Sorento", 2021);

        // Sort the array of cars
        Quick.sort(cars);

        // Print the sorted cars
        for (Car car : cars) {
            System.out.println(car);
        }

        // Load integers from a file
        String fileName = "src\\input.txt";
        int arraySize = 10;

        // Load integers from file
        List<Integer> integersFromFile = loadIntegersFromFile(fileName);
        if (integersFromFile != null) {
            System.out.println("Integers loaded from file: " + integersFromFile);
        } else {
            System.out.println("Failed to load ");
        }

        // Write integers to file
        if (integersFromFile != null) {
            writeIntegersToFile(integersFromFile, fileName);
        } else {
            System.out.println("Failed to write integers to file");
        }

        // Create a random array
        int[] randomArray = createRandomArray(arraySize);
        System.out.print("Random array: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Method to load integers from a file
    public static List<Integer> loadIntegersFromFile(String fileName) {
        List<Integer> integers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    continue; // Skip the first line which contains the size of the array
                }
                integers.add(Integer.parseInt(line.trim()));
            }
            return integers;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        } catch (NumberFormatException e) {
            System.err.println("Invalid integer format: " + e.getMessage());
            return null;
        }
    }

    // Method to write integers to a file
    public static void writeIntegersToFile(List<Integer> integers, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Integer num : integers) {
                writer.write(num.toString());
                writer.newLine();
            }
            System.out.println("Integers written to file successfully");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // Method to create a random array of integers
    public static int[] createRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100) + 1; // Generate random integers between 1 and 100
        }
        return array;
    }

}

