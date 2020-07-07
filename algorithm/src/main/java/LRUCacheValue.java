public class LRUCacheValue<V> {

    private V value;

    private Integer useCount;

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public LRUCacheValue() {

    }

    public LRUCacheValue(V value, Integer useCount) {
        this.value = value;
        this.useCount = useCount;
    }
}
