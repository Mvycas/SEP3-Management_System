package group3.repository;
import group3.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
IShiftRepository extends JpaRepository<Shift, Long> {
}
