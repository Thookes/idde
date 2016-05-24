/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.swingclient.gui.model;

import javax.swing.table.DefaultTableModel;

import edu.ubb.lab1.swingclient.util.TextProvider;

public class UserTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	private String[] columns = {
			TextProvider.getValue("MainFrame.tableIDColumn"),
			TextProvider.getValue("MainFrame.tableNameColumn"),
			TextProvider.getValue("MainFrame.tableUsernameColumn")
	};
	
	@Override
	public void setColumnIdentifiers(Object[] newIdentifiers) {
		columns = (String[]) newIdentifiers;
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public String getColumnName(int index) {
		return columns[index];
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

	/** 
	 * <br>
	 * <b> <i> getColumnIndex </i> </b>
	 * <br> <br>
	 * public int getColumnIndex(String columnName)
	 * <br> <br>
	 * Returns from model the index of given column.
	 * <br>
	 * @param columnName - the column name being queried
	 * @return an index for this column using the index value of the appropriate member in columnIdentifiers.
	 * If columnIdentifiers does not have an entry for this name, returns -1.
	 * **/
	public int getColumnIndex(String columnName) {
		boolean found = false;
		int i = 0;
		while (i < columns.length && !found) {
			if (columnName.equals(columns[i])) {
				found = true;
			} else {
				i++;
			}
		}
		if (found) {
			return i;
		} else {
			return -1;
		}
	}
}
