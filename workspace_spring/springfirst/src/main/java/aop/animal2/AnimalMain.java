package aop.animal2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {
	public static void main(String[] args) {
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("aop/animal2/animal.xml");
		Animal [] animals = new Animal[3];
		animals[0] = (Animal)factory.getBean("dog"); // Dog 클래스의 객체
		animals[1] = (Animal)factory.getBean("cat"); // Cat 클래스의 객체
		animals[2] = (Animal)factory.getBean("rabbit"); // Rabbit 클래스의 객체
		
		for(Animal a : animals) {
			a.lunch();
		}
	}
} 
/*
 * 1. Dog, Cat, Rabbit, AnimalAspect 클래스 완성
 * 2. animal.xml
 * */

/* 원하는 출력결과
 * 오늘은 뭐먹을거에요
 * 사료먹었습니다
 * Dog - 사료 먹었군요.
 * 오늘은 뭐먹을거에요
 * 사료먹었습니다
 * Cat - 사료 먹었군요.
 * 오늘은 뭐먹을거에요
 * 사료먹었습니다
 * Rabbit - 사료 먹었군요. */
