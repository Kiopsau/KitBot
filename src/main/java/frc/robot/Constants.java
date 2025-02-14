package frc.robot;

public final class Constants {
    public final class OIConstants {
        public static final int XBOXPort = 0;
    }

    public final class ShooterConstants {
        public static final int shooterCAN = 5;
        public static final double shooterSpeed = 4.0; 
    }

    public final class DriveConstants {
        public static final int leftMainCAN = 4;
        public static final int leftFollowCAN = 2;
        public static final int rightMainCAN = 3;
        public static final int rightFollowCAN = 1;

        public static final double driveSpeed = -5.0;

        public static final double turnSpeed = 1.0;
    } 

    public final class AlgaeConstants {
        public static final int rotateCAN = 7; 
        public static final int armCAN = 6; 
        public static final int encoderCAN = 9; 

        public static final double AlgaeSpeed = -4.0; 

        public static final double kP = 18.0; 
        public static final double kI = 1.0; 
        public static final double kD = 1.0; 

        public static final double kS = 0; 
        public static final double kG = 5.0; 

        public static final double armZero = 0.46; 
    }
}