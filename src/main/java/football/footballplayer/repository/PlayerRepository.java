package football.footballplayer.repository;

import football.footballplayer.member.Player;
import football.footballplayer.type.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByPosition(Position position);
}
