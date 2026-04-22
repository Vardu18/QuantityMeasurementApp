package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class UC6Test {

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        Quantity result = new Quantity(1.0, LengthUnit.FEET)
                .add(new Quantity(2.0, LengthUnit.FEET));

        assertEquals(3.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        Quantity result = new Quantity(6.0, LengthUnit.INCHES)
                .add(new Quantity(6.0, LengthUnit.INCHES));

        assertEquals(12.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        Quantity result = new Quantity(1.0, LengthUnit.FEET)
                .add(new Quantity(12.0, LengthUnit.INCHES));

        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        Quantity result = new Quantity(12.0, LengthUnit.INCHES)
                .add(new Quantity(1.0, LengthUnit.FEET));

        assertEquals(24.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_WithZero() {
        Quantity result = new Quantity(5.0, LengthUnit.FEET)
                .add(new Quantity(0.0, LengthUnit.INCHES));

        assertEquals(5.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_NegativeValues() {
        Quantity result = new Quantity(5.0, LengthUnit.FEET)
                .add(new Quantity(-2.0, LengthUnit.FEET));

        assertEquals(3.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_NullSecondOperand() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity(1.0, LengthUnit.FEET).add(null);
        });
    }
}