// src/main/java/com/example/player/PlayerController.java

package com.example.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.findAllPlayers();
    }

    @PostMapping("/players")
    public ResponseEntity<Void> createNew(@RequestBody Player newPlayer) {
        playerService.savePlayer(newPlayer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getByID(@PathVariable("id") int id) {
        return new ResponseEntity<>(playerService.findPlayerById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<Void> updateByID(@PathVariable("id") int id, @RequestBody Player updated) {
        playerService.updatePlayer(id, updated);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable("id") int id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}