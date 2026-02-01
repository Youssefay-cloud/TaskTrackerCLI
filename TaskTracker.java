package TaskTrackerproj;
import java.util.List;
import java.util.Scanner;

public class TaskTracker  {
    Scanner input = new Scanner(System.in);
    public List<Task> task ;
    public int id ;

    public void AddTask(){
        System.out.println("Enter task name: ");
        String name = input.nextLine();
        System.out.println("Enter task desc: ");
        String desc = input.nextLine();
        System.out.println("Enter task state: ");
        String state = input.nextLine();

        Task newtask = new Task(name, desc, id++,state);
        task.add(newtask);

    }

    public void updateTask(){
        System.out.println("Enter task id to update:");
        int taskid = input.nextInt();
        input.nextLine(); //consume newline
        System.out.println("Enter task name: ");
        String name = input.nextLine();
        System.out.println("Enter task desc: ");
        String desc = input.nextLine();
        System.out.println("Enter task state: ");
        String state = input.nextLine();

        for(Task t : task){
            if(t.getid() == taskid){
                task.remove(t);
                task.add(new Task(name, desc, taskid, state));
                System.out.println("had been added!");
                return;
            }
        }
        System.out.println("nothing like that");
            }
        


    


    public void deleteTask(){
        System.out.println("Enter task id to delete:");
        int taskid = input.nextInt();

        for(Task t : task){
            if(t.getid() == taskid){
                task.remove(t);
                System.out.println("had been deleted!");
                return;
            }
        }
        System.out.println("nothing like that");
    }


    public String taskState(){
        System.out.println("Enter taskid to see state: ");
        int taskid = input.nextInt();
        input.nextLine();
        for(Task t : task){
            if(t.getid() == task.get(taskid)){
                System.out.println(t.taskstate());
                return "alright";
            }
        }
        System.out.println("nothing");
    }

    public List<Task> taskList(){

        for(Task t : task){
            System.out.println(t);
        }
         return task ;
    }


    public List<Task> donetask(){
        for(Task t : task){
            if(t.taskstate = "done"){
                System.out.println(t);
            }else{
                System.out.println("There is no done task!!!");
            }
        }
    }
    public List<Task> notdonetask(){
        for(Task t : task){
            if(t.taskstate = "todo"){
                System.out.println(t);
            }else{
                System.out.println("There is no todo task!!!");
            }
        }
    }

    public List<Task> inprogtask(){
        for(Task t : task){
            if(t.taskstate = "in-progress"){
                System.out.println(t);
            }else{
                System.out.println("There is no in-progress task!!!");
            }
        }
    }


}
