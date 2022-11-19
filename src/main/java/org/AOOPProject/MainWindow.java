/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.AOOPProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.*;

/**
 *
 * @author twistingcamel
 */
public class MainWindow extends javax.swing.JFrame {
	/**
	 * Creates new form MainWindow
	 */
	public MainWindow() {
		initComponents();
		((FileContentsDisplayer) displayersTab.getComponentAt(0)).update();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonsNavigationPanel = new javax.swing.JPanel();
        dirBackButton = new DirBackButton(this);
        dirForwardButton1 = new DirForwardButton(this);
        dirUpButton = new DirUpButton(this);
        typeAddButton = new javax.swing.JButton();
        pathNavigationPanel = new javax.swing.JPanel();
        pathScrollPane = new javax.swing.JScrollPane();
        pathPanel = new javax.swing.JPanel();
        typesScrollPanel = new javax.swing.JScrollPane();
        typesPanel = new javax.swing.JPanel();
        Downloads = null;
        Pictures = null;
        displayersTab = new javax.swing.JTabbedPane();
        fileContentsDisplayer1 = new org.AOOPProject.FileContentsDisplayer(new File[]{new File("~"), new File("~/Downloads"), new File("~/Pictures")});
        menuBar = new javax.swing.JMenuBar();
        menuEdit = new javax.swing.JMenu();
        settingsJsonMenuItem = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();
        viewModeMenu = new javax.swing.JMenu();
        jMenuItem1 = new ViewMenuItem(this, new IconsOnlyView());
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new ViewMenuItem(this, new DetailsView());
        viewModeMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setName("jList1"); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jButton3.setText("jButton3");
        jButton3.setName("jButton3"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Form"); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        buttonsNavigationPanel.setBorder(new com.formdev.flatlaf.ui.FlatBorder());
        buttonsNavigationPanel.setName("buttonsNavigationPanel"); // NOI18N

        dirBackButton.setText("<");
        dirBackButton.setMaximumSize(new java.awt.Dimension(30, 30));
        dirBackButton.setMinimumSize(new java.awt.Dimension(30, 30));
        dirBackButton.setName("dirBackButton"); // NOI18N
        dirBackButton.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonsNavigationPanel.add(dirBackButton);

        dirForwardButton1.setText(">");
        dirForwardButton1.setMaximumSize(new java.awt.Dimension(30, 30));
        dirForwardButton1.setMinimumSize(new java.awt.Dimension(30, 30));
        dirForwardButton1.setName("dirForwardButton1"); // NOI18N
        dirForwardButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonsNavigationPanel.add(dirForwardButton1);

        dirUpButton.setText("^");
        dirUpButton.setMaximumSize(new java.awt.Dimension(30, 30));
        dirUpButton.setMinimumSize(new java.awt.Dimension(30, 30));
        dirUpButton.setName("dirUpButton"); // NOI18N
        dirUpButton.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonsNavigationPanel.add(dirUpButton);

        typeAddButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        typeAddButton.setText("+");
        typeAddButton.setBorder(null);
        typeAddButton.setMaximumSize(new java.awt.Dimension(30, 30));
        typeAddButton.setMinimumSize(new java.awt.Dimension(30, 30));
        typeAddButton.setName("typeAddButton"); // NOI18N
        typeAddButton.setPreferredSize(new java.awt.Dimension(30, 30));
        typeAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeAddButtonActionPerformed(evt);
            }
        });
        buttonsNavigationPanel.add(typeAddButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(buttonsNavigationPanel, gridBagConstraints);

        pathNavigationPanel.setBorder(new com.formdev.flatlaf.ui.FlatMenuBarBorder());
        pathNavigationPanel.setName("pathNavigationPanel"); // NOI18N
        pathNavigationPanel.setLayout(new java.awt.GridLayout(1, 0));

        pathScrollPane.setName("pathScrollPane"); // NOI18N

        pathPanel.setName("pathPanel"); // NOI18N
        pathScrollPane.setViewportView(pathPanel);

        pathNavigationPanel.add(pathScrollPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(pathNavigationPanel, gridBagConstraints);

        typesScrollPanel.setName("typesScrollPanel"); // NOI18N

        typesPanel.setBorder(new com.formdev.flatlaf.ui.FlatBorder());
        typesPanel.setName("typesPanel"); // NOI18N
        typesPanel.setLayout(new javax.swing.BoxLayout(typesPanel, javax.swing.BoxLayout.Y_AXIS));

        Downloads = new ExactNavigationButton(this, new RealFileSystemPopulator("Downloads", "~/Downloads"));
        Downloads.setText("Downloads");
        Downloads.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Downloads.setMaximumSize(new java.awt.Dimension(10000, 31));
        Downloads.setMinimumSize(new java.awt.Dimension(10000, 31));
        Downloads.setName("Downloads"); // NOI18N
        typesPanel.add(Downloads);

        Pictures = new ExactNavigationButton(this, new VirtualFileSystemPopulator("Pictures", GlobFileFilter.class, new String[]{"~/Downloads/*.jpeg", "~/Downloads/*.png", "~/Pictures/*.jpeg", "~/Pictures/*.png", "~/Downloads/*image*", "~/Pictures/*image*"}));
        Pictures.setText("Pictures");
        Pictures.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Pictures.setMaximumSize(new java.awt.Dimension(10000, 31));
        Pictures.setMinimumSize(new java.awt.Dimension(10000, 31));
        Pictures.setName("Pictures"); // NOI18N
        typesPanel.add(Pictures);

        typesScrollPanel.setViewportView(typesPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(typesScrollPanel, gridBagConstraints);

        displayersTab.setName("displayersTab"); // NOI18N
        displayersTab.addTab("tab1", fileContentsDisplayer1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(displayersTab, gridBagConstraints);

        menuBar.setBackground(new java.awt.Color(39, 43, 51));
        menuBar.setBorder(null);
        menuBar.setForeground(new java.awt.Color(39, 43, 51));
        menuBar.setToolTipText("");
        menuBar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        menuBar.setName("menuBar"); // NOI18N

        menuEdit.setBackground(new java.awt.Color(39, 43, 51));
        menuEdit.setText("Edit");
        menuEdit.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        menuEdit.setName("menuEdit"); // NOI18N

        settingsJsonMenuItem.setText("Edit Paths JSON");
        settingsJsonMenuItem.setName("settingsJsonMenuItem"); // NOI18N
        menuEdit.add(settingsJsonMenuItem);

        menuBar.add(menuEdit);

        menuView.setBackground(new java.awt.Color(39, 43, 51));
        menuView.setText("View");
        menuView.setName("menuView"); // NOI18N

        viewModeMenu.setText("View mode");
        viewModeMenu.setName("viewModeMenu"); // NOI18N

        jMenuItem1.setText("Icons only");
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        viewModeMenu.add(jMenuItem1);

        jMenuItem2.setText("Compact");
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        viewModeMenu.add(jMenuItem2);

        jMenuItem3.setText("Details");
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        viewModeMenu.add(jMenuItem3);

        menuView.add(viewModeMenu);

        viewModeMenu1.setText("Theme");
        viewModeMenu1.setName("viewModeMenu1"); // NOI18N

        jMenuItem6.setText("Light");
        jMenuItem6.setName("LightTheme"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        viewModeMenu1.add(jMenuItem6);

        jMenuItem7.setText("Dark");
        jMenuItem7.setName("DarkTheme"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        viewModeMenu1.add(jMenuItem7);

        menuView.add(viewModeMenu1);

        menuBar.add(menuView);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	// dark theme
	private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem7ActionPerformed
		// TODO add your handling code here:
		typesPanel.setBackground(new java.awt.Color(39, 43, 51));
		typesScrollPanel.setBackground(new java.awt.Color(39, 43, 51));
		displayersTab.setBackground(new java.awt.Color(39, 43, 51));
		fileContentsDisplayer1.setBackground(new java.awt.Color(39, 43, 51));
		buttonsNavigationPanel.setBackground(new java.awt.Color(39, 43, 51));
		menuBar.setBackground(new java.awt.Color(39, 43, 51));
		menuEdit.setBackground(new java.awt.Color(39, 43, 51));
	}// GEN-LAST:event_jMenuItem7ActionPerformed

	// light theme
	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem6ActionPerformed
		typesPanel.setBackground(new java.awt.Color(240, 240, 240));
		typesScrollPanel.setBackground(new java.awt.Color(240, 240, 240));
		displayersTab.setBackground(new java.awt.Color(240, 240, 240));
		fileContentsDisplayer1.setBackground(new java.awt.Color(240, 240, 240));
		buttonsNavigationPanel.setBackground(new java.awt.Color(240, 240, 240));
		menuBar.setBackground(new java.awt.Color(240, 240, 240));
		menuEdit.setBackground(new java.awt.Color(240, 240, 240));
	}// GEN-LAST:event_jMenuItem6ActionPerformed

	private void dirBackButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_dirBackButtonActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_dirBackButtonActionPerformed

	private void typeAddButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_dirUpButton2ActionPerformed
		// TODO add your handling code here:
		// add a directory to typesPanel
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setMultiSelectionEnabled(true);
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File[] files = chooser.getSelectedFiles();
			for (File file : files) {
				addType(file);
			}
		}
	}// GEN-LAST:event_dirUpButton2ActionPerformed

	private void addType(File file) {
		String name = file.getName();
		String path = file.getAbsolutePath();
		JButton button = new ExactNavigationButton(MainWindow.this, new RealFileSystemPopulator(new File(path)),
				name);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setMaximumSize(new Dimension(10000, 31));
		button.setMinimumSize(new Dimension(10000, 31));
		button.setName(name);
		// button.addActionListener(new java.awt.event.ActionListener() {
		// public void actionPerformed(java.awt.event.ActionEvent evt) {
		// typeButtonActionPerformed(evt, path);
		// }
		// });
		typesPanel.add(button);
		typesPanel.revalidate();
		typesPanel.repaint();

	}

	// private void typeButtonActionPerformed(java.awt.event.ActionEvent evt, String
	// path) {
	// // TODO add your handling code here:
	// // get selected directory
	// JButton button = new ExactNavigationButton(MainWindow.this, new
	// RealFileSystemPopulator(new File(path)),
	// new ArrayList<>());
	// // String name = button.getName();
	// System.out.println("Path: " + path);
	// Component selectedComponent = displayersTab.getSelectedComponent();
	// if (!(selectedComponent instanceof FileContentsDisplayer)) {
	// throw new RuntimeException("This tab does not contain an instance of
	// FileContentsDisplayer");
	// }
	// FileContentsDisplayer disp = (FileContentsDisplayer) selectedComponent;
	// // // TODO: Continue this
	// // // disp.handler.notify();
	// // // TODO: Try and catch out of bounds exception : (when active column is
	// null
	// // or
	// // // is not in listPanes)

	// // disp.bridge.setFirstColumnDirectory(
	// // new VirtualFileSystemPopulator(name, GlobFileFilter.class,
	// // new String[] { path }));

	// }

	// private void typeButtonAncestorAdded(javax.swing.event.AncestorEvent evt) {
	// }

	/**
	 * TODO: Use this as an example to implement the rest of the buttons, hard coded
	 * AND
	 * autogenerated (from roots (on unix/linux/mac -> "/", on windows -> "C:",
	 * "D:", "E:", "<whatever is detected>"))
	 * AND written in the JSON by the user (Edit->Edit Paths JSON in the menubar)
	 */

	/**
	 * @param args the command line arguments
	 */

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel.
		 * For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */

		try {
			// UIManager.setLookAndFeel(new FlatDarkLaf());
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}

		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainWindow().setVisible(true);
			}
		});
	}

	protected void typeButtonActionPerformed(ActionEvent evt) {
	}

	/**
	 * TODO: Use this as an example to implement the rest of the buttons, hard coded
	 * AND
	 * autogenerated (from roots (on unix/linux/mac -> "/", on windows -> "C:",
	 * "D:", "E:", "<whatever is detected>"))
	 * AND written in the JSON by the user (Edit->Edit Paths JSON in the menubar)
	 */
	/**
	 * @param args the command line arguments
	 */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Downloads;
    private javax.swing.JButton Pictures;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel buttonsNavigationPanel;
    private javax.swing.JButton dirBackButton;
    private javax.swing.JButton dirForwardButton1;
    private javax.swing.JButton dirUpButton;
    private javax.swing.JTabbedPane displayersTab;
    private org.AOOPProject.FileContentsDisplayer fileContentsDisplayer1;
    private javax.swing.JButton jButton3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuView;
    private javax.swing.JPanel pathNavigationPanel;
    private javax.swing.JPanel pathPanel;
    private javax.swing.JScrollPane pathScrollPane;
    private javax.swing.JMenuItem settingsJsonMenuItem;
    private javax.swing.JButton typeAddButton;
    private javax.swing.JPanel typesPanel;
    private javax.swing.JScrollPane typesScrollPanel;
    private javax.swing.JMenu viewModeMenu;
    private javax.swing.JMenu viewModeMenu1;
    // End of variables declaration//GEN-END:variables

	// TODO: Suggestion: store most of the settings into one JSON or binary format
	// TODO: Add a class to manage histories, so the app opens in the same state as
	// when it was closed (Or add some settings for that)
	// TODO: Add icons to the navigation buttons and link them to methods dealing
	// with the FileContentsDisplayer's methods (yet to be implemented) to navigate.
	// TODO: Add the needed menu items and link them to methods
	// TODO: Change the left column from the buttons to a jList with icons depicting
	// Videos, Images, Downloads, Home, Root/Drives (depending on the OS)
	// TODO: In the Edit->Edit Paths JSON, implement a way (a class or method,
	// probably should be an inner class here) to reload the left list using the
	// info in the JSON.
	// TODO: When an item in the left list is selected, the currentTab's
	// FileContentsDisplayer changes the root using the FileSystemPopulator
	// TODO: (Unsure if this is the right way to go) when the cursor is at the
	// leftmost column of the fileContentsDisplayer and the left or h key is
	// pressed, the cursor moves to the left list
	// TODO: The top text field (should probably be changed to a couple buttons in a
	// horizontal GridLayout) shows the current directory the cursor is on
	// TODO: The left column (typesPanel) should contain all the root drives (on
	// unix/linux/mac -> "/", on windows -> "C:", "D:", "E:", "<whatever is
	// detected>")

	public JPanel getPathPanel() {
		return pathPanel;
	}

	// public JTextField getPathString() {
	// return pathString;
	// }
	// TODO: Suggestion: store most of the settings into one JSON or binary format
	// TODO: Add a class to manage histories, so the app opens in the same state as
	// when it was closed (Or add some settings for that)
	// TODO: Add icons to the navigation buttons and link them to methods dealing
	// with the FileContentsDisplayer's methods (yet to be implemented) to navigate.
	// TODO: Add the needed menu items and link them to methods
	// TODO: Change the left column from the buttons to a jList with icons depicting
	// Videos, Images, Downloads, Home, Root/Drives (depending on the OS)
	// TODO: In the Edit->Edit Paths JSON, implement a way (a class or method,
	// probably should be an inner class here) to reload the left list using the
	// info in the JSON.
	// TODO: When an item in the left list is selected, the currentTab's
	// FileContentsDisplayer changes the root using the FileSystemPopulator
	// TODO: (Unsure if this is the right way to go) when the cursor is at the
	// leftmost column of the fileContentsDisplayer and the left or h key is
	// pressed, the cursor moves to the left list
	// TODO: The top text field (should probably be changed to a couple buttons in a
	// horizontal GridLayout) shows the current directory the cursor is on
	// TODO: The left column (typesPanel) should contain all the root drives (on
	// unix/linux/mac -> "/", on windows -> "C:", "D:", "E:", "<whatever is
	// detected>")
}
