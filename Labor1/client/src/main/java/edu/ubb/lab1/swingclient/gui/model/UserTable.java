/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.swingclient.gui.model;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class UserTable extends JTable {
	private static final long serialVersionUID = 1L;
	
	private final TableModel model;

	public UserTable() {
		model = new UserTableModel();
		
		setProperties();
	}
	
	private void setProperties() {
		this.setModel(model);
		this.getTableHeader().setResizingAllowed(false);
		this.setSelectionModel(new ForcedListSelectionModel());
		this.removeColumn(this.getColumnModel().getColumn(0));
	}
	
	@Override
	public TableModel getModel() {
		return model;
	}
}
