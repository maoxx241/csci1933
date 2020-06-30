public class Vehicle {
    private String makeModel;
    private double speed, fuelLevel, mpg;
    public Vehicle(String makeModelIn){
        makeModel = makeModelIn;
        speed=0;
        fuelLevel=15;
        mpg=20;
    }

    public void updateFuelLevel(int hours){
        fuelLevel-=(speed*hours)/mpg;
    }

    public String getStatus(){
        String info = new String("Vehicle:"+makeModel+",Speed:"+speed +", Fuel left:"+fuelLevel);
        return  info;
    }
    public void setFuelLevel(double fuelLevel){

    }
    public double getFuelLevel(){
        return fuelLevel;
    }

    public void setMpg(double mpg){

    }
    public double getMpg(){
        return mpg;
    }

    public double getSpeed() {
        return speed;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
