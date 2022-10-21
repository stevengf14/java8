package ec.com.learning.java8.nashorn;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    private ScriptEngineManager m;
    private ScriptEngine e;
    private Invocable invocable;

    public Main() {
        m = new ScriptEngineManager();
        e = m.getEngineByName("nashorn");
        invocable = (Invocable) e;
    }

    public void callFunctions() throws Exception {
        //e.eval("print('js from java')");
        e.eval(new FileReader("src\\main\\java\\ec\\com\\learning\\java8\\nashorn\\file.js"));
        
        String result = (String) invocable.invokeFunction("calculate", "2", "3");
        System.out.println(result);
        
        double result2 = (double) invocable.invokeFunction("calculate", 2, 3);
        System.out.println(result2);
    }
    
    public void implementInterface() throws Exception{
        e.eval(new FileReader("src\\main\\java\\ec\\com\\learning\\java8\\nashorn\\file.js"));
        Object implementation = e.get("threadImpl");
        Runnable r= invocable.getInterface(implementation, Runnable.class);
        
        Thread th1 = new Thread(r);
        th1.start();
        
        Thread th2 = new Thread(r);
        th2.start();
        
    }

    public static void main(String[] args) {
        try {
            Main app = new Main();
            app.callFunctions();
            app.implementInterface();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
