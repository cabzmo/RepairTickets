package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import model.Tower;

public class TestTower {

    Tower tower;

    @Before
    public void setUp() {
        tower = new Tower(1, "Rayan");
    }

    @Test
    public void testGetID() {
        assertEquals(1, tower.getID());
    }

    @Test
    public void testSetID() {
        tower.setID(2);
        assertEquals(2, tower.getID());
    }

    @Test
    public void testGetName() {
        assertEquals("Rayan", tower.getName());
    }

    @Test
    public void testSetName() {
        tower.setName("Mina");
        assertEquals("Mina", tower.getName());
    }
}