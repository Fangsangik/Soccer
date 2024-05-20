package football.footballplayer.service;


import football.footballplayer.dto.PlayerDto;
import football.footballplayer.member.Player;
import football.footballplayer.repository.PlayerRepository;

import football.footballplayer.type.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PlayerServiceImpl {

    private final PlayerRepository playerRepository;


    public void save(PlayerDto playerDto) {
        Player player = toEntity(playerDto);
        playerRepository.save(player);
    }

    public PlayerDto findById(Long id) {
       Player player = playerRepository.findById(id).orElseThrow(()
                -> new RuntimeException("존재하지 않는 아이디 입니다" + id));

       return PlayerDto.fromEntity(player);
    }

    public PlayerDto findByPosition(Position position){
        Player player = playerRepository.findByPosition(position)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 포지션 입니다."));

        validatePosition(player, position);

        return PlayerDto.fromEntity(player);
    }

    private void validatePosition(Player player, Position position) {
        if (!player.getPosition().equals(position)) {
            throw new RuntimeException("포지션이 일치하지 않습니다.");
        }
    }

    private Player toEntity(PlayerDto playerDto) {
        return Player.builder()
                .name(playerDto.getName())
                .age(playerDto.getAge())
                .position(playerDto.getPosition())
                .createdAt(playerDto.getCreatedAt())
                .deletedAt(playerDto.getDeletedAt())
                .build();
    }
}
