package MockintoPractice;

/**
 * Practice how to write tests using Mockinto
 * @author aichinos
 * @version 12 Jun 2025
 */

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

/**
 * @author aichi
 * @version 12 Jun 2025
 *
 */
public class GreetingServiceManualTest {
    
    //DAY 2: Stubbing methods
    @Test
    void testGreet() {
        GreetingService mockService = mock(GreetingService.class);
        when(mockService.greet("Risa")).thenReturn("Hello Risa!");
        
        String result = mockService.greet("Risa");
        System.out.println(result);//should print "Hello Risa!"
    }
    
    
    //DAY 3: Verifying behavior
    
    
    
    
    //DAY 4: Argument matchers
    
    
    
    //DAY 5: Multiple mocks
    
    
    
    //DAY 6: Exception mocking
    
    
    
    //DAY 7: Mini-project test
    /* 
     * - Build a simple service with 2 dependencies, and mock both.
     * - Write 2–3 unit tests fully using Mockito 
     * 
     */
    

}
