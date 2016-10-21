package userManagement;

import Ice.Current;
import UserMgmt.LoginResult;
import UserMgmt.LoginResultHolder;
import UserMgmt.UserInfo;
import UserMgmt.ValidationResult;
import UserMgmt._UserManagementDisp;

public class UserMgmtI extends _UserManagementDisp{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1683169645886062894L;

	@Override
	public void Login(UserInfo user, LoginResultHolder result, Current __current) {
		// TODO Auto-generated method stub
		System.out.println("User:{" + user.userName + ", "+ user.UserPassord+ "}");

		result.value = new LoginResult();
		result.value.sessionToken = 888;
		result.value.validationResult = ValidationResult.Welcome;
	}
	
	public void shutdown(Ice.Current current) {
        System.out.println("Shutting down...");
        current.adapter.getCommunicator().shutdown();
    }
}
