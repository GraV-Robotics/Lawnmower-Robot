package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveWithJoysticks extends Command {

  DriveTrainSubsystem driveTrainSubsystem;
  OI oi;

  public DriveWithJoysticks() {
    
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    driveTrainSubsystem.drive(oi.joystick1.getY(), oi.joystick2.getY());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
