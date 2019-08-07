package com.ghj.adaptor.objectAdaptor;

/**
 * @author gehj
 * @version 1.0
 * @description
 *
 *       我手中有个ps2插头的设备，但是主机上只有usb插头的插口，怎么办呢？弄个转换器，将ps2插头转换成为USB插头就可以使用了。
 *
 *       接口Ps2：描述ps2接口格式
 *
 *       接口Usb：描述USB接口格式
 *
 *       类Usber：是接口Usb的实现类，是具体的USB接口格式
 *
 *       Adapter：用于将ps2接口格式转换成为USB接口格式

 * @date 2019/8/7 11:36
 */
public class Test {


    public static void main(String[] args) {
        Adaptor adaptor = new Adaptor(new UsbImpl());
        adaptor.isPs2();
    }
}
