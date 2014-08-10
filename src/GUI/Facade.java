package GUI;


import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.*;

import Extra.FileManage;
import Extra.ServerManager;
import Scanner.Colorword;
import Scanner.Scanner;
import Scanner.WordType;

public class Facade {
	private static  Shell    	shell;							
	private static  Display  	display;				
	private static  StyledText 	sText;
	private static  Text    	result;
	private static 	Text 		info;
	private static  Button  	CPbtn;
	private static  Button  	CPWbtn;
	private static  Button      realtimebtn;
	private static  Menu        menu;
	
	//fileitem
	private static MenuItem openItem;
	private static MenuItem saveItem;
	private static MenuItem newItem;
	private static MenuItem exitItem;
	
	//optionitem
	private static MenuItem KeywordItem;
	private static MenuItem precomplileItem;
	private static MenuItem analysisItem;
	private static MenuItem formatItem;
	
	//aboutitem
	private static MenuItem howItem;
	private static MenuItem aboutItem;
	
	private static 	Scanner 	scanner;
	private static ColorFactory colorfactory;
	
	
	public Facade()
	{
		scanner = new Scanner();   //init myScanner
		colorfactory = new ColorFactory();  //init colorfatctory
		
		display = new Display();
		shell = new Shell(display,SWT.CLOSE);
		shell.open();
		shell.setText("MyLex");
		shell.setSize(800, 550);
		
		menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		setFileMenu();
		setOptionMenu();
		setAboutMenu();
		
        sText = new StyledText(shell, SWT.WRAP|SWT.V_SCROLL);
		sText.setBounds(5, 5, 400, 400);
    		
        result = new Text(shell, SWT.READ_ONLY|SWT.WRAP|SWT.V_SCROLL);
        result.setBounds(420, 5, 370, 400);
        result.setText("");
        
        CPbtn = new Button(shell, SWT.CHECK);
        CPbtn.setBounds(10,410, 150, 22);
        CPbtn.setText("complete parenthses");
        
        realtimebtn = new Button(shell, SWT.CHECK);
        realtimebtn.setBounds(165, 410, 120, 22);
        realtimebtn.setText("realtime analysis");
        
        CPWbtn = new Button(shell, SWT.CHECK);
        CPWbtn.setBounds(300,410, 150, 22);
        CPWbtn.setText("complete word");
        
        info = new Text(shell, SWT.READ_ONLY|SWT.WRAP|SWT.V_SCROLL);
        info.setBounds(5,440, 785, 50);
        info.setText("welcome!");
        
        //set listeners
        setListenner();
        //给shell加上布局管理器    
        while (!shell.isDisposed()) {  
            if (!display.readAndDispatch())  
                display.sleep();  
        }  
        display.dispose();  
	}
	
	public void setListenner()
	{
		sText.addModifyListener(new ModifyListener() {			
			@Override
			public void modifyText(ModifyEvent arg0) {
				if(realtimebtn.getSelection())
				{
					analysis();
				}
				if(CPbtn.getSelection())
				{
					ServerManager sm = new ServerManager();
					String content = sText.getText();
					String p = sm.needParenthese(content);
					if(p.equals(""))
						return;
					sText.setText(content + p);
					sText.setSelection(content.length() + 1);
					sText.setFocus();
				}
			}
		});
		saveItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				goSave();
			}
		});
		
		openItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				DialogFactory df = new DialogFactory();
		        FileManage fm = new FileManage();
			    String path = df.getOpendialog(shell);
			    if(path == null || path =="")
			    	return;
			    sText.setText(fm.openFile(path));
			}
		});
		
		newItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				DialogFactory df = new DialogFactory();
		        FileManage fm = new FileManage();
			    if(sText.getText() != null || sText.getText() != "")
			    {
			    	if(df.getNewandSave(shell))
			    	{
			    		goSave();
			    	}
			    }
			    sText.setText("");
			}
		});
		
		exitItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				shell.dispose();
			}
		});
		
		KeywordItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				DialogFactory df = new DialogFactory();
				df.getKeywordmap(shell);
				
			}
		});
		
		precomplileItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				DialogFactory df = new DialogFactory();
				df.getprecompilewordmap(shell);
				
			}
		});
		
		analysisItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				analysis();
			}
		});
		
		formatItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				ServerManager sm = new ServerManager();
				sText.setText(sm.run(sText.getText()));
			}
		});
		
		howItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				DialogFactory df = new DialogFactory();
				df.getHow(shell);
				
			}
		});
		
		aboutItem.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				DialogFactory df = new DialogFactory();
				df.getAbout(shell);
				
			}
		});
	}
	
	public void goSave()
	{
		FileManage fm = new FileManage();
	    DialogFactory df = new DialogFactory();
	    String path = df.getSaveDiaglog(shell);
	    if(path == null || path == "")
	    	return;
	    String file = sText.getText();
	    if(new File(path).exists())
	    {
	    	if(df.getOverwriteCmd(shell))
	    	{
	    		fm.saveFile(path, file);
	    	}
	    }else
	    	fm.saveFile(path, file);
	}
	
	public void setFileMenu()
	{
		MenuItem file = new MenuItem(menu, SWT.CASCADE);
		file.setText("file");
		Menu filemenu = new Menu(shell, SWT.DROP_DOWN);
		file.setMenu(filemenu);
		
		newItem = new MenuItem(filemenu, SWT.PUSH);
		newItem.setText("New");
		newItem.setAccelerator(SWT.CTRL + 'n');
		
		openItem = new MenuItem(filemenu, SWT.PUSH);
		openItem.setText("Open");
		openItem.setAccelerator(SWT.CTRL + 'o');
		
		saveItem = new MenuItem(filemenu, SWT.PUSH);
		saveItem.setText("Save");
		saveItem.setAccelerator(SWT.CTRL + 's');
		
		exitItem = new MenuItem(filemenu, SWT.PUSH);
		exitItem.setText("Exit");
		saveItem.setAccelerator(SWT.CTRL + 'e');
	}
	
	public void setOptionMenu()
	{
		MenuItem Option = new MenuItem(menu, SWT.CASCADE);
		Option.setText("Option");
		Menu Optionmenu = new Menu(shell, SWT.DROP_DOWN);
		Option.setMenu(Optionmenu);
		
		KeywordItem = new MenuItem(Optionmenu, SWT.PUSH);
		KeywordItem.setText("Keyword");
		
		precomplileItem = new MenuItem(Optionmenu, SWT.PUSH);
		precomplileItem.setText("Precompileword");
		
		analysisItem = new MenuItem(Optionmenu, SWT.PUSH);
		analysisItem.setText("analysis");
		
		formatItem = new MenuItem(Optionmenu, SWT.PUSH);
		formatItem.setText("format text");
		formatItem.setAccelerator(SWT.CTRL + 'f');
		
	}
	
	public void setAboutMenu()
	{
		MenuItem About = new MenuItem(menu, SWT.CASCADE);
		About.setText("about");
		Menu Aboutnmenu = new Menu(shell, SWT.DROP_DOWN);
		About.setMenu(Aboutnmenu);
		
		howItem = new MenuItem(Aboutnmenu, SWT.PUSH);
		howItem.setText("how to use");
		
		aboutItem = new MenuItem(Aboutnmenu, SWT.PUSH);
		aboutItem.setText("about");
	}
	
	public void analysis()
	{
		scanner.init();
		scanner.run(sText.getText());
		coloringText();		
		updateInfo();
		showErr();
	}
	
	public void showErr()
	{
		int tot = 0;
		int Err = 0;
		for(Colorword cw:scanner.getList())
		{
			tot ++;
			if(cw.getKeyword().getType() == WordType.UNKNOWN)
			{
				Err ++;
			}
		}
		info.setText("Total Word(s):\t" + tot + "\n"
				+ "Total Error(s):\t" + Err + "\n");
	}
	
	public void coloringText()
	{
		for(Colorword cw:scanner.getList())
		{
			StyleRange styleRange = colorfactory.run(
					cw.getBeginIndex(),
					cw.getEndIndex(),
					cw.getKeyword().getType());
	        sText.setStyleRange(styleRange);
		}
	}
	
	public void updateInfo()
	{
		String info = "";
		for(Colorword cw:scanner.getList())
		{
			info += cw.getKeyword().getType() + ":\t" + cw.getKeyword().getWord() +"\n";
		}
		result.setText(info);
	}
}

