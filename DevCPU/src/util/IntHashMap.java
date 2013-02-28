package util;

import java.util.HashSet;
import java.util.Set;

public class IntHashMap<V>
{
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  private static final int MAXIMUM_CAPACITY = 1073741824;
  private static final float DEFAULT_LOAD_FACTOR = 0.75F;
  private transient Entry<V>[] table;
  private transient int size;
  private int threshold;
  private final float loadFactor;
  private volatile transient int modCount;
  private Set<Integer> keys = new HashSet();

  public IntHashMap()
  {
    this.loadFactor = 0.75F;
    this.threshold = 12;
    this.table = new Entry[16];
  }

  private static int hash(int h) {
    h ^= h >>> 20 ^ h >>> 12;
    return h ^ h >>> 7 ^ h >>> 4;
  }

  private static int indexFor(int h, int length) {
    return h & length - 1;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public V get(int key) {
    int hash = hash(key);
    for (Entry e = this.table[indexFor(hash, this.table.length)]; e != null; e = e.next) {
      if (e.key == key) return (V) e.value;
    }
    return null;
  }

  public boolean containsKey(int key) {
    return getEntry(key) != null;
  }

  final Entry<V> getEntry(int key) {
    int hash = hash(key);
    for (Entry e = this.table[indexFor(hash, this.table.length)]; e != null; e = e.next) {
      if (e.key == key) return e;
    }
    return null;
  }

  public void put(int key, V value) {
    this.keys.add(Integer.valueOf(key));
    int hash = hash(key);
    int i = indexFor(hash, this.table.length);
    for (Entry e = this.table[i]; e != null; e = e.next) {
      if (e.key == key) {
        e.value = value;
      }
    }

    this.modCount += 1;
    addEntry(hash, key, value, i);
  }

  private void resize(int newCapacity)
  {
    Entry[] oldTable = this.table;
    int oldCapacity = oldTable.length;
    if (oldCapacity == 1073741824) {
      this.threshold = 2147483647;
      return;
    }

    Entry[] newTable = new Entry[newCapacity];
    transfer(newTable);
    this.table = newTable;
    this.threshold = (int)(newCapacity * this.loadFactor);
  }

  private void transfer(Entry<V>[] newTable) {
    Entry[] src = this.table;
    int newCapacity = newTable.length;
    for (int j = 0; j < src.length; j++) {
      Entry e = src[j];
      if (e != null) {
        src[j] = null;
        do {
          Entry next = e.next;
          int i = indexFor(e.hash, newCapacity);
          e.next = newTable[i];
          newTable[i] = e;
          e = next;
        }while (e != null);
      }
    }
  }

  public V remove(int key) {
    this.keys.remove(Integer.valueOf(key));
    Entry e = removeEntryForKey(key);
    return (V) (e == null ? null : e.value);
  }

  final Entry<V> removeEntryForKey(int key) {
    int hash = hash(key);
    int i = indexFor(hash, this.table.length);
    Entry prev = this.table[i];
    Entry e = prev;

    while (e != null) {
      Entry next = e.next;
      if (e.key == key) {
        this.modCount += 1;
        this.size -= 1;
        if (prev == e) this.table[i] = next; else
          prev.next = next;
        return e;
      }
      prev = e;
      e = next;
    }

    return e;
  }

  public void clear() {
    this.modCount += 1;
    Entry[] tab = this.table;
    for (int i = 0; i < tab.length; i++)
      tab[i] = null;
    this.size = 0;
  }

  public boolean containsValue(Object value)
  {
    if (value == null) return containsNullValue();

    Entry[] tab = this.table;
    for (int i = 0; i < tab.length; i++)
      for (Entry e = tab[i]; e != null; e = e.next)
        if (value.equals(e.value)) return true;
    return false;
  }

  private boolean containsNullValue() {
    Entry[] tab = this.table;
    for (int i = 0; i < tab.length; i++)
      for (Entry e = tab[i]; e != null; e = e.next)
        if (e.value == null) return true;
    return false;
  }

  private void addEntry(int hash, int key, V value, int bucketIndex)
  {
    Entry e = this.table[bucketIndex];
    this.table[bucketIndex] = new Entry(hash, key, value, e);
    if (this.size++ >= this.threshold) resize(2 * this.table.length); 
  }

  public Set<Integer> keySet()
  {
    return this.keys;
  }

  private static class Entry<V>
  {
    final int key;
    V value;
    Entry<V> next;
    final int hash;

    Entry(int h, int k, V v, Entry<V> n)
    {
      this.value = v;
      this.next = n;
      this.key = k;
      this.hash = h;
    }

    public final int getKey() {
      return this.key;
    }

    public final V getValue() {
      return this.value;
    }

    public final boolean equals(Object o)
    {
      if (!(o instanceof Entry)) return false;
      Entry e = (Entry)o;
      Object k1 = Integer.valueOf(getKey());
      Object k2 = Integer.valueOf(e.getKey());
      if ((k1 == k2) || ((k1 != null) && (k1.equals(k2)))) {
        Object v1 = getValue();
        Object v2 = e.getValue();
        if ((v1 == v2) || ((v1 != null) && (v1.equals(v2)))) return true;
      }
      return false;
    }

    public final int hashCode() {
      return IntHashMap.hash(this.key);
    }

    public final String toString() {
      return getKey() + "=" + getValue();
    }
  }
}