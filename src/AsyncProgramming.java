import java.util.ListIterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by rguleria on 24/08/16.
 */
public class AsyncProgramming {

    public static void main(String[] args){
        AsyncProgramming obj = new AsyncProgramming();
        CompletableFuture.supplyAsync(obj::doingSomeSuperStuff)
                          .thenApply(obj::doSomeReallyAmazingButSlowStuff)
                          .thenAccept(System.out::println);


        CompletableFuture.supplyAsync(obj::doingSomeSuperStuff)
                .thenCompose(obj::doSomeReallyAmazingButSlowStuff);





    }

    public String sumStuff(String abc){

        return abc+"2";

    }

    public String doingSomeSuperStuff(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "2";
    }

    public CompletableFuture<String> doSomeReallyAmazingButSlowStuff(String stuff){

        return CompletableFuture.completedFuture(stuff+"323");

    }

}
