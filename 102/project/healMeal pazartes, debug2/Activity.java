public class Activity{
    //properties
    double burnedPerHour;
    String activityName;

    //constructors
    public Activity(String name, double burnedPerHour){
        activityName = name;
        this.burnedPerHour = burnedPerHour;
    }
    
    //methods
    /**
     * Calculates how many calories is burned
     * @param time is activity time in hour
     * @return burned calories
     */
    public double calculateBurnedCalorie(double time){
        return time * burnedPerHour;
    }
    public double getBurnedPerHour(){
        return burnedPerHour;
    }
    public void setBurnedPerHour(double newBurnedPerHour){
        burnedPerHour = newBurnedPerHour;
    }
    public String toString(){
        return "" + activityName + " " + burnedPerHour;
    }
    public String getName(){
        return activityName;
    }
}