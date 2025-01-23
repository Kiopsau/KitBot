package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.DriverConstants;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
    public final Shooter shooter; 
    private final CommandXboxController shooterController; 
    //private final CommandXboxController driverController; 

    public RobotContainer() {
        shooter = new Shooter();

        shooterController = new CommandXboxController(DriverConstants.XBOXPort); 
        //driverController = new CommandXboxController(DriverConstants.XBOXPort); 

        configureBindings(); 
    }

    private void configureBindings() {
        shooterController.x().onTrue(shooter.start(ShooterConstants.CoralSpeed)); 
        shooterController.x().onFalse(shooter.stop()); 
    }
}
