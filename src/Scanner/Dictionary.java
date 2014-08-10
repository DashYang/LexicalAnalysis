package Scanner;

public class Dictionary {
	private String[] cppkeyword =
		{
			"auto","bool","break","case","char","catch",
			"class","const","continue","default","delete",
			"do","double","else","enum","explicit","extern",
			"float","for","friend","goto","if","inline","int",
			"long","mutable","new","operator","private","protected",
			"public","register","return","struct","switch","template",
			"this","throw","true","try","typedef","union","unsigned",
			"using","virtual","void","volatile","while","namespace"      
		};
	private String[] precompileword =
		{
			"#include" , "#define" , "#undef" ,
			"#pragma" , "#import" , "#error" , 
			"#line" , "#ifdef" , "#ifndef" , "#if" ,
			"#else" , "#elif" ,"#endif"
		};
	
	public boolean isMatch(String str)
	{
		for(String word:cppkeyword)
		{
			if(str.equals(word))
				return true;
		}
		for(String word:precompileword)
		{
			if(str.equals(word))
				return true;
		}
		return false;
	}

	
	public String[] getCppkeyword() {
		return cppkeyword;
	}

	public String[] getPrecompileword() {
		return precompileword;
	}
	
	
}
