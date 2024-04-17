import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class CustomStack<T> {
    private List<T> stack;

    public CustomStack(){
        stack=new ArrayList<>();
    }

    public void  push(T item){
        stack.add(item);
    }

    public T pop(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return stack.remove(stack.size()-1);
    }

    public int size(){
       return stack.size();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        CustomStack<Integer>  stackOfInteger=new CustomStack<>();
        stackOfInteger.push(23);
        stackOfInteger.push(43);
        stackOfInteger.push(33);
        System.out.println(stackOfInteger.isEmpty());

CustomStack<String> stackOfString=new CustomStack<>();
stackOfString.push("food");
stackOfString.push("cows");
System.out.println(stackOfString.size());
    }
}