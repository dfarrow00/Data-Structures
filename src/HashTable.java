//Hash table implemented using separate chaining and dynamic resizing.
public class HashTable {

    private class Entry {
        public String left;
        public Integer right;

        Entry(String left, Integer right){
            this.left = left;
            this.right = right;
        }
    }

    @SuppressWarnings("unchecked")
    private LinkedList<Entry>[] table = (LinkedList<Entry>[]) new LinkedList[10];
    private int numOccupied = 0;
    private final int maxLoadFactor = 3;
    private final int minLoadFactor = 1;
    private final int minTableSize = 10;
    private boolean rehashing = false;

    private void checkLoadFactor(){
        int loadFactor = numOccupied / table.length;
        if (loadFactor >= maxLoadFactor){
            resizeArray(table.length * 2);
        }
        else if (loadFactor < minLoadFactor && table.length > minTableSize){
            resizeArray(table.length / 2);
        }
    }

    //Hash function: Sum of ASCII codes % table length.
    private int generateHash(String input){
        int sum = 0;
        char[] charInput = input.toCharArray();

        for (char letter : charInput){
            sum += (int)letter;
        }
        return sum % table.length;
    }

    @SuppressWarnings("unchecked")
    private void resizeArray(int newSize){
        rehashing = true;
        numOccupied = 0;
        LinkedList<Entry>[] oldArray = table;
        table = (LinkedList<Entry>[]) new LinkedList[newSize];
        for (int i = 0; i < oldArray.length; i++){
            if (oldArray[i] != null && !oldArray[i].isEmpty()){
                for (int j = 0; j < oldArray[i].length(); j++){
                    Entry entry = oldArray[i].get(j);
                    add(entry.left, entry.right);
                }
            }
        }
        rehashing = false;
    }

    public Integer get(String key){
        int hashCode = generateHash(key);
        for (int i = 0; i < table[hashCode].length(); i++){
            if (table[hashCode].get(i).left.equals(key)) return table[hashCode].get(i).right;
        }
        return null;
    }

    public void add(String key, Integer value){
        int hashCode = generateHash(key);
        if (table[hashCode] == null){
            table[hashCode] = new LinkedList<>();
        }
        table[hashCode].insert(0, new Entry(key, value));
        numOccupied++;
        if (!rehashing) checkLoadFactor();
    }

    public void delete(String key){
        int hashCode = generateHash(key);
        if (table[hashCode] == null || table[hashCode].isEmpty()){
            return;
        }
        for (int i = 0; i < table[hashCode].length(); i++){
            if (table[hashCode].get(i).left.equals(key)){
                table[hashCode].delete(i);
                numOccupied--;
                break;
            }
        }
        checkLoadFactor();
    }
}
