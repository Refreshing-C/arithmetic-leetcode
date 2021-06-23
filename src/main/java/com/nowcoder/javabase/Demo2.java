package com.nowcoder.javabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class Demo2 {

    public static void main(String[] args) throws IOException {
//		File dir = new File("d:\\testdir");
//		showDir(dir,0);

        //toBin(6);
        //int n = getSum(8000);
        //System.out.println("n="+n);

//		System.out.println(dir.delete());

//		loadDemo();

//		writeObj();
    }

    public static void loadDemo() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("G:\\Java\\Workspace\\Java基础源代码\\day20\\info.txt");

        //将流中的数据加载进集合。
        prop.load(fis);

        prop.setProperty("wangwu", "39");

        FileOutputStream fos = new FileOutputStream("info.txt");

        prop.store(fos, "haha");

        //	System.out.println(prop);
        prop.list(System.out);

        fos.close();
        fis.close();

    }


    public static void writeObj() throws IOException {
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("obj.txt"));

        oos.writeObject(new Person("lisi0", 399, "kr"));

        oos.close();
    }

    public static String getLevel(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("|--");
        for (int x = 0; x < level; x++) {
            //sb.append("|--");
            sb.insert(0, "|  ");

        }
        return sb.toString();
    }

    public static void showDir(File dir, int level) {

        System.out.println(getLevel(level) + dir.getName());

        level++;
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory())
                showDir(file, level);
            else
                System.out.println(getLevel(level) + file);
        }
    }
}



/*
列出指定目录下文件或者文件夹，包含子目录中的内容。
也就是列出指定目录下所有内容。

因为目录中还有目录，只要使用同一个列出目录功能的函数完成即可。
在列出过程中出现的还是目录的话，还可以再次调用本功能。
也就是函数自身调用自身。
这种表现形式，或者编程手法，称为递归。

递归要注意：
1，限定条件。

2，要注意递归的次数。尽量避免内存溢出。

**/



