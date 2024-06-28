/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * 
 */

// Write your code here

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.player.model.Player;
import com.example.player.repository.PlayerRepository;
import com.example.player.model.PlayerRowMapper;

@Service
public class PlayerH2Service implements PlayerRepository {

    @Autowired
    public JdbcTemplate db;

    @Override
    public ArrayList<Player> getPlayers() {
        List<Player> playerList = db.query("select * from Team", new PlayerRowMapper());
        ArrayList<Player> players = new ArrayList<>(playerList);
        return players;

    }
}