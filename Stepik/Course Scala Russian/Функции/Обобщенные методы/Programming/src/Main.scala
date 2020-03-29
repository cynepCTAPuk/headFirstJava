import scala.annotation.tailrec
@tailrec
def fibs(n: Int, currentNumber: Int = 1, f1: Long = 0, f2: Long = 1): Long = {
    if (n == currentNumber)
        f2
    else {
        //put your code here  
    }
}
println(fibs(n))