 static class DoublyLinkedListNode {
    String key;
    int value;
    DoublyLinkedListNode prev = null;
    DoublyLinkedListNode next = null;

    public DoublyLinkedListNode(String key, int value){
     this.key = key;
     this.value = value;
    }

    public void removeBindings(){
      if(prev != null){
       prev.next = next;
        }
      if(next != null) next.prev = prev;
      prev= null;
      next = null;
    }
  }
