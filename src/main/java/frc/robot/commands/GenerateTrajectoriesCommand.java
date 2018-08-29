package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

public class GenerateTrajectoriesCommand extends Command {

  Waypoint[] points;
  Trajectory.Config config;
  Trajectory trajectory;
  TankModifier modifier;

  public GenerateTrajectoriesCommand() {

  }

  @Override
  protected void initialize() {
    config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, RobotMap.maxVelocityMetersPerSecond, RobotMap.maxVelocityMetersPerSecond, 60.0);
    points = new Waypoint[] {
      new Waypoint(convertInchesToMeters(12), convertInchesToMeters(12), Pathfinder.d2r(45)),
      new Waypoint(convertInchesToMeters(24), convertInchesToMeters(24), 0),
      new Waypoint(0, 0, 0)
    };

    trajectory = Pathfinder.generate(points, config);
    modifier = new TankModifier(trajectory).modify(RobotMap.wheelBaseWidth);
    Pathfinder.writeToCSV(RobotMap.leftTrajectory, modifier.getLeftTrajectory());
    Pathfinder.writeToCSV(RobotMap.rightTrajectory, modifier.getRightTrajectory());
  }

  @Override
  protected void execute() {

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

  protected double convertInchesToMeters(double in) {
    return in * 0.0254;
  }
}