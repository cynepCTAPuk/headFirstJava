package regex;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;

/**
 * https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form
 */
public class StringToCalc4 {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        System.out.println(engine.eval("40+2"));
        System.out.println(engine.eval("(2 * (-5 + 1.5 * 4) + 28)"));
    }
}
