package annotation;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        insprctService(SimpleService.class);
        insprctService(LazyService.class);
        insprctService(String.class);
    }

    static void insprctService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            Annotation[] ann = service.getAnnotations();
            for (Annotation a : ann) {
                System.out.println(a.toString());
            }
        }
    }
}
