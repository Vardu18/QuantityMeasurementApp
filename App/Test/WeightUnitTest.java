package com.apps.quantitymeasurement;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    // ===== Equality =====
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;
        return Double.compare(this.toBase(), other.toBase()) == 0;
    }

    // ===== Conversion =====
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = this.toBase();
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityWeight(converted, targetUnit);
    }

    // ===== UC6 Add =====
    public QuantityWeight add(QuantityWeight other) {
        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }

        double sumBase = this.toBase() + other.toBase();
        double result = this.unit.convertFromBaseUnit(sumBase);

        return new QuantityWeight(result, this.unit);
    }

    // ===== UC7 Add with target unit =====
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double sumBase = this.toBase() + other.toBase();
        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityWeight(result, targetUnit);
    }

    // Getters
    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}