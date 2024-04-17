public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers={13,11,3,0,1,5,89,23};
        boolean isNotSorted=true;
while(isNotSorted){
    isNotSorted=false;
for(int i=0;i<numbers.length-1;i++){
    if (numbers[i]>numbers[i+1]) {
                int temp=numbers[i];
                numbers[i]=numbers[i+1];
                numbers[i+1]=temp;
        isNotSorted=true;
            }

        }

}
        for(int num:numbers){
            System.out.println(num);
        }




    }
}