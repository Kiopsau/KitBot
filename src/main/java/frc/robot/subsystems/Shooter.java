package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX; 
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants; 

public class Shooter extends SubsystemBase {
    private TalonFX motor; 
    
    public Shooter() {
        motor = new TalonFX(ShooterConstants.CoralPort); 
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