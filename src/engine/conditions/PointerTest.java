package engine.conditions;

import java.util.ArrayList;

public class PointerTest {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		Integer a1 = 1;
		Integer a2 = 2;
		Integer a3 = 3;
		a.add(a1); a.add(a2); a.add(a3);
		
		ArrayList<Integer> b = a;
		
		b.remove(a2);
		b.remove(a3);
		for(Integer x : a){
			System.out.println(x);
		}
		
		for(Integer y: b){
			System.out.println(y);
		}
	}
}