package team.gif.robot;


import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;

public abstract class RobotMap {
    // Controllers
    public static final int DRIVER_CONTROLLER_ID = 0;
    public static final int AUX_CONTROLLER_ID = 1;
    public static final int TEST_CONTROLLER_ID = 2;

    public static final int PIGEON_ID = 9;
    public static final int LIMIT_SWITCH_ID = 9;
    public static final int TALONSRX_ID = 10;
    public static final int NEO_MOTOR= 45;
}
