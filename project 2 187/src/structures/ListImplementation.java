package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@code ListImplementation} is a Linked List that wraps {@link Node}s and provides useful
 * operations.
 */
public class ListImplementation<T> implements ListInterface<T> {
  // TODO: Add the sensible instance variables for a linked list implementation.
  private int size;
  private Node<T> head;
  private Node<T> tail;
  

  public ListImplementation() {
    // TODO: Initialize instance variables.
    size = 0;
    head = null; 
    tail = null;

  }

  /** Returns the number of nodes in this list. */
  @Override
  public int size() {
    // TODO: return the size of the list.
    return size;
  }

  @Override
  public boolean isEmpty() {
    // TODO: Return true if the list is empty; false otherwise
    return size == 0;
  }

  /**
   * Appends {@code elem} to the end of this {@code ListImplementation} and returns itself for
   * convenience.
   */
  @Override
  public ListImplementation<T> append(T elem) {
    // TODO: Append an item to the list
    if(isEmpty()){
        head = new Node<T>(elem,null);
        tail = head;
        size++;
    } else{
        tail.setNext(new Node<T>(elem,null));
        tail = tail.getNext();
        size++;
    }
    return this;
  }

  /** Gets the {@code n}th element from this list. */
  @Override
  public T get(int n) {
    // TODO: Get an item from the list at the given index.
    Node<T> newHead = head;
    for(int i=0;i < n; i++){
      if(newHead == null){
        return null;
      } else {
        newHead = newHead.getNext();
      }
    }

    return newHead.getData();
  }

  /**
   * Returns an iterator over this list. The iterator does not support the {@code remove()} method.
   */
  @Override
  public Iterator<T> iterator() {
    // TODO: Return an iterator over this list.
      class newIterator implements Iterator<T>{
        private Node<T> newHead;
        public newIterator(Node<T> starthead) {
          newHead = starthead;
        }
        @Override
        public boolean hasNext(){
          if(newHead != null){
            return true;
          }
          return false;
        }
        @Override
        public T next(){
          if(!this.hasNext()){
            throw new NoSuchElementException();
          } else {
            T data = newHead.getData();
            newHead = newHead.getNext();
            return data; 
          }
        }
        @Override
          public void remove(){
            return;
          }
    }
    return new newIterator(head);
   }
}
