package communityuni.com;

public class TheoryThread {
	public static class TheSecondThread extends Thread{
		public TheSecondThread() {
			System.out.println("The Second Thread");
		}
		//Override method run if Thread class
		public void run() {
			for(int i=0;i<10;i++)
			{
				System.out.println("th #2 "+i);
			}
		}
	}
	public static class TheFirstThread implements Runnable{
		public TheFirstThread() {
			System.out.println("The First Thread");
		}
		public void run() {
			for(int i=0;i<10;i++)
			{
				System.out.println("th #1 "+i);
			}
		}
	}
	public static class ThreadTest implements Runnable{
		Thread objth;
		public ThreadTest() {
			System.out.println(Thread.currentThread().getName());
			objth = new Thread(this);
			System.out.println("Thread objTh is Alive = "+ objth.isAlive());
			objth.setName("GiaHao");
			objth.start();//goi ham run
		}
		public void run() {
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.activeCount());
		}
	}
	public static class ThreadPriority extends Thread{
		int num;
		public ThreadPriority(int num) {
			this.setPriority(num);
			this.start();
		}
		public void run() {
			for(int i=1;i<21;i++)
			{
				System.out.println("Priority "+ this.getPriority() + " : Count : "+i);
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*TheFirstThread run1 = new TheFirstThread();
		Thread th1 = new Thread(run1);
		TheSecondThread th2 = new TheSecondThread();
		th1.start();
		th2.start();*/
		//ThreadTest test = new ThreadTest();
		ThreadPriority p1 = new ThreadPriority(Thread.MIN_PRIORITY);
		ThreadPriority p2 = new ThreadPriority(Thread.MAX_PRIORITY);
		p1.join();
		p2.join();
	}

}
