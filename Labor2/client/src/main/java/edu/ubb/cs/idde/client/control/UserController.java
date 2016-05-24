/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.client.control;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import edu.ubb.cs.idde.server.model.User;
import edu.ubb.cs.idde.server.service.ServiceException;
import edu.ubb.cs.idde.server.service.ServiceManager;
import edu.ubb.cs.idde.client.gui.GUI;
import edu.ubb.cs.idde.client.i18n.TextProvider;

public class UserController {

	private GUI gui;
	
	public UserController(GUI gui) {
		this.gui = gui;
	}
	
	public List<User> getAllUsers() {
		List<User> users = new LinkedList<User>();
		
		try {
			users = ServiceManager.getUserService().getAllUsers();
		} catch (ServiceException e) {
			JOptionPane.showMessageDialog(gui, TextProvider.getValue("Operations.getUsersError"), TextProvider.getValue("Operations.errorTitle"), JOptionPane.ERROR_MESSAGE);
		}
		
		return users;
	}
}
