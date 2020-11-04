package ie.wit.LeahCullen.A1.controllers

import ie.wit.LeahCullen.A1.main.playthroughView
import mu.KotlinLogging

class PlaythroughController {
    val logger = KotlinLogging.logger {  }

    init {
        logger.info { "Launching Dragon Age Companion App" }
        println("DA Kotlin App v1.0")
    }

    fun menu(): Int{return playthroughView.mainMenu()}
}