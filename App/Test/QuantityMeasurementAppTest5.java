package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    public void testConversion_FeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    public void testConversion_YardsToFeet() {
        assertEquals(9.0,
                QuantityMeasurementApp.convert(3.0, LengthUnit.YARDS, LengthUnit.FEET),
                EPSILON);
    }

    @Test
    public void testConversion_InchesToYards() {
        assertEquals(1.0,
                QuantityMeasurementApp.convert(36.0, LengthUnit.INCHES, LengthUnit.YARDS),
                EPSILON);
    }

    @Test
    public void testConversion_CmToInches() {
        assertEquals(1.0,
                QuantityMeasurementApp.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES),
                1e-4);
    }

    @Test
    public void testConversion_Zero() {
        assertEquals(0.0,
                QuantityMeasurementApp.convert(0.0, LengthUnit.FEET, LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    public void testConversion_Negative() {
        assertEquals(-12.0,
                QuantityMeasurementApp.convert(-1.0, LengthUnit.FEET, LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    public void testConversion_RoundTrip() {
        double original = 5.0;

        double converted = QuantityMeasurementApp.convert(original, LengthUnit.FEET, LengthUnit.INCHES);
        double back = QuantityMeasurementApp.convert(converted, LengthUnit.INCHES, LengthUnit.FEET);

        assertEquals(original, back, EPSILON);
    }

    @Test
    public void testConversion_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(1.0, null, LengthUnit.FEET);
        });
    }

    @Test
    public void testConversion_NaN() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES);
        });
    }
}