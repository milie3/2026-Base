// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

import static com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless;


public class SparkMaxDrive extends SubsystemBase {
    SparkMax neoMotor;
    RelativeEncoder encoder;
    PIDController pid;
    SparkMaxConfig config;


    public SparkMaxDrive() {
        config = new SparkMaxConfig();

        double kP = 0.012;
        double kI = 0;
        double kD = 0;

        neoMotor= new SparkMax(RobotMap.NEO_MOTOR, kBrushless);
        encoder = neoMotor.getEncoder();
        pid = new PIDController(kP, kI, kD);

        config.idleMode(SparkBaseConfig.IdleMode.kBrake);
        config.inverted(true);
        neoMotor.configure(config,
                ResetMode.kResetSafeParameters,
                PersistMode.kPersistParameters
        );
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

    }

    public double currentVelocity(){
        return encoder.getVelocity();
    }


}
