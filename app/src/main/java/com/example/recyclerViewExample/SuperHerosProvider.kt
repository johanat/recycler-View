package com.example.recyclerViewExample

class SuperHerosProvider {
    // companion Object para accceder a lo que esta dentro
    companion object{
        val superHeroList= listOf<SuperHero>(
            SuperHero(
                "kotlinMan",
                "Jetbrains",
                "johana tonguino",
                "https://codigoonclick.com/wp-content/uploads/2017/05/kotlin_para_android_developers.jpg "
            ),
            SuperHero(
                "Capital america",
                "Marvel ",
                "Steve Rogers",
                "https://assets.stickpng.com/images/580b57fbd9996e24bc43c025.png "
            ),
            SuperHero(
                "Iron Man ",
                "Marvel",
                "Tony Stark",
                "https://e1.pngegg.com/pngimages/819/968/png-clipart-iron-man-iron-man.png"
            ),
            SuperHero(
                "Hulk ",
                "Marvel",
                "Bruce Banner",
                "https://www.pngmart.com/files/2/Hulk-PNG-Photo.png "
            ),
            SuperHero(
                "Thor ",
                "Marvel",
                "Christopher Hemsworth",
                "https://w7.pngwing.com/pngs/976/580/png-transparent-iron-man-hulk-captain-america-thor-ultron-ironman-marvel-iron-man-heroes-superhero-fictional-character-thumbnail.png "
            ),
            SuperHero(
                "Capitana Marvel ",
                "Marvel",
                " Carol Danvers.",
                "https://w7.pngwing.com/pngs/976/580/png-transparent-iron-man-hulk-captain-america-thor-ultron-ironman-marvel-iron-man-heroes-superhero-fictional-character-thumbnail.png  "
            )
        )
    }
}