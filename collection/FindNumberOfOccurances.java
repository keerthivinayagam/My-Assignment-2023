package week3.day2.hw;

import java.util.HashMap;
import java.util.Map;

public class FindNumberOfOccurances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number= {2,3,5,6,3,2,1,4,2,1,6,-1,2};
		int len=number.length;
		Map<Integer,Integer> map =new HashMap<Integer, Integer>();
		for(int i=0;i<len;i++)
		{
			if (map.containsKey(number[i]))
			{
				map.put(number[i],map.get(number[i])+1);
			}
			else
			{
				map.put(number[i],1);
			}
		}
		System.out.println(map);
	}
	}

