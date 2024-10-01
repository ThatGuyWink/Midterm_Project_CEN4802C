package com.cen3024c.app;

import java.util.ArrayList;
import java.util.List;

/**
 * The ToDoList class manages a list of to-do items.
 */

public class ToDoList {
    private List<ListItem> items;

    /**
     * Constructs a new ToDoList instance with an empty list of items.
     */

    public ToDoList() {
        items = new ArrayList<>();
    }

    /**
     * Adds a new item to the to-do list.
     *
     * @param description The description of the to-do item.
     */

    public void addItem(String description) {
        items.add(new ListItem(description));
    }

    /**
     * Deletes an item from the to-do list by its index.
     *
     * @param index The index of the item to be deleted.
     * @return true if the item was successfully deleted, false otherwise.
     */

    public boolean deleteItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    /**
     * Returns the list of to-do items.
     *
     * @return A list of to-do items.
     */

    public List<ListItem> getItems() {
        return new ArrayList<>(items);
    }
}

