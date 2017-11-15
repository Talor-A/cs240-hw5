import java.util.Arrays;

public class SortedListArray<T extends Comparable<? super T>> implements SortedListInterface<T> {
  private int lastIndex = -1;
  private T[] list = (T[]) new Object[10];

  @Override
  public void add(T newEntry) {
    if (!isFull()) {
      lastIndex++;
      list[lastIndex] = newEntry;
      sortLastItem();
    }
  }

  @Override
  public T remove(int givenPosition) {
    T item = (T) list[givenPosition];
    for (int i = givenPosition; i < lastIndex; i++) {
      list[i] = list[i + 1];
    }
    list[lastIndex] = null;
    lastIndex--;
    sort();
    return item;
  }

  @Override
  public T remove(T anEntry) {
    remove(getPosition(anEntry));
    return anEntry;
  }

  @Override
  public int getPosition(T anEntry) {
    for (int i = 0; i <= lastIndex; i++) {
      if (list[i] == anEntry) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public T getEntry(int position) {
    return (T) list[position];
  }

  @Override
  public boolean contains(T anEntry) {
    for (T item : list) {
      if (item == anEntry) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void clear() {
    for (int i = 0; i <= lastIndex; i++) {
      list[i] = null;
    }
  }

  @Override
  public T[] toArray() {
    return Arrays.copyOf(list, lastIndex+1);
  }

  @Override
  public int getLength() {
    return lastIndex + 1;
  }

  @Override
  public boolean isEmpty() {
    return lastIndex == -1;
  }

  public boolean isFull() {
    return lastIndex == 9;
  }

  public void sortLastItem() {
    T selected = list[lastIndex];
    for (int j = lastIndex - 1; j >= 0; j--) {
      T test = list[j];
      if (test.compareTo(selected) < 0) {
        list[j + 1] = test;
        list[j] = selected;
      } else {
        list[j + 1] = selected;
        break;
      }
    }
  }

  public void sort() {
    for (int i = 1; i <= lastIndex; i++) {
      T selected = list[i];
      for (int j = i - 1; j >= 0; j--) {
        T test = list[j];
        if (test.compareTo(selected) < 0) {
          list[j + 1] = test;
          list[j] = selected;
        } else {
          list[j + 1] = selected;
          break;
        }
      }
    }
  }
}