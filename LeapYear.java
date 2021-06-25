// static class B {
//    public int Func() {
//        System.out.print("B");
//        return 0;
//    }
//}
//static class D extends B {
//    @Override
//    public int Func() {
//        System.out.print("D");
//        return 0;
//    }
//}
//public class LeapYear {
//
//    public static void getCustomerInfo() {
//
//        try {
//
//            // do something that may cause an Exception
//
//        } catch (java.io.FileNotFoundException ex) {
//            System.out.print("FileNotFoundException!");
//
//        } catch (java.io.IOException ex) {
//
//      System.out.print("IOException!");
//
//        } catch (java.lang.Exception ex) {
//
//            System.out.print("Exception!");
//
//        }
////
//    }
//
//    public static void main(String[] args) {
//
//        getCustomerInfo();
//
//    }
//}
//
//}
class LeapYear{
    public static void main(String[] args) {
        int i =5;
        int s = (i++);
        System.out.println(i);
        System.out.println(s);
        int s1 = (++i);
        System.out.println(i);
        System.out.println(s1);
        int s2 = (i--);
        System.out.println(i);
        System.out.println(s2);
        int s3 = (--i);
        System.out.println(i);
        System.out.println(s3);
        int r = s+s1+s2+s3;
        System.out.println(s);
    }
}
