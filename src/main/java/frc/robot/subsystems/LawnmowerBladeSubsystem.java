package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class LawnmowerBladeSubsystem extends Subsystem {

  public static VictorSP motor5;

  public LawnmowerBladeSubsystem() {
    motor5 = new VictorSP(RobotMap.motor5);
  }

  @Override
  public void initDefaultCommand() {

  }

  public static void on() {
    motor5.set(1.0);
  }

  public static void off() {
    motor5.set(0.0);
  }
}