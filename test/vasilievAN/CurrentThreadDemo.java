package vasilievAN;

class CurrentThreadDemo{
    public static void main(String args[]){
        Thread t = Thread.currentThread();
        System.out.println("Teкyщий поток исполнения: \t" + t);
        // изменитьимяпотокаисполнения
        try{
            for(int n=15; n>0 ;n--){
                // System.out.println(n);
                t.setName("MyThread_"+n);
                System.out.println("Пocлe изменения имени потока: \t" + t);
                Thread.sleep(500);
            }
        }catch(InterruptedException е){
            System.out.println("Глaвный поток исполнения прерван");
        } finally{
            System.out.println("Выполняется в любом случае!");
            System.out.println("Последнне изменёное имя потока: \t" + t);
        }
    }
}