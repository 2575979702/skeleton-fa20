public class LinkedListDeque<T> implements Deque<T>{

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
        public Node(T item){
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }
    @Override
    public void resize(){};
    @Override
    public void desize(){};

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
    @Override
    public void addFirst(T item){
        Node cur = new Node(item);
        if(size==0) {
            sentinel.next = cur;
            sentinel.prev = cur;
            cur.next = sentinel;
            cur.prev = sentinel;
        }else{
            sentinel.next.prev = cur;
            sentinel.next = cur;
            cur.next = sentinel.next.next;
            cur.prev = sentinel;
        }
        // Null pointer here
        size +=1;
    }

    /** Adds an item of type T to the back of the deque */
    @Override
    public void addLast(T item){
        Node cur = new Node(item);
        if(size==0) {
            sentinel.next = cur;
            sentinel.prev = cur;
            cur.next = sentinel;
            cur.prev = sentinel;
        }else{
            sentinel.prev.next = cur;
            sentinel.prev = cur;
            cur.next = sentinel;
            cur.prev = sentinel.prev.prev;
        }
        // Null pointer here
        size +=1;
    }

    /** Returns true if deque is empty, false otherwise */
    @Override
    public boolean isEmpty(){
        return size ==0;
    }

    /** Returns the number of items in the deque */
    @Override
    public int size(){
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line. */
    @Override
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
    @Override
    public T removeFirst(){
        T temp = this.get(0);
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
        return temp;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    @Override
    public T removeLast(){
        T temp = this.get(size-1);
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return temp;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque! */
    @Override
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

//public class LinkedListDeque<T> {
//    private Node sentinel;
//    private int size;
//
//    public class Node{
//        public Node prev;
//        public T item;
//        public Node next;
//
//        public Node(T item, Node prev, Node next){
//            this.item = item;
//            this.prev = prev;
//            this.next = next;
//        }
//
//        public Node(T item){
//            this.item = item;
//            this.prev = null;
//            this.next = null;
//        }
//    }
//
//    /** Parameter Constructor */
//    public LinkedListDeque(){
//        //Cast integer to Object then to T
//        sentinel = new Node((T) (Object)(-1));
//        size = 0;
//    }
//
//    /** Parameter Constructor with deep copy */
//    public LinkedListDeque(LinkedListDeque other){
//        sentinel = new Node((T) (Object)(-1));
//        size = 0;
//
//        for(int i=0;i<other.size();i++){
//            this.addLast((T) other.get(i));
//        }
//
//    }
//
//    /** Adds an item of type T to the front of the deque */
//    public void addFirst(T item){
//        Node cur = new Node(item);
//        if(size==0) {
//            sentinel.next = cur;
//            sentinel.prev = cur;
//            cur.next = sentinel;
//            cur.prev = sentinel;
//        }else{
//            sentinel.next.prev = cur;
//            sentinel.next = cur;
//            cur.next = sentinel.next.next;
//            cur.prev = sentinel;
//        }
//        // Null pointer here
//        size +=1;
//    }
//
//    /** Adds an item of type T to the back of the deque */
//    public void addLast(T item){
//        Node cur = new Node(item);
//        if(size==0) {
//            sentinel.next = cur;
//            sentinel.prev = cur;
//            cur.next = sentinel;
//            cur.prev = sentinel;
//        }else{
//            sentinel.prev.next = cur;
//            sentinel.prev = cur;
//            cur.next = sentinel;
//            cur.prev = sentinel.prev.prev;
//        }
//        // Null pointer here
//        size +=1;
//    }
//
//    /** Returns true if deque is empty, false otherwise */
//    public boolean isEmpty(){
//        return size ==0;
//    }
//
//    /** Returns the number of items in the deque */
//    public int size(){
//        return size;
//    }
//
//    /** Prints the items in the deque from first to last, separated by a space.
//     * Once all the items have been printed, print out a new line. */
//    public void printDeque(){
//        for (int i=0;i<this.size();i++){
//            System.out.print(this.get(i)+" ");
//            if (i==this.size()-1){
//                System.out.println("");
//            }
//        }
//    }
//
//    /** Removes and returns the item at the front of the deque.
//     * If no such item exists, returns null. */
//    public T removeFirst(){
//        T temp = this.get(0);
//        sentinel.next = sentinel.next.next;
//        sentinel.next.prev = sentinel;
//        size --;
//        return temp;
//    }
//
//    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
//    public T removeLast(){
//        T temp = this.get(size-1);
//        sentinel.prev = sentinel.prev.prev;
//        sentinel.prev.next = sentinel;
//        size --;
//        return temp;
//    }
//
//    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
//     * If no such item exists, returns null. Must not alter the deque! */
//    public T get(int index){
//        if(index<0&&index>=this.size()){
//            return null;
//        }
//        int i = 0;
//        Node temp = sentinel.next;
//        while (i<index){
//            temp = temp.next;
//            i++;
//        }
//        return temp.item;
//    }
//
//}
