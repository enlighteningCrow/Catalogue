/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.AOOPProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonsNavigationPanel = new javax.swing.JPanel();
        dirUpButton2 = new javax.swing.JButton();
        labelsNavigationPanel = new javax.swing.JPanel();
        pathString = new javax.swing.JTextField();
        typesScrollPanel = new javax.swing.JScrollPane();
        typesPanel = new javax.swing.JPanel();
        Downloads = new javax.swing.JButton();
        Pictures = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        displayersTab = new javax.swing.JTabbedPane();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        menuEdit = new javax.swing.JMenu();
        settingsJsonMenuItem = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();
        viewModeMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuNavigate = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuSettings = new javax.swing.JMenu();
        menuHelp = new javax.swing.JMenu();

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

        buttonsNavigationPanel.setName("buttonsNavigationPanel"); // NOI18N

        dirUpButton2.setText("+");
        dirUpButton2.setMaximumSize(new java.awt.Dimension(30, 30));
        dirUpButton2.setMinimumSize(new java.awt.Dimension(30, 30));
        dirUpButton2.setName("dirUpButton2"); // NOI18N
        dirUpButton2.setPreferredSize(new java.awt.Dimension(30, 30));
        dirUpButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirUpButton2ActionPerformed(evt);
            }
        });
        buttonsNavigationPanel.add(dirUpButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(buttonsNavigationPanel, gridBagConstraints);

        labelsNavigationPanel.setName("labelsNavigationPanel"); // NOI18N
        labelsNavigationPanel.setLayout(new java.awt.GridLayout(1, 0));

        pathString.setText("jTextField1");
        pathString.setName("pathString"); // NOI18N
        labelsNavigationPanel.add(pathString);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(labelsNavigationPanel, gridBagConstraints);

        typesScrollPanel.setName("typesScrollPanel"); // NOI18N

        typesPanel.setName("typesPanel"); // NOI18N
        typesPanel.setLayout(new javax.swing.BoxLayout(typesPanel, javax.swing.BoxLayout.Y_AXIS));

        Downloads.setText("Downloads");
        Downloads.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Downloads.setMaximumSize(new java.awt.Dimension(10000, 31));
        Downloads.setMinimumSize(new java.awt.Dimension(10000, 31));
        Downloads.setName("Downloads"); // NOI18N
        Downloads.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                DownloadsAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Downloads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadsActionPerformed(evt);
            }
        });
        typesPanel.add(Downloads);

        Pictures.setText("Pictures");
        Pictures.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Pictures.setMaximumSize(new java.awt.Dimension(10000, 31));
        Pictures.setMinimumSize(new java.awt.Dimension(10000, 31));
        Pictures.setName("Pictures"); // NOI18N
        typesPanel.add(Pictures);

        jButton6.setText("jButton6");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setMaximumSize(new java.awt.Dimension(10000, 31));
        jButton6.setMinimumSize(new java.awt.Dimension(10000, 31));
        jButton6.setName("jButton6"); // NOI18N
        typesPanel.add(jButton6);

        typesScrollPanel.setViewportView(typesPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(typesScrollPanel, gridBagConstraints);

        displayersTab.setName("displayersTab"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(displayersTab, gridBagConstraints);

        menuBar.setName("menuBar"); // NOI18N

        menuFile.setText("File");
        menuFile.setName("menuFile"); // NOI18N

        jMenu1.setText("Insert whatever menus needed here");
        jMenu1.setName("jMenu1"); // NOI18N
        menuFile.add(jMenu1);

        menuBar.add(menuFile);

        menuEdit.setText("Edit");
        menuEdit.setName("menuEdit"); // NOI18N

        settingsJsonMenuItem.setText("Edit Paths JSON");
        settingsJsonMenuItem.setName("settingsJsonMenuItem"); // NOI18N
        menuEdit.add(settingsJsonMenuItem);

        menuBar.add(menuEdit);

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

        jMenuItem4.setText("Etc.");
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        viewModeMenu.add(jMenuItem4);

        menuView.add(viewModeMenu);

        menuBar.add(menuView);

        menuNavigate.setText("Navigate");
        menuNavigate.setName("menuNavigate"); // NOI18N

        jMenu2.setText("Same as the navigation buttons to the left");
        jMenu2.setName("jMenu2"); // NOI18N
        menuNavigate.add(jMenu2);

        menuBar.add(menuNavigate);

        menuSettings.setText("Settings");
        menuSettings.setName("menuSettings"); // NOI18N
        menuBar.add(menuSettings);

        menuHelp.setText("Help");
        menuHelp.setName("menuHelp"); // NOI18N
        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dirUpButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirUpButton2ActionPerformed
        // TODO add your handling code here:
        //add a directory to typesPanel
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setMultiSelectionEnabled(true);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = chooser.getSelectedFiles();
            for(File file : files) {
                addType(file);
            }
        }

    }//GEN-LAST:event_dirUpButton2ActionPerformed

        private void addType(File file) {
        //add a directory to typesPanel
        String name = file.getName();
        JButton button = new JButton(name);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setMaximumSize(new Dimension(10000, 31));
        button.setMinimumSize(new Dimension(10000, 31));
        button.setName(name);
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeButtonActionPerformed(evt);
            }
        });
        typesPanel.add(button);
        typesPanel.revalidate();
        typesPanel.repaint();
        
}

        protected void typeButtonActionPerformed(ActionEvent evt) {
        }

        private void DownloadsAncestorAdded(javax.swing.event.AncestorEvent evt) {// GEN-FIRST:event_DownloadsAncestorAdded
                // TODO add your handling code here:
        }// GEN-LAST:event_DownloadsAncestorAdded

        /**
         * TODO: Use this as an example to implement the rest of the buttons, hard coded
         * AND
         * autogenerated (from roots (on unix/linux/mac -> "/", on windows -> "C:",
         * "D:", "E:", "<whatever is detected>"))
         * AND written in the JSON by the user (Edit->Edit Paths JSON in the menubar)
         */
        private void DownloadsActionPerformed(java.awt.event.ActionEvent evt) {
                Component selectedComponent = displayersTab.getSelectedComponent();
                if (!(selectedComponent instanceof FileContentsDisplayer)) {
                        throw new RuntimeException("This tab does not contain an instance of FileContentsDisplayer");
                }
                FileContentsDisplayer disp = (FileContentsDisplayer) selectedComponent;
                // TODO: Continue this
                // disp.handler.notify();
                // TODO: Try and catch out of bounds exception : (when active column is null or
                // is not in listPanes)
                disp.bridge.setFirstColumnDirectory(
                                new FileSystemPopulator(disp, "Downloads", GlobFileFilter.class,
                                                new String[] { "~/Downloads/*" }));
        }// GEN-LAST:event_DownloadsActionPerformed

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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(MainWindow.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(MainWindow.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(MainWindow.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(MainWindow.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new MainWindow().setVisible(true);
                        }
                });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Downloads;
    private javax.swing.JButton Pictures;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel buttonsNavigationPanel;
    private javax.swing.JButton dirUpButton2;
    private javax.swing.JTabbedPane displayersTab;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel labelsNavigationPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuNavigate;
    private javax.swing.JMenu menuSettings;
    private javax.swing.JMenu menuView;
    private javax.swing.JTextField pathString;
    private javax.swing.JMenuItem settingsJsonMenuItem;
    private javax.swing.JPanel typesPanel;
    private javax.swing.JScrollPane typesScrollPanel;
    private javax.swing.JMenu viewModeMenu;
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
}
