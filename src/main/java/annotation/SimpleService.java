package annotation;


@Service(name = "nameS")
public class SimpleService {

    @Init
    public void initService() {
        System.out.println("initService()");
    }

    public void methodSinAnotation() {
        System.out.println("methodSinAnotation()");
    }
}
