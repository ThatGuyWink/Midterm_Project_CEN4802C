package com.cen3024c.app;

/**
 * The ListItem class represents a single to-do list item.
 */

public class ListItem {
    private String description;

    /**
     * Constructs a new ListItem with the specified description.
     *
     * @param description The description of the to-do list item.
     */

    public ListItem(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the to-do list item.
     *
     * @return The description of the item.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Returns the string representation of the list item.
     *
     * @return The description of the item as a string.
     */

    @Override
    public String toString() {
        return description;
    }
}
