package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LEDOutputSubsystem;
import frc.robot.subsystems.LawnmowerBladeSubsystem;
import frc.robot.subsystems.LightRelaySubsystem;

public class Robot extends TimedRobot {
  public static OI m_oi;
  public static LEDOutputSubsystem ledOutputSubsystem;
  public static DriveTrainSubsystem driveTrainSubsystem;

  @Override
  public void robotInit() {
    m_oi = new OI();
    ledOutputSubsystem = new LEDOutputSubsystem();
    driveTrainSubsystem = new DriveTrainSubsystem();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}