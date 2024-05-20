package football.footballplayer.controller;

import football.footballplayer.dto.PlayerDto;
import football.footballplayer.member.Player;
import football.footballplayer.service.PlayerServiceImpl;
import football.footballplayer.type.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {

    private final PlayerServiceImpl playerService;

    @GetMapping
    public ResponseEntity<PlayerDto> getPlayer(@PathVariable Long id) {
        PlayerDto playerDto = playerService.findById(id);
        return ResponseEntity.ok(playerDto);
    }

    @GetMapping("/playerPosition")
    public ResponseEntity<PlayerDto> getPosition
            (@RequestParam Position position){
        PlayerDto playerDto = playerService.findByPosition(position);
        return ResponseEntity.ok(playerDto);
    }
}
