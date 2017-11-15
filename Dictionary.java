import java.util.Iterator;
/**
 * Dictionary
 */
public class Dictionary<K extends Comparable<K>, V> implements DictionaryInterface<K, V> {
  SortedList<Entry<K, V>> list = new SortedList();

  @Override
  public V add(K key, V value) {
    if(!contains(key)){
      list.add(new Entry(key,value));
      return value;
    }
    return null;
  }

  @Override
  public V remove(K key) {
    int end = list.getLength();
    int curr = 0;
    while(curr < end) {
      Entry e = list.getEntry(curr);
      if((K)e.getKey()==key) {
        list.remove(curr);
        return (V)e.getVal();
      }
      curr++;
    }
    return null;
  }
  @Override
  public V getValue(K key) {
    for (Entry e : list.toArray()) {
      if (e.getKey() == key)
        return (V)e.getVal();
    }
    return null;
  }
  @Override
  public Iterator<V> getValueIterator() {
    return null;
  }
  @Override
  public Iterator<K> getKeyIterator() {
    return null;
  }
  
  @Override
  public boolean contains(K key) {
    for (Entry e : list.toArray()) {
      if (e.getKey() == key)
        return true;
    }
    return false;
  }
  
  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }
  @Override
  public int getSize() {
    return list.getLength();
  }
  
  @Override
  public void clear() {
    list.clear();
  }

}

class Entry<Key extends Comparable, V> implements Comparable<Entry<Key,V>> {
  private Key key;
  private V val;

  Entry() {
    this(null, null);
  }

  Entry(Key k, V v) {
    key = k;
    val = v;
  }

  public Key getKey() {
    return key;
  }

  public V getVal() {
    return val;
  }

  public void setKey(Key k) {
    key = k;
  }

  public void setVal(V v) {
    val = v;
  }

  public int compareTo(Entry e) {
    return key.compareTo((Key)e.getKey());
  }
}