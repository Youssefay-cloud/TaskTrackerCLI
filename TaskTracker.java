import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskTracker  {
    public List<Task> tasklist = new ArrayList<>();
    private static final String FILE_PATH = "tasks.json";
    public int id ;

    private void saveToFile() {
        //Empty stringbuilder to start the json string  
        StringBuilder jsonBuilder = new StringBuilder();
        //Start the json
        jsonBuilder.append(" [\n");

        //We nee to add in this brackets one by one task 
        for(int i = 0 ; i < tasklist.size(); i++){
            // Get the task we need to save to file
            Task t = tasklist.get(i);

            //start a json object.
            jsonBuilder.append("   {\n");

            //insert what we need manually
            jsonBuilder.append("  \"id\": ").append(t.taskid).append(", \n");
            jsonBuilder.append("  \"name\": ").append(t.taskname).append(" ,\n");
            jsonBuilder.append("  \"desc\": ").append(t.taskdesc).append(" ,\n ");
            jsonBuilder.append("  \"state\": ").append(t.taskstate).append("\"\n");

            //close the object
            jsonBuilder.append("    }");

            //Add comma if it is not the last object
            if(i < tasklist.size() - 1){
                jsonBuilder.append(",\n");
            }else{
                jsonBuilder.append("\n");
            }
        }
        
        //close the json file
        jsonBuilder.append(" ]\n");

        //write to the file.
        try {
             Path path = Paths.get(FILE_PATH);
             Files.writeString(path, jsonBuilder.toString());
        } catch (Exception e) {
            System.out.println("Could not save tasks: " + e.getMessage());
        }
       
        

        
    }

    public void AddTask(String name, String desc){
        // Id
        int newId = tasklist.size() + 1 ;
        // task object with the details
        Task t = new Task(name, desc, newId, "todo");
        
        tasklist.add(t);

        saveToFile();

       System.out.println("Task added successfully (ID: " + newId + ")");
    }

    public void updtask(int id){
        Task t = tasklist.get(id);
        t.
    }

}
