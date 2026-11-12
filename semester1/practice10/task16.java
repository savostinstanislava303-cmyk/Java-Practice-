package practice10;

public class task16 {
    interface DataExportable {
        String toJson();
        String toCsvRow();
    }
    static class StudentGradeRecord implements DataExportable {
        private String name;
        private int group;
        private double gpa;
        public StudentGradeRecord(String name, int group, double gpa) {
            this.name = name;
            this.group = group;
            this.gpa = gpa;
        }
        @Override
        public String toJson() {
            return "{\"name\":\"" + name + "\", \"group\":" + group +
                    ", \"gpa\":" + gpa + "}";
        }
        @Override
        public String toCsvRow() {
            return name + "," + group + "," + gpa;
        }
    }
    static class WeatherObservation implements DataExportable {
        private String city;
        private double tempC;
        private int humidity;
        public WeatherObservation(String city, double tempC, int humidity) {
            this.city = city;
            this.tempC = tempC;
            this.humidity = humidity;
        }
        @Override
        public String toJson() {
            return "{\"city\":\"" + city + "\", \"tempC\":" + tempC +
                    ", \"humidity\":" + humidity + "}";
        }
        @Override
        public String toCsvRow() {
            return city + "," + tempC + "," + humidity;
        }
    }
    public static void main(String[] args) {
        DataExportable[] records = {
                new StudentGradeRecord("Anna", 11, 4.5),
                new StudentGradeRecord("Ivan", 12, 3.8),
                new WeatherObservation("Kyiv", 18.5, 65),
                new WeatherObservation("Lviv", 16.0, 70)
        };
        System.out.println("JSON DUMP:");
        for (DataExportable record : records) {
            System.out.println(record.toJson());
        }
        System.out.println("\nCSV TABLE:");
        System.out.println("Data");
        for (DataExportable record : records) {
            System.out.println(record.toCsvRow());
        }
    }
}

