# CREATE PROCEDURE BookCout(OUT cnt INT)
#   BEGIN
#     SELECT count(*) INTO cnt FROM Books;
#   END;


# CREATE PROCEDURE getBooks (bookId INT)
#   BEGIN
#     SELECT * FROM Books WHERE id = bookId;
#   END;


# CALL BooksCount(@out);
# SELECT @out



# CALL getBooks(1);



# CALL getCount();
# SELECT @users;
# SELECT @books;