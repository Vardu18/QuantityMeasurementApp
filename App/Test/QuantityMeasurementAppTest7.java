package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class UC7Test {

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        Quantity result = new Quantity(1.0, LengthUnit.FEET)
                .add(new Quantity(12.0, LengthUnit.INCHES), LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        Quantity result = new Quantity(1.0, LengthUnit.FEET)
                .add(new Quantity(12.0, LengthUnit.INCHES), LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        Quantity result = new Quantity(1.0, LengthUnit.FEET)
                .add(new Quantity(12.0, LengthUnit.INCHES), LengthUnit.YARDS);

        assertEquals(0.6667, result.getValue(), 0.001);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        Quantity result = new Quantity(1.0, LengthUnit.INCHES)
                .add(new Quantity(1.0, LengthUnit.INCHES), LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_Commutativity() {
        Quantity a = new Quantity(1.0, LengthUnit.FEET);
        Quantity b = new Quantity(12.0, LengthUnit.INCHES);

        Quantity r1 = a.add(b, LengthUnit.YARDS);
        Quantity r2 = b.add(a, LengthUnit.YARDS);

        assertEquals(r1.getValue(), r2.getValue(), 0.0001);
    }

    @Test
    public void testAddition_WithZero() {
        Quantity result = new Quantity(5.0, LengthUnit.FEET)
                .add(new Quantity(0.0, LengthUnit.INCHES), LengthUnit.YARDS);

        assertEquals(1.6667, result.getValue(), 0.001);
    }

    @Test
    public void testAddition_NegativeValues() {
        Quantity result = new Quantity(5.0, LengthUnit.FEET)
                .add(new Quantity(-2.0, LengthUnit.FEET), LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_NullTargetUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity(1.0, LengthUnit.FEET)
                    .add(new Quantity(12.0, LengthUnit.INCHES), null);
        });
    }

    @Test
    public void testAddition_NullOperand() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity(1.0, LengthUnit.FEET).add(null, LengthUnit.FEET);
        });
    }
}