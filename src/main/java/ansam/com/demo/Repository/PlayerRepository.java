package ansam.com.demo.Repository;

import ansam.com.demo.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer>
{
    boolean existsByPlayerName(String playerName);
    Optional<Player> findByPlayerName(String playerName);
}
