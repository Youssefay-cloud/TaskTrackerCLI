import TaskTrackerproj.Task;
import TaskTrackerproj.TaskTracker;

public class Main {
    static TaskTracker t ;
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Please, provide an order(add, update, delete, list): ");
            return;
        }

        String command = args[0];

        t  = new TaskTracker();

        switch(command){
            case "add":
                t.AddTask();
            case "update":
            case "delete": 
            case "list": 
        }
            
    }
}
