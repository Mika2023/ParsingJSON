import java.util.ArrayList;

public class User {
    private int id;
    private ArrayList<ToDoTask> tasks;

    public User(int id){
        this.id = id;
        this.tasks = new ArrayList<ToDoTask>();
    }
    public User() {this(-1);}

    public void addTask(ToDoTask task){
        if (isAdd(task) && !containsTask(task)) this.tasks.add(task);
    }
    public boolean isAdd(ToDoTask task){
        return task.getUserId()==this.id;
    }

    public boolean containsTask(ToDoTask task){
        for (ToDoTask toDoTask : tasks) {
            if(toDoTask.getId()==task.getId()) return true;
        }
        return false;
    }

    public void printUser(){
        System.out.printf("User №%d\n", this.id);
        for (ToDoTask toDoTask : tasks) {
            toDoTask.printTaskUser();
        }
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
}
