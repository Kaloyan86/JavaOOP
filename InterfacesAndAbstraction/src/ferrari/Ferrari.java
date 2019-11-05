package ferrari;

public class Ferrari implements Car {

    private String driverName;


    public Ferrari(String driverName) {
        this.setDriverName(driverName);

    }

    public String getDriverName() {
        return driverName;
    }

    private void setDriverName(String driverName) {
        this.driverName = driverName;
    }


    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

//    "{model}/{brakes}/{gas pedal}/{driver's name}"

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", MODEL, this.brakes(), this.gas(), this.driverName);
    }
}
