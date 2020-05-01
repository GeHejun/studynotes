import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/4/28 13:34
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> classLoaderTest = myClassLoader.findClass("ClassLoaderTest");
        System.out.println(myClassLoader.equals(classLoaderTest));

    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        File file = new File("D:\\gehj\\projects\\studynotes\\jvm\\src\\main\\java\\MyClassLoader.class");
        try {
            final byte[] classFileBytes = getClassFileBytes(file);
            clazz = defineClass(name, classFileBytes, 0, classFileBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    private byte[] getClassFileBytes(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        WritableByteChannel writableByteChannel = Channels.newChannel(byteArrayOutputStream);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        while (true) {
            int read = fileChannel.read(byteBuffer);
            if (read == 0 || read == -1) {
                break;
            }
            byteBuffer.flip();
            writableByteChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fileInputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
