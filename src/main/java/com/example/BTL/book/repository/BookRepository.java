package com.example.BTL.book.repository;

import com.example.BTL.book.dto.OderResponse;
import com.example.BTL.book.dto.OderResponseBookvsBorrowBookUser;
import com.example.BTL.book.dto.OderResponseBookvsCommentBook;
import com.example.BTL.book.dto.OderResponseBookvsUserBook;
import com.example.BTL.book.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    @Override
    List<Books> findAll();

    @Override
    <S extends Books> S save(S entity);

    @Override
    Optional<Books> findById(Integer integer);

    @Query("SELECT new com.example.BTL.book.dto.OderResponse(c.title , p.avatar) FROM Books c JOIN c.avatars p")
    public List<OderResponse> getJoinBookAvatar();

    @Query("SELECT new com.example.BTL.book.dto.OderResponseBookvsUserBook(c.title , p.star) FROM Books c JOIN c.userBooks p")
    public List<OderResponseBookvsUserBook> getJoinBookUserBook();

    @Query("SELECT new com.example.BTL.book.dto.OderResponseBookvsBorrowBookUser(c.title, p.quantity, p.status) FROM Books c JOIN c.borrowBookUsers p")
    public List<OderResponseBookvsBorrowBookUser> getJoinBookBorrowBookUser();

    @Query("SELECT new com.example.BTL.book.dto.OderResponseBookvsCommentBook(c.title, p.comment) FROM Books c JOIN c.commentBooks p")
    public List<OderResponseBookvsCommentBook> getJoinBookBookCommentBook();
}
