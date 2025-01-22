package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants; 

public class Shooter extends SubsystemBase {
    private Talon motor; 
    
    public Shooter() {
        motor = new Talon(ShooterConstants.CoralPort); 
    }

    public void ShootCoral(double volts) {
        motor.setVoltage(volts); 
    }

    public void StopShooter() {
        motor.setVoltage(0);
    }

    public Command start(double volts) {
        return runOnce(() -> {
            ShootCoral(volts);
        });
    }

    public Command stop() {
        return runOnce(() -> {
            StopShooter(); 
        });
    }
} 