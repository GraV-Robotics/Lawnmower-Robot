package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.LightRelaySubsystem;

public class LightRelayOn extends Command {

LightRelaySubsystem lightRelaySubsystem;

  public LightRelayOn(LightRelaySubsystem lightRelay) {
    lightRelaySubsystem = lightRelay;
  }

  @Override
  protected void initialize() {
    setTimeout(60);
  }

  @Override
  protected void execute() {
    lightRelaySubsystem.on();
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    lightRelaySubsystem.off();
  }

  @Override
  protected void interrupted() {
    lightRelaySubsystem.off();
  }
}