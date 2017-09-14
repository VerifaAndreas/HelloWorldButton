package verifa.helloworldbutton;

import verifa.helloworldbutton.BuildConfig;

import android.content.Intent;

import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

//import org.powermock.modules.junit4.PowerMockRunner;
//import org.powermock.modules.junit4.PowerMockRunnerDelegate;



@RunWith(RobolectricTestRunner.class)
//@RunWith(PowerMockRunner.class)
//@PowerMockRunnerDelegate(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
@PowerMockIgnore({ "org.mockito.*", "org.robolectric.*", "android.*" })
//@PowerMockIgnore({ "org.mockito.*", "org.robolectric.*"})
//@PrepareForTest(MainActivity.class)
@PrepareForTest(fullyQualifiedNames = { "verifa.helloworldbutton.MainActivity" })
public class RobolectricPowermockTest {
	
	@Rule
    public PowerMockRule rule = new PowerMockRule();
	
    @Test
    public void rLPMButtonClickTest() throws Exception {
    	MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.button).performClick();

        Intent expectedIntent = new Intent(activity, LoginActivity.class);
        assertTrue( 
        		expectedIntent.filterEquals( shadowOf(activity).getNextStartedActivity() ) 
        );
    }
    @Test
    public void testGetIntStatic() throws Exception {
    	PowerMockito.mockStatic(MainActivity.class);
    	when( MainActivity.getIntStatic() ).thenReturn(1);
    	assertEquals(1, MainActivity.getIntStatic());
    }
    @Test
    public void testGetIntNormal() throws Exception {
    	MainActivity ma = PowerMockito.mock(MainActivity.class);
    	when( ma.getIntNormal() ).thenReturn(1);
    	assertEquals(1, ma.getIntNormal());
    }
    @Test
    public void testGetIntBoth() throws Exception {
    	PowerMockito.mockStatic(MainActivity.class);
    	when( MainActivity.getIntStatic() ).thenReturn(1);
    	MainActivity ma = PowerMockito.mock(MainActivity.class);
    	when( ma.getIntNormal() ).thenReturn(1);
    	assertEquals(1, ma.getIntNormal());
    	assertEquals(1, MainActivity.getIntStatic());
    }
}