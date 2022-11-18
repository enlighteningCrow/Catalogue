package org.AOOPProject;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class IconButton extends JButton {
    // TODO: Test if necessary to overload active for icons
    Icon icon;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        this.setIcon(icon);
        this.revalidate();
    }

    public void setIcon(File icon) {
        setIcon(new ImageIcon(icon.getName()));
    }
}
