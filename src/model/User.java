package model;

import java.util.ArrayList;
import Exceptions.*;

public abstract class User {

    protected String name,status;
    protected String image;
    protected int age;
    protected ArrayList<User> friendList;

    public String getName()
    {
        return name;
    }

    public String getStatus()
    {
        return status;
    }

    public String getImage()
    {
        return image;
    }

    public int getAge()
    {
        return age;
    }

    public void displayDetails()
    {

        System.out.println("Name: " + name + "\nStatus: " + status + "\nImage: " + image
                + "\nAge: " + age + "\n\n");
    }

    public void addFriend (User addee)  throws TooYoungException, NotToBeFriendsException
    {
        if(age<16 && this instanceof Child)
        {
            if(addee.getAge()>=16 || !((Child) this).isChild((Adult) addee) || Math.abs(addee.getAge()-age)>3)
            {
                //System.out.println("Children cannot add adults except parents. Only children can be friends of children");
                throw new NotToBeFriendsException();
            }
            else if(age<=2)
            {
              //  System.out.println("Toddlers cannot have friends.");
                throw new TooYoungException();
            }
            else if(!((Child) this).isSibling((Child) addee))
            {
                friendList.add(addee);
            }
            else
            {
                System.out.println("Cannot add siblings");
            }
        }
        else
        {
            if(addee.age<16 && !((Child)addee).isChild((Adult)this))
            {
                //System.out.println("Children cannot add adults except parents. Only children can be friends of children");
                throw new NotToBeFriendsException();
            }
            else
            {
                friendList.add(addee);
            }
        }
    }

    public boolean isFriend(String conn)
    {
        for (User friend: friendList) {
            if(conn.equalsIgnoreCase(friend.getName()))
            {
                return true;
            }
        }
        return false;
    }

    public void updateprofile(String name,int age,String status)
    {
        this.name=name;
        if(age!=-1)
        this.age=age;
        if(status!=null)
        this.status=status;
    }

}
