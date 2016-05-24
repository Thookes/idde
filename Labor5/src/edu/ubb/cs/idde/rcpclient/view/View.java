package edu.ubb.cs.idde.rcpclient.view;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import edu.ubb.cs.idde.rcpclient.i18n.TextProvider;
import edu.ubb.cs.idde.server.model.User;
import edu.ubb.cs.idde.server.service.ServiceException;
import edu.ubb.cs.idde.server.service.ServiceManager;

public class View extends ViewPart {
	public static final String ID = "rcp-client.view";

	private Composite parent;
	private TableViewer viewer;

	class ViewLabelProvider extends LabelProvider  {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}

		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		this.parent = parent;
		
		createView();
	}

	private void createView() {
		viewer = new TableViewer(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);
		
		int width = 290;
		
		TableViewerColumn name = new TableViewerColumn(viewer, SWT.CENTER);
		name.getColumn().setText("Name");
		name.getColumn().setWidth(width);
		name.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				return ((User) element).getName();
			};
		});
		
		TableViewerColumn username = new TableViewerColumn(viewer, SWT.CENTER);
		username.getColumn().setText("Username");
		username.getColumn().setWidth(width);
		username.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				return ((User) element).getUsername();
			};
		});
	}
	
	public void refreshDatabaseTable() {
		try {
			viewer.setInput(ServiceManager.getUserService().getAllUsers());
			parent.layout();
		} catch (ServiceException e) {
			 MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					 TextProvider.getValue("Operations.errorTitle"),
					 TextProvider.getValue("Operations.getUsersError"));
		}
	}
	
	public void setLanguage() {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		shell.setText(TextProvider.getValue("MainFrame.title"));
		this.setPartName(TextProvider.getValue("MainFrame.partTitle"));
		
		MenuItem[] menuItems = shell.getMenuBar().getItems();
		menuItems[0].setText(TextProvider.getValue("MainFrame.showButton"));
		menuItems[1].setText(TextProvider.getValue("MainFrame.languagesButton"));
		MenuItem[] languages = menuItems[1].getMenu().getItems();
		// TODO Miért nem állítja át az almenük szövegét?
		languages[0].setText(TextProvider.getValue("MainFrame.englishButton"));
		languages[1].setText(TextProvider.getValue("MainFrame.hungarianButton"));
		menuItems[2].setText(TextProvider.getValue("MainFrame.exitButton"));
		
		viewer.getTable().getColumn(0).setText(TextProvider.getValue("name"));
		viewer.getTable().getColumn(1).setText(TextProvider.getValue("username"));
	}
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}