package verifa.helloworldbutton;

import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.stubbing.Answer;
import org.mockito.invocation.InvocationOnMock;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(MainActivity.class)
public class PowermockTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    
    @Test
    public void testSayHello() throws Exception {
    	PowerMockito.mockStatic(MainActivity.class);
    	Answer<Void> answer = new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) throws Throwable {
    			System.out.println("GOODBYE!!");
                return null;
            }
    	};
//    	when( MainActivity.sayHello() ).thenAnswer( answer );
    	MainActivity.sayHello();
    }
    
    @Test
    public void testGetIntStatic() throws Exception {
    	PowerMockito.mockStatic(MainActivity.class);
    	when( MainActivity.getIntStatic() ).thenReturn(1);
    	assertEquals(1, MainActivity.getIntStatic());
    }
}