package ie.wit.LeahCullen.A1.models
/*
choiceModel manages user data and stores choice objects
 */
data class choiceModel( var id: Long = 0,
                        var hero: String = "",
                        var beast: String = "",
                        var paragon1: String = "",
                        var paragon2: String = "",
                        var mages: String = "",
                        var ruler: String = "",
                        var urn: String = "",
                        var arl: String = "",
                        var archdemon: String = "")