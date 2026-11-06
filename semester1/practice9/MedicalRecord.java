package practice9;


import java.util.Arrays;
public class MedicalRecord {
    private final String patientId;
    private String fullName;
    private int bloodGroup;
    private boolean rhPositive;
    private String[] allergies;
    public MedicalRecord(String patientId, String fullName,
                         int bloodGroup, boolean rhPositive,
                         String[] allergies) {
        this.patientId = patientId;
        this.fullName = fullName;
        if (bloodGroup < 1 || bloodGroup > 4) {
            throw new IllegalArgumentException("Некоректна група крові!");
        }
        this.bloodGroup = bloodGroup;
        this.rhPositive = rhPositive;
        this.allergies = Arrays.copyOf(allergies, allergies.length);
    }
    public String[] getAllergies() {
        return Arrays.copyOf(allergies, allergies.length);
    }
    public boolean hasAllergyTo(String substance) {
        for (String allergy : allergies) {
            if (allergy.equalsIgnoreCase(substance)) {
                return true;
            }
        }
        return false;
    }
    private String getBloodGroupText() {
        String group;
        switch (bloodGroup) {
            case 1:
                group = "I (0)";
                break;
            case 2:
                group = "II (A)";
                break;
            case 3:
                group = "III (B)";
                break;
            case 4:
                group = "IV (AB)";
                break;
            default:
                group = "Невідома";
        }
        return group + (rhPositive ? " Rh+" : " Rh-");
    }
    @Override
    public String toString() {
        return "Медична картка:\n" +
                "ID пацієнта: " + patientId + "\n" +
                "ПІБ: " + fullName + "\n" +
                "Група крові: " + getBloodGroupText() + "\n" +
                "Алергії: " + Arrays.toString(allergies);
    }
    public static void main(String[] args) {
        String[] allergies = {"Пилок", "Арахіс", "Пеніцилін"};
        MedicalRecord patient = new MedicalRecord(
                "P001",
                "Іван Петренко",
                2,
                true,
                allergies
        );
        System.out.println(patient);
        System.out.println("\nПеревірка алергій:");
        System.out.println("Алергія на арахіс: " +
                patient.hasAllergyTo("арахіс"));
        System.out.println("Алергія на молоко: " +
                patient.hasAllergyTo("молоко"));
        allergies[0] = "Шоколад";
        System.out.println("\nПісля зміни зовнішнього масиву:");
        System.out.println(patient);
    }
}

