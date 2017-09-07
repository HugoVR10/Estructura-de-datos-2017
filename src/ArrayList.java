package Examen1;

import java.util.Arrays;
import java.util.Iterator;


/* Hugo Vazquez Reyes a01377824 */



public class ArrayList<E> implements List<E> {
	public Object[] top;
	private int size;
	private int initialCapacity = 5;
	private int extraCapacity = 5;
	
	/**
	 * Creates a new ArrayList instance with the default initial capacity.
	 */
	public ArrayList() {
		top = new Object[initialCapacity];
		size = 0;
	}
	
	/**
	 * Increases the capacity of this ArrayList instance so that it 
	 * can hold at least extraCapacity elements more.
	 * This method allocates a new array with greater capacity than the
	 * current one (top.length + extraCapacity) and copies all elements
	 * from top to the newly allocated array. The reference top is then
	 * updated to point to the new array. 
	 * @param extraCapacity increase the capacity of this ArrayList by this amount
	 */
	private void reserveExtraCapacity(int extraCapacity) {
		
		Object[] nuevoAr = new Object[initialCapacity + extraCapacity];

        for(int i = 0; i < top.length; i++)

            nuevoAr[i] = top[i];

        top = nuevoAr;

        initialCapacity = top.length;
		
		
	}
	
	/**
	 * Increases the capacity of this list if its size equals the length of the array
	 * where the data is stored. This method calls reserveExtraCapacity when (size() >= top.length).
	 * reserveExtraCapacity is called using the instance variable extraCapacity.
	 */
	private void ensureCapacity() {
		Object[] newArray = new Object[initialCapacity + extraCapacity];

        for(int i = 0; i < top.length; i++)

            newArray[i] = top[i];

        top = newArray;

        initialCapacity = top.length;
		
	}
	
	/**
	 * Shifts elements in the array (top) to the right, starting at the given position.
	 * @param index the position in which the shift will begin
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	private void shiftContentsRight(int index) {
		if(index < 0 || index > size())

            throw new IndexOutOfBoundsException();

        this.ensureCapacity();

        for(int i = size()-1; i >= index; i--)

            top[i+1] = top[i];
		
		
	}
	
	@Override
	public void addFirst(E e) {
		this.ensureCapacity();

        this.shiftContentsRight(0);

        top[0] = e;

        size++;
		
		
		
	}

	@Override
	public void addLast(E e) {
		this.ensureCapacity();

        top[size()] = e;

        size++;
		
		
		
		
	}

	@Override
	public void add(int index, E element) {
		
		if(index < 0 || index > size())

            throw new IndexOutOfBoundsException();

        this.ensureCapacity();

        this.shiftContentsRight(index);

        top[index] = element;

        size++;
		
		
		
		
		
		
	}

	@Override
	public E getFirst() {
		
		return null;

	}

	
	@Override
	public E getLast() {
		return null;
	}

	
	@Override
	public E get(int index) {
		
		
		
		
		return null;
	}

	@Override
	public E set(int index, E element) {
		return null;
	}

	@Override
	public void clear() {
		
		for(int i = 0; i < top.length; i++)

            top[i] = null;

        size = 0;

		
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
		
	}
	
	
	@Override
	public String toString() {
		
		if(size() == 0) {

             return "[]";}

	
		String regresaArreglo = "[" + String.valueOf(top[0]);

         for(int i = 1; i < size();i++) {

             regresaArreglo += ", " + String.valueOf(top[i]);

         regresaArreglo += "]";}

         return regresaArreglo;

	}
}
