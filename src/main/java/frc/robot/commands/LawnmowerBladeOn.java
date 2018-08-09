package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.LEDOutputSubsystem;
import frc.robot.subsystems.LawnmowerBladeSubsystem;

public class LawnmowerBladeOn extends InstantCommand {
  public LawnmowerBladeOn() {
    requires(new LawnmowerBladeSubsystem());
    requires(new LEDOutputSubsystem());
    setTimeout(30);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    LawnmowerBladeSubsystem.on();
    LEDOutputSubsystem.on();
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    LawnmowerBladeSubsystem.off();
    LEDOutputSubsystem.off();
  }

  @Override
  protected void interrupted() {
    LawnmowerBladeSubsystem.off();
    LEDOutputSubsystem.off();
  }
}