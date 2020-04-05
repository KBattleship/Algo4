/***
 **
 ** @Author: CheneyHao
 ** @Despriction: 主函数调用
 ** @Mail: yinzhihao@btte.net
 ** @Data: Created in 上午9:35 2018/9/12
 **
 ***/
public class Main {

    public static void main(String[] args) {
        int[] array={2,6,4,9,1,8,4};
        int[] res=bubbleSort(array);
        for(int i:res){
            System.out.println(i);
        }

    }

    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int tem = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tem;
                }
            }
        }
        return array;
    }
}
