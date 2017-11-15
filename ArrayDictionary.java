/**
 * ArrayDictionary
 */
import java.util.Iterator;

public class ArrayDictionary<K extends Comparable<K>, V> implements DictionaryInterface<K, V> {
  SortedListArray<Entry<K, V>> list = new SortedListArray();

  @Override
  public V add(K key, V value) {
    if (!contains(key) && !list.isFull()) {
      list.add(new Entry(key, value));
      return value;
    }
    return null;
  }

  @Override
  public V remove(K key) {
    int end = list.getLength();
    int curr = 0;
    while (curr < end) {
      Entry e = list.getEntry(curr);
      if ((K) e.getKey() == key) {
        list.remove(curr);
        return (V) e.getVal();
      }
      curr++;
    }
    return null;
  }

  @Override
  public V getValue(K key) {
    for (Entry e : list.toArray()) {
      if (e.getKey() == key)
        return (V) e.getVal();
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