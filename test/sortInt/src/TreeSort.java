class Tree {
    public Tree left;            // левое и правое поддеревья и ключ
    public Tree right;
    public int key;

    Tree(int k) {        // конструктор с инициализацией ключа
        key = k;
    }

    /*  insert (добавление нового поддерева (ключа))
        сравнить ключ добавляемого поддерева (К) с ключом корневого узла (X).
        Если K >= X, рекурсивно добавить новое дерево в правое поддерево.
        Если K < X, рекурсивно добавить новое дерево в левое поддерево.
        Если поддерева нет, то вставить на это место новое дерево
    */
    public void insert(Tree tree) {
        if (tree.key < key)
            if (left != null) left.insert(tree);
            else left = tree;
        else if (right != null) right.insert(tree);
        else right = tree;
    }

    /*  traverse (обход)
        Рекурсивно обойти левое поддерево.
        Применить функцию f (печать) к корневому узлу.
        Рекурсивно обойти правое поддерево.
    */
    void traverse(TreeVisitor visitor) {
        if (left != null) left.traverse(visitor);
        visitor.visit(this);
        if (right != null) right.traverse(visitor);
    }
}

interface TreeVisitor {
    void visit(Tree node);
}

class KeyPrinter implements TreeVisitor {
    public void visit(Tree node) {
        System.out.print(" " + node.key);
    }
}

class TreeSort {
    public static void main(String[] args) {
        Tree myTree = new Tree(50);
        int size = 1_000_000;            // array size
        double t0;
        double t1;
        double t00;
        double t01;
        System.out.println(String.format("Кол-во элементов = %,d", size));
        t0 = System.nanoTime();
        t00 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {  // fill array with random nodes
            int random = (int) (10 + java.lang.Math.random() * (99 - 10));
            myTree.insert(new Tree(random));
        }
        t1 = System.nanoTime();
        t01 = System.currentTimeMillis();
        System.out.println(String.format("TreeSort\ttime nanoseconds =\t%,.0f", t1 - t0));
        System.out.println(String.format("TreeSort\ttime milliseconds =\t%,.0f", t01 - t00));

//        myTree = new Tree(7);       // создать дерево (с ключом)
//        myTree.insert(new Tree(5));  // присоединять поддеревья
//        myTree.insert(new Tree(9));
//        myTree.traverse(new KeyPrinter());
    }
}