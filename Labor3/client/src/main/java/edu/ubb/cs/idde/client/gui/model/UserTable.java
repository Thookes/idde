/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.client.gui.model;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import edu.ubb.cs.idde.server.model.User;

public class UserTable extends JTable {
	private static final long serialVersionUID = 1L;
	
	private final TableModel model;

	public UserTable() {
		User user = new User();
		model = new MyTableModel(user);
		
		setProperties();
	}
	
	private void setProperties() {
		this.setModel(model);
		this.getTableHeader().setResizingAllowed(false);
		this.setSelectionModel(new ForcedListSelectionModel());
	}
	
	@Override
	public TableModel getModel() {
		return model;
	}
}
