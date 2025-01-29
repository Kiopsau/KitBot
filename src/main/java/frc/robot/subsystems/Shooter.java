package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants; 

public class Shooter extends SubsystemBase {
    private WPI_TalonSRX motor; 

    public boolean ShootOut = false; 
    public boolean ShootIn = false; 
    
    public Shooter() {
        motor = new WPI_TalonSRX(ShooterConstants.shooterCAN); 
    }

    public void ShootCoral() {
        if (!ShootIn) {
            motor.setVoltage(-ShooterConstants.shooterSpeed); 
            ShootOut = true; 
        } else {
            motor.setVoltage(0); 
            ShootOut = false; 
            ShootIn = false; 
        }
    }

    public void unShootCoral() {
        if (!ShootOut) {
            motor.setVoltage(ShooterConstants.shooterSpeed); 
            ShootIn = true; 
        } else {
            motor.setVoltage(0); 
            ShootOut = false; 
            ShootIn = false; 
        }
    }

    public void StopShooter() {
        motor.setVoltage(0); 
        ShootOut = false; 
        ShootIn = false; 
    }

    public Command start() {
        return runOnce(() -> {
            ShootCoral();
        });
    }

    public Command astart() {
        return runOnce(() -> {
            unShootCoral();
        });
    }

    public Command stop() {
        return runOnce(() -> {
            StopShooter(); 
        });
    }
} 