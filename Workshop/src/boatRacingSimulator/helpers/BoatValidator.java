package boatRacingSimulator.helpers;

public class BoatValidator {
    private static final int MIN_MODEL_lENGTH = 5;

    public static boolean validateModel(String model) {
        return model.length() >= MIN_MODEL_lENGTH;
    }

    public static String getMinModelLength() {
        return String.valueOf(MIN_MODEL_lENGTH);
    }

    public static boolean validateParam(int param) {
        return param > 0;
    }

    public static boolean validateSailEfficiency(int efficiency) {
        return efficiency > 0 && efficiency < 101;
    }
}
