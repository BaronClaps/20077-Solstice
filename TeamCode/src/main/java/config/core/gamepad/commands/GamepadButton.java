package config.core.gamepad.commands;


import androidx.annotation.NonNull;

import config.core.gamepad.ExGamepad;
import config.core.gamepad.GamepadKeys;


/**
 * A {@link Button} that gets its state from a {@link GamepadEx}.
 *
 * @author Jackson
 */
public class GamepadButton extends Button {

    private final ExGamepad m_gamepad;
    private final GamepadKeys.Button[] m_buttons;

    /**
     * Creates a gamepad button for triggering commands.
     *
     * @param gamepad the gamepad with the buttons
     * @param buttons the specified buttons
     */
    public GamepadButton(ExGamepad gamepad, @NonNull GamepadKeys.Button... buttons) {
        m_gamepad = gamepad;
        m_buttons = buttons;
    }

    /**
     * Gets the value of the joystick button.
     *
     * @return The value of the joystick button
     */
    @Override
    public boolean get() {
        boolean res = true;
        for (GamepadKeys.Button button : m_buttons)
            res = res && m_gamepad.getButton(button);
        return res;
    }

}
