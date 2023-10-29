package Main;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class PlaceholderTextField extends JTextField implements FocusListener {

    private final String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
        this.setText(placeholder); // Set the initial text to the placeholder
        this.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().equals(placeholder)) {
            this.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            this.setText(placeholder);
        }
    }
}
