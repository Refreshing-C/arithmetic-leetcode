package com.javabase;

import java.io.*;

class ObjectStreamDemo {
    public static void main(String[] args) throws Exception {
//		writeObj();
//		readObj();

//		FileOutputStream fos = new FileOutputStream(new File("obj.txt"));
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		osw.write("abc");
//		osw.flush();
//		osw.close();

        // 输入字符流
		FileReader reader = new FileReader(new File("D:\\obj.txt"));
		// 输入字符流缓冲区
		BufferedReader br = new BufferedReader(reader);

        // 输出字符流
        FileWriter fw = new FileWriter(new File("D:\\obj1.txt"));
        // 输出字符流缓冲区
        BufferedWriter bw = new BufferedWriter(fw);

		String str = "";
		while ((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
		}

		// 字符流需要手动关闭缓冲区
		reader.close();
		br.close();

		bw.close();
		fw.close();


        // 字节流
//        FileInputStream is = new FileInputStream(new File("D:\\obj.txt"));
//        // 把字节流转成字符流
//        InputStreamReader isr = new InputStreamReader(is);
//        char[] buff = new char[1024];
//        while (isr.read(buff, 0, 1024) != -1) {
//            System.out.println(new String(buff));
//        }




//		FileInputStream fis = new FileInputStream(new File("obj.txt"));
//		InputStreamReader isr = new InputStreamReader(fis);
    }

    public static void readObj() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));

        Person p = (Person) ois.readObject();

        System.out.println(p);
        ois.close();
    }

    public static void writeObj() throws IOException {
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("obj.txt"));

        oos.writeObject(new Person("lisi0", 399, "kr"));

        oos.close();
    }
}
