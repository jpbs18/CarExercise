public class Engine {

    private int range;
    private int fuelLevel;

    public Engine() {
        range = 10;
        fuelLevel = 10;
    }

    public int generateEnergy(int fuel) {
        if (fuelLevel - fuel < 0) {
            return 0;
        }
        fuelLevel -= fuel;
        return fuel * range;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

}
