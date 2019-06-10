/*
题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
都按先录入排列在前的规则处理。

例示：
jack      70
peter     96
Tom       70
smith     67

从高到低  成绩
peter     96
jack      70
Tom       70
smith     67

从低到高
smith     67
Tom       70
jack      70
peter     96


输入描述:
输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开



输出描述:
按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开

示例1
输入
3
0
fang 90
yang 50
ning 70

输出
fang 90
ning 70
yang 50
*/
package bishi0609;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int a = sc.nextInt();
            String[][] nums = new String[n][2];
            int[] count = new int[n];
            for(int i = 0;i<n;i++){
                nums[i][0] = sc.next();
                nums[i][1] = sc.next();
            }
            for(int i = 0;i<n-1;i++){
                for(int j = i+1;j<n;j++){
                    if(a == 0){
                        if(Integer.valueOf(nums[i][1]).compareTo(Integer.valueOf(nums[j][1])) >-1){
                            count[i] ++;
                        }else{
                            count[j]++;
                        }
                    }else{
                        if(Integer.valueOf(nums[i][1]).compareTo(Integer.valueOf(nums[j][1])) >0){
                            count[i] ++;
                        }else{
                            count[j]++;
                        }
                    }
                }
            }
            changeStr(nums,n,count);

            if(a == 0){  //降序
                for(int i = n-1;i>-1;i--){
                    System.out.print(nums[i][0] + " ");
                    System.out.println(nums[i][1]);
                }
            }else{//升序
                for(int i = 0;i<n;i++){
                    System.out.print(nums[i][0] + " ");
                    System.out.println(nums[i][1]);
                }
            }
        }



    }
    public static void changeStr(String[][] nums,int n,int[] count){
        int i = 0;
        while(i <n){
            if(count[i] == i){
                i++;
            }else{
                String s0 = nums[count[i]][0];
                String s1 = nums[count[i]][1];
                nums[count[i]][0] = nums[i][0];
                nums[count[i]][1] = nums[i][1];
                nums[i][0] = s0;
                nums[i][1] = s1;
                int tmp = count[i];
                count[i] = count[count[i]];
                count[tmp] = tmp ;
            }
        }
    }
}
