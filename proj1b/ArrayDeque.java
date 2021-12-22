public class ArrayDeque<T> implements Deque<T>{

    private T[] item;
    private int size;
    private int nextfirst;
    private int nextlast;


    /** Parameter Constructor */
    public ArrayDeque(){
        item = (T[]) new Object[8];
        size = 0;
        nextfirst= item.length/2;
        nextlast = item.length/2+1;
    }

    /** Parameter Constructor with deep copy */
    public ArrayDeque(ArrayDeque other){
        System.arraycopy(other.item,0,item,0,other.size());
        size = other.size();
        nextfirst = other.item.length/2;
        nextlast = other.item.length/2+1;
    }

    /** If the size of array is equal to item.length, resize item[] */
    @Override
    public void resize(){
        T[] temp = (T[]) new Object[item.length<<1];
        for(int i=0;i<size;i++){
            temp[item.length/2+i] = get(i);
        }
        nextfirst = item.length/2-1;
        nextlast = item.length/2+size;
        item = temp;
    }

    /** If the size of array is less than item.length/4, resize item[] */
    @Override
    public void desize(){
        T[] temp = (T[]) new Object[item.length>>1];
        for(int i=0;i<size;i++){
            temp[temp.length/2+i] = get(i);
        }
        nextfirst = temp.length/2-1;
        nextlast = temp.length/2+size;
        item = temp;
    }

    /** Adds an item of type T to the front of the deque */
    @Override
    public void addFirst(T i){
        if(size==item.length){
            resize();
        }
        item[nextfirst] = i;
        nextfirst--;
        if (nextfirst ==-1){
            nextfirst = item.length-1;
        }
        size++;

    }

    /** Adds an item of type T to the back of the deque */
    @Override
    public void addLast(T i){
        if(size==item.length){
            resize();
        }
        item[nextlast] = i;
        nextlast++;
        if (nextlast==item.length){
            nextlast = 0;
        }
        size++;
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
            System.out.print(this.get(i)+",");
            if (i==this.size()-1){
                System.out.println("");
            }
        }
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    @Override
    public T removeFirst(){
        T temp = item[nextfirst+1];
        size --;
        nextfirst++;
        if(size<item.length/4){
            desize();
        }
        return temp;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    @Override
    public T removeLast(){
        T temp = item[nextlast-1];
        size --;
        nextlast--;
        if(size<item.length/4){
            desize();
        }
        return temp;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque! */
    @Override
    public T get(int index){
        int realindex = (index+nextfirst+1)%item.length;
        return item[realindex];
    }
}
