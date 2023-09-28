import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mapdemo {
    public  static  void main(String[] args){
        Map<String,String> A = new HashMap<>();
        //特殊的数据结构，数组加链表，所有的map以下的方法都可以用
        A.put("foo", "17");
        A.put("bar", "19");
        A.put("bar", "17");
        System.out.println(A);//一个值只有一个哈希值
        System.out.println(A.get("foo"));
        Set<Map.Entry<String,String>> entries = A.entrySet();
        for (Map.Entry<String,String> entry : entries){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }

}
