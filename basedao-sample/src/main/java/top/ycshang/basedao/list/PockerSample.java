package top.ycshang.basedao.list;

import java.util.*;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-26 00:09
 **/
public class PockerSample {
    public static void main(String[] args) {
        // 定义一个Map集合用来存储牌号和牌
        Map<Integer, String> pockerMap = new HashMap<>(8);
        //定义一个List集合用来存储牌号
        List<Integer> pockerList = new ArrayList<>();
        String[] colors = "♥-♠-♦-♣".split("-");
        String[] nums = "2-A-K-Q-J-10-9-8-7-6-5-4-3".split("-");
        int index = 2;
        for (String num : nums) {
            for (String color : colors) {
                String thisPocker = color + num;
                //将扑克牌放入Map集合
                pockerMap.put(index, thisPocker);
                //将牌号放入到pockerList集合中
                pockerList.add(index);
                index++;
            }
        }
        //将大王小王添加到集合
        pockerMap.put(0, "大王");
        pockerMap.put(1, "小王");
        pockerList.add(0);
        pockerList.add(1);
        //洗牌
        Collections.shuffle(pockerList);
        //发牌
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        List<Integer> player3 = new ArrayList<>();
        List<Integer> diPai = new ArrayList<>();
        //遍历牌号的集合 判断索引发牌号
        for (int i = 0; i < pockerList.size(); i++) {
            Integer pockerNum = pockerList.get(i);
            if (i >= 51) {
                diPai.add(pockerNum);
            } else if (i % 3 == 0) {
                player1.add(pockerNum);
            } else if (i % 3 == 1) {
                player2.add(pockerNum);
            } else {
                player3.add(pockerNum);
            }
        }
        //	排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(diPai);
        show("张三", player1, pockerMap);
        show("李四", player2, pockerMap);
        show("王五", player3, pockerMap);
        show("底牌", diPai, pockerMap);
    }

    /**
     * 定义方法 看牌
     *
     * @param name      入参
     * @param player    入参
     * @param pockerMap 入参
     */
    private static void show(String name, List<Integer> player, Map<Integer, String> pockerMap) {
        System.out.print(name + ":");
        for (Integer pockerNum : player) {
            String thisPocker = pockerMap.get(pockerNum);
            System.out.print(thisPocker + " ");
        }
        System.out.println();
    }
}