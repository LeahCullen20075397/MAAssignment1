package ie.wit.LeahCullen.A1.controllers

import ie.wit.LeahCullen.A1.main.playthroughView
import ie.wit.LeahCullen.A1.main.playthroughs
import ie.wit.LeahCullen.A1.models.PlaythroughJSONStore
import ie.wit.LeahCullen.A1.models.playthroughModel
import mu.KotlinLogging

class PlaythroughController {
    val logger = KotlinLogging.logger {  }

    init {
        logger.info { "Launching Dragon Age Companion App" }
        println("DA Kotlin App v1.0")
    }

    fun menu(): Int{return playthroughView.mainMenu()}

    fun add(){
        var playthrough = playthroughModel()
    }

    /*fun delete(){
        var playthrough = playthroughModel()
    }*/
}