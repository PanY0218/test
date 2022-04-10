import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : pan.yuan2
 * @version : 1.0
 * @Description :
 * @taskId : 000000
 * @CreateDate : 18:46 2022/4/10
 * @see : PACKAGE_NAME
 */
public class Problem {

    /**
     * problem 1
     */

    public static class CachedData {

        public final Map<String, Object> CACHED_DATA_MAP = new ConcurrentHashMap<>();

        public Object processCachedData(String str, Object object) {
            if(CACHED_DATA_MAP.get(str) != null) {
               return CACHED_DATA_MAP.get(str);
            }
            CACHED_DATA_MAP.put(str, object);
            return object;
        }
    }

    /**
     * problem 2
     */

    public static class MyQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if(stack2.empty()){
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if(stack2.empty()){
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.empty() && stack2.empty();
        }
    }

    /**
     * problem 3
     */

    public static class LRU {
        Map<Integer, Map<Integer, Integer>> treeMap = new TreeMap<>();

        public final int len = 5;
        public void put(int key, int value) {
            Map<Integer, Integer> map = new HashMap<>(1);
            map.put(key, value);
            // 相同的值更新最近使用频率
            if(treeMap.containsValue(map)) {
                treeMap.forEach( (k, v) -> {
                    if(compareMap(map, v)) {
                        treeMap.put(k+1, v);
                        treeMap.remove(k);
                    }
                });
            }
            else {
                treeMap.put(1, map);
            }
        }

        public int get(int key) {
            // todo
            return -1;
        }

        public boolean compareMap(Map<Integer, Integer> mapA, Map<Integer, Integer> mapB) {

            for (Map.Entry<Integer, Integer> entryA : mapA.entrySet()) {
                Integer mapAValue = entryA.getValue();
                Integer mapBValue = mapB.get(entryA.getKey());
                if (!mapAValue.equals(mapBValue)) {
                    return false;
                }
            }
            return true;
        }
    }
}
