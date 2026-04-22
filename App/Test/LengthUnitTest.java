package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;

public class UC8Test {

    @Test
    public void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0,
                LengthUnit.INCHES.convertToBaseUnit(12.0),
                0.0001);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToInches() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertFromBaseUnit(1.0),
                0.0001);
    }

    @Test
    public void testQuantity_Equality_CrossUnit() {
        assertTrue(new Quantity(1.0, LengthUnit.FEET)
                .equals(new Quantity(12.0, LengthUnit.INCHES)));
    }

    @Test
    public void testQuantity_ConvertTo() {
        Quantity q = new Quantity(1.0, LengthUnit.FEET)
                .convertTo(LengthUnit.INCHES);

        assertEquals(12.0, q.getValue(), 0.0001);
    }

    @Test
    public void testQuantity_Add_TargetUnit() {
        Quantity result = new Quantity(1.0, LengthUnit.FEET)
                .add(new Quantity(12.0, LengthUnit.INCHES), LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    public void testQuantity_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity(1.0, null);
        });
    }

    @Test
    public void testQuantity_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity(Double.NaN, LengthUnit.FEET);
        });
    }
}