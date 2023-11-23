package f_哈希表HashMap.数组实现hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用数组实现HashMap (整型)
 *
 * @author zijian Wang
 */
public class ArrayHashMap {

    class KeyValuePairs {

        private Integer key;
        private Object value;

        public KeyValuePairs(Integer key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Integer getKey() {
            return key;
        }
    }

    private List<KeyValuePairs> buckets = new ArrayList<>();

    public ArrayHashMap(int size) {
        for (int i = 0; i < size; i++) {
            buckets.add(null);
        }
    }

    private int hash(int num) {
        int size = buckets.size();
        return num % size;
    }

    public void push(int key, Object value) {
        int index = hash(key);
        buckets.set(index, new KeyValuePairs(index, value));
    }

    public Object remove(int key) {
        int hashCode = hash(key);
        KeyValuePairs keyValuePairs = buckets.get(hashCode);
        buckets.set(hashCode, null);
        return keyValuePairs.getValue();
    }

    public int set(int key, Object value) {
        int hashCode = hash(key);
        buckets.set(hashCode, new KeyValuePairs(hashCode, value));
        return hashCode;
    }

    public Object get(int key) {
        int hashCode = hash(key);
        KeyValuePairs keyValuePairs = buckets.get(hashCode);
        return keyValuePairs.getValue();
    }

    public List<Integer> keySet() {
        return buckets.stream()
                .filter(x -> x != null)
                .map(x -> x.getKey())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ArrayHashMap arrayHashMap = new ArrayHashMap(10);
        System.out.println("ArrayHashMap 初始化2条数据");
        arrayHashMap.push(1, "wangzijian1");
        arrayHashMap.push(2, "wangzijian2");
        System.out.println(arrayHashMap.get(1));
        System.out.println(arrayHashMap.get(2));

        System.out.println("获取ArrayHashMap当前的所有key");
        System.out.println(arrayHashMap.keySet());

        System.out.println("修改key为2的值");
        arrayHashMap.set(2,"wangzijian222222");
        System.out.println(arrayHashMap.get(2));

        System.out.println("移除key为2的值");
        arrayHashMap.remove(2);
        System.out.println(arrayHashMap.buckets);

    }
}
