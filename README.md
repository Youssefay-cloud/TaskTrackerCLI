project : TaskTrackerCLI
It create a json file using StringBuilder manually without any frameworks

We have Task class
  has Id, name, description, statues 
  with its setters and getters
  and override toString method if we want to return it in a string format

We have the TaskTracker class
consturctor to load the json file using the loadFromFile method,
saveToFile method that create the file using Path and using 
stringBuilder to make the layout of json file manually 
then we have the primary methods of (add, update, delete, list, liststatues).

We have Main class
handle the inputs come from the CLI 


To make it work you run it like this
          java com.TaskTrackerproj.Main add "Go to shopping""Buy Groceries"


RoadMap URL : "https://roadmap.sh/projects/task-tracker"
