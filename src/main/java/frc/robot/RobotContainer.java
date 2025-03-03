// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Lights;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Algae.Algae;

public class RobotContainer {
    public final Shooter shooter;
    public final DriveTrain drivetrain; 
    public final Algae algae; 
    public final Lights lights; 

    private final CommandXboxController controller;  

    public RobotContainer() {
        shooter = new Shooter();
        drivetrain = new DriveTrain(); 
        algae = new Algae(); 
        lights = new Lights(); 

        controller = new CommandXboxController(OIConstants.XBOXPort);

        configureBindings();
    }

    private void configureBindings() {
        drivetrain.setDefaultCommand(drivetrain.drive(controller::getRightX, controller::getRightY));

        controller.x().onTrue(shooter.start());
        controller.x().onFalse(shooter.stop());
        controller.y().onTrue(shooter.astart());
        controller.y().onFalse(shooter.stop()); 

        controller.a().onTrue(algae.shootAlgae()); 
        controller.a().onFalse(algae.stopAlgae()); 
        controller.b().onTrue(algae.unshootAlgae()); 
        controller.b().onFalse(algae.stopAlgae()); 

        controller.rightBumper().onTrue(lights.setLights()); 
        lights.setLights(); 
    }

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}