package gw;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentNavigableMap;

public class ConcurrentNavigableMapDEMO {
    public static void main(String[] args) {
                //构建映射对象
                ConcurrentNavigableMap<String,String> map=new ConcurrentSkipListMap<>();
                map.put("Peter","a");
                map.put("Tom","b");
                map.put("Jerry","c");
                map.put("Frank","d");
                map.put("Cinda","e");
                map.put("Alice","f");
                map.put("Jack","g");
                //从头部开始截取到指定位置  不包括指定位置
                System.out.println(map.headMap("Jerry"));
                //从指定的位置截取到尾部 包含指定位置
                System.out.println(map.tailMap("Jerry"));
                //截取指定范围的位置的数据  包头不包尾
                System.out.println(map.subMap("Frank","Jerry"));
                System.out.println(map);
            }
        }


