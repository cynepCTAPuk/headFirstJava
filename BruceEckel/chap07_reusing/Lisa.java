package chap07_reusing;

//: reusing/Lisa.java
// {CompileTimeError} (Won’t compile)
class Lisa extends Homer {
//    @Override
    void doh(Milhouse m) {
        System.out.println("doh(Milhouse)");
    }
} ///:~