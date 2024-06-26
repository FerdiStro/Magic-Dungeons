package logger;

public class Logger {


    private  static DebugWindow  debugWindow;

    private static final Boolean debug =  true;

    public static void info(String message){
        System.out.print((char)27 + "[33m Info:");
        System.out.println((char)27 + "[39m " + message);
    }
    public static void error(String message){
        System.out.print((char)27 + "[31m Error:");
        System.out.println((char)27 + "[39m " + message);
    }
    public static void success(String message){
        System.out.print((char)27 + "[32m Success:");
        System.out.println((char)27 + "[39m " + message);
    }

    private static DebugWindow getInstance(){
        if(debugWindow==null){
           debugWindow =  new DebugWindow();
        }
        return debugWindow;
    }

    public static void debug(String message){
        if(debug){
            getInstance().addMessage(message);
//            System.out.print((char)27 + "[31m DEBUG:");
//            System.out.println((char)27 + "[39m " + message);
        }
    }


    //todo: Debug methode, when debug var is on all debugs in the project will be displayed
}
