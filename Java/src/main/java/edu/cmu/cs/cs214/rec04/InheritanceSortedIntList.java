package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.List;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {
    
    /* the number of added elements */
    private int totalAdded;

    /* the list storing elements */
    private final List<Integer> elements;

    /**
     * Constructor
     */
    public InheritanceSortedIntList() {
        // set number of added elements
        this.totalAdded = 0;

        // set element list as empty list
        this.elements = new ArrayList<>();
    }

    /**
     * Add a new element to the list, increment totalAdded
     *
     * @param val The value of the new element.
     * @return if the element is successfully added
     */
    @Override
    public boolean add(int val) {
        // add the element
        this.elements.add(val);

        // increment totalAdded
        this.totalAdded++;

        return true;
    }

    /**
     * Add a new list of elements to the list, increment totalAdded
     *
     * @param newList The list of the element to be added.
     * @return if the element is successfully added
     */
    @Override
    public boolean addAll(IntegerList newList) {
        // iterate the new list 
        for (int i = 0; i < newList.size(); i++) {
            // add the element to the list
            this.elements.add(newList.get(i));

            // increment totalAdded
            this.totalAdded++;
        }
        
        return true;
    }

    /**
     * Returns the integer at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list; 
     */
    public int get(int index) {
        
        return this.elements.get(index);
    }

    /**
     * Removes the first occurrence of the specified element from the list,
     * if it is present (optional operation).
     *
     * @param num an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    public boolean remove(int num) {

        return this.elements.remove(Integer.valueOf(num));
    }

    /**
     * Removes from the list all of its elements that are contained in the
     * specified IntegerList.
     *
     * @param list IntegerList containing elements to be removed from
     * the list
     * @return true if the list changed as a result of the call
     */
    public boolean removeAll(IntegerList rmList) {
        // iterate the list 
        for (int i = 0; i < rmList.size(); i++) {
            // remove the element to the list
            // check if successfully removed
            if (!this.elements.remove(Integer.valueOf(rmList.get(i)))) {
                return false;
            }

        }
        
        return true;
    }

    /**
     * Returns the number of elements in this list. If this list contains
     * more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return number of elements in the list
     */
    public int size() {
        if (this.elements.size() > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return this.elements.size();
    }

    /**
     * get value of totalAdded 
     *
     * @return this.totalAdded
     */
    public int getTotalAdded() {
        
        return this.totalAdded;
    }

}