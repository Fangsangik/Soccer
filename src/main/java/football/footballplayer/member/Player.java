package football.footballplayer.member;

import football.footballplayer.type.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {

    private Long id;
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Temporal(TemporalType.DATE)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.DATE)
    private LocalDateTime deletedAt;
}
