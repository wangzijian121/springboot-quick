package e_哈希表_hashmap.数组实现可扩容hashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用数组实现HashMap (整型)(可扩容)
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


    /**
     * 桶数组
     */
    private List<KeyValuePairs> buckets = new ArrayList<>();
    /**
     * 桶的数量
     */
    int size;

    /**
     * 扩容倍数
     */
    int extendRatio;

    /**
     * 负载因子(当桶的数量达到多少时触发扩容)
     */
    double loadFactor;


    public ArrayHashMap(int size) {
        loadFactor = 2 / 3;
        extendRatio = 2;
        for (int i = 0; i < size; i++) {
            buckets.add(null);
        }
    }

    /**
     * hash 函数（将输入的数据模上buckets的size）
     *
     * @param num
     * @return
     */
    private int hash(int num) {
        int size = buckets.size();
        return num % size;
    }

    public void push(int key, Object value) {
        if (checkLoadFactor()) {
            buckets = extend(buckets);
        }
        int index = hash(key);
        buckets.set(index, new KeyValuePairs(index, value));
        size++;
    }

    public Object remove(int key) {
        int hashCode = hash(key);
        KeyValuePairs keyValuePairs = buckets.get(hashCode);
        buckets.set(hashCode, null);
        size--;
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


    /**
     * 判断是否达到阈值
     */
    public boolean checkLoadFactor() {
        return size / buckets.size() > loadFactor;
    }

    /**
     * 扩容
     *
     * @param originalList
     * @return
     */
    public List<KeyValuePairs> extend(List<KeyValuePairs> originalList) {
        //获取数组长度
        int num = originalList.size() * (extendRatio - 1);
        for (int i = 0; i < num; i++) {
            originalList.add(null);
        }
        return originalList;
    }

    public static void main(String[] args) {
        ArrayHashMap arrayHashMap = new ArrayHashMap(5);
        System.out.println("ArrayHashMap 初始化2条数据");
        arrayHashMap.push(1, "wangzijian1");
        arrayHashMap.push(2, "wangzijian2");
        arrayHashMap.push(3, "wangzijian2");
        arrayHashMap.push(4, "wangzijian2");
        arrayHashMap.push(5, "wangzijian2");

        System.out.println(arrayHashMap.buckets);
        System.out.println("扩容前buckets长度:" + arrayHashMap.buckets.size());
        arrayHashMap.push(6, "wangzijian11");
        System.out.println("\n 进行了扩容,解决了冲突：" + arrayHashMap.buckets);
        System.out.println("扩容后buckets长度:" + arrayHashMap.buckets.size());


    }
}
