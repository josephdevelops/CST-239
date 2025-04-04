package app;

/**
 * The output of the Person class displays messages and values 
 * as the main method executes the program. When the getName(), 
 * getAge(), and getWeight() methods are called, they each 
 * print a message to indicate the method execution and return 
 * the respective attribute value. This design demonstrates 
 * encapsulation, where the attributes are private and accessed 
 * via public getter methods. The output reflects the 
 * initialized attributes of the Person object, showing how the 
 * constructor sets the values and how methods retrieve them.
 * @author Joseph Abraham
 * @version 1/15/2025
 */
public class Person {
	/**
	 * Class with person info
	 * @param age
	 * age description here
	 * @param name
	 * name description here
	 * @param weight
	 * weight description here
	 */

	
	private int age;
	private String name;
	private float weight;
	


	/**
	 * public person comment here
	 * @param age
	 * age param here
	 * @param name
	 * name param here
	 * @param weight
	 * weight param here
	 */
	public Person(int age, String name, float weight)
	{

		//super();
		this.age = age;
		this.name = name;
		this.weight = weight;
	}
	/**
	 * getAge() description goes here
	 * @return
	 * getAge() return description here
	 */
	public int getAge()
	
	{
		System.out.println("I am in getAge()");
		return age;
	}
	/**
	 * getName() description goes here
	 * @return
	 * getName() return description here
	 */
	public String getName()
	{
		System.out.println("I am in getName()");
		return name;
	}
	/**
	 * getWeight() description goes here
	 * @return
	 * getWeight() return description here
	 */
	public float getWeight()
	{
		System.out.println("I am in getWeight()");
		return weight;	
	}
	
	/**
	 * public main() comment here
	 * @param args
	 * arg comment here
	 */
	public static void main(String[] args)
	/**
	 * main()
	 */
	{
		Person person = new Person(25, "Bob", (float) 165.02);
		System.out.println("My name is " + person.getName());
		person.getAge();
		person.getWeight();
	
	}

}


/* 
 
+-----------------------+
|       Person          |
+-----------------------+
| - age: int           |
| - name: String       |
| - weight: float      |
+-----------------------+
| + Person(int, String, float) |
| + getAge(): int      |
| + getName(): String  |
| + getWeight(): float |
+-----------------------+

*/