import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println("Size of stack: " + intStack.size());
        System.out.println("Top element of stack: " + intStack.peek());

        int poppedItem = intStack.pop();
        System.out.println("Popped element: " + poppedItem);
        System.out.println("Size of stack after pop: " + intStack.size());
    }
}
