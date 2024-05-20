package football.footballplayer.dto;

import football.footballplayer.member.Player;
import football.footballplayer.type.Position;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class PlayerDto {

    private String name;
    private int age;
    private Position position;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;


    public static PlayerDto fromEntity(Player player){
        return PlayerDto.builder()
                .name(player.getName())
                .age(player.getAge())
                .position(player.getPosition())
                .createdAt(player.getCreatedAt())
                .deletedAt(player.getDeletedAt())
                .build();
    }
}
