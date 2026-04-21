package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        assertTrue(new Quantity(1.0, LengthUnit.FEET)
                .equals(new Quantity(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        assertTrue(new Quantity(1.0, LengthUnit.INCHES)
                .equals(new Quantity(1.0, LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        assertTrue(new Quantity(1.0, LengthUnit.FEET)
                .equals(new Quantity(12.0, LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        assertTrue(new Quantity(12.0, LengthUnit.INCHES)
                .equals(new Quantity(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        assertFalse(new Quantity(1.0, LengthUnit.FEET)
                .equals(new Quantity(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        assertFalse(new Quantity(1.0, LengthUnit.INCHES)
                .equals(new Quantity(2.0, LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_NullComparison() {
        assertFalse(new Quantity(1.0, LengthUnit.FEET).equals(null));
    }

    @Test
    public void testEquality_SameReference() {
        Quantity q = new Quantity(1.0, LengthUnit.FEET);
        assertTrue(q.equals(q));
    }

    @Test
    public void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity(1.0, null);
        });
    }
}