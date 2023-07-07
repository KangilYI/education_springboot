package hello.core.singleton;


/**
 * Singleton 패턴
 * 객체를 미리 생성하두는 가장 단순하고 안전한 방법
 * 싱글톤 패턴을 적용하면 이미 만들어진 객체를 공유하여 효율적으로 사용할 수 있다.
 */
public class SingletonService {

	// 1. static 영역에 객체를 딱 1개만 생성
	private static final SingletonService instance = new SingletonService();

	//2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메소드를 통해서만 조회 가능하도록 허용.
	public static SingletonService getInstance() {
		return instance;
	}

	//3. 생성자를 private으로 선언하여 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
	private SingletonService() { }

	public void logic() {
		System.out.println("싱글콘 객체 로직 호출");
	}
}
