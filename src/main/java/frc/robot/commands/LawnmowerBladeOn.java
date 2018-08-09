package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.LEDOutputSubsystem;
import frc.robot.subsystems.LawnmowerBladeSubsystem;

public class LawnmowerBladeOn extends InstantCommand {

  LawnmowerBladeSubsystem lawnmowerBladeSubsystem;
  LEDOutputSubsystem ledOutputSubsystem;

  public LawnmowerBladeOn() {
    
  }

  @Override
  protected void initialize() {
    setTimeout(30);
  }

  @Override
  protected void execute() {
    lawnmowerBladeSubsystem.on();
    ledOutputSubsystem.on();
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    lawnmowerBladeSubsystem.off();
    ledOutputSubsystem.off();
  }

  @Override
  protected void interrupted() {
    lawnmowerBladeSubsystem.off();
    ledOutputSubsystem.off();
  }
}