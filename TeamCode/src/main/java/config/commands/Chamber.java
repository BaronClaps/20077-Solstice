package config.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.pedropathing.util.Timer;

import config.core.Robot;

public class Chamber extends CommandBase {
    private final Robot robot;

    private int state = 0;
    private Timer timer = new Timer();

    public Chamber(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void initialize() {
        setState(1);
    }

    @Override
    public void execute() {
        switch (state) {
            case 1:
                robot.getO().specimenScore180();
                robot.getE().toZero();
                setState(2);
                break;
            case 2:
                if (!robot.getF().isBusy()) {
                    robot.getO().open();
                    setState(3);
                }
                break;
            case 3:
                if(timer.getElapsedTimeSeconds() > 0.25) {
                    robot.getO().hang();
                    robot.getO().open();
                    setState(-1);
                }
                break;
        }
    }

    @Override
    public boolean isFinished() {
        return state == -1;
    }

    public void setState(int x) {
        state = x;
        timer.resetTimer();
    }

}

