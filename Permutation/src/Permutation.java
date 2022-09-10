import java.util.ArrayList;

public class Permutation {
    //for循环全排列-可重复
    public static void main1(String[] args) {
        int arr[] = {1, 2, 3, 4};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    for (int o = 0; o < arr.length; o++) {
                        System.out.println(arr[i] + "," + arr[j] + "," + arr[k] + "," + arr[o]);
                    }
                }
            }
        }
    }

    //如果下表每次不重复的话，打印1，2，3，4
    public static void main3(String[] args) {
        int arr[] = {1, 2, 3, 4};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int o = k + 1; o < arr.length; o++) {
                        System.out.println(arr[i] + "," + arr[j] + "," + arr[k] + "," + arr[o]);
                    }
                }
            }
        }
    }

    //for循环全排列-不重复（让下标互不相同）
    public static void main2(String[] args) {
        int arr[] = {1, 2, 3, 4};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    for (int o = 0; o < arr.length; o++) {
                        if (i != j && j != k && i != k && o != k && o != j && o != i)
                            System.out.println(arr[i] + "," + arr[j] + "," + arr[k] + "," + arr[o]);
                    }
                }
            }
        }
    }

    //递归 求10^3
    public static void main4(String[] args) {
        System.out.println(sum(3));
    }

    public static int sum(int i) {
        int result = 10;
        if (i == 0) {
            return 1;
        } else {
            result *= sum(i - 1);
        }
        return result;
    }

    //递归，根据输入的数字打印
    //1 0-9
    //2 00-99
    //3 000-999
    //5 00000-99999
    
    public static void main5(String[] args) {	
		permutation(5);	
	}

	static StringBuilder sb=new StringBuilder();
	public static void permutation(int num) {
		if(num==1) {
			for(int i=0;i<10;i++) {
				sb.append(i);
				System.out.print(sb.toString()+",");
				sb.deleteCharAt(sb.length()-1);
			}
		}else if(num>1) {
			for(int i=0;i<10;i++) {
				sb.append(i);
				permutation(num-1);
				sb.deleteCharAt(sb.length()-1);
			}
			
		}else {
			return;
		}
	}
}
    

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr, 3);
    }

    //全排列
    //1 -1
    //12 -12 21
    //123 -123 132 321 312 213 231
    public static ArrayList<Integer> tempArr = new ArrayList<>();

    public static void permutation(int[] arr, int k) {
        if (k == 1) {
            for (int i = 0; i < arr.length; i++) {
                tempArr.add(arr[i]);
                System.out.print(tempArr.toString() + ",");
//                tempArr.remove(tempArr.size()-1);//重复全排列
                tempArr.remove((Object) arr[i]);
            }
            System.out.println();
        } else if (k > 1) {
            for (int i = 0; i < arr.length; i++) {
                tempArr.add(arr[i]);
//                permutation(arr,i-1); //重复全排列
                permutation(removeDuplicate(arr, tempArr.toArray(new Integer[1])), k - 1);
                // tempArr.remove(tempArr.size()-1);//重复全排列
                tempArr.remove((Object) arr[i]);
            }
        } else {
            return;
        }
    }

    //删除重复项
    public static int[] removeDuplicate(int[] arr, Integer... elements) {
        ArrayList<Integer> lastList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean find = false;
            for (int j = 0; j < elements.length; j++) {
                if (arr[i] == elements[j]) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                lastList.add(arr[i]);
            }
        }
        int[] lastArr = new int[lastList.size()];
        for (int i = 0; i < lastList.size(); i++) {
            lastArr[i] = lastList.get(i);
        }

        return lastArr;
    }




}
