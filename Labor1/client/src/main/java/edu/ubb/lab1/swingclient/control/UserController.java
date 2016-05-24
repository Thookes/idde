/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.swingclient.control;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import edu.ubb.lab1.backend.model.User;
import edu.ubb.lab1.backend.service.ServiceException;
import edu.ubb.lab1.backend.service.ServiceManager;
import edu.ubb.lab1.swingclient.gui.GUI;
import edu.ubb.lab1.swingclient.util.TextProvider;

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
