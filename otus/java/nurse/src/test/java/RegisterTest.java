import com.example.nurse.Register;
import org.junit.Assert;
import org.junit.Test;

public class RegisterTest {
    @Test
    public void absentObjectReturnsNull() {
        Register register = new Register();
        Object something = register.get("absent");
        Assert.assertNull(something);
    }
}
