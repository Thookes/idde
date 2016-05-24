/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.client.gui;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import org.osgi.framework.BundleContext;

import edu.ubb.cs.idde.interfce.model.User;
import edu.ubb.cs.idde.client.control.UserController;
import edu.ubb.cs.idde.client.gui.model.UserTable;
import edu.ubb.cs.idde.client.gui.model.MyTableModel;
import edu.ubb.cs.idde.client.i18n.TextProvider;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 600, HEIGHT = 300;

	public static BundleContext bundleContext;
	private static UserController userController;

	private final GUI gui = this;

	private JPanel basePanel;
	private JMenuBar menuBar;
	private JMenu operations;
	private JMenuItem refresh;
	private MyTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;

	public GUI(BundleContext bundleContext) {
		GUI.bundleContext = bundleContext;
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
		tableModel = (MyTableModel) table.getModel();
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
		
		for (int i = 0; i < tableModel.getColumnCount(); i++) {
			int columnIndexToView = table.convertColumnIndexToView(i);
			if (columnIndexToView >= 0) {
				TableColumn tc = table.getColumnModel().getColumn(columnIndexToView);
				tc.setHeaderValue(TextProvider.getValue(tableModel.getColumnName(i)));
			}
		}
		
		repaint();
	}

	// Refresh database
	public void refreshDatabaseTable() {
		List<User> l = userController.getAllUsers(bundleContext);
		refreshDatabaseTable(l);
	}
	
	public void refreshDatabaseTable(List<User> l) {
		tableModel.setRowCount(0);
		if (l.size() > 0) {
			for (int i = 0; i < l.size(); i++) {
				User user = l.get(i);
				int userFieldsNr = tableModel.getColumnCount();
				Object[] userObject = new Object[userFieldsNr];
				
				for (int j = 0; j < userFieldsNr; j++) {
					try {
						String columnName = tableModel.getColumnName(j);
						String capitalizedColumnName = columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
						String methodName;
						
						Field field = user.getClass().getDeclaredField(tableModel.getColumnName(j));
						Class<?> fieldType = field.getType();
						if (fieldType == boolean.class) {
							methodName = "is" + capitalizedColumnName;
						} else {
							methodName = "get" + capitalizedColumnName;
						}
						
						Method method = user.getClass().getDeclaredMethod(methodName);
						userObject[j] = method.invoke(user);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(this, TextProvider.getValue("MainFrame.refreshError"), TextProvider.getValue("MainFrame.refreshButton"), JOptionPane.ERROR_MESSAGE);
					}
				}
				tableModel.addRow(userObject);
			}
			table.setRowSelectionInterval(0, 0);
		}
	}
}
