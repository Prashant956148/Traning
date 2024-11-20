package com.zs.service;

import java.util.List;

import com.zs.entity.Player;

public interface PlayerService {
 void save(Player p);
List<Player> list();
Player fetch(int jno);
 List<Player> updateById(int id);
}
