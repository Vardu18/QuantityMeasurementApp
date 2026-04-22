package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Updated enum with new units
    public enum LengthUnit {

        FEET(1.0),
        INCHES(1.0 / 12.0),          // 1 inch = 1/12 feet
        YARDS(3.0),                  // 1 yard = 3 feet
        CENTIMETERS(0.0328084);      // 1 cm = 0.0328084 feet

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }
    }

    // SAME class as UC3 (no change)
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }
    }

    // Demo
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.YARDS);
        Quantity q2 = new Quantity(3.0, LengthUnit.FEET);

        System.out.println("1 yard == 3 feet ? " + q1.equals(q2));

        Quantity q3 = new Quantity(1.0, LengthUnit.CENTIMETERS);
        Quantity q4 = new Quantity(0.393701, LengthUnit.INCHES);

        System.out.println("1 cm == 0.393701 inches ? " + q3.equals(q4));
    }
}