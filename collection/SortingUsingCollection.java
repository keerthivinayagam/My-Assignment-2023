package week3.day2.hw;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SortingUsingCollection {

	public static void main(String[] args) {
		String[] company= {"HCL","Wipro","Aspire Systems","CTS"};
		Arrays.sort(company);
		for(int j=0;j<company.length;j++)
		{
			System.out.println(company[j]);
		}
		Set<String> set =new TreeSet<String>();
		for(int i=0;i<company.length;i++)
		{
			set.add(company[i]);
		}
		System.out.println(set);
		
		Object[] new1=set.toArray();
		for(int j=new1.length-1;j>=0;j--)
		{
			System.out.println(new1[j]);
		}
		
		


	}

}
