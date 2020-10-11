package generics.temporary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Test {
    public static void main(String[] args) {

        A test = new A<Long, Long>(1l, 2l);

        System.out.println(test.getIdUser());
        System.out.println(test.getIdValue());

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class A<IdUser, IdValue> {

    private IdUser idUser;
    private IdValue idValue;

}

