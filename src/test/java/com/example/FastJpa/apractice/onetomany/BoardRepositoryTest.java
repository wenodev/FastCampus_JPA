package com.example.FastJpa.apractice.onetomany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Transactional
@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    private Board newBoard;

    @BeforeEach
    void test_save(){
        List<Comment> comments = new ArrayList<>();
        comments.add(Comment.builder()
                .content("comment_content_1")
                .build());
        comments.add(Comment.builder()
                .content("comment_content_2")
                .build());

        newBoard = boardRepository.save(
                Board.builder()
                        .title("board_title")
                        .content("board_content")
                        .comments(comments)
                        .build());
    }

    @Test
    void test_update_comment(){
        newBoard.getComments().get(0).setContent("update_comment_content");
        boardRepository.save(newBoard);

        assertThat(newBoard.getComments().get(0).getContent()).isEqualTo("update_comment_content");
    }

    @Test
    void test_add_comment(){
        Comment comment = commentRepository.save(Comment.builder()
                .content("add_comment_content")
                .build());

        newBoard.getComments().add(comment);
    }

    @Test
    void test_select_comment(){
        List<Comment> comments = boardRepository.findById(1L).orElseThrow(RuntimeException::new).getComments();
        assertThat(comments.size()).isEqualTo(2);
    }

    @Test
    void test_print(){
        boardRepository.findAll().forEach(System.out::println);
    }

}

