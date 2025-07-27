package MockintoPractice;

/**
 * Interface for practicing how to use Mockinto
 * @author aichinos
 * @version 12 Jun 2025 - Day1
 *
 */
public interface GreetingService {
    
    /**
     * DAY 1: cresting an interface for up coming tests
     * @param name user's input 
     * @return String "user's name + greet"
     */
    String greet(String name);//This method does not need to have an implementation
    
    /* That means:
     * We simulate (mock) the behavior of dependencies (interfaces, services, repositories, etc.) 
     * without needing real implementations.
     * 
     * WHY? / HOW?
     * - When you call mock(GreetingService.class), Mockito creates a fake object that implements the interface for you.
     * - This mock object allows you to:
     *          - control the return values (when().thenReturn())
     *          - verify if methods were called (verify())
     *          - simulate exceptions (thenThrow())
     *          
     * So, you don’t need to write any real class that implements the interface.
     * 
     * 
     * As backend worker, you will often mock:
     *      - Repository interfaces (e.g. Spring Data JPA)
     *      - Service interfaces
     *      - External API clients
     *      - Other collaborators
     *  👉 This allows you to unit test your class in full isolation.
     * 
     */

}
