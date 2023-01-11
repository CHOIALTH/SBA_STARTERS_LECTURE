package tv;

public class TVMain {

	public static void main(String[] args) {
		/*
		 * SamsungTV tv = new SamsungTV(); tv.powerOn(); tv.volumeUp(5);
		 * tv.volumeDown(3); tv.powerOff();
		 */
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.soundUp(5);
		tv.soundDown(3);
		tv.turnOff();
	}

}
