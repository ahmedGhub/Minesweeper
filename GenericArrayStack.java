public class GenericArrayStack<E> implements Stack<E> {

  private int top;

     private E[] storage;
   // Constructor
    public GenericArrayStack( int capacity ) {
      if (capacity <= 0){
        System.out.println("Stack's capacity must be positive");
    }
    else{
      storage = (E[]) new Object [capacity];
      top = -1;
  }
}

    public boolean isEmpty() {
       return (top == -1);
    // ADD YOU CODE HERE

    }

    public void push( E elem ) {
      if (top == storage.length){
        System.out.println("Stack's underlying storage is overflow");
      }
      else{
          top++;
          storage[top] = elem;
  }
}


    public E pop() {
       if (top == -1){
           System.out.println("Stack is empty");
           return null;

       }
       else{
         int reserved = top;
         top--;
         return storage[reserved];

       }

    // ADD YOU CODE HERE

    }

    public E peek() {
      if (top == -1){
        System.out.println("Stack is empty");
        return null;
}
else{
  return storage[top];
    }
}
}
