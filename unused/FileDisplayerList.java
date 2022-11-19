// package org.AOOPProject;

// import java.io.File;
// import java.util.Vector;

// import javax.swing.JList;
// import javax.swing.ListModel;
// import javax.xml.transform.Source;

// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;

// public class FileDisplayerList extends JList<File> {
// void init(FileDisplayerView view) {
// setCellRenderer(view);
// view.setView(this);
// addMouseListener(new MouseAdapter() {
// public void mouseClicked(MouseEvent evt) {
// Object source = evt.getSource();
// JList<File> list = (JList<File>) source;
// switch (evt.getButton()) {
// case MouseEvent.BUTTON1:
// if (evt.getClickCount() == 2) {
// int index = list.locationToIndex(evt.getPoint());
// File selectedFile = list.getModel().getElementAt(index);
// if (selectedFile.isDirectory()) {

// }
// }
// break;
// case MouseEvent.BUTTON2:
// case MouseEvent.BUTTON3:
// // default:
// // System.out.println(evt.getButton());
// }
// // else if (evt.getClickCount() == 3) {
// // int index = list.locationToIndex(evt.getPoint());
// // }
// }
// });
// revalidate();
// repaint();
// // updateUI();
// }

// void setView(FileDisplayerView view) {
// init(view);
// }

// public FileDisplayerList(FileDisplayerView view, Vector<? extends File>
// listData) {
// super(listData);
// init(view);
// }

// public FileDisplayerList(FileDisplayerView view, File[] listData) {
// super(listData);
// init(view);
// }

// public FileDisplayerList(FileDisplayerView view, ListModel<File> dataModel) {
// super(dataModel);
// init(view);
// }

// public FileDisplayerList(FileDisplayerView view) {
// super();
// init(view);
// }

// public FileDisplayerList() {
// super();
// init(FileDisplayerView.geDefault());
// }
// }
