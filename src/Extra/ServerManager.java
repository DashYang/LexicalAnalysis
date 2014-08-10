package Extra;

import java.util.ArrayList;
import java.util.Vector;

import Scanner.Judge;

public class ServerManager {
	private ArrayList<Integer> rowtabs;
	private int nowrow;
	private int tabnum;
	
	public ServerManager(){}
	
	public String run(String text)
	{
		String res = "";
		String row = "";
		int tabnum = 0;
		int i,j;
		for(i = 0; i < text.length() ; i ++)
		{
			String t = text.substring(i,i+1);
			String st = text.substring(i+1);
			res += t;
			if(t.equals("{"))
			{
				//res += "\r\n";
				tabnum ++;
				
			}else if(t.equals("}"))
			{
				tabnum --;
				if(tabnum < 0)
					tabnum = 0;
			}else if(t.equals("\n") && !st.equals("}"))
			{
				for( j = 0; j < tabnum ; j++)
				{
					res += "\t";
				}
			}
		}
		return res;
	}
	
	public String needParenthese(String text)
	{
		if(text.length() < 1)
			return "";
		if(text.substring(text.length()-1).equals("("))
		{
			return ")";
		}
		if(text.substring(text.length()-1).equals("["))
		{
			return "]";
		}
		if(text.substring(text.length()-1).equals("{"))
		{
			return "}";
		}
		return "";
	}
}
