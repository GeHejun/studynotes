package com.ghj.adaptor.classAdaptor;

/**
 * @author gehj
 * @version 1.0
 * @description usb接口实现类
 * @date 2019/8/7 11:22
 */
public class UsbImpl implements Usb {
    @Override
    public void isUsb() {
        System.out.println("当前是USB口");
    }
}
