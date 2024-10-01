package com.cen4802c.app;

import com.cen3024c.app.ListItem;
import com.cen3024c.app.ToDoList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class ToDoListTest {

    private ToDoList toDoList;

    @Before
    public void setUp() {
        toDoList = new ToDoList();
    }

    @Test
    public void testAddItem() {
        toDoList.addItem("New Task");
        List<ListItem> items = toDoList.getItems();
        assertEquals(1, items.size());
        assertEquals("New Task", items.get(0).getDescription());
    }

    @Test
    public void testDeleteItem() {
        toDoList.addItem("Task 1");
        boolean deleted = toDoList.deleteItem(0);
        assertTrue(deleted);
        assertEquals(0, toDoList.getItems().size());
    }
}
