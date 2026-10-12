package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;
import team.gif.robot.subsystems.drivers.swerve.SparkMaxDriveMotor;

public class SparkMaxVoltage extends Command {

    public SparkMaxVoltage() {
        super();
        addRequirements(Robot.neoMotor);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {Robot.neoMotor.voltage(Constants.VOLTAGE_SPARK_MAX);}

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return true;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {Robot.neoMotor.voltage(0);}
}
