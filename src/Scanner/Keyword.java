package Scanner;

public class Keyword {
	private String word;
	private WordType type;
	
	public Keyword()
	{
		word ="";
		type = WordType.UNKNOWN;
	}
	
	public Keyword(String word, WordType type)
	{
		this.word = word;
		this.type = type;
	}
	
	public void set(String word, WordType type)
	{
		this.word = word;
		this.type = type;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public WordType getType() {
		return type;
	}

	public void setType(WordType type) {
		this.type = type;
	}
	
}
