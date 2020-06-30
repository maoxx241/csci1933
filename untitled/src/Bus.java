public class Bus extends Vehicle{
    private String route;
    private int numPassengers;;
    public Bus(String makeModelIn,String routeIn,int numPass){
        super(makeModelIn);
        route=routeIn;
        numPassengers=numPass;
    }


    public void updateFuelLevel(int hours) {
        setFuelLevel(getMpg()-(numPassengers)*(0.05));
    }

    public void setRoute(String route){

    }

    public String getRoute() {
        return route;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

}
