package lafore.chap11.hash;
// hash.java
// demonstrates hash table with linear probing
// to run this program: C:>java HashTableApp

import java.io.*;

////////////////////////////////////////////////////////////////
class DataItem {                                // (could have more data)
    private int iData;               // data item (key)

    //--------------------------------------------------------------
    public DataItem(int ii) {  // constructor
        iData = ii;
    }

    //--------------------------------------------------------------
    public int getKey() {
        return iData;
    }
//--------------------------------------------------------------
}  // end class DataItem

////////////////////////////////////////////////////////////////
class HashTable {
    private DataItem[] hashArray;      // array holds hash table
    private int arraySize;
    private DataItem nonItem;          // for deleted items

    // -------------------------------------------------------------
    public HashTable(int size) {       // constructor
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); // deleted item key is -1
    }

    // -------------------------------------------------------------
    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) System.out.print(hashArray[j].getKey() + " ");
            else System.out.print("** ");
        }
        System.out.println();
    }

    // -------------------------------------------------------------
    public int hashFunc(int key) {
        return key % arraySize;       // hash function
    }

    // -------------------------------------------------------------
    public void insert(DataItem item) { // insert a DataItem (assumes table not full)
        int key = item.getKey();        // extract key
        int hashVal = hashFunc(key);    // hash the key

        if (key >= 0) {
            // until empty cell or -1,
            while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
                ++hashVal;              // go to next cell
                hashVal %= arraySize;   // wraparound if necessary
            }
            hashArray[hashVal] = item;  // insert item
        } else System.out.println("Number must be positive");
    }  // end insert()

    // -------------------------------------------------------------
    public DataItem delete(int key) {      // delete a DataItem
        if (key < 0) {
            System.out.println("Number must be positive");
            return nonItem;
        }
        int hashVal = hashFunc(key);  // hash the key

        while (hashArray[hashVal] != null) {   // until empty cell, found the key?
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem;       // delete item
                return temp;                        // return item
            }
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        }
        return null;                  // can't search item
    }  // end delete()

    // -------------------------------------------------------------
    public DataItem find(int key) {      // search item with key
        int hashVal = hashFunc(key);  // hash the key

        while (hashArray[hashVal] != null) {   // until empty cell, found the key?
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];   // yes, return item
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        }
        return null;                  // can't search item
    }
// -------------------------------------------------------------
}  // end class HashTable

////////////////////////////////////////////////////////////////
class HashTableApp {
    public static void main(String[] args) throws IOException {
        DataItem aDataItem;
        int aKey, size, n, keysPerCell;
        System.out.print("Enter size of hash table: "); // get sizes
        size = getInt();
        System.out.print("Enter initial number of items: "); // initial qty numbers
        n = getInt();
        keysPerCell = 10;
        HashTable hashTable = new HashTable(size);      // make table

        for (int j = 0; j < n; j++) {   // insert random data (0 - keysPerCell*size)
            aKey = (int) (java.lang.Math.random() * keysPerCell * size);
            aDataItem = new DataItem(aKey);
            hashTable.insert(aDataItem);
        }

        boolean enter = true;
        while (enter) {                 // interact with user
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, find or x for EXIT: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    hashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    hashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    hashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to search: ");
                    aKey = getInt();
                    aDataItem = hashTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                    } else
                        System.out.println("Could not search " + aKey);
                    break;
                case 'x':
                    enter = false;
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()

    //--------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    //--------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
//--------------------------------------------------------------
}  // end class HashTableApp
////////////////////////////////////////////////////////////////