package server;
import userManagement.UserMgmtI;

public class Server extends Ice.Application{
	public int run(String[] args) {
		if(args.length > 0)
        {
			System.err.println(appName() + ": too many arguments");
            return 1;
        }

		Ice.ObjectAdapter adapter = Ice.Application.communicator().createObjectAdapter("UserManagement");
		adapter.add(new UserMgmtI(), Ice.Util.stringToIdentity("UserManagement"));
		adapter.activate();
		Ice.Application.communicator().waitForShutdown();
		return 0;
	}
	
	public static void main(String[] args)
    {
        Server app = new Server();
        int status = app.main("Server", args, "conf/config.server");
        System.exit(status);
    }
}
