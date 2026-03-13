abstract class Shape  
{
	abstract void draw();
}
class Circle extends Shape
{
	void draw()
	{
		System.out.println("circle drawn");
	}
}
class Rectangle extends Shape
{
	void draw()
	{
		System.out.println("rectangle drawn");
	}
}
class Demo
{
	public static void main(String[] args) 
	{
		Shape s = new Shape();
		s.draw();
	}
}
