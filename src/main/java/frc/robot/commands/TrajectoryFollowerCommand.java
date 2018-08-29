package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrainSubsystem;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class TrajectoryFollowerCommand extends Command {

  Trajectory leftTraj;
  Trajectory rightTraj;
  EncoderFollower left;
  EncoderFollower right;
  DriveTrainSubsystem driveTrainSubsystem;

  public TrajectoryFollowerCommand(DriveTrainSubsystem driveSubsystem) {
    driveTrainSubsystem = driveSubsystem;
  }

  @Override
  protected void initialize() {
    leftTraj = Pathfinder.readFromCSV(RobotMap.leftTrajectory);
    rightTraj = Pathfinder.readFromCSV(RobotMap.rightTrajectory);
    left = new EncoderFollower(leftTraj);
    right = new EncoderFollower(rightTraj);
  }

  @Override
  protected void execute() {
    left.configureEncoder(driveTrainSubsystem.getRawLeftEncoderPosition(), RobotMap.driveTrainEncoderPulses, RobotMap.driveTrainWheelSize);
    right.configureEncoder(driveTrainSubsystem.getRawRightEncoderPosition(), RobotMap.driveTrainEncoderPulses, RobotMap.driveTrainWheelSize);
    left.configurePIDVA(1.0, 0.0, 0.0, 1 / RobotMap.maxVelocityMetersPerSecond, 0);
    right.configurePIDVA(1.0, 0.0, 0.0, 1 / RobotMap.maxVelocityMetersPerSecond, 0);
    double l = left.calculate(driveTrainSubsystem.getRawLeftEncoderPosition());
    double r = right.calculate(driveTrainSubsystem.getRawRightEncoderPosition());
    double gyroHeading = driveTrainSubsystem.getGyroAngle();
    double desiredHeading = Pathfinder.r2d(left.getHeading());
    double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - gyroHeading);
    double turn = 0.8 * (-1.0/80.0) * angleDifference;
    driveTrainSubsystem.drive(l + turn, r - turn);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    driveTrainSubsystem.drive(0, 0);
  }

  @Override
  protected void interrupted() {
  }
}