package week1.day1;

public class Fibonacci {

	public static void main(String[] args) {
		int firstNum=0,secNumb=1,sum=0,i;
		
		 System.out.print(firstNum+" "+secNumb);   
		    
		 for(i=2;i<11;i++)   
		 {    
			 sum=firstNum + secNumb;    
		  System.out.print("  "+sum);    
		  firstNum = secNumb;    
		  secNumb = sum; 

	}
}
}

