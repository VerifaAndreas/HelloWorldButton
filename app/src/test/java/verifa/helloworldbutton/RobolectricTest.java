package verifa.helloworldbutton;

import verifa.helloworldbutton.BuildConfig;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RobolectricTest {

    @Test
    public void clickingLogin_shouldStartLoginActivity() throws Exception {
    	MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.button).performClick();

        Intent expectedIntent = new Intent(activity, LoginActivity.class);
        assertTrue( 
        		expectedIntent.filterEquals( shadowOf(activity).getNextStartedActivity() ) 
        );
    }
}