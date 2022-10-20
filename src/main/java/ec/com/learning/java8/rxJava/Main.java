package ec.com.learning.java8.rxJava;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    private List<Integer> list1;
    private List<Integer> list2;

    public Main() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        this.fillLists();
    }

    public void fillLists() {
        for (int i = 0; i < 1000; i++) {
            list1.add(i);
            list2.add(i);
        }
    }

    public void find() {
        Observable<Integer> obs1 = Observable.from(list1);
        Observable<Integer> obs2 = Observable.from(list2);

        /*
        // java 7
        Observable.merge(obs1, obs2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer number) {
                if (number == 1) {
                    System.out.println(number);
                }
            }

        });*/
        
        // java 8
        Observable.merge(obs1, obs2).filter(x -> x == 1).subscribe(System.out::println);
        Observable.merge(obs1, obs2).filter(x -> x == 1).subscribe(x -> {
            if(x==1){
                System.out.println(x);
            }
        });
    }

    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        list.add("Steven");
        list.add("Andres");
        list.add("German");
        list.add("Gregorio");
        
        Observable<String> obs = Observable.from(list);
        obs.subscribe(new Action1<String>(){
            @Override
            public void call(String t) {
                System.out.println(t);
            }
            
        });*/
        Main app = new Main();
        app.find();
    }

}
