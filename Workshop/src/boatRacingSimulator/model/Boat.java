package boatRacingSimulator.model;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.helpers.BoatValidator;

public abstract class Boat {

    private String model;
    private int weight;

    protected Boat(String model, int weight) throws ArgumentException {
        this.setModel(model);
        this.setWeight(weight);
    }

    private void setWeight(int weight) throws ArgumentException {
        if (BoatValidator.validateParam(weight)) {
            this.weight = weight;
        } else {
            throw new ArgumentException(generateErrorMessage("Weight"));
        }
    }

    protected String generateErrorMessage(String paramName) {
        return String.format("%s must be a positive integer.", paramName);
    }

    private void setModel(String model) throws ArgumentException {
        if (BoatValidator.validateModel(model)) {
            this.model = model;
        } else {
            throw new ArgumentException("Model's name must be at least "
                    + BoatValidator.getMinModelLength() + " symbols long.");
        }
    }

}
