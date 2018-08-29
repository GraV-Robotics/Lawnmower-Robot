package frc.robot;

import java.io.File;

public class RobotMap {

  public static int joystick1 = 1;
  public static int joystick2 = 0;
  public static int lawnmowerBladeButton = 1;
  public static int lightRelayButton = 2;
  public static int ledSwitch = 0;
  public static int motor1 = 3;
  public static int motor2 = 4;
  public static int motor3 = 1;
  public static int motor4 = 2;
  public static int motor5 = 0;
  public static int leftEncoder[] = {0, 1};
  public static int rightEncoder[] = {2, 3};
  public static int relay1 = 0;
  public static int motor1PDPChannel = 0;
  public static int motor2PDPChannel = 1;
  public static int motor3PDPChannel = 2;
  public static int motor4PDPChannel = 3;
  public static int motor5PDPChannel = 4;
  public static int relay1PDPChannel = 5;
  public static int LEDPDPChannel = 6;
  public static int driveTrainEncoderPulses = 1440;
  public static double driveTrainGearReduction = 15 / 22;
  public static int driveTrainWheelSize = 3;
  public static int wheelBaseWidth = 20;
  public static double inchToMeterConversionVal = 0.0254;
  public static double encoderDistancePerPulse = ((driveTrainGearReduction * (driveTrainWheelSize * Math.PI)) / driveTrainEncoderPulses);
  public static File leftTrajectory = new File("LeftTrajectory.csv");
  public static File rightTrajectory = new File("RightTrajectory.csv");
  public static double maxVelocityMetersPerSecond = 1.7;
}