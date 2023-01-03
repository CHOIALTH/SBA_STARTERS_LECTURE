package udemyJava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test1 {
	public static void main(String[] args) {
	    int sum = 0;
	    for(int i=0;i <= 10;i++) {
	        if (i%3==0)
	            continue;
	        sum += i;  
	    }
	    System.out.println(sum);
	} 
}
