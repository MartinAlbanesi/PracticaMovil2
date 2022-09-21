package com.practice.practicamovil2.data

import com.practice.practicamovil2.data.model.GameModel

class GameFakeRepository: GameRepository {

    private val games = listOf(
        GameModel("GTA V","Un juego donde tenes que ganarte la vida robando y matando gente","https://media-rockstargames-com.akamaized.net/tina-uploads/posts/9k922a7212kao3/59a05cd4bc90a814ee52dceb30d70de2c1946953.jpg"),
        GameModel("Resident Evil 4", "Leon S. Kennedy tiene la misión de rescatar a la hija del presidente de los zombies habitando una pequeña isla en españa", "https://www.nintenderos.com/wp-content/uploads/2021/06/resident-evil-4.jpg"),
        GameModel("Metro 2033","Un juego de disparos en primera persona donde necesitas sobrevivir al ataque de los mutantes en rusia","https://image.api.playstation.com/cdn/UP2047/CUSA00623_00/CDKT8KfSKuoRENogIW12qtoRJCpUPItk.png")
    )

    override fun listGames(): List<GameModel> {
        return games
    }

}