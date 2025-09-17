public class Nthread{
  public static void main(String[] args){
    int threads = 4;
    for(int i=0;i<threads;i++){
      new Thread(() -> {
        while(true){
          double x = Math.random() * Math.random();
        }
      }).start();
    }
  }

}
