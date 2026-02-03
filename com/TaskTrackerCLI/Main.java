package com.TaskTrackerCLI;
public class Main {
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Please, provide an order(add, update, delete, list): ");
            return;
        }

        TaskTracker t = new TaskTracker();

        String command = args[0].toLowerCase();

        switch(command){
            case "add":
                if(args.length < 3){
                    System.out.println("Error: Please provide a name and description");
                    System.out.println("Usage: java Main add \"Task Name\" \"Description\"");
                }else{
                    String name = args[1];
                    String desc = args[2];
                    t.AddTask(name, desc);
                }
                break; 
            
            case "update":
                if(args.length<3){
                    System.out.println("Error: Provide id and description");
                }else{
                    try{
                    int id = Integer.parseInt(args[1]);
                    String desc = args[2];
                    t.updtask(id, desc);
                    }catch(NumberFormatException e){
                        System.out.println("Error: ID must be a number!");
                    }
                }
                break;

                case "delete":
                    if(args.length<2){
                        System.out.println("Error: Please provide id to delete");
                    }else{
                        try{
                        int id = Integer.parseInt(args[1]);
                        t.deletetask(id);
                        }catch(NumberFormatException e)
                        {
                            System.out.println("Must be number");
                        }
                    }
                    break;
                
                case "list":
                    if(args.length>1){
                        //list by statues
                        String statues = args[1];
                        t.listbystatues(statues);
                    }else{
                        //list everything
                        t.listTasks();
                    }
                    break;

                default:
                    System.out.println("Unknown command: " + command);
                    System.out.println("available commands: add, update, delete, list");
            
            
            
            
            
            }
            
    }
}
