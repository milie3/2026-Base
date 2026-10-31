package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class TalonCommandHalf extends Command {

    public TalonCommandHalf() {
        super();
        addRequirements(Robot.talon); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        if (Robot.limitSwitch.status()){
            Robot.talon.output((Constants.PERCENT_OUTPUT_FORWARD)/2);
        }
        else Robot.talon.output(Constants.PERCENT_OUTPUT_FORWARD);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.talon.output(0);
    }
}
