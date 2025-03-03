package config.core.gamepad;

public class TriggerReader implements KeyReader {

    private ExGamepad gamepad;

    private GamepadKeys.Trigger trigger;

    /**
     * Last state of the button
     **/
    private boolean lastState;

    /**
     * Current state of the button
     **/
    private boolean currState;

    /**
     * Current threshold
     **/
    private double threshold;

    /**
     * Initializes controller variables
     *
     * @param gamepad The controller joystick
     * @param trigger The controller button
     **/
    public TriggerReader(ExGamepad gamepad, GamepadKeys.Trigger trigger) {
        this(gamepad, trigger, 0.5);
    }

    public TriggerReader(ExGamepad gamepad, GamepadKeys.Trigger trigger, double threshold) {
        this.gamepad = gamepad;
        this.trigger = trigger;
        this.threshold = threshold;

        if (this.gamepad.getTrigger(trigger) > this.threshold) {
            currState = true;
        } else {
            currState = false;
        }

        lastState = currState;
    }

    /**
     * Reads button value
     **/
    public void readValue() {
        lastState = currState;
        if (this.gamepad.getTrigger(trigger) > this.threshold) {
            currState = true;
        } else {
            currState = false;
        }
    }

    /**
     * Checks if the button is down
     **/
    public boolean isDown() {
        return currState;
    }

    /**
     * Checks if the button was just pressed
     **/
    public boolean wasJustPressed() {
        return (!lastState && currState);
    }

    /**
     * Checks if the button was just released
     **/
    public boolean wasJustReleased() {
        return (lastState && !currState);
    }

    /**
     * Checks if the button state has changed
     **/
    public boolean stateJustChanged() {
        return (lastState != currState);
    }

}
