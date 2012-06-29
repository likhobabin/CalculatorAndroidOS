package calculator;
//

public abstract class ArithmParser {

	public ArithmParser (){
		FExpression = new StringBuilder();
	}
	//
	
	public ArithmParser (String __expr){
		FExpression = new StringBuilder(__expr);
	}
	//
	
	public void setExpression(String __expr){
		FExpression.delete(0, FExpression.length());
		FExpression.append(__expr);
		FIdx=0;
	}
	//
	
	StringBuilder getExpression(){
		return(FExpression);
	}
	
	int getIndex(){
		return(FIdx);
	}
	
	public abstract  double result() throws IndexOutOfBoundsException, IllegalArgumentException ;
	abstract  double doResult();
	//
	
	char flowChar(){
		return(FExpression.charAt(FIdx));
	}

	void nextIdx() throws IndexOutOfBoundsException {
		++FIdx;
		checkLine();
	}
	//
	
	void incrIdx(){
		++FIdx;
	}
	//
	
	void checkLine() throws IndexOutOfBoundsException {
		if(FExpression.length()<=FIdx)	    		
			throw new IndexOutOfBoundsException();
	}
	
	boolean isIndexBigger(){
		if(FExpression.length()<=FIdx)	    		
			return(true);
		return(false);
	}
	//
	
	private StringBuilder FExpression;
	private int FIdx;
	//
}
