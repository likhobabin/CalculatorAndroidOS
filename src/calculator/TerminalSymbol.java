package calculator;

public class TerminalSymbol {
	//
	public static boolean isSeparator(char __idx_char){
		if('.' == __idx_char){
			return(true);
		}
		return(false);
	}
	//
	
	public static boolean isSign(char __idx_char){
		for(int i=0; SIGN.length>i; i++){
			if(SIGN[i] == __idx_char)
				return(true);
		}
		return(false);
	}
	//

	public static boolean isExponenta(char __idx_char){
		for(int i=0; SIGN.length>i; i++){
			if(EXPONENTA[i] == __idx_char)
				return(true);
		}
		return(false);
	}
	//

	public static boolean isDigit(char __idx_char){
		//
		for(int i=0; NUMBERS.length>i; i++){
			if(NUMBERS[i]==__idx_char)
				return(true);
		}
		return(false);
	}
	//
	
	public static boolean isOperation1(char __idx_char){
		//
		for(int i=0; OPERATION1.length>i; i++){
			if(OPERATION1[i]==__idx_char){
				return(true);
			}
		}
		return(false);
	}
	//
	
	public static boolean isOperation2(char __idx_char){
		//
		for(int i=0; OPERATION2.length>i; i++){
			if(OPERATION2[i]==__idx_char){
				return(true);
			}
		}
		return(false);
	}
	//
	
	public static boolean isUnaryOp(char __idx_char){
		//
		for(int i=0; UNARYOP.length>i; i++){
			if(UNARYOP[i]==__idx_char){
				return(true);
			}
		}
		return(false);
	}
	//	
	
	public static boolean isLeftBrace(char __idx_char){
		return('(' == __idx_char);
	}
	//
	
	public static boolean isRightBrace(char __idx_char){
		return(')' == __idx_char);
	}
	//
		
	static final char[] NUMBERS = {'0', '1','2','3','4','5','6','7','8','9'};
	static final char[] OPERATION1 = {'+', '-'};
	static final char[] OPERATION2 = {'*', '/'};
	static final char[] UNARYOP = {'+', '-'};
	static final char[] SIGN = {'-', '+'};
	static final char[] EXPONENTA = {'e', 'E'};
	static final int TEN = 10;
	//
}
