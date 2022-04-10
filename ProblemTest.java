import java.util.Stack;
import org.junit.Test;

/**
 * @author : pan.yuan2
 * @version : 1.0
 * @Description :
 * @taskId : 000000
 * @CreateDate : 19:27 2022/4/10
 * @see : PACKAGE_NAME
 */
public class ProblemTest {

    @Test
    public void problem1() {
        Problem.CachedData cachedData = new Problem.CachedData();
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        // 第一次直接返回
        System.out.println(cachedData.processCachedData("stack1", stack1));
        // 第二次从缓存取
        System.out.println(cachedData.processCachedData("stack1", stack1));
    }

    @Test
    public void problem2() {
        Problem.MyQueue myQueue = new Problem.MyQueue();
        // 插入
        myQueue.push(1);
        myQueue.push(2);
        // 打印头部
        System.out.println(myQueue.peek());
        // 是否为空
        System.out.println(myQueue.empty());
        // 打印弹出
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        // 是否为空
        System.out.println(myQueue.empty());
    }

    @Test
    public void problem3() {
        Problem.LRU lru = new Problem.LRU();
    }
}
