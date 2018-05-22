package model;

import java.util.ArrayList;

public class Child extends User {

   private Adult parentID1,parentID2;
    public Child(String name, String status, String image, int age, Adult parent1, Adult parent2)
    {
        this.name=name;
        this.status=status;
        this.image=image;
        this.age=age;
        parentID1 = parent1;
        parentID2 = parent2;
        this.friendList=new ArrayList<User>();
    }

    public void addParents()
    {
        System.out.println("Enter 1st Parent Name: ");
    }
    public Adult getParentID1() {
        return parentID1;
    }

    public Adult getParentID2() {
        return parentID2;
    }

    public void removeParent(Adult parent)
    {
        parentID1 = null;
        parentID2 = null;
    }

    public boolean isSibling(Child sibling)
    {
        if(parentID1.equals(sibling.getParentID1()) && parentID2.equals(sibling.getParentID2()))
            return true;
        return false;
    }

    public boolean isChild(Adult parent1)
    {
        if(parentID1.equals(parent1) || parentID2.equals(parent1))
        {
            return true;
        }

        return false;
    }

    public void displayParents()
    {
        System.out.println("Following are the parents of "+name);
        System.out.println(parentID1.getName());
        System.out.println(parentID2.getName());
    }
}
