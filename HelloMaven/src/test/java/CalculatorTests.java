import com.revature.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
//easy way to order our tests. check the @Order annotations below
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTests {

    //Uninitialized instance of Calculator that we'll instantiate for each test
    private Calculator calc;

    @BeforeAll //just a greeting... but anything you want to run before any test runs can go here
    public static void init(){
        System.out.println("Welcome to the Calculator Test Suite!");
    }

    @BeforeEach //before each test, we'll instantiate a new Calculator object
    public void setUp(){
        System.out.println("Instantiating a new Calculator object");
        calc = new Calculator();
        /*In the case of our Calculator tests, this isn't super necessary
         But this is actually considered best practice, so each test has a fresh instance of the object
         This helps us avoid any complications related to changes that occur in the object */
    }

    //I could write a similar @AfterAll method to run after every test finishes
    //@AfterAll, @AfterEach

    //positive test for the add() method
    @Order(4)
    @Test
    public void testAdd(){
        int result = calc.add(5, 10);
        assertEquals(15, result);
    }

    //another positive test for the add() method, this time using assertNotEquals
    @Order(3)
    @Test
    public void testAdd2(){
        int result = calc.add(5, 10);
        assertNotEquals(result, 16);
        //This isn't a test case we probably write, for obvious reasons (we know 15 != 16)
        //But assertNotEquals is still useful. Can be used for stuff like:
        //making sure an object isn't a duplicate, or that a method changed an object as intended (counter?)
    }

    //positive and negative test for the divide() method
    //HEY look we have two assertions in one test case! More elegant since they're testing the same thing
    @Order(2)
    @Test
    public void testDivide(){
        int result = calc.divide(10, 2);
        assertTrue(result == 5);
        assertFalse(result == 0);
    }

    //test for divide by zero (which should throw an IllegalArgumentException)
    @Order(1)
    @Test
    public void testDivideByZero(){
        assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
        //assertThrows expects an "executable" which is basically just something that can be run
    }

}
