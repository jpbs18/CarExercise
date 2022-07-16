public class Tyre {

    private int integrity = 100;

    private int consumeRatio;

    public Tyre(boolean frontOrRear){
        if(frontOrRear){
            this.consumeRatio = 2;
        }
        else{
            this.consumeRatio = 1;
        }
    }

    public void decreaseIntegrity() {
         integrity -= 25 * consumeRatio;

    }
    public int getIntegrity(){
        return this.integrity;
    }

    public void replaceTyre(){
        System.out.println("You set a new tyre.");
        this.integrity = 100;
    }
}
