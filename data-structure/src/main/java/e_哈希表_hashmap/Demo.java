package e_哈希表_hashmap;

import java.util.HashMap;

/**
 * Java 中的hashMap
 *
 * @author zijian Wang
 */
public class Demo {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("1", "wangzijian1");
        hashMap.put(2, "wangzijian2");
        System.out.println(hashMap);
        System.out.println(hashMap.get("1").hashCode());
        System.out.println(hashMap.get(2).hashCode());
        Integer num = 2;
        System.out.println(num.hashCode());
    }
}
