package com.practice.practicamovil2.data.repositories

import android.util.Log
import com.practice.practicamovil2.domain.model.APIGameModel

class GameFakeRepository: GameRepository {

    private val games = listOf(
        APIGameModel("GTA V","https://media-rockstargames-com.akamaized.net/tina-uploads/posts/9k922a7212kao3/59a05cd4bc90a814ee52dceb30d70de2c1946953.jpg","Un juego donde tenes que ganarte la vida robando y matando gente"),
        APIGameModel("Resident Evil 4", "https://www.nintenderos.com/wp-content/uploads/2021/06/resident-evil-4.jpg", "Leon S. Kennedy tiene la misión de rescatar a la hija del presidente de los zombies habitando una pequeña isla en españa"),
        APIGameModel("Metro 2033","https://image.api.playstation.com/cdn/UP2047/CUSA00623_00/CDKT8KfSKuoRENogIW12qtoRJCpUPItk.png","Un juego de disparos en primera persona donde necesitas sobrevivir al ataque de los mutantes en rusia"),
        APIGameModel("Valorant", "https://fotos.perfil.com/2021/12/13/trim/1280/720/que-es-el-videojuego-valorant-1283155.jpg","Un juego competitivo en primera persona donde hay que destacar para ganar"),
        APIGameModel("Subnautica", "https://assets.nintendo.com/image/upload/c_fill,w_1200/q_auto:best/f_auto/dpr_2.0/ncom/es_LA/games/switch/s/subnautica-switch/hero","Un juego donde debes sobrevivir las profundidades hostiles de un planeta extraterrestre"),
        APIGameModel("Cyberpunk 2077", "https://cdn1.epicgames.com/offer/77f2b98e2cef40c8a7437518bf420e47/EGS_Cyberpunk2077_CDPROJEKTRED_S1_03_2560x1440-359e77d3cd0a40aebf3bbc130d14c5c7","Basado en un mundo futurista, este juego de acción RPG nos brinda la posibilidad de recorrer la bella ciudad de Night City")
    )

    override suspend fun listGames(): List<APIGameModel> {
        Log.d("GameFakeRepository","Entró al método listGames()")
        return games
    }

}