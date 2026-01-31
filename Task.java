package TaskTrackerproj;
public class Task {
    
    protected String taskname;
    protected String taskdesc;
    protected String taskstate;
    protected int taskid ;

     //Constructor that will create the objects or here the tasks .
    public Task(String taskname, String taskdesc, int taskid,String state){
        this.taskname = taskname ;
        this.taskdesc = taskdesc;
        this.taskid = taskid;
        this.taskstate = state ;
    }

    // Setter and Getters
     public void setname(String name){
        this.taskname = name ;
    }
    public String getname(){
        return taskname ;
    }
    public void setdesc(String desc){
        this.taskdesc = desc ;
    }
    public String getdesc(){
        return taskdesc;
    }
    public void setid(int id){
        this.taskid = id ;
    }
    public int getid(){
        return taskid;
    }
    public void setstate(String state){
        this.taskstate = state ;
    }
     public String getstate(){
        return this.taskstate;
    }
    
}
