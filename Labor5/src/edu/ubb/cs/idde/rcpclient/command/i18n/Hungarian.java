package edu.ubb.cs.idde.rcpclient.command.i18n;

import java.util.Locale;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import edu.ubb.cs.idde.rcpclient.i18n.TextProvider;
import edu.ubb.cs.idde.rcpclient.view.View;

public class Hungarian implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener arg0) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		IWorkbenchPage p = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		View v = (View) p.findView("rcp-client.view");
		
		Locale locale = new Locale("hu", "HU");
		TextProvider.setLocale(locale);
		v.setLanguage();
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener arg0) {
	}

}
