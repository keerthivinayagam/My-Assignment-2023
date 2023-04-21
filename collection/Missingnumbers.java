package week3.day2.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Missingnumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {3,2,10,4,6,7,2,3,3,6,7,8,5,1};
		Set<Integer>  tree=new TreeSet<Integer>();
		for(int i=0;i<data.length;i++)
		{
			tree.add(data[i]);
		}
		System.out.println(tree);
		List<Integer> list =new ArrayList<Integer>();
		list.addAll(tree);
		System.out.println(list);
		int size=list.size();
		for(int i=0;i<=size;i++)
		{
			if(list.get(i)==i+1) {
				continue;
			}
			else {
				int missinsnum=++i;
				System.out.println("Missing no. is "+ missinsnum );
			}

}
	}
}
