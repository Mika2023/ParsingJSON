import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private ArrayList<User> users;
    private List<ToDoTask> tasks;
    private boolean userPrint; //you can choose the format in which tasks will be printed
    private boolean startNewTask;
    private ToDoTask tempTask;
    private User tempUser;

    public Controller(){
        this.users = new ArrayList<User>();
        this.tasks = new ArrayList<ToDoTask>();
        this.userPrint = false;
        this.startNewTask = false;
    }

    public void setUserPrint(boolean userPrint){
        this.userPrint = userPrint;
    }

    public void setToDos(String src){
        if (src.equals("[") || src.equals("]")) return;
        if (src.contains("{") || src.contains("}") ){
            this.startNewTask = src.contains("{");//if src=="{" it means that it is the start of a new task
            return;
        }
        if(this.startNewTask){
            src = src.substring(4);
            src = src.replace(",", "");
            String[] keyValue = src.split(": ");
            keyValue[0] = keyValue[0].replace("\"", "");

            if (keyValue[0].equals("userId")){
                this.tempTask = new ToDoTask();
                this.tempUser = new User();
            } 

            switch (keyValue[0]) {
                case "userId":
                    tempTask.setUserId(Integer.parseInt(keyValue[1]));
                    tempUser.setId(Integer.parseInt(keyValue[1]));
                    break;
                case "id":
                    tempTask.setId(Integer.parseInt(keyValue[1]));
                    break;
                case "title":
                    tempTask.setTitle(keyValue[1]);
                    break;
                case "completed":
                    tempTask.setCompleted(Boolean.parseBoolean(keyValue[1]));
                    break;

                default:
                    break;
            }

            if(keyValue[0].equals("completed")){
                tasks.add(tempTask);
                int ind = findUSer(tempUser);
                if(ind!=-1){
                    tempUser = users.get(ind);
                    tempUser.addTask(tempTask);
                    users.set(ind, tempUser);
                }
                else{
                    tempUser.addTask(tempTask);
                    users.add(tempUser);
                }
            }
        }
    }

    public int findUSer(User userSrc){
        for (int i = 0; i<users.size();++i){
            if(users.get(i).getId()==userSrc.getId()) return i;
        }
        return -1;

    }

    public void printAll(){
        if(userPrint){
            Collections.sort(users,new UsersCompare());
            for (User user : users) {
                user.printUser();
            }
        }
        else{
            for (ToDoTask toDoTask : tasks) {
                toDoTask.printTask();
            }
        }
    }

}
