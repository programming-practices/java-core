package _static.staticheskii_vlozenii_class;

public class Main {
    ClassOuter classOuter = new ClassOuter();
    ClassOuter.NoStaticClassInner noStaticClassInner = classOuter.new NoStaticClassInner();
    ClassOuter.StaticheskiiClassInner staticheskiiClassInner = new ClassOuter.StaticheskiiClassInner();
}
