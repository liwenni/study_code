package java0328;

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Test {
    //找出只出现一次的数字
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
           Integer value =  map.get(nums[i]);
           if(value == null){
               map.put(nums[i],1);
           }else{
               map.put(nums[i],value + 1);
           }
        }
        //遍历map，找出只出现一次的数字
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return -1;
    }

    //复制带随机指针的链表
    public Node copyRandomList(Node head) {
        //1.创建一个Map，key为旧节点，value为新节点。
        Map<Node,Node> map = new HashMap<>();
        // 遍历旧链表，创建新节点，以旧链表节点作为key，新链表节点作为value
        for(Node cur = head;cur != null;cur = cur.next){
            map.put(cur,new Node(cur.val));
        }
        //再次遍历旧链表，将next连接上
        for(Node cur = head;cur != null;cur = cur.next){
            //1.连接next
            //先取出cur对应的新节点
            Node curNew = map.get(cur);
            //再取出下一个新节点，即cur.next对应的新节点
            Node curNextNew = map.get(cur.next);
            //将两节点连接
            curNew.next = curNextNew;

            //2.连接random
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }

    //宝石与石头
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < jewels.length();i++) {
            set.add(jewels.charAt(i));
        }
        for(int i = 0;i < stones.length();i++){
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }

    //坏键盘打字
    public static void brokenKey(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String expect = scanner.next();
            String actual = scanner.next();
            //转为题目要求的大写字母
            expect = expect.toUpperCase();
            actual = actual.toUpperCase();
            //将actual存入set
            Set<Character> actualSet = new HashSet<>();
            for(int i = 0;i < actual.length();i++){
                actualSet.add(actual.charAt(i));
            }
            //遍历except，将actual中没有的字符添加至坏键的set中
            Set<Character> brokenSet = new HashSet<>();
            for(int i = 0;i < expect.length();i++){
                char c = expect.charAt(i);
                if(actualSet.contains(c)){
                    continue;
                }else{
                    if(brokenSet.contains(c)){
                        continue;
                    }else{
                        System.out.print(c);
                        brokenSet.add(c);
                    }
                }
            }

        }
        System.out.println();
    }


    //前k个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        //1.用Map统计words中每个单词出现的次数
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            Integer value = map.get(word);
            if(value == null){
                map.put(word,1);
            }else{
                map.put(word,value + 1);
            }
        }
        //2.将所有的key取出来放到一个List中
        List<String> wordList = new ArrayList<>(map.keySet());
        //3.对 wordList 进行排序。
        // 需在 sort 方法的第二个参数中传入一个Comparator对象，用来指定比较规则
        Collections.sort(wordList, new Comparator<String>() { //java的匿名内部类
            @Override
            public int compare(String o1, String o2) {
                Integer count1 = map.get(o1);
                Integer count2 = map.get(o2);
                 if(count1.equals(count2)){//如果出现次数相等，就按字符串的字典序来排序
                    return o1.compareTo(o2);
                }
                return count2 - count1;
            }
        });
        return wordList.subList(0,k);
    }
}
