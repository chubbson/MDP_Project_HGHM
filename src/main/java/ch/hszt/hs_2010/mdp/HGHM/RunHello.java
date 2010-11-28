package ch.hszt.hs_2010.mdp.HGHM;

public class RunHello {

	public static void main(String[] args) {
		Hello m_Hello = new Hello();
		System.out.println(m_Hello.getHelloKitty());
		System.out.println(m_Hello.getHelloWorld());
		System.out.println(m_Hello.getHelloName("Basil"));
	}
}
