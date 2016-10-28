package com.levelp.antonova;

/**
 * Created by katrushka on 27.10.2016.
 */
public class CustomArrayList {
  private Object[] array;

  public void add(Object element) {
    if (array == null) {
      array = new Object[]{element};
    } else {
      Object[] a = array;
      array = new Object[array.length + 1];
      for (int i = 0; i < a.length; i++) {
        array[i] = a[i];
      }
      array[a.length] = element;
    }
  }

  public void add(Object element, int i) {
    if (array == null && i == 0) {
      add(element);
      return;
    }
    if ((array == null && i != 0) || i < 0 || i > array.length - 1) {
      throw new IndexOutOfBoundsException("Ошибка");
    }
    array[i] = element;
  }

  public Object getElement(int i) {
    if (array == null || i < 0 || i > array.length - 1) {
      throw new IndexOutOfBoundsException("Ошибка");
    }
    return array[i];
  }

  public void deleteElement(int i) {
    if (array == null || i < 0 || i > array.length - 1) {
      throw new IndexOutOfBoundsException("Ошибка");
    }
    Object[] tempArray = array;
    array = new Object[array.length - 1];
    for (int j = 0; j < tempArray.length; j++) {
      if (i == j) {
        continue;
      }
      if (j > i) {
        array[j - 1] = tempArray[j];
      } else {
        array[j] = tempArray[j];
      }
    }
  }

  public boolean isEmptyArray() {
    return array == null || array.length == 0;
  }


  public int size() {
    return array != null ? array.length : 0;
  }
}
