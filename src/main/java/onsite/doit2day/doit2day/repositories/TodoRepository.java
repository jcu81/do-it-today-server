package onsite.doit2day.doit2day.repositories;

import onsite.doit2day.doit2day.data.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    public List<Todo> findAllByCompleted(Boolean completed);

}
