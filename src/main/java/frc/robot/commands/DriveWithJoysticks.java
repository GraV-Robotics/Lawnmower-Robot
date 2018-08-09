package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveWithJoysticks extends Command {

  public DriveWithJoysticks() {
    
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    DriveTrainSubsystem.drive(OI.joystick1.getY(), OI.joystick2.getY());
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
