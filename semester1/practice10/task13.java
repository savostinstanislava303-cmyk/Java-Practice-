package practice10;

public class task13 {
    interface AcousticSignal {
        default String emitAlert() {
            return "🔊 Звукова сирена 110 дБ";
        }
    }
    interface OpticalSignal {
        default String emitAlert() {
            return "🚨 Стробоскопічний маячок";
        }
    }
    static class EmergencyBeacon implements AcousticSignal, OpticalSignal {
        @Override
        public String emitAlert() {
            return AcousticSignal.super.emitAlert() + "\n" +
                    OpticalSignal.super.emitAlert();
        }
    }
    public static void main(String[] args) {
        EmergencyBeacon beacon = new EmergencyBeacon();
        System.out.println("Активація аварійного маячка:");
        System.out.println(beacon.emitAlert());
    }
}


