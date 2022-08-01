import java.util.*;

class Program {
  static class LRUCache {
    
    Map<String, DoublyLinkedListNode> cache  = new HashMap<String, DoublyLinkedListNode>();
    
    int maxSize;
    int currentSize = 0;
    DoublyLinkedList listOfMostRecent = new DoublyLinkedList();
    public LRUCache(int maxSize) {
      this.maxSize = maxSize > 1 ? maxSize : 1;
    }

    public void insertKeyValuePair(String key, int value) {
      if(!cache.containsKey(key)) {
        if(currentSize == maxSize){
          evictLeastRecent();
        } 
        else currentSize++;
        cache.put(key, new DoublyLinkedListNode(key, value));
      } 
      else replaceKey(key, value);
      updateMostRecent(cache.get(key));
    }

    public LRUResult getValueFromKey(String key) {
      if(!cache.containsKey(key)){
        return new LRUResult(false, -1);
      }
      updateMostRecent(cache.get(key));
      return new LRUResult(true, cache.get(key).value);
    }

    public String getMostRecentKey() {
      if(listOfMostRecent.head == null) return "";
      return listOfMostRecent.head.key;
    }
    
    public void evictLeastRecent(){
      String keyToRemove = listOfMostRecent.tail.key;

      listOfMostRecent.removeTail();
      cache.remove(keyToRemove);
    }
    
    public void updateMostRecent(DoublyLinkedListNode node){
       listOfMostRecent.setHeadTo(node);
      }
    
    public void replaceKey(String key, int value){
       if(!this.cache.containsKey(key)) return;
      cache.get(key).value = value;
      }
  }
