import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        List<Object> output = new ArrayList<>();
        output.add(null);
        myHashSet.add(1);
        output.add(null);
        myHashSet.add(2);
        output.add(null);
        output.add(myHashSet.contains(1));
        output.add(myHashSet.contains(3));
        myHashSet.add(2);
        output.add(null);
        output.add(myHashSet.contains(2));
        myHashSet.remove(2);
        output.add(null);
        output.add(myHashSet.contains(2));
        System.out.println(output);
    }
}
class MyHashSet {
    private boolean[] set;
    public MyHashSet() {
        set = new boolean[1000001];
    }
    public void add(int key) {
        set[key] = true;
    }
    public void remove(int key) {
        set[key] = false;
    }
    public boolean contains(int key) {
        return set[key];
    }
}
