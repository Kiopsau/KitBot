package frc.robot.subsystems.Algae;


public enum AlgaePosition {
    UPRIGHT("UPRIGHT", 1.1), 
    OUT("OUT", 0.1), 
    CARRY("CARRY", 0.27); 

    public final double position; 
    public final String name; 

    private AlgaePosition (String name, double position) {
        this.name = name; 
        this.position = position; 
    }

    @Override 
    public String toString() {
        return name; 
    }
}
