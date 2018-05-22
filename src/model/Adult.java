package model;

import Exceptions.NoAvailableException;
import Exceptions.NoParentException;

import java.util.ArrayList;

public class Adult extends User {

    private ArrayList<Child> childID;
    private Adult partnerID;
    public Adult(String name, String status, String image, int age)
    {
        this.name=name;
        this.status=status;
        this.image=image;
        this.age=age;
        this.friendList=new ArrayList<User>();
        childID=new ArrayList<Child>();
        partnerID=null;
    }

    public void addPartner(Adult partner) throws NoAvailableException {
        if(this.hasPartner())
            throw new NoAvailableException();
        else
        {
            partnerID=partner;

        }
    }

    public boolean hasPartner()
    {
        if(partnerID==null)
            return false;
        return true;
    }
    public void connectChild(Child child) throws NoParentException {
        if(this.hasPartner()) {
            childID.add(child);
            partnerID.childID.add(child);
        }
        else
            throw new NoParentException();
    }

    public void displayChildren()
    {
        System.out.println("Following are the children of "+name);
        for (Child child: childID) {
            System.out.println(child.getName());
        }
    }

    public boolean hasChild()
    {
        if(childID.isEmpty())
            return false;
        return true;
    }

}
