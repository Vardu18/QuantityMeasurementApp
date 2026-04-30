public Quantity<U> subtract(Quantity<U> other) {
    if (other == null) {
        throw new IllegalArgumentException("Other quantity cannot be null");
    }

    if (!this.unit.getClass().equals(other.unit.getClass())) {
        throw new IllegalArgumentException("Cannot subtract different measurement categories");
    }

    double resultBase = this.toBase() - other.toBase();

    double resultValue = this.unit.convertFromBaseUnit(resultBase);

    // round to 2 decimal places
    resultValue = Math.round(resultValue * 100.0) / 100.0;

    return new Quantity<>(resultValue, this.unit);
}