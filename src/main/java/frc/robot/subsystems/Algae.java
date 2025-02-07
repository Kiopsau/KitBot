package frc.robot.subsystems; 

import edu.wpi.first.wpilibj2.command.Command; 
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants.AlgaeConstants;

public class Algae extends SubsystemBase {
    private WPI_TalonSRX arm; 
    private WPI_VictorSPX rotater; 

    private boolean Coralin = false; 
    private boolean Coralout = false; 
    
    public Algae () { 
        rotater = new WPI_VictorSPX(AlgaeConstants.rotateCAN); 
        arm = new WPI_TalonSRX(AlgaeConstants.armCAN); 

        rotater.configFactoryDefault(); 
        arm.configFactoryDefault(); 
    } 

    public Command shootAlgae () {
        return runOnce(() -> {
            if (!Coralout) {
                rotater.setVoltage(AlgaeConstants.AlgaeSpeed); 
                Coralin = true; 
            }
        }); 
    } 

    public Command stopAlgae () {
        return runOnce(() -> {
            rotater.setVoltage(0); 
            Coralin = false; 
            Coralout = false; 
        }); 
    } 

    public Command unshootAlgae () {
        return runOnce(() -> { 
            if (!Coralin) { 
                rotater.setVoltage(-AlgaeConstants.AlgaeSpeed); 
                Coralout = true; 
            }
        }); 
    }
}
