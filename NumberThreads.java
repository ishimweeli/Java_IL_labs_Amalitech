public class NumberThreads {
    public static void main(String[] args) {
        CountingThread countingThread=new CountingThread(12,22);
        CountingThread countingThread2=new CountingThread(22,32);
        countingThread.start();
        countingThread2.start();
    }

    public static class CountingThread extends Thread{
        int start;
        int end;
        public  CountingThread(int start, int end ){
            this.start=start;
            this.end=end;
        }
        public void run(){
            for(int i=start;i<end;i++){
                System.out.println(i);
                try{
                    Thread.sleep(1000);
                }catch (Exception e){

                }

            }
        }
    }
}