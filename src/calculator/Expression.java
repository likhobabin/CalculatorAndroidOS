package calculator;

import static calculator.TerminalSymbol.*;

public class Expression extends ArithmParser{

	public Expression( ){
		super();
	}
	//	
	
	public Expression(String __expr){
		super(__expr);
	}
	//	
	
	public double result() throws ArrayIndexOutOfBoundsException, IllegalArgumentException{
		double res=Term();
		//		
		while(getExpression().length()>getIndex() && isOperation1(flowChar())){
			char idx_char = flowChar();
			incrIdx();
			switch(idx_char){
				case '+':
					res += Term();
				break;
				case '-':
					res -= Term();
				break;
			}
		}
		//
		return(res);
	}
	//
		
	private double Term() {
		double res = Factor();
		//
		while(getExpression().length()>getIndex() && isOperation2(flowChar())){
			char idx_char = flowChar();
			incrIdx();
			switch(idx_char){
				case '*':
					res *= Factor();
				break;
				case '/':
					res /= Factor();
				break;
			}
		}
		//
		return(res);
	}
	//
	
	private double Factor(){
		double res=0.0;
		//
		if(isUnaryOp(flowChar())){
			double efficient = 1.0;
			if('-' == flowChar())
				efficient = -1.0;
			nextIdx();
			res = efficient*factorSupp();
		}
		else
			if(isDigit(flowChar())){
				res = Number();
			}
			else
				if(isLeftBrace(flowChar())){
					nextIdx();
					res = result();
					if( isIndexBigger() )
						throw new IllegalArgumentException();
					if(!isRightBrace(flowChar()))
						throw new IllegalArgumentException();
					else
						incrIdx();
				}
				else
					throw new IllegalArgumentException();
		return(res);
	}
	//
	
	private double factorSupp(){
		double res=0.0;
		if(isDigit(flowChar())){
			return(Number());
		}
		else{
			if(isLeftBrace(flowChar())){
				nextIdx();
				res = result();
				if(isIndexBigger() )
					throw new IllegalArgumentException();
				if(!isRightBrace(flowChar()))
					throw new IllegalArgumentException();
				else
					incrIdx();
			}
			else
				throw new IllegalArgumentException();
		}
		return(res);
	}
	
	private double Number() {
		StringBuffer numValue = new StringBuffer();
		StringBuffer pow=null;
		double power = 1.0;
		//
		if(isSign(flowChar())){
			numValue.append(flowChar());
			nextIdx();
		}
		//
		if(!isDigit(flowChar())){
			throw new IllegalArgumentException();
		}
		//
		while(getExpression().length()>getIndex() && 
			  (isDigit(flowChar()) || isSeparator(flowChar())))
		{
			numValue.append(flowChar());
			if(isSeparator(flowChar())){
				incrIdx();	
				if(!isDigit(flowChar()))
					throw new IllegalArgumentException();
			}
			else
				incrIdx();
		}
		//
	    if(getExpression().length()>getIndex() &&
	       isExponenta(flowChar()))
	    {
	    	nextIdx();
	    	//__expr
			if(!isSign(flowChar()))
				throw new IllegalArgumentException();
			char sign = flowChar();

	    	nextIdx();	
	    	if(!isDigit(flowChar()))
	    		throw new IllegalArgumentException();
	    	
	    	pow = new StringBuffer();
	    	while(getExpression().length()>getIndex() && isDigit(flowChar())){
	    		pow.append(flowChar());
	    		incrIdx();
	    	}
	    	
	    	int i_pow = 1;
	    	if('-' == sign){
	    		i_pow *= (-1);
	    	}
	    	i_pow *= Integer.parseInt(pow.toString());
	    	power = Math.pow(TEN, i_pow);
		}
		//
		return(Double.parseDouble(numValue.toString())*power);
	}
	//
}
//
