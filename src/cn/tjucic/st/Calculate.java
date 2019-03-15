package cn.tjucic.st;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Calculate {

	public static Set<List<Integer>> getSet(int[] set){
		Set<List<Integer>> finalset = new HashSet<List<Integer>>();
		int len = set.length;
		int num =(int) Math.pow(2, len);
		
		for (int i = 1; i < num; i++) {
			List<Integer> subList = new ArrayList<Integer>();
			int index = i;
			for (int j = 0; j < len; j++) {
				if ((index & 1) == 1) { 
					subList.add(set[j]);
				}
				index >>= 1; // 右移一位
			}

		finalset.add(subList); 
		}
		return finalset;
	}
	public boolean Judge(int x) {
		
		int[] set = new int[] {50,20,5,5,1,1,1};
		Set<List<Integer>> result = getSet(set); // 调用方法
		// 输出结果
		Set<Integer> fin = new HashSet<Integer>();
		for (List<Integer> subSet : result) {
			int number=0;
			for (Integer num : subSet) {
				number+=num;
			}
			fin.add(number);
		}
		if(fin.contains(x)) {
        	return true;
        }else {
        	return false;
        }
		
		
	}
}