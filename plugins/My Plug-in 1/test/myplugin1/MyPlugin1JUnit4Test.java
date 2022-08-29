package myplugin1;

import com.nomagic.magicdraw.tests.MagicDrawTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

//junit4 test case with test class runner implementation, by no magic (Starts the program. Checks for memory leaks)
@RunWith(MagicDrawTestRunner.class)
public class MyPlugin1JUnit4Test
{
    @Test
    public void testPluginInitialized()
    {
        assertTrue(MyPlugin1.initialized);
    }

    /*
    @Test
    public void testPluginClosed()
    {
        assertTrue(MyPlugin1.closed);
    }
     */
}
