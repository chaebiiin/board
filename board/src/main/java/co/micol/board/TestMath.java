package co.micol.board;

public class TestMath {

	private int n;
	private int m;

	public TestMath() { // default 생성자

	}

	public TestMath(int n, int m) {
		super(); // 부모가 가지고 있는???
		this.n = n;
		this.m = m;
	}

	public int sum() { // 메소드 sum 생성.
		return n + m;
	}

	public int sub() { //???? 무슨 역할?
		int sub = 0;
		if (n >= m) {
			sub = n - m;
		} else {
			sub = m - n;
		}
		return sub;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public static void main(String[] args) {
		int n = 5;
		int m = 10;
		
	}


}
