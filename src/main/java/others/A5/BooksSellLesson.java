package others.A5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BooksSellLesson {
    int price = 10;

    public static void main(String[] args) {
        List<Books> booksList = new ArrayList<>();
        booksList.add(Books.ONE);
        booksList.add(Books.TWO);
        booksList.add(Books.THREE);
        booksList.add(Books.FOUR);//34
        booksList.add(Books.ONE);
        booksList.add(Books.TWO);//19
        System.out.println(getPrice(booksList));//53
    }

    static int getPrice(List<Books> books) {
        List<Set<Books>> booksList = new ArrayList<>();
        Set<Books> booksSet = new HashSet<>();
        while (books.size() != 0) {
            for (int i = 0; i < books.size(); ) {
                int size = booksSet.size();
                booksSet.add(books.get(i));
                if (booksSet.size() > size) {
                    books.remove(i);
                } else {
                    i++;
                }
            }
            booksList.add(booksSet);
            booksSet = new HashSet<>();
        }
        int price = 0;
        for (Set<Books> set : booksList) {
            switch (set.size()) {
                case 5:
                    price += 40;
                    break;
                case 4:
                    price += 34;
                    break;
                case 3:
                    price += 27;
                    break;
                case 2:
                    price += 19;
                    break;
                case 1:
                    price += 10;
                    break;
            }
        }
        return price;
    }

    // 5% 10% 15% 20%
    enum Books {ONE, TWO, THREE, FOUR, FIVE}
}
