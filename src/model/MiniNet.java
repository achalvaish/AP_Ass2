package model;

import Exceptions.NoParentException;
import Exceptions.NotToBeFriendsException;
import Exceptions.TooYoungException;

public class MiniNet {
    public static  void main(String args[])
    {
        Driver obj;
        
		try {
			obj = new Driver();
	        obj.run();
		} catch (TooYoungException | NotToBeFriendsException | NoParentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}
