package boatRacingSimulator.model;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.helpers.BoatValidator;

public class RowBoat extends Boat {

    private int oars;

    protected RowBoat(String model, int weight , int oars) throws ArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) throws ArgumentException {
        if (BoatValidator.validateParam(oars)){
            this.oars = oars;
        }else {
            throw new ArgumentException(this.generateErrorMessage("Oars"));
        }
    }
}
