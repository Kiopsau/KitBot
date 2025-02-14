package frc.robot.subsystems.Algae; 

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command; 
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants.AlgaeConstants;

public class Algae extends SubsystemBase {
    private WPI_TalonSRX arm; 
    private WPI_VictorSPX rotater; 
    private DutyCycleEncoder encoder; 

    private boolean Coralin = false; 
    private boolean Coralout = false; 

    private PIDController pid; 
    private ArmFeedforward feedforward; 
    
    private boolean bumperOn; 
    
    public Algae () { 
        rotater = new WPI_VictorSPX(AlgaeConstants.rotateCAN); 
        arm = new WPI_TalonSRX(AlgaeConstants.armCAN); 

        encoder = new DutyCycleEncoder(AlgaeConstants.encoderCAN); 

        bumperOn = false; 

        pid = new PIDController (
            AlgaeConstants.kP, 
            AlgaeConstants.kI, 
            AlgaeConstants.kD 
        ); 

        feedforward = new ArmFeedforward(0, AlgaeConstants.kG, 0); 

        Preferences.removeAll(); 
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

    @SuppressWarnings("static-access") 
    public Rotation2d getEncoderPositionInRotations () {
        return new Rotation2d().fromRotations(encoder.get() - AlgaeConstants.armZero); 
    } 

    public Command angle (AlgaePosition setpoint) {
        return runOnce(() -> {
            System.out.println(setpoint.name); 
            pid.setSetpoint(setpoint.position); 
        }); 
    } 

    public Command goPosition () {
        return runOnce(() -> {
            bumperOn = true; 
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

    public Command setAngle(double setpoint) {
        return runOnce(() -> {
            pid.setSetpoint(setpoint); 
        }); 
    } 

    @Override 
    public void periodic () {
        double encoderPos = getEncoderPositionInRotations().getRadians(); 

        if (!bumperOn) return; 

        double voltage = MathUtil.clamp(pid.calculate(encoderPos) + feedforward.calculate(pid.getSetpoint(), 0), -3, 5); 

        arm.setVoltage(voltage); 
    }
}
