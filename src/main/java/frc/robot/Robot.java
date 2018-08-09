package frc.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LEDOutputSubsystem;
import frc.robot.subsystems.LawnmowerBladeSubsystem;
import frc.robot.subsystems.LightRelaySubsystem;

public class Robot extends TimedRobot {
  public static OI m_oi;
  public static LEDOutputSubsystem ledOutputSubsystem;
  public static DriveTrainSubsystem driveTrainSubsystem;
  PowerDistributionPanel pdp = new PowerDistributionPanel();

  @Override
  public void robotInit() {
    m_oi = new OI();
    ledOutputSubsystem = new LEDOutputSubsystem();
    driveTrainSubsystem = new DriveTrainSubsystem();
    CameraServer.getInstance().startAutomaticCapture();
    
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putBoolean("DIO STATE: ", LEDOutputSubsystem.ledTogglePin.get());
    SmartDashboard.putNumber("LED Current Draw: ", pdp.getCurrent(RobotMap.LEDPDPChannel));
    SmartDashboard.putBoolean("Blade Active: ", LawnmowerBladeSubsystem.motor5.isAlive());
    SmartDashboard.putNumber("Blade Speed in MPH: ", convertToMPH(LawnmowerBladeSubsystem.motor5.getSpeed()));
    SmartDashboard.putNumber("Blade Current Draw: ", pdp.getCurrent(RobotMap.LawnmowerPDPChannel));
    SmartDashboard.putBoolean("Relay On: ", getRelayState());
    SmartDashboard.putNumber("Light Current Draw: ", pdp.getCurrent(RobotMap.LightPDPChannel));
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

  // I know this isn't 100% accurate, but its a decent enough estimation for my purpose.
  public double convertToMPH(double power) {
    int tempInt = 13180;
    return ((power * tempInt) * 60) / 5280;
  }

  public boolean getRelayState() {
    if (LightRelaySubsystem.relay1.get() == Relay.Value.kOn) {
      return true;
    } else {
      return false;
    }
  }
}