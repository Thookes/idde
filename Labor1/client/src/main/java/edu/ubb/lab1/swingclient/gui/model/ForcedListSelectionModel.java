/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.swingclient.gui.model;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;

public class ForcedListSelectionModel extends DefaultListSelectionModel {
	private static final long serialVersionUID = 1L;

	public ForcedListSelectionModel () {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
