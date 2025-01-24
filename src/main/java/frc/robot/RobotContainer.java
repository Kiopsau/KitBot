package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.DriverConstants;
import frc.robot.subsystems.Driver;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
    public final Shooter shooter; 
    public final Driver driver; 
    private final CommandXboxController shooterController; 
    //private final CommandXboxController driverController; 

    public RobotContainer() {
        shooter = new Shooter();
        driver = new Driver(); 

        shooterController = new CommandXboxController(DriverConstants.XBOXPort); 
        //driverController = new CommandXboxController(DriverConstants.XBOXPort); 

        configureBindings(); 
    }

    private void configureBindings() {
        shooterController.x().onTrue(shooter.start(ShooterConstants.CoralSpeed)); 
        shooterController.x().onFalse(shooter.stop()); 


        shooterController.rightTrigger().onTrue(driver.DriveRight(DriverConstants.DriveSpeed)); 
        shooterController.rightTrigger().onFalse(driver.DriveRight(0)); 

        shooterController.leftTrigger().onTrue(driver.DriveLeft(DriverConstants.DriveSpeed)); 
        shooterController.leftTrigger().onFalse(driver.DriveLeft(0)); 
    }
}
