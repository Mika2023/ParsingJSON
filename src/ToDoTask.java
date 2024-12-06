public class ToDoTask {
    private int id,userId;
    private String title;
    private boolean completed;

    public ToDoTask(int id, int userId, String title, boolean completed){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }
    public ToDoTask() {this(-1,-1,"",false);}

    public void printTaskUser(){
        String isCompl = (completed)?"":"not ";
        System.out.printf("\tThe task %s is %scompleted!\n",this.title,isCompl);
    }
    public void printTask(){
        String isCompl = (completed)?"":"not ";
        System.out.printf("№%d\nThe task %s is %scompleted!\n",this.id,this.title,isCompl);
    }

    public int getUserId(){
        return this.userId;
    }
    public int getId(){
        return this.id;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
