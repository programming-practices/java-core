package collections;

public interface ExampleRandomAccess {
}

class Main {
    public static void main(String[] args) {
//        if (RandomAccess instanceof ArrayList)System.out.println("ArrayList is RandomAccess");
//        if (new Vector() instanceof RandomAccess)System.out.println("Vector is RandomAccess");

    }
}

/*

Этот интерфейс не содержит н и одного члена. Но, реализуя его, коллекция из­
вещает о том , что она поддерживает эффективный произвольный доступ к своим
элементам. Даже если в коллекции и поддерживается произвольный доступ к ее
элементам, такой доступ может оказаться недостаточно э фф ективным. Проверяя
интер ф ейс RandomAcc e s s во время выполнения, в прикладном коде можно выяс­
н и ть , допускает ли к о нк ре т н ая коллекция некоторые виды оп е р а ций произволь­
н о г о доступа, и , в частности , насколько они применимы к крупным коллекциям.
(Чтобы оп р е д ел ит ь , реализует ли класс коллекции и нтер ф ейс R a n d omAc c e s s ,
можно во с пол ь з о ват ься оператором i n s tan ce o fArgInt . ) Интер ф ейс R a n domA c c e s s ре­
ализуется в классе ArrayL i s t и , сре;щ прочего, в унаследованном кл а с с е Ve c t o r .

*/
