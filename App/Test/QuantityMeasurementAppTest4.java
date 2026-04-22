package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToFeet() {
        assertTrue(new Quantity(1.0, LengthUnit.YARDS)
                .equals(new Quantity(3.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_YardToInches() {
        assertTrue(new Quantity(1.0, LengthUnit.YARDS)
                .equals(new Quantity(36.0, LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_CmToInches() {
        assertTrue(new Quantity(1.0, LengthUnit.CENTIMETERS)
                .equals(new Quantity(0.393701, LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_CmToFeet_NotEqual() {
        assertFalse(new Quantity(1.0, LengthUnit.CENTIMETERS)
                .equals(new Quantity(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_TransitiveProperty() {

        Quantity yard = new Quantity(1.0, LengthUnit.YARDS);
        Quantity feet = new Quantity(3.0, LengthUnit.FEET);
        Quantity inches = new Quantity(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    @Test
    public void testEquality_SameReference() {
        Quantity q = new Quantity(2.0, LengthUnit.YARDS);
        assertTrue(q.equals(q));
    }

    @Test
    public void testEquality_NullComparison() {
        assertFalse(new Quantity(1.0, LengthUnit.YARDS).equals(null));
    }

    @Test
    public void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity(1.0, null);
        });
    }
}