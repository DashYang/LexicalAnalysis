package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import Scanner.WordType;


/*********
 * the law of hightlight
 * @author Dash
 *
 */
public class ColorFactory {
	
	public ColorFactory() {}
	
	private StyleRange getNumberStyle(StyleRange stylerange)
	{
		Color color = Display.getCurrent().getSystemColor(SWT.COLOR_RED);
        stylerange.foreground = color;
        return stylerange;
	}
	
	private StyleRange getKeywordStyle(StyleRange stylerange)
	{
		Color color = Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
        stylerange.foreground = color;
        stylerange.fontStyle = SWT.BOLD;
        return stylerange;
	}
	
	private StyleRange getStringStyle(StyleRange stylerange)
	{
		Color color = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED);
        stylerange.foreground = color;
        return stylerange;
	}
	
	private StyleRange getOperatorStyle(StyleRange stylerange)
	{
		Color color = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY);
        stylerange.foreground = color;
        return stylerange;
	}
	
	private StyleRange getAnnotation(StyleRange stylerange)
	{
		Color color = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN);
        stylerange.foreground = color;
        return stylerange;
	}
	
	public StyleRange run(int start,int end,WordType type)
	{
		StyleRange stylerange = new StyleRange();
		stylerange.start = start;
		stylerange.length = end - start;
		switch(type)
		{
			case KEYWORD:
				return getKeywordStyle(stylerange);
			case NUMBER:
				return getNumberStyle(stylerange);
			case STRING:
				return getStringStyle(stylerange);
			case OPERATOR:
				return getOperatorStyle(stylerange);
			case ANNOTATION:
				return getAnnotation(stylerange);
		}
		return stylerange;
	}
}
