package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.RobotMap;

public class DriveTrainSubsystem extends Subsystem {

  public Spark motor1, motor2, motor3, motor4;
  public Encoder leftEncoder, rightEncoder;
  public Gyro gyro;

  @Override
  public void initDefaultCommand() {
    
  }

  public DriveTrainSubsystem() {
    motor1 = new Spark(RobotMap.motor1);
    motor2 = new Spark(RobotMap.motor2);
    motor3 = new Spark(RobotMap.motor3);
    motor4 = new Spark(RobotMap.motor4);
    leftEncoder = new Encoder(RobotMap.leftEncoder[0], RobotMap.leftEncoder[1], true, EncodingType.k4X);
    rightEncoder = new Encoder(RobotMap.rightEncoder[0], RobotMap.rightEncoder[1], true, EncodingType.k4X);
    gyro = new ADXRS450_Gyro();
    gyro.calibrate();
  }

  public void drive(double leftVal, double rightVal) {
    motor1.set(-leftVal);
    motor2.set(-leftVal);
    motor3.set(-rightVal);
    motor4.set(rightVal);
  }

  public int getRawLeftEncoderPosition() {
    return leftEncoder.getRaw();
  }

  public int getRawRightEncoderPosition() {
    return rightEncoder.getRaw();
  }

  public int getLeftEncoderPosition() {
    return leftEncoder.get();
  }

  public int geRightEncoderPosition() {
    return rightEncoder.get();
  }

  public void resetLeftEncoder() {
    leftEncoder.reset();
  }

  public void resetRightEncoder() {
    rightEncoder.reset();
  }

  public void resetGyro() {
    gyro.reset();
  }

  public double getGyroRate() {
    return gyro.getRate();
  }

  public double getGyroAngle() {
    return gyro.getAngle();
  }
}