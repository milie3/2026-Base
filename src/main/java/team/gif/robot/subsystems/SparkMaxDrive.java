// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

import static com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless;


public class SparkMaxDrive extends SubsystemBase {
    SparkMax neoMotor;
    RelativeEncoder encoder;
    PIDController pid;
    PIDController velocityPid;
    //private static final double NEO_KV = 12.0 / 5676.0;


    public SparkMaxDrive() {
        double kP = 1;
        double kI = 0.02;
        double kD = 0;

        neoMotor= new SparkMax(RobotMap.NEO_MOTOR, kBrushless);
        encoder = neoMotor.getEncoder();
        pid = new PIDController(kP, kI, kD);
        encoder.setPosition(0);
    }

    public void voltage(double input){
        neoMotor.setVoltage(input);
    }

    public void setpoint(double input){
        voltage(pid.calculate(encoder.getPosition(), input));
    }

    public double currentPosition(){
        return encoder.getPosition();
    }

    public void rpmControl(double input){
        //voltage(input * velocityPid.calculate(encoder.getVelocity(), input));
        neoMotor.set(velocityPid.calculate(encoder.getVelocity(), input)); // NEW
// NEW
    }

    public double currentVelocity(){
        return encoder.getVelocity();
    }


    public void stopMotor() {
        neoMotor.stopMotor();
    }
}
