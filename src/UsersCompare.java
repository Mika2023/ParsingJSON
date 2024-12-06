import java.util.Comparator;

public class UsersCompare implements Comparator<User>{

    public int compare(User user1,User user2){
        return user1.getId()-user2.getId();
    }

    public boolean equals(User ob1,User ob2){
        return compare(ob1, ob2)==0;
    }
    
}
