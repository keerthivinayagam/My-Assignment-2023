package week3.day2.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
		
		int[] data= {3,2,11,4,6,7,2,3,3,6,7};
		Set<Integer> tree =new TreeSet<Integer>();
		for(int i=0;i<data.length;i++)
		{
			tree.add(data[i]);
		}
System.out.println(tree);
List <Integer> list=new ArrayList<Integer>();
list.addAll(tree);
System.out.println(list);
int size = list.size();
System.out.println(list.get(size-2));



	}

}
