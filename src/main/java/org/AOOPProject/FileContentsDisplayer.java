/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.AOOPProject;

/**
 *
 * @author twistingcamel
 */
public class FileContentsDisplayer extends javax.swing.JPanel {

	/**
	 * Creates new form FileContentsDisplayer
	 */
	public FileContentsDisplayer() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                java.awt.GridBagConstraints gridBagConstraints;

                jScrollPane1 = new javax.swing.JScrollPane();
                jList1 = new javax.swing.JList<>();
                jScrollPane2 = new javax.swing.JScrollPane();
                jList2 = new javax.swing.JList<>();
                jScrollPane3 = new javax.swing.JScrollPane();
                jList3 = new javax.swing.JList<>();

                setLayout(new java.awt.GridBagLayout());

                jList1.setModel(new javax.swing.AbstractListModel<String>() {
                        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                        public int getSize() { return strings.length; }
                        public String getElementAt(int i) { return strings[i]; }
                });
                jScrollPane1.setViewportView(jList1);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 1.0;
                add(jScrollPane1, gridBagConstraints);

                jList2.setModel(new javax.swing.AbstractListModel<String>() {
                        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                        public int getSize() { return strings.length; }
                        public String getElementAt(int i) { return strings[i]; }
                });
                jScrollPane2.setViewportView(jList2);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 1.0;
                add(jScrollPane2, gridBagConstraints);

                jList3.setModel(new javax.swing.AbstractListModel<String>() {
                        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                        public int getSize() { return strings.length; }
                        public String getElementAt(int i) { return strings[i]; }
                });
                jScrollPane3.setViewportView(jList3);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 1.0;
                add(jScrollPane3, gridBagConstraints);
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JList<String> jList1;
        private javax.swing.JList<String> jList2;
        private javax.swing.JList<String> jList3;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        // End of variables declaration//GEN-END:variables
}
