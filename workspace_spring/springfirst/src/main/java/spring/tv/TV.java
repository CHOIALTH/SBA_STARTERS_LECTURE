package spring.tv;

public interface TV {
	public abstract void powerOn();
	void powerOff();
	void soundUp(int v); // volume 의 v
	void soundDown(int v);
	
}
