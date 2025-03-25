package Repository;

import Model.TblSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SectorRepository extends JpaRepository<TblSector, Integer> {
}
