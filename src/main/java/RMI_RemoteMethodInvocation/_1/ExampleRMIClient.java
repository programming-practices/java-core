package RMI_RemoteMethodInvocation._1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;

public class ExampleRMIClient {
    public static void main(String[] args) throws NamingException, RemoteException {
        Context context = new InitialContext();

        Enumeration<NameClassPair> enumeration = context.list("rmi://localhost/");
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement().getName());
        }

        IMath iMath = (IMath) context.lookup("rmi://localhost/imath");
        int result = iMath.add(7, 3);
        System.out.println(result);
    }
}
