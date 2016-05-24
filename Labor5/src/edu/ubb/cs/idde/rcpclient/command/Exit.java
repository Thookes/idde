package edu.ubb.cs.idde.rcpclient.command;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.ui.PlatformUI;

public class Exit implements IHandler {
  
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}
	  
	@Override
	public void dispose() {
	}
	  
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PlatformUI.getWorkbench().close();
		
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
	public void removeHandlerListener(IHandlerListener handlerListener) {
	}
	
}