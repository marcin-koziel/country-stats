package ca.marcinkoziel.countrystats.repositories;

import ca.marcinkoziel.countrystats.beans.Post;
import ca.marcinkoziel.countrystats.beans.PostType;
import ca.marcinkoziel.countrystats.beans.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByTags(Tag tag);
    List<Post> findAllByPostType(PostType postType);

}
