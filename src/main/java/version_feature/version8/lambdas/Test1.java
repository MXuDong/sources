package version_feature.version8.lambdas;

/**
 * @author Dong
 */

public class Test1 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是匿名类");
            }
        });
    }
}
