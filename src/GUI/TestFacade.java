package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class TestFacade {
	private static  Shell    	shell;							
	private static  Display  	display;	
	private static  Menu   		menu;
	
	public TestFacade()
	{
		display = new Display();
		shell = new Shell(display,SWT.CLOSE);
		shell.open();
		shell.setText("MyLex");
		shell.setSize(800, 550);
		
		menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		MenuItem file = new MenuItem(menu, SWT.CASCADE);
		file.setText("file");
		
		Menu filemenu = new Menu(shell, SWT.DROP_DOWN);
		//style必须是SWT.DROP_DOWN
		file.setMenu(filemenu);
		MenuItem openItem = new MenuItem(filemenu, SWT.PUSH);
		openItem.setText("Open");
		MenuItem saveItem = new MenuItem(filemenu, SWT.PUSH);
		saveItem.setText("Save");
		saveItem.setAccelerator(SWT.CTRL + 's');
		saveItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				System.out.println("save");
				
			}
		});
		
		
		while (!shell.isDisposed()) {  
            if (!display.readAndDispatch())  
                display.sleep();  
        }  
        display.dispose();  
	}
}
