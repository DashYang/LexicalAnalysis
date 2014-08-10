package GUI;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import Scanner.Dictionary;

public class DialogFactory {
	
	/**
	 * @param shell
	 * @return path
	 */
	public String getSaveDiaglog(Shell shell)
	{
		FileDialog dialog = new FileDialog(shell, SWT.SAVE);// 设置为保存对话框  
	    dialog.setFilterNames(new String[] { "CPP", "All Files (*.*)" });
	    dialog.setFilterExtensions(new String[] { "*.cpp", "*.*" });
	    dialog.setFilterPath("c:\\"); // Windows path
	    dialog.setFileName("file.cpp");
	    String path = dialog.open();
		return path;
	}
	
	/**
	 * @param shell
	 * @return path
	 */
	public String getOpendialog(Shell shell)
	{
		FileDialog fd = new FileDialog(shell, SWT.OPEN);
        fd.setText("Open");
        fd.setFilterPath("C:/");
        String[] filterExt = { "*.txt", "*.cpp", "*.*" };
        fd.setFilterExtensions(filterExt);
	    String path = fd.open();
		return path;
	}
	
	/**
	 * overwrite file
	 * @param shell
	 * @return path
	 */
	public boolean getOverwriteCmd(Shell shell)
	{
		MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION |SWT.YES | SWT.NO);
		messageBox.setMessage("文件存在，是否覆盖？");
		if(messageBox.open() == SWT.YES)
			return true;
		return false;
	}
	
	/**
	 *  new and save
	 * @param shell
	 * @return boolean
	 */
	public boolean getNewandSave(Shell shell)
	{
		MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION |SWT.YES | SWT.NO);
		messageBox.setMessage("是否保存原文件?");
		if(messageBox.open() == SWT.YES)
			return true;
		return false;
	}
	
	/**
	 *  keywordmap
	 * @param shell
	 * @return boolean
	 */
	public void getKeywordmap(Shell shell)
	{
		MessageBox messageBox = new MessageBox(shell, SWT.YES);
		String res = "";
		Dictionary dic = new Scanner.Dictionary();
		String[] words = dic.getCppkeyword();
		int cnt = 0;
		for(String word:words)
		{
			res += word + "\t";
			cnt ++ ;
			if(cnt % 4 == 0)
				res += "\n";
		}
		messageBox.setText("keywordmap");
		messageBox.setMessage(res);
		messageBox.open();
	}
	
	/**
	 *  precompilewordmap
	 * @param shell
	 * @return boolean
	 */
	public void getprecompilewordmap(Shell shell)
	{
		MessageBox messageBox = new MessageBox(shell, SWT.YES);
		String res = "";
		Dictionary dic = new Scanner.Dictionary();
		String[] words = dic.getPrecompileword();
		int cnt = 0;
		for(String word:words)
		{
			res += word + "\t";
			cnt ++ ;
			if(cnt % 4 == 0)
				res += "\n";
		}
		messageBox.setText("Precompilewordmap");
		messageBox.setMessage(res);
		messageBox.open();
	}
	
	/**
	 *  how
	 * @param shell
	 * @return boolean
	 */
	public void getHow(Shell shell)
	{
		MessageBox messageBox = new MessageBox(shell, SWT.YES);
		String res = "a cpp likely Text editor";
		messageBox.setText("how");
		messageBox.setMessage(res);
		messageBox.open();
	}
	
	/**
	 *  about
	 * @param shell
	 * @return boolean
	 */
	public void getAbout(Shell shell)
	{
		MessageBox messageBox = new MessageBox(shell, SWT.YES);
		String res = "Dash's work for compile theory\n LexicalAnalyzer";
		messageBox.setText("how");
		messageBox.setMessage(res);
		messageBox.open();
	}

	
}
