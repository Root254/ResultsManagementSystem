package sample;

import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class InputConstraints {
    public InputConstraints() {
    }

    public static void numbersOnly(final TextField textField, final Integer maxLenth) {
        textField.addEventFilter(KeyEvent.KEY_TYPED, createNumbersOnlyInputHandler(maxLenth));
        textField.focusedProperty().addListener((Observable observable) -> {
            textField.setText(textField.getText().trim());
        });
    }

    public static EventHandler<KeyEvent> createNumbersOnlyInputHandler(final Integer maxLength) {
        return createPatternInputHandler(maxLength, "[0-9.]");
    }

    public static EventHandler<KeyEvent> createPatternInputHandler(final Integer maxLength, String pattern) {
        return (KeyEvent event) -> {
            if (event.getSource() instanceof TextField) {
                TextField textField = (TextField) event.getSource();
                if (textField.getText().length() >= maxLength || !event.getCharacter().matches(pattern)) {
                    event.consume();
                }
            }
        };
    }
}
