package frc.robot.subsystems;

import frc.robot.Constants.DriverConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 


public class Driver extends SubsystemBase {
    private WPI_TalonSRX Left1; 
    private WPI_TalonSRX Left2; 
    private WPI_TalonSRX Right1; 
    private WPI_TalonSRX Right2; 

	public static final double diameter = 0;
	public static final double gearRatio = 1; 
	public static final double circumference = diameter * Math.PI;
	public static final double countsPerRevolution = 0; 
    
    public void Drivetrain() {
	    Left1 = new WPI_TalonSRX(DriverConstants.Left1Port); 
	    Left2 = new WPI_TalonSRX(DriverConstants.Left2Port); 
	    Right1 = new WPI_TalonSRX(DriverConstants.Right1Port); 
	    Right2 = new WPI_TalonSRX(DriverConstants.Right2Port); 
	    
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
