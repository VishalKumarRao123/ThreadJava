package package1;
class AK extends Thread{
	public void run() {
		for(int i=0;i<10;i++)
			 System.out.println("Thread-1"+i);
	}
}
class BK extends Thread{
	public void run() {
		for(int i=0;i<10;i++)
			 System.out.println("Thread-2"+i);
	}
}
public class ExtendingThreadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     AK obj1 = new AK();
     BK obj2 = new BK();
     obj1.start();
    
     obj2.start();
	}

}
