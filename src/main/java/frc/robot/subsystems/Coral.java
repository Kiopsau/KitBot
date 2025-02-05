package frc.robot.subsystems; 

import edu.wpi.first.wpilibj2.command.Command; 
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.CoralConstants;

public class Coral extends SubsystemBase {
    private WPI_TalonSRX rotater = new WPI_TalonSRX(CoralConstants.rotateCAN); 

    public boolean Coralin = false; 
    public boolean Coralout = false; 
    
    public Coral () {
        rotater.configFactoryDefault(); 
    } 

    public Command shootCoral () {
        return runOnce(() -> {
            rotater.setVoltage(CoralConstants.CoralSpeed); 
            System.err.println("CoralOUT"); 
            Coralout = true; 
        }); 
    } 

    public Command stopCoral () {
        return runOnce(() -> {
            rotater.setVoltage(0); 
            Coralin = false; 
            Coralout = false; 
        }); 
    }
}
