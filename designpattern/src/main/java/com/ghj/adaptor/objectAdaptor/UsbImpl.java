package com.ghj.adaptor.objectAdaptor;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/7 11:34
 */
public class UsbImpl implements Usb {
    @Override
    public void isUsb() {
        System.out.println("当前接口USB口");
    }
}
