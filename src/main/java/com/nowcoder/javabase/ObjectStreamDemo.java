package com.nowcoder.javabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

class ObjectStreamDemo 
{
	public static void main(String[] args) throws Exception
	{
//		writeObj();
//		readObj();
		
		FileOutputStream fos = new FileOutputStream(new File("obj.txt"));
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		osw.write("abc");
		osw.flush();
		osw.close();
		
		
//		FileInputStream fis = new FileInputStream(new File("obj.txt"));
//		InputStreamReader isr = new InputStreamReader(fis);
	}
	public static void readObj()throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));

		Person p = (Person)ois.readObject();

		System.out.println(p);
		ois.close();
	}

	public static void writeObj()throws IOException
	{
		ObjectOutputStream oos = 
			new ObjectOutputStream(new FileOutputStream("obj.txt"));

		oos.writeObject(new Person("lisi0",399,"kr"));

		oos.close();
	}
}
