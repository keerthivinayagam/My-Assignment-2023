package org.system;

public class Desktop extends computer{
	
	public void desktopSize()
	{
		System.out.println("Desktop size is: "+"1250x1500");
	}

	public static void main(String[] args) {
		
		Desktop obj=new Desktop();
		obj.desktopSize();
		obj.computerModel();
	}

}
