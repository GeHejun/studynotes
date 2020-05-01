import java.util.Objects;
import java.util.Stack;

/**
 * @author gehj
 * @version 1.0
 * @description GeHejun
 * @date 2020/4/28 9:43
 */
public class StackToQueue<T> {

    public static void main(String[] args) {
        StackToQueue<String> stringStackToQueue = new StackToQueue<>();
        stringStackToQueue.put("a");
        stringStackToQueue.put("b");
        System.out.println(stringStackToQueue.get());
        stringStackToQueue.put("c");
        System.out.println(stringStackToQueue.get());;
    }

    Stack inStack = new Stack();
    Stack outStack = new Stack();

    public void put(T t) {
        while (!outStack.isEmpty() && Objects.nonNull(outStack.peek())) {
            inStack.push(outStack.pop());
        }
        inStack.push(t);
    }

    public T get() {
        while (!inStack.isEmpty() && Objects.nonNull(inStack.peek())) {
            outStack.push(inStack.pop());
        }
       return (T)outStack.pop();
    }

}
