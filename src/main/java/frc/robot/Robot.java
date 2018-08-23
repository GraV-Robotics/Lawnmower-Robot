package frc.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DataLogger;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.LawnmowerBladeOn;
import frc.robot.commands.LightRelayOn;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LEDOutputSubsystem;
import frc.robot.subsystems.LawnmowerBladeSubsystem;
import frc.robot.subsystems.LightRelaySubsystem;

public class Robot extends TimedRobot {
  public static OI oi;
  public static LEDOutputSubsystem ledOutputSubsystem;
  public static DriveTrainSubsystem driveTrainSubsystem;
  public static DataLogger dataLogger;
  public static LawnmowerBladeSubsystem lawnmowerBladeSubsystem;
  public static LightRelaySubsystem lightRelaySubsystem;
  public static DriveWithJoysticks driveWithJoysticks;
  public static PowerDistributionPanel pdp = new PowerDistributionPanel();

  @Override
  public void robotInit() {
    oi = new OI();
    ledOutputSubsystem = new LEDOutputSubsystem();
    driveTrainSubsystem = new DriveTrainSubsystem();
    lawnmowerBladeSubsystem = new LawnmowerBladeSubsystem();
    lightRelaySubsystem = new LightRelaySubsystem();
    // CameraServer.getInstance().startAutomaticCapture();
    
  }

  @Override
  public void robotPeriodic() {
    // SmartDashboard.putBoolean("DIO STATE: ", ledOutputSubsystem.ledTogglePin.get());
    // SmartDashboard.putNumber("LED Current Draw: ", pdp.getCurrent(RobotMap.LEDPDPChannel));
    // SmartDashboard.putBoolean("Blade Active: ", lawnmowerBladeSubsystem.motor5.isAlive());
    // SmartDashboard.putNumber("Blade Speed in MPH: ", convertToMPH(lawnmowerBladeSubsystem.motor5.getSpeed()));
    // SmartDashboard.putNumber("Blade Current Draw: ", pdp.getCurrent(RobotMap.motor5PDPChannel));
    // SmartDashboard.putBoolean("Relay On: ", getRelayState());
    // SmartDashboard.putNumber("Light Current Draw: ", pdp.getCurrent(RobotMap.relay1PDPChannel));
    // dataLogger = new DataLogger();
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
    driveWithJoysticks = new DriveWithJoysticks();
    OI.lawnmowerButton.toggleWhenPressed(new LawnmowerBladeOn(lawnmowerBladeSubsystem, ledOutputSubsystem));
    OI.lightRelayButton.toggleWhenPressed(new LightRelayOn(lightRelaySubsystem));
  }

  @Override
  public void teleopPeriodic() {
    driveWithJoysticks.start();
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
    if (lightRelaySubsystem.relay1.get() == Relay.Value.kOn) {
      return true;
    } else {
      return false;
    }
  }
}