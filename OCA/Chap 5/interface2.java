 interface Demo
{
   void m1();
   default void m2(){
	System.out.println("default implementation");
   }
   static void m3(){
	System.out.println("static  implementation");
   }
}

class test implements Demo
{    
	 public  void m2(){
	System.out.println("test  implementation");
   }
	public void m1()
	{
		System.out.println("m1 implemented");
	}
  public static void main(String[] args)
  {
    test obj = new test();
	obj.m1();
	obj.m2();
	Demo.m3();
  }
}
