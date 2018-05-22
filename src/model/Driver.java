package model;

import Exceptions.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    ArrayList<User> userList;
    public Driver() throws TooYoungException, NotToBeFriendsException, NoParentException {
        userList=new ArrayList<User>();
        FileHandler fileObj=new FileHandler("people.txt");
        if(fileObj)
        List<String[]> peopleFile=try {
            fileObj.parseCSV();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(MiniNetGUI,);
        }

        /*Adult dad=new Adult("John","Eating","/po/lo",46);
        Adult mom=new Adult("Mona","Drinking","/pla/mop",40);
        Child c1=new Child("Edward","Playing","/pla",15,dad,mom);
        Child c2=new Child("Lily","Flying","/polk",12,dad,mom);
        userList.add(dad);
        userList.add(mom);
        userList.add(c1);
        userList.add(c2);*/
        try {
            dad.addFriend(mom);
            mom.addFriend(dad);
            dad.addFriend(c1);
            dad.addFriend(c2);
            mom.addFriend(c1);
            mom.addFriend(c2);
        }
        catch (TooYoungException e)
        {
            throw e;
        }
        catch (NotToBeFriendsException e)
        {
            throw e;
        }
        try {
            dad.connectChild(c1);
            mom.connectChild(c1);
            dad.connectChild(c2);
            mom.connectChild(c2);
        }
        catch (NoParentException e)
        {
            throw e;
        }
    }
    public void addUser(ArrayList<User> userList, User newUser)
    {
        userList.add(newUser);
    }

    public void deleteUser(ArrayList<User> userList, User newUser)
    {
        userList.remove(newUser);
    }

    public User searchUser(ArrayList<User> userList,String name)
    {
        for (User currUser: userList) {
            if(currUser.getName().equalsIgnoreCase(name))
                return currUser;
        }

        return null;
    }

    public boolean exists(ArrayList<User> userList, User targetUser)
    {
        for(User currUser:userList)
        {
            if(targetUser.equals(currUser))
            {
                return true;
            }
        }

        return false;
    }

    public void removeUser(User targetUser) throws NoParentException {
        for(User currUser:userList)
        {
            if(targetUser.equals(currUser))
            {
                if(currUser instanceof Adult && !((Adult) currUser).hasChild()) {
                    userList.remove(currUser);
                    return;
                }
                else {
                    throw new NoParentException();
                }
            }
        }
    }

    public void run() throws TooYoungException, NotToBeFriendsException, NoParentException {
	// write your code here


        Driver obj=new Driver();
        Scanner scan=new Scanner(System.in);
        do
        {   /*
            System.out.println("MiniNet Menu\n==============================");
            System.out.println("1.List everyone\n2.Select a profile by name\n3.Are these two direct friends\n" +
                    "4.Add a person\n5.Add a child\n6.Update a profile\n7.Connect profiles\n8.Print children or parent names.\n9.Delete user\n10.Exit");*/
            int choice=scan.nextInt();
            switch(choice)
            {
                case 1: for(User currUser:userList)
                        {
                            System.out.println(currUser.getName());
                        }
                    break;
                case 2: System.out.println("Enter the name of the profile to display: ");
                            scan.nextLine();
                        String search= scan.nextLine();
                         for(User currUser:userList)
                         {

                             if(search.equalsIgnoreCase(currUser.getName()))
                              {
                                  currUser.displayDetails();
                              }

                          }
                    break;
                case 3: System.out.println("Enter name of first person: ");
                    scan.nextLine();
                    String person1= scan.nextLine();
                    System.out.println("Enter name of second person: ");
                    String person2= scan.nextLine();
                    for(User currUser:userList)
                    {
                        if(person1.equalsIgnoreCase(currUser.getName()))
                        {
                            if(currUser.isFriend(person2)){
                                System.out.println("These are direct friends");
                            }
                            else
                            {
                                System.out.println("These are not direct friends");
                            }
                        }

                    }
                    break;
                case 4: System.out.println("Enter the name of user: ");
                    scan.nextLine();
                    String name=scan.nextLine();

                    System.out.println("Enter the age of user: ");

                    int age= scan.nextInt();
                    if(age>=0 && age<=150)
                    System.out.println("Enter the status of user: ");
                    scan.nextLine();
                    String status= scan.nextLine();
                    System.out.println("Enter the image location for user: ");
                    String image= scan.nextLine();
                    if(age<16)
                    {
                        Adult p1,p2;
                        do {
                            System.out.println("Enter Parent 1 name:");
                            scan.nextLine();
                            String parent1 = scan.nextLine();

                            p1 = (Adult) obj.searchUser(userList, parent1);

                            System.out.println("Enter Parent 2 name:");
                            scan.nextLine();
                            String parent2 = scan.nextLine();
                            p2 = (Adult) obj.searchUser(userList, parent2);

                            if(p1==null || p2==null)
                                System.out.println("Invalid user name. One or more users do not exist.");
                        }while(p1==null && p2==null);

                        User child=new Child(name,status,image,age,p1,p2);
                        userList.add(child);
                    }
                    else
                    {
                        User adult=new Adult(name,status,image,age);
                        userList.add(adult);
                    }
                    break;
                case 5:System.out.println("Enter Parent Name");
                case 6: System.out.println("Enter the name of the profile to be updated: ");
                    scan.nextLine();
                    String currProfile=scan.nextLine();
                    User currUser=obj.searchUser(userList,currProfile);
                    if(currUser==null) {
                        System.out.println("Invalid user"); break;
                    }
                    System.out.println("Press s to skip if detail is not required to be updated");
                    System.out.println("Enter the age of user: ");
                    String ageInp= scan.nextLine();
                    int age1;
                    if(ageInp.equalsIgnoreCase("s"))
                        age1=-1;
                    else
                        age1= Integer.parseInt(ageInp);
                    System.out.println("Enter the status of user: ");

                    String status1=scan.nextLine();;
                    if(status1.equalsIgnoreCase("s"))
                        status1=null;


                    currUser.updateprofile(currProfile,age1,status1);
                    break;
                case 7:System.out.println("Enter name of first person: ");
                    scan.nextLine();
                    String per1= scan.nextLine();
                    System.out.println("Enter name of second person: ");
                    String per2= scan.nextLine();
                    User p1=obj.searchUser(userList,per1);
                    User p2=obj.searchUser(userList,per2);
                    if(p1!=null && p2!=null) {
                        try {
                            p1.addFriend(p2);
                            p2.addFriend(p1);
                        }
                        catch (TooYoungException e)
                        {
                            throw e;
                        }
                        catch (NotToBeFriendsException e)
                        {
                            throw e;
                        }
                    }
                    else {
                        System.out.println("One or more invalid user names entered");
                    }
                    break;
                case 8:System.out.println("Enter name of person who's family should be printed: ");
                    scan.nextLine();
                    String pe1= scan.nextLine();
                    User fam1=obj.searchUser(userList,pe1);
                    if(fam1!=null) {
                        if (fam1.getAge() < 16 && fam1 instanceof Child) {
                            ((Child) fam1).displayParents();
                        } else
                        {
                            ((Adult) fam1).displayChildren();
                        }
                    }
                    else
                    {
                        System.out.println("Invalid \n");
                    }
                    break;
                case 9:System.out.println("Enter name of person to be deleted ");
                    scan.nextLine();
                    String per= scan.nextLine();
                    User del=obj.searchUser(userList,per);
                    try {
                        removeUser(del);
                        System.out.println("User deleted ");
                    }
                    catch (NoParentException e)
                    {
                        throw e;
                    }


                    break;
                case 10:System.out.println("Exiting the menu"); System.exit(0);
                    break;
                    default:System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }while(true);
    }
}
