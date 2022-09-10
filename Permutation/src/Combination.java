import java.util.ArrayList;
import java.util.Arrays;

public class Combination {
    //123的组合---for循环
    public static void main6(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<Integer> lastArr = new ArrayList<Integer>(10);
        for (int i = 0; i < arr.length; i++) {
            lastArr.add(arr[i]);
        }
        for (int j = 0; lastArr.size() > 0 && j < lastArr.size(); j++) {
            int data = lastArr.get(j);
            lastArr.remove(j);
            for (int k = 0; k < lastArr.size(); k++) {
                System.out.println(data + "," + lastArr.get(k));
            }
        }
    }


    //全组合-递归
    public static void main7(String[] args) {
        int[] arr={1,2,3};
        combination(0,2,arr);
    }

    public static ArrayList<Integer> arrayList=new ArrayList<>();
    public static void combination(int index, int num, int[] arr) {
        if(num==0){
            return;
        }else if(num==1){
            for(int i=index;i<arr.length;i++){
                arrayList.add(arr[i]);
                System.out.println(arrayList.toString()+",");
                arrayList.remove((Object)arr[i]);
            }
        }else{
            for(int i=index;i<=arr.length-num;i++){
                arrayList.add(arr[i]);
                combination(i+1,num-1,arr);
                arrayList.remove((Object)arr[i]);
            }
        }
    }

    //子集
    public static void main8(String[] args) {
        int[] arr={1,2,3};
        System.out.println(Arrays.toString((new int[]{})));
        for(int i=0;i<arr.length;i++)
            combination(0,i,arr);
    }
}
