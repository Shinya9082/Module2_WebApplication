package Model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {
    public Calculator() {
    }
    public static Object doScript(String script) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result ;
        try {
            result = engine.eval(script);
        } catch (ScriptException ex){
            result="Input mismatch";
        }
        return result;
    }

}
