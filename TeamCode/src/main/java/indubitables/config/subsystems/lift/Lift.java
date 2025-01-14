package indubitables.config.subsystems.lift;

import static indubitables.config.core.RobotConstants.liftToHighBucket;
import static indubitables.config.core.RobotConstants.liftToZero;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import indubitables.config.core.hardware.CachedMotor;

/** @author Baron Henderson
 * @version 2.0 | 1/4/25
 */

public class Lift extends SubsystemBase {

    private Telemetry telemetry;
    public CachedMotor rightLift, leftLift;
    public int pos;
    public PIDController pid;
    public static int target;
    public static double p = 0.01, i = 0, d = 0, f = 0.005;


    public Lift(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        rightLift = hardwareMap.get(CachedMotor.class, "rightLift");
        leftLift = hardwareMap.get(CachedMotor.class, "leftLift");

        rightLift.setDirection(DcMotor.Direction.FORWARD);
        leftLift.setDirection(DcMotor.Direction.REVERSE);
        rightLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        pid = new PIDController(p, i, d);

        register();
    }

    public void update() {
        pid.setPID(p,i,d);

        rightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        leftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        double pid_output = pid.calculate(getPos(), target);
        double power = pid_output + f;

        if(getPos() < 50 && target < 50) {
            rightLift.setPower(0);
            leftLift.setPower(0);
        } else {
            rightLift.setPower(power);
            leftLift.setPower(power);
        }
    }

    public void setTarget(int b) {
        target = b;
    }

    public int getPos() {
        pos = rightLift.getPosition();
        return rightLift.getPosition();
    }

    public void init() {
        pid.setPID(p,i,d);
    }

    public void start() {
        target = 0;
    }

    public void toZero() {
        setTarget(liftToZero);
    }

    public void toHighBucket() {
        setTarget(liftToHighBucket);
    }

    public void telemetry() {
        telemetry.addData("Lift Pos: ", getPos());
        telemetry.addData("Lift Target: ", target);
    }

    @Override
    public void periodic() {
        update();
        telemetry();
    }
}
