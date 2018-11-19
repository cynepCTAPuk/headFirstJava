package lafore.chap13;

class Graph {
  private final int MAX_VERTS = 20;
  private Vertex vertexList[]; // Массив вершин
  private int adjMat[][]; // Матрица смежности
  private int nVerts; // Текущее количество вершин

  // -------------------------------------------------------------
  // Конструктор
  public Graph() {
    vertexList = new Vertex[MAX_VERTS];
    // Матрица смежности
    adjMat = new int[MAX_VERTS][MAX_VERTS];
    nVerts = 0;
    for (int j = 0; j < MAX_VERTS; j++) // Матрица смежности
      for (int k = 0; k < MAX_VERTS; k++) // заполняется нулями
        adjMat[j][k] = 0;
  }

  // -------------------------------------------------------------
  // В аргументе передается метка
  public void addVertex(char lab) {
    vertexList[nVerts++] = new Vertex(lab);
  }

  // -------------------------------------------------------------
  public void addEdge(int start, int end) {
    adjMat[start][end] = 1;
    adjMat[end][start] = 1;
  }

  // -------------------------------------------------------------
  public void displayVertex(int v) {
    System.out.print(vertexList[v].label);
  }
  // -------------------------------------------------------------
} // Конец класса Graph