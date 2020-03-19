package qa;

public class Training {
	
	public Training() {
		int a=3;
		int b=5;
		int c= a+b;
		System.out.println("c = "+c);
		
	}	
	public Training(int a , int b) {
		int c= a+b;
		System.out.println("c = "+c);
	}
	
	public void manual() {
		System.out.println("This is manual function");
	}

	public void automation() {
		System.out.println("This is automation function");
	}
	
	
	public static void main(String[] args) {
		 Training t = new Training();
		 t.manual();
		 t.automation();
		
		// Training t1 = new Training(3,2);
		// t.manual();
		// t.automation();	 

	}

}
