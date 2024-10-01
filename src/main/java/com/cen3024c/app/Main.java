package com.cen3024c.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class is the entry point of the ToDo List application.
 * It provides a console-based interface for managing a persistent to-do list.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ToDoList toDoList = new ToDoList();
    private static String desktopPath = System.getProperty("user.home") + "/Desktop/";
    private static String fileName = "ToDoList.txt";
    private static File toDoFile = new File(desktopPath + fileName);

    /**
     * The main method starts the application, loading the to-do list from a file
     * and providing a menu for the user to interact with the list.
     *
     * @param args Command-line arguments (not used).
     */

    public static void main(String[] args) {
        // Load the existing to-do list from the file if it exists
        loadFromFile();

        boolean running = true;
        while (running) {
            printListMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    viewItems();
                    break;
                case 4:
                    saveToFile(); // Save to the file before exiting
                    running = false;
                    System.out.println("Closing program. Your to-do list has been saved.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Displays the menu options for the to-do list actions.
     */

    private static void printListMenu() {
        System.out.println("\n--- To Do List ---");
        System.out.println("1. Add an Item");
        System.out.println("2. Delete an Item");
        System.out.println("3. View List");
        System.out.println("4. Exit Program");
        System.out.println("Please select an option: ");
    }

    /**
     * Adds a new item to the to-do list by prompting the user for input.
     */

    private static void addItem() {
        System.out.println("Please enter the description of the list item: ");
        String description = scanner.nextLine();
        toDoList.addItem(description);
        System.out.println("Item added successfully.");
        saveToFile(); // Save immediately after adding an item
    }

    /**
     * Deletes an item from the to-do list based on the user's input.
     * The user is prompted to enter the item ID.
     */

    private static void deleteItem() {
        viewItems();
        System.out.println("Enter the item ID you want to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (toDoList.deleteItem(index)) {
            System.out.println("Item deleted successfully.");
            saveToFile(); // Save immediately after deleting an item
        } else {
            System.out.println("Item not found.");
        }
    }

    /**
     * Displays all items in the to-do list to the user.
     * If no items exist, a message indicating no items are found is displayed.
     */

    private static void viewItems() {
        List<ListItem> items = toDoList.getItems();

        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.println("To do list items: ");
            for (int i = 0; i < items.size(); i++) {
                System.out.println(i + ": " + items.get(i));
            }
        }
    }

    /**
     * Loads the to-do list from a file on the user's desktop.
     */

    private static void loadFromFile() {
        if (toDoFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(toDoFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    toDoList.addItem(line); // Add each line as a new to-do item
                }
                System.out.println("To-do list loaded from file.");
            } catch (IOException e) {
                System.out.println("An error occurred while loading the to-do list.");
                e.printStackTrace();
            }
        } else {
            System.out.println("No existing to-do list found. A new list will be created.");
        }
    }

    /**
     * Saves the current to-do list items to a file on the user's desktop.
     */

    private static void saveToFile() {
        try (FileWriter writer = new FileWriter(toDoFile)) {
            List<ListItem> items = toDoList.getItems();
            if (items.isEmpty()) {
                writer.write("No items found.");
            } else {
                for (ListItem item : items) {
                    writer.write(item.toString() + "\n");
                }
            }
            System.out.println("To-do list saved to " + toDoFile.getPath());
        } catch (IOException e) {
            System.out.println("An error occurred while saving the to-do list.");
            e.printStackTrace();
        }
    }
}
