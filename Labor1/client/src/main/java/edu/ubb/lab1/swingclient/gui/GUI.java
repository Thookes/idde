/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.swingclient.gui;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import edu.ubb.lab1.backend.model.User;
import edu.ubb.lab1.swingclient.control.UserController;
import edu.ubb.lab1.swingclient.gui.model.UserTable;
import edu.ubb.lab1.swingclient.gui.model.UserTableModel;
import edu.ubb.lab1.swingclient.util.TextProvider;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 600, HEIGHT = 300;

	private static UserController userController;

	private final GUI gui = this;

	private JPanel basePanel;
	private JMenuBar menuBar;
	private JMenu operations;
	private JMenuItem refresh;
	private UserTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;
	
	JButton exportButton, importButton;

	public GUI() {
		userController = new UserController(this);

		this.setBounds (((GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices())[0].getDisplayMode().getWidth() - WIDTH)/2,
				((GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices())[0].getDisplayMode().getHeight() - HEIGHT)/2,
				WIDTH, HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		basePanel = new JPanel();
		basePanel.setLayout(new BorderLayout());
		this.setContentPane(basePanel);

		createMenu();
		createUsersTable();
		setLanguage();

		this.setVisible(true);
	}

	// Sets the menu of the frame
	private void createMenu () {
		menuBar = new JMenuBar();

		operations = new JMenu();

		refresh = new JMenuItem();
		refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.refreshDatabaseTable();
			}
		});
		operations.add(refresh);
		menuBar.add(operations);

		this.setJMenuBar(menuBar);
	}

	// Create table to display users
	private void createUsersTable() {
		table = new UserTable();
		tableModel = (UserTableModel) table.getModel();
		scrollPane = new JScrollPane(table);

		basePanel.add(scrollPane, BorderLayout.CENTER);
	}
	
	public JTable getTable() {
		return table;
	}

	// Set language based on corresponding .properties file
	private void setLanguage() {
		this.setTitle(TextProvider.getValue("MainFrame.title"));
		operations.setText(TextProvider.getValue("MainFrame.operationsButton"));
		refresh.setText(TextProvider.getValue("MainFrame.refreshButton"));

		tableModel.setColumnIdentifiers(new String[] {
				TextProvider.getValue("MainFrame.tableIDColumn"),
				TextProvider.getValue("MainFrame.tableNameColumn"),
				TextProvider.getValue("MainFrame.tableUsernameColumn"),
		});
		for (int i = 0; i < tableModel.getColumnCount(); i++) {
			int columnIndexToView = table.convertColumnIndexToView(i);
			if (columnIndexToView >= 0) {
				TableColumn tc = table.getColumnModel().getColumn(columnIndexToView);
				switch (i) {
				case 1:
					tc.setHeaderValue(TextProvider.getValue("MainFrame.tableNameColumn"));
					break;
				case 2:
					tc.setHeaderValue(TextProvider.getValue("MainFrame.tableUsernameColumn"));
					break;
				}
			}
		}
		repaint();
	}

	// Refresh database
	public void refreshDatabaseTable() {
		List<User> l = userController.getAllUsers();
		refreshDatabaseTable(l);
	}
	
	public void refreshDatabaseTable(List<User> l) {
		tableModel.setRowCount(0);
		if (l.size() > 0) {
			for (int i = 0; i < l.size(); i++) {
				User user = l.get(i);
				tableModel.addRow(new Object[]{user.getID(), user.getName(), user.getUsername()});
			}
			table.setRowSelectionInterval(0, 0);
		}
	}

	public static void main(String args[]) {
		new GUI();
	}
}
