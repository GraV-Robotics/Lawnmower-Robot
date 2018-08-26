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
<<<<<<< HEAD
    ;
=======
    lightRelaySubsystem.on();
>>>>>>> master
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
<<<<<<< HEAD
    lightRelaySubsystem.on();
=======
    lightRelaySubsystem.off();
>>>>>>> master
  }

  @Override
  protected void interrupted() {
<<<<<<< HEAD
    
=======
    lightRelaySubsystem.off();
>>>>>>> master
  }
}