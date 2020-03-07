package com.ghj.proxy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/9/26 9:35
 */

class ClassDescriber {

    private static final String rn = "\r\n";

    private static final String t = "\t";

    private static final String b = "\0";

    private static final String start = "{";

    private static final String end = "}";

    private static final String split = ";";

    private static final String parameterStart = "(";

    private static final String parameterEnd = ")";

    private static final String parameterSplit = ",";

    String pkg;
    String[] dependOnPkgs;
    String name;
    String extendName;
    String interfaceName;
    List<MethodDescriber> methodDescribers;
    ClassLoader classLoader;


    public Object generateClass() throws IOException, ClassNotFoundException {
        StringBuilder sb = new StringBuilder();
        sb.append("package ") .append(pkg).append(rn);
        for (String s : dependOnPkgs) {
            sb.append("import ") .append(s).append(rn);
        }
        sb.append("public ").append("class ").append(name).append(" extend ").append(extendName).append(" implements ").append(interfaceName).append(start).append(rn);
        for (MethodDescriber methodDescriber: methodDescribers) {
            sb.append(methodDescriber.newMethod());
        }
        sb.append(end);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
        ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
        return inputStream.readObject();
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setDependOnPkgs(String[] dependOnPkgs) {
        this.dependOnPkgs = dependOnPkgs;
    }

    public void setExtendName(String extendName) {
        this.extendName = extendName;
    }


    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public void setMethodDescribers(List<MethodDescriber> methodDescribers) {
        this.methodDescribers = methodDescribers;
    }


    class MethodDescriber {
        int modifier;
        Class returnType;
        Class[] parametersType;
        String name;
        InvocationHandler h;

        MethodDescriber(int modifier, Class returnType, Class[] parametersType, String name) {
            this.modifier = modifier;
            this.returnType = returnType;
            this.parametersType = parametersType;
            this.name = name;
        }

        public String newMethod() {
            StringBuilder sb = new StringBuilder();
            sb.append(Modifier.toString(modifier)).append(returnType).append(name).append(parameterStart);
            for (int i = 0; i < parametersType.length; i++) {
                sb.append(parametersType[i].getSimpleName()).append(b).append(toLowerCaseFirstOne(parametersType[i].getSimpleName()));
                if (i != parametersType.length - 1) {
                    sb.append(parameterSplit);
                }
            }
            sb.append(parameterEnd).append(b).append(start).append(rn);
            sb.append("return ").append(h.invoke());
            return sb.toString();
        }

        public  String toLowerCaseFirstOne(String s){
            if(Character.isLowerCase(s.charAt(0))) {
                return s;
            } else {
                return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
            }

        }
    }
}
