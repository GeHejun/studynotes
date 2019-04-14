package array;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public class ArrayList<T> implements List<T>, RandomAccess {
    /**
     * list内部通过数组来实现
     */
    private Object[] table;
    /**
     * 当用户创建一个初始大小为0的list时会用到这样一个空数组
     */
    private static final Object[] EMPTY_TABLE = {};
    /**
     * 数组的长度，没增加或者见效快一个元素该值会变化
     */
    private int size;
    /**
     * 默认的初始大小
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * 当用户采用无参构造器时会使用这个默认大小的空数组
     * 最开始是空数组，当添加第一个元素时会改变成默认的初始大小
     * 这里的空数组要与EMPTY_TABLE区分开，EMPTY_TABLE是用户传的参数为0时用到
     * 而这里的空数组是为了扩容时候用到
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_TABLE = {};

    /**
     * 判断是否采用最大的数组容量临界值
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 默认的无参构造器，此时会采用默认参数的空数组
     */
    public ArrayList() {
        table = DEFAULT_CAPACITY_EMPTY_TABLE;
    }

    /**
     * 有默认参数的构造器 参数为初始大小
     * 分为一下两种情况
     * 1.用户传的默认参数是0，那么就使用EMPTY_TABLE作为空数组
     * 2.用户传的默认参数大于0，那么就使用用户传参作为初始数组大小
     * @param initialCapacity
     */
    public ArrayList(int initialCapacity) {
       if (initialCapacity > 0) {
           this.table = new Object[initialCapacity];
       } else if (initialCapacity == 0) {
           this.table = EMPTY_TABLE;
       } else {
           throw new IllegalArgumentException();
       }
    }

    /**
     * 参数是一个集合的构造器
     * @param c
     */
    public ArrayList(Collection c) {
        /**
         * 调用Collection的toArray方法
         * toArray 方法的实现：
         * 调用Arrays.copyOf(T[] t)方法
         * 底层再调用System.arrayCopy(Object src,int srcPos,Object dest, int destPos,int length)方法
         * 通过该方法table已经被重新赋值
         *
         * copyOf方法与arrayCopy方法不同之处
         * 1.copyOf方法会再调用arrayCopy方法之前创建一个新的对象，
         *   在创建新对象之前会比较要创建的对象是否是Object[]对象，
         *   如果是数组对象那么会重新创建一个Object[],否则会创建一个相同类型的数组对象啊
         *   所以这个新的对象有可能并不是Object[],然后再调用arrayCopy方法
         * 2.而arrayCopy方法用的还是传入的对象
         */
        table = c.toArray();
        if ((size = table.length) != 0) {
            //注意：class的比较用==或!=
            if (table.getClass() != Object[].class) {
                //如果返回的对象不是Object[].class类型，重新调用copyOf方法把类型传入，就会返回传入类型的数组
                table = Arrays.copyOf(table,size,Object[].class);
            }
        } else {
            //如果Collection的大小为0，那么直接赋给空数组
            table = EMPTY_TABLE;
        }
    }

    /**
     * 判断数组是否为空
     * 因为size是根据插入或者删除数据而变化的所以判断size是否是0就可以判断出是否是空数组了
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 通过下标获得下标对应的元素
     * @param index
     * @return
     */
    public T get(int index) {
        checkRange(index);
        return (T) table[index];
    }

    /**
     * 把指定位置的元素修改成功另一个值
     * @param index
     * @param data
     * @return
     */
    public T set(int index, T data) {
        checkRange(index);
        T old = (T) table[index];
        this.table[index] = data;
        return old;
    }

    /**
     * 在指定位置插入一个元素
     * @param index
     * @param data
     */
    public void add(int index, T data) {
        checkRange(index);
        //确保空间足够
        ensureEnoughCapacity(size + 1);
        for (int i = size; i > index; i--) {
            table[i] = table[i - 1];
        }
        table[index] = data;
        size++;
    }

    /**
     * 添加一个新元素
     * @param data
     * @return
     */
    public boolean add(T data) {
        //确保空间足够
        ensureEnoughCapacity(size + 1);
        table[size] = data;
        size++;
        return true;
    }

    /**
     * 把指定位置的元素移除
     * @param index
     */
    public void remove(int index) {
        checkRange(index);
        for (int i = index; i < size; i++) {
            table[i] = table[i + 1];
        }
        table[size - 1] = null;
        size--;
    }

    /**
     * 移除数组中第一个data元素
     * @param data
     * @return
     */
    public boolean remove(T data) {
        if (data == null) {
            for (int i = 0; i < size; i++) {
                if (table[i]== null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (data.equals(table[i])) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 移除数组中所有的data元素
     * @param data
     * @return
     */
    public boolean removeAll(T data) {
        boolean flag = false;
        if (data == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (table[i] == null) {
                    remove(i);
                    flag = true;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (data.equals(table[i])) {
                    remove(i);
                    flag = true;
                }
            }
        }
        return flag;
    }

    /**
     * 清空数组
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }
        size = 0;
    }

    /**
     * 判断数组中是否包含某一个元素，看这个元素在数组中的index是否大于0
     * @param data
     * @return
     */
    public boolean contains(T data) {
        return indexOf(data) > 0;
    }


    /**
     * indexOf方法包含两种情况
     * 1.data是空，直接遍历table去比较table中是否包含null
     * 2.data不为空，需要用data 去比较，原因防止table中有null元素，比较的时候报空指针异常
     * @param data
     * @return
     */
    public int indexOf(T data) {
        if ( data == null ) {
            for (int i = 0; i < size; i++) {
                if (table[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (data.equals(table[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 获取最后一个data元素的存放位置原理与indexOf相同，但是需要从后遍历
     * @param data
     * @return
     */
    public int lastIndexOf(T data) {
        if (data == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (table[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (data.equals(table[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 自己手动是实现检查下标是否合理
     * @param index
     */
    public void checkRange(int index) {
        if (index < 0 || index > table.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 确保数组中有足够的空间
     * 这是arrayList的核心方法
     * @param minCapacity
     */
    private void ensureEnoughCapacity(int minCapacity) {
        //因为默认构造方法给了一个默认的大小的数组，此时数组的大小仍然为0，
        // 在添加第一个元素的时候数组大小就要改变成默认大小
        if (table == DEFAULT_CAPACITY_EMPTY_TABLE) {
            // 此时要兼容ensureCapacity方法，因为这个方法调用的时候minCapacity可能比DEFAULT_SIZE大
            minCapacity = Math.max(DEFAULT_SIZE,minCapacity);
        }
        enoughCapacity(minCapacity);
    }

    /**
     * 这个方法用来判断是否需要扩容，有可能不需要扩容就有足够的空间
     */
    private void enoughCapacity(int minCapacity) {
        if (minCapacity > table.length) {
            grow(minCapacity);
        }
    }

    /**
     * 扩容方法
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        //原来的容量扩容到原来的1.5倍
        //这里用到移位操作 都是整数，所以不是严格的1.5倍
        int oldValue = table.length;
        int newValue = table.length + table.length >> 1;
        //如果minCapacity还是比原来数组的1.5倍大，那么数组容量用minCapacity
        //1.会发生此类问题的情况当all方法参数是数组时
        //2.当调用无参的构造函数然后第一次添加元素时
        //3.ensureCapacity方法时
        if (minCapacity > newValue) {
            newValue = minCapacity;
        }
        if (newValue > MAX_ARRAY_SIZE) {
            newValue = hugeSize(newValue);
        }
        //创建一个大容量数组，把原来的数组复制进新数组
        Arrays.copyOf(table,newValue);

    }

    /**
     * 用来设置数组的最大值
     * @param value
     * @return
     */
    public int hugeSize(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("");
        }
        value = value > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
        return value;
    }

    /**
     * 该toString方法是自己实现的
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(table[i]);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
