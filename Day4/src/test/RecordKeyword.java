package test;


//record keyword defines the all the common constructor,getter and setter methods on its own.
record Student4(int id, String name, int marks) {}

public class RecordKeyword {
	public static void main(String[] args) {
		Student4 obj = new Student4(1,"Eesha",76);
		System.out.println(obj.id());
		System.out.println(obj.name());
		System.out.println(obj.marks());
	}
}