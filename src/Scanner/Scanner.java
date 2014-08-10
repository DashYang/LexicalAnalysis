package Scanner;

import java.util.ArrayList;

public class Scanner {
	private int state;
	private DFA dfa;
	private ArrayList<Colorword> list;
	private Judge judge;
	private Dictionary dictionary;
	
	public Scanner()
	{
		state = 0;
		dfa = new DFA();
		list = new ArrayList<Colorword>();
		judge = new Judge();
		dictionary = new Dictionary();
	}
	
	public void init()
	{
		state = 0;
		list.clear();
	}
	
	public void run(String str)
	{
		for(int i = 0 ; i < str.length() ; )
		{
			char tmp = str.charAt(i);
			if(!judge.isVoid(tmp))
			{
				Keyword keyword = match(str.substring(i));
				list.add(new Colorword(i,keyword));
				i += keyword.getWord().length();
			}else
			{
				i ++;
			}
		}
	}
	
	public Keyword match(String str)
	{
		System.out.println("match: " + str + "len:" + str.length()); //debug
		Keyword kw = new Keyword();
		if(str.length() == 0)
			return kw;
		
		String word = "";
		System.out.println("init state :" + state ); //debug
		for(int i = 0 ; i < str.length() ; i++)
		{
			char tmp = str.charAt(i);
			System.out.println("tmp:" + tmp); //debug
			word += tmp;
			state = dfa.run(tmp, state);
			System.out.println("state :" + state); //debug
			if(state == 1 || state ==3
					||state == 7 ||state == 8 || state == 10
					|| state == 4 || state == 5 || state == 12
					|| state == 13 || state == 14)
			{
				kw.set(word,WordType.NUMBER);
			}
			else if(state == 16 || state == 40)
			{
				if(dictionary.isMatch(word))
				{
					kw.set(word, WordType.KEYWORD);
				}else
				{
					kw.set(word, WordType.IDENTIFIER);
				}
			}
			else if( state == 18 || state == 19 || state == 20 || state == 21 
					|| state == 22 || state == 23)
			{
				kw.set(word, WordType.STRING);
			}
			else if(state == 24 || state == 25 || state == 27 || state == 28
					|| state == 29 || state == 30 || state == 31 || state == 33
					)
			{
				kw.set(word, WordType.OPERATOR);
			}
			else if(state == -1)
			{
				kw.set(word,WordType.UNKNOWN);
			}else if(state == 34 || state ==36 || state == 37 || state == 38)
			{
				kw.set(word,WordType.ANNOTATION);
			}
			
			if(state == 2 || state == 9 || state == -2
					|| state == 11 || state == 6 || state == 15
					|| state == 17 || state == 20 || state == 23
					|| state == 25 || state == 26 || state == 35
					|| state == 38 || state == 41 || state == 42)
			{
				state = 0;
				return kw;
			}else if(state == 32)
			{
				state = 0;
				kw.set(word,WordType.PUNCTUATION);
				return kw;
			}else if(state == 39)
			{
				state = 0;
				kw.set(word,WordType.PARENTHESES);
				return kw;
			}
		}
		return kw;
	}
	
	public int getState()
	{
		return state;
	}
	
	public ArrayList<Colorword> getList()
	{
		return list;
	}
}
