package test_factorial;


import factorial.Factorial;
import org.junit.Assert;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class FactorialTest {
    
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0;  // test thu tinh huong tu te dau vao, may phai chay dung
        long expected = 1; //hy vong 0! = 1
        //long actual = ; goi ham can test ben core/app chinh/ code chinh
        long actual = Factorial.getFactorial(n);

        //so sanh dung expected vs. actual dung xanh xanh do do, framework
        Assert.assertEquals(expected, actual);

        // gop them vai case thanh cong/dua dau vao ngon!!! ham phai tinh ngon
        Assert.assertEquals(1, Factorial.getFactorial(1)); // tui muon 1! == 1
        Assert.assertEquals(2, Factorial.getFactorial(2)); // tui muon 2! == 2
        Assert.assertEquals(6, Factorial.getFactorial(3)); // tui muon 3! == 6
        Assert.assertEquals(24, Factorial.getFactorial(4)); // tui muon 4! == 24
        Assert.assertEquals(120, Factorial.getFactorial(5)); // tui muon 5! == 120
        Assert.assertEquals(720, Factorial.getFactorial(6)); // tui muon 6! == 720

        //ham giup so sanh 2 gia tri nao do co giong nhau hay khong
        //neu giong nhau -> thay mau xanh, code ngon it nhat cho case dang test
        //neu KO GIONG NHAU -> thay mau do, ham y expected va actual ko giong nhau
    }

    // ham getF() ta thiet ke co 2 tinh huong xu li
    //1. dua data tu te trong [0...20] -> tinh dung duoc n! -> done
    //2. dua data vao ca chon, am, >20; THIET KE CUA HAM LA NEM RA NGOAI LE
    // TAO KI VONG NGOAI LE XUAT HIEN KHI N < 0 || N > 20
    // rat mong ngoai le xuat hien voi n ca chon nay
    //neu ham nhan vao n < 0 hoac n > 20 va ham nem ra ngoai le
    //HAM CHAY DUNG NHU THIET KE
    //Test case:
    //input: -5
    // expected: IllegalArgumentException xuat hien
    // tinh huong bat thuong, ngoai le, ngoai du tinh, du lieu
    // la nhung thu ko the do luong, so sanh theo kieu value
    // ma chi co the do luong = cach chung co xuat hien hay ko
    //assertEquals() khong dung de so sanh 2 ngoai le
    //      Equals() la bang nhau hay ko tren value!!!
    //MAU DO, DO HAM DUNG LA CO NEM NGOAI LE THAT SU
    //          NHUNG KO PHAI LA NGOAI LE NHU KI VONG - THUC SU KI VONG SAI
    //          KO PHAI HAM NEM SAI
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenWrongArgumentThrowsException() {
//        MathUtil.getFactorial(-5); // ham @Test chay, hay ham getF() chay
//                                   // se nem ra ngoai le
//    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        Factorial.getFactorial(-5); // ham @Test chay, hay ham getF() chay
        // se nem ra ngoai le
    }

    //cách khác de bat ngoai le xuat hien, viet tu nhien hon!!!
    //xai Lambda
    //Test case: ham se nem ve ngoai le neu nhan vao 21
    //tui can thay mau xanh khi choi voi 21!
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_LambdaVersion() {
//        Assert.assertThrows(tham so 1: loai ngoai le muon so sanh, 
//                            tham so 2: doan code chay vang ra ngoai runnable);
        Assert.assertThrows(IllegalArgumentException.class,
                () -> {
                    Factorial.getFactorial(-5);
                });
        //MathUtil.getFactorial(-5); // ham @Test chay, hay ham getF() chay
        // se nem ra ngoai le
    }

    //Bat ngoai le, xem ham co nem ve ngoai le hay khong khi n ca chon
    //co nem, tuc la ham chay dung thiet ke -> xanh
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_TryCatch() {
        // chu dong kiem soat ngoai le!!!
        try {
            Factorial.getFactorial(-5); // ham @Test chay, hay ham getF() chay
        } catch (Exception e) {
            //bat try-catch la JUnit se ra mau xanh do da chu dong kiem soat 
            //ngoai le nhung khong chac ngoai le minh can co xuat hien hay khong???
            //co doan code kiem soat dung ngoai le IllegalArgumentException xh
            Assert.assertEquals("Invalid argument. N must be between 0...20",
                                e.getMessage());
        }
        // se nem ra ngoai le
    }

}
