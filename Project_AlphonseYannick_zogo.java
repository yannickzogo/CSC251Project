public class Project_AlphonseYannick_zogo {
    // Attributes
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    // No-arg constructor
    public Project_AlphonseYannick_zogo() {
        this.policyNumber = "";
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }

    // Parameterized constructor
    public Project_AlphonseYannick_zogo(String policyNumber, String providerName, String firstName, 
                  String lastName, int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Setters and Getters
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public String getPolicyNumber() { return policyNumber; }

    public void setProviderName(String providerName) { this.providerName = providerName; }
    public String getProviderName() { return providerName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }

    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }

    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
    public String getSmokingStatus() { return smokingStatus; }

    public void setHeight(double height) { this.height = height; }
    public double getHeight() { return height; }

    public void setWeight(double weight) { this.weight = weight; }
    public double getWeight() { return weight; }

    // Dynamic BMI Calculator (avoids stale data)
    public double getBMI() {
        if (height == 0) {
            return 0.0;
        }
        return (weight * 703) / (height * height);
    }

    // Dynamic Price Calculator (avoids stale data)
    public double getPrice() {
        double price = 600.0; // Base Fee

        if (age > 50) {
            price += 75.0;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }
        
        double bmi = getBMI();
        if (bmi > 35.0) {
            price += (bmi - 35.0) * 20.0;
        }

        return price;
    }
}