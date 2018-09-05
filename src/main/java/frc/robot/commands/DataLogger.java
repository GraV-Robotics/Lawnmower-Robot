package frc.robot.commands;

import java.io.IOException;
import java.io.PrintWriter;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class DataLogger extends Command {

  PrintWriter writer;
  String file;
  PowerDistributionPanel pdp;
  Long pastTime;
  Long currentTime;
  double finalTime;

  public DataLogger(PowerDistributionPanel powerDistributionPanel) {
    pdp = powerDistributionPanel;
  }

  @Override
  protected void initialize() {
    file = "logfile.txt";
    pastTime = System.currentTimeMillis();
  }

  @Override
  protected void execute() {
    try {
      writer = new PrintWriter(file);
      currentTime = System.currentTimeMillis();
      finalTime = pastTime - currentTime;
      writer.println("Motor1 Current Draw: " + pdp.getCurrent(RobotMap.motor1PDPChannel) + " time: " + finalTime + "ms");
      writer.println("Motor2 Current Draw: " + pdp.getCurrent(RobotMap.motor2PDPChannel) + " time: " + finalTime + "ms");
      writer.println("Motor3 Current Draw: " + pdp.getCurrent(RobotMap.motor3PDPChannel) + " time: " + finalTime + "ms");
      writer.println("Motor4 Current Draw: " + pdp.getCurrent(RobotMap.motor4PDPChannel) + " time: " + finalTime + "ms");
      writer.println("Motor5 Current Draw: " + pdp.getCurrent(RobotMap.motor5PDPChannel) + " time: " + finalTime + "ms");
      writer.println("LED Current Draw: " + pdp.getCurrent(RobotMap.LEDPDPChannel) + " time: " + finalTime + "ms");
      writer.println("Light Current Draw: " + pdp.getCurrent(RobotMap.relay1PDPChannel) + " time: " + finalTime + "ms");
      writer.println(" ");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}