package top.oyoung.springbootdemo;

import java.util.concurrent.*;

public class Test {

    static class Call implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "young";
        }
    }
    public static void main(String[] args) {

        FutureTask<String> task = new FutureTask<String>(new Call());
        new Thread(task).start();
        while(!task.isDone()){
            System.out.println("ing");

        }
        System.out.println("end");
    }
}
