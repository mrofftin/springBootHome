package co.mr.demo_01_17.repository;

import co.mr.demo_01_17.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
