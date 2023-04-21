package week3.day2.hw;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWords {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] test=text.split(" ");
		Set<String> unique=new LinkedHashSet<String>();
		for(int i=0;i<test.length;i++)
		{
			unique.add(test[i]);
			System.out.println(test[i]);
		}
		System.out.println(unique);
				

	}

}



