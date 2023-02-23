package hostelmanagementsystem;

import java.awt.Component;
import javax.swing.JTextField;

public class Transparent 
{

    public Transparent(Component[] comp) 
    {
        for (int x = 0; x < comp.length; x++) {
            if (comp[x] instanceof javax.swing.plaf.metal.MetalComboBoxButton) {

                ((javax.swing.plaf.metal.MetalComboBoxButton) comp[x]).setOpaque(false);

                ((javax.swing.plaf.metal.MetalComboBoxButton) comp[x]).setBorder(null);
            } else if (comp[x] instanceof JTextField) {
                ((JTextField) comp[x]).setOpaque(false);
                ((JTextField) comp[x]).setBorder(null);
            }
        }
    }
}
