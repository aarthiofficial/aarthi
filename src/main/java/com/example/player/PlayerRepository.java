// Write your code here
package com.example.player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {
    List<Player> findAllPlayers();

    Optional<Player> findPlayerById(int playerId);

    Player savePlayer(Player player);

    Player updatePlayer(int playerId, Player player);

    void deletePlayer(int playerId);
}
