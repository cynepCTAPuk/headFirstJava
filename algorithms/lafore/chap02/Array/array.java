package lafore.chap02.Array;

// array.java demonstrates Java arrays
// to run this program: C>java arrayApp
////////////////////////////////////////////////////////////////
class ArrayApp {
  public static void main(String[] args) {
    int[] array = new int[11];
    int nElems = 0;             // number of items
    int i;                      // loop counter
    int searchKey;              // key of item to search for
//--------------------------------------------------------------
    array[0] = 77;
    array[1] = 99;
    array[2] = 44;
    array[3] = 55;
    array[4] = 22;
    array[5] = 88;
    array[6] = 11;
    array[7] = 00;
    array[8] = 66;
    array[9] = 33;
    nElems = 10;
//-------------------------------------------------------------- Печать массива
    for (i = 0; i < nElems; i++) System.out.print(array[i] + " ");
    System.out.println();
//-------------------------------------------------------------- Поиск элемента
    searchKey = 66;
    for (i = 0; i < nElems; i++) if (array[i] == searchKey) break;
    if (i == nElems) System.out.println("Can't find " + searchKey);
    else System.out.println("Found " + searchKey);
//-------------------------------------------------------------- Удаление элемента
    searchKey = 55;
    for (i = 0; i < nElems; i++) if (array[i] == searchKey) break;
    for (int k = i; k < nElems; k++) array[k] = array[k + 1];
    nElems--;
//-------------------------------------------------------------- Печать массива
    for (i = 0; i < nElems; i++) System.out.print(array[i] + " ");
    System.out.println("");
  }
}
