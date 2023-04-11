package myFirstApp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.net.ContentHandler;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    Optional<Task> findById(Integer i);
    Task save(Task entity);

    List<Task> findByDone(@Param("state")boolean done);
    Page<Task> findAll(Pageable page);

    boolean existsById(Integer id);


}
