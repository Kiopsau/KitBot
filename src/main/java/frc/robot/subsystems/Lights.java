package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LEDConstants;

public class Lights extends SubsystemBase {
    private PWM lightStrip;
    private boolean light = false; 
    private int count = 0; 
    
    public Lights() {
        lightStrip = new PWM(LEDConstants.LEDCAN);

        Preferences.initDouble("patternType", 0.49);
    }

    public void applyPattern(int pattern) {
        lightStrip.setPulseTimeMicroseconds(pattern);
    }

    public Command setLights() {
        return runOnce(() -> {
            if (!light) {
                applyPattern(Preferences.getInt("patternType", 1840)); 
                System.out.println("YELLOW"); 
            } else {
                applyPattern(Preferences.getInt("patternType", 1925)); 
                System.out.println("BLUE"); 
            }
            count++; 
            if (count == 30) {
                count = 0; 
                light = !light; 
            }
        });
    }
}