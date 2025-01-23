package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX; 
import edu.wpi.first.wpilibj2.command.Command; 
import frc.robot.Constants.DriverConstants; 

public class Driver {
    private TalonFX DriveMotor; 

    public Driver () {
        DriveMotor = new TalonFX(DriverConstants.DrivePort); 
    } 

    public void Drive() {
        DriveMotor.setVoltage(DriverConstants.DriveSpeed); 
    }
}
