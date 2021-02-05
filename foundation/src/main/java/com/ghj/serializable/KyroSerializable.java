package com.ghj.serializable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.objenesis.strategy.StdInstantiatorStrategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KyroSerializable {
      
    public static void main(String[] args) throws IOException {
        long start =  System.currentTimeMillis();  
        setSerializableObject();  
        System.out.println("Kryo 序列化时间:" + (System.currentTimeMillis() - start) + " ms" );  
        start =  System.currentTimeMillis();  
        getSerializableObject();  
        System.out.println("Kryo 反序列化时间:" + (System.currentTimeMillis() - start) + " ms");  
  
    }  
  
    public static void setSerializableObject() throws FileNotFoundException {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);  
        kryo.setRegistrationRequired(false);  
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        kryo.register(Simple.class);
        Output output = new Output(new FileOutputStream("D:/file1.bin"));
        for (int i = 0; i < 100000; i++) {
            kryo.writeObject(output, new Simple("zhang"+i,(i+1)));
        }  
        output.flush();  
        output.close();  
    }  
  
  
    public static void getSerializableObject(){  
        Kryo kryo = new Kryo();  
        kryo.setReferences(false);  
        kryo.setRegistrationRequired(false);  
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());  
        Input input;
        try {  
            input = new Input(new FileInputStream("D:/file1.bin"));
            while(kryo.readObject(input, Simple.class) != null){
            }
  
            input.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (KryoException e){
  
        }  
    }  
  
}  