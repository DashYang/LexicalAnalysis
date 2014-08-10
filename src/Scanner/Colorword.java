package Scanner;

public class Colorword {
	private int beginIndex;
	private int endIndex;
	private String color;
	private Keyword keyword;
	
	public Colorword()
	{
		beginIndex = 0;
		endIndex = 0;
		color = "dark";
	}
	
	public Colorword(int beginIndex ,Keyword keyword)
	{
		this.beginIndex = beginIndex;
		this.endIndex = beginIndex + keyword.getWord().length();
		this.keyword = keyword;
		if(keyword.getType() == WordType.NUMBER)
			this.color = "red";
		else if(keyword.getType() == WordType.KEYWORD)
			this.color = "blue";
		else 
			this.color = "dark";
		
	}
	
	public Colorword(int beginIndex , int endIndx , String color,Keyword keyword)
	{
		this.beginIndex = beginIndex;
		this.endIndex = endIndx;
		this.color = color;
		this.keyword = keyword;
	}
	

	public int getBeginIndex() {
		return beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public String getColor() {
		return color;
	}

	public Keyword getKeyword() {
		return keyword;
	}
	
	
}
