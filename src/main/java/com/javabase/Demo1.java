package com.javabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
public class Demo1 {
	private static List<String> list;
	private static LinkedList<String> list2;

	public Demo1() {
		list = new ArrayList<String>();
		list2 = new LinkedList<String>();
	}
	
	public static void main(String[] args) {
		
		HashMap map = new HashMap<>();
		ConcurrentHashMap conMap = new ConcurrentHashMap();
		Iterator<String> it = list.iterator();
		ListIterator<String> listIterator = list.listIterator();
		
		int a = 3;
		Integer b = 3;
		Integer c = new Integer(3);
		
		System.out.println(a == b);
		System.out.println(b == c);
//		Calendar c = Calendar.getInstance();
//		System.out.println(c.get(Calendar.DAY_OF_MONTH));

		Properties prop = System.getProperties();
		Set<Entry<Object,Object>> entrySet = prop.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
//			System.out.println(entry.getKey() + ":  " + entry.getValue());
		}
		/*HashMap<Student,String> hm = new HashMap<Student,String>();

		hm.put(new Student("lisi1",21),"beijing");
		hm.put(new Student("lisi1",21),"tianjin");
		hm.put(new Student("lisi2",22),"shanghai");
		hm.put(new Student("lisi3",23),"nanjing");
		hm.put(new Student("lisi4",24),"wuhan");

		//第一种取出方式 keySet

		Set<Student> keySet = hm.keySet();

		Iterator<Student> it = keySet.iterator();

		while(it.hasNext())
		{
			Student stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu+".."+addr);
		}*/
		
	}

}


/*class Student implements Comparable<Student>
{
	private String name;
	private int age;
	Student(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Student s)
	{
		int num = new Integer(this.age).compareTo(new Integer(s.age));

		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}

	public int hashCode()
	{
		return name.hashCode()+age*34;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			throw new ClassCastException("类型不匹配");

		Student s = (Student)obj;

		return this.name.equals(s.name) && this.age==s.age;
		

	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return name+":"+age;
	}
}*/
