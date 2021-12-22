public class OffByN implements CharacterComparator{
    private int basic = 0;
    public OffByN(int i){
        basic = i;
    }
    @Override
    public boolean equalChars(char x, char y){
        return Math.abs(x-y)==basic;
    }

}
