public interface Deque<T> {

    public void addFirst(T item);
    public void addLast(T item);
    public boolean isEmpty();
    public int size();
    public T get(int index);
    public T removeFirst();
    public T removeLast();
    public void printDeque();
    public void resize();
    public void desize();

}
