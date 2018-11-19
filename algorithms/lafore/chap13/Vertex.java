package lafore.chap13;

class Vertex {
  public char label; // Метка (например, ‘A’)
  public boolean wasVisited;

  // Конструктор
  public Vertex(char lab) {
    label = lab;
    wasVisited = false;
  }
} // Конец класса Vertex