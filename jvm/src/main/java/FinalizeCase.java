/**
 * @author gehj
 * @version 1.0
 * @description finalize方法
 * @date 2019/8/8 14:28
 */
public class FinalizeCase {

    private static Block block = null;

    public static void main(String[] args) {
        block = new Block();
        long l = Runtime.getRuntime().freeMemory();
        block = null;
        System.gc();
        System.out.println(Runtime.getRuntime().freeMemory() - l);
        System.out.println(1024 * 1024 * 20);
    }

    static class Block{
        byte[] memory200M = new byte[1024 * 1024 * 20];

        @Override
        protected void finalize() throws Throwable {
//            System.out.println("执行finalize方法，准备回收");
            super.finalize();
        }
    }
}
