package com.TaskTrackerCLI;
import java.io.File;
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

    public TaskTracker(){
        loadFromFile();
    }

    private void loadFromFile(){
        Path path = Paths.get(FILE_PATH);
        // Check if the file exists
        if(!Files.exists(path)){
            return ;
        }

        try {
            // read the json file
            String content = Files.readString(path);

            //remove the brackets 
            content = content.replace("[", "").replace("]", "")
                .replace("\"", "");

            if(content.trim().isEmpty()){return ;}

            // save each Task as a chunck
            String[] chunck = content.split("},");

            for(String c : chunck){
                // clean the curly braces
                c = c.replace("{", "").replace("}", "");

                // Extract Fields
                String[] Fields = c.split(",");

                // Temporary values
                int id  = 0 ;
                String name = "", desc = "", state = "";

                 for(String field : Fields){
                    String[] parts = field.split(":");
                    if(parts.length < 2) continue;

                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch(key){
                        case "id": id = Integer.parseInt(value); break;
                        case "name": name = value ; break;
                        case "desc": desc = value ; break;
                        case "state": state = value ; break ;
                    }
                 }

                 Task t = new Task(name, desc, id, state);
                 tasklist.add(t);
            }
        }catch(Exception e){
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

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
            jsonBuilder.append("  \"id\": \"").append(t.taskid).append("\", \n");
            jsonBuilder.append("  \"name\": \"").append(t.taskname).append("\", \n");
            jsonBuilder.append("  \"desc\": \"").append(t.taskdesc).append("\", \n ");
            jsonBuilder.append("  \"state\": \"").append(t.taskstate).append("\"\n");

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

    public void updtask(int taskid, String newdesc){
        boolean found = false ;

        // search for the task matching id
        for(Task t : tasklist){
            if(t.getid() == taskid ){
                found = true ;
                t.setdesc(newdesc);
                break;
            }
        }
        if(found){
            saveToFile();
            System.out.println("The task has been updated and its task is " + taskid );
        }else{
            System.out.println("Error!!!!");
        }
        
    }

    public void deletetask(int id){
        boolean found = false ;
        Task toremove = null ;
        for(Task t : tasklist){
            if(t.getid() == id){
                found = true ;
                toremove = t ;
                break; 
            }
        }
        if(found){
            tasklist.remove(toremove);
            saveToFile();
            System.out.println("Has been deleted successfully");
        }else{
            System.out.println("Error!!!");
        }
    }

    public void listTasks(){
        if(tasklist.isEmpty()){
            System.out.println("No Tasks");
            return ;
        }
        System.out.println("ID  |Statues      | Description");
        System.out.println("----|-------------|---------------------");

        for(Task t : tasklist){
            System.out.printf("[%-3d] | %-11s | %s%n", t.getid(), t.getstate(), t.getdesc());
        }
    }

    public void listbystatues(String statues){
        boolean found = false ;

        for(Task t : tasklist){
            //Check if the task matches the filter (e.g, "done")
            if(t.getstate().equals(statues)){
                found = true ;
                System.out.println(t);
            }
        }

        if(!found){
            System.out.println("It doesn't exist!!!");
        }
    }

    

}
