package boatRacingSimulator.model;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.helpers.BoatValidator;

public class SailBoat extends Boat {
    private int sailEfficiency;

    protected SailBoat(String model, int weight , int sailEfficiency) throws ArgumentException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) throws ArgumentException {
        if (BoatValidator.validateSailEfficiency(sailEfficiency)){
            this.sailEfficiency = sailEfficiency;
        }else {
            throw new ArgumentException("Sail Effectiveness must be between [1...100].");
        }
    }
}
