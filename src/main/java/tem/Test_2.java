package tem;

import java.util.*;
import java.util.stream.Collectors;

public class Test_2 {
    public static void main(String[] args) {

        List<UserOne> list = new ArrayList<>();
        list.add(new UserOne("A"));
        list.add(new UserOne("B"));
        list.add(new UserOne("B"));
        Collection<UserTwo> userTwos_A = mapCollectionUserOneToCollectionUserTwo(list);
        System.out.println(userTwos_A);
        ArrayList<UserTwo> userTwos_A_1 = new ArrayList<>(userTwos_A);
        System.out.println(userTwos_A_1);
        HashSet<UserTwo> userTwos_A_2 = new HashSet<>(userTwos_A);
        System.out.println(userTwos_A_2);

        Set<UserOne> set = new HashSet<>();
        set.add(new UserOne("A"));
        set.add(new UserOne("B"));
        Collection<UserTwo> userTwos_B = mapCollectionUserOneToCollectionUserTwo(set);
        System.out.println(userTwos_B);
        HashSet<UserTwo> userTwos_B_1 = new HashSet<>(userTwos_B);
        System.out.println(userTwos_B_1);


    }

    public static Collection<UserTwo> mapCollectionUserOneToCollectionUserTwo(Collection<UserOne> collection) {
        Collection<UserTwo> result = null;

        result = collection.parallelStream()
                .map(userOne -> new UserTwo(userOne.getName()))
                .collect(Collectors.toCollection(ArrayList::new));

        return result;
    }
}

class UserOne {
    private String name;

    public UserOne(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOne userone = (UserOne) o;
        return Objects.equals(name, userone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "UserOne{" +
                "name='" + name + '\'' +
                '}';
    }
}

class UserTwo {
    private String name;

    public UserTwo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTwo usertwo = (UserTwo) o;
        return Objects.equals(name, usertwo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "UserTwo{" +
                "name='" + name + '\'' +
                '}';
    }
}
