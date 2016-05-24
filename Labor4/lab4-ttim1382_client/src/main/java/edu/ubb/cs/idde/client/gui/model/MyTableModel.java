/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.client.gui.model;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	private String[] columns;
	
	public MyTableModel(Object object) {
		Field[] allFields = object.getClass().getDeclaredFields();
		List<Field> nonStaticFields = new ArrayList<Field>();
		
		for (Field field : allFields) {
			if(!((field.getModifiers() & Modifier.STATIC) == Modifier.STATIC)) {
				nonStaticFields.add(field);
			}
		}
		
		columns = new String[nonStaticFields.size()];
		
		for (int i = 0; i < nonStaticFields.size(); i++) {
			columns[i] = nonStaticFields.get(i).getName();
		}
	}
	
	@SuppressWarnings("unused")
	private List<Field> findAllFields(Class<?> cls) {
		List<Field> fields = new ArrayList<Field>();
		
		for (Field field : cls.getDeclaredFields()) {
			if(!((field.getModifiers() & Modifier.STATIC) == Modifier.STATIC)) {
				fields.add(field);
			}
		}
		
		if (cls.getSuperclass() != null) {
			List<Field> parentFields = findAllFields(cls.getSuperclass());
			fields.addAll(parentFields);
		}
		
		return fields;
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
