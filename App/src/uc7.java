package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Enum with conversion factors to base unit (FEET)
    public enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(1.0 / 30.48);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeetFactor;
        }
    }

    // Quantity class
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        // ===== UC3: Equality =====
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;
            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }

        // ===== UC6: Add (result in this.unit) =====
        public Quantity add(Quantity other) {
            if (other == null) {
                throw new IllegalArgumentException("Other quantity cannot be null");
            }

            double sumInFeet = this.toFeet() + other.toFeet();
            double resultValue = this.unit.fromFeet(sumInFeet);

            return new Quantity(resultValue, this.unit);
        }

        // ===== UC7: Add with target unit =====
        public Quantity add(Quantity other, LengthUnit targetUnit) {
            if (other == null) {
                throw new IllegalArgumentException("Other quantity cannot be null");
            }
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double sumInFeet = this.toFeet() + other.toFeet();
            double resultValue = targetUnit.fromFeet(sumInFeet);

            return new Quantity(resultValue, targetUnit);
        }

        // Getters
        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCHES);

        // UC3 Equality
        System.out.println("Equality: " + q1.equals(q2));

        // UC6 Addition
        Quantity result1 = q1.add(q2);
        System.out.println("UC6 Add (same unit as first): " +
                result1.getValue() + " " + result1.getUnit());

        // UC7 Addition
        Quantity result2 = q1.add(q2, LengthUnit.YARDS);
        System.out.println("UC7 Add (target unit YARDS): " +
                result2.getValue() + " " + result2.getUnit());
    }
}