package Scanner;

public class DFA {
	private Judge judge;
	public DFA()
	{
		judge = new Judge();
	}
	public int run(char tmp,int state)
	{
		switch(state)
		{
			case -1:
			{
				if(judge.isEnd(tmp)) 
					return -2;
				else 
					return -1;
			}
			case 0:
			{
				if(judge.isC2(tmp))
				{
					return 1;
				}
				else if(judge.isC3(tmp))
				{
					return 3;
				}else if(judge.isC11(tmp))
				{
					return 16;
				}else if(judge.isC13(tmp))
				{
					return 18;
				}else if(judge.isC14(tmp))
				{
					return 21;
				}else if(judge.isVoid(tmp))
				{
					return 0;
				}else if(judge.isSimpleOperator(tmp) || judge.isLogicOperator(tmp)
						|| judge.isEqual(tmp))
				{
					return 24;
				}else if(judge.isC16(tmp))
				{
					return 27;
				}else if(judge.isC17(tmp))
					return 29;
				else if(judge.isExclamation(tmp))
					return 31;
				else if(judge.isPunctuation(tmp))
					return 32;
				else if(judge.isC18(tmp))
					return 33;
				else if(judge.isParenthese(tmp))
					return 39;
				else if(judge.isSharp(tmp))
					return 40;
				else if(tmp == '.')
					return 28;
				else
					return -1;
			}
			case 1:
			{
				if(judge.isC1(tmp))
				{
					return 1;
				}else if(judge.isC6(tmp))
				{
					return 12;
				}else if(judge.isC4(tmp))
				{
					return 4;
				}else if(judge.isC5(tmp))
				{
					return 2;
				}else 
					return -1;
			}
			case 3:
			{
				if(judge.isC4(tmp))
					return 4;
				else if(judge.isC7(tmp))
					return 10;
				else if(judge.isC9(tmp))
					return 7;
				else if(judge.isC5(tmp))
					return 2;
				else
					return -1;
			}
			case 7:
			{
				if(judge.isC8(tmp))
				{
					return 8;
				}else 
					return -1;
			}
			case 8:
			{
				if(judge.isC8(tmp))
					return 8;
				if(judge.isC5(tmp))
					return 9;
				else 
					return -1;
			}
			case 10:
			{
				if(judge.isC7(tmp))
					return 10;
				if(judge.isC5(tmp))
					return 11;
				else 
					return -1;
			}
			case 4:
			{
				if(judge.isC1(tmp))
					return 5;
				else 
					return -1;
			}
			case 5:
			{
				if(judge.isC1(tmp))
					return 5;
				if(judge.isC5(tmp))
					return 6;
				if(judge.isC6(tmp))
					return 12;
				else 
					return -1;
			}
			case 12:
			{
				if(judge.isC1(tmp))
					return 14;
				if(judge.isC10(tmp))
					return 13;
				else 
					return -1;
			}
			case 13:
			{
				if(judge.isC1(tmp))
					return 14;
				else 
					return -1;
			}
			case 14:
			{
				if(judge.isC1(tmp))
					return 14;
				if(judge.isC5(tmp))
					return 15;
				else 
					return -1;
			}
			case 16:
			{
				if(judge.isC12(tmp))
				{
					return 16;
				}else 
				{
					return 17;	
				}
			}
			case 18:
			{
				if(judge.isC15(tmp))
				{
					return 19;
				}else if(judge.isC13(tmp))
				{
					return 20;
				}
				else if(!judge.isC15(tmp))
				{
					return 18;
				}
			}
			case 19:
			{
				if(!judge.isC15(tmp))
					return 18;
				else
					return 19;
			}
			case 21:
			{
				if(judge.isC14(tmp))
					return 23;
				else if(judge.isC15(tmp))
					return 22;
				else
					return 21;
			}
			case 22:
			{
				if(judge.isC15(tmp))
					return 22;
				else 
					return 21;
			}
			case 24:
			{
				if(judge.isEqual(tmp))
					return 25;
				else 
					return 26;
			}
			case 27:
			{
				if(judge.isEqual(tmp))
					return 25;
				if(judge.isC16(tmp))
					return 28;
				else 
					return 26;
			}
			case 28:
			{
				if(judge.isEqual(tmp))
					return 25;
				else 
					return 26;
			}
			case 29:
			{
				if(judge.isEqual(tmp))
					return 25;
				else if(judge.isC17(tmp))
					return 30;
				else 
					return 26;
			}
			case 30:
			{
				if(judge.isEqual(tmp))
					return 25;
				else 
					return 26;
			}
			case 31:
			{
				if(judge.isEqual(tmp))
					return 25;
				else
					return -2;
			}
			case 33:
			{
				if(judge.isEqual(tmp))
					return 25;
				else if(judge.isC18(tmp))
					return 34;
				else if(judge.isC19(tmp))
					return 36;
				else 
					return 26;
			}
			case 34:
			{
				if(judge.isEnter(tmp))
					return 35;
				else 
					return 34;
			}
			case 36:
			{
				if(judge.isC19(tmp))
					return 37;
				else 
					return 36;
			}
			case 37:
			{
				if(judge.isC18(tmp))
					return 38;
				if(judge.isC19(tmp))
					return 37;
				else 
					return 36;
			}
			case 40:
			{
				if(judge.isC11(tmp))
					return 40;
				else 
					return 41;
			}
			default :
				return -1;
		}
	}
}
