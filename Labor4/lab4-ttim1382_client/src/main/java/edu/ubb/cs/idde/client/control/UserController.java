/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.client.control;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.cs.idde.interfce.model.User;
import edu.ubb.cs.idde.interfce.service.ServiceException;
import edu.ubb.cs.idde.interfce.service.UserService;
import edu.ubb.cs.idde.client.gui.GUI;
import edu.ubb.cs.idde.client.i18n.TextProvider;

public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	private GUI gui;
	
	public UserController(GUI gui) {
		this.gui = gui;
	}
	
	public List<User> getAllUsers(BundleContext context) {
		List<User> users = new LinkedList<User>();
		
		try {
			ServiceReference<?> serviceRef = context.getServiceReference(UserService.class.getName());

			if (serviceRef != null) {
				UserService serviceObj = (UserService)context.getService(serviceRef);
				users = serviceObj.getAllUsers();
			}
			else {
				System.out.println("Service reference is null.");
				LOG.error("Service reference is null.");
			}
		} catch (ServiceException e) {
			JOptionPane.showMessageDialog(gui, TextProvider.getValue("Operations.getUsersError"), TextProvider.getValue("Operations.errorTitle"), JOptionPane.ERROR_MESSAGE);
		}
		
		return users;
	}
}
