package com.practice.practicamovil2.data

import com.practice.practicamovil2.data.model.GameModel

class GameFakeRepository: GameRepository {

    private val games = listOf(
        GameModel("GTA V","Un juego donde tenes que ganarte la vida robando y matando gente","https://media-rockstargames-com.akamaized.net/tina-uploads/posts/9k922a7212kao3/59a05cd4bc90a814ee52dceb30d70de2c1946953.jpg"),
        GameModel("Resident Evil 4", "Leon S. Kennedy tiene la misión de rescatar a la hija del presidente de los zombies habitando una pequeña isla en españa", "https://www.nintenderos.com/wp-content/uploads/2021/06/resident-evil-4.jpg"),
        GameModel("Metro 2033","Un juego de disparos en primera persona donde necesitas sobrevivir al ataque de los mutantes en rusia","https://image.api.playstation.com/cdn/UP2047/CUSA00623_00/CDKT8KfSKuoRENogIW12qtoRJCpUPItk.png"),
        GameModel("Valorant","Un juego competitivo en primera persona donde hay que destacar para ganar", "https://fotos.perfil.com/2021/12/13/trim/1280/720/que-es-el-videojuego-valorant-1283155.jpg"),
        GameModel("Subnautica","Un juego donde debes sobrevivir las profundidades hostiles de un planeta extraterrestre", "https://assets.nintendo.com/image/upload/c_fill,w_1200/q_auto:best/f_auto/dpr_2.0/ncom/es_LA/games/switch/s/subnautica-switch/hero"),
        GameModel("Cyberpunk 2077","Basado en un mundo futurista, este juego de acción RPG nos brinda la posibilidad de recorrer la bella ciudad de Night City", "https://cdn1.epicgames.com/offer/77f2b98e2cef40c8a7437518bf420e47/EGS_Cyberpunk2077_CDPROJEKTRED_S1_03_2560x1440-359e77d3cd0a40aebf3bbc130d14c5c7")
    )

    override fun listGames(): List<GameModel> {
        return games
    }

}