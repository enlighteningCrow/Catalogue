// package org.AOOPProject;

// import java.util.ArrayList;

// import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

// public class NavigationHistory {
// ArrayList<DirectoryShownFiles> history;
// PopulatorColumnsBridge bridge;

// public NavigationHistory(ArrayList<DirectoryShownFiles> history,
// PopulatorColumnsBridge bridge) {
// this.history = history;
// this.bridge = bridge;
// if (bridge.history != null)
// System.err.println("Warning: The bridge's history is not null");
// bridge.history = this;
// }

// public void doFunc(NavigationHistoryAcessor accessor) {
// accessor.manipulateHistory();
// bridge.update();
// }
// }
