import java.util.Stack;

public class QueueUsingTwoStacks<T> {
    private Stack<T> stackEnqueue = new Stack<>();
    private Stack<T> stackDequeue = new Stack<>();

    public void enqueue(T value) {
         stackEnqueue.push(value);
    }

    public T dequeue() {
        shiftStacks();
        if (stackDequeue.isEmpty()) {
            return null;
        }
        return stackDequeue.pop();
    }

    public T print() {
        shiftStacks();
        if (stackDequeue.isEmpty()) {
            return null;
        }
        return stackDequeue.peek();
    }

    private void shiftStacks() {
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Phần tử đầu hàng đợi (print): " + queue.print()); // 10
        System.out.println("Dequeue: " + queue.dequeue()); // 10

        queue.enqueue(40);
        System.out.println("Phần tử đầu hàng đợi sau khi thêm 40: " + queue.print()); // 20
        System.out.println("Dequeue: " + queue.dequeue()); // 20
    }
}

