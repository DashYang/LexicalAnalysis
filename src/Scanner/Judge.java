package Scanner;

public class Judge 
{
	
	/**
	 * void
	 * @param char
	 * @return
	 */
	public boolean isVoid(char tmp)   
	{
		if(tmp == ' ' || tmp == '\t' || tmp == '\n' || tmp == '\r')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * #
	 * @param char
	 * @return
	 */
	public boolean isSharp(char tmp)   
	{
		if(tmp == '#')
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * + - *  %
	 * @param char
	 * @return
	 */
	public boolean isSimpleOperator(char tmp)   
	{
		if(tmp == '+' || tmp == '-' || tmp == '*' 
				|| tmp == '%')
		{
			return true;
		}
		return false;
	}

	
	/**
	 * , : ? $ @ ` ;
	 * @param char
	 * @return
	 */
	public boolean isPunctuation(char tmp)   
	{
		if(tmp == ',' || tmp == ':' || tmp == '?' || tmp == '%'
				|| tmp == '@' || tmp == '`' || tmp == ';')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * punctuation or void
	 * @param char
	 * @return
	 */
	public boolean isEnd(char tmp)   
	{
		if(isPunctuation(tmp) || isVoid(tmp))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * !
	 * @param char
	 * @return
	 */
	public boolean isExclamation (char tmp)   
	{
		if(tmp == '!')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * & | ^
	 * @param char
	 * @return
	 */
	public boolean isLogicOperator(char tmp)   
	{
		if(tmp == '&' || tmp == '|' || tmp == '^' )
		{
			return true;
		}
		return false;
	}
	
	/**
	 * not
	 * @param char
	 * @return boolean
	 */
	public boolean isNot(char tmp)   
	{
		if(tmp == '~' )
		{
			return true;
		}
		return false;
	}
	
	/**
	 * \n
	 * @param char
	 * @return boolean
	 */
	public boolean isEnter(char tmp)   
	{
		if(tmp == '\n' )
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * 0~9
	 * @param char
	 * @return
	 */
	public boolean isC1(char tmp)   
	{
		if(tmp >= '0' && tmp <='9')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * =
	 * @param char
	 * @return
	 */
	public boolean isEqual(char tmp)   
	{
		if(tmp == '=')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 1~9
	 * @param char
	 * @return
	 */
	public boolean isC2(char tmp)   
	{
		if(tmp >= '1' && tmp <='9')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 0
	 * @param char
	 * @return
	 */
	//0
	public boolean isC3(char tmp)   
	{
		if(tmp == '0')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * .
	 * @param char
	 * @return
	 */
	//.
	public boolean isC4(char tmp)   
	{
		if(tmp == '.')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * operator (without '/')
	 * @param char
	 * @return
	 */
	public boolean isOperator(char tmp)  
	{
		if(tmp == '+' || tmp == '-' || tmp == '*')
		{
			return true;
		}else if(tmp == '<' || tmp == '>')
			return true;
		return false;
	}
	
	/**
	 * []{}()
	 * @param char
	 * @return
	 */
	public boolean isParenthese(char tmp)  
	{
		if(tmp == '[' || tmp == ']' || tmp == '{' || tmp == '}'
				|| tmp == '(' || tmp == ')' )
		{
			return true;
		}else 
			return false;
	}
	
	/**
	 * else
	 * @param char
	 * @return
	 */
	public boolean isC5(char tmp)  
	{
		if(isOperator(tmp) || isVoid(tmp) || isPunctuation(tmp) 
				|| isC18(tmp) || isParenthese(tmp))
			return true;
		return false;
	}
	
	/**
	 * E|e
	 * @param char
	 * @return
	 */
	//E|e
	public boolean isC6(char tmp)
	{
		if(tmp == 'E' || tmp == 'e')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 0~7
	 * @param char
	 * @return
	 */
	public boolean isC7(char tmp)   
	{
		if(tmp >= '0' && tmp <='7')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 0~9 a~f A~F
	 * @param char
	 * @return
	 */
	public boolean isC8(char tmp)   
	{
		if(tmp >= '0' && tmp <='9')
		{
			return true;
		}else if(tmp >= 'a' && tmp <='f')
			return true;
		else if(tmp >= 'A' && tmp <='E')
			return true;
		return false;
	}
	
	/**
	 * X|x
	 * @param char
	 * @return
	 */
	public boolean isC9(char tmp)   
	{
		if(tmp == 'X' || tmp == 'x')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * +|-
	 * @param char
	 * @return
	 */
	public boolean isC10(char tmp)   
	{
		if(tmp == '+' || tmp == '-')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * character，underline
	 * @param char
	 * @return
	 */
	public boolean isC11(char tmp)   
	{
		if(tmp <= 'Z' && tmp >= 'A')
		{
			return true;
		}else if(tmp <= 'z' && tmp >= 'a')
		{
			return true;
		}else if(tmp == '_')
			return true;
		return false;
	}
	
	/**
	 * character，underline,number
	 * @param char
	 * @return
	 */
	public boolean isC12(char tmp)   
	{
		if(tmp <= 'Z' && tmp >= 'A')
		{
			return true;
		}else if(tmp <= 'z' && tmp >= 'a')
		{
			return true;
		}else if(tmp == '_')
			return true;
		else if(tmp >= '0' && tmp <= '9')
			return true;
		return false;
	}
	
	/**
	 * '
	 * @param char
	 * @return
	 */
	public boolean isC13(char tmp)
	{
		if(tmp == '\'')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * "
	 * @param char
	 * @return
	 */
	public boolean isC14(char tmp)
	{
		if(tmp == '\"')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * \
	 * @param char
	 * @return
	 */
	public boolean isC15(char tmp)
	{
		if(tmp == '\\')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * <
	 * @param char
	 * @return
	 */
	public boolean isC16(char tmp)
	{
		if(tmp == '<')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * >
	 * @param char
	 * @return
	 */
	public boolean isC17(char tmp)
	{
		if(tmp == '>')
		{
			return true;
		}
		return false;
	}
	
	/**  
	 * /
	 * @param char
	 * @return
	 */
	public boolean isC18(char tmp)
	{
		if(tmp == '/')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * *
	 * @param char
	 * @return
	 */
	public boolean isC19(char tmp)
	{
		if(tmp == '*')
		{
			return true;
		}
		return false;
	}
	
}
