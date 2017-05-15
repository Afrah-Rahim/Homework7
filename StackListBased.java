// Assumes that the classes ListInterface and ListReferenceBased are available
 
public class StackListBased implements StackInterface {
  private ListInterface list;

  public StackListBased() {
    list = new ListReferenceBased(); 
  }  // end default constructor
  
  public boolean isEmpty() {
    return list.isEmpty();
  }  // end isEmpty
     
  public void push(Object newItem) {
    list.add(1, newItem);
  }  // end push
  
  public Object pop() throws StackException {
    if (!list.isEmpty()) {
      Object temp = list.get(1);
      list.remove(1);
      return temp;
    }
    else {
      throw new StackException("StackException on " +
                               "pop: stack empty");
    }  // end if
  }  // end pop
  
  public void popAll() {
    list.removeAll();
  }  // end popAll
  
  public Object peek() throws StackException {
    if (!isEmpty()) {
      return list.get(1);
    }
    else {
      throw new StackException("StackException on " +
                               "peek: stack empty");
    }  // end if
  }  // end peek
}  // end StackListBased