public class Building {
    private String streetAddress;
    private double sizeInSqFt;

    // Default constructor
    public Building() {
        this.streetAddress = "Unknown";
        this.sizeInSqFt = 0.0;
    }

    // Parameterized constructor
    public Building(String streetAddress, double sizeInSqFt) {
        setStreetAddress(streetAddress);
        setSizeInSqFt(sizeInSqFt);
    }

    // Getters and Setters
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        if (streetAddress != null && !streetAddress.trim().isEmpty()) {
            this.streetAddress = streetAddress;
        } else {
            this.streetAddress = "Unknown";
        }
    }

    public double getSizeInSqFt() {
        return sizeInSqFt;
    }

    public void setSizeInSqFt(double sizeInSqFt) {
        if (sizeInSqFt >= 0) {
            this.sizeInSqFt = sizeInSqFt;
        } else {
            this.sizeInSqFt = 0.0;
        }
    }

    @Override
    public String toString() {
        return "Building Address: " + streetAddress + ", Size: " + sizeInSqFt + " sq ft";
    }
}