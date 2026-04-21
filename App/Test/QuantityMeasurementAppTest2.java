package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest2 {

    // -------- Feet Tests --------

    @Test
    public void testFeetEquality_SameValue() {
        assertTrue(new Feet(1.0).equals(new Feet(1.0)));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        assertFalse(new Feet(1.0).equals(new Feet(2.0)));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        assertFalse(new Feet(1.0).equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        assertFalse(new Feet(1.0).equals(new Inches(1.0)));
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet f = new Feet(1.0);
        assertTrue(f.equals(f));
    }

    // -------- Inches Tests --------

    @Test
    public void testInchesEquality_SameValue() {
        assertTrue(new Inches(1.0).equals(new Inches(1.0)));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        assertFalse(new Inches(1.0).equals(new Inches(2.0)));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        assertFalse(new Inches(1.0).equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        assertFalse(new Inches(1.0).equals(new Feet(1.0)));
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches i = new Inches(1.0);
        assertTrue(i.equals(i));
    }
}