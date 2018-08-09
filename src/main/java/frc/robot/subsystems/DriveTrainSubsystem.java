package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoysticks;

public class DriveTrainSubsystem extends Subsystem {

  public static Spark motor1, motor2, motor3, motor4;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveWithJoysticks());
  }

  public DriveTrainSubsystem() {
    motor1 = new Spark(RobotMap.motor1);
    motor2 = new Spark(RobotMap.motor2);
    motor3 = new Spark(RobotMap.motor3);
    motor4 = new Spark(RobotMap.motor4);
  }

  public static void drive(double leftVal, double rightVal) {
    motor1.set(leftVal);
    motor2.set(leftVal);
    motor3.set(rightVal);
    motor4.set(rightVal);
  }
}