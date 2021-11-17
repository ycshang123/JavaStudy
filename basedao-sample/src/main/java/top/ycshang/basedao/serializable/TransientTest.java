package top.ycshang.basedao.serializable;

import java.io.*;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-18 00:00
 **/
public class TransientTest {
    public static void main(String[] args) {
        try {
            SerializeUser();
            DeSerializeUser();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void SerializeUser() throws IOException {
        User user = new User();
        user.setUsername("ssy");
        user.setPassword("ssy123");
        OutputStream out;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D://data.txt"));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        System.out.println("普通字段序列化:username=" + user.getUsername());
        System.out.println("添加了transient关键字序列化:password=" + user.getPassword());
    }

    private static void DeSerializeUser() throws IOException, ClassNotFoundException {
        File file = new File("D://data.txt");
        InputStream in;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        User user = (User) objectInputStream.readObject();
        System.out.println("普通字段反序列化:username=" + user.getUsername());
        System.out.println("添加了transient关键字反序列化:password=" + user.getPassword());
    }
}