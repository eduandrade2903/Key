package Repository;

import Model.TblSector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<TblSector, Integer> {
}
