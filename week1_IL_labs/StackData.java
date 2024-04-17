package week1_IL_labs;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackData<T> {
    public ArrayList<T> stack;
    public StackData() {
        stack = new ArrayList();
    }
public void push(T item){
        stack.add(item);
}
    public T pop(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
      return   stack.removeLast();
    }

    public void display(){
        for(int i=0;i<stack.size();i++){
            System.out.println(stack.get(i));
        }
    }

    public static void main(String[] args) {
   StackData<Integer> intStack=new StackData();
   intStack.push(12);
        intStack.push(13);
        intStack.push(14);
        intStack.push(15);
        intStack.pop();
   intStack.display();


        StackData<String> stringStack=new StackData<>();
        stringStack.push("hi hi ");
        stringStack.push("hello ");
        stringStack.display();

    }




}
