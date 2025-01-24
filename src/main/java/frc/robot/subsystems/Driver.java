package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX; 
import frc.robot.Constants.DriverConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 


public class Driver extends SubsystemBase {
    private TalonFX Left1; 
    private TalonFX Left2; 
    private TalonFX Right1; 
    private TalonFX Right2; 

	public static final double diameter = 0;
	public static final double gearRatio = 1; 
	public static final double circumference = diameter * Math.PI;
	public static final double countsPerRevolution = 0; 
    
    public void Drivetrain() {
	    Left1 = new TalonFX(DriverConstants.Left1Port); 
	    Left2 = new TalonFX(DriverConstants.Left2Port); 
	    Right1 = new TalonFX(DriverConstants.Right1Port); 
	    Right2 = new TalonFX(DriverConstants.Right2Port); 
	    
	    /*double dpp = gearRatio * (circumference/countsPerRevolution);
	    right.setDistancePerPulse(dpp); // must be changed for both right and left
	    left.setDistancePerPulse(dpp);   */ 
   }
   
   public void rightDrive(double speed) {
	   Right1.set(speed); 
	   Right2.set(speed); 
   }
   
   public void leftDrive(double speed) {
	   Left1.set(speed); 
	   Left2.set(speed); 
   }
   
   /*public void drive(double leftMotors, double rightMotors) {
	   Left1.set(leftMotors);
	   Left2.set(leftMotors); 
	   Right1.set(rightMotors);
	   Right2.set(rightMotors); 
   }*/ 

   public Command DriveRight(double speed) {
        return runOnce(() -> {
            rightDrive(speed); 
        }); 
   }

   public Command DriveLeft(double speed) {
        return runOnce(() -> {
            leftDrive(speed); 
        }); 
   }
}
