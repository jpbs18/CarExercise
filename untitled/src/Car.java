public class Car {

    private String brand;
    private String color;
    private Engine engine;

    private Tyre[] tyre;

    private Radio radio;

    public Car(String brand, String color, int numberTyres) {
        this.brand = brand;
        this.color = color;
        this.engine = new Engine();
        this.radio = new Radio();
        this.tyre = new Tyre[numberTyres];
        createTyre();
    }

    public void accelerate() {
        int distance = engine.generateEnergy(1);

        if (checkAll()) {
            System.out.println("Your tyre exloded.");
            replaceIfNecessary();
            return;
        }

        if (distance > 0) {
            System.out.println("Vrum, vrum for " + distance + "km.");
            decreaseAll();
            if (checkAll()) {
                radio.play();
            }
            return;
        }
        System.out.println("No vrum, vrum for you!");
        getRefuelled();
    }


    public void getRefuelled(){
        System.out.println("You refuelled your car");
        engine.setFuelLevel(10);
    }

    public String getBrand(String brand){
        return this.brand;
    }

    public String getColor(String color){
        return this.color;
    }


    public void createTyre(){

        for(int i = 0; i < tyre.length; i++){
            if(i < 2){
                tyre[i] = new Tyre(true);
            }
            else{
                tyre[i] = new Tyre(false);
            }
        }
    }

    private boolean checkAll(){
        for(Tyre e : tyre){
            if(e.getIntegrity() < 1){
                return true;
            }
        }
        return false;
    }

    private void replaceIfNecessary(){
        for(Tyre e : tyre){
            if(e.getIntegrity() <= 0){
                e.replaceTyre();
            }
        }
    }

    private void decreaseAll(){
        for(Tyre e : tyre){
            e.decreaseIntegrity();
        }
    }
}
