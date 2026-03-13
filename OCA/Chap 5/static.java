class Demo 
{
	static int cntobjects = 0;
	Demo(int v) 
	{
		cntobjects++;
	}
public static void main(String []args) 
	{
		Demo obj[] = new Demo[5];  

		for(int i = 0; i < 5; i++) 
		{
			obj[i] = new Demo(i+1); 
    }
	obj[0].cntobjects++;
		System.out.println("Count of objects "+ obj[3].cntobjects);	
  }
}
