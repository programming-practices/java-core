package annotation;

@Service(name = "nameL")
public class LazyService {

    @Init
    public void lazyInit() throws Exception {
        System.out.println("lazyInit()");
    }
}
