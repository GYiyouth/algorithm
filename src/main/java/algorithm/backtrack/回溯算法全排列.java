package algorithm.backtrack;

import com.google.common.collect.Lists;


import java.util.ArrayList;
import java.util.List;

/**
 * @link https://labuladong.gitbook.io/algo/bi-du-wen-zhang/hui-su-suan-fa-xiang-jie-xiu-ding-ban
 *
 */
public class 回溯算法全排列 {

    public static void main(String[] args) {
        数组全排列();
    }

    /**
     * 假设给出一组数字，不重复，请给出他的全排列组合
     * 比如:1,2,3
     * 得到
     * 123
     * 132
     * 231
     * 213
     * 321
     * 312
     */
    public static void 数组全排列(){
        List<Integer> rawInput = Lists.newArrayList(1,2,3,4,5,6);
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> nowPathList = new ArrayList<>();
        List<Integer> remainChoice = new ArrayList<>(rawInput);
        traverseEveryPath(resultList, nowPathList, remainChoice);
        int index = 0;
        for (List<Integer> list : resultList) {
            System.out.println(String.format("全排列结果[%d]:%s", ++index, list.toString()));
        }
    }

    /**
     * 遍历地做这个问题
     * @param resultList
     * @param nowPath
     * @param remainChoice
     */
    public static void traverseEveryPath(List<List<Integer>> resultList, List<Integer> nowPath, List<Integer> remainChoice){
        if (remainChoice.size() == 0){
            resultList.add(Lists.newArrayList(nowPath));
            return;
        }
        for (Integer targetValue : remainChoice) {
            nowPath.add(targetValue);
            List<Integer> tempList = Lists.newArrayList(remainChoice);
            tempList.remove(targetValue);
            traverseEveryPath(resultList, nowPath, tempList);
            nowPath.remove(targetValue);
        }
    }
}
