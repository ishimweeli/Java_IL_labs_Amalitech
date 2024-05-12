package Repository;

import com.amalitech.springboottodoapp.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
