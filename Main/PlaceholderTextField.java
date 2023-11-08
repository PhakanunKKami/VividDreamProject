package Main;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class PlaceholderTextField extends JTextField implements FocusListener {

    private String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
        this.setText(placeholder); // Set the initial text to the placeholder
        this.addFocusListener(this);
    }

    public void setPlaceholder(String newPlaceholder) {
        this.placeholder = newPlaceholder;
        this.setText(newPlaceholder);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().equals(placeholder)) {
            this.setText("");
            if(this.getBackground().equals(Color.WHITE)){
                this.setForeground(Color.BLACK);
            }
            else{
                this.setForeground(Color.WHITE);
            }
            
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            this.setText(placeholder);
        }
    }
}
