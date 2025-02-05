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

    public final class CoralConstants {
        public static final int rotateCAN = 1; 
        public static final int pidtalonbtw = 5; 
        public static final double CoralSpeed = 1; 
    }
}