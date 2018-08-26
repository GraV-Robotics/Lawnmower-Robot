package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class DriveWithJoysticks extends Command {

<<<<<<< HEAD
  DriveTrainSubsystem driveTrainSubsystem;

  public DriveWithJoysticks(DriveTrainSubsystem driveTrain) {
    driveTrainSubsystem = driveTrain;
=======
  public DriveWithJoysticks() {
    
>>>>>>> master
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
<<<<<<< HEAD
    driveTrainSubsystem.drive(OI.joystick1.getY(), OI.joystick2.getY());
=======
    Robot.driveTrainSubsystem.drive(OI.joystick1.getY(), OI.joystick2.getY());
>>>>>>> master
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
