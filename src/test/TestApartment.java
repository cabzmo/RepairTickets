package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Apartment;

public class TestApartment {

    Apartment apartment;

    @Before
    public void setUp() {
        apartment = new Apartment(1, "5b", 1);
    }

    @Test
    public void testGetID() {
        assertEquals(1, apartment.getID());
    }

    @Test
    public void testSetID() {
        apartment.setID(2);
        assertEquals(2, apartment.getID());
    }

    @Test
    public void testGetName() {
        assertEquals("5b", apartment.getName());
    }

    @Test
    public void testSetName() {
        apartment.setName("6");
        assertEquals("6", apartment.getName());
    }

    @Test
    public void testGetFloorID() {
        assertEquals(1, apartment.getFloorID());
    }

    @Test
    public void testSetFloorID() {
        apartment.setFloorID(2);
        assertEquals(2, apartment.getFloorID());
    }
}
