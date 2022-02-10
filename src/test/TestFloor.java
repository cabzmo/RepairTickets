package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Floor;

public class TestFloor {

    Floor floor;

    @Before
    public void setUp() {
        floor = new Floor(1, "5", 1);
    }

    @Test
    public void testGetID() {
        assertEquals(1, floor.getID());
    }

    @Test
    public void testSetID() {
        floor.setID(2);
        assertEquals(2, floor.getID());
    }

    @Test
    public void testGetName() {
        assertEquals("5", floor.getName());
    }

    @Test
    public void testSetName() {
        floor.setName("6");
        assertEquals("6", floor.getName());
    }

    @Test
    public void testGetTowerID() {
        assertEquals(1, floor.getTowerID());
    }

    @Test
    public void testSetTowerID() {
        floor.setTowerID(2);
        assertEquals(2, floor.getTowerID());
    }
}
