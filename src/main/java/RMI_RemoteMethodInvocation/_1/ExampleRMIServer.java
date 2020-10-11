package RMI_RemoteMethodInvocation._1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

interface IMath extends Remote {
    int add(int a, int b) throws RemoteException;
}

public class ExampleRMIServer {
    public static void main(String[] args) throws NamingException, RemoteException, AlreadyBoundException, MalformedURLException {
        Context context = new InitialContext();
        context.bind("rmi://localhost:1099/imath", new IMathImpl());
//        context.bind("rmi:imath", new IMathImpl());
//        Naming.bind("imath", new IMathImpl());
    }
}

class IMathImpl extends UnicastRemoteObject implements IMath {

    protected IMathImpl() throws RemoteException {
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}

/*
Pered zapyskom servera treba zapustutu rmiregistry v konsoli v papke s otkompelirovanumi classami

I vozmozno nado bydet vstanovit v configuraciones c etomy faily  -Djava.rmi.server.codebase=http://localhost:1099/imath
*/