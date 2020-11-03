package ie.wit.LeahCullen.A1.models

interface relationshipStore {
    fun findAll(): List<relationshipModel>
    fun findOne(id: Long): relationshipModel?
    fun create(relationship: relationshipModel)
    fun update(relationship: relationshipModel)
}