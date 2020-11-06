package ie.wit.LeahCullen.A1.models

interface playthroughStore {
    fun findAll(): List<playthroughModel>
    fun findOne(id: Long): playthroughModel?
    fun create(playthrough: playthroughModel)
    fun update(playthrough: playthroughModel)
    fun delete(playthrough: playthroughModel)
}