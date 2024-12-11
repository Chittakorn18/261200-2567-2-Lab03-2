public class Patient {
    private int id;
    private String name;
    private int birthYear;
    private double height; // cm
    private double weight; // kg
    private String bloodGroup;
    private String phoneNumber;

    public Patient(int id, String name, int birthYear, double height, double weight, String bloodGroup, String phoneNumber) {
        this.id = id;
        this.name = name;

        if (birthYear > 0 && birthYear <= 2024) {
            this.birthYear = birthYear;
        } else {
            this.birthYear = 2000; // Default
            System.out.println("Invalid birth year. Defaulting to 2000.");
        }

        if (height > 0) {
            this.height = height;
        } else {
            this.height = 170; // Default
            System.out.println("Invalid height. Defaulting to 170 cm.");
        }

        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = 60; // Default
            System.out.println("Invalid weight. Defaulting to 60 kg.");
        }

        if (bloodGroup != null && !bloodGroup.isEmpty()) {
            this.bloodGroup = bloodGroup;
        } else {
            this.bloodGroup = "Unknown"; // Default
            System.out.println("Invalid blood group. Defaulting to 'Unknown'.");
        }

        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "Not Provided"; // Default
            System.out.println("Invalid phone number. Defaulting to 'Not Provided'.");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBMI() {
        if (height > 0 && weight > 0) {
            double heightInMeters = height / 100.0;
            return weight / (heightInMeters * heightInMeters);
        } else {
            return 0.0; // Invalid BMI if height or weight is invalid
        }
    }

    public int getAge(int currentYear) {
        if (currentYear >= birthYear) {
            return currentYear - birthYear;
        } else {
            System.out.println("Invalid current year.");
            return -1;
        }
    }

    public void displayDetails(int currentYear) {
        System.out.println("Patient ID: " + id);
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Age: " + getAge(currentYear));
        System.out.println("Patient Height (cm): " + height);
        System.out.println("Patient Weight (kg): " + weight);
        System.out.println("Patient Blood Group: " + bloodGroup);
        System.out.println("Patient Phone Number: " + phoneNumber);
        System.out.println("Patient BMI: " + getBMI());
    }

    public static void main(String[] args) {
        int currentYear = 2024;
        Patient patient = new Patient(1001, "John Doe", 1978, 175.5, 78.0, "O+", "123-456-7890");
        patient.displayDetails(currentYear);

        Patient invalidPatient = new Patient(1002, "Joe Dohn", 1990, -160.0, -65.0, "", "");
        invalidPatient.displayDetails(currentYear);
    }
}
