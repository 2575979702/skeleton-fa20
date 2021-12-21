public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    public class Node{
        public Node prev;
        public T item;
        public Node next;

        public Node(T item, Node prev, Node next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /** Parameter Constructor */
    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Parameter Constructor with deep copy */
    public LinkedListDeque(LinkedListDeque other){
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for(int i=0;i<other.size();i++){
            this.addLast((T) other.get(i));
        }

    }



    /** Adds an item of type T to the front of the deque */
    public void addFirst(T item){
        Node cur = new Node(item,sentinel,null);
        cur.next = sentinel.next;
        sentinel.next = cur;
        size +=1;
    }

    /** Adds an item of type T to the back of the deque */
    public void addLast(T item){
        Node cur = new Node(item, null, sentinel);
        cur.prev = sentinel.prev;
        sentinel.prev = cur;
        size +=1;
    }

    /** Returns true if deque is empty, false otherwise */
    public boolean isEmpty(){
        return size ==0;
    }

    /** Returns the number of items in the deque */
    public int size(){
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line. */
    public void printDeque(){
        for (int i=0;i<this.size();i++){
            System.out.print(this.get(i)+" ");
            if (i==this.size()-1){
                System.out.println("");
            }
        }
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public T removeFirst(){
        T temp = this.get(0);
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
        return temp;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast(){
        T temp = this.get(size-1);
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return temp;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque! */
    public T get(int index){
        if(index<0&&index>=this.size()){
            return null;
        }
        int i = 0;
        Node temp = sentinel.next;
        while (i<index){
            temp = temp.next;
            i++;
        }
        return temp.item;
    }

}
