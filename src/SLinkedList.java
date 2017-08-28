import java.util.NoSuchElementException;

public class SLinkedList<E> implements List<E> {
	private SNode<E> top;
	private int size;
	
	public SLinkedList() {
		top = new SNode<E>();
		size = 0;
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		SNode<E> newNode = new SNode<E>(e); 
		newNode.next= top.next; 
		top.next =newNode;
		size++; 	
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		SNode<E> newNode= new SNode<E>(e); 
     	SNode<E> current=top;
		while(current.next  !=null); 
     	   current = current.next;
     	   
     	current.next = newNode; 
     	size++; 		
	}

	@Override
	public void add(int index, E element) {
		if(index < 0 ||index <= size()){
			throw new IndexOutOfBoundsException(); 
		}
		SNode<E> current = top; 
		SNode<E> newNode = new SNode<E> (element); 
		
		if(top.next != null && index==0){
			newNode.next = top.next; 
			top.next = newNode; 
			size++; 
		}else {
           for(int i = 0; i < index; i++){
             current = current.next; 
        }
           SNode<E> x = current.next; 
           current.next = newNode; 
           newNode.next = x; 
           size++; 
		}
		}
		


	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		 if(top.next==null) {
				throw new NoSuchElementException(); 				
			}
		  SNode<E> current=top.next;
		  while(current.next !=null)
			  current=current.next; 
		  return current.value; 		
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		if(top.next==null) {
			throw new NoSuchElementException(); 				
		}
	  SNode<E> current=top;
	  while(current.next.next !=null)
		  current = current.next; 
	  SNode<E> nodeToRemove = current.next; 
	  current.next=null; 
	  size --; 
	  return nodeToRemove.value; 
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		  if (index < 0 || index >= size) {
		      return null;
		    }
		    else if (index == 0) {
		      return removeFirst();
		    }
		    else if (index == size - 1) {
		      return removeLast();
		    }
		    else {
		      SNode<E> previous = top;

		      for (int i = 1; i < index; i++) {
		        previous = previous.next;
		      }

		      SNode<E> current = previous.next;
		      previous.next = current.next;
		      size--;
		return null;
		    }
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		return index == -1;
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		if(top.next==null) {
			throw new NoSuchElementException(); 				
		}
	  SNode<E> current=top.next;
	  while(current.next !=null)
		  current=current.next; 		
		return null;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		 if(top.next==null) {
				throw new NoSuchElementException(); 				
			}
		  SNode<E> current=top.next;
		  while(current.next !=null)
			  current=current.next; 
		  return current.value; 
		  
		 
	 }
		
	@Override
	public E get(int index)  {
		// TODO Auto-generated method stub
		if(index < 0 || index>size()) {
			throw new IndexOutOfBoundsException();
		}
		SNode<E> current = top;
		//Occurs if index is towards the end of the list
		for (int i =0; i<=index; i++) {
			current = current.next; 
		}
		return current.value;
		
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		if(index < 0 || index>size()) {
			throw new IndexOutOfBoundsException();
		
	}
		SNode<E> current = top;
		for (int i =0; i<=index; i++) {
			current = current.next; 
		}
		current.value=element; 
		return current.value; 
		
	}
	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		 SNode<E> current = top;
		    for (int i = 0; i < size; i++) {
		      if (current.value.equals(e))
		        return true;
		      current = current.next;
		    }

		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		int index = 0; 
		if(o==null) {
			for(SNode<E> x=top.next; x !=null; x=x.next) {
		   if(x.value==null)
			   return index;
		   index++;
			}	
		
	}
	else {
		for(	SNode<E> x= top.next; x!=null; x = x.next) {
			if(o.equals(x.value))
				return index; 
			index++; 
		}
		}
		return -1; 
	
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		 top.next= null; 
   	      size=0;	
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() ==0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] array = new Object[size];
		for (SNode<E> node=top; node != null; node = node.next) {
		}
return array;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		if(top.next==null)
			return"[]"; 
		
		SNode<E> current = top.next; 
		String returnValue = "[" + current.value; 
		while(current.next !=null) {
			current= current.next; 
			returnValue += "," +current.value; 
		}
		return returnValue += "]"; 
		
	}
}

